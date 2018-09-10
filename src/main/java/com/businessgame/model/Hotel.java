package com.businessgame.model;

public abstract class Hotel extends Cell {

    private int buyValue ;
    private int rentValue;
    private Player ownedBy;

    public Hotel(int index, int buyValue, int rentValue) {
        super(index);
        this.buyValue = buyValue;
        this.rentValue = rentValue;
    }

    public int getBuyValue() {
        return buyValue;
    }

    public void setBuyValue(int buyValue) {
        this.buyValue = buyValue;
    }

    public int getRentValue() {
        return rentValue;
    }

    public void setRentValue(int rentValue) {
        this.rentValue = rentValue;
    }

    public Player getOwnedBy() {
        return ownedBy;
    }

    public void setOwnedBy(Player ownedBy) {
        this.ownedBy = ownedBy;
    }

}
