package com.softserve;

import java.util.List;
import java.util.ArrayList;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * Created by Ivanna Terletska on 22.10.2014.
 */

public class AtmosferaBanksListCreator implements IBanksListCreator {
    private String networkUrl;


    AtmosferaBanksListCreator(String networkUrl) {
        this.networkUrl = networkUrl;
    }

    public List<BankEntry> createBanksList() {
        
        List<BankEntry> atmosferaBanks = new ArrayList<BankEntry>();
        
        try {
            Document doc = Jsoup.connect(networkUrl).get();
            Elements names = doc.select("td.tab_line_mini");  // Array of names of banks
            
            for (Element name : names) { 
            	Element  tmp = name.nextElementSibling();
            	String   bankName = name.text();
            	String   bankUrl = tmp.child(0).attr("href");
              //  System.out.println(bankName);
              //  System.out.println(url);
                atmosferaBanks.add(new BankEntry(bankName,bankUrl));    //Add elements to list
                tmp = tmp.nextElementSibling();
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        return atmosferaBanks; // List!
    }
}
