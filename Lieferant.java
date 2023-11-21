
/**
 * Die Klasse Lieferant umfasst die Informationen zu den für die Fabrik bestellbaren Materialien und die dazugehörigen Methoden.
 * 
 * @author GBI Gruppe 19
 * @version 1.0
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
        
    public Lieferant(){
        this.bestellteHolzeinheiten = 0; 
        this.bestellteSchrauben = 0;
        this.bestellteFarbeeinheiten = 0;
        this.bestellteKartoneinheiten = 0;
        this.bestellteKissen = 0;
        this.lieferungInArbeit = false;
    }


    //Es wäre noch cool eine Variable zu haben, in der die bisher je Bestellten Materialien gespeichert werden, auch mit einer Bestellnummer


    /**
     * Methode zur Ausgabe der Variable lieferungInArbeit.
     * @return lieferungInArbeit    Ein boolean Wert, welcher besagt ob eine Lieferung in Arbeit ist (true) oder nicht (false).
     */
    public boolean gibLieferungInArbeit(){
        return this.lieferungInArbeit;
    }
    
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
     *  
     */
    @Override //es ist eine good practice
    public void run(){
        System.out.println("Lieferant thread started...");
         
        while(true){
            if(lieferungInArbeit){
                try{
                    System.out.println("Lieferant hat eine Bestellung erhalten...");
                    // this.sleep(8000); //derzeit 8 sec, damit man nicht zu lang warten muss. Später 48sec.
                    this.sleep(20000); //derzeit 8 sec, damit man nicht zu lang warten muss. Später 48sec.
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
                
                bestellendesLager.wareLiefern(bestellteHolzeinheiten, bestellteSchrauben, bestellteFarbeeinheiten, bestellteKartoneinheiten, bestellteKissen);
                lieferungInArbeit = false;
                System.out.println("Bestellung geliefert.");
            } else {
                try{
                    this.sleep(1000); // Damit jede Stunde gechecked wird, ob eine Bestellung eingetroffen ist.
                } catch (InterruptedException ie){
                    ie.printStackTrace();
                }
            }
        }
    }
}
