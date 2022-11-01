package com.adv.java.fin.application;

import com.adv.java.iostream.IOStream;
import com.adv.java.regex.RegExSearch;
import com.adv.java.xml.XML;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.File;
import java.io.IOException;
import java.util.List;


public class MainAppRunner {

    public static void main(String[] args) throws XPathExpressionException, ParserConfigurationException, IOException, SAXException {

        List<String> bookList;
        File bookListTxt;

        XML xml = new XML();
        IOStream ioStream = new IOStream();
        RegExSearch regExSearch = new RegExSearch();

        System.out.println("\nParsing MicrosoftXML file to add books to list using xPath parser - module com.adv.java.xml\n");

        bookList = xml.parserXPath();

        System.out.println("\nAdding list of books to Book_List.txt file - module com.adv.java.iostream");
        bookListTxt = ioStream.writeToTextFile(bookList);
        System.out.println("Books have been added to Book_List.txt file located at " +bookListTxt.getAbsolutePath() +"\n");

        System.out.println("Searching Book_List.txt for the number of books that cost more than $10.00 - module com.adv.regex\n");
        regExSearch.findXML(bookListTxt);

        System.out.println("\nAll Done!");
    }
}
