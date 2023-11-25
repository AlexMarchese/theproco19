import java.util.LinkedList;

/**
 * Die Klasse Roboter produziert die Bestellungen, welche vom Produktionsmanager in Auftrag gegeben werden und gibt die Info 
 * 
 * 
 * @author GBI Gruppe 19
 * @version 1.0
 * 
 */
public class Roboter extends Thread
{
    // Instanzvariablen 
    /*LinkedList <Produkt> warteschlange;
    public String name; 
    public int produktionsZeit;
    */
    private LinkedList <Produkt> warteschlange;
    private String name; 
    private int produktionsZeit;

    /**
     * Konstruktor für Objekte der Klasse Roboter
     *  
     */
    public Roboter()
    {
        // Instanzvariable initialisieren
        this.warteschlange = new LinkedList<Produkt>();
        String name;
        int produktionsZeit; 
    }

    
    /// Getters und Setters

    /**
     * Methode, um die Produktionszeit zu setzen.
     * @param   produktionsZeit Die Zeit, die es benötigt um die Produkte zu produzieren.
     */
    public void setzeProduktionsZeit(int produktionsZeit) {
        this.produktionsZeit = produktionsZeit;
    }
    
    /**
     * Methode, um die Produktionszeit zu setzen.
     * @param   produktionsZeit Die Zeit, die es benötigt um die Produkte zu produzieren.
     */
    public int gibProduktionsZeit() {
        return this.produktionsZeit;
    }
    
    /**
     * Methode, um den Name zu setzen.
     * @param   name Der Name, der die Bestellung hat.
     */
    public void setzeName(String name) {
        this.name = name;
    }
    
    /**
     * Methode, um den Namen zu setzen.
     * @param   name Der Name, der die Bestellung hat.
     */
    public String gibName() {
        return this.name;
    }
    
    /// Methoden
    
    /**
     * Methode, 
     */
    public void run(){
        //muss noch im Rahmen des Threads eingefügt werden
    }
    
    /**
     * Methode, 
     */
    public void fuegeProduktHinzu(Produkt produkt){
        //
    }
    
    /**
     * Methode, 
     */
    public void produziereProdukt(Produkt produkt){
        //
    }
    
    
}
