import java.util.ArrayList;
/**
 * Die Klasse Bestellung umfasst die Informationen zu den Bestellungen und die dazugehörigen Methoden.
 * Sie dient zur Erstellung von Bestellungen, die Sofas und Stühle beinhalten.
 * 
 * @author GBI Gruppe 19
 * @version 2.0
 */
public class Bestellung {
    // Instanzvariablen
    private ArrayList<Produkt> bestellteProdukte;
    private boolean bestellBestaetigung;
    private int beschaffungsZeit; // in Tagen
    private int anzahlSofas;
    private int anzahlStuehle;
    private int bestellungsNr;
    private float lieferzeit; // in Tagen
    private float produktionszeit; // in Tagen

    /**
     * Konstruktor für die Instanzen der Klasse Bestellung.
     * 
     * @param   anzahlSofas     Die Anzahl Sofas gibt die Anzahl an bestellten Sofas.
     * @param   anzahlStuehle   Die Anzahl Stühle gibt die Anzahl an bestellten Stühlen.
     * @param   bestellungsNr   Die BestellungsNr gibt eine Bestellungsnummer für die Bestellung.
     * 
     */
    public Bestellung(int anzahlSofas, int anzahlStuehle, int bestellungsNr) {
           
        
        // Stellt sicher, dass keine Bestellung mit Negativwerten aufgegeben wird.
        if (anzahlSofas < 0 || anzahlStuehle < 0) {
            throw new IllegalArgumentException("Bitte geben Sie keine negativen Werte für die Anzahl der Stühle und Sofas an.");
        } else {
            // Instanzvariablen initialisieren
            this.anzahlSofas = anzahlSofas;
            this.anzahlStuehle = anzahlStuehle;
            this.bestellteProdukte = new ArrayList<Produkt>(); 
            this.bestellBestaetigung = false;
            this.beschaffungsZeit = 0; // Zeit die es braucht, um die Materialien für die bestellten Produkte zu beschaffen
            this.bestellungsNr = bestellungsNr; // Wird von der Klasse Fabrik gegeben
            this.lieferzeit = 1;
            this.produktionszeit = 0;
            this.bestellteProdukteHinzufuegen();
            
        }
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
    public ArrayList<Produkt> gibBestellteProdukte() { // N.B. Entspricht liefereBestellteProdukte() in der Musterlösung
        return this.bestellteProdukte;
    }
    
    /**
     * Methode zum Setzen der Variable bestellBestaetigung.
     * 
     * @param   status  Zustand der Bestellbestätigung.
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
     * @param   zeit    Zeitangabe in Tagen.
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
     * @return  beschaffungsZeit    Zeitangabe in Tagen.
     */
    public int gibBeschaffungszeit() {
        return this.beschaffungsZeit;
    }

    /**
     * Methode zum Setzen der Bestellungsnummer.
     * 
     * @param   bestellNummer   Die Bestellungsnummer, die von Fabrik gegeben wird.
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
     * @return  bestellungsNr   Die Bestellungsnummer.
     */
    public int gibBestellungsNr() {
        return this.bestellungsNr;
    }

    /**
     * Methode zur Anpassung der AnzahlStuehle. Gibt der Variable AnzahlStuehle den
     * angegebenen Wert. Fehlermeldung, wenn ein negativer Wert (oder 0) angegeben wird.
     * 
     * @param   menge   Menge an Stühlen.
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
     * @return  anzahlStuehle   Anzahl bestellter Stühle.
     */
    public int gibAnzahlStuehle() {
        return this.anzahlStuehle;
    }

    /**
     * Methode zur Anpassung der AnzahlSofas. Gibt der Variable AnzahlSofas den
     * angegebenen Wert. Fehlermeldung, wenn ein negativer Wert (oder 0) angegeben wird.
     * 
     * @param   menge   Menge an Sofas
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
     * @return  anzahlSofas Anzahl bestellter Sofas.
     */
    public int gibAnzahlSofas() {
        return this.anzahlSofas;
    }
    
    /**
     * Methode zum Setzen der Lieferzeit. Die Lieferzeit errechnet sich aus Produktionszeit, Beschaffungszeit und Standardlieferzeit.
     * 
     * @param   lieferzeit  Lieferzeit in Tagen.
     */
    public void setzeLieferzeit(float lieferzeit) {
        this.lieferzeit = lieferzeit;
    }    
    
    /**
     * Methode zur Ausgabe der Lieferzeit. Die Lieferzeit errechnet sich aus Produktionszeit, Beschaffungszeit und Standardlieferzeit.
     * 
     * @return  lieferzeit  Lieferzeit in Tagen.
     */
    public float gibLieferzeit() {
        return this.lieferzeit;
    }

    /**
     * Methode zum Setzen der Produktionszeit.
     * 
     * @param   produktionszeit   Produktionszeit in Tagen.
     */
    public void setzeProduktionszeit(float produktionszeit) {
        this.produktionszeit = produktionszeit;
    }    
    
    /**
     * Methode zur Ausgabe der Produktionszeit.
     * 
     * @return  produktionszeit  Produktionszeit in Tagen.
     */
    public float gibProduktionszeit() {
        return this.produktionszeit;
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
     * Es ermöglicht einen vereinfachten Unit Test.
     * 
     * @return   String  Text zur Bestellbestätigung.
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

        // Folgende Zeilen geben das Wort Tag im Singular aus, wenn es nur eins ist.
        int liefzeit = (int)Math.floor(this.lieferzeit);
        String tg = " Tage.";

        if (liefzeit == 1) {
            tg = " Tag.";
        }

        this.bestellBestaetigung = true;
        return "Bestellung (Nr. " + bestellungsNr + ") mit " + this.anzahlSofas + sf +
        "und " + this.anzahlStuehle + st + "ist bestätigt." +
            "\nDie Lieferzeit beträgt " + liefzeit + tg;
    }

    
    /**
     * Methode zur Überprüfung des Status der Bestellbestaetigung. 
     * Gibt Auskunft, ob eine Bestellung bestaetigt wurde oder nicht.
     * Anstelle der üblichen Ausgabe, geben wir den Inhalt als String zurück. 
     * Es ermöglicht einen vereinfachten Unit Test.
     * 
     * @return   String  Text zum Status der Bestellbestätigung.
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
     * Das Ergebnis wird in der Variable abgespeichert.
     */
    public void berechneLieferzeit() {
        int standardlieferzeit = 1;
        
        for (Produkt produkt : this.gibBestellteProdukte()) {   
            // Wenn Produkt ein Stuhl ist...
            if (produkt instanceof Stuhl){
                // ...dann  soll es wie ein solches behandelt werden
                Stuhl stuhl = (Stuhl)produkt;
                this.produktionszeit += stuhl.gibTotalProduktionszeit();
            } else if (produkt instanceof Sofa){
                // Sonst wie ein Sofa
                Sofa sofa = (Sofa)produkt;
                this.produktionszeit += sofa.gibTotalProduktionszeit();
                }
            }
            
        this.produktionszeit /= 1440; // in Tagen
        
        this.lieferzeit = this.produktionszeit + this.beschaffungsZeit + standardlieferzeit;
        
    }

    /**
     * Methode um festzustellen, wieviele Einheiten der jeweiligen Produkte für die Bestellung nötig sind.
     * 
     * @return totHolz  Gesamtmenge an Einheiten Holz, die für die Bestellung nötig sind.
     * @return totSchrauben Gesamtmenge an Einheiten Schrauben, die für die Bestellung nötig sind.
     * @return totFarbe Gesamtmenge an Einheiten Farbe, die für die Bestellung nötig sind.
     * @return totKarton Gesamtmenge an Einheiten Karton, die für die Bestellung nötig sind.
     * @return totKissen Gesamtmenge an Einheiten Kissen, die für die Bestellung nötig sind.
     */

     public int[] anzahlEinheiten(){

        // Variablen zur Ermittlung der für jede Bestellung benötigte Einheiten
        int totHolz = 0;
        int totSchrauben = 0;
        int totFarbe = 0;
        int totKarton = 0;
        int totKissen = 0;

        // Ermittlung der Werte
        for (Produkt produkt : this.gibBestellteProdukte()) {

            

            if (produkt instanceof Stuhl) {
                // Damit man das Produkt wie einen Stuhl behandeln kann
                Stuhl stuhl = (Stuhl)produkt;
                totHolz += stuhl.gibHolzeinheiten();
                totSchrauben += stuhl.gibSchrauben();
                totFarbe += stuhl.gibFarbeinheiten();
                totKarton += stuhl.gibKartoneinheiten();

            } else if (produkt instanceof Sofa) {
                // Damit man das Produkt wie einen Stuhl behandeln kann
                Sofa sofa = (Sofa)produkt;
                totHolz += sofa.gibHolzeinheiten();
                totSchrauben += sofa.gibSchrauben();
                totFarbe += sofa.gibFarbeinheiten();
                totKarton += sofa.gibKartoneinheiten();
                totKissen = totKissen + sofa.gibKissen();              
                
                }

            }
        return new int[]{totHolz, totSchrauben, totFarbe, totKarton, totKissen};
        }

        
}
