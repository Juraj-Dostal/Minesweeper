import javax.swing.JOptionPane;
/**
 * Trieda, ktorá spravuje celú hru.
 * 
 * @author Juraj Dostál
 */
public class Minesweeper {
    private HraciePole pole;
    private HraciDisplej displej;
    private OdkryvaniePolicok odkryvanie;
    private Tah tah;
    private StavHry stavHry;
    
    private int pocetMin;
    private int pocetRiadkov;
    private int pocetStlpcov;
    private int cas;
    private boolean speciHra;
    
    /**
     * Konštruktor vytvára inštanciu hry, kde sa počíta čas.
     */
    public Minesweeper(int pocetRiadkov, int pocetStlpcov, int pocetMin) {
        this.pocetMin = pocetMin;
        this.pocetRiadkov = pocetRiadkov;
        this.pocetStlpcov = pocetStlpcov;
        this.cas = 0;
        this.speciHra = false;
        
        this.pole = new HraciePole(this);
        this.displej = new HraciDisplej(this);
        this.odkryvanie = new OdkryvaniePolicok(this);
        this.tah = new Tah(this);
        this.stavHry = StavHry.NEZACALA;
    }
    
    /**
     * Konštruktor vytvára inštanciu hry, kde sa odpočíta čas.
     */
    public Minesweeper(int pocetRiadkov, int pocetStlpcov, int pocetMin, int cas) {
        this.pocetMin = pocetMin;
        this.pocetRiadkov = pocetRiadkov;
        this.pocetStlpcov = pocetStlpcov;
        this.cas = cas;
        this.speciHra = true;
        
        this.pole = new HraciePole(this);
        this.displej = new HraciDisplej(this);
        this.odkryvanie = new OdkryvaniePolicok(this);
        this.tah = new Tah(this);
        this.stavHry = StavHry.NEZACALA;
    }
    
    /**
     * Metóda vráti hodnotu atribútu.
     */
    public int getPocetRiadkov() {
        return this.pocetRiadkov;
    }
    
    /**
     * Metóda vráti hodnotu atribútu.
     */
    public int getPocetStlpcov() {
        return this.pocetStlpcov; 
    }
    
    /**
     * Metóda vráti hodnotu atribútu.
     */
    public int getPocetMin() {
        return this.pocetMin;
    }
    
    /**
     * Metóda vráti hodnotu atribútu.
     */
    public int getCas() {
        return this.cas;
    }
    
    /**
     * Metóda vráti hodnotu atribútu.
     */
    public boolean getSpeciHra() {
        return this.speciHra;
    }
    
    /**
     * Metóda vráti referenciu na inštanciu.
     */
    public StavHry getStavHry() {
        return this.stavHry;
    }
    
    /**
     * Metóda vráti referenciu na inštanciu.
     */
    public HraciePole getHraciePole() {
        return this.pole;
    }
    
    /**
     * Metóda vráti referenciu na inštanciu.
     */
    public HraciDisplej getHraciDisplej() {
        return this.displej;
    }
    
    /**
     * Metóda vráti referenciu na inštanciu.
     */
    public OdkryvaniePolicok getOdkryvaniePolicok() {
        return this.odkryvanie;
    }
    
    /**
     * Metóda vygeneruje hracie pole.
     */
    public void vygenerujPole(int riadok, int stlpec) {
        this.pole.vygenerujMiny(this.pocetMin, riadok, stlpec);
        this.pole.vygenerujPole();
    }
    
    /**
     * Metóda nastavuje atribút stavHra a podľa podmienky pošle správu užívateľovi.
     */
    public void nastavStavHry(StavHry stavHry) {
        this.stavHry = stavHry;
        if (this.stavHry == StavHry.PREHRA || this.stavHry == StavHry.PREHRA_SPECIHRA || this.stavHry == StavHry.VYHRA) {
            this.posliSpravu();
        }
    }
    
    /**
     * Metóda pošle správu užívateľovi.
     */
    private void posliSpravu() {
        JOptionPane.showMessageDialog(null, this.stavHry.getText());
    }
    
    /**
     * Metóda vyčistí hraciu plochu.
     */
    public void upracDisplej() {
        this.displej.vycistiPlochu();
    }
    
    /**
     * Metóda vracia vyhodnotenie podmienky.
     */
    public boolean skoncilaHra() {
        if (this.stavHry == StavHry.NEROZHODNUTA || this.stavHry == StavHry.NEZACALA) {
            return false;
        }
        return true;
    }
}
