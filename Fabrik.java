import java.util.ArrayList;

/**
 * Die Klasse Fabrik enthält eine Übersicht (Array-Liste) über alle Bestellungen und dient zur Verwaltung von Produktion und Bestellungen.
 * 
 * @author GBI Gruppe 19
 * @version 1.0
*/

public class Fabrik {
    // Hier wird die Klasse initialisiert und eine Array-List definiert
    private ArrayList <Bestellung> bestellungList;
    private int bestellungsNrCounter;
    private Lager lager;
    private Produktions_Manager produktions_manager;

    /**
     * Konstruktor für Instanzen der Klasse Fabrik.
     */
    public Fabrik() {
        this.bestellungList = new ArrayList<Bestellung>();
        this.bestellungsNrCounter = 1; // Attribut für die erste Bestellung gesetzt
        // this.produktions_manager = new Produktions_Manager(lager, this); // Wird erst unten gestartet, sobald Lager definiert wird
        // produktions_manager.start();
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

    

    /// Methoden

    
    /**
     * Methode zum erstellen eines Lagers. Wird von main aufgerufen.
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
        this.produktions_manager = new Produktions_Manager(lager, this);
        produktions_manager.start();
    }

    
    public void erstelleProduktions_Manager() {
        produktions_manager = new Produktions_Manager(this.lager, this);
    }

    /**
     * Methode, die überprüft, ob das Lager aufgefüllt werden muss und ggf. die zugehörige Methode der Klasse Lager ausführt.
     */
    public String lagerAuffuellen(){    
        // // Fülle das Lager auf, falls ein Material nicht ausreicht.
        // if (lager.gibvorhandeneHolzeinheiten() + lager.gibInLieferungHolzeinheiten() < lager.benoetigteHolzeinheiten
        //     || lager.gibvorhandeneSchrauben() + lager.gibInLieferungSchrauben() < lager.benoetigteSchrauben
        //     || lager.gibvorhandeneFarbeeinheiten() + lager.gibInLieferungFarbeeinheiten() < lager.benoetigteFarbeeinheiten 
        //     || lager.gibvorhandeneKartoneinheiten() + lager.gibInLieferungKartoneinheiten() < lager.benoetigteKartoneinheiten
        //     || lager.gibvorhandeneKissen() + lager.gibInLieferungKissen() < lager.benoetigteKissen) {
        //         System.out.println(lager.lagerAuffuellen() instanceof String); 
        // } 
        return lager.lagerAuffuellen();
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
            this.bestellungsNrCounter ++; // Sodass die folgende Bestellung eine höhere Nummer bekommt
            
            // Beschaffungszeit wird berechnet, abgespeichert und Materialen werden ggf. nachbestellt.
            neueBestellung.setzeBeschaffungszeit(lager.berechneBeschaffungsZeit(neueBestellung));
         
            // Lieferzeit wird berechnet und Bestellung wird bestaetigt.
            neueBestellung.berechneLieferzeit();

            // Bestellung wird dem Produktionsmanager gegeben
            produktions_manager.fuegeZuVerarbeitendeBestellungenHinzu(neueBestellung);
            
            // OLD
            // // Bei jeder Bestellung wird das Lager aufgefüllt.
            // lager.lagerAuffuellen();

            // // Bei jeder Bestellung wird überprüft, ob das Lager aufgefüllt werden kann.
            // this.lagerAuffuellen();

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
    
//    /**
//     * Methode zur Erstellung der Produkte aus den Bestellungen. 
//     * Solange es genug Einheiten für die Bestellungen gibt, werden die Produkte erstellt und geliefert.
//     * 
//     * @return  String  Text zur Erstellung der Produkte. In Abhängigkeit der Anzahl Bestellungen und Material an Lager werden unterschiedliche return statements zurückgegeben.
//     */
//    public String erstelleProdukte(){
//
//        
//
//        // Variable zur Ermittlung der Anzahl an Bestellungen, die entfernt werden sollen
//        int anzahl = 0;
//
//
//        for(Bestellung bestellung : this.bestellungList){
//
//            int [] benoetigteEinheiten = bestellung.anzahlEinheiten();
//
//            if (lager.gibvorhandeneHolzeinheiten() < benoetigteEinheiten[0] || lager.gibvorhandeneSchrauben() < benoetigteEinheiten[1] || lager.gibvorhandeneFarbeeinheiten() < benoetigteEinheiten[2] || lager.gibvorhandeneKartoneinheiten() < benoetigteEinheiten[3] || lager.gibvorhandeneKissen() < benoetigteEinheiten[4]) {
//                break;
//            } else {
//                // Benötigte Einheiten werden zur Produktion eingesetzt und somit von den verfügbaren weggenommen.
//                lager.setzevorhandeneHolzeinheiten(lager.gibvorhandeneHolzeinheiten() - benoetigteEinheiten[0]);
//                lager.setzevorhandeneSchrauben(lager.gibvorhandeneSchrauben() - benoetigteEinheiten[1]);
//                lager.setzevorhandeneFarbeeinheiten(lager.gibvorhandeneFarbeeinheiten() - benoetigteEinheiten[2]);
//                lager.setzevorhandeneKartoneinheiten(lager.gibvorhandeneKartoneinheiten() - benoetigteEinheiten[3]);
//                lager.setzevorhandeneKissen(lager.gibvorhandeneKissen() - benoetigteEinheiten[4]);
//                
//                anzahl ++;
//            }
//            
//        
//        }
//
//        if (anzahl != 0){
//            for (int i = 0; i < anzahl; i++) {
//            this.bestellungList.remove(0);
//            }
//
//            if (anzahl == 1) {
//                return "Die Produkte der ersten Bestellung wurden erstellt und geliefert.\nWeitere werden hergestellt, sobald neue Bestellungen einkommen und genug Material im Lager ist.";
//            }
//            return "Die Produkte der ersten " + anzahl + " Bestellungen wurden erstellt und geliefert.\nWeitere werden hergestellt, sobald neue Bestellungen einkommen und genug Material im Lager ist.";
//        }
//
//        return "Keine Produkte konnten hergestellt werden. Dafür braucht es mindestens eine Bestellung und/oder genug Material im Lager.";
//
//
//    }

    // /** 
    //  * Diese Methode simuliert das vergehen von zwei Tagen. Das hat einen Einfluss auf die Lieferung der Produkte des Lagers.
    //  * Die Materialien in Lieferung werden zum Vorrat hinzugefügt.
    // */
    // public void nachZweiTagen(){

    //     // Materialien in Lieferung kommen an und werden dem Vorrat hinzugefügt
    //     lager.setzevorhandeneHolzeinheiten(lager.gibvorhandeneHolzeinheiten() + lager.gibInLieferungHolzeinheiten());
    //     lager.setzevorhandeneSchrauben(lager.gibvorhandeneSchrauben() + lager.gibInLieferungSchrauben());
    //     lager.setzevorhandeneFarbeeinheiten(lager.gibvorhandeneFarbeeinheiten() + lager.gibInLieferungFarbeeinheiten());
    //     lager.setzevorhandeneKartoneinheiten(lager.gibvorhandeneKartoneinheiten() + lager.gibInLieferungKartoneinheiten());
    //     lager.setzevorhandeneKissen(lager.gibvorhandeneKissen() + lager.gibInLieferungKissen());

    //     // Diese sind also nicht mehr in Lieferung
    //     lager.setzeInLieferungHolzeinheiten(0);
    //     lager.setzeInLieferungSchrauben(0);
    //     lager.setzeInLieferungFarbeeinheiten(0);
    //     lager.setzeInLieferungKartoneinheiten(0);
    //     lager.setzeInLieferungKissen(0);

    // }
    
