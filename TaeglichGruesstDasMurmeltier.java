
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
    private volatile int zeitFaktor; // Wird benötigt, um dem Nutzer aus der GUI die Möglichkeit zu geben die Zeit um den Faktor zu beeinflussen
    private int warten; // Sekunden, wieviel gewartet werden muss

    /**
     * Konstruktor für Objekte der Klasse TaeglichGruesstDasMurmeltier
     */
    public TaeglichGruesstDasMurmeltier(Fabrik fabrik){
        // Instanzvariable initialisieren
        this.meineFabrik = fabrik;
        this.zeitFaktor = 1;
        this.warten = 24_000 * this.zeitFaktor; // Defaultwert sind 24 * Faktor
        // this.warten = 1_000 * this.zeitFaktor; // Defaultwert sind 24 * Faktor
    }
        
    /**
     *  Methode, run() startet einen Thread, der in regelmässsigen Abständen die Lagersituation einer Fabrik überprüft,
     *  die vergangene Zeit simuliert und bei Bedarf das Lager auffüllt.
     */
    @Override
    public void run(){
        
        // Warten, dass die Variablen initialisiert werden
        try {
            Thread.sleep(2_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // System.out.println("Und taeglich gruesst das Murmeltier (als Thread gestartet...)");
        loop();
              
        
    }

    /*
     * Methode, die alle 24h überprüft, ob das Lager aufgefüllt werden muss
     */
    private void loop() {

        int warteZeit = warten;
        while (warteZeit == warten) {
            
            
            //Der Thread schläft für 24 Stunden * Faktor
            try{
            Thread.sleep(warten); 
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

            // warten = 1_000 * this.zeitFaktor;
            warten = 24_000 * this.zeitFaktor;

        }
        // System.out.println("CHangeee");
        loop();
    }
    

    /**
     * Methode zur Veränderung der Zeit um den im Input angegebenen Faktor.
     * 
     */
    public void beeinflusseZeit(int faktor){
        this.zeitFaktor = faktor;
    }
}
