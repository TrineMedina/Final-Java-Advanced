package com.adv.java.regex;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExSearch {

    static private String text;
    static private Matcher matcher;

    public static void readFromTextFile(File file) throws IOException {

        String pathName = System.getProperty("user.dir") + File.separator + "Book_List.txt";
        Path path = Paths.get(pathName);
        text = new String(Files.readAllBytes(path));
    }

    public static void patternMaker(String regEx){
        Pattern pattern = Pattern.compile(regEx);
        matcher = pattern.matcher(text);
    }

    public void findXML(File file) throws IOException {

        readFromTextFile(file);

        int counter = 0;
        String regEx = "[1-9]{2}.[0-9]{2}";

        patternMaker(regEx);
        while (matcher.find()){
            counter ++;
        }
        System.out.println("Total number of books that cost $10 or more: " + counter);
    }
}

