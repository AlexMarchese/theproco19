import java.util.ArrayList;

/**
 * Die Klasse Fabrik enthält eine Übersicht (Array-Liste) über alle Bestellungen und dient zur Verwaltung von Produktion und Bestellungen.
 * 
 * @author GBI Gruppe 19
 * @version 2.0
*/

public class Fabrik {
    // Hier wird die Klasse initialisiert und eine Array-List definiert
    private ArrayList <Bestellung> bestellungList;
    private int bestellungsNrCounter;
    private Lager lager;
    private Produktions_Manager produktions_manager;
    private TaeglichGruesstDasMurmeltier meinMurmeltier;

    /**
     * Konstruktor für Instanzen der Klasse Fabrik.
     */
    public Fabrik() {
        this.bestellungList = new ArrayList<Bestellung>();
        this.bestellungsNrCounter = 1; // Attribut für die erste Bestellung gesetzt
        // Lager, Produktionsmanager und Murmeltier werden erst nach Aufruf der jeweiligen Methode durch Main gestartet.
    }


    /// Getters und Setters

    /**
     * Methode zum Setzen der ArrayList mit den Bestellungen.
     * 
     * @param  bestellungList   ArrayList mit den Bestellungen.
     */
    public void setzeBestellungsList(ArrayList<Bestellung> bestellungList) {
        this.bestellungList = bestellungList;
    }

    /**
     * Methode zur Ausgabe der Bestellungen.
     * 
     * @return  bestellungList   Liste mit den Bestellungen.
     */
    public ArrayList<Bestellung> gibBestellungsList() {
        return this.bestellungList;
    }

    /**
     * Methode zum Setzen des Zählers der Bestellungen.
     * 
     * @param  bestellungsNrCounter   Zähler der Bestellungen.
     */
    public void setzebestellungsNrCounter(int bestellungsNrCounter) {
        this.bestellungsNrCounter = bestellungsNrCounter;
    }

    /**
     * Methode zur Ausgabe des Zählers der Bestellungen.
     * 
     * @return  bestellungsNrCounter   Zähler der Bestellungen.
     */
    public int gibbestellungsNrCounter() {
        return this.bestellungsNrCounter;
    }

    /**
     * Methode zur Ausgabe der Lagers der Fabrik.
     * 
     * @return  lager   Lager der Fabrik.
     */
    public Lager gibLager() {
        return this.lager;
    }



    

    /// Methoden

    
    /**
     * Methode zur Erstellung des Lagers. Wird von main aufgerufen.
     * 
     *@param    maxHolzeinheiten            Die maximale Kapazität des Lagers für Holzeinheiten.
     *@param    maxSchrauben                Die maximale Kapazität des Lagers für Schrauben. 
     *@param    maxFarbeeinheiten           Die maximale Kapazität des Lagers für Farbeinheiten.
     *@param    maxKartoneinheiten          Die maximale Kapazität des Lagers für Kartoneinheiten.
     *@param    maxKissen                   Die maximale Kapazität des Lagers für Kissen.
     *@param    vorhandeneHolzeinheiten     Die aktuell vorhandene Anzahl Holzeinheiten im Lager.
     *@param    vorhandenSchrauben          Die aktuell vorhandene Anzahl Schrauben im Lager.
     *@param    vorhandeneFarbeeinheiten    Die aktuell vorhandene Anzahl Farbeinheiten im Lager.
     *@param    vorhandeneKartoneinheiten   Die aktuell vorhandene Anzahl Kartoneinheiten im Lager.
     *@param    vorhandeneKissen            Die aktuell vorhandene Anzahl Kissen im Lager. 
     */
    public void erstelleLager(int maxHolzeinheiten, int maxSchrauben, int maxFarbeeinheiten, int maxKartoneinheiten,int maxKissen, int vorhandeneHolzeinheiten, int vorhandenSchrauben, int vorhandeneFarbeeinheiten, int vorhandeneKartoneinheiten, int vorhandeneKissen) {
        lager = new Lager(maxHolzeinheiten, maxSchrauben, maxFarbeeinheiten, maxKartoneinheiten, maxKissen, vorhandeneHolzeinheiten, vorhandenSchrauben, vorhandeneFarbeeinheiten, vorhandeneKartoneinheiten, vorhandeneKissen);
    }

    /**
     * Methode zur Erstellung des Produktionsmanager. Wird von main aufgerufen.
     */
    public void erstelleProduktions_Manager() {
        this.produktions_manager = new Produktions_Manager(this.lager, this);
        produktions_manager.start();
    }
    
