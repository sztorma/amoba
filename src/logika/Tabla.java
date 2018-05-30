/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import java.util.Scanner;

/**
 *
 * @author Progj11
 */
public class Tabla {

    private static Scanner scanner;

    private int meret;
    private int pontszamx;
    private int pontszamo;
    private Jel[][] tabla;

    static {
        scanner = new Scanner(System.in);
    }

    public Tabla(int meret) {
        this.meret = meret;
        pontszamx = 0;
        pontszamo = 0;
        // letrehozzuk a tablat
        tabla = new Jel[meret][meret];
        // null-okkal tolti fel a tablat
        tablaUrites();
    }

    public int getPontszamx() {
        return pontszamx;
    }

    public void setPontszamx(int pontszamx) {
        this.pontszamx = pontszamx;
    }

    public int getPontszamo() {
        return pontszamo;
    }

    public void setPontszamo(int pontszamo) {
        this.pontszamo = pontszamo;
    }

    // ket koordinata bekerese a scanner segitsegevel
    public Koordinata bekertKoordinata(Jel elhelyezendoJel) {
        // koordinata osztalyt kidolgozni
        // bekerjuk a ket int-et a scannerrel

        System.out.print ("(" + elhelyezendoJel.getNev() + ") sor: ");
        int x = scanner.nextInt();
        System.out.print ("oszlop: ");
        int y = scanner.nextInt();

        // visszaterunk egy Koordinata osztallyal, ami a ket intet tartalmazza
        Koordinata k = new Koordinata();
        k.setX(x-1);
        k.setY(y-1);

        return k;
    }

    public void jelLerakas(Koordinata k, Jel elhelyezendoJel) {
        //uresE(k);
        //belulVanE(k);

        tabla[k.getX()][k.getY()] = elhelyezendoJel;

        // ha mindketto igaz, akkor lerakunk egy jelet a bekert koordinatara
        // azt a jelet, amit parameterben kapunk itt
    }

    private Jel aGyoztes() {
        // megnezi, hogy van-e gyoztes, es ha igen, akkor
        // visszater egy Jel-lel, ami vagy JelX, vagy JelO, vagy null
        // a jatek persze addig folytatodik, amig ez a aGyoztes null
        return null;
    }

    public void kisJatekFuttatas() {
        // amig nincs gyoztes, addig jeleket rakunk le
        int lepesSzam = 0;
        do {
            lepesSzam++;
            Jel elhelyezendoJel;
            // egyszer az egyik, masszor a masik jo
            // kettovel valo osztas maradeka egyszer 1, egyszer 0
            if (lepesSzam % 2 == 1) {
                JelX elhelyezendoJelForras = new JelX();
                elhelyezendoJel = (Jel) elhelyezendoJelForras;
            } else {
                JelO elhelyezendoJelForras = new JelO();
                elhelyezendoJel = (Jel) elhelyezendoJelForras;
            }

            Koordinata k = bekertKoordinata(elhelyezendoJel);
            jelLerakas(k, elhelyezendoJel);
            kirajzolas();
        } while (aGyoztes() == null);
        pontOsztas(aGyoztes());
    }

    private void kirajzolas() {
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla.length; j++) {
                if (tabla[i][j] == null) {
                    System.out.print(".");
                } else {
                    System.out.print(tabla[i][j]);
                }
            }
            System.out.println("");
        }
    }

    private void tablaUrites() {
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla.length; j++) {
                tabla[i][j] = null;
            }
        }
    }

    private void uresE(Koordinata k) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void belulVanE(Koordinata k) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void pontOsztas(Jel aGyoztes) {
        // a kisJatek vegen ad pontot a gyoztesnek
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
