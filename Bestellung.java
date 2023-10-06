import java.util.ArrayList;
/**
 * Klasse zur Definition von Instanzen, die eine Bestellung beinhalten.
 * 
 * @author GBI Gruppe 19
 * @version 1.0
 */
public class Bestellung
{
    // Instanzvariablen
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
        this.bestellteProdukte = new ArrayList<Produkt>();
        this.bestellBestaetigung = false;
        this.beschaffungsZeit = 1; //Welche Beschaffungszeit? Haben wir das nicht auf Lager? Produktionsdauer?
        this.anzahlSofas = anzahlSofas;
        this.anzahlStuehle = anzahlStuehle;
        this.bestellungsNr = 0; //muss von Fabrik gegeben werden
        
    }

   
    /*
     * 
     */
    public void bestellungBestaetigen()
    {
        this.bestellBestaetigung = true;
        System.out.println("Bestellung Nr. " + bestellungsNr + "bestaetigt");
    }
    
    /*
     * 
     */
    public boolean gibBestellBestaetigung()
    {
        return this.bestellBestaetigung;
    }
    
    /*
     * 
     */
    public void setzeBeschaffungszeit(int zeit)
    {
        this.beschaffungsZeit = zeit;
    }
    
    /*
     * 
     */
    public int gibBeschaffungszeit()
    {
        return this.beschaffungsZeit;
    }
    
    /*
     * 
     */
    public int gibBestellungsNr()
    {
        return this.bestellungsNr;
    }
    
    /*
     * 
     */
    public int gibAnzahlStuehle()
    {
        return this.anzahlStuehle;
    }
    
    /*
     * 
     */
    public int gibAnzahlSofas()
    {
        return this.anzahlSofas;
    }
    
    
    
}
