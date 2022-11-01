package com.adv.java.networking;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {
    int port = 49152;
    String localServer = "localhost";
    String bookListXML = "MicrosoftXML.xml";

    public void connectToServer() throws IOException {

        try (Socket socket = new Socket(localServer, port)) {

            OutputStream out = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(out, StandardCharsets.UTF_8), true);
            writer.write(bookListXML);

            Scanner sc = new Scanner(socket.getInputStream(), "UTF-8");
            System.out.println();
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        }
    }
}