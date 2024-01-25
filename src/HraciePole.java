import java.util.Random;
/**
 * Trieda, ktorá vytvára hraciu plochu.
 * 
 * @author Juraj Dostál
 */
public class HraciePole {
    
    private int[][] hraciePole;
    
    /**
     * Konštruktor vytvára atribút hraciePole.
     */
    public HraciePole(Minesweeper hra) {
        this.hraciePole = new int[hra.getPocetRiadkov()][hra.getPocetStlpcov()];
    }
    
    /**
     * Metóda vráti hodnotu daného políčka.
     */
    public int getHodnotaPola(int riadok, int stlpec) {
        return this.hraciePole[riadok][stlpec];
    }
    
    /**
     * Metóda vygeneruje míny.
     * Hodnota -1 znamená, že sa na danom políčku nachádza mína.
     */
    public void vygenerujMiny(int pocetMin, int riad, int stlp) {
        Random generator = new Random();
        int index = 0;
        while (index < pocetMin) {
            int riadok = generator.nextInt(this.hraciePole.length);
            int stlpec = generator.nextInt(this.hraciePole[0].length);
            
            if (this.hraciePole[riadok][stlpec] != -1 && riadok != riad && stlpec != stlp) {
                this.hraciePole[riadok][stlpec] = -1;
                index++;
            } 
        }
        
    }
    
    /**
     * Metóda zistí koľko mín sa nachádza okolo políčka.
     */
    public void vygenerujPole() {
        int pocetMin; //hodnota, ktorá udáva počet mín okolo políčka
        for (int riadok = 0; riadok < this.hraciePole.length; riadok++) {
            for (int stlpec = 0; stlpec < this.hraciePole[riadok].length; stlpec++) {
                pocetMin = 0;
                if (this.hraciePole[riadok][stlpec] != -1) {
                    if (riadok > 0) {
                        if (this.hraciePole[riadok - 1][stlpec] == -1) {
                            pocetMin++;
                        }
                        if (stlpec > 0 && this.hraciePole[riadok - 1][stlpec - 1] == -1) {
                            pocetMin++;                            
                        }
                    }
                    if (riadok < this.hraciePole.length - 1) {
                        if (this.hraciePole[riadok + 1][stlpec] == -1) {
                            pocetMin++;
                        }
                        if (stlpec < this.hraciePole[riadok].length - 1 && this.hraciePole[riadok + 1][stlpec + 1] == -1) {
                            pocetMin++;                            
                        }
                    }
                    if (stlpec > 0) {
                        if (this.hraciePole[riadok][stlpec - 1] == -1) {
                            pocetMin++;
                        }
                        if (riadok < this.hraciePole.length - 1 && this.hraciePole[riadok + 1][stlpec - 1] == -1) {
                            pocetMin++;                            
                        }
                    }
                    if (stlpec < this.hraciePole[riadok].length - 1) {
                        if (this.hraciePole[riadok][stlpec + 1] == -1) {
                            pocetMin++;
                        }
                        if (riadok > 0 && this.hraciePole[riadok - 1][stlpec + 1] == -1) {
                            pocetMin++;                            
                        }
                    }
                    this.hraciePole[riadok][stlpec] = pocetMin;
                }
            }
        }
    }
}
