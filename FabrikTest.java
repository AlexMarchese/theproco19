

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



    }

    @Test
    /**
     * Ablauf vom Test
     */
    public void testeBestellungAufgebenNegativeWerte() {



    }

    @Test
    /**
     * Ablauf vom Test
     */
    public void testeBestellungenAusgeben() {

        Fabrik testFabrik = new Fabrik();

        assertEquals(testFabrik.bestellungenAusgeben(), "In der Fabrik GBI Gruppe 19 gibt es im Moment 0 Bestellungen.\n");

        testFabrik.bestellungAufgeben(1, 2);
        testFabrik.bestellungAufgeben(0, 3);

        String erwarteteAusgabe = "In der Fabrik GBI Gruppe 19 gibt es im Moment 2 Bestellungen. \n\n";
        erwarteteAusgabe += ("Bestellung Nr.: 1\nAnzahl Stühle: 2\nAnzahl Sofas: 1\n" +
                            "- - - - - - - - - - - - - - - - - - - - - - - - - - - -" +
                            "Bestellung Nr.: 2\nAnzahl Stühle: 3\nAnzahl Sofas: 0\n" +
                            "- - - - - - - - - - - - - - - - - - - - - - - - - - - -") 

        System.out.println(testFabrik.bestellungenAusgeben());
        assertEquals(testFabrik.bestellungenAusgeben(), erwarteteAusgabe);

    }


    
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
