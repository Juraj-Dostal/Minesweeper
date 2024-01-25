
/**
 * Enum StavHry slúži na označenie v akom stave je hra.
 * 
 * @author Juraj Dostál
 */
public enum StavHry {
    NEZACALA,
    NEROZHODNUTA,
    VYHRA("Vyhral si!!!"),
    PREHRA("Nasiel si minu, prehral si :("),
    PREHRA_SPECIHRA("Nestihol si pozadovanom case :(");
    
    private String text;
    
    /**
     * Konštruktor vytvára inštanciu.
     */
    StavHry() {
    }
    
    /**
     * Konštruktor vytvára inštanciu a nastavuje atribút.
     */
    StavHry(String text) {
        this.text = text;
    }
    
    /**
     * Metóda vráti hodnotu daného atribútu.
     */
    public String getText() {
        return this.text;
    }
}
