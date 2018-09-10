package com.businessgame.model;

import java.util.*;

public class BusinessGameBoard {

    private Map<Integer, Cell> mapOfCells = new HashMap<>();
    private Set<Party> players = new HashSet<>();
    private Bank bank ;

    public BusinessGameBoard() {
        this.bank = Bank.initializeBankWithCapital();
    }


    public Map<Integer, Cell> getMapOfCells() {
        return mapOfCells;
    }

    public void setMapOfCells(Map<Integer, Cell> mapOfCells) {
        this.mapOfCells = mapOfCells;
    }

    public Set<Party> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Party> players) {
        this.players = players;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }


    public void setUpGameBoard(Set<Party> playerList, String inputCells){
        try{
            if(playerList.size() >= 2) {
               this.setPlayers(playerList);
            }else {
                throw new RuntimeException("Mininum two players are requiried");
            }

            String[] cells = inputCells.split(",");
            int cellIndex = 1;
            for(String cell : cells){
                switch(cell)
                {
                    case "J":
                        mapOfCells.put(cellIndex, new Jail(cellIndex));
                        break;
                    case "H":
                        mapOfCells.put(cellIndex, new SilverHotel(cellIndex));
                        break;
                    case "L":
                        mapOfCells.put(cellIndex, new Lottery(cellIndex));
                        break;
                    default:
                        mapOfCells.put(cellIndex, new Empty(cellIndex));
                }
                cellIndex++;
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }


    }

    public int getNoOfPlayersInGame(){
        return  this.getPlayers().size();
    }

    public Party getPlayerById(int id){
        Set<Party> players = this.getPlayers();
        for(Party player : players){
            if(((Player)player).getId() == id)
                return player;
        }
        return null;
    }


}
