

// import static org.junit.jupiter.api.Assertions.*;
// import org.junit.jupiter.api.AfterEach;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

// /**
//  * Testklasse ProduktTest, um die Methoden der Klasse "Produkt" zu testen.
//  *
//  * @author  GBI Gruppe 19
//  * @version 1.0
//  */

// public class ProduktTest {

//     String nameTestClasse = "ProduktTest"; // Name der Testklasse
    
//     /**
//      * Konstruktor von ProduktTest
//      */
//     public ProduktTest() {
//     }

//     /**
//      * Anweisungen vor jedem Testlauf
//      */
//     @BeforeEach
//     public void setUp() {
//         System.out.println("Testlauf " + nameTestClasse + " Start");
//         System.out.println();
//     }

//     /**
//      * Anweisungen nach jedem Testlauf
//      */
//     @AfterEach
//     public void tearDown() {
//         System.out.println();
//         System.out.println("Testlauf " + nameTestClasse + " Ende");
//         System.out.println("------------------------");
//     }
    
//     /**
//      * 
//      * Der Test überprüft, ob die Erstellung eines Produkts funktioniert. 
//      * Dies wird überprüft, indem ein neues Produkt erstellt wird und die initialisierten Werte 
//      * mit der Vorgabe aus dem Test vergliechen werden. 
//      * 
//      */
//     @Test
//     public void testeProduktMitVariablenAngabe() {
//         Produkt testProdukt = new Produkt(5, 6, 7, 8, 9);

//         assertEquals(testProdukt.gibHolzeinheiten(), 5);
//         assertEquals(testProdukt.gibSchrauben(), 6);
//         assertEquals(testProdukt.gibFarbeinheiten(), 7);
//         assertEquals(testProdukt.gibKartoneinheiten(), 8);
//         assertEquals(testProdukt.gibZustand(), 0);
//         assertEquals(testProdukt.gibTotalProduktionszeit(), 9);

//         System.out.println("Test Produkt mit Variablenangabe erfolgreich. Initialisierung mit Selbstdefinierten Variablen funktioniert.");

//     }
    
     
//     /**
//      * 
//      * Test der Setter-Methoden. 
//      * Der Test überprüft, ob die Methoden die Werte richtig aktualisieren und diese dann richtig zurückgegeben werden,
//      * indem die Rückgabe mit der Vorgabe aus dem Test verglichen wird.
//      * 
//      */
//     @Test  
//     public void testeProduktSetters() {
//         Produkt testProdukt = new Produkt(1, 2, 3, 4, 5);

//         testProdukt.setzeHolzeinheiten(1);
//         assertEquals(testProdukt.gibHolzeinheiten(), 1);
//         testProdukt.setzeSchrauben(2);
//         assertEquals(testProdukt.gibSchrauben(), 2);
//         testProdukt.setzeFarbeinheiten(3);
//         assertEquals(testProdukt.gibFarbeinheiten(), 3);
//         testProdukt.setzeKartoneinheiten(4);
//         assertEquals(testProdukt.gibKartoneinheiten(), 4);
//         testProdukt.setzeZustand(5);
//         assertEquals(testProdukt.gibZustand(), 5);
//         testProdukt.setzeTotalProduktionszeit(5);
//         assertEquals(testProdukt.gibTotalProduktionszeit(), 5);

//         System.out.println("Test Setters von der Klasse Sofa erfolgreich.");

//     }

// }
