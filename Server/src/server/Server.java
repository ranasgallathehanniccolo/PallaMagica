/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package server;
import java.io.*;
import java.net.*;
import java.util.Scanner;
/**
 *
 * @author Windows
 */

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(5555);
        Socket clientSocket = serverSocket.accept();

        DataInputStream in = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
        Scanner tastiera = new Scanner(System.in);

        while (true) {

        System.out.println("Client: " + in.readUTF());

        System.out.print("Server: ");
        out.writeUTF(tastiera.nextLine());

        }
    }
}
