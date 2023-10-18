import java.util.ArrayList;

/**
 * Beschreiben Sie hier die Klasse Fabrik.
 * 
 * @Gruppe19
 * @Version 1
 */
public class Fabrik {
    // Die Klasse Fabrik enthält eine Übersicht (Array-liste) über alle Bestellungen
    // Hier wird die Klasse initialisiert und definiert als Array-List
    private ArrayList<Bestellung> bestellungList;
    private int bestellungsNr; 

    /**
     * Konstruktor für Objekte der Klasse Fabrik
     */
    public Fabrik() {
        this.bestellungList = new ArrayList<Bestellung>();
        this.bestellungsNr = 1; // Attribut für die erste Bestellung gesetzt
    }

    /**
     * Methode, um eine Bestellung aufzugeben
     */
    public void bestellungAufgeben(int sofa, int chairs) {
        bestellungList.add(new Bestellung(sofa, chairs, this.bestellungsNr));
        this.bestellungsNr ++; // sodass die folgende Bestellung eine höhere Nummer bekommt
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
            System.out.println("ArrayList: " + bestellung.gibBestellteProdukte());
        }

    /**
     * Main Methode, wenn es keine Tesklasse gäbe
     */
    //public static void main(String[] args) {
        // pass
    }

}