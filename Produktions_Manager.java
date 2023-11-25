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
    
    private Holzarbeitungs_Roboter holzRoboter;
    private Montage_Roboter montageRoboter;
    private Lackier_Roboter lackierRoboter; 
    private Verpackungs_Roboter verpackungsRoboter;
    private Fabrik meineFabrik; 
    private Lager meinLager; 
    private LinkedList <Bestellung> zuVerarbeitendeBestellungen;
    private LinkedList <Bestellung> bestellungInProduktion; 
    

    /** TO DO
     * Konstruktor für Objekte der Klasse Produktions_Manager
     */
    
    public Produktions_Manager(Lager meinLager, Fabrik meineFabrik)
    {
        
        this.holzRoboter = new Holzarbeitungs_Roboter();
        this.montageRoboter = new Montage_Roboter();
        this.lackierRoboter = new Lackier_Roboter();
        this.verpackungsRoboter = new Verpackungs_Roboter();
        this.meineFabrik = meineFabrik;
        this.meinLager = meinLager; 
        this.zuVerarbeitendeBestellungen = new LinkedList<Bestellung>();
        this.bestellungInProduktion = new LinkedList<Bestellung>();
        
    }
    
    public void run() {
        while (true) {
            // Prüfe, ob eine neue Bestellung eingetroffen ist
            if (!zuVerarbeitendeBestellungen.isEmpty()) {
                Bestellung neueBestellung = zuVerarbeitendeBestellungen.poll();
                bestellungInProduktion.add(neueBestellung);

                // Starte die Produktion für die neue Bestellung
                starteProduktion(neueBestellung);

                // Lass den Thread eine kurze Weile schlafen
                try {
                    Thread.sleep(1000); 
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        }
    }

    public void fuegeZuVerarbeitendeBestellungenHinzu(Bestellung bestellung) {
        zuVerarbeitendeBestellungen.add(bestellung);
    }

    public void starteProduktion(Bestellung bestellung) {
        // Implementiere die Produktion hier
        for (Produkt produkt : bestellung.gibBestellteProdukte()) {
            // Alokation der Roboter basierend auf Produkttyp
            if (produkt instanceof Stuhl) {
                holzRoboter.produziereProdukt(produkt);
                montageRoboter.produziereProdukt(produkt);
                lackierRoboter.produziereProdukt(produkt);
                verpackungsRoboter.produziereProdukt(produkt);
            } else if (produkt instanceof Sofa) {
                holzRoboter.produziereProdukt(produkt);
                lackierRoboter.produziereProdukt(produkt);
                montageRoboter.produziereProdukt(produkt);
                verpackungsRoboter.produziereProdukt(produkt);
                
            }
        }

        // Überprüfe, ob die Bestellung abgeschlossen ist
        if (bestellungInProduktion.contains(bestellung)) {
            bestellungInProduktion.remove(bestellung);
            System.out.println("Bestellung " + bestellung.gibBestellungsNr() + " abgeschlossen.");
        }
    }

}
/**    
    /// Methoden
    /**
     * Methode, 
     *
    public void startProduktion(Bestellung neueBestellung){
        if (neueBestellung instaceof Stuhl){
            
        }
    }
    
    /**
     * Methode, 
     *
    @Override
    public void run(){
        System.out.println("Produktionsmanager thread started...");
        while(true){
            if(bestellungInProduktion.isEmpty()){                   
                if(!zuVerarbeitendeBestellungen.isEmpty()){
                Bestellung neueBestellung = zuVerarbeitendeBestellungen.poll();
                bestellungInProduktion.add(neueBestellung);
                System.out.println("Produktion von neuer Bestellung hat begonnen.");
                startProduktion(neueBestellung);
                
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
}
}
}
}

/**
     * Methode, 
     * public void fuegeZuVerarbeitendeBestellungenHinzu (Bestellung bestellung){
        this.zuVerabreitendeBestellungen.add(bestellung);
        //Man muss noch überprüfen, dass die zuverarb Liste nicht leer ist

        // Bestellung der Liste zuVerabreitendeBestellungen wegnehmen
        //Bestellung best = this.zuVerabreitendeBestellungen.removeFirst();

        // Bestellung der Liste bestellungInProduktion hinzufügen 
        //this.bestellungInProduktion.add(best);
    }
    
    
}
**/