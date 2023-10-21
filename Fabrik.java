import java.util.ArrayList;

/**
 * Beschreiben Sie hier die Klasse Fabrik.
 * 
 * @author GBI Gruppe 19
 * @version 1.0
*/

public class Fabrik {
    // Die Klasse Fabrik enthält eine Übersicht (Array-liste) über alle Bestellungen
    // Hier wird die Klasse initialisiert und definiert als Array-List
    private ArrayList<Bestellung> bestellungList;
    private int bestellungsNrCounter; 

    /**
     * Konstruktor für Objekte der Klasse Fabrik
     */
    public Fabrik() {
        this.bestellungList = new ArrayList<Bestellung>();
        this.bestellungsNrCounter = 1; // Attribut für die erste Bestellung gesetzt
    }


    /// Getters und Setters

    /**
     * Methode zum Setzen der Bestellungen
     * 
     * @param  bestellungList   ArrayList mit den Bestellungen
     */
    public void setzeBestellungsList(ArrayList<Bestellung> bestellungList) {
        this.bestellungList = bestellungList;
    }

    /**
     * Methode zur Ausgabe der Bestellungen
     * 
     * @return  bestellungList   Liste mit den Bestellungen
     */
    public ArrayList<Bestellung> gibBestellungsList() {
        return this.bestellungList;
    }

    /**
     * Methode zum Setzen des Zählers der Bestellungen
     * 
     * @param  bestellungsNrCounter   Zähler der Bestellungen
     */
    public void setzebestellungsNrCounter(int bestellungsNrCounter) {
        this.bestellungsNrCounter = bestellungsNrCounter;
    }

    /**
     * Methode zur Ausgabe des Zählers der Bestellungen
     * 
     * @return  bestellungsNrCounter   Zähler der Bestellungen
     */
    public int gibbestellungsNrCounter() {
        return this.bestellungsNrCounter;
    }

    

    /// Methoden


    /**
     * Methode, um eine Bestellung aufzugeben
    */
    public void bestellungAufgeben(int sofa, int chairs) {
        // Stellt sicher, dass keine Bestellung mit Negativwerten aufgegeben wird
        if (sofa < 0 || chairs < 0) {
            throw new IllegalArgumentException("Bitte geben Sie keine negativen Werte für die Anzahl an.");
        } else {
            bestellungList.add(new Bestellung(sofa, chairs, this.bestellungsNrCounter));
            this.bestellungsNrCounter ++; // sodass die folgende Bestellung eine höhere Nummer bekommt
        }
    }

    /**
     * Methode zur Ausgabe der Bestellungen
     * 
     * @param   ausgabe  Text zur Ausgabe der Bestellungen
     * 
     * Anstelle der üblichen Ausgabe, geben wir den Inhalt als String zurück. Es ermöglicht ein vereinfachter Unit Test.
     */
    public String bestellungenAusgeben() {

        String ausgabe = null;
        String best = " Bestellungen.\n\n";

        // Folgende Zeile gibt das Wort Bestellung im Singular aus, wenn es nur eine ist.
        if (this.bestellungList.size() == 1) {
            best = " Bestellung.\n\n";
        }

        // Erster Teil der Ausgabe
        ausgabe = ("In der Fabrik GBI Gruppe 19 gibt es im Moment " + this.bestellungList.size() + best);

        // Information zur jeder Bestellung
        for(Bestellung bestellung : this.bestellungList)   //to be improved - more fancyness
        {
            ausgabe += 
                ("Bestellung Nr.: " + bestellung.gibBestellungsNr() + "\n" +
                "Anzahl Stühle: " + bestellung.gibAnzahlStuehle() + "\n" +
                "Anzahl Sofas: " + bestellung.gibAnzahlSofas() + "\n" +
                // "ArrayList: " + bestellung.gibBestellteProdukte() + "\n" + //rausnehmen?
                "- - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        }

        // Letzter Teil der Ausgabe
        // ausgabe += ("Das entspricht insgesamt" + );

        return ausgabe;

    /**
     * Main Methode, wenn es keine Tesklasse oder Mainklasse gäbe
     */
    //public static void main(String[] args) {
        // pass
    }

    
}