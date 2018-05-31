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
    private int darabJelGyozelemhez;
    private int pontszamx;
    private int pontszamo;
    private Jel[][] tabla;

    static {
        scanner = new Scanner(System.in);
    }

    public Tabla(int meret, int darabJelGyozelemhez) {
        this.meret = meret;
        this.darabJelGyozelemhez = darabJelGyozelemhez;
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

    public int getDarabJelGyozelemhez() {
        return darabJelGyozelemhez;
    }

    public void setDarabJelGyozelemhez(int darabJelGyozelemhez) {
        this.darabJelGyozelemhez = darabJelGyozelemhez;
    }

    // ket koordinata bekerese a scanner segitsegevel
    public Koordinata bekertKoordinata(Jel elhelyezendoJel) {
        // koordinata osztalyt kidolgozni
        // bekerjuk a ket int-et a scannerrel

        System.out.print("(" + elhelyezendoJel + ") sor: ");
        int x = scanner.nextInt();
        System.out.print("oszlop: ");
        int y = scanner.nextInt();

        // visszaterunk egy Koordinata osztallyal, ami a ket intet tartalmazza
        Koordinata k = new Koordinata();
        k.setX(x - 1);
        k.setY(y - 1);

        return k;
    }

    public boolean jelLerakas(Koordinata k, Jel elhelyezendoJel) {
        // ha mindketto igaz, akkor lerakunk egy jelet a bekert koordinatara
        // azert fut le tablan kivuli erteknel, mert
        // a belulVanE fuggveny false, es igy a tovabbi reszt mar nem kell nezni, 
        // mert biztos, hogy false lesz az && miatt
        if (belulVanE(k) && uresE(k)) {
            // azt a jelet, amit parameterben kapunk itt
            tabla[k.getX()][k.getY()] = elhelyezendoJel;
            return true;
        } else {
            System.out.println("Kivul van, vagy mar foglalt a mezo!");
            return false;
        }
    }

    private Jel aGyoztes(Koordinata k) {
        // megnezi, hogy van-e gyoztes, es ha igen, akkor
        // visszater egy Jel-lel, ami vagy JelX, vagy JelO, vagy null
        // a jatek persze addig folytatodik, amig ez a aGyoztes null
        // az utolso lerakott jel koordinatajatol megnezi az osszes vonalat, atlot
        // vegiglepked rajta, es nezi, hogy van-e egymas mellett eleg ugyanolyan jel
        // ha van, akkor kipel, es visszaadja a gyoztes jelet
        // sor vegigjarasa

        int darabEgymasMellett = 0;
        // aki utoljara lep, annak a jele:
        Jel utolsoJel = tabla[k.getX()][k.getY()];
        
        int induloIndexY = 0;
        // vizszintesen megnezi
        do {
            if (tabla[k.getX()][induloIndexY].getJelErtek()==utolsoJel.getJelErtek()) {
                darabEgymasMellett++;
            } else {
                darabEgymasMellett=0;
            }
            induloIndexY++;
        } while (darabEgymasMellett < darabJelGyozelemhez && induloIndexY<meret);

        if (darabEgymasMellett>=darabJelGyozelemhez) {
            System.out.println("Gyozelem!!!");
        }
        
        return null;
    }

    public void kisJatekFuttatas() {
        // amig nincs gyoztes, addig jeleket rakunk le
        int lepesSzam = 0;
        Koordinata k;
        do {
            Jel elhelyezendoJel;
            // egyszer az egyik, masszor a masik jo
            // kettovel valo osztas maradeka egyszer 1, egyszer 0
            if (lepesSzam % 2 == 1) {
                //JelX elhelyezendoJelForras = new JelX();
                elhelyezendoJel = new Jel(1);
            } else {
                //JelO elhelyezendoJelForras = new JelO();
                 elhelyezendoJel = new Jel(-1);
            }

            k = bekertKoordinata(elhelyezendoJel);
            //jelLerakas(k, elhelyezendoJel);
            // beleteszi a jelet, mikozben visszater azzal, hogy sikerult-e
            if (jelLerakas(k, elhelyezendoJel)) {
                lepesSzam++;
            }

            aGyoztes(k);

            kirajzolas();
        } while (aGyoztes(k) == null);
        pontOsztas(aGyoztes(k));
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

    private boolean uresE(Koordinata k) {
        return (tabla[k.getX()][k.getY()] == null);
    }

    private boolean belulVanE(Koordinata k) {
        return (k.getX() >= 0 && k.getX() < meret
                && k.getY() >= 0 && k.getY() < meret);
    }

    private void pontOsztas(Jel aGyoztes) {
        // a kisJatek vegen ad pontot a gyoztesnek
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
