package com.softserve;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

/**
 * Created by Tolsyk on 22.10.2014.
 */
public class AtmNetworksXML {

    public static void createXML(List<AtmNetwork> networks, String filename) {
        File file = new File(filename);

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        try {
            // Create document
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("banks");
            doc.appendChild(rootElement);
            // Crating the DOM structure banks element
            for (AtmNetwork atmNetwork : networks) {
                Element network = doc.createElement("network");
                network.setAttribute("name", atmNetwork.getName());
                rootElement.appendChild(network);
                List banks = atmNetwork.getBanks();
                setBanksInNetwork(doc, banks, network);
            }
            // save Document doc in
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(file);
            transformer.transform(source, result);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        System.out.println("file write!!");

    }
    /**this method saved tags (Elements) link  and name  in bank. And bank saved in his network*/
    private static void setBanksInNetwork(Document doc, List<BankEntry> bankList, Element network) {
        for (BankEntry bankEntry : bankList) {

            Element bank = doc.createElement("bank");
            Element name = doc.createElement("name");
            Element link = doc.createElement("link");

            name.appendChild(doc.createTextNode(bankEntry.getBankName()));
            link.appendChild(doc.createTextNode(bankEntry.getBankURL()));

            network.appendChild(bank);
            bank.appendChild(name);
            bank.appendChild(link);


        }
    }

}
