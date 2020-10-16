package ru.geekbrains.HomeWork_07_Chat;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class ServerChat {
    private LoginService loginService;

    public LoginService getLoginService() {
        return loginService;
    }

    private Set<ClientChat> clientChats;
    public ServerChat () {
        this.clientChats = new HashSet<>();
        this.loginService = new LoginService();
        start(8888);
    }

    public void start(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            waitingClient(serverSocket);
        } catch (IOException e) {
            System.out.println("Server can't start");
            e.printStackTrace();
        }
    }

    public void waitingClient(ServerSocket serverSocket) throws IOException {
        while (true) {
            System.out.println("Server waiting client ...");
            Socket client = serverSocket.accept();
            System.out.println("Client accepted: " + client);
            new ClientChat(this, client);
        }
    }

    public void broadcastMessage(String message) {
        for (ClientChat cc: clientChats){
            cc.sendMessage(message);
        }
        Date date = new Date();
        writeHistory(date + ": "+message);

    }

    public void personalMessage(String user, String message) {
        for (ClientChat cc : clientChats) {
            if (user.equals(cc.getName())){
                cc.sendMessage(message);
            }
        }

    }
    public void subscription (ClientChat clientChat) {
        clientChats.add(clientChat);

    }
    public void unsubscription(ClientChat clientChat) {
        clientChats.remove(clientChat);
    }
    public boolean checkLogin(String name) {
        for (ClientChat cc: clientChats) {
            if (cc.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    static void writeHistory(String lineString) {
        File fileHistory = new File("src/ru/geekbrains/HomeWork_07_Chat/history.txt");

        try (FileWriter fileWriter = new FileWriter(fileHistory, true)) {
            fileWriter.write(lineString + '\n');
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
