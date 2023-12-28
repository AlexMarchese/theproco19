// import java.util.Scanner; // Wird benötigt, um eine Eingabe vom Terminal zu bekommen
// import java.util.regex.Pattern; // Wird benutzt, um Eingabewerte zu überprüfen

import javax.swing.Timer;

import javax.swing.SwingUtilities;

/**
 * 
 * Die Klasse Main ist der Einstiegspunkt in das Programm und in der Main Methode wird das Programm ausgeführt.
 * Hier können aufgefüllte Bestellungen mit individuellen Anzahlen an Stühlen und Sofas aufgegeben werden oder es 
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
     * Die main-Methode startet die Anwendung. Der GUI wird hier erstellt und sichtbar gemacht.
     * Darüber hinaus wird ein Timer verwendet, um das GUI-Fenster stetig zu aktualisieren.
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