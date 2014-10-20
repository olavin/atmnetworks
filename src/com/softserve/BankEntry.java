package com.softserve;

import java.net.MalformedURLException;
import java.net.URL;
/**
 * Created by Olavin on 20.10.2014.
 */
public class BankEntry {
    private String bankName;
    private String bankUrl = null;

    BankEntry(String name){
        bankName = name;
    }

    BankEntry(String name, String strUrl) {
        bankName = name;
        bankUrl = strUrl;
    }

    public String getBankName(){
        return bankName;
    }

    public String getBankURL(){
        return bankUrl;
    }

}
