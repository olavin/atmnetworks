package com.softserve;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<AtmNetwork> atmNetworks = new ArrayList<AtmNetwork>(5); // 5 will be enough

        atmNetworks.add(new AtmNetwork("ПриватБанк", new PrivatBanksListCreator("https://privatbank.ua/")));
        atmNetworks.add(new AtmNetwork("АТМоСфера", new AtmosferaBanksListCreator("http://www.atmosphere.net.ua/")));
        atmNetworks.add(new AtmNetwork("Euronet", new EuronetBanksListCreator("http://ubanks.com.ua/atmnet/euronet.php")));
        atmNetworks.add(new AtmNetwork("Радіус", new RadiusBanksListCreator("http://ubanks.com.ua/atmnet/radius.php")));
        atmNetworks.add(new AtmNetwork("УкрКард", new UkrcardBanksListCreator("http://www.ukrcard.com.ua/")));

        AtmNetworksXML.createXML(atmNetworks);

    }
}
