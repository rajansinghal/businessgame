package com.businessgame.main;

import com.businessgame.model.*;
import com.businessgame.rule.BusinessGameRule;

import java.util.*;

public class BusinessGameMain {
    public static void main(String arr[]){

        Player player1 = Player.setUpPlayerWithIdAndCapital(1);
        Player player2 = Player.setUpPlayerWithIdAndCapital(2);
        Player player3 = Player.setUpPlayerWithIdAndCapital(3);

        Set<Party> players = new HashSet<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);

        String inputCells = "J,H,L,H,E,L,H,L,H,J";


        BusinessGameBoard businessGameBoard = new BusinessGameBoard();
        businessGameBoard.setUpGameBoard(players,inputCells);

        String diceThrows = "2,2,1,4,2,3,4,1,3,2,2,7,4,7,2,4,4,2,2,2,2";

        String[] diceThrow = diceThrows.split(",");
        int playerCount = 1;
        BusinessGameRule businessGameRule = new BusinessGameRule(businessGameBoard);
        for(String dice : diceThrow){
            if(playerCount > 3) {
                playerCount = 1;
            }

            int diceMove = Integer.parseInt(dice);
            if(playerCount == 1){
                businessGameRule.applyRule(diceMove,player1);
            }else if(playerCount ==2 ){
                businessGameRule.applyRule(diceMove,player2);
            }else if (playerCount == 3){
                businessGameRule.applyRule(diceMove,player3);
            }

            playerCount++;
        }

    }

}
