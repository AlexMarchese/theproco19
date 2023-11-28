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
    private LinkedList<Bestellung> zuVerarbeitendeBestellungen;
    private LinkedList<Bestellung> bestellungInProduktion;
    // private LinkedList<Roboter> stuhlProduktionsAbfolge;
    // private LinkedList<Roboter> sofaProduktionsAbfolge;
    

    /** TO DO
     * Konstruktor für Objekte der Klasse Produktions_Manager
     */
    
    public Produktions_Manager(Lager meinLager, Fabrik meineFabrik)
    {
        
        // this.holzRoboter = new Holzarbeitungs_Roboter();
        // this.montageRoboter = new Montage_Roboter();
        // this.lackierRoboter = new Lackier_Roboter();
        // this.verpackungsRoboter = new Verpackungs_Roboter();
        this.meineFabrik = meineFabrik;
        this.meinLager = meinLager; 
        this.zuVerarbeitendeBestellungen = new LinkedList<Bestellung>();
        this.bestellungInProduktion = new LinkedList<Bestellung>();
        //neu
        // this.stuhlProduktionsAbfolge = new LinkedList<Roboter>();
        // this.sofaProduktionsAbfolge = new LinkedList<Roboter>();
        
       
        holzRoboter.start();
        montageRoboter.start();
        lackierRoboter.start();
        verpackungsRoboter.start();
        
        // stuhlProduktionsAbfolge.add(holzRoboter);
        // stuhlProduktionsAbfolge.add(montageRoboter);
        // stuhlProduktionsAbfolge.add(lackierRoboter);
        // stuhlProduktionsAbfolge.add(verpackungsRoboter);
        
        // sofaProduktionsAbfolge.add(holzRoboter);
        // sofaProduktionsAbfolge.add(lackierRoboter);
        // sofaProduktionsAbfolge.add(montageRoboter);
        // sofaProduktionsAbfolge.add(verpackungsRoboter);
    }
    
    
    // Implementiert run für die Threadklasse
    public void run()
    {
        while(true) //man braucht Moeglichkeit, um die Schleife zu unterbr
        {
            // Ist neue Bestellung eingetroffen, dann hole nächste Bestellung und starte Produktion

            if(!zuVerarbeitendeBestellungen.isEmpty())
            {
                Bestellung neueBestellung = zuVerarbeitendeBestellungen.poll();
                bestellungInProduktion.add(neueBestellung);
                System.out.println("Produktion von Bestellung " + neueBestellung.gibBestellungsNr() + " in bearbeitung." );
                // starteProduktion(neueBestellung);
            }
                       
            // Wird gebraucht, damit der Loop nicht so oft wie möglich durchgeführt wird und somit
            // den Prozessor überarbeitet 
            try{
                Thread.sleep(10);
            }
            catch(InterruptedException ie)
            {
                ie.printStackTrace();
            }
        }
    }
    
    // // Startet Produktion aller Produkte in bestellung
    // private void starteProduktion(Bestellung bestellung)
    // {
    //     for(Produkt prod: bestellung.gibBestellteProdukte())
    //     {
    //         if(prod instanceof Stuhl)
    //         {
    //             // LinkedList muss geclonet werden, da jeder Stuhl seine eigene Kopie verändert
    //             prod.setzeProduktionsAblauf((LinkedList<Roboter>) stuhlProduktionsAbfolge.clone());
    //             prod.naechsteProduktionsStation();
    //         }
    //         else if(prod instanceof Sofa)
    //         {
    //             // LinkedList muss geclonet werden, da jedes Sofa seine eigene Kopie verändert
    //             prod.setzeProduktionsAblauf((LinkedList<Roboter>) sofaProduktionsAbfolge.clone());
    //             prod.naechsteProduktionsStation();
    //         }
    //         else
    //         {
    //             throw new IllegalArgumentException("starteProduktion() nicht für diese Subklasse von Produkt definiert");
    //         }
    //     }
    // }

    // // Produktion eines Stuhls
    // private void produziereStuhl(){

        

    // }
    
    // Fügt Bestellung zur Liste der zu produzierenden Bestellungen hinzuw
    public void fuegeZuVerarbeitendeBestellungenHinzu(Bestellung bestellung)
    {
        zuVerarbeitendeBestellungen.add(bestellung);
    }


}
   
    /**
    public void run() {
        while (true) {
            // Prüfe, ob eine neue Bestellung eingetroffen ist
            if (!zuVerarbeitendeBestellungen.isEmpty()) {
                Bestellung neueBestellung = zuVerarbeitendeBestellungen.poll();
                bestellungInProduktion.add(neueBestellung);

                // Starte die Produktion für die neue Bestellung
                starteProduktion(neueBestellung);

                try {
                    Thread.sleep(1000); 
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        }
    }
    /**public void startRoboter() {
        while (true) {
            // Prüfe, ob eine neue Bestellung eingetroffen ist
            if (!zuVerarbeitendeBestellungen.isEmpty()) {
                Bestellung neueBestellung = zuVerarbeitendeBestellungen.poll();
                bestellungInProduktion.add(neueBestellung);

                // Starte die Produktion für die neue Bestellung
                starteProduktion(neueBestellung);

                try {
                    Thread.sleep(1000); 
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        }
    }
    **
    
    public void fuegeZuVerarbeitendeBestellungenHinzu(Bestellung bestellung) {
        zuVerarbeitendeBestellungen.add(bestellung);
    }

    public void starteProduktion(Bestellung bestellung) {
        // Implementiere die Produktion hier
        for (Produkt produkt : bestellung.gibBestellteProdukte()) {
            // Alokation der Roboter basierend auf Produkttyp
            if (produkt instanceof Stuhl) {
                try{
                holzRoboter.produziereProdukt(produkt);
                Thread.sleep (10000);
                System.out.println("Bestellung " + bestellung.gibBestellungsNr() + " Holzbearbeitung abgeschlossen.");
                montageRoboter.produziereProdukt(produkt);
                Thread.sleep (5000);
                System.out.println("Bestellung " + bestellung.gibBestellungsNr() + " Montage abgeschlossen.");
                lackierRoboter.produziereProdukt(produkt);
                Thread.sleep (2000);
                System.out.println("Bestellung " + bestellung.gibBestellungsNr() + " Lackierung abgeschlossen.");
                verpackungsRoboter.produziereProdukt(produkt);
                Thread.sleep (5000);
                System.out.println("Bestellung " + bestellung.gibBestellungsNr() + " Verpackung abgeschlossen.");
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            } else if (produkt instanceof Sofa) {
                try{
                holzRoboter.produziereProdukt(produkt);
                Thread.sleep (30000);
                System.out.println("Bestellung " + bestellung.gibBestellungsNr() + " Holzbearbeitung abgeschlossen.");
                lackierRoboter.produziereProdukt(produkt);
                Thread.sleep (5000);
                System.out.println("Bestellung " + bestellung.gibBestellungsNr() + " Lackierung abgeschlossen.");
                montageRoboter.produziereProdukt(produkt);
                Thread.sleep (15000);
                System.out.println("Bestellung " + bestellung.gibBestellungsNr() + " Montage abgeschlossen.");
                verpackungsRoboter.produziereProdukt(produkt);
                Thread.sleep (10000);
                System.out.println("Bestellung " + bestellung.gibBestellungsNr() + " Verpackung abgeschlossen.");
            } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
        }

        // Überprüfe, ob die Bestellung abgeschlossen ist
        if (bestellungInProduktion.contains(bestellung)) {
            bestellungInProduktion.remove(bestellung);
            System.out.println("Bestellung " + bestellung.gibBestellungsNr() + " abgeschlossen.");
        }
        }
 
    }
}
    /**
     * Methode, um die Produktionszeit zu setzen.
     * @param   produktionsZeit Die Zeit, die es benötigt um die Produkte zu produzieren.
     *
    public int gibProduktionsZeit(Product product) {
        if (product instanceof Stuhl){
            return 
        }
        
        ptproduktionsZeit = produktionsZeit)
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