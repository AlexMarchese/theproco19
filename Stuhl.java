
/**
 * Die Klasse Stuhl umfasst die Informationen zum Stuhl und die dazugehörige Methoden.
 * 
 * @author GBI Gruppe 19
 * @version 1.0
 */
public class Stuhl extends Produkt
{
    private final static int holzeinheiten = 2;
    private final static int schrauben = 10;
    private final static int farbeinheiten = 2;
    private final static int kartoneinheiten = 1;
    private final static int produktionsZeit = 22;
    
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
        super();       // check the difference with not writing it!!
                        // setters away | getters change, but do not add static!
        

    }

    /// Getters und Setters

    /**
     * Methode, um benötigte Holzeinheiten für einen Stuhl zu erhalten.
     * @return  holzeinheiten   Die  benötigten Einheiten Holz für den Stuhl.
     */
    public int gibHolzeinheiten() {
        return Stuhl.holzeinheiten;
    }

    /**
     * Methode, um benötigte Schrauben für einen Stuhl zu erhalten.
     * @return  schrauben   Die  benötigte Anzahl Schrauben für den Stuhl.
     */
    public int gibSchrauben() {
        return Stuhl.schrauben;
    }
    
    /**
     * Methode, um benötigte Farbeinheiten für einen Stuhl zu erhalten.
     * @return  farbeinheiten   Die  benötigten Einheiten Farbe für den Stuhl.
     */
    public int gibFarbeinheiten() {
        return Stuhl.farbeinheiten;
    }

    /**
     * Methode, um benötigte Kartoneinheiten für einen Stuhl zu erhalten.
     * @return  kartoneinheiten Die benötigten Einheiten Karton für den Stuhl.
     */
    public int gibKartoneinheiten() {
        return Stuhl.kartoneinheiten;
    }
    
    /**
     * Methode, um die Produktionszeit für einen Stuhl zu erhalten.
     * @return  produktionsZeit Die totale Produktionszeit (in Minuten) für den Stuhl.
     */
    public int gibTotalProduktionszeit() {
        return Stuhl.produktionsZeit;
    }
    
}
