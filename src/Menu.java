import javax.swing.JOptionPane;

/**
 * Trieda vytvára menu hry a danú hru.
 * 
 * @author Juraj Dostál
 */
public class Menu {
    private Minesweeper hra;
    
    /**
     * Konštruktor vytvára inštanciu.
     */
    public Menu() {
        this.hra = null;
        int chceHrat = JOptionPane.showConfirmDialog(null, "Chceš hrať?");
                
        if (chceHrat == 0) {
            this.vyberObtaznost(); 
        }
    }
    
    /**
     * Metóda slúži na výber obtiažnosti.
     */
    private void vyberObtaznost() {
        int lahkaObtaznost = JOptionPane.showConfirmDialog(null, "Chceš ľahkú obťažnosť?");
        if (lahkaObtaznost == 0) {
            int speciHra = JOptionPane.showConfirmDialog(null, "Chceš špeciálnu hru?\n Musíš do určitého času odkryť hraciu plochu bez odkrytia míny.\n Nájdením míny sa ti pridá čas ale ak zle označíš tak sa ti odoberie. ");
            if (speciHra == 0) {
                this.hra = new Minesweeper(9, 9, 10, 30);
            } else if (speciHra == 1) {
                this.hra = new Minesweeper(9, 9, 10);
            } else if (speciHra == 2) { 
                return;
            }  
            return;
        } else if (lahkaObtaznost == 2) {
            return;
        }
        int strednaObtaznost = JOptionPane.showConfirmDialog(null, "Chceš strednú obťažnosť?");
        if (strednaObtaznost == 0) {
            int speciHra = JOptionPane.showConfirmDialog(null, "Chceš špeciálnu hru?\n Musíš do určitého času odkryť hraciu plochu bez odkrytia míny.\n Nájdením míny sa ti pridá čas ale ak zle označíš tak sa ti odoberie. ");
            if (speciHra == 0) {
                this.hra = new Minesweeper(16, 16, 40, 60);
            } else if (speciHra == 1) {
                this.hra = new Minesweeper(16, 16, 40);
            } else if (speciHra == 2) { 
                return;
            }     
            return;
        } else if (strednaObtaznost == 2) {
            return;
        }
        int tazkaObtaznost = JOptionPane.showConfirmDialog(null, "Chceš ťažkú obťažnosť?");
        if (tazkaObtaznost == 0) {
            int speciHra = JOptionPane.showConfirmDialog(null, "Chceš špeciálnu hru?\n Musíš do určitého času odkryť hraciu plochu bez odkrytia míny.\n Nájdením míny sa ti pridá čas ale ak zle označíš tak sa ti odoberie. ");
            if (speciHra == 0) {
                this.hra = new Minesweeper(16, 30, 99, 90);
            } else if (speciHra == 1) {
                this.hra = new Minesweeper(16, 30, 99);
            } else if (speciHra == 2) { 
                return;
            } 
            return;
        } else if (tazkaObtaznost == 2) {
            return;
        }
        int vlastnaObtaznost = JOptionPane.showConfirmDialog(null, "Chceš vlastnú obťažnosť? ");
        if (vlastnaObtaznost == 0) {
            this.vlastnaObtiaznost();
            return;
        } else if (vlastnaObtaznost == 2) {
            return;
        }
        int chceObtaznost = JOptionPane.showConfirmDialog(null, "Chceš si znova vybrať obťažnosť?");
        if (chceObtaznost == 0) {
            this.vyberObtaznost();
        }
    }
    
    /**
     * Metóda nastavuje a kontroluje zadané hodnoty na vytvorenie vlastnej obtiažnosti.
     */
    private void vlastnaObtiaznost() {
        int pocetRiadkov;
        int pocetStlpcov;
        int pocetMin;
        do {
            pocetRiadkov = Integer.parseInt(JOptionPane.showInputDialog(null, "Pocet riadkov? (maximalne 24)"));
        } while (this.skontrolujPocet(pocetRiadkov, 24));
        
        do {
            pocetStlpcov = Integer.parseInt(JOptionPane.showInputDialog(null, "Pocet stlpcov? (maximalne 30)"));
        } while (this.skontrolujPocet(pocetStlpcov, 30));
        
        do {
            pocetMin = Integer.parseInt(JOptionPane.showInputDialog(null, "Pocet min? (maximalne 667)"));
        } while (this.skontrolujPocet(pocetMin, 667));
        this.hra = new Minesweeper(pocetRiadkov, pocetStlpcov, pocetMin);
    }
    
    /**
     * Metóda skontroluje zadanú hodnotu.
     */
    private boolean skontrolujPocet(int pocet, int maxPocet) {
        if (0 < pocet && pocet < maxPocet + 1) {
            return false;
        }
        JOptionPane.showMessageDialog(null, "Zadaj cislo od 1 do " + maxPocet + " znova.");
        return true;
    }
}
