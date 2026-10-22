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
    private static final String HELP =
        "Comandi disponibili:\n"
        + "  PERSONA_[1-3]     scegli la personalita\n"
        + "  DOMANDA_[testo]   fai una domanda\n"
        + "  HELP              mostra questo aiuto\n";

    public GestoreClient(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Messaggio di benvenuto con la scelta della personalità
           // out.writeUTF("Benvenuto alla Palla Magica! Scegli la personalita:\n"
           // + "  1 - Classica\n"
           // + "  2 - Dario Moccia\n"
           // + "  3 - Cinico\n"        
           // + HELP);   // un solo messaggio


            while (true) {
                String msg = in.readUTF().trim();
                System.out.println("Il client invia: " + msg);

                if (msg.startsWith("PERSONA_")) {
                    try {
                        int n = Integer.parseInt(msg.substring("PERSONA_".length()).trim());
                        if (n < 1 || n > 3) {
                            out.writeUTF("ERRORE: personalita non valida (scegli 1, 2 o 3).");
                        } else {
                            palla = new PallaMagica(n);
                            out.writeUTF("Personalita impostata: " + palla.getNome()
                                    + ". Ora fai la tua domanda!");
                        }
                    } catch (NumberFormatException e) {
                        out.writeUTF("ERRORE: usa PERSONA_[numero].");
                    }

                } else if (msg.startsWith("DOMANDA_")) {
                    if (palla == null) {
                        out.writeUTF("ERRORE: prima scegli una personalita con PERSONA_[numero].");
                    } else {
                        out.writeUTF(palla.dammiRisposta());
                    }

                } else if (msg.equals("HELP")) {
                    out.writeUTF(HELP);
                    
                } else {
                    out.writeUTF("ERRORE: comando sconosciuto. Scrivi HELP.");
                }
            }
        } catch (Exception e) {
            // il client ha chiuso la connessione
        } finally {
            System.out.println("Un client si e' disconnesso");
            try { socket.close(); } catch (IOException e) { }
        }
    }
}
