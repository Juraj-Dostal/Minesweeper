import java.util.ArrayList;
/**
 * Trieda hrací displej vytvára celkové grafická hrozhranie na hru.
 * 
 * @author Juraj Dostál
 */
public class HraciDisplej {
   
    private Policko[][] policka;
    private Vlajka[][] vlajky;
    
    private static final int STRANA = 25;
    private static final int PRIEMER = 20;
    private static final int SIRKA = 2;
    private static final int DLZKA = 7;
    
    private HraciePole hraciePole;
    
    private Displej casovac;
    private Displej pocetVlajok;
    
    private ArrayList<SedemSegmentovyDisplej> zoznamCisiel;
    private ArrayList<Mina> zoznamMin;
    
    /**
     * Konštruktor vytvára celkový grafický vystup.
     */
    public HraciDisplej(Minesweeper hra) {
        this.policka = new Policko[hra.getPocetRiadkov()][hra.getPocetStlpcov()];
        this.vlajky = new Vlajka[hra.getPocetRiadkov()][hra.getPocetStlpcov()];
        
        this.hraciePole = hra.getHraciePole();
        
        this.casovac = new Displej(100, 600);
        this.pocetVlajok = new Displej(500, 600);
        
        this.zoznamCisiel = new ArrayList<SedemSegmentovyDisplej>();
        this.zoznamMin = new ArrayList<Mina>();
        
        for (int riadok = 0;  riadok < this.policka.length ; riadok++ ) {
            for (int stlpec = 0; stlpec < this.policka[riadok].length ; stlpec++) {
                this.policka[riadok][stlpec] = new Policko(this.STRANA, this.STRANA * stlpec , this.STRANA * riadok);
            }
        }
        
    }
    
    /**
     * Metóda odkryje políčko a ukáže čo sa nachádza na danom mieste.
     */
    public void odkryPolicko(int riadok, int stlpec) {
        this.policka[riadok][stlpec].skry();
        int hodnota = this.hraciePole.getHodnotaPola(riadok, stlpec);
        if (hodnota == -1) {
            this.zoznamMin.add(new Mina(this.PRIEMER, this.STRANA, this.STRANA * stlpec, this.STRANA * riadok));
        } else if (0 < hodnota && hodnota < 9) {
            this.zoznamCisiel.add(new SedemSegmentovyDisplej(this.STRANA, this.STRANA * stlpec, this.STRANA * riadok, this.SIRKA, this.DLZKA, hodnota, true));
        } 
    }
    
    /**
     * Metóda zobrazí vlajku.
     */
    public void zobrazVlajku(int riadok, int stlpec) {
        this.vlajky[riadok][stlpec] = new Vlajka(this.STRANA * stlpec, this.STRANA * riadok);
    }
    
    /**
     * Metóda skryje vlajku.
     */
    public void skryVlajku(int riadok, int stlpec) {
        this.vlajky[riadok][stlpec].skry();
        this.vlajky[riadok][stlpec] = null;
    }
    
    /**
     * Metóda zistuje, či sa na danóm políčku nachádza vlajka.
     */
    public boolean jeViditelnaVlajka(int riadok, int stlpec) {
        return this.vlajky[riadok][stlpec] != null;
    }
    
    /**
     * Metóda zobrazí čas displeji.
     */
    public void zobrazCas(int cas) {
        this.casovac.zobrazHodnotu(cas);
    }
    
    /**
     * Metóda zobrazí počeť vlajok na displeji.
     */
    public void zobrazPocetVlajok (int pocetVlajok) {
        this.pocetVlajok.zobrazHodnotu(pocetVlajok);
    }
    
    /**
     * Metóda všetky inštancie dá skryť.
     */
    public void vycistiPlochu() {
        for (Mina aktualna : this.zoznamMin) {
            aktualna.skryMinu();
        }
        for (SedemSegmentovyDisplej aktualny : this.zoznamCisiel) {
            aktualny.vymazVsetko();
        }
        this.casovac.vymaz();
        this.pocetVlajok.vymaz();
        for (int riadok = 0;  riadok < this.policka.length ; riadok++ ) {
            for (int stlpec = 0; stlpec < this.policka[riadok].length ; stlpec++) {
                this.policka[riadok][stlpec].skry();
            }
        }
        for (int riadok = 0;  riadok < this.vlajky.length ; riadok++ ) {
            for (int stlpec = 0; stlpec < this.vlajky[riadok].length ; stlpec++) {
                if (this.vlajky[riadok][stlpec] != null) {
                    this.vlajky[riadok][stlpec].skry();
                }
            }
        }
    }
}
