package com.businessgame.model;

import java.util.Map;

public abstract class Cell {

    private int index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Cell() {}
    public Cell(int index) {
        this.index = index;
    }

    public abstract  void performCellLogic(Player player, Map<Integer,Cell> mapOfCells, Bank bank);

}
