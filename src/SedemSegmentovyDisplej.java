/**
 * Trieda sedem segmentový displej vytvára pomocou segmentu takzvaný displej, ktorý zobrazí hodnotu od 0 po 9.
 * 
 * @author Juraj Dostál
 * !!! robené na cvičení
 */
public class SedemSegmentovyDisplej {
    
    private Segment[] displej;
    
    /**
     * Konštruktor vytvára jednotlive segmenty displeja a nastavuje ich.
     */
    public SedemSegmentovyDisplej(int strana, int polohaX, int polohaY, int sirka, int dlzka, int cislo, boolean oznacujePocetMin) {
        int x = polohaX + ((strana - (( 2 * sirka ) + dlzka)) / 2);
        int y = polohaY + ((strana - (( 3 * sirka ) + (2 * dlzka))) / 2);
        
        this.displej = new Segment[7];
        
        for (int i = 0; i < this.displej.length; i++) {
            this.displej[i] = new Segment();
        }
        
        this.displej[0].nastavVelkost(dlzka, sirka);
        this.displej[0].nastavPoziciu(x + sirka, y);
        
        this.displej[1].nastavVelkost(sirka, dlzka);
        this.displej[1].nastavPoziciu(x + sirka + dlzka, y + sirka);
        
        this.displej[2].nastavVelkost(sirka, dlzka);
        this.displej[2].nastavPoziciu(x + sirka + dlzka, y + (2 * sirka) + dlzka);
        
        this.displej[3].nastavVelkost(dlzka, sirka);
        this.displej[3].nastavPoziciu(x + sirka, y + 2 * (sirka + dlzka));
        
        this.displej[4].nastavVelkost(sirka, dlzka);
        this.displej[4].nastavPoziciu(x, y + (2 * sirka) + dlzka);
       
        this.displej[5].nastavVelkost(sirka, dlzka);
        this.displej[5].nastavPoziciu(x, y + sirka);
        
        this.displej[6].nastavVelkost(dlzka, sirka);
        this.displej[6].nastavPoziciu(x + sirka, y + sirka + dlzka);
        
        this.nastavFarbu(this.vyberFarbu(cislo, oznacujePocetMin));
        this.zobrazCislo(cislo);
    }
    
    /**
     * Metóda zobrazí všetky segmenty.
     */
    public void zapniVsetko() {
        for (int i = 0; i < this.displej.length; i++) {
            this.displej[i].zapni();
        }
    }
    
    /**
     * Metóda skryje všetky segmenty.
     */
    public void vypniVsetko() {
        for (int i = 0; i < this.displej.length; i++) {
            this.displej[i].vypni();
        }
    }
    
    /**
     * Metóda vymaže všetky segmenty.
     */
    public void vymazVsetko() {
        for (int i = 0; i < this.displej.length; i++) {
            this.displej[i].vymaz();
        }
    }
    
    /**
     * Metóda nastavuje jednotlive segmenty podľa toho ake číslo ma zobraziť.
     */
    public void zobrazCislo(int cislo) {
               
        switch (cislo) {
            case 0:
                this.zapniVsetko();
                this.displej[6].vypni();
                break;
            case 1:
                this.vypniVsetko();
                this.displej[1].zapni();
                this.displej[2].zapni();
                break;
            case 2:
                this.zapniVsetko();
                this.displej[2].vypni();
                this.displej[5].vypni();
                break;
            case 3:
                this.zapniVsetko();
                this.displej[4].vypni();
                this.displej[5].vypni();
                break;
            case 4:
                this.vypniVsetko();
                this.displej[5].zapni();
                this.displej[1].zapni();
                this.displej[6].zapni();
                this.displej[2].zapni();
                break;
            case 5:
                this.zapniVsetko();
                this.displej[1].vypni();
                this.displej[4].vypni();
                break;
            case 6:
                this.zapniVsetko();
                this.displej[1].vypni();
                break;
            case 7:
                this.vypniVsetko();
                this.displej[0].zapni();
                this.displej[1].zapni();
                this.displej[2].zapni();
                break;
            case 8:
                this.zapniVsetko();
                break;
            case 9:
                this.zapniVsetko();
                this.displej[4].vypni();
                break;
            default: 
                this.vypniVsetko();
                break;
        }
        
    }
    
    /**
     * Metóda nastavuje všetkým segmentom farbu.
     */
    private void nastavFarbu(String farba) {
        for (Segment aktualny : this.displej) {
            aktualny.nastavFarbu(farba);
        }
    }
    
    /**
     * Metóda vyberá farbu podla hodnoty čísla pokiaľ označuje počet mín v okolí polička. 
     */
    private String vyberFarbu(int cislo, boolean oznacujePocetMin) {
        if (oznacujePocetMin) {       
            switch (cislo) {
                case 1:
                    return "blue";
                case 2:
                    return "green";
                case 3:
                    return "red";
                case 4:
                    return "cyan";
                case 5:
                    return "orange";
                case 6:
                    return "magenta";
                case 7:
                    return "gray";
                case 8:
                    return "black";
                default:
                    return "black";
            }
        } else {
            return "red";
        }
    }
}
