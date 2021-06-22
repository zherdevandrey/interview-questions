package ru.com.example;

import java.io.*;
import java.net.Socket;

public class Client {


    public static void main(String[] args) throws IOException {




        Socket socket = new Socket("127.0.0.1", 32312);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        bufferedWriter.write("ANDREY");
        bufferedWriter.flush();

        System.out.println("CLIENT SENT REQUEST");

        String s = bufferedReader.readLine();

        System.out.println(s);

        bufferedWriter.close();
        bufferedReader.close();

    }


}
