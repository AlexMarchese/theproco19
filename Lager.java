
/**
 * Die Klasse Lager umfasst die Informationen zu den von der Fabrik benötigten Materialien 
 * und die dazugehörigen Methoden um das Lager zu verwalten.
 * 
 * 
 * @author GBI Gruppe 19
 * @version 1.0
 * 
 */

public class Lager{
    // Instanzvariablen
    int maxHolzeinheiten;
    int maxSchrauben;
    int maxFarbeeinheiten;
    int maxKartoneinheiten;
    int maxKissen;
    int vorhandeneHolzeinheiten;
    int vorhandeneSchrauben;
    int vorhandeneFarbeeinheiten;
    int vorhandeneKartoneinheiten;
    int vorhandeneKissen;
    Lieferant lieferant; 
    int benötigteHolzeinheiten;
    int benötigteSchrauben;
    int benötigteFarbeinheiten;
    int benötigteKartoneinheiten;
    int benötigteKissen; 

    /**
     * Konstruktor für Objekte der Klasse Lager
     *@param    maxHolzeinheiten            Die maximale Kapazität des Lagers für Holzeinheiten.
     *@param    maxSchrauben                Die maximale Kapazität des Lagers für Schrauben. 
     *@param    maxFarbeeinheiten           Die maximale Kapazität des Lagers für Farbeinheiten.
     *@param    maxKartoneinheiten          Die maximale Kapazität des Lagers für Kartoneinheiten.
     *@param    maxKissen                   Die maximale Kapazität des Lagers für Kissen.
     *@param    vorhandeneHolzeinheiten     Die aktuelle Anzahl Holzeinheiten im Lager.
     *@param    vorhandenSchrauben          Die aktuelle Anzahl Schrauben im Lager.
     *@param    vorhandeneFarbeeinheiten    Die aktuelle Anzahl Farbeinheiten im Lager.
     *@param    vorhandeneKartoneinheiten   Die aktuelle Anzahl Kartoneinheiten im Lager.
     *@param    vorhandeneKissen            Die aktuelle Anzahl Kissen im Lager. 
     */
    public Lager(int maxHolzeinheiten, int maxSchrauben, int maxFarbeeinheiten, int maxKartoneinheiten,int maxKissen, int vorhandeneHolzeinheiten, int vorhandenSchrauben, int vorhandeneFarbeeinheiten, int vorhandeneKartoneinheiten, int vorhandeneKissen) {
        // Instanzvariable initialisieren
        this.maxHolzeinheiten = maxHolzeinheiten;
        this.maxSchrauben = maxSchrauben;
        this.maxFarbeeinheiten = maxFarbeeinheiten;
        this.maxKartoneinheiten = maxKartoneinheiten;
        this.maxKissen = maxKissen;
        this.vorhandeneHolzeinheiten = vorhandeneHolzeinheiten;
        this.vorhandeneSchrauben = vorhandenSchrauben;
        this.vorhandeneFarbeeinheiten = vorhandeneFarbeeinheiten;
        this.vorhandeneKartoneinheiten = vorhandeneKartoneinheiten;
        this.vorhandeneKissen = vorhandeneKissen;
        this.benötigteHolzeinheiten = 0;
        this.benötigteSchrauben = 0;
        this.benötigteFarbeinheiten = 0;
        this.benötigteKartoneinheiten = 0;
        this.benötigteKissen = 0; 
    }


    /// Getters und Setters


    /**
     * Methode, um die maximale Lagerkapazität an Holzeinheiten anzupassen.
     * @param   maxHolzeinheiten    Die maximale Anzahl Holzeinheiten in numerischer Form (Lagerkapazität).
     */
    public void setzemaxHolzeinheiten(int maxHolzeinheiten) {
        this.maxHolzeinheiten = maxHolzeinheiten;
    }
    
    /**
     * Methode, um die momentane Anzahl an Holzeinheiten im Lager auszugeben.
     * @return   vorhandeneHolzeinheiten    Die momentane Anzahl an Holzeinheiten im Lager in numerischer Form.
     */
    public int gibvorhandeneHolzeinheiten() {
        return this.vorhandeneHolzeinheiten;
    }

