
/**
 * Eine Klasse, welche die Parameter des Sofas enthält.
 * 
 * @author GBI Gruppe 19
 * @version 1.0
 */
public class Sofa extends Produkt {
    // Instanzvariablen
    private int kissen;
    

    /**
     * Konstruktor für Instanzen der Klasse Sofa, wenn Parameter von extern einfliessen sollen.
     * @param   zustand   Das ist der Zustand.
     * @param   holzeinheiten   Das sind die Anzahl Einheiten Holz, die für das Produkt benötigt werden.
     * @param   schrauben   Das sind die Anzahl Schrauben, die für das Produkt benötigt werden.
     * @param   Anzahl Kissen welche zum Produkt gehören.
     * @param   farbeinheiten   Das sind die Anzahl Einheiten Farbe, die für das Produkt benötigt werden.
     * @param   kartoneinheiten   Das sind die Anzahl Einheiten Karton, die für das Produkt benötigt werden.
     * @param   produktionsZeit   Das ist die Zeit (in Minuten) welche zur Produktion des Produkts benötigt wird.
     */
    public Sofa(int holzeinheiten, int schrauben, int kissen, int farbeinheiten, int kartoneinheiten, int produktionsZeit) {
        // Instanzvariable initialisieren
       super(holzeinheiten, schrauben, farbeinheiten, kartoneinheiten, produktionsZeit);
       this.kissen = kissen;
    }

    /**
    * Konstruktor für Objekte der Klasse Sofa, wenn Default-Parameter verwendet werden sollen.
    */
    public Sofa() {
        // Instanzvariable initialisieren
        super(4, 5, 1, 5, 20); 
        this.kissen = 5;
    }



    /// Getters und Setters


    /**
     * Methode, um die Anzahl an Kissen zu setzen.
     * @param   kissen  Anzahl Kissen welche zum Produkt Sofa gehören.
     */
    public void setzeKissen(int kissen) {
        this.kissen = kissen;
    }

    /**
     * Methode, um benötigte Anzahl Kissen für ein Sofa zu erhalten.
     * @return  kissen  Anzahl Kissen welche zum Produkt Sofa gehören.
     */
    public int gibKissen() {
        return this.kissen;
    }
    
}
