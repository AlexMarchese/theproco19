
/**
 * Eine Klasse, welche die Parameter des Sofas enthält.
 * 
 * @author GBI Gruppe 19
 * @version 1.0
 */
public class Sofa
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private int holzeinheiten;
    private int schrauben;
    private int kissen;
    private int farbeinheiten;
    private int kartoneinheiten;
    private int produktionsZeit;

    /**
     * Konstruktor für Objekte der Klasse Sofa, wenn Parameter von extern einfliessen sollen.
     */
    public Sofa(int holzeinheiten, int schrauben, int kissen, int farbeinheiten, int kartoneinheiten, int produktionsZeit)
    {
        // Instanzvariable initialisieren
        this.holzeinheiten = holzeinheiten;
        this.schrauben = schrauben;
        this.kissen = kissen;
        this.farbeinheiten = farbeinheiten;
        this.kartoneinheiten = kartoneinheiten;
        this.produktionsZeit = produktionsZeit;
    }

       /**
     * Konstruktor für Objekte der Klasse Sofa, wenn Default-Parameter verwendet werden sollen.
     */
    public Sofa()
    {
        // Instanzvariable initialisieren
        this.holzeinheiten = 4;
        this.schrauben = 5;
        this.kissen = 5;
        this.farbeinheiten = 1;
        this.kartoneinheiten = 5;
        this.produktionsZeit = 20; //muss noch überarbeitet werden, da 20 die Summe ist. //brauchen wie hier noch zusatz "this.xxx"? 
        //theoretisch 2 Konstruktoren möglich einer Dummy variable / einer mt parameter
  
    }

    /**
     * Methode, um benötigte Holzeinheiten für ein Sofa zu erhalten
     * 
     */
    public int getHolzeinheiten()
    {
        return holzeinheiten; //brauchen wie hier noch zusatz "this.xxx"?
        
    }
    
        /**
     * Methode, um benötigte Schrauben für ein Sofa zu erhalten
     * 
     */
    public int getSchrauben()
    {
        return schrauben;//brauchen wie hier noch zusatz "this.xxx"?
        
    }
    
    /**
     * Methode, um benötigte Kissen für ein Sofa zu erhalten
     * 
     */
    public int getKissen()
    {
        return kissen;//brauchen wie hier noch zusatz "this.xxx"?
        
    }
    
    /**
     * Methode, um benötigte Farbe für ein Sofa zu erhalten
     * 
     */
    public int getFarbeinheiten()
    {
        return farbeinheiten;//brauchen wie hier noch zusatz "this.xxx"?
        
    }
    
        /**
     * Methode, um benötigte Holzeinheiten für eine Sofa zu erhalten
     * 
     */
    public int getKartoneinheiten()
    {
        return kartoneinheiten;//brauchen wie hier noch zusatz "this.xxx"?
        
    }
    
        /**
     * Methode, um benötigte Produktionszeit für ein Sofa zu erhalten
     * 
     */
    public int getTotalProduktionszeit() //muss noch angepasst werden, falls Produktionszeit nicht Total, sondern für bestimmten Prodktionsschritt ist.
    {
        return produktionsZeit;//brauchen wie hier noch zusatz "this.xxx"?
        
    }
}
