
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

    // Einheiten, die Aufgrund von den eingetroffenen Bestellungen benötigt werden.
    int benoetigteHolzeinheiten;
    int benoetigteSchrauben;
    int benoetigteFarbeeinheiten;
    int benoetigteKartoneinheiten;
    int benoetigteKissen; 

    // Steht für die Einheiten die bestellt, aber noch nicht geliefert wurden.
    int inLieferungHolzeinheiten;
    int inLieferungSchrauben;
    int inLieferungFarbeeinheiten;
    int inLieferungKartoneinheiten;
    int inLieferungKissen; 


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
        this.benoetigteHolzeinheiten = 0;
        this.benoetigteSchrauben = 0;
        this.benoetigteFarbeeinheiten = 0;
        this.benoetigteKartoneinheiten = 0;
        this.benoetigteKissen = 0; 
        this.inLieferungHolzeinheiten = 0;
        this.inLieferungSchrauben = 0;
        this.inLieferungFarbeeinheiten = 0;
        this.inLieferungKartoneinheiten = 0;
        this.inLieferungKissen = 0; 
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
     * Methode, um die Anzahl an Holzeinheiten im Lager zu setzen.
     * @param   vorhandeneHolzeinheiten    Die momentane Anzahl an Holzeinheiten im Lager in numerischer Form.
     */
    public void setzevorhandeneHolzeinheiten(int vorhandeneHolzeinheiten) {
        this.vorhandeneHolzeinheiten = vorhandeneHolzeinheiten;
    }

    /**
     * Methode, um die momentane Anzahl an Holzeinheiten, die auf dem Weg zur Lieferung sind, auszugeben.
     * @return   inLieferungHolzeinheiten    Die momentane Anzahl an Holzeinheiten auf dem Weg zur Lieferung.
     */
    public int gibInLieferungHolzeinheiten() {
        return this.inLieferungHolzeinheiten;
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
     * Methode, um die Anzahl an Schrauben im Lager zu setzen.
     * @param   vorhandeneSchrauben    Die momentane Anzahl an Schrauben im Lager in numerischer Form.
     */
    public void setzevorhandeneSchrauben(int vorhandeneSchrauben) {
        this.vorhandeneSchrauben = vorhandeneSchrauben;
    }

    /**
     * Methode, um die momentane Anzahl an Schrauben, die auf dem Weg zur Lieferung sind, auszugeben.
     * @return   inLieferungSchrauben    Die momentane Anzahl an Schrauben auf dem Weg zur Lieferung.
     */
    public int gibInLieferungSchrauben() {
        return this.inLieferungSchrauben;
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
     * Methode, um die Anzahl an Farbeeinheiten im Lager zu setzen.
     * @param   vorhandeneFarbeeinheiten    Die momentane Anzahl an Farbeeinheiten im Lager in numerischer Form.
     */
    public void setzevorhandeneFarbeeinheiten(int vorhandeneFarbeeinheiten) {
        this.vorhandeneFarbeeinheiten = vorhandeneFarbeeinheiten;
    }

    /**
     * Methode, um die momentane Anzahl an Farbeeinheiten, die auf dem Weg zur Lieferung sind, auszugeben.
     * @return   inLieferungFarbeeinheiten    Die momentane Anzahl an Farbeeinheiten auf dem Weg zur Lieferung.
     */
    public int gibInLieferungFarbeeinheiten() {
        return this.inLieferungFarbeeinheiten;
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
     * Methode, um die Anzahl an Kartoneinheiten im Lager zu setzen.
     * @param   vorhandeneKartoneinheiten    Die momentane Anzahl an Kartoneinheiten im Lager in numerischer Form.
     */
    public void setzevorhandeneKartoneinheiten(int vorhandeneKartoneinheiten) {
        this.vorhandeneKartoneinheiten = vorhandeneKartoneinheiten;
    }
    
    /**
     * Methode, um die momentane Anzahl an Kartoneinheiten, die auf dem Weg zur Lieferung sind, auszugeben.
     * @return   inLieferungKartoneinheiten    Die momentane Anzahl an Kartoneinheiten auf dem Weg zur Lieferung.
     */
    public int gibInLieferungKartoneinheiten() {
        return this.inLieferungKartoneinheiten;
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

    /**
     * Methode, um die Anzahl an Kissen im Lager zu setzen.
     * @param   vorhandeneKissen    Die momentane Anzahl an Kissen im Lager in numerischer Form.
     */
    public void setzevorhandeneKissen(int vorhandeneKissen) {
        this.vorhandeneKissen = vorhandeneKissen;
    }

    /**
     * Methode, um die momentane Anzahl an Kissen, die auf dem Weg zur Lieferung sind, auszugeben.
     * @return   inLieferungKissen    Die momentane Anzahl an Kissen auf dem Weg zur Lieferung.
     */
    public int gibInLieferungKissen() {
        return this.inLieferungKissen;
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
               benoetigteHolzeinheiten += produkt.gibHolzeinheiten();
               benoetigteSchrauben += produkt.gibSchrauben();
               benoetigteFarbeeinheiten += produkt.gibFarbeinheiten();
               benoetigteKartoneinheiten += produkt.gibKartoneinheiten();

            } else if (produkt instanceof Sofa) {
               benoetigteHolzeinheiten += produkt.gibHolzeinheiten();
               benoetigteSchrauben += produkt.gibSchrauben();
               benoetigteFarbeeinheiten += produkt.gibFarbeinheiten();
               benoetigteKartoneinheiten += produkt.gibKartoneinheiten();
               benoetigteKissen = benoetigteKissen + ((Sofa) produkt).gibKissen();              
                
            }
        }
        
        // Produkte die benötigt werden sind weder im Lager noch unterwegs.
        if (gibvorhandeneHolzeinheiten() + inLieferungHolzeinheiten < benoetigteHolzeinheiten
              || gibvorhandeneSchrauben() + inLieferungSchrauben < benoetigteSchrauben
              || gibvorhandeneFarbeeinheiten() + inLieferungFarbeeinheiten < benoetigteFarbeeinheiten 
              || gibvorhandeneKartoneinheiten() + inLieferungKartoneinheiten < benoetigteKartoneinheiten
              || gibvorhandeneKissen() + inLieferungKissen < benoetigteKissen) {
              beschaffungszeit = 2;
        // Produkte die benötigt werden sind noch nicht im Lager aber unterwegs.
        } else if (gibvorhandeneHolzeinheiten() < benoetigteHolzeinheiten
              || gibvorhandeneSchrauben() < benoetigteSchrauben
              || gibvorhandeneFarbeeinheiten() < benoetigteFarbeeinheiten
              || gibvorhandeneKartoneinheiten() < benoetigteKartoneinheiten
              || gibvorhandeneKissen() < benoetigteKissen){beschaffungszeit = 1;}
        
        // Benötigte Produkte sind im Lager
        else {beschaffungszeit = 0;}
            //muss man noch einen Stop (break) einbauen?? Glaube nicht, das braucht es doch nur bei while, falls es keine stop condition gibt (flo);
    
    return beschaffungszeit;
        
    }
    
    
    /**
     * Methode, lagerAuffuellen vergleicht ob die benötigten Materialien die maximale Lager Kapazität überschreiten und reduziert diese ggf und bestellt anschließend über den Methode wareBestellen die zu Bestellenden Materialien nach.
     * 
     * @param   lagerAuffuellen    Füllt den Lagerbestand. //WIESO? wo ist der param?
     * 
    */

public void lagerAuffuellen() {      //Methode wird getriggert sobald irgendetwas benoetigt wird und es nicht vorhanden ist
        Lieferant lieferant = new Lieferant();

        int zuBestellendeHolzeinheiten = maxHolzeinheiten - vorhandeneHolzeinheiten;
        int zuBestellendeSchrauben = maxSchrauben - vorhandeneSchrauben;
        int zuBestellendeFarbeinheiten = maxFarbeeinheiten - vorhandeneFarbeeinheiten;
        int zuBestellendeKartoneinheiten = maxKartoneinheiten - vorhandeneKartoneinheiten;
        int zuBestellendeKissen = maxKissen - vorhandeneKissen;

        // Bestellung beim Lieferanten aufgeben und auf die Lieferung warten (2 Tage Lieferzeit).
        lieferant.wareBestellen(zuBestellendeHolzeinheiten, zuBestellendeSchrauben, zuBestellendeFarbeinheiten, zuBestellendeKartoneinheiten, zuBestellendeKissen);
        // Lagerbestände aktualisieren.
        //Das muesste vllcht erst nach 2 Tagen passieren, sonst ist die Angabe beim Kunden falsch
        //vllcht am besten eine wirdgeliefert Variable zu haben
        inLieferungHolzeinheiten += zuBestellendeHolzeinheiten;
        inLieferungSchrauben += zuBestellendeSchrauben;
        inLieferungFarbeeinheiten += zuBestellendeFarbeinheiten;
        inLieferungKartoneinheiten += zuBestellendeKartoneinheiten;
        inLieferungKissen += zuBestellendeKissen;
        
        // benötigte Einheiten um den bestellten Wert reduzieren, wenn der Wert kleiner als die benötigte Einheiten ist.
        benoetigteHolzeinheiten = Math.max(0, benoetigteHolzeinheiten - zuBestellendeHolzeinheiten);
        benoetigteSchrauben = Math.max(0, benoetigteSchrauben - zuBestellendeSchrauben);
        benoetigteFarbeeinheiten = Math.max(0, benoetigteFarbeeinheiten - zuBestellendeFarbeinheiten);
        benoetigteKartoneinheiten = Math.max(0, benoetigteKartoneinheiten - zuBestellendeKartoneinheiten);
        benoetigteKissen = Math.max(0, benoetigteKissen - zuBestellendeKissen);

        //kann vllt auch vereinfacht werden (alex)
        //ich wuerde die Methode wie in den Notes geschrieben implementieren, alles Bestellen bis zum Max
        //Begruenden: der Preis veraendert sich nicht im Laufe der Zeit, noch kostet es Materialiern am Lager
        //zu haben, noch gehen sie kaputt. Vorteil: weniger warten fuer den Kunden.
        //Impliziert, dass diese Methode nicht bei jeder Bestellung aufgerufen wird.
        //wenn etwas benötigt wird (e.g. für  1k Stühle verlieren wir so die info)
        //bei jeder Best an den Lieferer sollte die Menge bei benötgt verringert werden.
        
        // // Überprüfen, ob die Bestellmenge die Lagerkapazität überschreitet.
        // if (gibvorhandeneHolzEinheiten() + benötigteHolzeinheiten > maxHolzeinheiten) {
        //     // Bestellmenge reduzieren, um die Lagerkapazität nicht zu überschreiten.
        //     benötigteHolzeinheiten = maxHolzeinheiten - gibvorhandeneHolzEinheiten(); // ist es nicht this.methode()?
        // } 

        // if (gibvorhandeneSchrauben() + benötigteSchrauben > maxSchrauben) {
        //     benötigteSchrauben = maxSchrauben - gibvorhandeneSchrauben();
        // }

        // if (gibvorhandeneFarbeEinheiten() + benötigteFarbeinheiten > maxFarbeeinheiten) { //FarbeEinheiten eigentlich
        //     benötigteFarbeinheiten = maxFarbeeinheiten - gibvorhandeneFarbeEinheiten();
        // }

        // if (gibvorhandeneKartonEinheiten() + benötigteKartoneinheiten > maxKartoneinheiten) {
        //     benötigteKartoneinheiten = maxKartoneinheiten - gibvorhandeneKartonEinheiten();
        // }

        // if (gibvorhandeneKissen() + benötigteKissen > maxKissen) {
        //     benötigteKissen = maxKissen - gibvorhandeneKissen();
        // }

        // // Bestellung beim Lieferanten aufgeben und auf die Lieferung warten (2 Tage Lieferzeit).
        // lieferant.wareBestellen(benötigteHolzeinheiten, benötigteSchrauben, benötigteFarbeinheiten, benötigteKartoneinheiten, benötigteKissen);

        // // Lagerbestände aktualisieren.
        // vorhandeneHolzeinheiten += benötigteHolzeinheiten;
        // vorhandeneSchrauben += benötigteSchrauben;
        // vorhandeneFarbeeinheiten += benötigteFarbeinheiten;
        // vorhandeneKartoneinheiten += benötigteKartoneinheiten;
        // vorhandeneKissen += benötigteKissen;
        
        // // benötigte Einheiten zurücksetzen, um von 0 anzufangen.
        // benötigteHolzeinheiten = 0;
        // benötigteSchrauben = 0;
        // benötigteFarbeinheiten = 0;
        // benötigteKartoneinheiten = 0;
        // benötigteKissen = 0;
    }
            
    /**
     * Die Methode lagerBestandAusgeben gibt den aktuellen Lagerbestand aus.
     * 
     * @return   String    Text zum Lagerbestand
     * 
    */
     public String lagerBestandAusgeben() {
        return "Aktueller Lagerbestand:\nIm Lager befinden sich " + vorhandeneHolzeinheiten + " Holzeinheiten von maximal " + 
        maxHolzeinheiten + " Holzeinheiten.\nIm Lager befinden sich " + vorhandeneSchrauben + " Schrauben von maximal " + maxSchrauben + 
        " Schrauben.\nIm Lager befinden sich " + vorhandeneFarbeeinheiten + " Farbeeinheiten von maximal " + maxFarbeeinheiten + 
        " Farbeeinheiten.\nIm Lager befinden sich " + vorhandeneKartoneinheiten + "Kartoneinheiten von maximal " + maxKartoneinheiten + 
        " Kartoneinheiten.\nIm Lager befinden sich " + vorhandeneKissen + "Kissen von maximal" + maxKissen + "Kissen.";
    }
}
