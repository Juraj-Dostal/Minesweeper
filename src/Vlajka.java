import fri.shapesge.Obrazok;
/**
 * Trieda Vlajka slúži na označenie míny.
 * 
 * @author Juraj Dostál 
 */
public class Vlajka {
    
    private Obrazok vlajka;
    
    /**
     * Konštruktor vytvára a nastavuje vlajku.
     */
    public Vlajka(int polohaX, int polohaY) {
        this.vlajka = new Obrazok("pics/vlajka.png");
        this.vlajka.posunVodorovne(polohaX - 100);
        this.vlajka.posunZvisle(polohaY - 100);
        this.vlajka.zobraz();
    }
    
    /**
     * Metóda skryje vlajku.
     */
    public void skry() {
        this.vlajka.skry();
    }
}
