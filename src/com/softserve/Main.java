package com.softserve;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<AtmNetwork> atmNetworks = new ArrayList<AtmNetwork>(5); // 5 will be enough

        atmNetworks.add(new AtmNetwork("ПриватБанк", new PrivatBanksListCreator("https://privatbank.ua/")));
        atmNetworks.add(new AtmNetwork("АТМоСфера", new AtmosferaBanksListCreator("http://www.atmosphere.net.ua/ru/members_atmoshera_rus.htm?print&showAll=1")));
        //atmNetworks.add(new AtmNetwork("Euronet", new UkrcardBanksListCreator("http://ubanks.com.ua/atmnet/euronet.php")));
        //atmNetworks.add(new AtmNetwork("Радіус", new UkrcardBanksListCreator("http://ubanks.com.ua/atmnet/radius.php")));
        //atmNetworks.add(new AtmNetwork("УкрКард", new UkrcardBanksListCreator("http://ubanks.com.ua/atmnet/ukrcard.php")));

        for(AtmNetwork network : atmNetworks){
            printAtmNetwork(network);
        }

        AtmNetworksXML.createXML(atmNetworks, "atm_networks.xml");

    }

    public static void printAtmNetwork(AtmNetwork network){
        System.out.println(network.getName());
        for(BankEntry bank : network.getBanks()){
            System.out.printf("  -  %s %s\n", bank.getBankName(), bank.getBankURL());
        }
        System.out.println();
    }
}
