
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

    // // private final static int produktionsZeitHolz;
    // private final int produktionsZeitHolz = 30;
    // private final int produktionsZeitMontage = 5;
    // private final int produktionsZeitSpritzung = 15;
    // private final int produktionsZeitVerpackung = 10;
    
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
        // this.produktionsAblauf.add(new Holzarbeitungs_Roboter());
        // this.produktionsAblauf.add(new Montage_Roboter());
        // this.produktionsAblauf.add(new Lackier_Roboter());
        // this.produktionsAblauf.add(new Verpackungs_Roboter());

        super.setzeProduktionszeitHolz(30); // in Minuten
        super.setzeProduktionszeitMontage(5); // in Minuten
        super.setzeProduktionszeitSpritzung(15); // in Minuten
        super.setzeProduktionszeitVerpackung(10); // in Minuten
        

    }

    /// Getters und Setters

    /**
     * Methode, um benötigte Holzeinheiten für einen Stuhl zu erhalten.
     * @return  holzeinheiten   Die  benötigten Einheiten Holz für den Stuhl.
     */
    public static int gibHolzeinheiten() {
        return Stuhl.holzeinheiten;
    }

    /**
     * Methode, um benötigte Schrauben für einen Stuhl zu erhalten.
     * @return  schrauben   Die  benötigte Anzahl Schrauben für den Stuhl.
     */
    public static int gibSchrauben() {
        return Stuhl.schrauben;
    }
    
    /**
     * Methode, um benötigte Farbeinheiten für einen Stuhl zu erhalten.
     * @return  farbeinheiten   Die  benötigten Einheiten Farbe für den Stuhl.
     */
    public static int gibFarbeinheiten() {
        return Stuhl.farbeinheiten;
    }

    /**
     * Methode, um benötigte Kartoneinheiten für einen Stuhl zu erhalten.
     * @return  kartoneinheiten Die benötigten Einheiten Karton für den Stuhl.
     */
    public static int gibKartoneinheiten() {
        return Stuhl.kartoneinheiten;
    }

    /**
     * Methode, um die Produktionszeit für einen Stuhl zu erhalten.
     * @return  produktionsZeit Die totale Produktionszeit (in Minuten) für den Stuhl.
     */
    public static int gibTotalProduktionszeit() {
        return Stuhl.produktionsZeit;
    }
    
   
    
}
