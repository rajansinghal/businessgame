package com.businessgame.model;

import java.util.Map;

public class Empty extends Cell {


    public Empty(int index) {
        super(index);
    }

    @Override
    public void performCellLogic(Player player, Map<Integer,Cell> mapOfCells, Bank bank) {
        // do nothing
    }
}
