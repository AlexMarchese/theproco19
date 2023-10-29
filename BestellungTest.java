
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testklasse BestellungTest, um die Methoden der Klasse "Bestellung" zu testen. 
 *
 * @author  GBI Gruppe 19
 * @version 1.0
 */

public class BestellungTest {

    String nameTestClasse = "BestellungTest"; // Name der Testklasse
    
    /**
     * Konstruktor von BestellungTest
     */
    public BestellungTest() {
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

    
    /**
     * Der Test überprüft, ob die Erstellung einer Bestellung funktioniert. 
     * Dies wird überprüft, indem eine neue Bestellung erstellt wird und die initialisierten Werte 
     * mit der Vorgabe aus dem Test verglichen werden. 
     * 
     */
    @Test
    public void testeBestellung() {

        // Instanzierung einer Bestellung
        Bestellung testBestellung = new Bestellung(5, 6, 2);

        assertEquals(testBestellung.gibAnzahlSofas(), 5);
        assertEquals(testBestellung.gibAnzahlStuehle(), 6);
        assertEquals(testBestellung.gibBestellungsNr(), 2);

        // Testen von automatisch initialisierten Werten
        assertEquals(testBestellung.gibBestellBestaetigung(), false);
        assertEquals(testBestellung.gibBeschaffungszeit(), 1);

        // Überprüfung, dass die Arraylist die Produkte enthält
        assertEquals(testBestellung.gibBestellteProdukte().size(), 11);

        // Kontrolle, dass es genau fünf Sofas und Sechs Stühle sind
        int anzahlStuehle = 0;
        int anzahlSofas = 0;

        for (Object produkt : testBestellung.gibBestellteProdukte()) {
            if (produkt instanceof Stuhl) {
                anzahlStuehle++;
            } else if (produkt instanceof Sofa) {
                anzahlSofas++;
            }
        }

        assertEquals(6, anzahlStuehle);
        assertEquals(5, anzahlSofas);

        System.out.println("Test Bestellung mit Variablenangabe erfolgreich. Initialisierung mit Selbstdefinierten Variablen und Standardwerten funktioniert.");

    }

    
    /**
     * Test der Methode "bestellungBestaetige()". 
     * Der Test überprüft, ob die Methode die erwartete Bestellbestätigung zurück gibt, 
     * indem eine Bestellung erstellt wird und die Rückgabe mit der Vorgabe aus dem Test verglichen wird. 
     */
    @Test
    public void testeBestellungBestaetigen() {

        Bestellung testBestellung = new Bestellung(5, 6, 2);
        assertEquals("Bestellung (Nr. 2) mit 5 Sofas und 6 Stühlen ist bestätigt.", testBestellung.bestellungBestaetigen());

        System.out.println("Bestellbestätigung wird wie erwartet Ausgegeben");
        
    }
    
    
    /**
     * Test der Methode "ueberpruefeBestellbestaetigung()". 
     * Der Test überprüft, ob die Methode für eine nicht-bestätigte Bestellung 
     * und für eine bestätigte Bestellung den richtigen Text zurück gibt, 
     * indem die Rückgabe mit der Vorgabe aus dem Test verglichen wird. 
     * 
     */
    @Test
    public void testeUeberpruefeBestellbestaetigung() {

        Bestellung testBestellung = new Bestellung(5, 6, 2);
        // Bei der Initialisierung ist bestellBestaetigung false
        assertEquals("Die Bestellung mit der Nr. 2 ist nicht bestätigt.", testBestellung.ueberpruefeBestellbestaetigung());

        testBestellung.setzeBestellBestaetigung(true);
        assertEquals("Die Bestellung mit der Nr. 2 ist bestätigt.", testBestellung.ueberpruefeBestellbestaetigung());

        System.out.println("Die Methode UeberpruefeBestellbestaetigung funktioniert.");
        
    }


}
