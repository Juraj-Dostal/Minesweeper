/**
 * Trieda Displej vytvára displej na zobrazovanie hodnoty, pomocou triedy SedemSegmentovyDisplej. 
 * 
 * @author Juraj Dostál
 */
public class Displej {
    
    private SedemSegmentovyDisplej[] displej;
    
    /**
     * Konštruktor vytvára tri sedem segmentové displeje.
     */
    public Displej(int polohaX, int polohaY) {
        this.displej = new SedemSegmentovyDisplej[3];
        for (int i = 0; i < this.displej.length; i++) {
            this.displej[i] = new SedemSegmentovyDisplej(50, polohaX + ( i * 30 ), polohaY, 5, 15, 0, false);
        }
    }
    
    /**
     * Metóda vráti hodnotu parametra.
     */
    public void zobrazHodnotu(int hodnota) {
        int cislo;
        if (-1 < hodnota && hodnota < 1000) {
            cislo = hodnota;
        } else if (hodnota > 999) {
            cislo = 999;
        } else {
            cislo = 0;
        }
        
        for (int i = 0; i < this.displej.length; i++) {
            int delitel = 1;
            for (int index = 0; index < this.displej.length - i - 1; index++) {
                delitel *= 10;
            }
            this.displej[i].zobrazCislo(cislo % (10 * delitel) / delitel);
        }
    }
    
    /**
     * Metóda skryje displej.
     */
    public void vymaz() {
        for (int i = 0; i < this.displej.length; i++) {
            this.displej[i].vymazVsetko();
        }
    }
}
