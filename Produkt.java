
/**
 * Beschreiben Sie hier die Klasse Produkt.
 * 
 * @author GBI Gruppe 19
 * @version 1.0
 * 
 * 
 */

/**
 * @param   zustand   Das ist der Zustand
 */
public class Produkt {
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    int zustand;
    int holzeinheiten;
    int schrauben;
    int farbeinheiten;
    int kartoneinheiten;
    int produktionsZeit; 

    /**
     * Konstruktor für Objekte der Klasse Produkt, Produkt kann Zahlenwerte annehmen
     * 0= nicht gestartet
     * 1= in bearbeitung (Zukünftig denkbar; Zustand pro Maschine/Roboter 00 = nicht gestartet, 11 Maschine/Roboter 1 in bearbeitung 12 etc)
     * 2= abgeschlossen
       */
    public Produkt(int holzeinheiten, int schrauben, int farbeinheiten, int kartoneinheiten, int produktionsZeit) {
        // Instanzvariable initialisieren
        this.zustand = 0;
        this.holzeinheiten = holzeinheiten;
        this.schrauben = schrauben;
        this.farbeinheiten = farbeinheiten;
        this.kartoneinheiten = kartoneinheiten;
        this.produktionsZeit = produktionsZeit;
    }

    /**
     * 
     * Methode zustandÄndern ersetzt den Zustandswert des Produkts
     * 
     * 
     *
     */
    public void zustandAendern(int zustand) {
        // fehlt: if loop um zu vermeiden, dass ein ungültiger value eingegeben wird
        this.zustand = zustand;
    }
    
    /**
     * Methode gibt aktuellen Zustand zurück.
     */
    public int aktuellerZustand() {
        return this.zustand;
    }
    
    /**
     * Methode, um benötigte Holzeinheiten für einen Stuhl zu erhalten
     */
    public int getHolzeinheiten() {
        return this.holzeinheiten;
    }
    /**
     * Methode, um benötigte Holzeinheiten für einen Stuhl zu ändern
     */
    public void setHolzeinheiten(int anzahlHolzeinheiten) {
         this.holzeinheiten = anzahlHolzeinheiten;
    }
    
    /**
     * Methode, um benötigte Schrauben für einen Stuhl zu erhalten
     */
    public int getSchrauben() {
        return this.schrauben;
    }
    /**
     * Methode, um benötigte Schrauben für einen Stuhl zu ändern
     */
    public void setSchrauben(int anzahlSchrauben) {
        this.schrauben = anzahlSchrauben;
    }
    
    /**
     * Methode, um benötigte Farbeinheiten für einen Stuhl zu erhalten
     */
    public int getFarbeinheiten() {
        return this.farbeinheiten;
    }
    /**
     * Methode, um benötigte Farbeinheiten für einen Stuhl zu ändern
     */
    public void setFarbeinheiten(int anzahlFarbeinheiten) {
        this.farbeinheiten = anzahlFarbeinheiten;
    }
    
    /**
     * Methode, um benötigte Kartoneinheiten für einen Stuhl zu erhalten
     */
    public int getKartoneinheiten() {
        return this.kartoneinheiten;
    }
     /**
     * Methode, um benötigte Kartoneinheiten für einen Stuhl zu ändern
     */
    public void setKartoneinheiten(int anzahlKartoneinheiten) {
        this.kartoneinheiten = anzahlKartoneinheiten;
    }
    
        /**
     * Methode, um Produktionszeit für einen Stuhl zu erhalten
     * 
     */
    public int getTotalProduktionszeit() { //muss noch angepasst werden, falls Produktionszeit nicht Total, sondern für bestimmten Prodktionsschritt ist.
        return this.produktionsZeit;
    }
    /**
     * Methode, um Produktionszeit für einen Stuhl zu ändern
     * 
     */
    public void setTotalProduktionszeit(int neueproduktionsZeit) { //muss noch angepasst werden, falls Produktionszeit nicht Total, sondern für bestimmten Prodktionsschritt ist.
         this.produktionsZeit = neueproduktionsZeit;
    }
}
