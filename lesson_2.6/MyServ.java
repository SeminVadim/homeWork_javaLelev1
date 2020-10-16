package ru.geekbrains.HomeWork_06_Serv;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class MyServ {

    public static void main(String[] args){
        new MyServ();
    }

    public MyServ() {
        String stringFromClient;
        Socket socket = null;
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Start server");
            socket = serverSocket.accept();
            System.out.println("Client are connecting");
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            while (true) {
                stringFromClient = inputStream.readUTF();
                if (stringFromClient.equals("/end")) {
                    socket.close();
                    break;
                }
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        sendMessage(outputStream);
                    }
                }).start();
                System.out.println("Client: " + stringFromClient);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(DataOutputStream outputStream) {
        Scanner in = new Scanner(System.in);
        String  msgInputField;
        while (true) {
            msgInputField = in.nextLine();
            try {
                outputStream.writeUTF(msgInputField);
                msgInputField = "";
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Ошибка отправки сообщения");
            }
        }
    }
}
