package com.businessgame.model;

import java.util.Map;

import static com.businessgame.constant.BusinessConstant.JAIL_FINE;
import static com.businessgame.constant.BusinessConstant.LOTTERY_VALUE;

public class Lottery extends Cell {
    public Lottery(int index) {
        super(index);
    }

    @Override
    public void performCellLogic(Player player, Map<Integer,Cell> mapOfCells, Bank bank) {
        player.setBalance(player.getBalance() + LOTTERY_VALUE);
        bank.setBalance(bank.getBalance() - LOTTERY_VALUE);
    }
}
