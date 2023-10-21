
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testklasse ProduktTest, um den Sofa und dessen Methoden zu testen
 *
 * @author  GBI Gruppe 19
 * @version 1
 */

public class BestellungTest {

    String nameTestClasse = "BestellungTest"; // Name der Testklasse
    
    /**
     * Konstruktor von BestellungTest
     */
    public BestellungTest() {
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

    @Test
    /**
     * Ablauf vom Test.
     * 
     * Dieser Test beweist, dass ein Fehler ausgegeben wird, wenn eine negative Zahl eingegeben werden sollte
     */
    public void testeBestellungEingabeNegativeWerte() {

        try {
            assertThrows(IllegalArgumentException.class, () -> new Bestellung(-2, 3, 123));
        } catch (AssertionError e) {
            // This block will be executed if the assertion fails (i.e., exception is not thrown)
            fail("Sollte eine 'IllegalArgumentException' zurückgeben, aber es ist ein Fehler aufgetreten.");
        }
    }

    @Test
    /**
     * Ablauf vom Test
     */
    public void testeBestellungBestaetigen() {

        Bestellung testBestellung = new Bestellung(5, 6, 2);
        System.out.println(testBestellung.bestellungBestaetigen());
        assertEquals("Bestellung Nr. 2 bestätigt.", testBestellung.bestellungBestaetigen());
        

    }

}
