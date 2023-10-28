
/**
 * Eine Klasse, welche die Parameter des Stuhls enthält.
 * 
 * @author GBI Gruppe 19
 * @version 1.0
 */
public class Stuhl extends Produkt
{
    // Es werden keine weiteren Instanzvariablen definiert
    
    
/**
 * Konstruktor für Instanzen der Klasse Stuhl, wenn Parameter von extern einfliessen sollen.
    * @param   zustand   Das ist der Zustand.
    * @param   holzeinheiten   Das ist die Anzahl Einheiten Holz, welche für das Produkt benötigt werden.
    * @param   schrauben   Das ist die Anzahl Schrauben, die für das Produkt benötigt werden.
    * @param   farbeinheiten   Das ist die Anzahl Einheiten Farbe, die für das Produkt benötigt werden.
    * @param   kartoneinheiten   Das ist die Anzahl Einheiten Karton, die für das Produkt benötigt werden.
    * @param   produktionsZeit   Das ist die Zeit (in Minuten), welche zur Produktion des Produkts benötigt wird.
     */
    public Stuhl(int holzeinheiten, int schrauben, int farbeinheiten, int kartoneinheiten, int produktionsZeit) {
        // Instanzvariable initialisieren
        super(holzeinheiten, schrauben, farbeinheiten, kartoneinheiten, produktionsZeit);
    }

    /**
     * Konstruktor für Objekte der Klasse Stuhl, wenn Default-Parameter verwendet werden sollen.
     */
    public Stuhl() {
        // Instanzvariable initialisieren
        super(2, 10, 2, 1, 22); 
    }
    
}
