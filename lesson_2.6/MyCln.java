package ru.geekbrains.HomeWork_06_Cln;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MyCln {
    private final String SERVER_ADDR = "localhost";
    private final int SERVER_PORT = 8189;
    private Socket socket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;


    public static void main(String[] args) {
        System.out.println("star programm");
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("start new thread");
                new MyCln();
            }
        }).start();
    }

    public MyCln() {
        System.out.println("start myCln");
        try {
            openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sendMessage();
    }
    public void openConnection() throws IOException {
        socket = new Socket(SERVER_ADDR, SERVER_PORT);
        inputStream = new DataInputStream(socket.getInputStream());
        outputStream = new DataOutputStream(socket.getOutputStream());
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        String strFromServer = inputStream.readUTF();
                        if (strFromServer.equalsIgnoreCase("/end")) {
                            break;
                        }
                        System.out.println("Server:" + strFromServer);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void closeConnection() {
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage() {
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
