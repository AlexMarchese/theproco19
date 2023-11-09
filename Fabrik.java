import java.util.ArrayList;

/**
 * Die Klasse Fabrik enthält eine Übersicht (Array-Liste) über alle Bestellungen und dient zur Verwaltung von Produktion und Bestellungen.
 * 
 * @author GBI Gruppe 19
 * @version 1.0
*/

public class Fabrik {
    // Hier wird die Klasse initialisiert und als Array-List definiert
    private ArrayList<Bestellung> bestellungList;
    private int bestellungsNrCounter;
    private Lager lager;

    /**
     * Konstruktor für Instanzen der Klasse Fabrik.
     */
    public Fabrik() {
        this.bestellungList = new ArrayList<Bestellung>();
        this.bestellungsNrCounter = 1; // Attribut für die erste Bestellung gesetzt
    }


    /// Getters und Setters

    /**
     * Methode zum Setzen der ArrayList mit den Bestellungen.
     * 
     * @param  bestellungList   ArrayList mit den Bestellungen
     */
    public void setzeBestellungsList(ArrayList<Bestellung> bestellungList) {
        this.bestellungList = bestellungList;
    }

    /**
     * Methode zur Ausgabe der Bestellungen.
     * 
     * @return  bestellungList   Liste mit den Bestellungen
     */
    public ArrayList<Bestellung> gibBestellungsList() {
        return this.bestellungList;
    }

    /**
     * Methode zum Setzen des Zählers der Bestellungen.
     * 
     * @param  bestellungsNrCounter   Zähler der Bestellungen
     */
    public void setzebestellungsNrCounter(int bestellungsNrCounter) {
        this.bestellungsNrCounter = bestellungsNrCounter;
    }

    /**
     * Methode zur Ausgabe des Zählers der Bestellungen
     * 
     * @return  bestellungsNrCounter   Zähler der Bestellungen
     */
    public int gibbestellungsNrCounter() {
        return this.bestellungsNrCounter;
    }

    

    /// Methoden

    
    /**
     * Methode zum erstellen eines Lagers. Wird von main aufgerufen.
     * 
     *@param    maxHolzeinheiten            Die maximale Kapazität des Lagers für Holzeinheiten.
     *@param    maxSchrauben                Die maximale Kapazität des Lagers für Schrauben. 
     *@param    maxFarbeeinheiten           Die maximale Kapazität des Lagers für Farbeinheiten.
     *@param    maxKartoneinheiten          Die maximale Kapazität des Lagers für Kartoneinheiten.
     *@param    maxKissen                   Die maximale Kapazität des Lagers für Kissen.
     *@param    vorhandeneHolzeinheiten     Die aktuelle Anzahl Holzeinheiten im Lager.
     *@param    vorhandenSchrauben          Die aktuelle Anzahl Schrauben im Lager.
     *@param    vorhandeneFarbeeinheiten    Die aktuelle Anzahl Farbeinheiten im Lager.
     *@param    vorhandeneKartoneinheiten   Die aktuelle Anzahl Kartoneinheiten im Lager.
     *@param    vorhandeneKissen            Die aktuelle Anzahl Kissen im Lager. 
     */
    public void erstelleLager(int maxHolzeinheiten, int maxSchrauben, int maxFarbeeinheiten, int maxKartoneinheiten,int maxKissen, int vorhandeneHolzeinheiten, int vorhandenSchrauben, int vorhandeneFarbeeinheiten, int vorhandeneKartoneinheiten, int vorhandeneKissen) {
        lager = new Lager(maxHolzeinheiten, maxSchrauben, maxFarbeeinheiten, maxKartoneinheiten, maxKissen, vorhandeneHolzeinheiten, vorhandenSchrauben, vorhandeneFarbeeinheiten, vorhandeneKartoneinheiten, vorhandeneKissen);
    }

    /**
     * Methode, die überprüft, ob das Lager aufgefüllt werden muss und ggf. die zugehörige Methode der Klasse Lager ausführt.
     */
    public void lagerAuffuellen(){    
        // Fülle das Lager auf, falls ein Material nicht ausreicht.
        if (lager.gibvorhandeneHolzeinheiten() + lager.gibInLieferungHolzeinheiten() < lager.benoetigteHolzeinheiten
            || lager.gibvorhandeneSchrauben() + lager.gibInLieferungSchrauben() < lager.benoetigteSchrauben
            || lager.gibvorhandeneFarbeeinheiten() + lager.gibInLieferungFarbeeinheiten() < lager.benoetigteFarbeeinheiten 
            || lager.gibvorhandeneKartoneinheiten() + lager.gibInLieferungKartoneinheiten() < lager.benoetigteKartoneinheiten
            || lager.gibvorhandeneKissen() + lager.gibInLieferungKissen() < lager.benoetigteKissen) {
                lager.lagerAuffuellen();
        }
    }
    
