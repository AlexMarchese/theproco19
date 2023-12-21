import java.util.ArrayList;

/**
 * Die Klasse Lieferant umfasst die Informationen zu den faufgefülltür die Fabrik bestellbaren Materialien und die dazugehörigen Methoden.
 * 
 * @author GBI Gruppe 19
 * @version 2.0
 */
public class Lieferant extends Thread {
    // Instanzvariablen
    private int bestellteHolzeinheiten;
    private int bestellteSchrauben;
    private int bestellteFarbeeinheiten;
    private int bestellteKartoneinheiten;
    private int bestellteKissen;
    private boolean lieferungInArbeit;
    private Lager bestellendesLager;
    private int zeitFaktor; // Wird benötigt, um dem Nutzer aus der GUI die Möglichkeit zu geben die Zeit um den Faktor zu beeinflussen
        
    public Lieferant(){
        this.bestellteHolzeinheiten = 0; 
        this.bestellteSchrauben = 0;
        this.bestellteFarbeeinheiten = 0;
        this.bestellteKartoneinheiten = 0;
        this.bestellteKissen = 0;
        this.lieferungInArbeit = false;
        this.zeitFaktor = 1;
    }

    /// Getters und Setters

    /**
     * Methode zur Ausgabe der Variable lieferungInArbeit.
     * @return lieferungInArbeit    Ein boolean Wert, welcher besagt ob eine Lieferung in Arbeit ist (true) oder nicht (false).
     */
    public boolean gibLieferungInArbeit(){
        return this.lieferungInArbeit;
    }

    /**
     * Methode zum Setzen des Faktors, um die Zeit zu beeinflussen.
     * 
     * @param  faktor   Faktor, um der die Zeit beeinfluss werden soll
     */
    public void setzeZeitFaktor(int faktor) {
        this.zeitFaktor = faktor;
    }


    /// Methoden
    
    /**
     * Methode, um Ware zu bestellen.
     * 
     * @param   holzeinheiten   Anzahl Holzeinheiten, die bestellt werden
     * @param   schrauben       Anzahl Schrauben, die bestellt werden
     * @param   farbeeinheiten  Anzahl Farbeinheiten, die bestellt werden
     * @param   kartoneinheiten Anzahl Kartoneinheiten, die bestellt werden
     * @param   kissen          Anzahl Kissen, die bestellt werden
     * @param   lager           Das Lager, welches die Methode aufruft
     */
    public void wareBestellen(int holzeinheiten, int schrauben, int farbeeinheiten, int kartoneinheiten, int kissen, Lager lager)
    {
        // Bestellte Holzmenge wird abgespeichert
        lieferungInArbeit = true;
        this.bestellteHolzeinheiten = holzeinheiten; 
        this.bestellteSchrauben = schrauben;
        this.bestellteFarbeeinheiten = farbeeinheiten;
        this.bestellteKartoneinheiten = kartoneinheiten;
        this.bestellteKissen = kissen;
        this.bestellendesLager = lager;
    }

    
    /**
     *  Methode, run() startet den Lieferanten Thread. 
     *  Wenn eine Bestellung vorliegt, gibt der Thread eine Bestätigung aus, zeigt den Bestellschein an und simuliert eine Lieferzeit von 24 Stunden.
     *  Nach Ablauf der simulierten Lieferzeit ruft der Thread die Methode wareLiefern des zugeordneten Lagers auf und übergibt die bestellten Einheiten. 
     *  Wenn die Lieferung erfolgreich abgeschlossen ist wird lieferungInArbeit auf false gesetzt und gibt einen Lieferschein aus.
     *  Wenn keine Bestellung vorliegt wartet der Thread eine Stunde und prüft dann erneut, ob eine Bestellung eingegangen ist.
     */
    @Override
    public void run(){
        System.out.println("Lieferant wurde als Thread gestartet...");
         
        while(true){
            if(lieferungInArbeit){
                try{
                    System.out.println("Der Lieferant hat die Bestellung vom Lager erhalten und bestaetigt den Auftrag wie folgt.");
                    System.out.println( "-------------------------------------------------------------");
                    System.out.println("Bestellschein:");
                    System.out.println( "Holzeinheiten:   " + this.bestellteHolzeinheiten + 
                                        "\nSchrauben:       " + this.bestellteSchrauben + 
                                        "\nFarbeinheiten:   " + this.bestellteFarbeeinheiten +
                                        "\nKartoneinheiten: " + this.bestellteKartoneinheiten + 
                                        "\nKissen:          " + this.bestellteKissen);
                    System.out.println( "-------------------------------------------------------------");
                    System.out.println("\nDie Lieferzeit betraegt 48 Stunden.\n");
                    
                    this.sleep(48000 * this.zeitFaktor); // 48 sec -> 48 Stunden (Defaultwert, also wenn der Faktor 1 ist)
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
                
                bestellendesLager.wareLiefern(bestellteHolzeinheiten, bestellteSchrauben, bestellteFarbeeinheiten, bestellteKartoneinheiten, bestellteKissen);
                lieferungInArbeit = false;
                System.out.println( "-------------------------------------------------------------");
                System.out.println("Der Lieferant hat die Bestellung geliefert. \nLieferschein:");
                System.out.println( "\nHolzeinheiten:   " + this.bestellteHolzeinheiten + 
                                    "\nSchrauben:       " + this.bestellteSchrauben + 
                                    "\nFarbeinheiten:   " + this.bestellteFarbeeinheiten +
                                    "\nKartoneinheiten: " + this.bestellteKartoneinheiten + 
                                    "\nKissen:          " + this.bestellteKissen);
                System.out.println( "-------------------------------------------------------------");
            } else {
                try{
                    this.sleep(1000 * this.zeitFaktor); // Damit jede Stunde gechecked wird, ob eine Bestellung eingetroffen ist.
                } catch (InterruptedException ie){
                    ie.printStackTrace();
                }
            }
        }
    }
}
