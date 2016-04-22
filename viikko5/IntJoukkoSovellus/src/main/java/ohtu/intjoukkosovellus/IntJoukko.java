
package ohtu.intjoukkosovellus;

import java.util.TreeSet;

public class IntJoukko {
    
    private final TreeSet<Integer> joukko;
    
    public IntJoukko() {
        this.joukko = new TreeSet<>();
    }
    
    public IntJoukko(TreeSet<Integer> joukko) {
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
        
        if (alkiot.length()>0) alkiot = (String)alkiot.subSequence(0, alkiot.length()-1);
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

    private TreeSet<Integer> getJoukko() {
        return this.joukko;
    }
    
    public int[] toIntArray() {
        int [] ret = new int[joukko.size()];
        int c = 0;
        for (int i : this.joukko) {
            ret[c++]=i;
        }
        return ret;
    }
        
}