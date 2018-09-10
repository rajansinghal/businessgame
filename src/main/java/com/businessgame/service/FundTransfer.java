package com.businessgame.service;

import com.businessgame.model.Party;

public class FundTransfer implements FinancialServiceInterface {


   /* public void transferFunds(Party sourceParty, Party targetParty, int amountToBeTransferred){
        int actuallAmountAvaliable = sourceParty.getBalance();
        if(amountToBeTransferred != 0 && actuallAmountAvaliable >= amountToBeTransferred){
            int amountAfterCredit =  actuallAmountAvaliable - amountToBeTransferred;
            sourceParty.setBalance(amountAfterCredit);

            int amountAfterDebit = targetParty.getBalance() + amountToBeTransferred;
            targetParty.setBalance(amountAfterDebit);
        }


    }*/
}
