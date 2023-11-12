
/**
 * Die Klasse Lieferant umfasst die Informationen zu den für die Fabrik bestellbaren Materialien und die dazugehörigen Methoden.
 * 
 * @author GBI Gruppe 19
 * @version 1.0
 */
public class Lieferant {
    // Instanzvariablen
    int versendeteHolzeinheiten;
    int versendeteSchrauben;
    int versendeteFarbeeinheiten;
    int versendeteKartoneinheiten;
    int versendeteKissen;
        
    public Lieferant(){
        this.versendeteHolzeinheiten = 0; 
        this.versendeteSchrauben = 0;
        this.versendeteFarbeeinheiten = 0;
        this.versendeteKartoneinheiten = 0;
        this.versendeteKissen = 0;

    }

    /**
     * Methode, um zu überprüfen, ob eine Bestellung an den Lieferanten erzeugt werden kann.
     * Momentan gibt es keine Bedingungen, die dies hindern -> der Wert ist immer "true".
     * Man könnte gut einstellen, dass nur gewisse Mengen bestellt werden können oder Bestellungen verhindern,
     * wenn der Lieferant keine einnehmen kann.
     * 
     * @param   holzeinheiten   Anzahl Holzeinheiten die bestellt werden möchten.
     * @param   schrauben   Anzahl Schrauben die bestellt werden möchten.
     * @param   farbeeinheiten  Anzahl Farbeinheiten die bestellt werden möchten.
     * @param   kartoneinheiten Anzahl Kartoneinheiten die bestellt werden möchten.
     * @param   kissen  Anzahl Kissen die bestellt werden möchten.
     * @return  boolean Gibt an, ob eine Bestellung beim Lieferanten erzeut werden kann. Momentan gibt es noch keine Bedingungen, die dies verhindern. Deswegen ist der Wert momentan immer "true".
     */
    public boolean wareBestellen(int holzeinheiten, int schrauben, int farbeeinheiten, int kartoneinheiten, int kissen)
    {
        // Zähler wächst um die bestellte Menge
        this.versendeteHolzeinheiten += holzeinheiten; 
        this.versendeteSchrauben += schrauben;
        this.versendeteFarbeeinheiten += farbeeinheiten;
        this.versendeteKartoneinheiten += kartoneinheiten;
        this.versendeteKissen += kissen;

        return true;
    }

}