    /**
     * Methode, um eine Bestellung aufzugeben, die Lieferzeit festzulegen und die Bestellung zu bestaetigen.
     * 
     * @param   sofa    Anzahl Sofas
     * @param   chairs  Anzahl Stühle
    */
    public void bestellungAufgeben(int sofa, int chairs) {
        Bestellung neueBestellung;
        
        // Stellt sicher, dass keine Bestellung mit Negativwerten aufgegeben wird
        if (sofa < 0 || chairs < 0) {
            throw new IllegalArgumentException("Bitte geben Sie keine negativen Werte für die Anzahl an.");
        } else {
            neueBestellung = new Bestellung(sofa, chairs, this.bestellungsNrCounter);
            bestellungList.add(neueBestellung);
            this.bestellungsNrCounter ++; // Sodass die folgende Bestellung eine höhere Nummer bekommt
            
            // Beschaffungszeit wird berechnet, abgespeichert und Materialen werden ggf. nachbestellt.
            neueBestellung.setzeBeschaffungszeit(lager.berechneBeschaffungsZeit(neueBestellung));
            
            // Lieferzeit wird berechnet und Bestellung wird bestaetigt.
            neueBestellung.berechneLieferzeit();
            // neueBestellung.bestellungBestaetigen(); //noetig? 
            
            lagerAuffuellen();
            // erstelleProdukte();
        }
    }

    /**
     * Methode zur Ausgabe der Bestellungen.
     * 
     * Anstelle der üblichen Ausgabe, wird der Inhalt als String zurückgegeben, 
     * was einen einen vereinfachten Unit Test ermöglicht.
     * 
     * @return  ausgabe Text zur Ausgabe der Bestellungen
     *
     */
    public String bestellungenAusgeben() {

        String ausgabe = null;
        int anzahlSofasGesamt = 0;
        int anzahlStuehleGesamt = 0;
        int produktionsZeitGesamt = 0;
        int beschaffungsZeitGesamt = 0;
        String best = " Bestellungen.\n\n";

        // Folgende Zeile gibt das Wort Bestellung im Singular aus, wenn es nur eine ist.
        if (this.bestellungList.size() == 1) {
            best = " Bestellung.\n\n";
        }

        // Erster Teil der Ausgabe
        ausgabe = ("In der Fabrik GBI Gruppe 19 gibt es im Moment " + this.bestellungList.size() + best);

        // Information zur jeder Bestellung
        for(Bestellung bestellung : this.bestellungList)   
        {
            // Berechnung der Produktionszeit zur Angabe in Minuten
            int prodzeit = (int)Math.floor(bestellung.gibProduktionszeit() * 1440);
            ausgabe += 
                ("Bestellung Nr.: " + bestellung.gibBestellungsNr() + "\n" +
                "Anzahl Stühle: " + bestellung.gibAnzahlStuehle() + "\n" +
                "Anzahl Sofas: " + bestellung.gibAnzahlSofas() + "\n" +
                "Produktionszeit: " + prodzeit + " Minuten\n" +
                "Beschaffungszeit: " + bestellung.gibBeschaffungszeit() + " Tage\n" +
                "- - - - - - - - - - - - - - - - - - - - - - - - - - - -\n");
            anzahlSofasGesamt += bestellung.gibAnzahlSofas();
            anzahlStuehleGesamt += bestellung.gibAnzahlStuehle();
            produktionsZeitGesamt += prodzeit;
            beschaffungsZeitGesamt += bestellung.gibBeschaffungszeit();
        }

        String st = " Stühlen";
        String sf = " Sofas.";

        // Folgende Zeilen geben das Wort Stuhl und Sofa im Singular aus, wenn es nur eins ist.
        if (anzahlSofasGesamt == 1) {
            sf = " Sofa.";
        }
        if (anzahlStuehleGesamt == 1) {
            st = " Stuhl";
        }


        // Letzter Teil der Ausgabe (wird nur hinzugefügt, wenn es Bestellungen gab also anzahlSofasGesamt oder anzahlStuehleGesamt größer als 0)
        if (anzahlSofasGesamt > 0 || anzahlStuehleGesamt > 0) {
        ausgabe += ("\nDas entspricht insgesamt " + anzahlStuehleGesamt + st + " und " + anzahlSofasGesamt + sf);
        ausgabe += (" Die totale Produktionszeit und die totale Beschaffungszeit sind entsprechend " +
        produktionsZeitGesamt + " Minuten und " + beschaffungsZeitGesamt + " Tage.");
        
        }

        return ausgabe;
        
    }

