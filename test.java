import java.util.ArrayList;
import java.util.List;

/**
 * Beschreiben Sie hier die Klasse Fabrik.
 * 
 * @Gruppe19 (Ihr Name) 
 * @Version 1(eine Versionsnummer oder ein Datum)
 */
public class Fabrik
{
    // Die Klasse Fabrik enthält eine Übersicht (Array-liste) über alle Bestellungen
    // Hier wird die Klasse initialisiert und definiert als Array-List
    private ArrayList<Bestellung> BestellungList;

    /**
     * Konstruktor für Objekte der Klasse Fabrik
     */
    public Fabrik()
    {
        BestellungList = new ArrayList<Bestellung>(); 
    }
