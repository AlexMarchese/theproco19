import java.util.ArrayList;
/**
 * Die Klasse Bestellung umfasst die Informationen zu den Bestellungen und die dazugehörigen Methoden.
 * Sie dient zur Erstellung von Bestellungen, die Sofas und Stühle beinhalten.
 * 
 * @author GBI Gruppe 19
 * @version 1.0
 */
public class Bestellung {
    // Instanzvariablen
    private ArrayList<Produkt> bestellteProdukte;
    private boolean bestellBestaetigung;
    private int beschaffungsZeit; // in Tagen
    private int anzahlSofas;
    private int anzahlStuehle;
    private int bestellungsNr;
    private float lieferzeit;

    /**
     * Konstruktor für die Instanzen der Klasse Bestellung
     * 
     * @param   anzahlSofas     Die Anzahl Sofas gibt die Anzahl an bestellten Sofas.
     * @param   anzahlStuehle   Die Anzahl Stühle gibt die Anzahl an bestellten Stühlen.
     * @param   bestellungsNr   Die BestellungsNr gibt eine Bestellungsnummer für die Bestellung.
     * 
     */
    public Bestellung(int anzahlSofas, int anzahlStuehle, int bestellungsNr) {
        // Instanzvariablen initialisieren
        this.bestellteProdukte = new ArrayList<Produkt>(); 
        this.bestellBestaetigung = false;
        this.beschaffungsZeit = 0; // Zeit die es braucht, um die Materialien für die bestellten Produkte zu beschaffen
        this.anzahlSofas = anzahlSofas;
        this.anzahlStuehle = anzahlStuehle;
        this.bestellungsNr = bestellungsNr; // Wird von der Klasse Fabrik gegeben
        this.lieferzeit = 1;
        this.bestellteProdukteHinzufuegen();        
    }



    /// Getters und Setters

    /**
     * Methode zum Setzen der ArrayList mit den bestellten Produkten.
     * 
     * @param   produkte   ArrayList mit den bestellten Produkten.
     */
    public void setzeBestellteProdukte(ArrayList<Produkt> produkte) {
        this.bestellteProdukte = produkte;
    }    
    
    /**
     * Methode zur Ausgabe der Liste der bestellten Produkte.
     * 
     * @return  bestellteProdukte   ArrayList<Produkt> mit den Referenzen zu den bestellten Produkten.
     */
    public ArrayList<Produkt> gibBestellteProdukte() {
        return this.bestellteProdukte;
    }
    
    /**
     * Methode zum Setzen der Variable bestellBestaetigung.
     * 
     * @param   status Zustand der Bestellbestätigung.
     */
    public void setzeBestellBestaetigung(Boolean status) {
        this.bestellBestaetigung = status;
    }
    
    /**
     * Methode zur Ausgabe der Variable bestellBestaetigung.
     * 
     * @return  bestellBestaetigung Boolean zur Identifizierung, ob eine Bestellung bestätigt ist oder nicht.
     */
    public boolean gibBestellBestaetigung() {
        return this.bestellBestaetigung;
    }

    /**
     * Methode zum Setzen der Beschaffungszeit in Tagen. Fehlermeldung, wenn ein negativer Wert angegeben wird.
     * 
     * @param zeit Zeitangabe in Tagen.
     */
    public void setzeBeschaffungszeit(int zeit) {
        if(zeit >= 0) {
            this.beschaffungsZeit = zeit;
        } else {
            System.out.println("\nDer angegebene Wert (" + zeit + ") ist ungültig:"
                                + "\n   Bitte geben Sie für die Beschaffungszeit eine Zahl ein, die grösser oder gleich 0 ist.");
        }
    }
    
    /**
     * Methode zur Ausgabe der Beschaffungszeit in Tagen. Rechnet die Anzahl Minuten in Tage um und gibt diese aus.
     * 
     * @return beschaffungsZeit Zeitangabe in Tagen.
     */
    public int gibBeschaffungszeit() {
        return this.beschaffungsZeit;
    }

