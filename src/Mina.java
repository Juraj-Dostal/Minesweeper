import fri.shapesge.Stvorec;
import fri.shapesge.Kruh;
/**
 * Mína je trieda, ktorá vytvára grafické znázornenie míny na hraciom displeji.
 * 
 * @author Juraj Dostál
 */
public class Mina {
    
    private Stvorec pozadie;
    private Kruh mina;
    
    /**
     * Konštruktor vytvára a nastavuje jednotlivé časti míny.
     */
    public Mina(int priemer, int strana, int polohaX, int polohaY) {
        this.mina = new Kruh();
        this.pozadie = new Stvorec();
        
        this.mina.zmenFarbu("black");
        this.mina.zmenPriemer(priemer);
        this.mina.posunVodorovne(((strana - priemer) / 2) + polohaX - 20);
        this.mina.posunZvisle(((strana - priemer) / 2) + polohaY - 60);
        this.pozadie.zmenFarbu("red");
        this.pozadie.zmenStranu(strana);
        this.pozadie.posunVodorovne(polohaX - 60);
        this.pozadie.posunZvisle(polohaY - 50);
        this.zobrazMinu();
    }
    
    /**
     * Metóda zobrazí mínu.
     */
    public void zobrazMinu() {
        this.pozadie.zobraz();
        this.mina.zobraz();
    }
    
    /**
     * Metóda skryje mínu.
     */
    public void skryMinu() {
        this.pozadie.skry();
        this.mina.skry();
    }   
}
