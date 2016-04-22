
package ohtu.intjoukkosovellus;

import java.util.Scanner;


public class UI {
    private final SovellusLogiikka logiikka;
    private final Scanner lukija;

    public UI(Scanner lukija) {
        this.logiikka = new SovellusLogiikka(new IntJoukko(), new IntJoukko(), new IntJoukko());
        this.lukija = lukija;
    }
    
    
    public void kaynnista() {
        tulostaKaynnistysViesti();
        
        String kasky = lukija.nextLine();
        while (!lopetus(kasky)) {
            lueKasky(kasky);
            System.out.print(">>");
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
            sisaltyvyys();
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
    
    public String kysyJoukko(String... teksti) {
        if (teksti.length>0) System.out.println(teksti[0]);
        else System.out.println("Anna joukko");
        
        System.out.print(">>");
        String luettu = lukija.nextLine();
        while (!logiikka.onJoukko(luettu)) {
            System.out.println("Virheellinen joukko! " + luettu);
            System.out.print("Yritä uudelleen!>>");
            luettu = lukija.nextLine();
        }
        return luettu;
    }
    
    public String[] kysyJoukot(String... teksti) {
        if (teksti.length>0) System.out.println(teksti[0]);
        String[] joukot = new String[2];
        System.out.print("1. joukko? ");
        joukot[0] = kysyJoukko();
        System.out.print("2. joukko? ");
        joukot[1] = kysyJoukko();
        
        return joukot;
    }
    
    public int kysyLuku(String... teksti) {
        if (teksti.length>0) System.out.println(teksti[0]);
        else System.out.println("Anna luku");
        System.out.print(">>");
        return Integer.parseInt(lukija.nextLine());
    }

    public void lisays() {
        String joukko = kysyJoukko();
        int luku = kysyLuku("Anna lisättävä luku");
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
    }

    public void poisto() {
        String joukko = kysyJoukko();
        int luku = kysyLuku("Anna poistettava luku");
        logiikka.poista(joukko, luku);
    }

    public void sisaltyvyys() {
        String joukko = kysyJoukko();
        int luku = kysyLuku();
        if (logiikka.sisaltyy(joukko, luku)) {
            System.out.println(luku + " kuuluu joukkoon ");
        } else {
            System.out.println(luku + " ei kuulu joukkoon ");
        }
    }
    
}
