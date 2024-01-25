import fri.shapesge.Stvorec;
/**
 * Trieda Policko vytvára na hraciom displeji na plátne štvorec.
 * 
 * @author Juraj Dostál
 */

public class Policko {
    
    private Stvorec policko;
    
    /**
     * Konštruktor vytvára a nastavuje políčko.
     */
    public Policko(int strana, int polohaX, int polohaY) {
        this.policko = new Stvorec();
        
        this.policko.zmenStranu(strana - 2);
        this.policko.zmenFarbu("gray");
        this.policko.posunVodorovne(polohaX - 60 + 2);
        this.policko.posunZvisle(polohaY - 50 + 2);
        this.zobraz();
    }
    
    /**
     * Metóda zobrazí políčko.
     */
    public void zobraz() {
        this.policko.zobraz();
    }
    
    /**
     * Metóda skryje políčko.
     */
    public void skry() {
        this.policko.skry();
    }
}
