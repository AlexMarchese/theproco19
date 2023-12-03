

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testklasse SofaTest, um die Methoden der Klasse "Sofa" zu testen.
 *
 * @author  GBI Gruppe 19
 * @version 2.0
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

        assertEquals(Sofa.gibHolzeinheiten(), 4);
        assertEquals(Sofa.gibSchrauben(), 5);
        assertEquals(Sofa.gibFarbeinheiten(), 1);
        assertEquals(Sofa.gibKartoneinheiten(), 5);
        assertEquals(Sofa.gibKissen(), 5);
        assertEquals(Sofa.gibTotalProduktionszeit(), 60);

        System.out.println("Test Sofa erfolgreich. Defaultinitialisierung und Getters funktionieren.");
    }

    /**
     * 
     * Diese Testmethode überprüft, ob die Produktionszeiten eines Sofas korrekt initialisiert werden.
     * Es wird ein neues Sofa erstellt und die Rückgabe der erwarteten Produktionszeiten mit der Vorgabe aus dem Test verglichen. 
     * 
     */
    @Test
    public void testeProduktionszeitSofa() {
        Sofa testSofa = new Sofa();

        assertEquals(testSofa.gibProduktionszeitHolz(), 30);
        assertEquals(testSofa.gibProduktionszeitSpritzung(), 5);
        assertEquals(testSofa.gibProduktionszeitMontage(), 15);
        assertEquals(testSofa.gibProduktionszeitVerpackung(), 10);

        System.out.println("Die Produktionszeiten des Sofas werden richtig initialisiert.");
    }

}
