/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;
import java.io.*;
import java.net.*;
/**
 *
 * @author ranasgalla.niccolo
 */


public class GestoreClient extends Thread {
    private Socket socket;
    private PallaMagica palla;

    public GestoreClient(Socket socket) {
        this.socket = socket;
        this.palla = new PallaMagica();
    }

    public void run() {
        try {
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            out.writeUTF("Fai una domanda alla Palla Magica");

            while (true) {
                // Legge la domanda
                String domanda = in.readUTF(); 
                System.out.println("Il client chiede: " + domanda);

                // Prende una risposta a caso e la invia
                String risposta = palla.dammiRisposta();
                out.writeUTF(risposta);
            }
        } catch (Exception e) {
            System.out.println("Un client si è disconnesso.");
        }
    }
}
