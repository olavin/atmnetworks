package com.softserve;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by Olavin on 20.10.2014.
 */
public class UbanksComUaBanksListCreator implements IBanksListCreator {
    private String networkUrl;

    UbanksComUaBanksListCreator(String networkUrl){
        this.networkUrl = networkUrl;
    }

    public List<BankEntry> createBanksList(){
        List<BankEntry> banksList = new ArrayList<BankEntry>();
        String bankName;
        String bankUrl;
        try {
            Document doc = Jsoup.connect(networkUrl).get();
            //int i = 0;
            Elements banks = doc.select("#zmist li");
            for (Element element : banks) {
                if(element.children().isEmpty()){
                    bankName = element.text();
                    // no site URL for this Bank :(
                    // trying to search at Google
                    bankUrl = GoogleSearch.find(bankName); //trying to search at Google
                } else {
                    // lookup for Bank's site URL on separate page
                    bankUrl = searchBankSite(element.child(0).attr("href"));
                    bankName = element.child(0).text();
                }
                //System.out.printf("{%d} ",i++);
                //System.out.println(bankName+";"+bankUrl);
                banksList.add(new BankEntry(bankName, bankUrl));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return banksList;
    }

    private String searchBankSite(String pageUrl) throws IOException {
        String bankAddr = null;
        URL baseUrl = new URL(networkUrl);
        URL url = new URL(baseUrl,pageUrl);
        Document doc = Jsoup.connect(url.toString()).get();
        Elements elements = doc.select("div.url>span.value-title"); // '>' means "sub" select
        bankAddr = elements.get(0).child(0).attr("href");
        return bankAddr;
    }

}
