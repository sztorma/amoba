/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amoba2;

import logika.Tabla;

/**
 *
 * @author Progj11
 */
public class Amoba2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int meret=5;
        int darabJelGyozelemhez=3;
        
        Tabla tabla = new Tabla(meret, darabJelGyozelemhez);
        tabla.kisJatekFuttatas();
  
    }
    
}
