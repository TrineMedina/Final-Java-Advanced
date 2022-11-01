package com.adv.java.iostream;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class IOStream {

    public File writeToTextFile(List<String> bookList) {

        File bookListTxt= new File("Book_List.txt");

        try (PrintWriter pw = new PrintWriter(bookListTxt, StandardCharsets.UTF_8)) {

            for (String book : bookList) {
                pw.println(book);
            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        return bookListTxt;
    }

}
