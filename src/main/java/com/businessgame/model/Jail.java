package com.businessgame.model;

import java.util.Map;

import static com.businessgame.constant.BusinessConstant.JAIL_FINE;

public class Jail extends Cell{

    public Jail(int index) {
        super(index);
    }

    @Override
    public void performCellLogic(Player player, Map<Integer,Cell> mapOfCells, Bank bank) {
        bank.setBalance(bank.getBalance() + JAIL_FINE);
        player.setBalance(player.getBalance() - JAIL_FINE);
    }


}
