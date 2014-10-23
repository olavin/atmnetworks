package com.softserve;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by d18-antoshkiv on 23.10.2014.
 */
public class GoogleSearch {

    /** Attention! Google limit number of searches per day to 100 (probably)
        if you overcome it, you receive message: "Unusual traffic from your computer network"
        and have to recognize Captcha
    */
    public static String find(String request) {
        final String google = "http://www.google.com/search?q=";
        final String userAgent = "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:33.0) Gecko/20100101 Firefox/33.0";

        String requestUrl = null;
        try {
            requestUrl = google + URLEncoder.encode(request, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            //Bad request
            return ""; // URL not found
        }
        //System.out.println(requestUrl);

        Document doc = null;
        try {
            doc = Jsoup.connect(requestUrl).userAgent(userAgent).get();
            Thread.sleep(100); // don't disturb Google too often
        } catch (IOException e) {
            return ""; // URL not found
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        Elements links = doc.select("h3.r");

        //System.out.println("Found: "+links.size());
        //Element link = links.get(0);
        //String title = link.text();
        //System.out.println(link.html());
        //System.out.println("Tag:"+link.tagName());
        String url = links.get(0).child(0).absUrl("href");

//        System.out.println("Title: " + title);
//        System.out.println("URL: " + url);

        return url;

    }
}
