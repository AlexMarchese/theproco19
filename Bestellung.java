import java.util.ArrayList;
/**
 * Beschreiben Sie hier die Klasse Bestellung.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Bestellung
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private ArrayList<Produkt> bestellteProdukte;
    private boolean bestellBestaetigung;
    private int beschaffungsZeit;
    private int anzahlSofas;
    private int anzahlStuehle;
    private int bestellungsNr;


    /**
     * Konstruktor für Objekte der Klasse Bestellung
     */
    public Bestellung(int anzahlSofas, int anzahlStuehle)
    {
        // Instanzvariable initialisieren
        this.anzahlSofas = anzahlSofas;
        this.anzahlStuehle = anzahlStuehle;
        // die anderen Attribute muessen auch noch initalisiert werden
    }

   
    /*
     * 
     */
    public void bestellungBestaetigen()
    {
        //pass
    }
    
    /*
     * 
     */
    public boolean gibBestellBestaetigung()
    {
        return true; // ggf noch zu aendern
    }
    
    /*
     * 
     */
    public void setzeBeschaffungszeit(int zeit)
    {
        //pass
    }
    
    /*
     * 
     */
    public int gibBeschaffungszeit()
    {
        return 1; // noch zu aendern
    }
    
    /*
     * 
     */
    public int gibBestellungsNr()
    {
        return 1; // noch zu aendern
    }
    
    /*
     * 
     */
    public int gibAnzahlStuehle()
    {
        return 1; // noch zu aendern
    }
    
    /*
     * 
     */
    public int gibAnzahlSofas()
    {
        return 1; // noch zu aendern
    }
    
    
    
}
