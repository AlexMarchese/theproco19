import java.util.LinkedList;

/**
 * Die Klasse Roboter produziert die Bestellungen, welche vom Produktionsmanager in Auftrag gegeben werden und gibt die Info 
 * 
 * 
 * @author GBI Gruppe 19
 * @version 1.0
 * 
 */
public class Roboter extends Thread
{
    // Instanzvariablen 
    /*LinkedList <Produkt> warteschlange;
    public String name; 
    public int produktionsZeit;
    */
    private LinkedList <Produkt> warteschlange;
    private String name; 
    private int produktionsZeitStuhl;
    private int produktionsZeitSofa;

    /**
     * Konstruktor für Objekte der Klasse Roboter
     *  
     */
    public Roboter()
    {
        // Instanzvariable initialisieren
        this.warteschlange = new LinkedList<Produkt>();
        String name;
        int produktionsZeitStuhl; 
        int produktionsZeitSofa;
    }

    
    /// Getters und Setters

    /**
     * Methode, um die Produktionszeit zu setzen.
     * @param   produktionsZeit Die Zeit, die es benötigt um die Produkte zu produzieren.
     */
    public void setzeProduktionsZeitStuhl(int produktionsZeitStuhl) {
        this.produktionsZeitStuhl = produktionsZeitStuhl;
    }
    
    /**
     * Methode, um die Produktionszeit zu setzen.
     * @param   produktionsZeit Die Zeit, die es benötigt um die Produkte zu produzieren.
     */
    public void setzeProduktionsZeitSofa(int produktionsZeitSofa) {
        this.produktionsZeitSofa = produktionsZeitSofa;
    }
    
    /**
     * Methode, um die Produktionszeit zu setzen.
     * @param   produktionsZeit Die Zeit, die es benötigt um die Produkte zu produzieren.
     */
    public int gibProduktionsZeitStuhl() {
        return this.produktionsZeitStuhl;
    }
    
    /**
     * Methode, um die Produktionszeit zu setzen.
     * @param   produktionsZeit Die Zeit, die es benötigt um die Produkte zu produzieren.
     */
    public int gibProduktionsZeitSofa() {
        return this.produktionsZeitSofa;
    }
    
    /**
     * Methode, um den Name zu setzen.
     * @param   name Der Name, der die Bestellung hat.
     */
    public void setzeName(String name) {
        this.name = name;
    }
    
    /**
     * Methode, um den Namen zu setzen.
     * @param   name Der Name, der die Bestellung hat.
     */
    public String gibName() {
        return this.name;
    }
    
    /// Methoden
    
    /**
     * Methode, 
     */
    public void run()
    {
        while(true)
        {
            // Schaut, ob neue Produkte in Warteschlange sind, und produziert die dann.
            if(!warteschlange.isEmpty()){
                produziereProdukt(warteschlange.poll());
            }
            else
            {
                // Falls nichts in Warteschlange, wartet der Roboter 10 Millisekunden, bevor nochmals schaut
                try{
                    Thread.sleep(10);
                }catch(InterruptedException ie)
                {
                    ie.printStackTrace();
                }
            }
        }
    }
    
    /**
     * Methode, 
     */
    public void produziereProdukt(Produkt produkt){
        if(produktionsZeitStuhl == 0 || produktionsZeitSofa == 0)
        {
            throw new IllegalArgumentException("Stuhl-/Sofaproduktionszeit gleich 0 ist unmöglich.");
        }
        
        if(produkt instanceof Stuhl)
        {
            try{
                Thread.sleep(produktionsZeitStuhl);
            }catch(InterruptedException ie)
            {
                ie.printStackTrace();
            }
        }
        else if(produkt instanceof Sofa)
        {
            try{
                Thread.sleep(produktionsZeitSofa); 
            }catch(InterruptedException ie)
            {
                ie.printStackTrace();
            }
        }
        else
        {
            throw new IllegalArgumentException("produziereProdukt() nicht implementiert für das gewählte Produkt");
        }
        
        produkt.naechsteProduktionsStation();
        
    }        
    }

    
    /**
     * Methode, 
     *
   // public void fuegeProduktHinzu(Produkt produkt){
        //
    }
     **/

  
    
  
        //}
    
   