import java.util.Scanner; // Wird benötigt, um eine Eingabe vom Terminal zu bekommen

/**
 * 
 * Die Klasse Main ist der Einstiegspunkt in das Programm und in der Main Methode wird das Programm ausgeführt.
 * Hier können Bestellungen mit individuellen Anzahlen an Stühlen und Sofas aufgegeben werden oder es 
 * wird eine vordefinierte Bestellung ausgeführt. 
 * 
 * 
 * @author  GBI Gruppe 19
 * @version 1.0
 */
public class Main
{
    public static void main(String[] args) {
        
        Fabrik fabrikStart = new Fabrik();
        
        fabrikStart.erstelleLager(100, 100, 100, 100, 100, 100, 100, 100, 100, 100);

        // Bestellung Eingabe durch den Kunden
        Scanner myObj = new Scanner(System.in);
        int anzahlStuehle;
        int anzahlSofas;
        
        System.out.println("Herzlich Willkommen zu der Fabrik GBI Gruppe 19.\n");
        System.out.println("Seit 1954 stellen wir Mobiliar großer Qualität her." +
                            " Aktuell haben Sie die Möglichkeit zwischen unseren Klassikern Sofa und Stuhl zu wählen." +
                            " Hier können Sie direkt eine oder mehrere Produkte wählen. Tragen Sie einfach direkt die gewünschte Anzahl ein.\n" +
                            "N.B. Es wird eine ganze Zahl erwartet.\n");



        //TO BE REMOVED
        anzahlSofas = 2;
        anzahlStuehle = 2;
    


        // System.out.print("Anzahl Stühle: ");
        // anzahlStuehle = myObj.nextInt();
        // System.out.print("Anzahl Sofas: ");
        // anzahlSofas = myObj.nextInt();

        // Theoretisch kann man die Eingabe des Kundens überprüfen. Wir haben aber schon eine Fehler der bei Negativen Werten aufgerufen wird.
        // Bei einem typ der nicht anders als ein int ist, gibt es die Java Standardmeldung. Dadurch wir auf weitere Einschränkungen verzichtet.

        myObj.close();

        fabrikStart.bestellungAufgeben(anzahlSofas, anzahlStuehle);

        // Letze Bestellung abrufen
        Bestellung letzeBest = fabrikStart.gibBestellungsList().get(fabrikStart.gibBestellungsList().size() - 1);

        System.out.print("\nIhre " + letzeBest.bestellungBestaetigen() + " Vielen Dank!");
        System.out.println("\n_______________________________________________________");
        System.out.println("\nEine Bestellung mit 1 Sofa und 1 Stuhl wird automatisch aufgegeben.");

        // Bestellung ohne Eingabe durch den Kunden
        fabrikStart.bestellungAufgeben(1, 1);

        // Anzeige für den Aeki Mitarbeitenden
        System.out.println("\n\n_______________________________________________________");
        System.out.println("\nLieber Aeki Mitarbeitender.");
        System.out.println(fabrikStart.bestellungenAusgeben());
        
    }

}
