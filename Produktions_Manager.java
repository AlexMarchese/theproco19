import java.util.LinkedList;

/**
 * Die Klasse Produktions_Manager 
 * 
 * 
 * 
 * @author GBI Gruppe 19
 * @version 1.0
 * 
 */
public class Produktions_Manager extends Thread
{
    // Instanzvariablen 
    
    // private Holzarbeitungs_Roboter holzRoboter;
    // private Montage_Roboter montageRoboter;
    // private Lackier_Roboter lackierRoboter; 
    // private Verpackungs_Roboter verpackungsRoboter;
    private Fabrik meineFabrik; 
    private Lager meinLager; 
    private LinkedList <Bestellung> zuVerabreitendeBestellungen;
    private LinkedList <Bestellung> bestellungInProduktion; 
    

    /** TO DO
     * Konstruktor für Objekte der Klasse Produktions_Manager
     */
    
    public Produktions_Manager(Lager meinLager, Fabrik meineFabrik)
    {
        //TEMPorär
        // this.holzRoboter = new Holzarbeitungs_Roboter();
        // this.montageRoboter = new Montage_Roboter();
        // this.lackierRoboter = new Lackier_Roboter();
        // this.verpackungsRoboter = new Verpackungs_Roboter();

        this.meineFabrik = meineFabrik;
        this.meinLager = meinLager; 
        this.zuVerabreitendeBestellungen = new LinkedList<Bestellung>();
        this.bestellungInProduktion = new LinkedList<Bestellung>();
        
    }

    
    /// Methoden
    
    /**
     * Methode, 
     */
    @Override
    public void run(){
        // System.out.println("Lieferant thread started...");
         
        // while(true){
        //     if(lieferungInArbeit){
        //         try{
        //             System.out.println("Lieferant hat eine Bestellung erhalten...");
        //             // this.sleep(8000); //derzeit 8 sec, damit man nicht zu lang warten muss. Später 48sec.
        //             this.sleep(20000); //derzeit 8 sec, damit man nicht zu lang warten muss. Später 48sec.
        //         } catch (InterruptedException ie) {
        //             ie.printStackTrace();
        //         }
                
        //         bestellendesLager.wareLiefern(bestellteHolzeinheiten, bestellteSchrauben, bestellteFarbeeinheiten, bestellteKartoneinheiten, bestellteKissen);
        //         lieferungInArbeit = false;
        //         System.out.println("Bestellung geliefert.");
        //     } else {
        //         try{
        //             this.sleep(1000); // Damit jede Stunde gechecked wird, ob eine Bestellung eingetroffen ist.
        //         } catch (InterruptedException ie){
        //             ie.printStackTrace();
        //         }
        //     }
        // }
    }
    
    /**
     * Methode, 
     */
    public void fuegeZuVerarbeitendeBestellungenHinzu (Bestellung bestellung){
        
        //Man muss noch überprüfen, dass die zuverarb Liste nicht leer ist

        // Bestellung der Liste zuVerabreitendeBestellungen wegnehmen
        Bestellung best = this.zuVerabreitendeBestellungen.removeFirst();

        // Bestellung der Liste bestellungInProduktion hinzufügen 
        this.bestellungInProduktion.add(best);
    }
    
    
}
