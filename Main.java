import java.util.Scanner; // Wird benötigt, um eine Eingabe vom Terminal zu bekommen

/**
 * Main Methode.
 *
 * @author  GBI Gruppe 19
 * @version 1
 */
public class Main
{
    public static void main(String[] args) {

        // Bestellung Eingabe durch den Kunden
        Scanner myObj = new Scanner(System.in);
        int anzahlStuehle;
        int anzahlSofas;
        
        System.out.println("Herzlich Willkommen zu der Fabrik GBI Gruppe 19.");
        System.out.println("Seit 1954 stellen wir Mobiliar großer Qualität her." +
                            " Aktuell haben Sie die Möglichkeit zwischen unseren Klassikern Sofa und Stuhl zu wählen." +
                            " Hier können Sie direkt eine oder mehrere Produkte wählen. Tragen Sie einfach direkt die gewünschte Anzahl ein.\n");

        anzahlSofas = 3;
        anzahlStuehle = 4;

        Fabrik farbikTest = new Fabrik();
        farbikTest.bestellungAufgeben(anzahlSofas, anzahlStuehle);

        System.out.println("Ihre Bestellung mit " + anzahlSofas + " Sofas und " + 
                            anzahlStuehle + " wurde erfasst. Vielen Dank!\n\n");

        // Bestellung ohne Eingabe durch den Kunden
        farbikTest.bestellungAufgeben(5, 2);

        // Anzeige für den Produktionsmanager / Aeki Mitarbeiter
        System.out.println("Lieber Aeki Mitarbeitender.");
        System.out.println(farbikTest.bestellungenAusgeben());
        
    }

}
