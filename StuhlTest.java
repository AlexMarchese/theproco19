

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
     * Der Test überprüft, ob die Erstellung eines Stuhls ohne die Angabe von Variablenwerten funktioniert. 
     * Dies wird überprüft, indem ein neuer Stuhl erstellt wird und die Rückgabe zuerwarteten Standartwerte  
     * mit der Vorgabe aus dem Test verglichen wird. 
     * 
     */
    @Test
    public void testeStuhlKeineVariablenAngabe() {
        Stuhl testStuhl = new Stuhl();

        assertEquals(testStuhl.gibHolzeinheiten(), 2);
        assertEquals(testStuhl.gibSchrauben(), 10);
        assertEquals(testStuhl.gibFarbeinheiten(), 2);
        assertEquals(testStuhl.gibKartoneinheiten(), 1);
        assertEquals(testStuhl.gibTotalProduktionszeit(), 22);

        System.out.println("Test Stuhl ohne Variablenangabe erfolgreich. Defaultinitialisierung und Getters funktionieren.");
    }

    
    /**
     * 
     * Der Test überprüft, ob die Erstellung eines Stuhls mit der Angabe von Variablenwerten funktioniert. 
     * Dies wird überprüft, indem ein neuer Stuhl erstellt wird und die Rückgabe der initialisierten Werte   
     * mit der Vorgabe aus dem Test verglichen wird. 
     * 
     */
    @Test
    public void testeStuhlMitVariablenAngabe() {
        Stuhl testStuhl = new Stuhl(5, 6, 7, 8, 9);

        assertEquals(testStuhl.gibHolzeinheiten(), 5);
        assertEquals(testStuhl.gibSchrauben(), 6);
        assertEquals(testStuhl.gibFarbeinheiten(), 7);
        assertEquals(testStuhl.gibKartoneinheiten(), 8);
        assertEquals(testStuhl.gibTotalProduktionszeit(), 9);

        System.out.println("Test Stuhl mit Variablenangabe erfolgreich. Initialisierung mit Selbstdefinierten Variablen funktioniert.");

    }
    
    
    /**
     * 
     * Test der Setter-Methoden. 
     * Der Test überprüft, ob die Methoden die Werte richtig aktualisieren und diese dann richtig zurückgegeben werden,
     * indem die Rückgabe mit der Vorgabe aus dem Test verglichen wird.
     * 
     */
    @Test
    public void testeStuhlSetters() {
        Stuhl testStuhl = new Stuhl(5, 6, 7, 8, 9);

        testStuhl.setzeHolzeinheiten(1);
        assertEquals(testStuhl.gibHolzeinheiten(), 1);
        testStuhl.setzeSchrauben(2);
        assertEquals(testStuhl.gibSchrauben(), 2);
        testStuhl.setzeFarbeinheiten(3);
        assertEquals(testStuhl.gibFarbeinheiten(), 3);
        testStuhl.setzeKartoneinheiten(4);
        assertEquals(testStuhl.gibKartoneinheiten(), 4);
        testStuhl.setzeTotalProduktionszeit(5);
        assertEquals(testStuhl.gibTotalProduktionszeit(), 5);

        System.out.println("Test Setters von der Klasse Stuhl erfolgreich.");

    }

}