    /**
     * Methode zum Setzen der Bestellungsnummer.
     * 
     * @param   bestellNummer   Bestellungsnummer, die von Fabrik gegeben wird.
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
     * Methode zur Ausgabe der Bestellungsnummer.
     * 
     * @return  bestellungsNr   die Bestellungsnummer
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
    
        /**
     * Methode zum Setzen der Lieferzeit. Die Lieferzeit errechnet sich aus Produktionszeit, Beschaffungszeit und Standardlieferzeit.
     * 
     * @param   lieferzeit   Lieferzeit in Tagen
     */
    public void setzeLieferzeit(float lieferzeit) {
        this.lieferzeit = lieferzeit;
    }    
    
    /**
     * Methode zur Ausgabe der Lieferzeit. Die Lieferzeit errechnet sich aus Produktionszeit, Beschaffungszeit und Standardlieferzeit.
     * 
     * @return  lieferzeit  Lieferzeit in Tagen
     */
    public float gibLieferzeit() {
        return this.lieferzeit;
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
     * Anstelle der üblichen Ausgabe, geben wir den Inhalt als String zurück. 
     * Es ermöglicht ein vereinfachter Unit Test.
     * 
     * @return   String  Text zur Bestellbestätigung
     * 
     */
    public String bestellungBestaetigen() {

        // Folgende Zeilen geben das Wort Stuhl und Sofa im Singular aus, wenn es nur eins ist.
        String sf = " Sofas ";
        String st = " Stühlen ";

        if (this.anzahlSofas == 1) {
            sf = " Sofa ";
        }
        if (this.anzahlSofas == 1) {
            st = " Stuhl ";
        }

        this.bestellBestaetigung = true;
        return "Bestellung (Nr. " + bestellungsNr + ") mit " + this.anzahlSofas + sf +
        "und " + this.anzahlStuehle + st + "ist bestätigt.";
    }
    
    /**
     * Methode zur Überprüfung des Status der Bestellbestaetigung. 
     * Gibt Auskunft, ob eine Bestellung bestaetigt wurde oder nicht.
     * Anstelle der üblichen Ausgabe, geben wir den Inhalt als String zurück. 
     * Es ermöglicht ein vereinfachter Unit Test.
     * 
     * @return   String  Text zum Status der Bestellbestätigung
     * 
     * 
     */
    public String ueberpruefeBestellbestaetigung() {
        if(this.bestellBestaetigung){
            return "Die Bestellung mit der Nr. " + this.bestellungsNr +
                            " ist bestätigt.";
            } else {                    
            return "Die Bestellung mit der Nr. " + this.bestellungsNr +
                            " ist nicht bestätigt."; 
            }
    }
    
    /**
     * Methode zur Berechnung der Lieferzeit. Die Lieferzeit errechnet sich aus Produktionszeit, Beschaffungszeit und Standardlieferzeit.
     */
    public void berechneLieferzeit() {
        float produktionszeit = 0;
        int standardlieferzeit = 1;
        
        for (Produkt produkt : this.gibBestellteProdukte()) {
            if (produkt instanceof Stuhl) {
                produktionszeit += produkt.gibTotalProduktionszeit();

            } else if (produkt instanceof Sofa) {            
                produktionszeit += produkt.gibTotalProduktionszeit();
            }   
        }
        
        produktionszeit /= 1440; // in Tagen
        
        this.setzeLieferzeit(produktionszeit + this.beschaffungsZeit + standardlieferzeit);
        
    }
    
    /**
     * Methode zur Ausgabe der Auftragsbestaetigung, welche angibt, wann die bestellten Produkte geliefert werden.
     * 
     * @return   String
     * 
     */
    public String auftragsBestaetigung() {
        String text;
        
        berechneLieferzeit();
        this.bestellBestaetigung = true;
        
        
        if(this.bestellBestaetigung){
            text = " Die Lieferzeit beträgt " + this.gibLieferzeit() + " Tage.";
            return this.bestellungBestaetigen() + text;
            } else {                    
            text = "Die Bestellung Nr. " + this.bestellungsNr + " konnte nicht bestaetigt werden. Bitte wenden Sie sich an den Kundendienst.";
            return text;
            }
    }
    
    /**
     * Methode zur Ausgabe der Methode auftragsBestaetigung() an die Konsole.
     */
    public void auftragsBestaetigungAnKonsole() {
        System.out.println(this.auftragsBestaetigung());
    }
}
