package com.softserve;

import java.util.List;

/**
 * Created by Olavin on 20.10.2014.
 */
public class AtmNetwork {
    private String name;
    private List<BankEntry> banksList = null;
    private IBanksListCreator  banksListCreator = null;

    AtmNetwork(String name, IBanksListCreator creator){
        this.name = name;
        banksListCreator = creator;
    }

    public void createBanksList(){
        banksList = banksListCreator.createBanksList();
    }


    public String getName(){
        return name;
    }

    public List<BankEntry> getBanks(){
        return banksList;
    }

}
