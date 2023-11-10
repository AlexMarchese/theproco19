

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
        
        System.out.println("Herzlich Willkommen zu der Fabrik GBI Gruppe 19.\n");
        System.out.println("Seit 1954 stellen wir Mobiliar großer Qualität her. Aktuell bieten wir unsere Klassiker Sofa und Stuhl an." );
        

        // System.out.println("\n_______________________________________________________");
        System.out.println("\nEine Bestellung mit 1 Sofa und 1 Stuhl wird automatisch aufgegeben.");

        // Bestellung ohne Eingabe durch den Kunden
        fabrikStart.bestellungAufgeben(1, 1);
        System.out.println(fabrikStart.lagerSituation());

        // Weitere Bestellung
        System.out.println("\nEine weitere Bestellung mit 3 Sofas und 1 Stuhl wird automatisch aufgegeben.");
        fabrikStart.bestellungAufgeben(3, 1);
        System.out.println(fabrikStart.lagerSituation());

        // Weitere Bestellung
        System.out.println("\nEine weitere Bestellung mit 2 Sofas und 1 Stuhl wird automatisch aufgegeben.");
        fabrikStart.bestellungAufgeben(2, 1);
        System.out.println(fabrikStart.lagerSituation());

        // Anzeige für den Aeki Mitarbeitenden
        System.out.println("\n\n_______________________________________________________");
        System.out.println("\nLieber Aeki Mitarbeitender.");
        System.out.println(fabrikStart.bestellungenAusgeben());
        System.out.println(fabrikStart.lagerSituation());
        

        System.out.println("\nProdukte werden erstellt\n");
        System.out.println(fabrikStart.erstelleProdukte());
        System.out.println(fabrikStart.bestellungenAusgeben());
        System.out.println(fabrikStart.lagerSituation());

        // Weitere Bestellung
        System.out.println("\nEine weitere Bestellung mit 3 Sofas und 1 Stuhl wird automatisch aufgegeben.");
        fabrikStart.bestellungAufgeben(3, 1);
        System.out.println(fabrikStart.erstelleProdukte());
        System.out.println(fabrikStart.lagerSituation());

        // Tag vergeht
        fabrikStart.naechsterTag();
        System.out.println(fabrikStart.lagerSituation());
        
    }

}
