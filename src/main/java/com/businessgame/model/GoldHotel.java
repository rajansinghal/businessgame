package com.businessgame.model;

import java.util.List;
import java.util.Map;

public class GoldHotel extends Hotel {
    public GoldHotel(int index) {
        super(index, 300, 150);
    }

    @Override
    public void performCellLogic(Player player, Map<Integer,Cell> mapOfCells, Bank bank) {
        List<Hotel> hotels = player.getAssets();
        if(this.getOwnedBy() != null){

            if (this.getOwnedBy().getId() == player.getId()) {
                hotels.remove(this);
                Hotel upgradedHotel = new PlatinumHotel(player.getCurrentPosition());
                upgradedHotel.setOwnedBy(player);
                hotels.add(upgradedHotel);
                mapOfCells.put(player.getCurrentPosition(),upgradedHotel);
                player.setBalance(player.getBalance() - (upgradedHotel.getBuyValue() - this.getBuyValue()));
                bank.setBalance(bank.getBalance() + (upgradedHotel.getBuyValue() - this.getBuyValue()));
            } else if(this.getOwnedBy().getId() != player.getId()){
                player.setBalance(player.getBalance() - this.getRentValue());
                this.getOwnedBy().setBalance(this.getOwnedBy().getBalance() + this.getRentValue());
            }

        }
        player.setAssets(hotels);
    }
}
