import java.util.LinkedList;

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
    // int holzeinheiten;
    // int schrauben;
    // int farbeinheiten;
    // int kartoneinheiten;
    // int produktionsZeit;
    private final int produktionsZeitHolz = 0;
    private final int produktionsZeitMontage = 0;
    private final int produktionsZeitSpritzung = 0;
    private final int produktionsZeitVerpackung = 0;
    LinkedList<Roboter> produktionsAblauf;


    //TO DO
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
    // public Produkt(int holzeinheiten, int schrauben, int farbeinheiten, int kartoneinheiten, int produktionsZeit) {
    public Produkt() {
        // Instanzvariable initialisieren
        this.zustand = 0; // 0 = nicht gestartet, 1 = in Bearbeitung, 2 = abgeschlossen
        // this.holzeinheiten = holzeinheiten;
        // this.schrauben = schrauben;
        // this.farbeinheiten = farbeinheiten;
        // this.kartoneinheiten = kartoneinheiten;
        // this.produktionsZeit = produktionsZeit;
        // this.produktionsAblauf = new LinkedList<Roboter>();
    }


    /// Getters und Setters

    /**
     * Methode, um den Zustandswert des Produkts zu setzen.
     * @param   zustand Der Zustand des Produkts in numerischer Form (0 = nicht gestartet, 1 = in Bearbeitung, 2 = abgeschlossen)
     */
    public void setzeZustand(int zustand) {
        this.zustand = zustand;
    }
    
    /**
     * Methode gibt aktuellen Zustand zurück (0 = nicht gestartet, 1 = in Bearbeitung, 2 = abgeschlossen).
     * @return  zustand Der aktuelle Zustand des Produkts in numerischer Form
     */
    public int gibZustand() {
        return this.zustand;
    }
    
    /**
     * Methode, um den Produktionsablauf für ein Produkt zu setzen.
     * @param   produktionsAblauf Die Reihenfolge der Produktionsstationen (Roboter) in einer LinkedList
     */
    public void setzeProduktionsAblauf(LinkedList<Roboter> produktionsAblauf) {
         this.produktionsAblauf = produktionsAblauf;
    }
    
    /**
     * Methode, um den Produktionsablauf für ein Produkt zu erhalten.
     * @return  produktionsAblauf Die Reihenfolge der Produktionsstationen (Roboter) in einer LinkedList
     */
    public LinkedList<Roboter> gibProduktionsAblauf() {
        return this.produktionsAblauf;
    }
    
    // /**
    //  * Methode, um die Produktionsstation (Roboter) eines Produkts zu wechseln. Nimmt aus der Liste der zu durchlaufenden
    //  * Roboter den jeweils nächsten heraus und fügt dem Roboter das aktuelle Produkt in der Liste der
    //  * zu produzierenden Produkte hinzu.
    //  */
    // public void naechsteProduktionsStation() {
    //     ;
    // }

     // TO DO : check documentation of following getters
    /**
     * Methode, um die Produktionszeit für ein Sofa zu erhalten.
     * @return  produktionsZeit Die Produktionszeit (in Minuten) für das Sofa.
     */
    public int gibProduktionszeitHolz() {
        return this.produktionsZeitHolz;
    }
    
    /**
     * Methode, um die Produktionszeit für ein Sofa zu erhalten.
     * @return  produktionsZeit Die Produktionszeit (in Minuten) für das Sofa.
     */
    public int gibProduktionszeitMontage() {
        return this.produktionsZeitMontage;
    }
    
    /**
     * Methode, um die Produktionszeit für ein Sofa zu erhalten.
     * @return  produktionsZeit Die Produktionszeit (in Minuten) für das Sofa.
     */
    public int gibProduktionszeitSpritzung() {
        return this.produktionsZeitSpritzung;
    }
    
    /**
     * Methode, um die Produktionszeit für ein Sofa zu erhalten.
     * @return  produktionsZeit Die Produktionszeit (in Minuten) für das Sofa.
     */
    public int gibProduktionszeitVerpackung() {
        return this.produktionsZeitVerpackung;
    }
    
}
