

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testklasse SofaTest, um das Sofa und deren Methoden zu testen.
 *
 * @author  GBI Gruppe 19
 * @version 1
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
    
    @Test
    /**
     * Ablauf vom Test
     */
    public void testeSofaKeineVariablenAngabe() {
        Sofa testSofa = new Sofa();

        assertEquals(testSofa.gibHolzeinheiten(), 4);
        assertEquals(testSofa.gibSchrauben(), 5);
        assertEquals(testSofa.gibFarbeinheiten(), 1);
        assertEquals(testSofa.gibKartoneinheiten(), 5);
        assertEquals(testSofa.gibKissen(), 5);
        assertEquals(testSofa.gibTotalProduktionszeit(), 20);

        System.out.println("Test Sofa ohne Variablenangabe erfolgreich. Defaultinitialisierung und Getters funktionieren.");
    }

    @Test
    /**
     * Ablauf vom Test
     */
    public void testeSofaMitVariablenAngabe() {
        Sofa testSofa = new Sofa(5, 6, 2, 7, 8, 9);

        assertEquals(testSofa.gibHolzeinheiten(), 5);
        assertEquals(testSofa.gibSchrauben(), 6);
        assertEquals(testSofa.gibFarbeinheiten(), 7);
        assertEquals(testSofa.gibKartoneinheiten(), 8);
        assertEquals(testSofa.gibKissen(), 2);
        assertEquals(testSofa.gibTotalProduktionszeit(), 9);

        System.out.println("Test Sofa mit Variablenangabe erfolgreich. Initialisierung mit Selbstdefinierten Variablen funktioniert.");

    }
    
    @Test   
    /**
     * Ablauf vom Test
     */
    public void testeSofaSetters() {
        Sofa testSofa = new Sofa(5, 6, 2, 7, 8, 9);

        testSofa.setzeHolzeinheiten(1);
        assertEquals(testSofa.gibHolzeinheiten(), 1);
        testSofa.setzeSchrauben(2);
        assertEquals(testSofa.gibSchrauben(), 2);
        testSofa.setzeFarbeinheiten(3);
        assertEquals(testSofa.gibFarbeinheiten(), 3);
        testSofa.setzeKartoneinheiten(4);
        assertEquals(testSofa.gibKartoneinheiten(), 4);
        testSofa.setzeKissen(5);
        assertEquals(testSofa.gibKissen(), 5);
        testSofa.setzeTotalProduktionszeit(5);
        assertEquals(testSofa.gibTotalProduktionszeit(), 5);

        System.out.println("Test Setters von der Klasse Sofa erfolgreich.");

    }

}
