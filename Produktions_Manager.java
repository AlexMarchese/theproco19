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
 * @version 2.0
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
    private int zeitFaktor; // Wird benötigt, um dem Nutzer aus der GUI die Möglichkeit zu geben die Zeit um den Faktor zu beeinflussen

    /** 
     * Konstruktor für Objekte der Klasse Produktions_Manager
     * 
     * @param meinLager     Das Lager, das vom Produktions-Manager verwaltet wird.
     * @param meineFabrik   Die Fabrik, zu der der Produktions-Manager gehört.
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
        this.zeitFaktor = 1;
        
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
        
        //zur Vorgabe der Produktionsabfolge für Stuhl und Sofa
        this.stuhlProduktionsAbfolge = new LinkedList<Roboter>();
        this.sofaProduktionsAbfolge = new LinkedList<Roboter>();
        
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
        while(true)
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
     * @param   bestellung                  Die Bestellung, für die die Produktion gestartet werden soll.
     * @throw   IllegalArgumentException    Wenn die Methode nicht für die Subklasse (Sofa oder Stuhl) des Produkts definiert ist.
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
                // Wenn sich die Klasse seit der letzten Iteration geändert hat oder der Wert nicht den anfänglichen 'null' ist, dann muss man die eine Stunde zur Umstellung der Maschinen beraufgefücksichtigen
                if((prodTyp != null && prod.getClass() != prodTyp.getClass())){
                    try {                    
                        Thread.sleep(1000 * this.zeitFaktor); // eine Stunde warten
                        System.out.println("Die Produktionsstrasse wird umgebaut. Dies dauert eine Stunde.");
                        System.out.println("Die Produktionsstrasse wurde erfolgreich umgebaut.");
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }

                if(prod instanceof Stuhl)
                {
                    prod.setzeProduktionsAblauf(holzRoboter, montageRoboter, lackierRoboter, verpackungsRoboter);
                    this.reduziereLager(Stuhl.gibHolzeinheiten(), Stuhl.gibSchrauben(), Stuhl.gibFarbeinheiten(), Stuhl.gibKartoneinheiten(), 0);
                    prod.naechsteProduktionsStation();
                    
                    prodTyp = prod;
                } 
                else if(prod instanceof Sofa)
                {
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
     * Die Methode fügt Bestellungen zur Liste der zu verarbeitenden Bestellungen hinzu.
     * 
     * @param   bestellung  Die Bestellung, die der Liste der zu verarbeitenden Bestellungen hinzugefügt werden soll.
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
                    System.out.println("Gerade sind nicht genug Einheiten fuer die komplette Erstellung der Produkte der Bestellung verfügbar. Es werden die Produkte produziert, die mit den vorhandenen Mengen an produziert werden koennen. Es wird abgewartet, bis die weiteren Materialien eintreffen und weiter produziert.");

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
    }
    
    // Getters Roboter
    
    /**
     * Methode zur Ausgabe des Holzbearbeitungsroboters.
     */
    public Holzbearbeitungs_Roboter gibHolzRoboter() {
        return this.holzRoboter;
    }
    
    /**
     * Methode zur Ausgabe des Montageroboters.
     */
    public Montage_Roboter gibMontageRoboter() {
        return this.montageRoboter;
    }
    
    /**
     * Methode zur Ausgabe des Lackierroboters.
     */
    public Lackier_Roboter gibLackierRoboter() {
        return this.lackierRoboter;
    }
    
    /**
     * Methode zur Ausgabe des Verpackungsroboters.
     */
    public Verpackungs_Roboter gibVerpackungsRoboter() {
        return this.verpackungsRoboter;
    }

    /**
     * Methode zur Veränderung der Zeit um den im Input angegebenen Faktor.
     * 
     */
    public void beeinflusseZeit(int faktor){
        this.holzRoboter.setzeZeitFaktor(faktor);
        this.montageRoboter.setzeZeitFaktor(faktor);
        this.lackierRoboter.setzeZeitFaktor(faktor);
        this.verpackungsRoboter.setzeZeitFaktor(faktor);
    }
}