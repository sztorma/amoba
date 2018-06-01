/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

/**
 *
 * @author Progj11
 */
public class Jel {
    
    private int jelErtek;

    public Jel() {
    }

    public Jel(int jelErtek) {
        this.jelErtek = jelErtek;
    }

    public int getJelErtek() {
        return jelErtek;
    }

    public void setJelErtek(int jelErtek) {
        this.jelErtek = jelErtek;
    }

    

    @Override
    public String toString() {
        if (jelErtek==1) {
            return "X";
        }
        return "O";
    }
   
}
