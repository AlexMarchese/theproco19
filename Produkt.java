
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
     */
    public Produkt(int zustand)
    {
        // Instanzvariable initialisieren
        this.zustand = zustand;
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
        // tragen Sie hier den Code ein
        this.zustand = zustand;
    }
    
    /**
     * Methode gibt aktuellen Zustand zurück.
     */
    public int aktuellerZustand()
    {
        // tragen Sie hier den Code ein
        return zustand;
    }
}
