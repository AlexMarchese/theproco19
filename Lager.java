
/**
 * Die Klasse Lager umfasst die Informationen zu den von der Fabrik benötigten Materialien 
 * und die dazugehörigen Methoden um das Lager zu verwalten.
 * 
 * 
 * @author GBI Gruppe 19
 * @version 2.0
 * 
 */

public class Lager{
    // Instanzvariablen
    private int maxHolzeinheiten;
    private int maxSchrauben;
    private int maxFarbeeinheiten;
    private int maxKartoneinheiten;
    private int maxKissen;
    private int vorhandeneHolzeinheiten;
    private int vorhandeneSchrauben;
    private int vorhandeneFarbeeinheiten;
    private int vorhandeneKartoneinheiten;
    private int vorhandeneKissen;
    private Lieferant lieferant; 

    // Einheiten, die Aufgrund von den eingetroffenen Bestellungen benötigt werden.
    private int benoetigteHolzeinheiten;
    private int benoetigteSchrauben;
    private int benoetigteFarbeeinheiten;
    private int benoetigteKartoneinheiten;
    private int benoetigteKissen; 

    // Steht für die Einheiten die bestellt, aber noch nicht geliefert wurden.
    private int inLieferungHolzeinheiten;
    private int inLieferungSchrauben;
    private int inLieferungFarbeeinheiten;
    private int inLieferungKartoneinheiten;
    private int inLieferungKissen; 


    /**
     * Konstruktor für Objekte der Klasse Lager
     *@param    maxHolzeinheiten            Die maximale Kapazität des Lagers für Holzeinheiten.
     *@param    maxSchrauben                Die maximale Kapazität des Lagers für Schrauben. 
     *@param    maxFarbeeinheiten           Die maximale Kapazität des Lagers für Farbeinheiten.
     *@param    maxKartoneinheiten          Die maximale Kapazität des Lagers für Kartoneinheiten.
     *@param    maxKissen                   Die maximale Kapazität des Lagers für Kissen.
     *@param    vorhandeneHolzeinheiten     Die aktuell vorhandene Anzahl Holzeinheiten im Lager.
     *@param    vorhandenSchrauben          Die aktuell vorhandene Anzahl Schrauben im Lager.
     *@param    vorhandeneFarbeeinheiten    Die aktuell vorhandene Anzahl Farbeinheiten im Lager.
     *@param    vorhandeneKartoneinheiten   Die aktuell vorhandene Anzahl Kartoneinheiten im Lager.
     *@param    vorhandeneKissen            Die aktuell vorhandene Anzahl Kissen im Lager. 
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
        this.lieferant = new Lieferant();
        lieferant.start();
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
     * Methode, um die Anzahl an Holzeinheiten in Lieferung zu setzen.
     * @param   inLieferungHolzeinheiten    Die momentane Anzahl an Holzeinheiten in Lieferung in numerischer Form.
     */
    public void setzeInLieferungHolzeinheiten(int inLieferungHolzeinheiten) {
        this.inLieferungHolzeinheiten = inLieferungHolzeinheiten;
    }

    /**
     * Methode, um die maximale Lagerkapazität an Schrauben anzupassen.
     * @param   maxSchrauben    Die maximale Anzahl Schrauben in numerischer Form (Lagerkapazität).
     */
    public void setzemaxSchrauben(int maxSchrauben) {
        this.maxSchrauben = maxSchrauben;
    }
    
