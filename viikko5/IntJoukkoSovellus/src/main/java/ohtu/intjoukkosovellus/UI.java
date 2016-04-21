
package ohtu.intjoukkosovellus;

import java.util.Scanner;


public class UI {
    private SovellusLogiikka logiikka;
    private Scanner lukija;

    public UI(Scanner lukija) {
        this.logiikka = new SovellusLogiikka(new IntJoukko(), new IntJoukko(), new IntJoukko());
        this.lukija = new Scanner(System.in);
    }
    
    
    public void kaynnista() {
        tulostaKaynnistysViesti();
        
        String kasky = lukija.nextLine();
        while (!lopetus(kasky)) {
            lueKasky(kasky);
            kasky = lukija.nextLine();
        }
        
        System.out.println("Lopetetaan, moikka!");
    }
    
    public void lueKasky(String kasky) {
        if (kasky.equals("lisää") || kasky.equals("li")) {
                lisays();
            } else if (kasky.equalsIgnoreCase("poista") || kasky.equalsIgnoreCase("p")) {
                poisto();
            } else if (kasky.equalsIgnoreCase("kuuluu") || kasky.equalsIgnoreCase("k")) {
                kuuluu();
            } else if (kasky.equalsIgnoreCase("yhdiste") || kasky.equalsIgnoreCase("y")) {
                yhdiste();
            } else if (kasky.equalsIgnoreCase("leikkaus") || kasky.equalsIgnoreCase("le")) {
                leikkaus();
            } else if (kasky.equalsIgnoreCase("erotus") || kasky.equalsIgnoreCase("e")) {
                erotus();
            } else if (logiikka.onJoukko(kasky)) {
                System.out.println(logiikka.joukkoToString(kasky));
            } else {
                System.out.println("Virheellinen komento! " + kasky);
                tulostaOhje();
            }
    }
    
    private boolean lopetus(String kasky) {
        return (kasky.equalsIgnoreCase("lopeta") 
                || kasky.equalsIgnoreCase("q") 
                || kasky.equalsIgnoreCase("quit"));
    }
    
    
    public void tulostaKaynnistysViesti() {
        System.out.println("Tervetuloa joukkolaboratorioon!");
        System.out.println("Käytössäsi ovat joukot A, B ja C.");
        tulostaOhje();
    }
    
    public void tulostaOhje() {
        System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e), leikkaus(le) ja lopetus(quit)(q).");
        System.out.println("Joukon nimi komentona tarkoittaa pyyntöä tulostaa joukko.");
    }
    
    public String kysyJoukko() {
        System.out.println("Anna joukko");
        String luettu = lukija.nextLine();
        while (!logiikka.onJoukko(luettu)) {
            System.out.println("Virheellinen joukko! " + luettu);
            System.out.print("Yritä uudelleen!");
            luettu = lukija.nextLine();
        }
        return luettu;
    }
    
    public String[] kysyJoukot() {
        String[] joukot = new String[2];
        System.out.print("1. joukko? ");
        joukot[0] = kysyJoukko();
        System.out.print("2. joukko? ");
        joukot[1] = kysyJoukko();
        
        return joukot;
    }
    
    public int kysyLuku() {
        System.out.println("Anna luku");
        return lukija.nextInt();
    }

    public void lisays() {
        String joukko = kysyJoukko();
        int luku = kysyLuku();
        logiikka.lisaa(joukko, luku);
    }

    public void yhdiste() {
        String[] joukot = kysyJoukot();
        System.out.println(joukot[0] + " yhdiste " + joukot[1] + 
                            "= " + logiikka.yhdiste(joukot[0], joukot[1]));
    }

    public void leikkaus() {
        String[] joukot = kysyJoukot();
        System.out.println(joukot[0] + " leikkaus " + joukot[1] + 
                            "= " + logiikka.leikkaus(joukot[0], joukot[1]));
    }

    public void erotus() {
        String[] joukot = kysyJoukot();
        System.out.println(joukot[0] + " erotus " + joukot[1] + 
                            "= " + logiikka.erotus(joukot[0], joukot[1]));
        return;
    }

    public void poisto() {
        String joukko = kysyJoukko();
        System.out.print("Mikä luku poistetaan? ");
        int luku = kysyLuku();
        logiikka.poista(joukko, luku);;
    }

    public void kuuluu() {
        IntJoukko joukko;
        int kysLuku;
        Scanner lukija = new Scanner(System.in);
        System.out.print("Mihin joukkoon? ");
        joukko = mikaJoukko();
        System.out.print("Mikä luku? ");
        kysLuku = lukija.nextInt();
        boolean kuuluuko = joukko.kuuluu(kysLuku);
        if (kuuluuko) {
            System.out.println(kysLuku + " kuuluu joukkoon ");
        } else {
            System.out.println(kysLuku + " ei kuulu joukkoon ");
        }
        return;
    }
    
}
