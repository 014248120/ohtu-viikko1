
package ohtu.intjoukkosovellus;


public class SovellusLogiikka {
    public final IntJoukko A,B,C;

    public SovellusLogiikka(IntJoukko A, IntJoukko B, IntJoukko C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }
    
    
    public String joukkoToString(String joukko) {
        return getJoukko(joukko).toString();
    }
    
    public boolean onJoukko(String joukko) {
        return getJoukko(joukko) != null;
    }
    
    public IntJoukko getJoukko(String joukko) {
        switch (joukko) {
            case "A": return A;
            case "B": return B;
            case "C": return C;
            default: return null;
        }
    }
    
    public void lisaa(String joukko, int luku) {
        getJoukko(joukko).lisaa(luku);
    }
    
    public String yhdiste(String x, String y) {
        return getJoukko(x).yhdiste(getJoukko(y)).toString();
    }
    
    public String leikkaus(String x, String y) {
        return getJoukko(x).leikkaus(getJoukko(y)).toString();
    }
    
    public String erotus(String x, String y) {
        return getJoukko(x).erotus(getJoukko(y)).toString();
    }
    
    public void poista(String joukko, int luku) {
        getJoukko(joukko).poista(luku);
    }
    
    public boolean sisaltyy(String joukko, int luku) {
        return getJoukko(joukko).kuuluu(luku);
    }
    
}