    /**
     * Methode, um die maximale Lagerkapazität an Schrauben anzupassen.
     * @param   maxSchrauben    Die maximale Anzahl Schrauben in numerischer Form (Lagerkapazität).
     */
    public void setzemaxSchrauben(int maxSchrauben) {
        this.maxSchrauben = maxSchrauben;
    }
    
    /**
     * Methode, um die momentane Anzahl an Schrauben im Lager auszugeben.
     * @return   vorhandeneSchrauben    Die momentane Anzahl an Schrauben im Lager in numerischer Form.
     */
    public int gibvorhandeneSchrauben() {
        return this.vorhandeneSchrauben;
    }

    /**
     * Methode, um die maximale Lagerkapazität an Farbeeinheiten anzupassen.
     * @param   maxFarbeeinheiten    Die maximale Anzahl Farbeeinheiten in numerischer Form (Lagerkapazität).
     */
    public void setzemaxFarbeeinheiten(int maxFarbeeinheiten) {
        this.maxFarbeeinheiten = maxFarbeeinheiten;
    }
    
    /**
     * Methode, um die momentane Anzahl an Farbeeinheiten im Lager auszugeben.
     * @return   vorhandeneFarbeeinheiten    Die momentane Anzahl an Farbeeinheiten im Lager in numerischer Form.
     */
    public int gibvorhandeneFarbeeinheiten() {
        return this.vorhandeneFarbeeinheiten;
    } 
    
    /**
     * Methode, um die maximale Lagerkapazität an Kartoneinheiten anzupassen.
     * @param   maxKartoneinheiten    Die maximale Anzahl Kartoneinheiten in numerischer Form (Lagerkapazität).
     */
    public void setzemaxKartoneinheiten(int maxKartoneinheiten) {
        this.maxKartoneinheiten = maxKartoneinheiten;
    }
    
    /**
     * Methode, um die momentane Anzahl an Kartoneinheiten im Lager auszugeben.
     * @return   vorhandeneKartoneinheiten    Die momentane Anzahl an Kartoneinheiten im Lager in numerischer Form.
     */
    public int gibvorhandeneKartoneinheiten() {
        return this.vorhandeneKartoneinheiten;
    }   
    
    /**
     * Methode, um die maximale Lagerkapazität an Kissen anzupassen.
     * @param   maxKissen    Die maximale Anzahl Kissen in numerischer Form (Lagerkapazität).
     */
    public void setzemaxKissen(int maxKissen) {
        this.maxKissen = maxKissen;
    }
    
    /**
     * Methode, um die momentane Anzahl an Kissen im Lager auszugeben.
     * @return   vorhandeneKissen    Die momentane Anzahl an Kissen im Lager in numerischer Form.
     */
    public int gibvorhandeneKissen() {
        return this.vorhandeneKissen;
    }     
    
    
    /// Methoden


    /**
     * Methode, berechneBeschaffungsZeit schaut für eine Bestellung alle Produkte an und addiert die benötigten Materialien, wenn diese im Lager vorhanden sind 
     * bleibt die BeschaffungsZeit bei 0 anderenfalls erhöht sie sich auf 2. 
     * 
     * @return   beschaffungszeit    0 oder 2 für die Anzahl Tage an Beschaffungszeit
     * 
    */
    public int berechneBeschaffungsZeit(Bestellung kundenBestellung) {      
        
        int beschaffungszeit = 0;
          

        for (Produkt produkt : kundenBestellung.gibBestellteProdukte()) {
            if (produkt instanceof Stuhl) {
               benötigteHolzeinheiten += produkt.gibHolzeinheiten();
               benötigteSchrauben += produkt.gibSchrauben();
               benötigteFarbeinheiten += produkt.gibFarbeinheiten();
               benötigteKartoneinheiten += produkt.gibKartoneinheiten();

            } else if (produkt instanceof Sofa) {
               benötigteHolzeinheiten += produkt.gibHolzeinheiten();
               benötigteSchrauben += produkt.gibSchrauben();
               benötigteFarbeinheiten += produkt.gibFarbeinheiten();
               benötigteKartoneinheiten += produkt.gibKartoneinheiten();
               benötigteKissen = benötigteKissen + ((Sofa) produkt).gibKissen();              
                
            }
        }
            
        if (gibvorhandeneHolzeinheiten() < benötigteHolzeinheiten
              || gibvorhandeneSchrauben() < benötigteSchrauben
              || gibvorhandeneFarbeeinheiten() < benötigteFarbeinheiten 
              || gibvorhandeneKartoneinheiten() < benötigteKartoneinheiten
              || gibvorhandeneKissen() < benötigteKissen) {
              beschaffungszeit = 2;
        } else {beschaffungszeit = 0;}
            //muss man noch einen Stop (break) einbauen?? Glaube nicht, das braucht es doch nur bei while, falls es keine stop condition gibt (flo);
    
    return beschaffungszeit;
        
    }
    
    
    /**
     * Methode, lagerAuffuellen vergleicht ob die benötigten Materialien die maximale Lager Kapazität überschreiten und reduziert diese ggf und bestellt anschließend über den Methode wareBestellen die zu Bestellenden Materialien nach.
     * 
     * @param   lagerAuffuellen    Füllt den Lagerbestand. //WIESO? wo ist der param?
     * 
    */

