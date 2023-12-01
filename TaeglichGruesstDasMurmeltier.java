
/**
 * Die Klasse TaeglichGruesstDasMurmeltier wird genützt um einen Check zu durchlaufen, der alle 24 Stunden (also 24 sec) stattfinden soll.
 * Es wird geprüft, ob das Lager aufgefüllt werden soll. Ausserdem wird eine tägliche Übersicht gegeben.
 * 
 * @author (Ihr Name) 
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
        meineFabrik = fabrik;
    }
        
    /**
     *  TO DO - DOKU
     */
    @Override
    public void run(){
        // lasse die lagerAuffuellen Methode Laufen
        meineFabrik.lagerAuffuellen();
        
        // gib Übersicht - TO DO, falls Zeit besteht.
        
        //Schlafe für 24h
        try{
        Thread.sleep(24000);
        }
        catch (InterruptedException ie){
            ie.printStackTrace();
        }
    }
}
