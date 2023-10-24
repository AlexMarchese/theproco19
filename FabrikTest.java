

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testklasse Fabriktest, um Fabrik und dessen Methoden mit den davon abhängigen Klassen zu testen
 *
 * @author  GBI Gruppe 19
 * @version 1
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

    @Test
    /**
     * Ablauf vom Test
     */
    public void testeFabrik() {

        Fabrik testFabrik = new Fabrik();

        assertEquals(testFabrik.gibBestellungsList().size(), 0);
        assertEquals(testFabrik.gibbestellungsNrCounter(), 1);

        System.out.println("Initialisierung der Klasse Fabrik erfolgreich.");

    }
    
    @Test
    /**
     * Ablauf vom Test
     */
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

    @Test
    /**
     * Ablauf vom Test
     */
    public void testeBestellungAufgeben() {

        Fabrik testFabrik = new Fabrik();

        // Nach einer Bestellung
        testFabrik.bestellungAufgeben(3, 4);
        assertEquals(testFabrik.gibBestellungsList().size(), 1);
        assertEquals(testFabrik.gibbestellungsNrCounter(), 1);

        // Nach einer weiteren Bestellung
        testFabrik.bestellungAufgeben(6, 5);
        assertEquals(testFabrik.gibBestellungsList().size(), 2);
        assertEquals(testFabrik.gibbestellungsNrCounter(), 2);

        // Man könnte noch testen, ob die Korrekte Anzahl an Produkten in den entsprechenden
        // Bestellungen erfasst wurde. Dies wurde aber schon durch in BestellungTest.java überprüft

        System.out.println("Methode bestellungAufgeben funktioniert bei positiven Werten.");

    }

    @Test
    /**
     * Ablauf vom Test
     */
    public void testeBestellungAufgebenNegativeWerte() {

        Fabrik testFabrik = new Fabrik();
        testFabrik.bestellungAufgeben(0, 0);

        try {
            assertThrows(IllegalArgumentException.class, () -> new Bestellung(-2, 3, 123));
        } catch (AssertionError e) {
            // This block will be executed if the assertion fails (i.e., exception is not thrown) -> auf DE!!!!!!!!!
            fail("Sollte eine 'IllegalArgumentException' zurückgeben, aber es ist ein Fehler aufgetreten.");
        }

        System.out.println("Kontrolle ob einer der eingegebenen Werte für Stuhl oder Sofa negativ ist funktioniert.");


    }

    // @Test TO DELETE
    // /**
    //  * Ablauf vom Test.
    //  * 
    //  * Dieser Test beweist, dass ein Fehler ausgegeben wird, wenn eine negative Zahl eingegeben werden sollte
    //  */
    // public void testeBestellungEingabeNegativeWerte() {

    //      //check Alex
    // }

    // @Test    ////// to be fixed
    // /**
    //  * Ablauf vom Test
    //  */
    // public void testeBestellungenAusgeben() {

    //     Fabrik testFabrik = new Fabrik();

    //     // System.err.println(testFabrik.bestellungenAusgeben());
    //     assertEquals(testFabrik.bestellungenAusgeben(), "In der Fabrik GBI Gruppe 19 gibt es im Moment 0 Bestellungen.\n\n");

    //     testFabrik.bestellungAufgeben(1, 2);
    //     testFabrik.bestellungAufgeben(0, 3);

    //     String erwarteteAusgabe = "In der Fabrik GBI Gruppe 19 gibt es im Moment 2 Bestellungen. \n\n";
    //     erwarteteAusgabe += ("Bestellung Nr.: 1\nAnzahl Stühle: 2\nAnzahl Sofas: 1\n" +
    //                         "- - - - - - - - - - - - - - - - - - - - - - - - - - - -\n" +
    //                         "Bestellung Nr.: 2\nAnzahl Stühle: 3\nAnzahl Sofas: 0\n" +
    //                         "- - - - - - - - - - - - - - - - - - - - - - - - - - - -\n");

    //     // System.out.println(testFabrik.bestellungenAusgeben());
    //     // System.out.println(erwarteteAusgabe);
    //     assertEquals(testFabrik.bestellungenAusgeben(), erwarteteAusgabe);

    // }





    
    // @Test
    // /**
    //  * Ablauf vom Test
    //  */
    // public void testeFabrik() {
    //     fabrik = new Fabrik();
        
    //     // fabrik.bestellungAufgeben(1, 0);
    //     // fabrik.bestellungAufgeben(3, 5);
    //     fabrik.bestellungenAusgeben();


    //     // assert 
    //     assertEquals(fabrik.getBestellungen().size(), 9);
    // }

    // @Test
    // /**
    //  * Ablauf vom Test wenn es keine Bestellungen gibt
    //  */
    // public void testeFabrikKeineBestellungen() {
    //     fabrik = new Fabrik();
    //     fabrik.bestellungenAusgeben();
    // }

    // @Test
    // /**
    //  * Ablauf vom Test wenn es keine Bestellungen gibt
    //  */
    // public void testeFabrikNegativerProduktWert() {
    //     fabrik = new Fabrik();
    //     // fabrik.bestellungAufgeben(-1, 0);
    //     fabrik.bestellungenAusgeben();
    // }

    // @Test
    // /**
    //  * Ablauf vom Test Wertüberprüfung
    //  */
    // public void testeFabrikNormal() {
    //     fabrik = new Fabrik();
        
    //     // fabrik.bestellungAufgeben(1, 0);
    //     // fabrik.bestellungAufgeben(3, 5);
    //     fabrik.bestellungenAusgeben();
    // }
}
