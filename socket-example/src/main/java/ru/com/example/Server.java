package ru.com.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket socket = new ServerSocket(32312);

        System.out.println("SERVER STARTED");

        while (true){
            Socket client = socket.accept();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

            bufferedWriter.write("HELLO " + bufferedReader.readLine());
            bufferedWriter.flush();
            bufferedWriter.close();
            bufferedReader.close();

            client.close();
        }
    }
}

