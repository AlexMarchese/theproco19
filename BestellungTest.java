

import static org.junit.jupiter.api.Assertions.*;
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
    private Fabrik fabrik;
    
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
        System.out.println("Testlauf Start");
        System.out.println();
    }

    /**
     * Anweisungen nach jedem Testlauf
     */
    @AfterEach
    public void tearDown() {
        System.out.println("Testlauf Ende");
        System.out.println("------------------------");
    }

    // check if expetion was thrown: assertThrows
    
    
    @Test
    /**
     * Ablauf vom Test
     */
    public void testeFabrik() {
        fabrik = new Fabrik();
        
        // fabrik.bestellungAufgeben(1, 0);
        // fabrik.bestellungAufgeben(3, 5);
        fabrik.bestellungenAusgeben();


        // assert 
        assertEquals(fabrik.getBestellungen().size(), 9);
    }

    @Test
    /**
     * Ablauf vom Test wenn es keine Bestellungen gibt
     */
    public void testeFabrikKeineBestellungen() {
        fabrik = new Fabrik();
        fabrik.bestellungenAusgeben();
    }

    @Test
    /**
     * Ablauf vom Test wenn es keine Bestellungen gibt
     */
    public void testeFabrikNegativerProduktWert() {
        fabrik = new Fabrik();
        // fabrik.bestellungAufgeben(-1, 0);
        fabrik.bestellungenAusgeben();
    }

    @Test
    /**
     * Ablauf vom Test Wertüberprüfung
     */
    public void testeFabrikNormal() {
        fabrik = new Fabrik();
        
        // fabrik.bestellungAufgeben(1, 0);
        // fabrik.bestellungAufgeben(3, 5);
        fabrik.bestellungenAusgeben();
    }
}
