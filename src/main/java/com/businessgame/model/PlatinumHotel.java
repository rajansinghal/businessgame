package com.businessgame.model;

import java.util.List;
import java.util.Map;

public class PlatinumHotel extends Hotel {

    public PlatinumHotel(int index){
        super(index, 500, 300);
    }

    @Override
    public void performCellLogic(Player player, Map<Integer,Cell> mapOfCells, Bank bank) {
        if(this.getOwnedBy() != null){

            if(this.getOwnedBy().getId() != player.getId()){
                player.setBalance(player.getBalance() - this.getRentValue());
                this.getOwnedBy().setBalance(this.getOwnedBy().getBalance() + this.getRentValue());
            }

        }
    }
}
