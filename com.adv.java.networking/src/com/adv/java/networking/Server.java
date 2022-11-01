package com.adv.java.networking;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import  java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static int port = 49152;

    public static void main(String[] args) throws IOException {


        System.out.println("Server running on port # " + port);

        try (
                ServerSocket sSocket = new ServerSocket(port)){

            System.out.println("Waiting for connection...");

            try (Socket incoming = sSocket.accept()){
                System.out.println("Connection made.");
                OutputStream out = incoming.getOutputStream();

                Scanner sc = new Scanner(incoming.getInputStream(), "UTF-8");
                System.out.println("Receiving data...");
                System.out.println("Data received:\n");
                while (sc.hasNext()){
                    try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(out, "UTF-8"), true)){
                        writer.println(sc.nextLine());
                    }
                }
                sSocket.close();
            }
        }
    }
}

