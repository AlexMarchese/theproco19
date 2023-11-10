
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
     * wenn der Lieferant keine Einnehmen kann.
     * 
     * @param holzeinheiten
     * @param schrauben
     * @param farbeeinheiten
     * @param kartoneinheiten
     * @param kissen
     * @return
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
