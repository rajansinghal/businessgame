package com.cvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxAllocations {

    public static void main(String[] args) {
        String inputString = "1A,2B,1C,1D,1H,2F";
        String[] inputArray= inputString.split(",");
        Map<String,List<String>> rowwiseSeatAllocationMap = new HashMap<>();
        for(String seatLocation: inputArray){
            String row = seatLocation.substring(0,1);
            String column= seatLocation.substring(1);
            if(null != rowwiseSeatAllocationMap.get(row)){
                List<String> seats = rowwiseSeatAllocationMap.get(row);
                seats.add(column);
                rowwiseSeatAllocationMap.put(row,seats);
            }else{
                List<String> seats = new ArrayList<>();
                seats.add(column);
                rowwiseSeatAllocationMap.put(row,seats);
            }

        }

        int N=3;
        int maxSeatAllocationCount= 0;
        for(int i = 1 ; i <= N ; i++){
            if( null != rowwiseSeatAllocationMap.get(String.valueOf(i))){

                List<String> ls = rowwiseSeatAllocationMap.get(String.valueOf(i));

                boolean isPossibleInGroup1=true;
                boolean gp21Flag=false;
                boolean isPossibleInGroup2=true;
                boolean isPossibleInGroup3=true;

                for(String se : ls ){
                    if(isPossibleInGroup1 && isPresentInGroup1(se)){
                        isPossibleInGroup1 = false;
                    }else if (isPossibleInGroup2 && (isPresentInGroup21(se) || isPresentInGroup22(se))){
                       if(isPresentInGroup22(se)){
                           isPossibleInGroup2 = false;
                       }else if( isPresentInGroup21(se)){
                            if(!gp21Flag)
                                gp21Flag = true;
                            else
                                isPossibleInGroup2 = false;
                        }

                    }else if(isPossibleInGroup3 && isPresentInGroup3(se)){
                        isPossibleInGroup3 = false ;
                    }
                }

                maxSeatAllocationCount = maxSeatAllocationCount + allocationCountInTheRow(isPossibleInGroup1, isPossibleInGroup2, isPossibleInGroup3);

            }else{
                maxSeatAllocationCount = maxSeatAllocationCount + 3;
            }

        }
        System.out.println(maxSeatAllocationCount);
    }

    public static boolean isPresentInGroup1(String s){
        List<String> s1= new ArrayList<>();
        s1.add("A");
        s1.add("B");
        s1.add("C");

       return s1.contains(s);
    }
    public static boolean isPresentInGroup3(String s){
        List<String> s1= new ArrayList<>();
        s1.add("H");
        s1.add("I");
        s1.add("J");

        return s1.contains(s);
    }
    public static boolean isPresentInGroup22(String s){
        List<String> s1= new ArrayList<>();
        s1.add("E");
        s1.add("F");
        return s1.contains(s);
    }
    public static boolean isPresentInGroup21(String s){
        List<String> s1= new ArrayList<>();
        s1.add("D");
        s1.add("G");
        return s1.contains(s);
    }

    public static int allocationCountInTheRow(boolean isPossibleInGroup1, boolean isPossibleInGroup2,boolean isPossibleInGroup3){
        int allocationCountForTheRow=0;
        if(isPossibleInGroup1){
            allocationCountForTheRow = allocationCountForTheRow+1;
        }
        if(isPossibleInGroup2){
            allocationCountForTheRow = allocationCountForTheRow +1 ;
        }
        if(isPossibleInGroup3){
            allocationCountForTheRow = allocationCountForTheRow + 1;
        }
        return allocationCountForTheRow;
    }
}
