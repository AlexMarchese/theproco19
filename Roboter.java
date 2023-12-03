import java.util.LinkedList;

/**
 * Die Klasse Roboter produziert die Bestellungen, welche vom Produktionsmanager in Auftrag gegeben werden und gibt die Info 
 * 
 * 
 * @author GBI Gruppe 19
 * @version 2.0
 * 
 */
public class Roboter extends Thread
{
    // Instanzvariablen 
    private LinkedList <Produkt> warteschlange;
    private String name; 

    /**
     * Konstruktor für Objekte der Klasse Roboter
     */
    public Roboter()
    {
        // Instanzvariable initialisieren
        this.warteschlange = new LinkedList<Produkt>();
        this.name = "";
    }
    
    
    /// Getters + Setters
    
    
    /**
     * Methode, um den Name des jeweiligen Roboters zu setzen.
     * @param   name Der Name, den der Roboter hat.
     */
    public void setzeName(String name) {
        this.name = name;
    }
    
    /**
     * Methode, gibt den Namen des jeweiligen Roboters zurück.
     * @return   name Der Name, den der Roboter hat.
     */
    public String gibName() {
        return this.name;
    }
    
    
    /// Methoden
    
    
    /**
     * Methode, run() startet den Roboter-Thread.Es wird kontinuierlich überprüft, ob neue Produkte in der Produktwarteschlange sind.
     * Wenn Produkte vorhanden sind, werden diese aus der Warteschlange entfernt und produziert,
     * indem die Methode `produziereProdukt` aufgerufen wird. 
     * Wenn die Warteschlange leer ist, wartet der Roboter für eine Millisekunde, bevor er erneut überprüft.
     * 
     */
    @Override
    public void run()
    {  
        System.out.println(gibName() + " wurde als Thread gestartet...");
        while(true)
        {
            // Schaut, ob neue Produkte in Warteschlange sind, und produziert diese dann.
            if(!warteschlange.isEmpty()){
                produziereProdukt(warteschlange.poll());
            }
            else
            {
                // Falls nichts in Warteschlange, wartet der Roboter 1 Millisekunde, bevor er nochmals schaut.
                try{
                    Thread.sleep(1);
                } catch(InterruptedException ie)
                {
                    ie.printStackTrace();
                }
            }
        }
    }
    
    /**
     * 
     * Methode, produziereProdukte(Produkte produkt) simuliert die Produktion eines Produkts durch den entsprechenden Roboter.
     * Der Roboter schläft für die benötigte Produktionszeit des Produkts und gibt
     * eine Statusmeldung aus, wenn die Produktion abgeschlossen ist. Danach wird
     * das Produkt zur nächsten Produktionsstation verschoben.
     * 
     * @param produkt Das zu produzierende Produkt.
     * 
     */
    public void produziereProdukt(Produkt produkt){
        
        try {
            if(this instanceof Holzbearbeitungs_Roboter){
                // Schlafe (produziere) für die gegebene Zeit -> durch 60 mal 1000, weil es dann so viele Sekunden sind, wie es Stunden brauchen würde.
                Thread.sleep(produkt.gibProduktionszeitHolz()/60*1000);
                System.out.println("Holzbearbeitung für Produkt "+ produkt +" abgeschlossen.");
            } else if(this instanceof Montage_Roboter){
                Thread.sleep(produkt.gibProduktionszeitMontage()/60*1000);
                System.out.println("Montage von Produkt "+ produkt +" abgeschlossen.");
            } else if(this instanceof Lackier_Roboter){
                Thread.sleep(produkt.gibProduktionszeitSpritzung()/60*1000);
                System.out.println("Lackierung von Produkt "+ produkt +" abgeschlossen.");
            } else if(this instanceof Verpackungs_Roboter){
                Thread.sleep(produkt.gibProduktionszeitVerpackung()/60*1000);
                System.out.println("Verpackung von Produkt "+ produkt +" abgeschlossen.");
            }
            
            produkt.naechsteProduktionsStation();
            
        } catch(InterruptedException ie)
        {
            ie.printStackTrace();
        }

        
    }        
    

    /**
     * Methode, fuegeProduktHinzu(Produkt produkt) fügt ein Produkt zur Warteschlange des Roboters hinzu.
     *
     * @param produkt Das Produkt, das zur Warteschlange hinzugefügt werden soll.
     */
    public void fuegeProduktHinzu(Produkt produkt){
        this.warteschlange.add(produkt);
        }
     

  
    
  
}
    
   