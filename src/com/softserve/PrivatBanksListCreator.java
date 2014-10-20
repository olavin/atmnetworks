package com.softserve;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Olavin on 20.10.2014.
 */
public class PrivatBanksListCreator implements IBanksListCreator {
    private String networkUrl;

    PrivatBanksListCreator(String networkUrl){
        this.networkUrl = networkUrl;
    }

    public List<BankEntry> createBanksList(){
        List<BankEntry> privatBank = new ArrayList<BankEntry>(1);
        privatBank.add(new BankEntry("ПриватБанк",networkUrl)); // only for PrivatBank networkUrl == bankUrl
        return privatBank;
    }

}
