
/**
 * Die Klasse Sofa umfasst die Informationen zum Sofa und die dazugehörige Methoden.
 * 
 * @author GBI Gruppe 19
 * @version 2.0
 */
public class Sofa extends Produkt
{
    private final static int holzeinheiten = 4;
    private final static int schrauben = 5;
    private final static int farbeinheiten = 1;
    private final static int kartoneinheiten = 5;
    private final static int kissen = 5;

    private final static int produktionsZeit = 60;//in Minuten

    /**
     * Konstruktor für Objekte der Klasse Sofa
     */
    public Sofa() {
        super();
        
        super.setzeProduktionszeitHolz(30); //in Minuten
        super.setzeProduktionszeitSpritzung(5); //in Minuten
        super.setzeProduktionszeitMontage(15); //in Minuten
        super.setzeProduktionszeitVerpackung(10); //in Minuten
        

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
