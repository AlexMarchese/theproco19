

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testclasse Fabriktest, um Fabrik und dessen Methoden mit den davon abhängigen Klassen zu testen
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
    }

    /**
     * Anweisungen nach jedem Testlauf
     */
    @AfterEach
    public void tearDown() {
        System.out.println("Testlauf Ende");
    }
    
    
    @Test
    /**
     * Ablauf vom Test
     */
    public void testeFabrik() {
        fabrik = new Fabrik();
        
        fabrik.bestellungAufgeben(1, 0);
        fabrik.bestellungAufgeben(3, 5);
        fabrik.bestellungenAusgeben();


        // assert 
        // assertEquals(fabrik.bestellungList.length, 9);
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
        fabrik.bestellungAufgeben(-1, 0);
        fabrik.bestellungenAusgeben();
    }

    @Test
    /**
     * Ablauf vom Test Wertüberprüfung
     */
    public void testeFabrikNormal() {
        fabrik = new Fabrik();
        
        fabrik.bestellungAufgeben(1, 0);
        fabrik.bestellungAufgeben(3, 5);
        fabrik.bestellungenAusgeben();
    }
}
