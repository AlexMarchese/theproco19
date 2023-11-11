
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testklasse LieferantTest, um die Methoden der Klasse "Lieferant" zu testen. 
 *
 * @author  GBI Gruppe 19
 * @version 1.0
 */

public class LieferantTest {

    String nameTestClasse = "LieferantTest"; // Name der Testklasse
    
    /**
     * Konstruktor von LieferantTest
     */
    public LieferantTest() {
    }

    /**
     * Anweisungen vor jedem Testlauf.
     */
    @BeforeEach
    public void setUp() {
        System.out.println("Testlauf " + nameTestClasse + " Start");
        System.out.println();
    }

    /**
     * Anweisungen nach jedem Testlauf.
     */
    @AfterEach
    public void tearDown() {
        System.out.println();
        System.out.println("Testlauf " + nameTestClasse + " Ende");
        System.out.println("------------------------");
    }

    
    /** TO DO
     * Der Test überprüft, ob die Erstellung eines Lieferants funktioniert. 
     * Dies wird überprüft, indem eine neue Lieferant erstellt wird und die initialisierten Werte 
     * mit der Vorgabe aus dem Test verglichen werden. 
     * 
     */
    @Test
    public void testeLieferantWareBestellen() {

        // Instanzierung eines Lieferanten
        Lieferant testLieferant = new Lieferant();

        // wareBestellen soll "true" zurückgeben
        assertEquals(testLieferant.wareBestellen(0, 0, 0, 0, 0), true);

        System.out.println("Test Aufruf der Methode wareBestellen erfolgreich.");

    }

   


}
