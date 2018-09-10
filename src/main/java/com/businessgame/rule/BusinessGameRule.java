package com.businessgame.rule;

import com.businessgame.model.*;
import com.businessgame.service.FinancialServiceInterface;
import com.businessgame.service.FundTransfer;

import java.util.Map;

import static com.businessgame.constant.BusinessConstant.*;

public class BusinessGameRule {

    //FinancialServiceInterface financialService = new FundTransfer();
    BusinessGameBoard businessGameBoard ;
    Bank bank ;

    public  BusinessGameRule(BusinessGameBoard businessGameBoard){
        this.businessGameBoard = businessGameBoard;
        this.bank= Bank.initializeBankWithCapital();
    }

    public void applyRule(int diceMove, Player player){

        int newPosition = player.getCurrentPosition() + diceMove;

        Map<Integer,Cell> mapOfCells= businessGameBoard.getMapOfCells();
        if(newPosition > mapOfCells.size()){
            newPosition = newPosition - mapOfCells.size();
        }
            player.setCurrentPosition(newPosition);

        Cell cell = mapOfCells.get(newPosition);

        cell.performCellLogic(player, mapOfCells,bank);
        businessGameBoard.setMapOfCells(mapOfCells);
        businessGameBoard.setBank(bank);

    }

}
