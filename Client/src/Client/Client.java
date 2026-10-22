/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Client;
import java.io.*;
import java.net.*;
import java.util.Scanner;
/**
 *
 * @author ranasgalla.niccolo
 */

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 5555);

        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream());
        Scanner tastiera = new Scanner(System.in);

        // Legge subito il benvenuto (con menu e help) mandato dal server
        System.out.println("Server: " + in.readUTF());
        
        while (true) {

        System.out.print("Client: ");
        out.writeUTF(tastiera.nextLine());

        System.out.println("Server: " + in.readUTF());

        }
    }
}