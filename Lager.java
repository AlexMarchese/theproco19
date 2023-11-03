
/**
 * Die Klasse Lager umfasst die Informationen zu den von der Fabrik benötigten Materialien 
 * und die dazugehörige Methoden um das Lager zu verwalten.
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

    /**
     * Konstruktor für Objekte der Klasse Lager
     *@param    maxHolzeinheiten    Die maximale Kapazität des Lagers für Holzeinheiten.
     *@param    maxSchrauben    Die maximale Kapazität des Lagers für Schrauben. 
     *@param    maxFarbeeinheiten   Die maximale Kapazität des Lagers für Farbeinheiten.
     *@param    maxKartoneinheiten  Die maximale Kapazität des Lagers für Kartoneinheiten.
     *@param    maxKissen   Die maximale Kapazität des Lagers für Kissen.
     *@param    vorhandeneHolzeinheiten Die aktuelle Anzahl Holzeinheiten im Lager.
     *@param    vorhandenSchrauben  Die aktuelle Anzahl Schrauben im Lager.
     *@param    vorhandeneFarbeeinheiten    Die aktuelle Anzahl Farbeinheiten im Lager.
     *@param    vorhandeneKartoneinheiten   Die aktuelle Anzahl Kartoneinheiten im Lager.
     *@param    vorhandeneKissen    Die aktuelle Anzahl Kissen im Lager. 
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
     * Methode, XXX.
     * 
     * @return   BeschaffungsZeit    XXX
     * 
    */
    public int gibBeschaffungsZeit(Bestellung kundenBestellung) {      
        
        int beschaffungszeit = 0;
        int benötigteHolzeinheiten = 0;
        int benötigteSchrauben = 0;
        int benötigteFarbeinheiten = 0;
        int benötigteKartoneinheite = 0;
        int benötigteKissen = 0;   

        for (Produkt produkt : kundenBestellung.gibBestellteProdukte()) {
            if (produkt instanceof Stuhl) {
               benötigteHolzeinheiten = benötigteHolzeinheiten + ((Stuhl) produkt).gibHolzeinheiten();
               benötigteSchrauben = benötigteSchrauben + ((Stuhl) produkt).gibSchrauben();
               benötigteFarbeinheiten = benötigteFarbeinheiten + ((Stuhl) produkt).gibFarbeinheiten();
               benötigteKartoneinheite = benötigteKartoneinheite + ((Stuhl) produkt).gibKartoneinheiten();

            } else if (produkt instanceof Sofa) {
               benötigteHolzeinheiten = benötigteHolzeinheiten + ((Sofa) produkt).gibHolzeinheiten();
               benötigteSchrauben = benötigteSchrauben + ((Sofa) produkt).gibSchrauben();
               benötigteFarbeinheiten = benötigteFarbeinheiten + ((Sofa) produkt).gibFarbeinheiten();
               benötigteKartoneinheite = benötigteKartoneinheite + ((Sofa) produkt).gibKartoneinheiten();
               benötigteKissen = benötigteKissen + ((Sofa) produkt).gibKissen();              
                
            }
        }
            
        if (gibvorhandeneHolzeinheiten() < benötigteHolzeinheiten
              || gibvorhandeneSchrauben() < benötigteSchrauben
              || gibvorhandeneFarbeeinheiten() < benötigteFarbeinheiten 
              || gibvorhandeneKartoneinheiten() < benötigteKartoneinheite
              || gibvorhandeneKissen() < benötigteKissen) {
              beschaffungszeit = 2;
        } else {beschaffungszeit = 0;}
            // muss man noch einen Stop (break) einbauen?? 
    
    return beschaffungszeit;
        
    }
    
    
    /**
     * Methode, XXX.
     * 
     * @param   XX    XXX
     * 
    */

    //public int lagerAuffuellen() {
        
    //}

    
    /**
     * Die Methode lagerBestandAusgeben gibt den aktuellen Lagerbestand aus.
     * 
     * @return   Sting    Text zum Lagerbestand
     * 
    */
     public void lagerBestandAusgeben() {
        System.out.println("Aktueller Lagerbestand:");
        System.out.println("Im Lgaer befinden sich " + vorhandeneHolzeinheiten + " Holzeinheiten von maximal " + maxHolzeinheiten + " Holzeinheiten.");
        System.out.println("Im Lgaer befinden sich " + vorhandeneSchrauben + " Schrauben von maximal " + maxSchrauben + " Schrauben.");
        System.out.println("Im Lager befinden sich " + vorhandeneFarbeeinheiten + " Farbeeinheiten von maximal " + maxFarbeeinheiten + " Farbeeinheiten.");
        System.out.println("Im Lager befinden sich " + vorhandeneKartoneinheiten + "Kartoneinheiten von maximal " + maxKartoneinheiten + " Kartoneinheiten.");
        System.out.println("Im Lager befinden sich " + vorhandeneKissen + "Kissen von maximal" + maxKissen + "Kissen.");
    }
}
