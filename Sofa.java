
/**
 * Die Klasse Sofa umfasst die Informationen zum Sofa und die dazugehörigen Methoden.
 * 
 * @author GBI Gruppe 19
 * @version 1.0
 */
public class Sofa extends Produkt {
    // Instanzvariablen
    private int kissen;
    

    /**
     * Konstruktor für Instanzen der Klasse Sofa, wenn Parameter von extern einfliessen sollen.
     * @param   holzeinheiten   Das ist die Anzahl der Einheiten Holz, die für das Produkt benötigt werden.
     * @param   schrauben       Das ist die Anzahl der Schrauben, die für das Produkt benötigt werden.
     * @param   kissen          Das ist die Anzahl der Kissen, welche zum Produkt gehören.
     * @param   farbeinheiten   Das ist die Anzahl der Einheiten Farbe, die für das Produkt benötigt werden.
     * @param   kartoneinheiten Das ist die Anzahl der Einheiten Karton, die für das Produkt benötigt werden.
     * @param   produktionsZeit Das ist die Zeit (in Minuten) welche zur Produktion des Produkts benötigt wird.
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
