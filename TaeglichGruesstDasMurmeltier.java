
/**
 * Die Klasse TaeglichGruesstDasMurmeltier repräsentiert einen Thread, der alle 24 Stunden (24 sec) einen Prüfung der Lagersituation durchführen soll.
 * Es wird geprüft, ob das Lager aufgefüllt werden soll und eine tägliche Übersicht gegeben.
 * 
 * @author GBI Gruppe 19 
 * @version 2.0
 */
public class TaeglichGruesstDasMurmeltier extends Thread
{
    // Instanzvariablen
    private Fabrik meineFabrik;
    private int zeitFaktor; // Wird benötigt, um dem Nutzer aus der GUI die Möglichkeit zu geben die Zeit um den Faktor zu beeinflussen

    /**
     * Konstruktor für Objekte der Klasse TaeglichGruesstDasMurmeltier
     */
    public TaeglichGruesstDasMurmeltier(Fabrik fabrik){
        // Instanzvariable initialisieren
        this.meineFabrik = fabrik;
        this.zeitFaktor = 1;
    }
        
    /**
     *  Methode, run() startet einen Thread, der in regelmässsigen Abständen die Lagersituation einer Fabrik überprüft,
     *  die vergangene Zeit simuliert und bei Bedarf das Lager auffüllt.
     */
    @Override
    public void run(){
        System.out.println("Und taeglich gruesst das Murmeltier (als Thread gestartet...)");
        while (true) {
            
            //Der Thread schläft für 24 Stunden
            try{
            Thread.sleep(24_000 * this.zeitFaktor); 
            }
            catch (InterruptedException ie){
                // Falls der Thread während des Schlafens unterbrochen wird, wird eine Fehlermeldung ausgegeben
                ie.printStackTrace();
            }

            // Informationsausgabe, Lagersituation lagerbeständeüberprüfen und ggf. auffüllen
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("24 Stunden sind vergangen.\nDie Lagersituation wird ausgegeben und es wird ueberprueft, ob das Lager aufgefuellt werden muss.");
            System.out.println(this.meineFabrik.lagerSituation());
            // lasse die lagerAuffuellen Methode Laufen
            System.out.println(meineFabrik.lagerAuffuellen());
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");

        }      
        
    }

    /**
     * Methode zur Veränderung der Zeit um den im Input angegebenen Faktor.
     * 
     */
    public void beeinflusseZeit(int faktor){
        this.zeitFaktor = faktor;
    }
}
