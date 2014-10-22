package com.softserve;

import com.google.code.bing.search.schema.web.WebResponse;
import com.google.code.bing.search.schema.web.WebResult;
import com.google.code.bing.search.schema.web.WebSearchOption;

import com.google.code.bing.search.client.BingSearchClient;
import com.google.code.bing.search.client.BingSearchServiceClientFactory;
import com.google.code.bing.search.client.BingSearchClient.SearchRequestBuilder;
import com.google.code.bing.search.schema.AdultOption;
import com.google.code.bing.search.schema.SearchOption;
import com.google.code.bing.search.schema.SearchRequest;
import com.google.code.bing.search.schema.SearchResponse;
import com.google.code.bing.search.schema.SourceType;
import com.google.code.bing.search.schema.web.WebResult;
import com.google.code.bing.search.schema.web.WebSearchOption;

import java.util.List;

/**
 * Created by d18-antoshkiv on 22.10.2014.
 */
public class bingSearch {
    public static void findSiteByCompanyName(String name){
        final String applicationId = "75ed54d2d43f4265b03f1a670193cd86"; //olavin's AppId

        BingSearchServiceClientFactory factory = BingSearchServiceClientFactory.newInstance();
        BingSearchClient client = factory.createBingSearchClient();

        BingSearchClient.SearchRequestBuilder builder = client.newSearchRequestBuilder();

        builder.withAppId(applicationId);
        builder.withQuery(name);
        builder.withSourceType(SourceType.WEB);
        builder.withVersion("2.0");
        builder.withMarket("en-us"); //en-us uk-UA
        builder.withAdultOption(AdultOption.MODERATE);
        builder.withSearchOption(SearchOption.ENABLE_HIGHLIGHTING);

        builder.withWebRequestCount(10L);
        builder.withWebRequestOffset(0L);
        builder.withWebRequestSearchOption(WebSearchOption.DISABLE_HOST_COLLAPSING);
        builder.withWebRequestSearchOption(WebSearchOption.DISABLE_QUERY_ALTERATIONS);

        SearchResponse response = client.search(builder.getResult());

        System.out.println("Bing API Version " + response.getVersion());
        System.out.println("Web results for " + response.getQuery().getSearchTerms());

        if(response != null){
            //System.out.println(response.getWeb().toString());

            //response.
            WebResponse web = response.getWeb();
            if(web != null){
                //long total = web.getTotal();
                //System.out.println("Total: "+String.valueOf(total));
                //List<WebResult> res = response.getWeb().getResults();
                /*
                for (WebResult result : res) {
                    System.out.println(result.getTitle());
                    System.out.println(result.getDescription());
                    System.out.println(result.getUrl());
                    System.out.println(result.getDateTime());
                }
                */

            }

        }
    }
}
