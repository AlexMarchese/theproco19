

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testklasse Fabriktest, um Fabrik und deren Methoden mit den davon abhängigen Klassen zu testen.
 *
 * @author  GBI Gruppe 19
 * @version 1.0
 */

 public class FabrikTest {

    String nameTestClasse = "FabrikTest"; // Name der Testklasse
    
    /**
     * Konstruktor von FabrikTest
     */
    public FabrikTest() {
    }

    /**
     * Anweisungen vor jedem Testlauf
     */
    @BeforeEach
    public void setUp() {
        System.out.println("Testlauf " + nameTestClasse + " Start");
        System.out.println();
    }

    /**
     * Anweisungen nach jedem Testlauf
     */
    @AfterEach
    public void tearDown() {
        System.out.println();
        System.out.println("Testlauf " + nameTestClasse + " Ende");
        System.out.println("------------------------");
    }

    
    /**
     * 
     * Der Test überprüft, ob die Erstellung einer Fabrik funktioniert. 
     * Dies wird überprüft, indem eine neue Fabrik erstellt wird und die initialisierten Werte
     * ("leere Liste" und "BestellungsNrCounter auf 1")  mit der Vorgabe aus dem Test vergliechen werden. 
     *  
     */
    @Test
    public void testeFabrik() {

        Fabrik testFabrik = new Fabrik();

        assertEquals(testFabrik.gibBestellungsList().size(), 0);
        assertEquals(testFabrik.gibbestellungsNrCounter(), 1);

        System.out.println("Initialisierung der Klasse Fabrik erfolgreich.");

    }
    
    
    /**
     * Test der Setter-Methoden. 
     * Der Test überprüft, ob die Methoden (1) BestellungsListe auf Null setzt  2) die BestellungsListe befüllt wird) 
     * wie erwartet ausgeführt wird, indem die Rückgabe mit der Vorgabe aus dem Test verglichen wird.
     *  
     */
    @Test
    public void testeSetters() {

        Fabrik testFabrik = new Fabrik();

        testFabrik.setzeBestellungsList(null);
        assertNull(testFabrik.gibBestellungsList());

        ArrayList<Bestellung> testArray = new ArrayList<Bestellung>() ;
        testArray.add(0, new Bestellung(1, 0, 1));

        testFabrik.setzeBestellungsList(testArray);
        assertEquals(testFabrik.gibBestellungsList().size(), 1);

        System.out.println("Setters und Getters Funktionieren");

    }

    
    /**
     * 
     * Test der Methode "bestellungAufgeben()". 
     * Der Test überprüft, ob nach Ausführung der Mehtode die Liste korrekt befüllt  
     * und der BestellungsNrCounter erhöht wird, 
     * indem eine Fabrik erstellt wird und die Ausführung mit der Vorgabe aus dem Test verglichen wird. 
     * 
     */
    @Test
    public void testeBestellungAufgeben() {

        Fabrik testFabrik = new Fabrik();
        testFabrik.erstelleLager(100, 100, 100, 100, 100, 100, 100, 100, 100, 100);

        // Nach einer Bestellung
        testFabrik.bestellungAufgeben(3, 4);
        assertEquals(testFabrik.gibBestellungsList().size(), 1);
        assertEquals(testFabrik.gibbestellungsNrCounter(), 2);

        // Nach einer weiteren Bestellung
        testFabrik.bestellungAufgeben(6, 5);
        assertEquals(testFabrik.gibBestellungsList().size(), 2);
        assertEquals(testFabrik.gibbestellungsNrCounter(), 3);

        // Man könnte noch testen, ob die Korrekte Anzahl an Produkten in den entsprechenden
        // Bestellungen erfasst wurde. Dies wurde aber schon durch in BestellungTest.java überprüft

        System.out.println("Methode bestellungAufgeben funktioniert bei positiven Werten.");

    }

    
    /**
     * 
     * Test der Methode "bestellungAufgebenNegativWerte()". 
     * Der Test überprüft, ob bei der Eingabe von Negativwerten der richtige Text zurückgegeben wird,
     * indem die Rückgabe mit der Vorgabe aus dem Test verglichen wird. 
     * 
     */
    @Test
    public void testeBestellungAufgebenNegativeWerte() {

        Fabrik testFabrik = new Fabrik();

        // Eine Bestellung mit einem oder beiden Negativwerten soll verhindert werden.

        // Einer der beiden Werte negativ
        try {
            assertThrows(IllegalArgumentException.class, () -> testFabrik.bestellungAufgeben(-3, 4));
        } catch (AssertionError e) {
            // Fehler wird angegeben, falls die Operation unzulässig ist
            fail("Sollte eine 'IllegalArgumentException' zurückgeben, aber es ist ein Fehler aufgetreten.");
        }

        // Beide Werte negativ
        try {
            assertThrows(IllegalArgumentException.class, () -> testFabrik.bestellungAufgeben(-3, -4));
        } catch (AssertionError e) {
            // Fehler wird angegeben, falls die Operation unzulässig ist
            fail("Sollte eine 'IllegalArgumentException' zurückgeben, aber es ist ein Fehler aufgetreten.");
        }

        System.out.println("Methode bestellungAufgeben verhindert die Eingabe von Negativwerten.");

    }

    /** TO DO
     * 
     * Test der Methode "bestellungAufgebenNegativWerte()". 
     * Der Test überprüft, ob bei der Eingabe von Negativwerten der richtige Text zurückgegeben wird,
     * indem die Rückgabe mit der Vorgabe aus dem Test verglichen wird. 
     * 
     */
    @Test
    public void testeBestellungAufgebenZuVielAufEinmal() {

        Fabrik testFabrik = new Fabrik();
        testFabrik.erstelleLager(100, 100, 100, 100, 100, 100, 100, 100, 100, 100);

        // Eine Bestellung mit zu großer Menge (entsprechend der Größe des Lagers) soll verhindert werden.

        // Werte sind zu gross
        try {
            assertThrows(IllegalArgumentException.class, () -> testFabrik.bestellungAufgeben(55, 4));
        } catch (AssertionError e) {
            // Fehler wird angegeben, falls die Operation unzulässig ist
            fail("Sollte eine 'IllegalArgumentException' zurückgeben, aber es ist ein Fehler aufgetreten.");
        }

        System.out.println("Methode testeBestellungAufgebenZuVielAufEinmal verhindert die Eingabe von zu hohen Werten, entsprechend der maximalen Kapazität des Lagers.");

    }

    // /** TO DO
    //  * 
    //  * Test der Methode "bestellungAufgebenNegativWerte()". 
    //  * Der Test überprüft, ob bei der Eingabe von Negativwerten der richtige Text zurückgegeben wird,
    //  * indem die Rückgabe mit der Vorgabe aus dem Test verglichen wird. 
    //  * 
    //  */
    // @Test
    // public void testeBestellungAufgebenNichtGenugMaterialienFuerTagVerfuegbar() {

    //     Fabrik testFabrik = new Fabrik();
    //     testFabrik.erstelleLager(100, 100, 100, 100, 100, 100, 100, 100, 100, 100);

    //     // Einige Bestellungen im Laufe des Tages
    //     testFabrik.bestellungAufgeben(3, 4);
    //     testFabrik.bestellungAufgeben(1, 4);

    //     // Produkte werden erstellt
    //     testFabrik.erstelleProdukte();

    //     System.out.println(testFabrik.lagerSituation());

    //     // Eine weitere Bestellung sollte nicht mehr möglich sein, da keine Schrauben mehr verfügbar sind
    //     try {
    //         assertThrows(IllegalArgumentException.class, () -> testFabrik.bestellungAufgeben(1, 2));
    //     } catch (AssertionError e) {
    //         // Fehler wird angegeben, falls die Operation unzulässig ist
    //         fail("Sollte eine 'IllegalArgumentException' zurückgeben, aber es ist ein Fehler aufgetreten.");
    //     }

    //     System.out.println("Methode testeBestellungAufgebenNichtGenugMaterialienFuerTagVerfuegbar verhindert die Eingabe von neuen Werten wenn für den spezifischen Tag keine Resourcen mehr auf Lager verfügbar sind. In diesem Fall gibt es keine Schrauben mehr.");

    // }

       
    /**
     * 
     * Test der Methode "bestellungAusgeben()". 
     * Der Test überprüft, ob erstens bei der Ausführung der Methode ohne aufgegebene Bestellung 
     * der richtige Text zurückgegeben wird und zweitens bei der Ausführung der Methode 
     * mit zurvor aufgegebenen Bestellungen der richtige Text zurückgegeben wird,
     * indem die Rückgabe mit der Vorgabe aus dem Test verglichen wird. 
     * 
     */
    @Test
    public void testeBestellungenAusgeben() {

        Fabrik testFabrik = new Fabrik();
        testFabrik.erstelleLager(100, 100, 100, 100, 100, 100, 100, 100, 100, 100);
        
        assertEquals(testFabrik.bestellungenAusgeben(), "In der Fabrik GBI Gruppe 19 gibt es im Moment 0 Bestellungen.\n\n");


        testFabrik.bestellungAufgeben(1, 2);
        testFabrik.bestellungAufgeben(0, 3);

        String erwarteteAusgabe = "In der Fabrik GBI Gruppe 19 gibt es im Moment 2 Bestellungen.\n\n";
        erwarteteAusgabe += ("Bestellung Nr.: 1\nAnzahl Stühle: 2\nAnzahl Sofas: 1\nProduktionszeit: 64 Minuten\nBeschaffungszeit: 0 Tage\n" +
                            "- - - - - - - - - - - - - - - - - - - - - - - - - - - -\n" +
                            "Bestellung Nr.: 2\nAnzahl Stühle: 3\nAnzahl Sofas: 0\nProduktionszeit: 66 Minuten\nBeschaffungszeit: 0 Tage\n" +
                            "- - - - - - - - - - - - - - - - - - - - - - - - - - - -\n\n" +
                            "Das entspricht insgesamt 5 Stühlen und 1 Sofa." +
                            " Die totale Produktionszeit und die totale Beschaffungszeit sind entsprechend 130 Minuten und 0 Tage.");

        assertEquals(testFabrik.bestellungenAusgeben(), erwarteteAusgabe);

        System.out.println("Die Methode Bestellungen Ausgeben funktioniert wie erwartet.");

    }

    /**
     * TO DO
     * Test der Methode "bestellungAusgeben()". 
     * Der Test überprüft, ob erstens bei der Ausführung der Methode ohne aufgegebene Bestellung 
     * der richtige Text zurückgegeben wird und zweitens bei der Ausführung der Methode 
     * mit zurvor aufgegebenen Bestellungen der richtige Text zurückgegeben wird,
     * indem die Rückgabe mit der Vorgabe aus dem Test verglichen wird. 
     * 
     */
    @Test
    public void testeErstelleProdukte() {

        Fabrik testFabrik = new Fabrik();
        testFabrik.erstelleLager(100, 100, 100, 100, 100, 100, 100, 100, 100, 100);

         // Einige Bestellungen im Laufe des Tages
        testFabrik.bestellungAufgeben(3, 4);
        testFabrik.bestellungAufgeben(1, 4);
        testFabrik.bestellungAufgeben(6, 2);

        // Überprüfung, dass die Liste 3 Bestellungen enthält
        assertEquals(testFabrik.gibBestellungsList().size(), 3);

        // Produkte werden erstellt und Überprüfung der Meldung
        assertEquals(testFabrik.erstelleProdukte(), "Die Produkte der ersten 2 Bestellungen wurden erstellt und geliefert.\nWeitere werden hergestellt, sobald neue Bestellungen einkommen und genug Material im Lager ist.");

        // Aufgrund des Mangels in Elementen können nur die Produkte von den ersten beiden Bestellungen erstellt werden.
        // Es bleibt noch eine
        assertEquals(testFabrik.gibBestellungsList().size(), 1);

        // Es ist die Nummer drei
        assertEquals(testFabrik.gibBestellungsList().get(0).gibBestellungsNr(), 3);

        System.out.println("Die Methode erstelleProdukte funktioniert wie erwartet.");

    }

}
