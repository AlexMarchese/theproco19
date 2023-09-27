
/**
 * Eine Klasse, welche die Parameter des Stuhls enthält.
 * 
 * @author GBI Gruppe 19
 * @version 1.0
 */
public class Stuhl
{
    // Instanzvariablen
    private int holzeinheiten = 2;
    private int schrauben = 10;
    private int farbeinheiten = 2;
    private int kartoneinheiten = 1;
    private int produktionsZeit = 22; //muss noch überarbeitet werden, da 22 die Summe ist.

    /**
     * Konstruktor für Objekte der Klasse Stuhl
     */
    public Stuhl(int holzeinheiten, int schrauben, int farbeinheiten, int kartoneinheiten, int produktionsZeit)
    {
        // Instanzvariable initialisieren
        this.holzeinheiten = holzeinheiten;
        this.schrauben = schrauben;
        this.farbeinheiten = farbeinheiten;
        this.kartoneinheiten = kartoneinheiten;
        this.produktionsZeit = produktionsZeit;
    }

    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    public int getHolzeinheiten()
    {
        return holzeinheiten;
        
    }
}
