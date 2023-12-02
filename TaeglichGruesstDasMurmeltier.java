
/**
 * Die Klasse TaeglichGruesstDasMurmeltier wird genützt um einen Check zu durchlaufen, der alle 24 Stunden (also 24 sec) stattfinden soll.
 * Es wird geprüft, ob das Lager aufgefüllt werden soll. Ausserdem wird eine tägliche Übersicht gegeben.
 * 
 * @author Gruppe GBI19 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class TaeglichGruesstDasMurmeltier extends Thread
{
    // Instanzvariablen
    private Fabrik meineFabrik;

    /**
     * Konstruktor für Objekte der Klasse TaeglichGruesstDasMurmeltier
     */
    public TaeglichGruesstDasMurmeltier(Fabrik fabrik){
        // Instanzvariable initialisieren
        this.meineFabrik = fabrik;
    }
        
    /**
     *  TO DO - DOKU
     */
    @Override
    public void run(){
        System.out.println("Und täglich grüsst das Murmeltier (als Thread gestartet...)");
        while (true) {
            
            //Schlafe für 24h
            try{
            Thread.sleep(24_000); 
            }
            catch (InterruptedException ie){
                ie.printStackTrace();
            }

            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("24 Stunden sind vergangen.\nDie Lagersituation wird ausgegeben und es wird überprüft, ob das Lager aufgefüllt werden muss.");
            System.out.println(this.meineFabrik.lagerSituation());
            // lasse die lagerAuffuellen Methode Laufen
            meineFabrik.lagerAuffuellen();
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");

        }      
        
    }
}
