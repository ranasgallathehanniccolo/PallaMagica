/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;
import java.util.*;

/**
 *
 * @author ranasgalla.niccolo
 */

public class PallaMagica {
    private String[] risposteBasi = {
        "Si, assolutamente.",
        "E' molto probabile.",
        "Forse, chiedi piu' tardi.",
        "Non ci contare.",
        "Assolutamente no."
    };
    private String[] risposteDarioMoccia = {
        "De",
        "Pefforza",
        "Si va a letto",
        "Bimbi",
        "Lo fanno",
        "Mio padre"
    };
    private String[] risposteCinico = {
        "Sì. Ma tanto finisce male lo stesso.",
        "Certo, le speranze si sono sempre realizzate... a qualcun altro.",
        "Chiedilo al tuo futuro io. Ah no, è depresso anche lui.",
        "Il tuo piano è ottimo. Peccato che l'universo non l'abbia letto.",
        "Ti rispondo quando avrò voglia. Spoiler: mai.",
    };

    private String[] risposteInUso;
    private String nome;
    private Random rand = new Random();

    // Il costruttore imposta l'array giusto in base al numero scelto
    public PallaMagica(int personalita) {
        switch (personalita) {
            case 1:
                risposteInUso = risposteBasi;
                nome = "Classica";
                break;
            case 2:
                risposteInUso = risposteDarioMoccia;
                nome = "Dario Moccia";
                break;
            case 3:
                risposteInUso = risposteCinico;
                nome = "Offensivo";
                break;    
        }
    }

    public String getNome() {
        return nome;
    }

    public String dammiRisposta() {
        return risposteInUso[rand.nextInt(risposteInUso.length)];
    }
}