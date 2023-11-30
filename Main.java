import java.util.Scanner; // Wird benötigt, um eine Eingabe vom Terminal zu bekommen

/**
 * 
 * Die Klasse Main ist der Einstiegspunkt in das Programm und in der Main Methode wird das Programm ausgeführt.
 * Hier können Bestellungen mit individuellen Anzahlen an Stühlen und Sofas aufgegeben werden oder es 
 * wird eine vordefinierte Bestellung ausgeführt. 
 * 
 * 
 * @author  GBI Gruppe 19
 * @version 2.0
 */
public class Main
{
    // private void synchedCommandExec(consoleLock, myObj) {  //need for later
    //     synchronized(consoleLock) {
    //         System.out.print("Kommando: ");
    //         String kommando = myObj.nextLine();
    //         // run comman 
    //     }
    // }
    public static void main(String[] args) { //original one

        // public static final consoleLock = new Object(); //need for later
        
        // Fabrik fabrikStart = new Fabrik();
        
        // fabrikStart.erstelleLager(100, 100, 100, 100, 100, 100, 100, 100, 100, 100);
        
    //     System.out.println("Herzlich Willkommen zu der Fabrik GBI Gruppe 19.\n");
    //     System.out.println("Seit 1954 stellen wir Mobiliar bester Qualität her. Aktuell bieten wir unsere Klassiker Sofa und Stuhl an." );
        

    //     // System.out.println("\n_______________________________________________________");
    //     System.out.println("\nEine Bestellung mit 1 Sofa und 1 Stuhl wird automatisch aufgegeben.");

    //     // Bestellung ohne Eingabe durch den Kunden
    //     System.out.println(fabrikStart.bestellungAufgeben(1, 1));

    //     // Weitere Bestellung
    //     System.out.println("\nEine weitere Bestellung mit 7 Sofas und 1 Stuhl wird automatisch aufgegeben.");
    //     System.out.println(fabrikStart.bestellungAufgeben(7, 1));

    //     // Weitere Bestellung
    //     System.out.println("\nEine weitere Bestellung mit 16 Sofas und 1 Stuhl wird automatisch aufgegeben.");
    //     System.out.println(fabrikStart.bestellungAufgeben(16, 1));

    //     // Anzeige für den Aeki Mitarbeitenden
    //     System.out.println("\n\n_______________________________________________________");
    //     System.out.println("\nLieber Aeki Mitarbeitender.");
    //     System.out.println(fabrikStart.bestellungenAusgeben());
        

    //     System.out.println("\nProdukte werden erstellt\n");
    //     System.out.println(fabrikStart.erstelleProdukte());
    //     System.out.println(fabrikStart.bestellungenAusgeben());
    //     System.out.println(fabrikStart.lagerSituation());

    //     // Weitere Bestellung
    //     System.out.println("\nEine weitere Bestellung mit 3 Sofas und 1 Stuhl wird automatisch aufgegeben.");
    //     System.out.println(fabrikStart.bestellungAufgeben(3, 1));
    //     System.out.println("\nProdukte werden erstellt\n");
    //     System.out.println(fabrikStart.erstelleProdukte());
    //     System.out.println(fabrikStart.lagerSituation());

    //     // 2 Tage vergehen
    //     System.out.println("\nNach zwei Tagen.");
    //     fabrikStart.nachZweiTagen();
    //     System.out.println(fabrikStart.lagerSituation());

       
    /// Part 1
        
        Fabrik fabrikStart = new Fabrik();
        
        fabrikStart.erstelleLager(100, 100, 100, 100, 100, 100, 100, 100, 100, 100);

        System.out.println(fabrikStart.lagerSituation());

        Scanner myObj = new Scanner(System.in);

        String kommando;

        while (true) {

            System.out.print("Kommando:\n");
            kommando = myObj.nextLine();

            
            // synchedCommandExec(); //need for later

            // Überprüft, ob der Nutzer den Loop verlassen möchte
            if (kommando.trim().equalsIgnoreCase("exit")) {
                break; // Verlässt den Loop wenn der Nutzer "exit" eingibt
            }

            // Bestellung aufgeben
            else if (kommando.trim().equalsIgnoreCase("best")){
                System.out.println(fabrikStart.bestellungAufgeben(7, 1));
            }

            // Produkte erstellen
            //else if (kommando.trim().equalsIgnoreCase("erst")){
            //    System.out.println(fabrikStart.erstelleProdukte());
            //}

            // Lagersituation ausgeben
            else if (kommando.trim().equalsIgnoreCase("situat")){
                System.out.println(fabrikStart.lagerSituation());
            }

            // Am Ende eines Tages
            else if (kommando.trim().equalsIgnoreCase("ende")){
                //IF LOOP ob sich eine Best lohnt
                System.out.println(fabrikStart.lagerAuffuellen());
                // fabrikStart.lagerAuffuellen();
            }

            else {continue;}
        }

            
            
    //         try {
    //             // Sleep for 5 seconds (5000 milliseconds)
    //             Thread.sleep(1000);
    //         } catch (InterruptedException e) {
    //             // Handle the exception if needed
    //             e.printStackTrace();
    //         }
    
            
    //     }
        
    //     myObj.close();



    // public static void main(String[] args) { //just a copy

        // // Test Best
        // Bestellung testBest = new Bestellung(3, 2, 0);
       
        // // Test Lager
        // Lager testLager = new Lager(100, 100, 100, 100, 100, 100, 100, 100, 100, 100);

        // // Test Produktions_Manager
        // Produktions_Manager testProduktions_Manager = new Produktions_Manager(testLager);

        // testProduktions_Manager.zuVerabreitendeBestellungen.add(testBest);
        // System.out.println(testProduktions_Manager.zuVerabreitendeBestellungen);
        // System.out.println(testProduktions_Manager.bestellungInProduktion);

        // testProduktions_Manager.fuegeZuVerarbeitendeBestellungenHinzu(testBest);
        // System.out.println(testProduktions_Manager.zuVerabreitendeBestellungen);
        // System.out.println(testProduktions_Manager.bestellungInProduktion);

        // Roboter testVerpackungs = new Verpackungs_Roboter();
        // Roboter testMontage = new Montage_Roboter();
        // // testVerpackungs.warteschlange.add(new Stuhl());
        // // testVerpackungs.warteschlange.add(new Stuhl());
        // // testVerpackungs.warteschlange.add(new Sofa());

        // System.out.println(testVerpackungs.gibName());
        // System.out.println(testMontage.gibName());
        // // System.out.println(testVerpackungs.testMethod());
        // testVerpackungs.produziereProdukt(new Sofa());
        // testVerpackungs.produziereProdukt(new Stuhl());
        // testMontage.produziereProdukt(new Stuhl());

    }


}
