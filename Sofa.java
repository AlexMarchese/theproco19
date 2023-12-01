
/**
 * Die Klasse Sofa umfasst die Informationen zum Sofa und die dazugehörige Methoden.
 * 
 * @author GBI Gruppe 19
 * @version 1.0
 */
public class Sofa extends Produkt
{
    private final static int holzeinheiten = 4;
    private final static int schrauben = 5;
    private final static int farbeinheiten = 1;
    private final static int kartoneinheiten = 5;
    private final static int kissen = 5;

    private final static int produktionsZeit = 60;

    // private int produktionsZeitHolz = 10;
    // private int produktionsZeitMontage = 5;
    // private int produktionsZeitSpritzung = 2;
    // private int produktionsZeitVerpackung = 5;
    
    // /**
    //  * Konstruktor für Instanzen der Klasse Sofa, wenn Parameter von extern einfliessen sollen.
    // * @param   holzeinheiten    Das ist die Anzahl der Einheiten Holz, welche für das Produkt benötigt werden.
    // * @param   schrauben        Das ist die Anzahl der Schrauben, die für das Produkt benötigt werden.
    // * @param   farbeinheiten    Das ist die Anzahl der Einheiten Farbe, die für das Produkt benötigt werden.
    // * @param   kartoneinheiten  Das ist die Anzahl der Einheiten Karton, die für das Produkt benötigt werden.
    // * @param   produktionsZeit  Das ist die Zeit (in Minuten), welche zur Produktion des Produkts benötigt wird.
    //  */
    // public Sofa(int holzeinheiten, int schrauben, int farbeinheiten, int kartoneinheiten, int produktionsZeit) {
    //     // Instanzvariable initialisieren
    //     super(holzeinheiten, schrauben, farbeinheiten, kartoneinheiten, produktionsZeit);
    // }

    /**
     * Konstruktor für Objekte der Klasse Sofa
     */
    public Sofa() {
        super();       
        // this.produktionsAblauf.add(new Holzarbeitungs_Roboter());
        // this.produktionsAblauf.add(new Lackier_Roboter());
        // this.produktionsAblauf.add(new Montage_Roboter());
        // this.produktionsAblauf.add(new Verpackungs_Roboter());

        super.setzeProduktionszeitHolz(10);
        super.setzeProduktionszeitMontage(5);
        super.setzeProduktionszeitSpritzung(2);
        super.setzeProduktionszeitVerpackung(5);
        

    }



    /// Getters und Setters

    /**
     * Methode, um benötigte Holzeinheiten für ein Sofa zu erhalten.
     * @return  holzeinheiten   Die  benötigten Einheiten Holz für das Sofa.
     */
    public static int gibHolzeinheiten() {
        return Sofa.holzeinheiten;
    }

    /**
     * Methode, um benötigte Schrauben für ein Sofa zu erhalten.
     * @return  schrauben   Die  benötigte Anzahl Schrauben für das Sofa.
     */
    public static int gibSchrauben() {
        return Sofa.schrauben;
    }
    
    /**
     * Methode, um benötigte Farbeinheiten für ein Sofa zu erhalten.
     * @return  farbeinheiten   Die  benötigten Einheiten Farbe für das Sofa.
     */
    public static int gibFarbeinheiten() {
        return Sofa.farbeinheiten;
    }

    /**
     * Methode, um benötigte Kartoneinheiten für ein Sofa zu erhalten.
     * @return  kartoneinheiten Die benötigten Einheiten Karton für das Sofa.
     */
    public static int gibKartoneinheiten() {
        return Sofa.kartoneinheiten;
    }

    /**
     * Methode, um benötigte Kissen für ein Sofa zu erhalten.
     * @return  Kissen Die benötigten Kissen für das Sofa.
     */
    public static int gibKissen() {
        return Sofa.kissen;
    }

    /**
     * Methode, um die Produktionszeit für ein Sofa zu erhalten.
     * @return  produktionsZeit Die totale Produktionszeit (in Minuten) für das Sofa.
     */
    public static int gibTotalProduktionszeit() {
        return Sofa.produktionsZeit;
    }
    
}
