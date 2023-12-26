// import java.util.Scanner; // Wird benötigt, um eine Eingabe vom Terminal zu bekommen
// import java.util.regex.Pattern; // Wird benutzt, um Eingabewerte zu überprüfen

import javax.swing.Timer;

import javax.swing.SwingUtilities;

/**
 * 
 * Die Klasse Main ist der Einstiegspunkt in das Programm und in der Main Methode wird das Programm ausgeführt.
 * Hier können aufgefülltBestellungen mit individuellen Anzahlen an Stühlen und Sofas aufgegeben werden oder es 
 * wird eine vordefinierte Bestellung ausgeführt. 
 * 
 * 
 * @author  GBI Gruppe 19
 * @version 2.0
 */
public class Main
{
    private Fabrik fabrikStart;
    private Lager lager;

    public Main() {
        // Fabrik, Lager und Manager initialisieren
        this.fabrikStart = new Fabrik();
        this.fabrikStart.erstelleLager(1_000, 5_000, 1_000, 1_000, 100, 1_000, 5_000, 1_000, 1_000, 100);
        this.fabrikStart.erstelleProduktions_Manager();
        this.fabrikStart.erstelleMurmeltier(); // Das Murmeltier simuliert einen Tagesablauf und ist in der Klasse Fabrik zuhause.

        this.lager = this.fabrikStart.gibLager();
    }

    /**
     * Methode zur Ausgabe der Fabrik.
     * 
     * @return  fabrikStart   Fabrik.
     */
    public Fabrik gibFabrik(){
        return this.fabrikStart;
    }

    /**
     * Methode zur Ausgabe der Lagers der Fabrik.
     * 
     * @return  lager   Lager der Fabrik.
     */
    public Lager gibLager(){
        return this.lager;
    }

    /**
     * Die main-Methode startet die Anwendung.
     * Hier wird ein GUI erstellt und sichtbar gemacht.
     * Ein Timer wird verwendet, um die GUI-Fenster in regelmäßigen Abständen zu aktualisieren.
     * Der Timer ruft die aktualisiereFenster() Methode des GUI-Objekts alle 1 Millisekunde auf.
     */   
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
                    GUI gui = new GUI();
                    gui.setVisible(false);

                    Timer timer = new Timer(1, e -> gui.aktualisiereFenster());
                    timer.setRepeats(true); // true, damit sich das wiederholt
                    timer.start();
            });
    }


}
//     public String befehle(String kommando){
//         // Main main = new Main();

//         // Erster Teil -> Es wird gezeigt, wie das eingehen von 1 Bestellung funktioniert.
            
//         // // 2 Sekunden auf die Initialisierung warten. Führt sonst zu Exceptions später im Prozess
//         // try{
//         //     Thread.sleep(2000);
//         // }
//         // catch(InterruptedException ie)
//         // {
//         //     ie.printStackTrace();
//         // }
         
//         // System.out.println(this.fabrikStart.lagerSituation());
//         // System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
        
        
//         // System.out.println("Eine Bestellung mit 1 Sofa und 1 Stuhl wird aufgegeben.");
//         // this.fabrikStart.bestellungAufgeben(1, 1);

//         // // Kurze 24 Sekunden Pause, damit gezeigt werden kann wie die Bestellungen erstellt werden
//         // try
//         // {
//         //      Thread.sleep(24_000);
//         //  }
//         //  catch (InterruptedException ie)
//         //  {
//         //      ie.printStackTrace();
//         //  }

        
//         // try (// Zweiter Teil -> Der Nutzer darf entscheiden
//         // Scanner myObj = new Scanner(System.in)) {
//             // String kommando; // Für das Kommando im Terminal durch den Nutzer

//             // System.out.print("\n\nLieber Nutzer, Willkommen zum Testen unserer AEKI Fabrik der Gruppe 19. Ja genau, testen Sie gerne an unserer Funktionalität und überzeugen sie sich selbst ;).");
//             // System.out.println("\nIhnen stehen 3 verschiedene Kommandos zu Verfügung:");
//             // System.out.println("1. 'situat' - Wir zeigen Ihnen die Situation im Lager unserer Fabrik");
//             // System.out.println("2. 'best' 'a' 'b' - Gibt eine Bestellung auf. Geben Sie dabei die Anzahl an Sofas und Stühlen mit einem Abstand dazwischen an. Bsp:'best 3 2' = 3 Sofas und 2 Stühle.");
//             // System.out.println("3. 'ende' - Sie sind zufrieden und wollen diese privilegierte Nutzersicht verlassen.\n");
//             // System.out.println("N.B. Sie dürfen jederzeit ein Kommando eingeben. Wenn Sie sich vertippen, passiert nichts und dürfen das Kommando erneut eingeben.");
//             // System.out.println("Gerne dürfen sie auch probieren unrealistische Werte einzugeben und schauen was passiert. Viel Spaß!");

            

