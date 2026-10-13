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
        "Sì, assolutamente.",
        "È molto probabile.",
        "Forse, chiedi più tardi.",
        "Non ci contare.",
        "Assolutamente no."
    };
    private String[] risposteDarioMoccia = {
        "De",
        "Pefforza",
        "Si va a letto",
        "AAAAAAAH",
        "lo fanno",
        "Mio padre"
    };
    private String[] risposteFilosoficheMeme = {
        "Non importa come percorrerai la strada...",
        "Ricorda: l'acqua non è verde",
        "Le cinesi ti diranno sempre: tloppo colto",
        ""
    };
    
    private String[] risposteInUso;

    // Il costruttore imposta l'array giusto in base al numero scelto
    public PallaMagica(int personalita) {
        switch (personalita) {
            default:
            case 1:
                risposteInUso = risposteBasi;
                break;
            case 2:
                risposteInUso = risposteDarioMoccia;
                break;
            case 3:
                risposteInUso = risposteFilosoficheMeme;
                break;
        }
    }

    public String dammiRisposta() {
        Random rand = new Random();
        int indice = rand.nextInt(risposteInUso.length);
        return risposteInUso[indice];
    }
}
