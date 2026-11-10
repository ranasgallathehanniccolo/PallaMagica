/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import com.google.gson.Gson;
import java.util.Random;
import java.io.*;
/**
 *
 * @author ranasgalla.niccolo
 */
public class PallaJson {
    
    public static class Personalita {
        private String nome;
        private String[] risposte;
    }
    
    private Personalita[] lista;
    private Random rand = new Random();
    
     public PallaJson(String percorso) throws IOException {
        lista = new Gson().fromJson(new FileReader(percorso), Personalita[].class);
    }

    public String getNome(int n) {
        return lista[n - 1].nome;
    }

    public String dammiRisposta(int n) {
        String[] r = lista[n - 1].risposte;
        return r[rand.nextInt(r.length)];
    }
}
