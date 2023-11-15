
/**
 * Die Klasse Stuhl umfasst die Informationen zum Stuhl und die dazugehörige Methoden.
 * 
 * @author GBI Gruppe 19
 * @version 1.0
 */
public class Stuhl extends Produkt
{
    private static int holzeinheiten;
    private static int schrauben;
    private static int farbeinheiten;
    private static int kartoneinheiten;
    private static int produktionsZeit;
    
    // /**
    //  * Konstruktor für Instanzen der Klasse Stuhl, wenn Parameter von extern einfliessen sollen.
    // * @param   holzeinheiten    Das ist die Anzahl der Einheiten Holz, welche für das Produkt benötigt werden.
    // * @param   schrauben        Das ist die Anzahl der Schrauben, die für das Produkt benötigt werden.
    // * @param   farbeinheiten    Das ist die Anzahl der Einheiten Farbe, die für das Produkt benötigt werden.
    // * @param   kartoneinheiten  Das ist die Anzahl der Einheiten Karton, die für das Produkt benötigt werden.
    // * @param   produktionsZeit  Das ist die Zeit (in Minuten), welche zur Produktion des Produkts benötigt wird.
    //  */
    // public Stuhl(int holzeinheiten, int schrauben, int farbeinheiten, int kartoneinheiten, int produktionsZeit) {
    //     // Instanzvariable initialisieren
    //     super(holzeinheiten, schrauben, farbeinheiten, kartoneinheiten, produktionsZeit);
    // }

    /**
     * Konstruktor für Objekte der Klasse Stuhl
     */
    public Stuhl() {
        super();
        // Instanzvariable initialisieren
        holzeinheiten = 2;
        schrauben = 10;
        farbeinheiten = 2;
        kartoneinheiten = 1;
        produktionsZeit = 22;
        
        
        // super(2, 10, 2, 1, 22); 

    }
    
}
