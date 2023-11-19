

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testklasse SofaTest, um die Methoden der Klasse "Sofa" zu testen.
 *
 * @author  GBI Gruppe 19
 * @version 1.0
 */

public class SofaTest {
    
    String nameTestClasse = "SofaTest"; // Name der Testklasse

    /**
     * Konstruktor von SofaTest
     */
    public SofaTest() {
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
     * Der Test überprüft, ob die Erstellung eines Sofas funktioniert. 
     * Dies wird überprüft, indem ein neues Sofa erstellt wird und die Rückgabe zuerwarteten Standartwerte  
     * mit der Vorgabe aus dem Test verglichen wird. 
     * 
     */
    @Test
    public void testeSofa() {
        Sofa testSofa = new Sofa();

        assertEquals(testSofa.gibHolzeinheiten(), 2);
        assertEquals(testSofa.gibSchrauben(), 10);
        assertEquals(testSofa.gibFarbeinheiten(), 2);
        assertEquals(testSofa.gibKartoneinheiten(), 1);
        assertEquals(testSofa.gibKissen(), 5);
        assertEquals(testSofa.gibTotalProduktionszeit(), 22);

        System.out.println("Test Sofa erfolgreich. Defaultinitialisierung und Getters funktionieren.");
    }

}