//                 // TO DO ALEX - remove trims and to lower case and all unnecessary input mgm things

//                     // kommando = myObj.nextLine();
//                     // kommando = myObj.nextLine();

//                     // // Überprüft, ob der Nutzer den Loop verlassen möchte
//                     // if (kommando.trim().equalsIgnoreCase("ende")) {
//                     //     System.out.println("Es wurde entschieden die Nutzeransicht zu verlassen. Das Programm wird geschlossen. Wir danken für ihren Besuch und bis zum nächsten mal in der AEKI Fabrik!");
//                     //     // break; // Verlässt den Loop wenn der Nutzer "ende" eingibt
//                     // }

//                     // Bestellung aufgeben
//                     if (kommando.trim().toLowerCase().contains("best")){

//                         try {
//                             String nums = kommando.split("best ")[1].trim();                 
                            
//                             // Stellt sicher, dass genau zwei Zahlen eingegeben werden. Nicht drei wovon nur die ersten beiden genommen werden oder ähnliches
//                             if(Pattern.compile("\\d+ \\d+").matcher(nums).matches()){
//                                 String[] values = nums.split(" "); // Unterteilt den String in 2 Werte (der erste ist die Anz Sofas und der zweite die Anz Stühle)
//                                 // System.out.println(this.fabrikStart.bestellungAufgeben(Integer.parseInt(values[0]), Integer.parseInt(values[1])));
//                                 return this.fabrikStart.bestellungAufgeben(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
//                             } else {throw new IllegalArgumentException("Es sollten genau 2 Zahlen sein");}
                            
//                         } catch (IllegalArgumentException e) { // Stellt sicher, dass der Nutzer keine negavtie oder basierend auf Lager nicht produzierbaren Bestellungsmengen eingibt
                    
//                             return "\n! Bitte stellen sie sicher, dass sie weder negative noch basierend auf dem Lager zu große Bestellungsmengen eingeben und dass sie nach dem Kommando 'best' genau zwei ganze Zahlen eintippen!\n";
//                             // continue;
//                         } catch (ArrayIndexOutOfBoundsException e) { // Stellt sicher, dass der Nutzer zwei Werte bei der Bestellung eingibt
                    
//                             return "\n! Bitte stellen sie sicher, dass sie nach dem Kommando 'best' genau zwei ganze Zahlen eingeben!\n";
//                             // continue;
//                             }
//                         }

//                     // Lagersituation ausgeben
//                     else if (kommando.trim().equalsIgnoreCase("situat")){
//                         // System.out.println(this.fabrikStart.lagerSituation());
//                         return this.fabrikStart.lagerSituation();
//                     }

//                     // Nichterkanntes Kommando
//                     else {
//                         // System.out.println("Kommando nicht erkannt. Bitte erneut versuchen.");
//                         return "kommando nicht erkannt. Bitte erneut versuchen.";
//                         // continue;
//                     }
                    
                
//         }
//     }

//         // Alle Prozesse werden beendet
//     //     try
//     //     {
//     //         Thread.sleep(10);
//     //     }
//     //     catch (InterruptedException ie)
//     //     {
//     //         ie.printStackTrace();
//     //     }

//     //     System.out.println("Alle Prozesse wurden beendet.");

//     //     System.exit(0);
    
//     // }
    
// //     public static void main(String[] args) {

// //         Main main = new Main();

// //         // Erster Teil -> Es wird gezeigt, wie das eingehen von 1 Bestellung funktioniert.
            
// //         // 2 Sekunden auf die Initialisierung warten. Führt sonst zu Exceptions später im Prozess
// //         try{
// //             Thread.sleep(2000);
// //         }
// //         catch(InterruptedException ie)
// //         {
// //             ie.printStackTrace();
// //         }
         
// //         System.out.println(main.fabrikStart.lagerSituation());
// //         System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
        
        
// //         System.out.println("Eine Bestellung mit 1 Sofa und 1 Stuhl wird aufgegeben.");
// //         main.fabrikStart.bestellungAufgeben(1, 1);

