import java.util.ArrayList;

/**
 * Die Klasse Fabrik enthält eine Übersicht (Array-Liste) über alle Bestellungen.
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
     * Konstruktor für Instanzen der Klasse Fabrik.
     * 
     * @param bestellungList Die BestellungList ist eine Array-Liste welche alle getätigten Bestellungen enthält.
     * @param bestellungsNrCounter Der BestellungsNrCounter stellt die Anzahl der Bestellungen dar.
     * 
     * 
     */
    public Fabrik() {
        this.bestellungList = new ArrayList<Bestellung>();
        this.bestellungsNrCounter = 1; // Attribut für die erste Bestellung gesetzt
    }


    /// Getters und Setters

    /**
     * Methode zum Setzen der Bestellungen.
     * 
     * @param  bestellungList   ArrayList mit den Bestellungen
     */
    public void setzeBestellungsList(ArrayList<Bestellung> bestellungList) {
        this.bestellungList = bestellungList;
    }

    /**
     * Methode zur Ausgabe der Bestellungen.
     * 
     * @return  bestellungList   Liste mit den Bestellungen
     */
    public ArrayList<Bestellung> gibBestellungsList() {
        return this.bestellungList;
    }

    /**
     * Methode zum Setzen des Zählers der Bestellungen.
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
     * Methode, um eine Bestellung aufzugeben.
     * 
     * @param sofa Anzahl Sofas
     * @param chairs Anzahl Stühle
    */
    public void bestellungAufgeben(int sofa, int chairs) {
        // Stellt sicher, dass keine Bestellung mit Negativwerten aufgegeben wird
        if (sofa < 0 || chairs < 0) {
            throw new IllegalArgumentException("Bitte geben Sie keine negativen Werte für die Anzahl an.");
        } else {
            bestellungList.add(new Bestellung(sofa, chairs, this.bestellungsNrCounter));
            this.bestellungsNrCounter ++; // Sodass die folgende Bestellung eine höhere Nummer bekommt
        }
    }

    /**
     * Methode zur Ausgabe der Bestellungen.
     * 
     * @return   ausgabe  Text zur Ausgabe der Bestellungen
     * 
     * Anstelle der üblichen Ausgabe, wird der Inhalt als String zurückgegeben, was einen einen vereinfachten Unit Test ermöglicht.
     */
    public String bestellungenAusgeben() {

        String ausgabe = null;
        int anzahlSofasGesamt = 0;
        int anzahlStuehleGesamt = 0;
        String best = " Bestellungen.\n\n";

        // Folgende Zeile gibt das Wort Bestellung im Singular aus, wenn es nur eine ist.
        if (this.bestellungList.size() == 1) {
            best = " Bestellung.\n\n";
        }

        // Erster Teil der Ausgabe
        ausgabe = ("In der Fabrik GBI Gruppe 19 gibt es im Moment " + this.bestellungList.size() + best);

        // Information zur jeder Bestellung
        for(Bestellung bestellung : this.bestellungList)   
        {
            ausgabe += 
                ("Bestellung Nr.: " + bestellung.gibBestellungsNr() + "\n" +
                "Anzahl Stühle: " + bestellung.gibAnzahlStuehle() + "\n" +
                "Anzahl Sofas: " + bestellung.gibAnzahlSofas() + "\n" +
                "- - - - - - - - - - - - - - - - - - - - - - - - - - - -\n");
            anzahlSofasGesamt += bestellung.gibAnzahlSofas();
            anzahlStuehleGesamt += bestellung.gibAnzahlStuehle();
        }

        String st = " Stühlen";
        String sf = " Sofas.";

        // Folgende Zeilen geben das Wort Stuhl und Sofa im Singular aus, wenn es nur eins ist.
        if (anzahlSofasGesamt == 1) {
            sf = " Sofa.";
        }
        if (anzahlStuehleGesamt == 1) {
            st = " Stuhl";
        }


        // Letzter Teil der Ausgabe (wird nur hinzugefügt, wenn es Bestellungen gab also anzahlSofasGesamt oder anzahlStuehleGesamt größer als 0)
        if (anzahlSofasGesamt > 0 || anzahlStuehleGesamt > 0) {
        ausgabe += ("\nDas entspricht insgesamt " + anzahlStuehleGesamt + st + " und " + anzahlSofasGesamt + sf);
        }

        return ausgabe;
        
    }
    
}