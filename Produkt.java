
/**
 * Beschreiben Sie hier die Klasse Produkt.
 * 
 * @author GBI Gruppe 19
 * @version 1.0
 */
public class Produkt
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private int zustand;

    /**
     * Konstruktor für Objekte der Klasse Produkt, Produkt kann Zahlenwerte annehmen
     * 0= nicht gestartet
     * 1= in bearbeitung (Zukünftig denkbar; Zustand pro Maschine/Roboter 00 = nicht gestartet, 11 Maschine/Roboter 1 in bearbeitung 12 etc)
     * 2= abgeschlossen
       */
    public Produkt()
    {
        // Instanzvariable initialisieren
        this.zustand = 0;
    }

    /**
     * 
     * Methode zustandÄndern ersetzt den Zustandswert des Produkts
     * 
     * 
     *
     */
    public void zustandAendern(int zustand)
    {
        // fehlt: if loop um zu vermeiden, dass ein ungültiger value eingegeben wird
        this.zustand = zustand;
    }
    
    /**
     * Methode gibt aktuellen Zustand zurück.
     */
    public int aktuellerZustand()
    {
        // tragen Sie hier den Code ein
        return this.zustand;
    }
}
