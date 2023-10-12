import java.util.ArrayList;
/**
 * Klasse zur Erstellung von Bestellungen, die Sofas und Stühle beinhalten.
 * 
 * @author GBI Gruppe 19
 * @version 1.0
 */
public class Bestellung {
    // Instanzvariablen
    private ArrayList<Produkt> bestellteProdukte;
    private boolean bestellBestaetigung;
    private int beschaffungsZeit;
    private int anzahlSofas;
    private int anzahlStuehle;
    private int bestellungsNr;


    /**
     * Konstruktor
     */
    public Bestellung(int anzahlSofas, int anzahlStuehle, int bestellungsNr) {
        // Instanzvariable initialisieren
        this.bestellteProdukte = new ArrayList<Produkt>(); //es fehlen ja noch die Stühle und Sofas in der Liste
        this.bestellBestaetigung = false;
        this.beschaffungsZeit = 1; //Welche Beschaffungszeit? Haben wir das nicht auf Lager? Produktionsdauer?
        this.anzahlSofas = anzahlSofas;
        this.anzahlStuehle = anzahlStuehle;
        this.bestellungsNr = bestellungsNr; //muss von Fabrik gegeben werden
        this.bestellteProdukteHinzufuegen();
    }

     /* 
      * Methode zum hinzufügen der bestellten Produkte in die zugehörige Liste. 
      * Wird bei der Initialisierung einer Bestellung automatisch ausgeführt.
     */
    private void bestellteProdukteHinzufuegen() {     
        int stuhlCount = 0;
        int sofaCount = 0;
        while(stuhlCount < this.anzahlStuehle) {
            this.bestellteProdukte.add(new Stuhl());
            stuhlCount++;
        }
        
        while(sofaCount < this.anzahlSofas) {
            this.bestellteProdukte.add(new Sofa());
            sofaCount++;
        }
    }

        
    
    /*
     * Methode zur Bestaetigung der Bestellung. Setzt bestellBestaetigung auf true und
     * gibt die Information aus, dass die Bestellung bestaetigt ist.
     */
    public void bestellungBestaetigen() {
        this.bestellBestaetigung = true;
        System.out.println("Bestellung Nr. " + bestellungsNr + " bestaetigt.");
    }
    
    /*
     * Methode zur Ausgabe der Variable bestellBestaetigung.
     */
    public boolean gibBestellBestaetigung() {
        return this.bestellBestaetigung;
    }
    
    /*
     * Methode zur Anpassung der Beschaffungszeit. Gibt der Variable beschaffungsZeit den
     * angegebenen Wert. Fehlermeldung, wenn ein negativer Wert (oder 0) angegeben wird.
     * 
     * @param zeit Zeitangabe in Tagen
     */
    public void setzeBeschaffungszeit(int zeit) {
        if(zeit>0) {
            this.beschaffungsZeit = zeit;
        } else {
            System.out.println("\nDer angegebene Wert (" + zeit + ") ist ungültig:"
                                + "\n   Bitte geben Sie für die Beschaffungszeit eine Zahl ein, die grösser ist als 0.");
        }
    }
    
    /*
     * Methode zur Ausgabe der gesetzten Beschaffungszeit.
     */
    public int gibBeschaffungszeit() {
        return this.beschaffungsZeit;
    }
    
    /*
     * Methode zur Ausgabe der Bestellnummer.
     */
    public int gibBestellungsNr() {
        return this.bestellungsNr;
    }
    
    /*
     * Methode zur Ausgabe der Anzahl bestellter Stühle.
     */
    public int gibAnzahlStuehle() {
        return this.anzahlStuehle;
    }
    
    /*
     * Methode zur Ausgabe der Anzahl bestellter Sofas.
     */
    public int gibAnzahlSofas() {
        return this.anzahlSofas;
    }
    
    public ArrayList<Produkt> gibBestellteProdukte() {
        return this.bestellteProdukte;
    }
    
    
    
}