    /**
     * Methode zur Erstellung des Murmeltiers. Das Murmeltier ruft Abläufe auf, welche alle 24 Stunden stattfinden sollen. Wird von main aufgerufen.
     */
    public void erstelleMurmeltier() {
        this.meinMurmeltier = new TaeglichGruesstDasMurmeltier(this);
        meinMurmeltier.start();
    }

    /**
     * Methode, die überprüft, ob das Lager aufgefüllt werden muss und ggf. die zugehörige Methode der Klasse Lager ausführt.
     * Die Methode im Lager wird aufgerufen, sofern eines der Materialien unter 25% des maximalen Lagerbestands fällt.
     * Falls schon eine Lieferung im Gange ist, wird die Bestellung durch die zugehörige Methode der Klasse Lager unterbunden.
     */
    public String lagerAuffuellen(){    
        // Fülle das gesamte Lager zum Maximum auf, falls ein Material unter 25% des maximalen Lagerbestands fällt.
        
        if (lager.gibvorhandeneHolzeinheiten() < lager.gibMaxHolzeinheiten() * 0.25
             || lager.gibvorhandeneSchrauben() < lager.gibMaxSchrauben()*0.25
             || lager.gibvorhandeneFarbeeinheiten() < lager.gibMaxFarbeeinheiten()*0.25
             || lager.gibvorhandeneKartoneinheiten() < lager.gibMaxKartoneinheiten()*0.25
             || lager.gibvorhandeneKissen() < lager.gibMaxKissen()*0.25) {
                 lager.lagerAuffuellen();
                 return ("\nDie Fabrik meldet tiefe Lagerbestände für mindestens einen Materialtyp und beantragt deshalb das Auffüllen des Lagers.");   
        }
        return("\nDie Fabrik meldet genug hohe Lagerbestände und muss noch nicht aufgefüllt werden.");
    }
    
    /**
     * Methode, um eine Bestellung aufzugeben, die Lieferzeit festzulegen und die Bestellung zu bestätigen.
     * 
     * @param   sofa    Anzahl Sofas
     * @param   chairs  Anzahl Stühle
    */
    public String bestellungAufgeben(int sofa, int chairs) {

        Bestellung neueBestellung;
        
        // Stellt sicher, dass keine Bestellung mit Negativwerten aufgegeben wird.
        if (sofa < 0 || chairs < 0) {
            throw new IllegalArgumentException("Bitte geben Sie keine negativen Werte für die Anzahl an.");
        } 
        // Überprüft, dass die Bestellung (entsprechend der Größe des Lagers) produziert werden kann, wenn es die einzige wäre.
        else if (lager.anzahlBasierendAufLager(sofa, chairs)){
            throw new IllegalArgumentException("Bitte bestellen Sie eine kleinere Menge. Wir sind leider nicht ausgerüstet, um so viel auf einmal zu produzieren.");
        } 
        else { 
            neueBestellung = new Bestellung(sofa, chairs, this.bestellungsNrCounter);
            bestellungList.add(neueBestellung);
            this.bestellungsNrCounter ++; // Bewirkt, dass die folgende Bestellung die nächsthöhere Nummer bekommt.
            
            // Beschaffungszeit wird berechnet, abgespeichert und Materialen werden ggf. nachbestellt.
            neueBestellung.setzeBeschaffungszeit(lager.berechneBeschaffungsZeit(neueBestellung));
         
            // Lieferzeit wird berechnet und Bestellung wird bestaetigt.
            neueBestellung.berechneLieferzeit();

            // Bestellung wird dem Produktionsmanager gegeben
            produktions_manager.fuegeZuVerarbeitendeBestellungenHinzu(neueBestellung);

            return neueBestellung.bestellungBestaetigen();
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
        String best = " Bestellungen.\n";

        // Folgende Zeile gibt das Wort Bestellung im Singular aus, wenn es nur eine ist.
        if (this.bestellungList.size() == 1) {
            best = " Bestellung.\n";
        }

        // Erster Teil der Ausgabe
        ausgabe = ("In der Fabrik GBI Gruppe 19 gibt es im Moment " + this.bestellungList.size() + best + "\n");

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
     * Methode zur Ausgabe der Situation des Lagers. Ruft die Methode vom Lager auf.
     * @return  String  Text zum Lagerbestand.
     *
     */
    public String lagerSituation(){
      
        return lager.lagerBestandAusgeben();
    }
}
    

    
