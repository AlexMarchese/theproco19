
/**
 * Eine Klasse, welche die Parameter des Stuhls enthält.
 * 
 * @author GBI Gruppe 19
 * @version 1.0
 */
public class Stuhl
{
    // Instanzvariablen
    private int holzeinheiten;
    private int schrauben;
    private int farbeinheiten;
    private int kartoneinheiten;
    private int produktionsZeit; 

    /**
     * Konstruktor für Objekte der Klasse Stuhl, wenn Parameter von extern einfliessen sollen.
     */
    public Stuhl(int holzeinheiten, int schrauben, int farbeinheiten, int kartoneinheiten, int produktionsZeit)
    {
        // Instanzvariable initialisieren
        this.holzeinheiten = holzeinheiten;
        this.schrauben = schrauben;
        this.farbeinheiten = farbeinheiten;
        this.kartoneinheiten = kartoneinheiten;
        this.produktionsZeit = produktionsZeit;
    }

        /**
     * Konstruktor für Objekte der Klasse Stuhl, wenn Default-Parameter verwendet werden sollen.
     */
    public Stuhl()
    {
        // Instanzvariable initialisieren
        this.holzeinheiten = 2;
        this.schrauben = 10;
        this.farbeinheiten = 2;
        this.kartoneinheiten = 1;
        this.produktionsZeit = 22; //muss noch überarbeitet werden, da 22 die Summe ist. //brauchen wie hier noch zusatz "this.xxx"? 
        //theoretisch 2 Konstruktoren möglich einer Dummy variable / einer mt parameter
    }
    
    
    /**
     * Methode, um benötigte Holzeinheiten für einen Stuhl zu erhalten
     * 
     */
    public int getHolzeinheiten()
    {
        return holzeinheiten; //brauchen wie hier noch zusatz "this.xxx"?
        
    }
    
        /**
     * Methode, um benötigte Holzeinheiten für einen Stuhl zu erhalten
     * 
     */
    public int getSchrauben()
    {
        return schrauben;//brauchen wie hier noch zusatz "this.xxx"?
        
    }
    
        /**
     * Methode, um benötigte Holzeinheiten für einen Stuhl zu erhalten
     * 
     */
    public int getFarbeinheiten()
    {
        return farbeinheiten;//brauchen wie hier noch zusatz "this.xxx"?
        
    }
    
        /**
     * Methode, um benötigte Holzeinheiten für einen Stuhl zu erhalten
     * 
     */
    public int getKartoneinheiten()
    {
        return kartoneinheiten;//brauchen wie hier noch zusatz "this.xxx"?
        
    }
    
        /**
     * Methode, um benötigte Holzeinheiten für einen Stuhl zu erhalten
     * 
     */
    public int getTotalProduktionszeit() //muss noch angepasst werden, falls Produktionszeit nicht Total, sondern für bestimmten Prodktionsschritt ist.
    {
        return produktionsZeit;//brauchen wie hier noch zusatz "this.xxx"?
        
    }
}
