
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
        //muss noch überarbeitet werden, da 20 die Summe ist. //brauchen wie hier noch zusatz "this.xxx"? 
        //theoretisch 2 Konstruktoren möglich einer Dummy variable / einer mt parameter
    }



    /// Getters und Setters


    /**
     * Methode, um die Anzahl an Kissen zu setzen
     */
    public void setzeKissen(int kissen) {
        // fehlt: if loop um zu vermeiden, dass ein ungültiger value eingegeben wird
        this.kissen = kissen;
    }

    /**
     * Methode, um benötigte Kissen für ein Sofa zu erhalten
     */
    public int gibKissen() {
        return this.kissen;
    }
    
}