    public void lagerAuffuellen() {
        Lieferant lieferant = new Lieferant();
        
        // Überprüfen, ob die Bestellmenge die Lagerkapazität überschreitet.
        if (gibvorhandeneHolzeinheiten() + benötigteHolzeinheiten > maxHolzeinheiten) {
            // Bestellmenge reduzieren, um die Lagerkapazität nicht zu überschreiten.
            benötigteHolzeinheiten = maxHolzeinheiten - gibvorhandeneHolzeinheiten();
        } 

        if (gibvorhandeneSchrauben() + benötigteSchrauben > maxSchrauben) {
            benötigteSchrauben = maxSchrauben - gibvorhandeneSchrauben();
        }

        if (gibvorhandeneFarbeeinheiten() + benötigteFarbeinheiten > maxFarbeeinheiten) {
            benötigteFarbeinheiten = maxFarbeeinheiten - gibvorhandeneFarbeeinheiten();
        }

        if (gibvorhandeneKartoneinheiten() + benötigteKartoneinheiten > maxKartoneinheiten) {
            benötigteKartoneinheiten = maxKartoneinheiten - gibvorhandeneKartoneinheiten();
        }

        if (gibvorhandeneKissen() + benötigteKissen > maxKissen) {
            benötigteKissen = maxKissen - gibvorhandeneKissen();
        }

        // Bestellung beim Lieferanten aufgeben und auf die Lieferung warten (2 Tage Lieferzeit).
        lieferant.wareBestellen(benötigteHolzeinheiten, benötigteSchrauben, benötigteFarbeinheiten, benötigteKartoneinheiten, benötigteKissen);

        // Lagerbestände aktualisieren.
        vorhandeneHolzeinheiten += benötigteHolzeinheiten;
        vorhandeneSchrauben += benötigteSchrauben;
        vorhandeneFarbeeinheiten += benötigteFarbeinheiten;
        vorhandeneKartoneinheiten += benötigteKartoneinheiten;
        vorhandeneKissen += benötigteKissen;
        
        // bwnötigte Einheiten zurücksetzen, um von 0 anzufangen.
        benötigteHolzeinheiten = 0;
        benötigteSchrauben = 0;
        benötigteFarbeinheiten = 0;
        benötigteKartoneinheiten = 0;
        benötigteKissen = 0;
    }
            
    /**
     * Die Methode lagerBestandAusgeben gibt den aktuellen Lagerbestand aus.
     * 
     * @return   Sting    Text zum Lagerbestand
     * 
    */
     public void lagerBestandAusgeben() {
        System.out.println("Aktueller Lagerbestand:");
        System.out.println("Im Lager befinden sich " + vorhandeneHolzeinheiten + " Holzeinheiten von maximal " + maxHolzeinheiten + " Holzeinheiten.");
        System.out.println("Im Lager befinden sich " + vorhandeneSchrauben + " Schrauben von maximal " + maxSchrauben + " Schrauben.");
        System.out.println("Im Lager befinden sich " + vorhandeneFarbeeinheiten + " Farbeeinheiten von maximal " + maxFarbeeinheiten + " Farbeeinheiten.");
        System.out.println("Im Lager befinden sich " + vorhandeneKartoneinheiten + "Kartoneinheiten von maximal " + maxKartoneinheiten + " Kartoneinheiten.");
        System.out.println("Im Lager befinden sich " + vorhandeneKissen + "Kissen von maximal" + maxKissen + "Kissen.");
    }
}
