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

    /**
     * Methode, um eine Bestellung aufzugeben
    */
    public void bestellungAufgeben(int sofa, int chairs) throws Exception {
        bestellungList.add(new Bestellung(sofa, chairs, this.bestellungsNrCounter));

        this.bestellungsNrCounter ++; // sodass die folgende Bestellung eine höhere Nummer bekommt
    }

    /**
     * Methode zur Ausgabe der Bestellungen
     */
    public void bestellungenAusgeben() {
        for(Bestellung bestellung : this.bestellungList)   //to be improved - more fancyness
        {
            System.out.println("Bestellung Nr.: " + bestellung.gibBestellungsNr());
            System.out.println("Anzahl Stühle: " + bestellung.gibAnzahlStuehle());
            System.out.println("Anzahl Sofas: " + bestellung.gibAnzahlSofas());
            System.out.println("ArrayList: " + bestellung.gibBestellteProdukte()); //rausnehmen?
            System.out.println();
        }

    /**
     * Main Methode, wenn es keine Tesklasse gäbe
     */
    //public static void main(String[] args) {
        // pass
    }

    ArrayList<Bestellung> getBestellungen() {
        return this.bestellungList;
    }
}