    /**
     * Methode zur Ausgabe der Situation des Lagers.
     * @return  ausgabe Text zur Ausgabe der Situation des Lagers
     *
     */
    public String lagerSituation(){
        String ausgabe = "Lagersituation";

        ausgabe += ("\nLager:               Holzeinheiten - " + lager.gibvorhandeneHolzeinheiten() + " | Schrauben - " + lager.gibvorhandeneSchrauben() + 
        " | Farbeeineiten - " + lager.gibvorhandeneFarbeeinheiten() + " | Kartoneineiten - " + lager.gibvorhandeneKartoneinheiten() + 
        " | Kissen - " + lager.gibvorhandeneKissen());
        ausgabe += ("\nWird noch geliefert: Holzeinheiten - " + lager.gibInLieferungHolzeinheiten() + "  | Schrauben - " + lager.gibInLieferungSchrauben() + 
        "  | Farbeeineiten - " + lager.gibInLieferungFarbeeinheiten() + "  | Kartoneineiten - " + lager.gibInLieferungKartoneinheiten() + 
        "  | Kissen - " + lager.gibInLieferungKissen());

        return ausgabe;
    }
    
    /**
     * Methode der Erstellung der Produkte aus den Bestellungen. 
     * Solange es genug Einheiten für die Bestellungen gibt, werden die Produkte erstellt und geliefert.
     */
    public void erstelleProdukte(){

        // Variablen zur Ermittlung der für jede Bestellung benötigte Einheiten
        int bestHolz = 0;
        int bestSchrauben = 0;
        int bestFarbe = 0;
        int bestKarton = 0;
        int bestKissen = 0;

        // Variable zur Ermittlung der Anzahl an Bestellungen, die entfernt werden sollen
        int anzahl = 0;


        for(Bestellung bestellung : this.bestellungList){

            // Ermittlung der Werte
            for (Produkt produkt : bestellung.gibBestellteProdukte()) {
                if (produkt instanceof Stuhl) {
                   bestHolz += produkt.gibHolzeinheiten();
                   bestSchrauben += produkt.gibSchrauben();
                   bestFarbe += produkt.gibFarbeinheiten();
                   bestKarton += produkt.gibKartoneinheiten();
    
                } else if (produkt instanceof Sofa) {
                   bestHolz += produkt.gibHolzeinheiten();
                   bestSchrauben += produkt.gibSchrauben();
                   bestFarbe += produkt.gibFarbeinheiten();
                   bestKarton += produkt.gibKartoneinheiten();
                   bestKissen = bestKissen + ((Sofa) produkt).gibKissen();              
                    
                }
            }
            // Überprüfung, ob genug Einheiten vorhanden sind
            if (lager.gibvorhandeneHolzeinheiten() < bestHolz || lager.gibvorhandeneSchrauben() < bestSchrauben || lager.gibvorhandeneFarbeeinheiten() < bestFarbe || lager.gibvorhandeneKartoneinheiten() < bestKarton || lager.gibvorhandeneKissen() < bestKissen) {
                break;
            } else {
                // Benötigte Einheiten werden zur Produktion eingesetzt und somit von den verfügbaren weggenommen.
                lager.setzevorhandeneHolzeinheiten(lager.gibvorhandeneHolzeinheiten() - bestHolz);
                lager.setzevorhandeneSchrauben(lager.gibvorhandeneSchrauben() - bestSchrauben);
                lager.setzevorhandeneFarbeeinheiten(lager.gibvorhandeneFarbeeinheiten() - bestFarbe);
                lager.setzevorhandeneKartoneinheiten(lager.gibvorhandeneKartoneinheiten() - bestKarton);
                lager.setzevorhandeneKissen(lager.gibvorhandeneKissen() - bestKissen);
                
                anzahl ++;
                // liefereBestellung(bestellung);
            }
        
        }

        // // this.bestellungList.remove(0);
        for (int i = 0; i < anzahl; i++) {
            this.bestellungList.remove(0);
        }


    }
    
    // /** TO COMPLETE
    //  * Methode der Lieferung der Produkte aus den Bestellungen.
    //  * 
    //  * @param   best    
    //  * @return 
    //  */
    // public void liefereBestellung(Bestellung best){

    //     // Bestellung wird von der Liste entfernt
    //     this.bestellungList.remove(0);
    //     // Und geliefert
    //     best.bestellungLiefern();
    // }
    
}