import fri.shapesge.Manazer;
/**
 * Trieda, ktorá rieší jednotlivé ťahy a čas a kontroluje ich. 
 * 
 * @author Juraj Dostál
 */
public class Tah {
    
    private Manazer manazer;
    private Minesweeper hra;
    private OdkryvaniePolicok odkryvanie;
    private HraciePole pole;
    private HraciDisplej displej;
    
    private boolean prvyTah;
    private boolean koniecHry;
    
    private static final int STRANA = 25;
    private int pocetVlajok;
    private int cas;
    
    /**
     * Konštruktor vytvára inštanciu a nasavuje hodnoty.
     */
    public Tah(Minesweeper hra) {
        this.manazer = new Manazer();
        this.manazer.spravujObjekt(this);
        
        this.hra = hra;
        this.odkryvanie = this.hra.getOdkryvaniePolicok();
        this.pole = this.hra.getHraciePole();
        this.displej = this.hra.getHraciDisplej();
        
        this.prvyTah = true;
        this.koniecHry = false;
        
        this.pocetVlajok = this.hra.getPocetMin();
        this.displej.zobrazPocetVlajok(this.pocetVlajok);
        
        this.cas = this.hra.getCas();
        this.displej.zobrazCas(this.cas);
    }
    
    /**
     * Metóda odpočítava alebo pripočítava čas poďla typu hry.
     */
    public void tik() {
        if (this.hra.getSpeciHra() && this.cas < 1) {
            this.hra.nastavStavHry(StavHry.PREHRA_SPECIHRA);
            this.nastavKoniecHry();
        } else if (!(this.koniecHry) && !(this.prvyTah) && this.hra.getSpeciHra() && this.cas > 0) {
            this.cas -= 1;
            this.displej.zobrazCas(this.cas);
        } else if (!(this.koniecHry) && !(this.prvyTah)) {
            this.cas += 1;
            this.displej.zobrazCas(this.cas);
        }
    }
    
    /**
     * Metóda odkryje políčko.
     */
    public void odkryPolicko(int x, int y) {
        int riadok = y / this.STRANA;
        int stlpec = x / this.STRANA;
        if (this.skontrolujPolicko(riadok, stlpec) && !(this.displej.jeViditelnaVlajka(riadok, stlpec))) {
            this.urobTah(riadok, stlpec);
        }
    }
    
    /**
     * Metóda označí políčko vlajkou.
     */
    public void oznacPolicko(int x, int y) {
        int riadok = y / this.STRANA;
        int stlpec = x / this.STRANA;
        if (this.skontrolujPolicko(riadok, stlpec) && !(this.odkryvanie.getJePolickoOdkryte(riadok, stlpec))) {
            this.nastavVlajku(riadok, stlpec);
        }   
    }
    
    /**
     * Metóda skontroluje či dané políčko existuje na hracej ploche.
     */
    public boolean skontrolujPolicko(int riadok, int stlpec) {
        return riadok < this.hra.getPocetRiadkov() && stlpec < this.hra.getPocetStlpcov();
    }
    
    /**
     * Metóda zobrazí alebo skryje vlajku na požadovanom mieste. 
     * Pri specialnej hre pridá alebo zoberie čas poďla spravnosti položenia vlajky.
     */
    public void nastavVlajku(int riadok, int stlpec) {
        if (this.displej.jeViditelnaVlajka(riadok, stlpec)) {
            this.displej.skryVlajku(riadok, stlpec);
            this.pocetVlajok += 1;
            this.displej.zobrazPocetVlajok(this.pocetVlajok);
        } else {
            this.displej.zobrazVlajku(riadok, stlpec);
            this.pocetVlajok -= 1;
            if (this.hra.getSpeciHra() && this.pole.getHodnotaPola(riadok, stlpec) == -1) {
                this.cas += 5;
            } else if (this.hra.getSpeciHra() && this.pole.getHodnotaPola(riadok, stlpec) != -1) {
                this.cas -= 10;
                this.pocetVlajok += 1;
                this.displej.skryVlajku(riadok, stlpec);
            }
            this.displej.zobrazPocetVlajok(this.pocetVlajok);
        }
    }
    
    /**
     * Metóda skontroluje, či pri ťahu neukončil hru a pri prvom ťahu vytvára hracie pole.
     */
    public void urobTah(int riadok, int stlpec) {
        if (this.prvyTah) {
            this.hra.vygenerujPole(riadok, stlpec);
            this.hra.nastavStavHry(StavHry.NEROZHODNUTA);
            this.prvyTah = false;
        }
        this.odkryvanie.odkryPolicka(riadok, stlpec);
        if (this.pole.getHodnotaPola(riadok, stlpec) == -1) {
            this.hra.nastavStavHry(StavHry.PREHRA);
            this.nastavKoniecHry();
        } else if (this.overVyhru()) {
            this.hra.nastavStavHry(StavHry.VYHRA);
            this.nastavKoniecHry();
        }
    }
    
    /**
     * Metóda overuje výhru.
     */
    public boolean overVyhru() {
        for (int riadok = 0; riadok < this.hra.getPocetRiadkov(); riadok++) {
            for (int stlpec = 0; stlpec < this.hra.getPocetStlpcov(); stlpec++) {
                if ( !(this.odkryvanie.getJePolickoOdkryte(riadok, stlpec)) && this.pole.getHodnotaPola(riadok, stlpec) > -1) {
                    return false;
                } 
            }
        }
        return true;
    }
    
    /**
     * Metóda nastaví koniec.
     */
    private void nastavKoniecHry() {
        this.koniecHry = true;
        this.manazer.prestanSpravovatObjekt(this);
    }
}
