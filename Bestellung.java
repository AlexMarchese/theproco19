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
    private int beschaffungsZeit; // in Minuten
    private int beschaffungsZeitInTagen; // zur Ausgabe der beschaffungsZeit in Tagen
    private int anzahlSofas;
    private int anzahlStuehle;
    private int bestellungsNr;

    /**
     * Konstruktor für die Objekt der Klasse Bestellung
     */
    public Bestellung(int anzahlSofas, int anzahlStuehle, int bestellungsNr) {
        // Stellt sicher, dass die Klasse nicht mit Negativwerten instanziert wird   //Alex: rausnehmen?
        if (anzahlSofas < 0 || anzahlStuehle < 0) {
            throw new IllegalArgumentException("Bitte geben Sie keine negativen Werte für die Anzahl an.");

        } else {
            // Instanzvariablen initialisieren
            this.bestellteProdukte = new ArrayList<Produkt>(); 
            this.bestellBestaetigung = false;
            this.beschaffungsZeit = 1440; // Minuten
            this.anzahlSofas = anzahlSofas;
            this.anzahlStuehle = anzahlStuehle;
            this.bestellungsNr = bestellungsNr; // Wird von der Klasse Fabrik gegeben 
            this.bestellteProdukteHinzufuegen();
        
        }
        
    }
  


    /// Getters und Setters

    /**
     * Methode zum Setzen der ArrayList mit den bestellten Produkten.
     * 
     * @param   produkte   ArrayList mit den bestellten Produkten
     */
    public void setzeBestellteProdukte(ArrayList<Produkt> produkte) {
        this.bestellteProdukte = produkte;
    }    
    
    /**
     * Methode zur Ausgabe der Liste der bestellten Produkte.
     * 
     * @return  bestellteProdukte   ArrayList<Produkt> mit den Referenzen zu den bestellten Produkten
     */
    public ArrayList<Produkt> gibBestellteProdukte() {
        return this.bestellteProdukte;
    }
    
    /**
     * Methode zum Setzen der Variable bestellBestaetigung.
     * 
     * @param   zustand Zustand der Bestellbestätigung
     */
    public void setzeBestellBestaetigung(Boolean status) {
        this.bestellBestaetigung = status;
    }
    
    /**
     * Methode zur Ausgabe der Variable bestellBestaetigung.
     * 
     * @return  bestellBestaetigung Boolean zur Identifizierung, ob eine Bestellung bestätigt ist oder nicht
     */
    public boolean gibBestellBestaetigung() {
        return this.bestellBestaetigung;
    }

    /**
     * Methode zum Setzen der Beschaffungszeit. Rechnet die angegebenen Tage in Minuten um und gibt
     *  der Variable beschaffungsZeit den umgerechneten Wert. Fehlermeldung, wenn ein negativer Wert angegeben wird
     * 
     * @param zeit Zeitangabe in Tagen
     */
    public void setzeBeschaffungszeit(int zeit) {
        if(zeit >= 0) {
            this.beschaffungsZeit = zeit * 1140;
        } else {
            System.out.println("\nDer angegebene Wert (" + zeit + ") ist ungültig:"
                                + "\n   Bitte geben Sie für die Beschaffungszeit eine Zahl ein, die grösser oder gleich 0 ist.");
        }
    }
    
    /**
     * Methode zur Ausgabe der Beschaffungszeit in Tagen. Rechnet die Anzahl Minuten in Tage um und gibt diese aus.
     * 
     * @return beschaffungsZeitInTagen Zeitangabe in Tagen
     */
    public int gibBeschaffungszeit() {
        beschaffungsZeitInTagen = this.beschaffungsZeit / 1440;
        return beschaffungsZeitInTagen;
    }

    /**
     * Methode zum Setzen der Bestellnummer.
     * 
     * @param   bestellNummer   Bestellnummer, die von Fabrik gegeben wird
     */
    public void setzeBestellungsNr(int bestellNummer) {
        if(bestellNummer > 0) {
            this.bestellungsNr = bestellNummer;
        } else {
            System.out.println("\nDer angegebene Wert (" + bestellNummer + ") ist ungültig:"
                                + "\n   Bitte geben Sie für die Bestellnummer eine Zahl ein, die grösser ist als 0.");
        }
    }
    
    /**
     * Methode zur Ausgabe der Bestellnummer.
     * 
     * @return  bestellungsNr   die Bestellnummer
     */
    public int gibBestellungsNr() {
        return this.bestellungsNr;
    }

    /**
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

    /**
     * Methode zur Ausgabe der Anzahl bestellter Stühle.
     * 
     * @return  anzahlStuehle Anzahl bestellter Stühle
     */
    public int gibAnzahlStuehle() {
        return this.anzahlStuehle;
    }

    /**
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

    /**
     * Methode zur Ausgabe der Anzahl bestellter Sofas.
     * 
     * @return  anzahlSofas Anzahl bestellter Sofas
     */
    public int gibAnzahlSofas() {
        return this.anzahlSofas;
    }

    
    /// Methoden


    /**
     * Methode zum hinzufügen der bestellten Produkte in die zugehörige Liste. 
     * Wird bei der Initialisierung einer Bestellung automatisch ausgeführt.
     */
    private void bestellteProdukteHinzufuegen() {     
        int stuhlCount = 0;
        int sofaCount = 0;
        while(stuhlCount < this.anzahlStuehle) {
            Produkt stuhl = new Stuhl();
            this.bestellteProdukte.add(stuhl);
            stuhlCount++;
        }
        
        while(sofaCount < this.anzahlSofas) {
            Produkt sofa = new Sofa();
            this.bestellteProdukte.add(sofa);
            sofaCount++;
        }
    }

    /**
     * Methode zur Bestaetigung der Bestellung. Setzt bestellBestaetigung auf true und
     * gibt die Information aus, dass die Bestellung bestaetigt ist.
     * 
     * @param   String  Text zur Bestellbestätigung
     * 
     * Anstelle der üblichen Ausgabe, geben wir den Inhalt als String zurück. Es ermöglicht ein vereinfachter Unit Test.
     */
    public String bestellungBestaetigen() {
        this.bestellBestaetigung = true;
        return "Bestellung Nr. " + bestellungsNr + " bestätigt.";
    }
    
    /**
     * Methode zur Überprüfung des Status der Bestellbestaetigung. Gibt Auskunft, ob eine
     * Bestellung bestaetigt wurde oder nicht.
     */
    public void ueberpruefeBestellbestaetigung() {
        if(this.bestellBestaetigung){
            System.out.println("Die Bestellung mit der Nr. " + this.bestellungsNr +
                            " ist bestätigt.");
            } else {                    
            System.out.println("Die Bestellung mit der Nr. " + this.bestellungsNr +
                            " ist nicht bestätigt."); 
            }
    }
}
