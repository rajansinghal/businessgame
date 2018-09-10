package com.businessgame.model;

import java.util.List;
import java.util.Map;

public class SilverHotel extends Hotel {
    public SilverHotel(int index) {
        super(index, 200, 50);
    }

    @Override
    public void performCellLogic(Player player,Map<Integer,Cell> mapOfCells,Bank bank) {
        List<Hotel> hotels = player.getAssets();
        if(this.getOwnedBy() != null){

            if (this.getOwnedBy().getId() == player.getId()) {
                hotels.remove(this);
                Hotel upgradedHotel = new GoldHotel(player.getCurrentPosition());
                upgradedHotel.setOwnedBy(player);
                hotels.add(upgradedHotel);
                mapOfCells.put(player.getCurrentPosition(),upgradedHotel);
                player.setBalance(player.getBalance() - (upgradedHotel.getBuyValue() - this.getBuyValue()));
                bank.setBalance(bank.getBalance() + (upgradedHotel.getBuyValue() - this.getBuyValue()));
            } else if(this.getOwnedBy().getId() != player.getId()){
                player.setBalance(player.getBalance() - this.getRentValue());
                this.getOwnedBy().setBalance(this.getOwnedBy().getBalance() + this.getRentValue());
            }

        }else {
            player.setBalance(player.getBalance() - this.getBuyValue());
            bank.setBalance(bank.getBalance() + this.getBuyValue());
            hotels.add(this);
            this.setOwnedBy(player);


        }
        player.setAssets(hotels);
    }
}
