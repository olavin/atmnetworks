package com.softserve;

import java.util.List;

/**
 * Created by Olavin on 20.10.2014.
 */
public class EuronetBanksListCreator implements IBanksListCreator {
    private String networkUrl;

    EuronetBanksListCreator(String networkUrl){
        this.networkUrl = networkUrl;
    }

    public List<BankEntry> createBanksList(){
        // TODO: write method
        return null; // List!
    }

}
