import java.util.ArrayList;
/**
 * Klasse zur Definition von Objekten, die eine Bestellung beinhalten.
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
        this.beschaffungsZeit = 2; //Welche Beschaffungszeit? Haben wir das nicht auf Lager?
        this.anzahlSofas = anzahlSofas;
        this.anzahlStuehle = anzahlStuehle;
        this.bestellungsNr = 0;
        
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
        if(this.bestellBestaetigung == true){
            return true;
        }else {
        return false;} // ggf noch zu aendern, wozu brauchen wir das?
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
        return anzahlStuehle;
    }
    
    /*
     * 
     */
    public int gibAnzahlSofas()
    {
        return anzahlSofas;
    }
    
    
    
}
