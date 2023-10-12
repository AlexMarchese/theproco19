

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class FabrikTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class FabrikTest {
    private Fabrik fabrik;
    /**
     * Default constructor for test class FabrikTest
     */
    public FabrikTest() {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp() {
        System.out.println("Testlauf Start");
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown() {
        System.out.println("Testlauf Ende");
    }
    
    @Test
    public void testeFabrik() {
        fabrik = new Fabrik();
        
        fabrik.bestellungAufgeben(1, 0);
        fabrik.bestellungAufgeben(3, 5);
        fabrik.bestellungenAusgeben();
    }
}
