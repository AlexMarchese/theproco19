
/**
 * Die Klasse Lager umfasst die Informationen zu den von der Fabrik benötigten Materialien und die dazugehörige Methoden um das Lager zu verwalten.
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
}
