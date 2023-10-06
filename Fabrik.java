import java.util.ArrayList;
// import java.util.List;

/**
 * Beschreiben Sie hier die Klasse Fabrik.
 * 
 * @Gruppe19
 * @Version 1
 */
public class Fabrik
{
    // Die Klasse Fabrik enthält eine Übersicht (Array-liste) über alle Bestellungen
    // Hier wird die Klasse initialisiert und definiert als Array-List
    private ArrayList<Bestellung> bestellungList;

    /**
     * Konstruktor für Objekte der Klasse Fabrik
     */
    public Fabrik()
    {
        bestellungList = new ArrayList<Bestellung>();
    }

    /*
     * 
     */
    public void bestellungAufgeben(int sofa, int chairs)
    {
        bestellungList.add(new Bestellung(sofa, chairs));
    }

    /*
     * 
     */
    public void bestellungAusgeben() //bestellungenAusgeben?
     {
        for(Bestellung bestellung : bestellungList)
        {
            System.out.println("Bestellung Nr.: " + bestellung.gibBestellungsNr());
            System.out.println("Anzahl Stühle: " + bestellung.gibAnzahlStuehle());
            System.out.println("Anzahl Sofas: " + bestellung.gibAnzahlSofas());
        }
    }


    public static void main(String[] args) {
        // pass
    }

}