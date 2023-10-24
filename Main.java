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
        
        Fabrik fabrikStart = new Fabrik();

        // Bestellung Eingabe durch den Kunden
        Scanner myObj = new Scanner(System.in);
        int anzahlStuehle;
        int anzahlSofas;
        
        System.out.println("Herzlich Willkommen zu der Fabrik GBI Gruppe 19.\n");
        System.out.println("Seit 1954 stellen wir Mobiliar großer Qualität her." +
                            " Aktuell haben Sie die Möglichkeit zwischen unseren Klassikern Sofa und Stuhl zu wählen." +
                            " Hier können Sie direkt eine oder mehrere Produkte wählen. Tragen Sie einfach direkt die gewünschte Anzahl ein.\n" +
                            "N.B. Es wird eine ganze Zahl erwartet.\n");

        System.out.print("Anzahl Stühle: ");
        anzahlStuehle = myObj.nextInt();
        System.out.print("Anzahl Sofas: ");
        anzahlSofas = myObj.nextInt();
        // Theoretisch kann man die Eingabe des Kundens überprüfen. Wir haben aber schon eine Fehler der bei Negativen Werten aufgerufen wird.
        // Bei einem typ der nicht anders als ein int ist, gibt es die Java Standardmeldung. Dadurch wir auf weitere Einschränkungen verzichtet.

        myObj.close();

        fabrikStart.bestellungAufgeben(anzahlSofas, anzahlStuehle);

        System.out.println("Ihre Bestellung mit " + anzahlSofas + " Sofas und " + 
                            anzahlStuehle + " wurde erfasst. Vielen Dank!\n\n");

        // Bestellung ohne Eingabe durch den Kunden
        fabrikStart.bestellungAufgeben(1, 1);

        // Anzeige für den Aeki Mitarbeitenden
        System.out.println("Lieber Aeki Mitarbeitender.");
        System.out.println(fabrikStart.bestellungenAusgeben());
        
    }

}
