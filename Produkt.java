
/**
 * Die Klasse Produkt umfasst die Informationen zu den von der Fabrik produzierbaren Produkten und die dazugehörige Methoden.
 * Diese Produkte umfassen Sofas und Stühle.
 * 
 * @author GBI Gruppe 19
 * @version 1.0
 * 
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
     * Konstruktor für Objekte der Klasse Produkt. Produkt kann Zahlenwerte annehmen.
     * 
     * @param   holzeinheiten   Das ist die Anzahl der Einheiten Holz, welche für das Produkt benötigt werden.
     * @param   schrauben       Das ist die Anzahl der Schrauben, welche für das Produkt benötigt werden.
     * @param   farbeinheiten   Das ist die Anzahl der Einheiten Farbe, welche für das Produkt benötigt werden.
     * @param   kartoneinheiten Das ist die Anzahl Einheiten Karton, welche für das Produkt benötigt werden.
     * @param   produktionsZeit Das ist die Zeit (in Minuten), welche zur Produktion des Produkts benötigt wird.
     * 
     */
    public Produkt(int holzeinheiten, int schrauben, int farbeinheiten, int kartoneinheiten, int produktionsZeit) {
        // Instanzvariable initialisieren
        /*
         * 0= nicht gestartet 1= in Bearbeitung (Zukünftig denkbar; Zustand pro Maschine/Roboter 00 = nicht gestartet, 11 Maschine/Roboter 1 in Bearbeitung 12 etc) 2= abgeschlossen
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
     * Methode, um den Zustandswert des Produkts zu setzen.
     * @param   zustand Der Zustandswert des Produkts in numerischer Form.
     */
    public void setzeZustand(int zustand) {
        this.zustand = zustand;
    }
    
    /**
     * Methode gibt aktuellen Zustand zurück.
     * @return  zustand Den aktuellen Zustand des Produkts in numerischer Form.
     */
    public int gibZustand() {
        return this.zustand;
    }

    /**
     * Methode, um benötigte Holzeinheiten für ein Produkt zu setzen.
     * @param   anzahlHolzeinheiten Die benötigten Einheiten Holz für das Produkt.
     */
    public void setzeHolzeinheiten(int anzahlHolzeinheiten) {
         this.holzeinheiten = anzahlHolzeinheiten;
    }
    
    /**
     * Methode, um benötigte Holzeinheiten für ein Produkt zu erhalten.
     * @return  holzeinheiten   Die  benötigten Einheiten Holz für das Produkt.
     */
    public int gibHolzeinheiten() {
        return this.holzeinheiten;
    }
    
    /**
     * Methode, um benötigte Schrauben für ein Produkt zu setzen.
     * @param   anzahlSchrauben Die benötigte Anzahl Schrauben für das Produkt.
     */
    public void setzeSchrauben(int anzahlSchrauben) {
        this.schrauben = anzahlSchrauben;
    }

    /**
     * Methode, um benötigte Schrauben für ein Produkt zu erhalten.
     * @return  schrauben   Die  benötigte Anzahl Schrauben für das Produkt.
     */
    public int gibSchrauben() {
        return this.schrauben;
    }
    
    /**
     * Methode, um benötigte Farbeinheiten für ein Produkt zu setzen.
     * @param   anzahlFarbeinheiten Die benötigten Einheiten Farbe für das Produkt.
     */
    public void setzeFarbeinheiten(int anzahlFarbeinheiten) {
        this.farbeinheiten = anzahlFarbeinheiten;
    }
    
    /**
     * Methode, um benötigte Farbeinheiten für ein Produkt zu erhalten.
     * @return  farbeinheiten   Die  benötigten Einheiten Farbe für das Produkt.
     */
    public int gibFarbeinheiten() {
        return this.farbeinheiten;
    }
    
    /**
     * Methode, um benötigte Kartoneinheiten für ein Produkt zu setzen.
     * @param   anzahlKartoneinheiten   Die benötigten Einheiten Karton für das Produkt.
     */
    public void setzeKartoneinheiten(int anzahlKartoneinheiten) {
        this.kartoneinheiten = anzahlKartoneinheiten;
    }
    
    /**
     * Methode, um benötigte Kartoneinheiten für ein Produkt zu erhalten.
     * @return  kartoneinheiten Die benötigten Einheiten Karton für das Produkt.
     */
    public int gibKartoneinheiten() {
        return this.kartoneinheiten;
    }
    
    /**
     * Methode, um die Produktionszeit für ein Produkt zu setzen.
     * @param   neueproduktionsZeit Die totale Produktionszeit (in Minuten) für das Produkt.
     */
    public void setzeTotalProduktionszeit(int neueproduktionsZeit) {
         this.produktionsZeit = neueproduktionsZeit;
    }
    
    /**
     * Methode, um die Produktionszeit für ein Produkt zu erhalten.
     * @return  produktionsZeit Die totale Produktionszeit (in Minuten) für das Produkt.
     */
    public int gibTotalProduktionszeit() {
        return this.produktionsZeit;
    }
    
}
