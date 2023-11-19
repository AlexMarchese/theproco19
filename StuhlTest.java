

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testklasse StuhlTest, um die Methoden der Klasse "Stuhl" zu testen.
 *
 * @author  GBI Gruppe 19
 * @version 1.0
 */

public class StuhlTest {

    String nameTestClasse = "StuhlTest"; // Name der Testklasse
    
    /**
     * Konstruktor von StuhlTest
     */
    public StuhlTest() {
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
     * Der Test überprüft, ob die Erstellung eines Stuhls funktioniert. 
     * Dies wird überprüft, indem ein neuer Stuhl erstellt wird und die Rückgabe zuerwarteten Standartwerte  
     * mit der Vorgabe aus dem Test verglichen wird. 
     * 
     */
    @Test
    public void testeStuhl() {
        Stuhl testStuhl = new Stuhl();

        assertEquals(testStuhl.gibHolzeinheiten(), 2);
        assertEquals(testStuhl.gibSchrauben(), 10);
        assertEquals(testStuhl.gibFarbeinheiten(), 2);
        assertEquals(testStuhl.gibKartoneinheiten(), 1);
        assertEquals(testStuhl.gibTotalProduktionszeit(), 22);

        System.out.println("Test Stuhl erfolgreich. Defaultinitialisierung und Getters funktionieren.");
    }

}
