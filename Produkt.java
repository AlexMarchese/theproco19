
/**
 * Beschreiben Sie hier die Klasse Produkt.
 * 
 * @author GBI Gruppe 19
 * @version 1.0
 * 
 * 
 */

/**
 * @param   zustand   Das ist der Zustand.
 * @param   holzeinheiten   Das sind die Anzahl Einheiten Hol,z die für das Produkt benötigt werden.
 * @param   schrauben   Das sind die Anzahl Schrauben, die für das Produkt benötigt werden.
 * @param   farbeinheiten   Das sind die Anzahl Einheiten Farbe, die für das Produkt benötigt werden.
 * @param   kartoneinheiten   Das sind die Anzahl Einheiten Karton, die für das Produkt benötigt werden.
 * @param   produktionsZeit   Das ist die Zeit welche zur Produktion des Produkts benötigt wird.
 * 
*/
public class Produkt {
    // Instanzvariablen
    int zustand;
    int holzeinheiten;
    int schrauben;
    int farbeinheiten;
    int kartoneinheiten;
    int produktionsZeit; 

    /**
     * Konstruktor für Objekte der Klasse Produkt, Produkt kann Zahlenwerte annehmen
     */
    public Produkt(int holzeinheiten, int schrauben, int farbeinheiten, int kartoneinheiten, int produktionsZeit) {
        // Instanzvariable initialisieren
        /*
         * 0= nicht gestartet 1= in bearbeitung (Zukünftig denkbar; Zustand pro Maschine/Roboter 00 = nicht gestartet, 11 Maschine/Roboter 1 in bearbeitung 12 etc) 2= abgeschlossen
         */ 
        this.zustand = 0;
        this.holzeinheiten = holzeinheiten;
        this.schrauben = schrauben;
        this.farbeinheiten = farbeinheiten;
        this.kartoneinheiten = kartoneinheiten;
        this.produktionsZeit = produktionsZeit;
    }


    /// Getters und Setters


    /**
     * Methode, um den Zustandswert des Produkts zu setzen
     * @param   Den Zustandswert des Produkts in numerischer Form.
     */
    public void setzeZustand(int zustand) {
        this.zustand = zustand;
    }
    
    /**
     * Methode gibt aktuellen Zustand zurück.
     * @return  Den aktuellen Zustand des Produkts in numerischer Form.
     */
    public int gibZustand() {
        return this.zustand;
    }

    /**
     * Methode, um benötigte Holzeinheiten für einen Stuhl zu setzen
     * @param   Die benötigten Einheiten Holz für das Produkt.
     */
    public void setzeHolzeinheiten(int anzahlHolzeinheiten) {
         this.holzeinheiten = anzahlHolzeinheiten;
    }
    
    /**
     * Methode, um benötigte Holzeinheiten für einen Stuhl zu erhalten
     * @return  Die  benötigten Einheiten Holz für das Produkt.
     */
    public int gibHolzeinheiten() {
        return this.holzeinheiten;
    }
    
    /**
     * Methode, um benötigte Schrauben für einen Stuhl zu setzen
     * @param   Die benötigte Anzahl Schrauben für das Produkt.
     */
    public void setzeSchrauben(int anzahlSchrauben) {
        this.schrauben = anzahlSchrauben;
    }

    /**
     * Methode, um benötigte Schrauben für einen Stuhl zu erhalten
     * @return  Die  benötigte Anzahl Schrauben für das Produkt.
     */
    public int gibSchrauben() {
        return this.schrauben;
    }
    
    /**
     * Methode, um benötigte Farbeinheiten für einen Stuhl zu setzen
     * @param   Die benötigten Einheiten Farbe für das Produkt.
     */
    public void setzeFarbeinheiten(int anzahlFarbeinheiten) {
        this.farbeinheiten = anzahlFarbeinheiten;
    }
    
    /**
     * Methode, um benötigte Farbeinheiten für einen Stuhl zu erhalten
     * @return  Die  benötigten Einheiten Farbe für das Produkt.
     */
    public int gibFarbeinheiten() {
        return this.farbeinheiten;
    }
    
    /**
     * Methode, um benötigte Kartoneinheiten für einen Stuhl zu setzen
     * @param   Die benötigten Einheiten Karton für das Produkt.
     */
    public void setzeKartoneinheiten(int anzahlKartoneinheiten) {
        this.kartoneinheiten = anzahlKartoneinheiten;
    }
    
    /**
     * Methode, um benötigte Kartoneinheiten für einen Stuhl zu erhalten
     * @return  kartoneinheiten Die benötigten Einheiten Karton für das Produkt.
     */
    public int gibKartoneinheiten() {
        return this.kartoneinheiten;
    }
    
    /**
     * Methode, um Produktionszeit für einen Stuhl zu setzen
     * @param   Die totale Produktionszeit für das Produkt.
     */
    public void setzeTotalProduktionszeit(int neueproduktionsZeit) {
         this.produktionsZeit = neueproduktionsZeit;
    }
    
    /**
     * Methode, um die Produktionszeit für einen Stuhl zu erhalten
     * @return  Die totale Produktionszeit für das Produkt.
     */
    public int gibTotalProduktionszeit() {
        return this.produktionsZeit;
    }
    
}
