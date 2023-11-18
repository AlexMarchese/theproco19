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
public class Produktions_Manager
{
    // Instanzvariablen 
    
    Holzarbeitungs_Roboter holzRoboter;
    Montage_Roboter montageRoboter;
    Lackier_Roboter lackierRoboter; 
    Verpackungs_Roboter verpackungsRoboter;
    Fabrik meineFabrik; 
    Lager meinLager; 
    LinkedList <Bestellung> zuVerabreitendeBestellungen;
    LinkedList <Bestellung> bestellungInProduktion; 
    

    /**
     * Konstruktor für Objekte der Klasse Produktions_Manager
     */
    public Produktions_Manager(int maxHolzeinheiten, int maxSchrauben, int maxFarbeeinheiten, int maxKartoneinheiten,int maxKissen, int vorhandeneHolzeinheiten, int vorhandenSchrauben, int vorhandeneFarbeeinheiten, int vorhandeneKartoneinheiten, int vorhandeneKissen)
    {
        this.holzRoboter = new Holzarbeitungs_Roboter();
        this.montageRoboter = new Montage_Roboter();
        this.lackierRoboter = new Lackier_Roboter();
        this.verpackungsRoboter = new Verpackungs_Roboter();
        this.meineFabrik = new Fabrik(); 
        this.meinLager = new Lager(maxHolzeinheiten, maxSchrauben, maxFarbeeinheiten, maxKartoneinheiten, maxKissen, vorhandeneHolzeinheiten, vorhandenSchrauben, vorhandeneFarbeeinheiten, vorhandeneKartoneinheiten, vorhandeneKissen); 
        this.zuVerabreitendeBestellungen = new LinkedList<Bestellung>();
        this.bestellungInProduktion = new LinkedList<Bestellung>();
        
    }

    
    /// Methoden
    
    /**
     * Methode, 
     */
    public void run(){
        //muss noch im Rahmen des Threads eingefügt werden
    }
    
    /**
     * Methode, 
     */
    public void fuegeZuVerarbeitendeBestellungenHinzu (Bestellung bestellung){
        //
    }
    
    
}