    /**
     * Methode, um die aktuelle Anzahl an Schrauben im Lager auszugeben.
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
     * Methode, um die Anzahl an Schrauben in Lieferung zu setzen.
     * @param   inLieferungSchrauben    Die momentane Anzahl an Schrauben in Lieferung in numerischer Form.
     */
    public void setzeInLieferungSchrauben(int inLieferungSchrauben) {
        this.inLieferungSchrauben = inLieferungSchrauben;
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
     * Methode, um die Anzahl an Farbeinheiten in Lieferung zu setzen.
     * @param   inLieferungFarbeeinheiten    Die momentane Anzahl an Farbeinheiten in Lieferung in numerischer Form.
     */
    public void setzeInLieferungFarbeeinheiten(int inLieferungFarbeeinheiten) {
        this.inLieferungFarbeeinheiten = inLieferungFarbeeinheiten;
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
     * Methode, um die Anzahl an Kartoneinheiten in Lieferung zu setzen.
     * @param   inLieferungKartoneinheiten    Die momentane Anzahl an Kartoneinheiten in Lieferung in numerischer Form.
     */
    public void setzeInLieferungKartoneinheiten(int inLieferungKartoneinheiten) {
        this.inLieferungKartoneinheiten = inLieferungKartoneinheiten;
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

    /**
     * Methode, um die Anzahl an Kissen in Lieferung zu setzen.
     * @param   inLieferungKissen    Die momentane Anzahl an Kissen in Lieferung in numerischer Form.
     */
    public void setzeInLieferungKissen(int inLieferungKissen) {
        this.inLieferungKissen = inLieferungKissen;
    }
   
    /**
     * Methode, um die maximale Lagerkapazität an Holzeinheiten zu erhalten.
     * @return   maxHolzeinheiten    Die maximale Kapazität an Holzeinheiten in diesem Lager
     */
    public int gibMaxHolzeinheiten() {
        return this.maxHolzeinheiten;
    }   
    
    /**
     * Methode, um die maximale Lagerkapazität an Schrauben zu erhalten.
     * @return   maxSchrauben    Die maximale Kapazität an Schrauben in diesem Lager
     */
    public int gibMaxSchrauben() {
        return this.maxSchrauben;
    }   
    
    /**
     * Methode, um die maximale Lagerkapazität an Farbeinheiten zu erhalten.
     * @return   maxFarbeeinheiten    Die maximale Kapazität an Farbeinheiten in diesem Lager
     */
    public int gibMaxFarbeeinheiten() {
        return this.maxFarbeeinheiten;
    }   
    
    /**
     * Methode, um die maximale Lagerkapazität an Kartoneinheiten zu erhalten.
     * @return   maxKartoneinheiten    Die maximale Kapazität an Kartoneinheiten in diesem Lager
     */
    public int gibMaxKartoneinheiten() {
        return this.maxKartoneinheiten;
    }   
    
    /**
     * Methode, um die maximale Lagerkapazität an Kissen zu erhalten.
     * @return   maxKissen    Die maximale Kapazität an Kissen in diesem Lager
     */
    public int gibMaxKissen() {
        return this.maxKissen;
    }   
    
    
    /// Methoden


    /**
     * Methode, berechneBeschaffungsZeit(Bestellung kundenBestellung) schaut für eine Bestellung alle Produkte an und addiert die benötigten Materialien, wenn diese im Lager vorhanden sind 
     * bleibt die BeschaffungsZeit bei 0 anderenfalls erhöht sie sich auf 2. 
     * 
     * @return   beschaffungszeit    0 oder 2 für die Anzahl Tage an Beschaffungszeit.
     * 
    */
    public int berechneBeschaffungsZeit(Bestellung kundenBestellung) {      
        
        int beschaffungszeit = 0;
        
        int [] benoetigteEinheiten = kundenBestellung.anzahlEinheiten();
        this.benoetigteHolzeinheiten = benoetigteEinheiten[0];
        this.benoetigteSchrauben = benoetigteEinheiten[1];
        this.benoetigteFarbeeinheiten = benoetigteEinheiten[2];
        this.benoetigteKartoneinheiten = benoetigteEinheiten[3];
        this.benoetigteKissen = benoetigteEinheiten[4];

        
        // Produkte die benötigt werden sind weder im Lager noch unterwegs.
        if (this.gibvorhandeneHolzeinheiten() + this.inLieferungHolzeinheiten < this.benoetigteHolzeinheiten
              || this.gibvorhandeneSchrauben() + this.inLieferungSchrauben < this.benoetigteSchrauben
              || this.gibvorhandeneFarbeeinheiten() + this.inLieferungFarbeeinheiten < this.benoetigteFarbeeinheiten 
              || this.gibvorhandeneKartoneinheiten() + this.inLieferungKartoneinheiten < this.benoetigteKartoneinheiten
              || this.gibvorhandeneKissen() + this.inLieferungKissen < this.benoetigteKissen) {
              beschaffungszeit = 2;
        // Produkte die benötigt werden sind noch nicht im Lager aber unterwegs.
        } else if (this.gibvorhandeneHolzeinheiten() < this.benoetigteHolzeinheiten
              || this.gibvorhandeneSchrauben() < this.benoetigteSchrauben
              || this.gibvorhandeneFarbeeinheiten() < this.benoetigteFarbeeinheiten
              || this.gibvorhandeneKartoneinheiten() < this.benoetigteKartoneinheiten
              || this.gibvorhandeneKissen() < this.benoetigteKissen){beschaffungszeit = 1;}
        
        // Benötigte Produkte sind im Lager
        else {beschaffungszeit = 0;}
    
        return beschaffungszeit;
    }
    
    /**
     * Methode, lagerAuffuellen() überprüft, ob eine Bestellung beim Lieferanten möglich ist, stellt die Bestellmenge fest und bestellt ggf.
     * über die Lieferanten-Methode wareBestellen die zu Bestellenden Materialien nach. Die Lager-Methode wird nur getriggert,
     * wenn die Fabrik-Methode feststellt, dass aufgefaufgefüllt werden muss.
     * 
     * @return  String  Text bezüglich dem Auffüllen des Lagers. Je nachdem ob das Lager gefüllt werden konnte oder nicht wird der entsprechende Text ausgegeben.
    */

    public String lagerAuffuellen() {
        if (lieferant.gibLieferungInArbeit()){
            System.out.println("Das Lager konnte noch nicht aufgefuellt werden. Da jedoch bereits eine Bestellung aufgegeben wurde, wird deren Eintreffen abgewartet bevor eine erneute Bestellung innerhalb von 24 Stunden aufgegeben wird.");
            return "Lager kann momentan nicht aufgefuellt werden. Es ist schon eine Lieferung im Gange."; //fix this
        } else {
            // zu bestellende Einheiten berechnen
            int zuBestellendeHolzeinheiten = this.maxHolzeinheiten - this.vorhandeneHolzeinheiten;
            int zuBestellendeSchrauben = this.maxSchrauben - this.vorhandeneSchrauben;
            int zuBestellendeFarbeinheiten = this.maxFarbeeinheiten - this.vorhandeneFarbeeinheiten;
            int zuBestellendeKartoneinheiten = this.maxKartoneinheiten - this.vorhandeneKartoneinheiten;
            int zuBestellendeKissen = this.maxKissen - this.vorhandeneKissen;

            // Überprüfung, dass mindestens einer der Werte nicht 0 ist
            if (zuBestellendeHolzeinheiten != 0 || zuBestellendeSchrauben != 0 || zuBestellendeFarbeinheiten != 0 || zuBestellendeKartoneinheiten != 0 || zuBestellendeKissen != 0) {
                // Bestellung  
                lieferant.wareBestellen(zuBestellendeHolzeinheiten, zuBestellendeSchrauben, zuBestellendeFarbeinheiten, zuBestellendeKartoneinheiten, zuBestellendeKissen, this);

                // Variablen aktualisieren
                this.inLieferungHolzeinheiten += zuBestellendeHolzeinheiten;
                this.inLieferungSchrauben += zuBestellendeSchrauben;
                this.inLieferungFarbeeinheiten += zuBestellendeFarbeinheiten;
                this.inLieferungKartoneinheiten += zuBestellendeKartoneinheiten;
                this.inLieferungKissen += zuBestellendeKissen;

                System.out.println("Antrag von Fabrik auf Lagerauffuellung bestaetigt.\nBestellung an Lieferant aufgegeben.");
                return "Bestellung konnte aufgegeben werden."; //fix this
            } else { // Falls alle Werte 0 sind
                System.out.println("Zu bestellende Materialeinheiten sind alle gleich 0.\nAntrag von Fabrik auf Lagerauffuellung durch Lager abgelehnt.");
                return "Lager hat gerade die maximale Anzahl an Einheiten"; //check this
            }
            
        }
    }
 
    /** 
     * Methode, wareLiefern() erhöht die vorhandenen Materialien um die gelieferten Einhiten und reduziert die zuliefernden Materialien um die gelieferten Mengen.
     *
     * @param   gelieferteHolzeinheiten     Die Anzahl der gelieferten Holzeinheiten
     * @param   gelieferteSchrauben         Die Anzahl der gelieferten Schrauben
     * @param   gelieferteFarbeinheiten     Die Anzahl der gelieferten Farbeinheiten
     * @param   gelieferteKartoneinheiten   Die Anzahl der gelieferten Kartoneinheiten
     * @param   gelieferteKissen            Die Anzahl der gelieferten Kissen
    */
    public void wareLiefern(int gelieferteHolzeinheiten, int gelieferteSchrauben, int gelieferteFarbeinheiten, int gelieferteKartoneinheiten, int gelieferteKissen) {
        // Vorhandene Materialien nehmen um den gelieferten Wert zu
        vorhandeneHolzeinheiten += gelieferteHolzeinheiten;
        vorhandeneSchrauben += gelieferteSchrauben;
        vorhandeneFarbeeinheiten += gelieferteFarbeinheiten;
        vorhandeneKartoneinheiten += gelieferteKartoneinheiten;
        vorhandeneKissen += gelieferteKissen;

        // Materialien in Lieferung sinken um den gelieferten Wert 
        inLieferungHolzeinheiten -= gelieferteHolzeinheiten;
        inLieferungSchrauben -= gelieferteSchrauben;
        inLieferungFarbeeinheiten -= gelieferteFarbeinheiten;
        inLieferungKartoneinheiten -= gelieferteKartoneinheiten;
        inLieferungKissen -= gelieferteKissen;

        // Benötigte Materialien sinken um den gelieferten Wert 
        benoetigteHolzeinheiten -= gelieferteHolzeinheiten;
        benoetigteSchrauben -= gelieferteSchrauben;
        benoetigteFarbeeinheiten -= gelieferteFarbeinheiten;
        benoetigteKartoneinheiten -= gelieferteKartoneinheiten;
        benoetigteKissen -= gelieferteKissen;
        System.out.println("Das Lager bestaetigt den Erhalt der Ware vom Lieferanten.");
    }
    
            
    /**
     * Die Methode lagerBestandAusgeben() gibt den aktuellen Lagerbestand aus.
     * 
     * @return   ausgabe    Text zum Lagerbestand.
     * 
    */
   
     public String lagerBestandAusgeben() {

        String ausgabe = "\nLagersituation";

        ausgabe += ("\nIm Lager:                Holzeinheiten - " + this.vorhandeneHolzeinheiten + " | Schrauben - " + this.vorhandeneSchrauben + 
        " | Farbeeinheiten - " + this.vorhandeneFarbeeinheiten + " | Kartoneinheiten - " + this.vorhandeneKartoneinheiten + 
        " | Kissen - " + this.vorhandeneKissen);

        ausgabe += ("\nWird noch geliefert:     Holzeinheiten - " + this.inLieferungHolzeinheiten + "  | Schrauben - " + this.inLieferungSchrauben + 
        "  | Farbeeinheiten - " + this.inLieferungFarbeeinheiten + "  | Kartoneinheiten - " + this.inLieferungKartoneinheiten + 
        "  | Kissen - " + this.inLieferungKissen);
        ausgabe += ("\nMaximale Lagerkapazitaet: Holzeinheiten - " + this.maxFarbeeinheiten + "  | Schrauben - " + this.maxSchrauben + 
        "  | Farbeeinheiten - " + this.maxFarbeeinheiten + "  | Kartoneinheiten - " + this.maxKartoneinheiten + 
        "  | Kissen - " + this.maxKissen);

        return ausgabe;
    }

    /**
     * Methode anzahlBasierendAufLager(int sofa, int chairs) überprüft, ob die benötigte Anzahl von Einheiten für eine Bestellung 
     * die maximal verfügbaren Einheiten im Lager überschreitet.

     * 
     * @param   sofa  Anzahl Sofas die prodzuiert werden sollen.
     * @param   chairs  Anzahl Stühle die produziert werden sollen.
     * @return  boolean Ob die Bestellung produziert werden könnte.
     */
    public boolean anzahlBasierendAufLager(int sofa, int chairs){

        // Zählt Einheiten, die für eine Bestellung benötigt werden
        Bestellung testBest = new Bestellung(sofa, chairs, 0);
        int [] noetig = testBest.anzahlEinheiten();
        int [] lagerMax = {this.maxHolzeinheiten, this.maxSchrauben, this.maxFarbeeinheiten, this.maxKartoneinheiten, this.maxKissen};
       
        for (int i = 0; i < noetig.length; i++) {
            if (noetig[i] > lagerMax[i]) {
                return true; // Irgendeinwert ist höher als das Maximum am Lager
                }
            }
        return false;
    
    }

}
