package com.softserve;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * Created by Olavin on 20.10.2014.
 */
public class AtmosferaBanksListCreator implements IBanksListCreator {
    private String networkUrl;
    

    AtmosferaBanksListCreator(String networkUrl){
        this.networkUrl = networkUrl;
    }

    public List<BankEntry> createBanksList(){
        // TODO: write method
        List<BankEntry> atmosferaBanks = new ArrayList<BankEntry>;
        try {
        Document doc = Jsoup.connect(networkUrl).get();
        Elements names = doc.select("td.tab_line_mini");
        Elements links = doc.select("a[href]");
        
        for (Element name : names) {
         for (Element name : names) {      
        atmosferaBanks.add(new BankEntry(name.text(), name.attr("href")));
        } catch (IOException e) {
        e.printStackTrace();
        }
        }
    

        return null; // List!
    }

}