// //         // Kurze 24 Sekunden Pause, damit gezeigt werden kann wie die Bestellungen erstellt werden
// //         try
// //         {
// //              Thread.sleep(24_000);
// //          }
// //          catch (InterruptedException ie)
// //          {
// //              ie.printStackTrace();
// //          }

        
// //         try (// Zweiter Teil -> Der Nutzer darf entscheiden
// //         Scanner myObj = new Scanner(System.in)) {
// //             String kommando; // Für das Kommando im Terminal durch den Nutzer

// //             System.out.print("\n\nLieber Nutzer, Willkommen zum Testen unserer AEKI Fabrik der Gruppe 19. Ja genau, testen Sie gerne an unserer Funktionalität und überzeugen sie sich selbst ;).");
// //             System.out.println("\nIhnen stehen 3 verschiedene Kommandos zu Verfügung:");
// //             System.out.println("1. 'situat' - Wir zeigen Ihnen die Situation im Lager unserer Fabrik");
// //             System.out.println("2. 'best' 'a' 'b' - Gibt eine Bestellung auf. Geben Sie dabei die Anzahl an Sofas und Stühlen mit einem Abstand dazwischen an. Bsp:'best 3 2' = 3 Sofas und 2 Stühle.");
// //             System.out.println("3. 'ende' - Sie sind zufrieden und wollen diese privilegierte Nutzersicht verlassen.\n");
// //             System.out.println("N.B. Sie dürfen jederzeit ein Kommando eingeben. Wenn Sie sich vertippen, passiert nichts und dürfen das Kommando erneut eingeben.");
// //             System.out.println("Gerne dürfen sie auch probieren unrealistische Werte einzugeben und schauen was passiert. Viel Spaß!");

// //             while (true) {

                

// //                     kommando = myObj.nextLine();

// //                     // Überprüft, ob der Nutzer den Loop verlassen möchte
// //                     if (kommando.trim().equalsIgnoreCase("ende")) {
// //                         System.out.println("Es wurde entschieden die Nutzeransicht zu verlassen. Das Programm wird geschlossen. Wir danken für ihren Besuch und bis zum nächsten mal in der AEKI Fabrik!");
// //                         break; // Verlässt den Loop wenn der Nutzer "ende" eingibt
// //                     }

// //                     // Bestellung aufgeben
// //                     else if (kommando.trim().toLowerCase().contains("best")){

// //                         try {
// //                             String nums = kommando.split("best ")[1].trim();                 
                            
// //                             // Stellt sicher, dass genau zwei Zahlen eingegeben werden. Nicht drei wovon nur die ersten beiden genommen werden oder ähnliches
// //                             if(Pattern.compile("\\d+ \\d+").matcher(nums).matches()){
// //                                 String[] values = nums.split(" "); // Unterteilt den String in 2 Werte (der erste ist die Anz Sofas und der zweite die Anz Stühle)
// //                                 System.out.println(main.fabrikStart.bestellungAufgeben(Integer.parseInt(values[0]), Integer.parseInt(values[1])));
// //                             } else {throw new IllegalArgumentException("Es sollten genau 2 Zahlen sein");}
                            
// //                         } catch (IllegalArgumentException e) { // Stellt sicher, dass der Nutzer keine negavtie oder basierend auf Lager nicht produzierbaren Bestellungsmengen eingibt
                    
// //                             System.out.println("\n! Bitte stellen sie sicher, dass sie weder negative noch basierend auf dem Lager zu große Bestellungsmengen eingeben und dass sie nach dem Kommando 'best' genau zwei ganze Zahlen eintippen!\n");
// //                             continue;
// //                         } catch (ArrayIndexOutOfBoundsException e) { // Stellt sicher, dass der Nutzer zwei Werte bei der Bestellung eingibt
                    
// //                             System.out.println("\n! Bitte stellen sie sicher, dass sie nach dem Kommando 'best' genau zwei ganze Zahlen eingeben!\n");
// //                             continue;
// //                             }
// //                         }

// //                     // Lagersituation ausgeben
// //                     else if (kommando.trim().equalsIgnoreCase("situat")){
// //                         System.out.println(main.fabrikStart.lagerSituation());
// //                     }

// //                     // Nichterkanntes Kommando
// //                     else {
// //                         System.out.println("Kommando nicht erkannt. Bitte erneut versuchen.");
// //                         continue;
// //                     }
                    
// //                 }
// //         }

// //         // Alle Prozesse werden beendet
// //         try
// //         {
// //             Thread.sleep(10);
// //         }
// //         catch (InterruptedException ie)
// //         {
// //             ie.printStackTrace();
// //         }

// //         System.out.println("Alle Prozesse wurden beendet.");

// //         System.exit(0);
    

// // }
// // }
