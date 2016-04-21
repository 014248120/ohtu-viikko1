
package ohtu.intjoukkosovellus;

import java.util.HashSet;

public class IntJoukko {
    
    private final HashSet<Integer> joukko;
    
    public IntJoukko() {
        this.joukko = new HashSet<>();
    }
    
    public IntJoukko(HashSet<Integer> joukko) {
        this.joukko = joukko;
    }
    
    public boolean lisaa(int luku) {
        return this.joukko.add(luku);
    }
    
    public boolean kuuluu(int luku) {
        return this.joukko.contains(luku);
    }
    
    public boolean poista(int luku) {
        return this.joukko.remove(luku);
    }
    
    public int mahtavuus() {
        return this.joukko.size();
    }
    
    @Override
    public String toString() {
        String alkiot = "";
        for (int i : this.joukko) {
            alkiot += i + ",";
        }
        
        alkiot = (String)alkiot.subSequence(0, alkiot.length()-1);
        return "{" + alkiot + "}";
    }
   

    public IntJoukko yhdiste(IntJoukko a) {
        IntJoukko x = new IntJoukko();
        for (int i : a.getJoukko()) {
            x.lisaa(i);
        }
        
        for (int i : this.joukko) {
            x.lisaa(i);
        }
        
        return x;
    }

    public IntJoukko leikkaus(IntJoukko a) {
        IntJoukko x = new IntJoukko();
        for (int i : a.getJoukko()) {
            if (this.joukko.contains(i)) x.lisaa(i);
        }
        return x;

    }
    
    public IntJoukko erotus ( IntJoukko a) {
        IntJoukko x = new IntJoukko();
        for (int i : a.getJoukko()) {
            if (!this.joukko.contains(i)) x.lisaa(i);
        }
        for (int i : this.joukko) {
            if (!a.getJoukko().contains(i)) x.lisaa(i);
        }
        return x;
    }

    private HashSet<Integer> getJoukko() {
        return this.joukko;
    }
        
}