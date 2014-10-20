package com.softserve;

import java.util.List;

/**
 * Created by Olavin on 20.10.2014.
 */
public class AtmNetwork {
    private String name;
    private List<BankEntry> banksList = null;

    AtmNetwork(String name, IBanksListCreator creator){
        this.name = name;
        banksList = creator.createBanksList();
    }

    public String getName(){
        return name;
    }

    public List<BankEntry> getBanks(){
        return banksList;
    }

}
