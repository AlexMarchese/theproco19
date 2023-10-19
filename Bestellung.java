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
    public Bestellung(int anzahlSofas, int anzahlStuehle, int bestellungsNr) throws Exception {
        // Stellt sicher, dass die Klasse nicht mit Negativwerten instanziert wird
        if (anzahlSofas < 0 || anzahlStuehle < 0) {
            throw new Exception("Bitte geben Sie keine negativen Werte für die Anzahl an.");
        } 
        // Instanzvariablen initialisieren
        this.bestellteProdukte = new ArrayList<Produkt>(); //es fehlen ja noch die Stühle und Sofas in der Liste -> weg?
        this.bestellBestaetigung = false;
        this.beschaffungsZeit = 1; //Welche Beschaffungszeit? Haben wir das nicht auf Lager? Produktionsdauer? -> ?
        this.anzahlSofas = anzahlSofas;
        this.anzahlStuehle = anzahlStuehle;
        this.bestellungsNr = bestellungsNr; // Wird von Fabrik gegeben 
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
    


    /// Getters und Setters


    /*
     * Methode zum Setzen der Variable bestellBestaetigung.
     * 
     * @param   zustand Zustand der Bestellbestätigung
     */
    public void setzeBestellBestaetigung(Boolean zustand) {
        this.bestellBestaetigung = zustand;
    }
    
    /*
     * Methode zur Ausgabe der Variable bestellBestaetigung.
     * 
     * @return  bestellBestaetigung Bestellbestätigung
     */
    public boolean gibBestellBestaetigung() {
        return this.bestellBestaetigung;
    }

    /*
     * Methode zum Setzen der Beschaffungszeit. Gibt der Variable beschaffungsZeit den
     * angegebenen Wert. Fehlermeldung, wenn ein negativer Wert (oder 0) angegeben wird.
     * 
     * @param zeit Zeitangabe in Tagen
     */
    public void setzeBeschaffungszeit(int zeit) {
        if(zeit > 0) {
            this.beschaffungsZeit = zeit;
        } else {
            System.out.println("\nDer angegebene Wert (" + zeit + ") ist ungültig:"
                                + "\n   Bitte geben Sie für die Beschaffungszeit eine Zahl ein, die grösser ist als 0.");
        }
    }
    
    /*
     * Methode zur Ausgabe der Beschaffungszeit.
     * 
     * @return beschaffungsZeit Zeitangabe in Tagen
     */
    public int gibBeschaffungszeit() {
        return this.beschaffungsZeit;
    }

    /*
     * Methode zum Setzen der Bestellnummer.
     * 
     * @param   nummer   die Bestellnummer
     */
    public void setzeBestellungsNr(int nummer) {
        if(nummer > 0) {
            this.bestellungsNr = nummer;
        } else {
            System.out.println("\nDer angegebene Wert (" + nummer + ") ist ungültig:"
                                + "\n   Bitte geben Sie für die Bestellnummer eine Zahl ein, die grösser ist als 0.");
        }
    }
    
    /*
     * Methode zur Ausgabe der Bestellnummer.
     * 
     * @return  bestellungsNr   die Bestellnummer
     */
    public int gibBestellungsNr() {
        return this.bestellungsNr;
    }

    /*
     * Methode zur Anpassung der AnzahlStuehle. Gibt der Variable AnzahlStuehle den
     * angegebenen Wert. Fehlermeldung, wenn ein negativer Wert (oder 0) angegeben wird.
     * 
     * @param   menge   Menge an Stühlen
     */
    public void setzeAnzahlStuehle(int menge) {
        if(menge >= 0) {
            this.anzahlStuehle = menge;
        } else {
            System.out.println("\nDer angegebene Wert (" + menge + ") ist ungültig:"
                                + "\n   Bitte geben Sie für die Anzahl Stühle eine Zahl ein, die nicht negativ ist.");
        }
    }

    /*
     * Methode zur Ausgabe der Anzahl bestellter Stühle.
     * 
     * @return  anzahlSofas Anzahl bestellter Stühle
     */
    public int gibAnzahlStuehle() {
        return this.anzahlStuehle;
    }

    /*
     * Methode zur Anpassung der AnzahlSofas. Gibt der Variable AnzahlSofas den
     * angegebenen Wert. Fehlermeldung, wenn ein negativer Wert (oder 0) angegeben wird.
     * 
     * @param menge Menge an Sofas
     */
    public void setzeAnzahlSofas(int menge) {
        if(menge >= 0) {
            this.anzahlSofas = menge;
        } else {
            System.out.println("\nDer angegebene Wert (" + menge + ") ist ungültig:"
                                + "\n   Bitte geben Sie für die Anzahl Sofas eine Zahl ein, die nicht negativ ist.");
        }
    }

    /*
     * Methode zur Ausgabe der Anzahl bestellter Sofas.
     * 
     * @return  anzahlSofas Anzahl bestellter Sofas
     */
    public int gibAnzahlSofas() {
        return this.anzahlSofas;
    }

    /*
     * Methode zum Setzen der Array mit den bestellten Produkten.
     * 
     * @param   produkte   Array mit den bestellten Produkten
     */
    public void setzeBestellteProdukte(ArrayList<Produkt> produkte) {
        this.bestellteProdukte = produkte;
    }

    /*
     * Methode zur Ausgabe der Array mit den bestellten Produkten.
     * 
     * @return  bestellteProdukte   Array mit den bestellten Produkten
     */
    public ArrayList<Produkt> gibBestellteProdukte() {
        return this.bestellteProdukte;
    }


    

    /// Methoden

    /*
     * Methode zur Bestaetigung der Bestellung. Setzt bestellBestaetigung auf true und
     * gibt die Information aus, dass die Bestellung bestaetigt ist.
     */
    public void bestellungBestaetigen() {
        this.bestellBestaetigung = true;
        System.out.println("Bestellung Nr. " + bestellungsNr + " bestaetigt.");
    }
    
        
    
    
   
    
    
    

    
    
    
    
    
    
}
