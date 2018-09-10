package com.businessgame.model;

import java.util.*;

import static com.businessgame.constant.BusinessConstant.PLAYER_INITIAL_CAPITAL;

public class Player extends  Party{

    private int balance;
    private int id;
    private int currentPosition;
    private List<Hotel> assets = new ArrayList<>();

    public Player(int id, int balance) {
        this.balance = balance;
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public List<Hotel> getAssets() {
        return assets;
    }

    public void setAssets(List<Hotel> assets) {
        this.assets = assets;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public static Player setUpPlayerWithIdAndCapital(int playerId){
        return new Player(playerId ,  PLAYER_INITIAL_CAPITAL);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return getId() == player.getId();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }
}
