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
    
    public static void main(String[] args) {

        // Erster Teil -> Es wird gezeigt, wie das eingehen von 2 Bestellungen funktioniert.
        
        Fabrik fabrikStart = new Fabrik();
        fabrikStart.erstelleLager(1_000, 5_000, 1_000, 1_000, 100, 1_000, 5_000, 1_000, 1_000, 100);
        fabrikStart.erstelleProduktions_Manager();
        fabrikStart.erstelleMurmeltier(); // Das Murmeltier simuliert einen Tagesablauf und ist in der Klasse Fabrik zuhause.
        System.out.println(fabrikStart.lagerSituation());
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");

        // TaeglichGruesstDasMurmeltier tagAblauf = new TaeglichGruesstDasMurmeltier(fabrikStart); - Wird in fabrik gemacht (jede Fabrik braucht ihr eigenes Murmeltier)
        // tagAblauf.start(); - Wird in fabrik gemacht (jede Fabrik braucht ihr eigenes Murmeltier)
        
        try
        {
        Thread.sleep(2_000);
        }
        catch (InterruptedException ie)
        {
            ie.printStackTrace();
        }
        
        System.out.println("Eine Bestellung mit 2 Sofas und 1 Stuhl wird aufgegeben.");
        fabrikStart.bestellungAufgeben(2, 1);
        System.out.println("Eine weitere Bestellung mit 2 Sofas und 3 Stühlen wird aufgegeben.");
        fabrikStart.bestellungAufgeben(2, 3);

        // Kurze 30 Sekunden Pause, damit gezeigt werden kann wie die Bestellungen erstellt werden
        try
        {
            Thread.sleep(30_000);
        }
        catch (InterruptedException ie)
        {
            ie.printStackTrace();
        }

        
        // Zweiter Teil -> Der Nutzer darf entscheiden
        Scanner myObj = new Scanner(System.in);

        String kommando; // Für das Kommando im Terminal durch den Nutzer

        System.out.print("\n\nLieber Nutzer, Willkommen zum Testen unserer AEKI Fabrik der Gruppe 19. Ja genau, zweifeln Sie gerne an unserer Funktionalität und sehen sie es selbst ;).");
        System.out.println("\nIhnen stehen 3 verschiedene Kommandos zu Verfügung:");
        System.out.println("1. 'situat' - Wir zeigen Ihnen die Situation im Lager unserer Fabrik");
        System.out.println("2. 'best' 'a' 'b' - Gibt eine Bestellung auf. Geben Sie dabei die Anzahl an Sofas und Stühlen mit einem Abstand dazwischen an. Bsp:'best 3 2' = 3 Stühle und 2 Sofas.");
        System.out.println("3. 'ende' - Sie sind zufrieden und wollen diese privilegierte Nutzersicht verlassen.\n");
        System.out.println("N.B. Sie dürfen jederzeit ein Kommando eingeben. Wenn Sie sich vertippen, passiert nichts und dürfen das Kommando erneut eingeben. Viel Spaß!");

        while (true) {

            kommando = myObj.nextLine();

            // Überprüft, ob der Nutzer den Loop verlassen möchte
            if (kommando.trim().equalsIgnoreCase("ende")) {
                System.out.println("Es wurde entschieden die Nutzersicht zu verlassen. Das Programm wird geschlossen.");
                break; // Verlässt den Loop wenn der Nutzer "ende" eingibt
            }

            // Bestellung aufgeben
            else if (kommando.trim().toLowerCase().contains("best")){
                 
                String nums = kommando.split("best ")[1];                 
                String[] values = nums.split(" "); // Unterteilt der String in 2 Werte (der erste ist die Anz Sofas und der zweite die Anz Stühle)

                System.out.println("Nums " + Integer.parseInt(values[0]) + " " + Integer.parseInt(values[1]));
                System.out.println(fabrikStart.bestellungAufgeben(Integer.parseInt(values[0]), Integer.parseInt(values[1])));
            }

            // Lagersituation ausgeben
            else if (kommando.trim().equalsIgnoreCase("situat")){
                System.out.println(fabrikStart.lagerSituation());
            }

            else {continue;}
        }
         
    
    
        // Alle Prozesse werden beendet
        try
        {
            Thread.sleep(10);
        }
        catch (InterruptedException ie)
        {
            ie.printStackTrace();
        }

        System.out.println("Alle Prozesse werden beendet");

        System.exit(0);
    }

}
