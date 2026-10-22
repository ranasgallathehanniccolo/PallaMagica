/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package server;
import java.io.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author ranasgalla.niccolo
 */

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(5555);
        System.out.println("Server Palla Magica avviato");

        while (true) {
            // Aspetta un client
            Socket socket = server.accept();
            System.out.println("Nuovo client connesso");

            // Crea un thread per questo client e lo avvia
            GestoreClient gestore = new GestoreClient(socket);
            gestore.start();
        }
    }
}