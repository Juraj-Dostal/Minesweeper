/**
 * Táto trieda slúži na odkrývanie políčok.
 * 
 * @author Juraj Dostál
 */

public class OdkryvaniePolicok {
    private boolean[][] odkrytePolicka; // atribut hovorí či je políčko odkryté
    private HraciDisplej hraciDisplej;
    private HraciePole hraciePole;
    
    /**
     * Konštruktor vytvára inštanciu.
     */
    public OdkryvaniePolicok(Minesweeper hra) {
        this.odkrytePolicka = new boolean[hra.getPocetRiadkov()][hra.getPocetStlpcov()];
        
        for (int riadok = 0; riadok < this.odkrytePolicka.length; riadok++) {
            for (int stlpec = 0; stlpec < this.odkrytePolicka[0].length; stlpec++) {
                this.odkrytePolicka[riadok][stlpec] = false;
            }
        }
        
        this.hraciDisplej = hra.getHraciDisplej();
        this.hraciePole = hra.getHraciePole();
    }
    
    /**
     * Metóda vráti hodnotu typu boolean.
     */
    public boolean getJePolickoOdkryte(int riadok, int stlpec) {
        return this.odkrytePolicka[riadok][stlpec];
    }
    
    /**
     * Metóda nastaví hodnotu daného atribútu.
     */
    public void setPolickoOdkry(int riadok, int stlpec) {
        this.odkrytePolicka[riadok][stlpec] = true;
    }
    
    /**
     * Metóda odkryje políčko.
     */
    public void odkryPolicko(int riadok, int stlpec) {
        this.hraciDisplej.odkryPolicko(riadok, stlpec);
        this.odkrytePolicka[riadok][stlpec] = true;
    }
    
    /**
     * Metóda prejde cele pole a ak v okolí je odkryté políčko a zároveň je prázdne tak ho odkryje.
     */
    public void odkryPolicka(int riadok, int stlpec) {
        if (!this.getJePolickoOdkryte(riadok, stlpec)) {
            this.odkryPolicko(riadok, stlpec);
            boolean odkryloPolicko = true;
            while (odkryloPolicko) {
                odkryloPolicko = false;
                for (int riad = 0; riad < this.odkrytePolicka.length; riad++) {
                    for (int stlp = 0; stlp < this.odkrytePolicka[0].length; stlp++) {
                        if ( (!(this.odkrytePolicka[riad][stlp])) && this.hraciePole.getHodnotaPola(riad, stlp) != -1) {
                            if (riad > 0) {
                                if (this.odkrytePolicka[riad - 1][stlp] && this.hraciePole.getHodnotaPola(riad - 1, stlp) == 0) {
                                    this.odkryPolicko(riad, stlp);
                                    odkryloPolicko = true;
                                }
                                if (stlp > 0 && this.odkrytePolicka[riad - 1][stlp - 1] && this.hraciePole.getHodnotaPola(riad - 1, stlp - 1) == 0) {
                                    this.odkryPolicko(riad, stlp);
                                    odkryloPolicko = true;
                                }
                            }
                            if (riad < this.odkrytePolicka.length - 1) {
                                if (this.odkrytePolicka[riad + 1][stlp] && this.hraciePole.getHodnotaPola(riad + 1, stlp) == 0) {
                                    this.odkryPolicko(riad, stlp);
                                    odkryloPolicko = true;
                                }
                                if (stlp < this.odkrytePolicka[0].length - 1 && this.odkrytePolicka[riad + 1][stlp + 1] && this.hraciePole.getHodnotaPola(riad + 1, stlp + 1) == 0) {
                                    this.odkryPolicko(riad, stlp);
                                    odkryloPolicko = true;                           
                                }
                            }
                            if (stlp > 0) {
                                if (this.odkrytePolicka[riad][stlp - 1] && this.hraciePole.getHodnotaPola(riad, stlp - 1) == 0) {
                                    this.odkryPolicko(riad, stlp);
                                    odkryloPolicko = true;
                                }
                                if (riad < this.odkrytePolicka.length - 1 && this.odkrytePolicka[riad + 1][stlp - 1] && this.hraciePole.getHodnotaPola(riad + 1, stlp - 1) == 0) {
                                    this.odkryPolicko(riad, stlp);
                                    odkryloPolicko = true;                            
                                }
                            }
                            if (stlp < this.odkrytePolicka[0].length - 1) {
                                if (this.odkrytePolicka[riad][stlp + 1] && this.hraciePole.getHodnotaPola(riad, stlp + 1) == 0) {
                                    this.odkryPolicko(riad, stlp);
                                    odkryloPolicko = true;
                                }
                                if (riad > 0 && this.odkrytePolicka[riad - 1][stlp + 1] && this.hraciePole.getHodnotaPola(riad - 1, stlp + 1) == 0) {
                                    this.odkryPolicko(riad, stlp);
                                    odkryloPolicko = true;                           
                                }
                            }
                        }
                    } 
                } 
            }
        }
    }
}
