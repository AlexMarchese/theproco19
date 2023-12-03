import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections; // Dieses und das nächste werden benötigt, um weiter unten die Liste mit allen Produkten nach Produkttypen zu ordnen
import java.util.Comparator;

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
    
    private Holzbearbeitungs_Roboter holzRoboter;
    private Montage_Roboter montageRoboter;
    private Lackier_Roboter lackierRoboter; 
    private Verpackungs_Roboter verpackungsRoboter;
    private Fabrik meineFabrik; 
    private Lager meinLager; 
    private LinkedList<Bestellung> zuVerarbeitendeBestellungen;
    private LinkedList<Bestellung> bestellungenInProduktion;
    private LinkedList<Roboter> stuhlProduktionsAbfolge;
    private LinkedList<Roboter> sofaProduktionsAbfolge;
    

    /** 
     * Konstruktor für Objekte der Klasse Produktions_Manager
     * 
     * @param meinLager Das Lager, das vom Produktions-Manager verwaltet wird.
     * @param meineFabrik Die Fabrik, zu der der Produktions-Manager gehört.
     * 
     */
    
    public Produktions_Manager(Lager meinLager, Fabrik meineFabrik)
    {
        
        this.meineFabrik = meineFabrik;
        this.meinLager = meinLager;
        this.holzRoboter = new Holzbearbeitungs_Roboter();
        this.montageRoboter = new Montage_Roboter();
        this.lackierRoboter = new Lackier_Roboter(); 
        this.verpackungsRoboter = new Verpackungs_Roboter();
        
        // 2 Sekunden warten bevor die Roboter gestartet werden, da in der Zwischenzeit die Produktionszeit aus den Produkten initialisiert wird.
        // Führt sonst zu Exceptions später im Prozess
        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException ie)
        {
            ie.printStackTrace();
        }

        holzRoboter.start();
        montageRoboter.start();
        lackierRoboter.start();
        verpackungsRoboter.start();
        
        
        this.zuVerarbeitendeBestellungen = new LinkedList<Bestellung>();
        this.bestellungenInProduktion = new LinkedList<Bestellung>();
        
        //neu - zur Vorgabe der Produktionsabfolge für Stuhl und Sofa
        this.stuhlProduktionsAbfolge = new LinkedList<Roboter>();
        this.sofaProduktionsAbfolge = new LinkedList<Roboter>();
       

        // stuhlProduktionsAbfolge.add(holzRoboter);
        // stuhlProduktionsAbfolge.add(montageRoboter);
        // stuhlProduktionsAbfolge.add(lackierRoboter);
        // stuhlProduktionsAbfolge.add(verpackungsRoboter);
        
        // sofaProduktionsAbfolge.add(holzRoboter);
        // sofaProduktionsAbfolge.add(lackierRoboter);
        // sofaProduktionsAbfolge.add(montageRoboter);
        // sofaProduktionsAbfolge.add(verpackungsRoboter);
        
    }
    
    
    /** 
     * 
     * Methode, run() startet Produktions-Manager als eigenen Thread. Es wird kontinuierlich überwacht, ob neue Bestellungen reingekommen sindund
     * startet die Produktion für jede neue Bestellung. Zudem überprüft sie, ob Bestellungen fertiggestellt wurden, und gibt entsprechende Rückmeldungen.
     * 
     */
    
    @Override
    public void run()
    {
        System.out.println("Produktionsmanager wurde als Thread gestartet...");
        while(true) //man braucht Moeglichkeit, um die Schleife zu unterbr (Flo: Wieso? Falls notwendig, müssten wir mit egener Variable und Methode einbauen)
        {
            // Ist neue Bestellung eingetroffen, dann hole nächste Bestellung und starte Produktion

            if(!this.zuVerarbeitendeBestellungen.isEmpty())
            {
                Bestellung neueBestellung = zuVerarbeitendeBestellungen.poll();
                bestellungenInProduktion.add(neueBestellung);
                System.out.println("Produktion von Bestellung " + neueBestellung.gibBestellungsNr() + " in bearbeitung." );
                this.starteProduktion(neueBestellung);
            }
               
            // Überprüfe, ob es fertige Bestellungen hat.
            // Geht durch die Bestellungen
            
            this.pruefeFertigeBestellungen();
            /* TEST - FLO
            ausserLoop: for(Bestellung bestellung : bestellungenInProduktion){
                // Geht durch die Bestellten Produkte
                for(Produkt produkt : bestellung.gibBestellteProdukte()){
                    // wenn irgendein Produkt noch nicht erstellt wurde, dann startet der Loop neu
                    if(produkt.gibZustand() != 2){
                        break ausserLoop;
                    }
                }
                // Wenn alles erstellt, dann Bestätigung dafür geben
                bestellung.setzeAlleProdukteProduziert(true);
                bestellungenInProduktion.remove(bestellung);
                // System.out.println(bestellung.bestellungGeliefert());
                System.out.println("Produktionsmanager ist fertig: " + this); // Was soll das bedeuten?

            } */


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
     
    /** 
     * Methode, starteProduktion(Bestellung bestellung) startet Produktionen aller Produkte für eine gegebene Bestellung und reduziert die Lagerbestände entsprechend. 
     * Die Liste an Bestellungen sind nach dem Typ sortiert, damit die Maschinen möglichst wenig umgebaut werden müssen.
     * Zwischen unterschiedlichen Produkttypen wird eine Stunde Wartezeit eingefügt, um die Maschinen umzustellen.
     * 
     * @param bestellung Die Bestellung, für die die Produktion gestartet werden soll.
     * @throw IllegalArgumentException Wenn die Methode nicht für die Subklasse (Sofa oder Stuhel) des Produkts definiert ist.
     */

    private void starteProduktion(Bestellung bestellung)
    {   
        Produkt prodTyp = null;

        // Liste wird sortiert
        ArrayList<Produkt> produkte = bestellung.gibBestellteProdukte();
        Comparator<Object> classComparator = Comparator.comparing(o -> o.getClass().getName());
        Collections.sort(produkte, classComparator);

            for(Produkt prod : produkte)
            {   
                // Wenn sich die Klasse seit der letzten Iteration geändert hat oder der Wert nicht den anfänglichen 'null' ist, dann muss man die eine Stunde zur Umstellung der Maschinen berücksichtigen
                if((prodTyp != null && prod.getClass() != prodTyp.getClass())){
                    try {                    
                        Thread.sleep(1000); // eine Stunde warten
                        System.out.println("Die Produktionsstrasse wird umgebaut. Dies dauert eine Stunde.");
                        System.out.println("Die Produktionsstrasse wurde erfolgreich umgebaut.");
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }

                if(prod instanceof Stuhl)
                {
                    // LinkedList muss geclonet werden, da jeder Stuhl seine eigene Kopie verändert
                    // prod.setzeProduktionsAblauf((LinkedList<Roboter>) stuhlProduktionsAbfolge.clone());
                    prod.setzeProduktionsAblauf(holzRoboter, montageRoboter, lackierRoboter, verpackungsRoboter);
                    this.reduziereLager(Stuhl.gibHolzeinheiten(), Stuhl.gibSchrauben(), Stuhl.gibFarbeinheiten(), Stuhl.gibKartoneinheiten(), 0);
                    prod.naechsteProduktionsStation();
                    
                    prodTyp = prod;
                } 
                else if(prod instanceof Sofa)
                {
                    // LinkedList muss geclonet werden, da jedes Sofa seine eigene Kopie verändert
                    // prod.setzeProduktionsAblauf((LinkedList<Roboter>) sofaProduktionsAbfolge.clone());
                    prod.setzeProduktionsAblauf(holzRoboter, lackierRoboter, montageRoboter, verpackungsRoboter);
                    this.reduziereLager(Sofa.gibHolzeinheiten(), Sofa.gibSchrauben(), Sofa.gibFarbeinheiten(), Sofa.gibKartoneinheiten(), Sofa.gibKissen());
                    prod.naechsteProduktionsStation();
                    
                    
                    prodTyp = prod;
                }
                else
                {
                    throw new IllegalArgumentException("starteProduktion() nicht für diese Subklasse von Produkt definiert");
                }
            }
        }

    
    /** 
     * Methode, fuegeZuVerarbeitendeBestellungenHinzu(Bestellung bestellung) fügt Bestellung zur Liste der zu produzierenden bzw. verarbeitenden 
     * Bestellungen hinzu.
     * 
     * @param bestellung  Die Bestellung, die der Liste der zu verarbeitenden Bestellungen hinzugefügt werden soll.
     * 
     */
    public void fuegeZuVerarbeitendeBestellungenHinzu(Bestellung bestellung)
    {
        zuVerarbeitendeBestellungen.add(bestellung);
    }

    /** 
     * 
     * Methode, pruefeFertigeBestellungen() überprüft, ob es fertige Bestellungen gibt und macht die nötigen Schritte.
     * Überprüft, ob Bestellungen in der Produktion vollständig abgeschlossen sind.
     * Für jede Bestellung wird geprüft, ob alle bestellten Produkte den Zustand 2 haben,
     * was bedeutet, dass sie fertig produziert wurden. Bei vollständig produzierten Bestellungen
     * wird die entsprechende Bestellung abgeschlossen und aus der Liste der laufenden Bestellungen entfernt.
     * 
     */
    
    public void pruefeFertigeBestellungen()
    {
        for (Bestellung bestellung : this.bestellungenInProduktion) {
            boolean bestellungFertig = true;
            // pruefe ob jedes Produkt der Bestellung den zustand 2 hat. Wenn nicht, setze die Variable bestellungFertig auf false.
            for (Produkt produkt : bestellung.gibBestellteProdukte()) {
                if(produkt.zustand != 2){
                    bestellungFertig = false;
                }
            }
            
            if (bestellungFertig){
                bestellung.setzeAlleProdukteProduziert(true);
                bestellungenInProduktion.remove(bestellung);
                System.out.println("Die Bestellung Nr. " + bestellung.gibBestellungsNr() + " ist fertig.");
            }
    }
    }
    
    /** 
     * 
     * Methode, reduziereLager() reduziert die Lagerbestände um die angegebenen Mengen für verschiedene Materialien(Holz, Schrauben, Farbe, Karton, Kissen).
     * Die Methode überprüft, ob ausreichende Materialien für die Produktion vorhanden sind. Wenn nicht, wird so viel produziert, wie mit den vorhandenen Materialien mölgich ist, 
     * und gewartet (geschlafen), bis genügend Materialien für die vollständige Produktion geliefert wurden.
     *
     * @param holzeinheiten Die Anzahl der zu reduzierenden Holzeinheiten.
     * @param schrauben Die Anzahl der zu reduzierenden Schrauben.
     * @param farbeinheiten Die Anzahl der zu reduzierenden Farbeinheiten.
     * @param kartoneinheiten Die Anzahl der zu reduzierenden Kartoneinheiten.
     * @param kissen Die Anzahl der zu reduzierenden Kissen.
     * 
     * 
     */
    public void reduziereLager(int holzeinheiten, int schrauben, int farbeinheiten, int kartoneinheiten, int kissen){
                int holzEinh = meinLager.gibvorhandeneHolzeinheiten() - holzeinheiten;
                int schraub = meinLager.gibvorhandeneSchrauben() - schrauben;
                int farbEinh = meinLager.gibvorhandeneFarbeeinheiten() - farbeinheiten;
                int kartonEinh = meinLager.gibvorhandeneKartoneinheiten() - kartoneinheiten;
                int kiss = meinLager.gibvorhandeneKissen() - kissen;


                // Sollte eine Einheit durch die zu bearbeitende Bestellung negativ werden (= nicht verfügbar sein), dann wird jede Stunde überprüft, ob die Lieferung der nötigen Materialien eingetroffen ist
                if (holzEinh < 0 || schraub < 0 || farbEinh < 0 || kartonEinh < 0 || kiss < 0) {
                    System.out.println("Gerade sind nicht genug Einheiten für die komplette Erstellung der Produkte der Bestellung verfügbar. Es werden die Produkte produziert, die mit den vorhandenen Mengen an produziert werden können. Es wird abgewartet, bis die weiteren Materialien eintreffen und weiter produziert.");

                    while (holzEinh < 0 || schraub < 0 || farbEinh < 0 || kartonEinh < 0 || kiss < 0) {
                        try{
                            Thread.sleep(5_000); // 5 Sekunden steht für 5 Stunden
                            
                        }
                        catch(InterruptedException ie)
                        {
                            ie.printStackTrace();
                        }
                        
                        // Werte werden neu berechnet
                        holzEinh = meinLager.gibvorhandeneHolzeinheiten() - holzeinheiten;
                        schraub = meinLager.gibvorhandeneSchrauben() - schrauben;
                        farbEinh = meinLager.gibvorhandeneFarbeeinheiten() - farbeinheiten;
                        kartonEinh = meinLager.gibvorhandeneKartoneinheiten() - kartoneinheiten;
                        kiss = meinLager.gibvorhandeneKissen() - kissen;

                    
                        }
                    System.out.println("Jetzt hat es genug Einheiten. Produktion folgt.");
                    } 
                
                

                meinLager.setzevorhandeneHolzeinheiten(holzEinh);
                meinLager.setzevorhandeneSchrauben(schraub);
                meinLager.setzevorhandeneFarbeeinheiten(farbEinh);
                meinLager.setzevorhandeneKartoneinheiten(kartonEinh);
                meinLager.setzevorhandeneKissen(kiss);
        // System.out.println("Lager reduz");
    }
}
   
    /*
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