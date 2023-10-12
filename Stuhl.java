
/**
 * Eine Klasse, welche die Parameter des Stuhls enthält.
 * 
 * @author GBI Gruppe 19
 * @version 1.0
 */
public class Stuhl extends Produkt
{
    // Instanzvariablen -> keine weiteren
    
    
    /**
     * Konstruktor für Objekte der Klasse Stuhl, wenn Parameter von extern einfliessen sollen.
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
        //muss noch überarbeitet werden, da 22 die Summe ist. //brauchen wie hier noch zusatz "this.xxx"? 
        //theoretisch 2 Konstruktoren möglich einer Dummy variable / einer mt parameter
    }
    
}
