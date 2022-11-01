package com.adv.java.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XML {

    private static String fileName = "MicrosoftXML.xml";
    private static XPath path;
    private static Document doc;
    static List<String> bookList = new ArrayList<>();

    public List<String> parserXPath() throws XPathExpressionException, ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.parse(fileName);

        XPathFactory xPathFactory = XPathFactory.newInstance();
        path = xPathFactory.newXPath();

        String expression = "/catalog/book";
        NodeList nodeList = (NodeList) path.compile(expression).evaluate(doc, XPathConstants.NODESET);
        int count = 0;

        for (int i = 0; i < nodeList.getLength(); i++) {

            Node newNode = nodeList.item(i);

            if (newNode.getNodeType() == Node.ELEMENT_NODE) {

                Element element = (Element) newNode;
                bookList.add("Author: " + element.getElementsByTagName("author").item(0).getTextContent());
                bookList.add("Title: " + element.getElementsByTagName("title").item(0).getTextContent());
                bookList.add("Price: $" + element.getElementsByTagName("price").item(0).getTextContent() + "\n");
                count++;
            }
        }
        System.out.println(count + " books have been added to the list as follows:\n\n" +bookList.toString());
        return bookList;
    }
}

