
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

   


}
