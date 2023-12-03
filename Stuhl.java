
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

    private final static int produktionsZeit = 22; //in Minuten



    /**
     * Konstruktor für Objekte der Klasse Stuhl
     */
    public Stuhl() {
        super();

        super.setzeProduktionszeitHolz(10); // in Minuten
        super.setzeProduktionszeitMontage(5); // in Minuten
        super.setzeProduktionszeitSpritzung(2); // in Minuten
        super.setzeProduktionszeitVerpackung(5); // in Minuten
        

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
