import java.util.LinkedList;

/**
 * Die Klasse Produkt umfasst die Informationen zu den von der Fabrik produzierbaren Produkten und die dazugehörige Methoden.
 * Diese Produkte umfassen Sofas und Stühle.
 * 
 * @author GBI Gruppe 19
 * @version 1.0
 * 
 * 
 */

public class Produkt {
    // Instanzvariablen
    int zustand;
    private int produktionsZeit; //in Minuten
    private int produktionsZeitHolz; //in Minuten
    private int produktionsZeitMontage; //in Minuten
    private int produktionsZeitSpritzung; //in Minuten
    private int produktionsZeitVerpackung; //in Minuten
    LinkedList<Roboter> produktionsAblauf; //in Minuten

    /** 
     * Konstruktor für Objekte der Klasse Produkt. Produkt kann Zahlenwerte annehmen. 
     */
    public Produkt() {
        // Instanzvariable initialisieren
        this.zustand = 0; // 0 = nicht gestartet, 1 = in Bearbeitung, 2 = abgeschlossen
        this.produktionsZeit = 0; //in Minuten
        this.produktionsAblauf = new LinkedList<Roboter>();
    }


    /// Getters und Setters

    /**
     * Methode, um den Zustandswert des Produkts zu setzen.
     * @param   zustand Der Zustand des Produkts in numerischer Form (0 = nicht gestartet, 1 = in Bearbeitung, 2 = abgeschlossen)
     */
    public void setzeZustand(int zustand) {
        this.zustand = zustand;
    }
    
    /**
     * Methode gibt aktuellen Zustand zurück (0 = nicht gestartet, 1 = in Bearbeitung, 2 = abgeschlossen).
     * 
     * @return  zustand Der aktuelle Zustand des Produkts in numerischer Form
     */
    public int gibZustand() {
        return this.zustand;
    }
    
    /**
     * Methode, um den Produktionsablauf für ein Produkt zu setzen.
     * @param   produktionsAblauf Die Reihenfolge der Produktionsstationen (Roboter) in einer LinkedList
     */
    public void setzeProduktionsAblauf(Roboter roboter1, Roboter roboter2, Roboter roboter3, Roboter roboter4) {
         this.produktionsAblauf.add(roboter1);
         this.produktionsAblauf.add(roboter2);
         this.produktionsAblauf.add(roboter3);
         this.produktionsAblauf.add(roboter4);
    }
    
    /**
     * Methode, um den Produktionsablauf für ein Produkt zu erhalten.
     * @return  produktionsAblauf Die Reihenfolge der Produktionsstationen (Roboter) in einer LinkedList
     */
    public LinkedList<Roboter> gibProduktionsAblauf() {
        return this.produktionsAblauf;
    }
    
    /**
     * Methode, um die Produktionsstation (Roboter) eines Produkts zu wechseln. Nimmt aus der Liste der zu durchlaufenden
     * Roboter den jeweils nächsten heraus und fügt dem Roboter das aktuelle Produkt in der Liste der
     * zu produzierenden Produkte hinzu.
     */
    public void naechsteProduktionsStation() {
        if(produktionsAblauf.size() > 0){
            Roboter roboterImEinsatz = produktionsAblauf.poll();
            roboterImEinsatz.fuegeProduktHinzu(this);
            this.zustand = 1;
        } else {
            System.out.println("Produkt " + this + " ist fertig"); 
            this.zustand = 2;
        }
    }

    /**
     * Methode, um die Produktionszeit für das Holz zu erhalten.
     * @return  produktionsZeit Gibt die Produktionszeit (in Minuten) zurück.
     */
    public int gibProduktionszeitHolz() {
        return this.produktionsZeitHolz;
    }

    /**
     * Methode, um die Produktionszeit für das Holz zu setzen.
     * @param produktionsZeitHolz Die neue Produktionszeit für die Holzbearbeitung in Minuten.
     *  
     */
    public void setzeProduktionszeitHolz(int produktionsZeitHolz) {
        this.produktionsZeitHolz = produktionsZeitHolz;
    }
    
    /**
     * Methode, um die Produktionszeit für die Montage zu erhalten.
     * @return  produktionsZeit Gibt die Produktionszeit (in Minuten) zurück.
     */
    public int gibProduktionszeitMontage() {
        return this.produktionsZeitMontage;
    }

    /**
     * Methode, um die Produktionszeit für die Montage zu setzen.
     * @param  produktionsZeitMontage Die neue Produktionszeit für die Montage in Minuten.
     */
    public void setzeProduktionszeitMontage(int produktionsZeitMontage) {
        this.produktionsZeitMontage = produktionsZeitMontage;
    }    
    
    /**
     * Methode, um die Produktionszeit für die Spritzung zu erhalten.
     * @return  produktionsZeit Gibt die Produktionszeit (in Minuten) zurück.
     */
    public int gibProduktionszeitSpritzung() {
        return this.produktionsZeitSpritzung;
    }

    /**
     * Methode, um die Produktionszeit für die Spritzung zu setzen.
     * @param  produktionsZeitSpritzung Die neue Produktionszeit für die Spritzung in Minuten.
     */
    public void setzeProduktionszeitSpritzung(int produktionsZeitSpritzung) {
        this.produktionsZeitSpritzung = produktionsZeitSpritzung;
    }
    
    /**
     * Methode, um die Produktionszeit für die Verpackung zu erhalten.
     * @return  produktionsZeit Gibt die Produktionszeit (in Minuten) zurück.
     */
    public int gibProduktionszeitVerpackung() {
        return this.produktionsZeitVerpackung;
    }

    /**
     * Methode, um die Produktionszeit für die Verpackung zu setzen.
     * @param  produktionsZeitVerpackung Die neue Produktionszeit für die Verpackung in Minuten.
     */
    public void setzeProduktionszeitVerpackung(int produktionsZeitVerpackung) {
        this.produktionsZeitVerpackung = produktionsZeitVerpackung;
    }
    
}
