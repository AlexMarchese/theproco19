import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList; 
import java.io.PrintStream;

import java.util.List;

/**
 * Die Klasse GUI stellt die graphische Nutzeroberfläche für die AEKI Fabrik bereit 
 * und gibt eine Übersicht über die Abläufe in der Fabrik, das Entwicklerteam, den Lieferanten sowie die bestellbaren Produkte.
 */
public class GUI extends JFrame {
    private JFrame fenster;
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel lagerbestandPanel;  
    private JPanel zeitrafferAnzeige;
    private JPanel columnsPanel;
    private JPanel bestellungenPanel;
    private JPanel roboterStatusPanel;
    private JPanel statusUpdatesPanel;
    private JPanel leftPanel;
    private JMenuBar menueZeile;
    private JMenu fileMenu;

    private Fabrik fabrik;
    private Lager lager;
    private Produktions_Manager produktions_manager;
    private Holzbearbeitungs_Roboter holzRoboter;
    private Montage_Roboter montageRoboter;
    private Lackier_Roboter lackierRoboter; 
    private Verpackungs_Roboter verpackungsRoboter;
    private List<Bestellung> bestellungenList;
    private String zeitFaktor;

    private Main main;

    /**
    * Konstruktor für Objekte der Klasse GUI.
    */
    public GUI() {
        main = new Main();

        // Aus der Main Methode und mehr
        this.fabrik = main.gibFabrik(); 
        this.lager = main.gibLager();
        this.produktions_manager = fabrik.gibProduktions_Manager();
        this.bestellungenList = fabrik.gibBestellungsList();
        this.holzRoboter = produktions_manager.gibHolzRoboter();
        this.montageRoboter = produktions_manager.gibMontageRoboter();        
        this.lackierRoboter = produktions_manager.gibLackierRoboter();
        this.verpackungsRoboter = produktions_manager.gibVerpackungsRoboter();

        this.zeitFaktor = "1";

        initFenster(); // Initialisierung des Hauptfensters
    }


    /**
     * Methode zur Initialisierung des Hauptfensters der Anwendung mit verschiedenen Subfenstern und Komponenten.
    */
    private void initFenster() {

            // Gesamtfenster
            fenster = new JFrame("AEKI Übersicht");
            fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fenster.setExtendedState(JFrame.MAXIMIZED_BOTH);
            fenster.setUndecorated(false);

            // Obiges Subfenster mit Lagerbestand, Zeitrafferanzeige und 3 Spalten im Zentrum
            mainPanel = new JPanel(new BorderLayout()); 
            // kleines Subfenster mit Lagerbestand und Zeitrafferanzeige
            topPanel = new JPanel(new BorderLayout());  
            // Konfiguriere Anzeige des Top Panels
            topPanel.setBackground(new Color(221, 221, 221));
            // Erstellung des Fensters mit dem Lagerbestand    
            lagerbestandPanel = new JPanel(); 
            // Wird dem kleinen Subfenster hinzugefügt
            topPanel.add(lagerbestandPanel, BorderLayout.WEST); 
            aktualisiereLagerbestand();
            // Erstellung des Fensters mit der Angabe des Zeitraffers
            zeitrafferAnzeige = new JPanel(new BorderLayout()); 
            topPanel.add(zeitrafferAnzeige, BorderLayout.EAST);
            aktualisiereZeitraffer();
            // kleines Subfenster wird dem obigen Subfenster hinzugefügt 
            mainPanel.add(topPanel, BorderLayout.NORTH);

            /// 3 Subfenster im Zentrum ("Bestellungen", "Roboter Status", "Status-Updates")
            columnsPanel = new JPanel(new GridLayout(1, 3)); 
            konfiguriereSubfensterZentrum();

            // Linke Leiste mit drei Knöpfen
            leftPanel = new JPanel();
            konfiguriereLinkeLeisteKnoepfe();

            /// Menüleiste
            menueZeile = new JMenuBar();
            konfiguriereMenueleiste();

            // Hauptfenster-Konfigurierung
            fenster.add(mainPanel);
            fenster.setSize(800, 400);
            fenster.setLocationRelativeTo(null);
            fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fenster.setVisible(true);
    }

    /// Konfigurierungen der einzelnen Fenster
   
    /**
     * Methode zur Konfigurierung des Lagerbestandes, welches den aktuellen Lagerbestand oben anzeigt.
     * Dabei wird  der kritische Lagerbestand von 25% des maximalen Werts berücksichtigt und  niedrige Bestände in rot markiert. 
     */
    private void aktualisiereLagerbestand(){

        // Panel säubern, bevor es aufgefaufgesetzt wird
        lagerbestandPanel.removeAll();

        // Konfiguriere lagerbestandPanel
        lagerbestandPanel.setBackground(new Color(221, 221, 221));
        lagerbestandPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JLabel lagerbestandLabel = new JLabel("Lagerbestand:");
        lagerbestandPanel.add(lagerbestandLabel);

        JLabel holzLabel, schraubenLabel, kissenLabel, farbeLabel, kartonLabel;

        // Wert Holz
        if (gibHolzWert() > gibMaximalerHolzWert() * 0.25){
            holzLabel = new JLabel("Holz: " + gibHolzWert() + " / " + gibMaximalerHolzWert() + " Einheiten"); 
        } else {
            holzLabel = new JLabel("<html><font color='red'>Holz: " + gibHolzWert() + " / " + gibMaximalerHolzWert() + " Einheiten"); 
        }
        lagerbestandPanel.add(holzLabel);

        // Wert Schrauben
        if (gibSchraubenWert() > gibMaximalerSchraubenWert() * 0.25){
            schraubenLabel = new JLabel("Schrauben: " + gibSchraubenWert() + " / " + gibMaximalerSchraubenWert() + " Einheiten"); 
        } else {
            schraubenLabel = new JLabel("<html><font color='red'>Schrauben: " + gibSchraubenWert() + " / " + gibMaximalerSchraubenWert() + " Einheiten"); 
        }
        lagerbestandPanel.add(schraubenLabel);

        // Wert Kissen
        if (gibKissenWert() > gibMaximalerKissenWert() * 0.25){
            kissenLabel = new JLabel("Kissen: " + gibKissenWert() + " / " + gibMaximalerKissenWert() + " Einheiten"); 
        } else {
            kissenLabel = new JLabel("<html><font color='red'>Kissen: " + gibKissenWert() + " / " + gibMaximalerKissenWert() + " Einheiten"); 
        }
        lagerbestandPanel.add(kissenLabel);

        // Wert Farbe
        if (gibFarbeWert() > gibMaximalerFarbeWert() * 0.25){
            farbeLabel = new JLabel("Farbe: " + gibFarbeWert() + " / " + gibMaximalerFarbeWert() + " Einheiten"); 
        } else {
            farbeLabel = new JLabel("<html><font color='red'>Farbe: " + gibFarbeWert() + " / " + gibMaximalerFarbeWert() + " Einheiten"); 
        }
        lagerbestandPanel.add(farbeLabel);

        // Wert Karton
        if (gibKartonWert() > gibMaximalerKartonWert() * 0.25){
            kartonLabel = new JLabel("Karton: " + gibKartonWert() + " / " + gibMaximalerKartonWert() + " Einheiten"); 
        } else {
            kartonLabel = new JLabel("<html><font color='red'>Karton: " + gibKartonWert() + " / " + gibMaximalerKartonWert() + " Einheiten"); 
        }
        lagerbestandPanel.add(kartonLabel);

        // Panel updaten
        lagerbestandPanel.revalidate();
        lagerbestandPanel.repaint();
    }


    /**
     * Methode zur Konfigurierung und Aktualisierung der Anzeige des Zeitraffers.
     */
    private void aktualisiereZeitraffer(){

        // Panel säubern, bevor es aufgefaufgesetzt wird
        zeitrafferAnzeige.removeAll();

        // Konfiguriere Zeitraffer Anzeige
        zeitrafferAnzeige.setBackground(new Color(221, 221, 221));
        zeitrafferAnzeige.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

        JLabel zeitrafferAnzeigeLabel = new JLabel("Zeitraffer:");
        zeitrafferAnzeige.add(zeitrafferAnzeigeLabel);

        // Konvertiert der Wert von String zu integer
        int number = Integer.parseInt(this.zeitFaktor);

        JLabel ZeitKonversion = new JLabel("1 Sekunde = " + (number == 1 ? "1 Stunde" : (60 / number) + (number > 30 ? " Minute" : " Minuten")));
        zeitrafferAnzeige.add(ZeitKonversion);
    }

    /**
     * Konfigurierung der Subfenster im Zentrum mit 3 Spalten.
     * Erstellt und aktualisiert das Bestellungen-Panel, das Roboter-Status-Panel und das Status-Updates-Panel.
     */
    private void konfiguriereSubfensterZentrum(){
        // Fenster für Bestellungen erstellen       
        bestellungenPanel = new JPanel(new BorderLayout());

        // Fenster für Bestellungen aktualisieren
        aktualisiereColumnBestellungen();

        // Fenster für Bestellungen zu columnsPanel hinzufügen
        columnsPanel.add(bestellungenPanel);

        // Fenster für Roboter-Status erstellen
        roboterStatusPanel = new JPanel(new BorderLayout());

        // Fenster für Bestellungen aktualisieren
        aktualisiereColumnRoboterstatus();

        // Fenster für Roboter-Status zu columnsPanel hinzufügen
        columnsPanel.add(roboterStatusPanel);

        // Fenster für Status-Updates erstellen
        statusUpdatesPanel = new JPanel(new BorderLayout());

        // Fenster für Status-Updates konfigurieren
        konfiguriereColumnStatusupdates();

        // Fenster für Status-Updates zu columnsPanel hinzufügen
        columnsPanel.add(statusUpdatesPanel);
        
        // Fügt Konfiguration dem Main panel hinzu
        mainPanel.add(columnsPanel, BorderLayout.CENTER);

        // Subfenster updaten
        columnsPanel.revalidate();
        columnsPanel.repaint();
    }

    /**
     * Konfigurierung des Bestellungen-Panel.
     * Aktualisiert das Bestellungen-Panel, indem es das Panel leert, neu gestaltet und mit aktualisierten Daten füllt, 
     * und dann die Oberfläche aktualisiert, um die Änderungen anzuzeigen.
     * Dabei wird die neuste Bestellung stets ganz oben angezeigt.
     */
    private void aktualisiereColumnBestellungen(){
        //Fenster säubern, bevor es aufgesetzt wird
        bestellungenPanel.removeAll();

        // Fenster designen und befüllen
        bestellungenPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK),
                BorderFactory.createEmptyBorder(10, 10, 10, 10))); 
                
        // Border hinzufügen
        JLabel bestellungenLabel = new JLabel("Bestellungen");
        bestellungenPanel.add(bestellungenLabel, BorderLayout.NORTH);

        JPanel bestellungenLogPanel = aktualisiereBestellungPanel();
        
        // Verwende ein GridLayout mit Abstand von 4 Pixeln horizontal und 6 Pixeln vertikal zwischen den Komponenten
        bestellungenLogPanel.setLayout(new GridLayout(6, 4, 4, 6));

        JScrollPane bestellungenLogScrollPane = new JScrollPane(bestellungenLogPanel);
        bestellungenPanel.add(bestellungenLogScrollPane, BorderLayout.CENTER);

        // Fenster updaten
        bestellungenPanel.revalidate();
        bestellungenPanel.repaint();
    }

    /**
     * Konfigurierung des Roboter-Status-Panel.
     * Aktualisiert das Roboter-Status-Panel, indem es das Panel leert und neu gestaltet für alle vier verschiedenen Roboter.
     */
    private void aktualisiereColumnRoboterstatus(){
        //Fenster säubern, bevor es aufgesetzt wird
        roboterStatusPanel.removeAll();

        // Fenster designen und befüllen
        roboterStatusPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK),
                BorderFactory.createEmptyBorder(10, 10, 10, 10))); // Fügen Sie den leeren Border hinzu

        JLabel roboterStatusLabel = new JLabel("Roboter Status");
        roboterStatusPanel.add(roboterStatusLabel, BorderLayout.NORTH);

        // Fenster innerhalb der Roboterspalte
        JPanel roboterInnerPanel = new JPanel(new GridLayout(6, 4, 4, 6));

        // Roboter in den jeweiligen Panels abbilden
        JPanel holzRoboterPanel = aktualisiereRoboterPanel(this.holzRoboter);
        JPanel montageRoboterPanel = aktualisiereRoboterPanel(this.montageRoboter);
        JPanel lackierRoboterPanel = aktualisiereRoboterPanel(this.lackierRoboter);
        JPanel verpackungsRoboterPanel = aktualisiereRoboterPanel(this.verpackungsRoboter);

        //Roboter-Panels zu InnerPannel hinzufügen hinzufügen
        roboterInnerPanel.add(holzRoboterPanel);
        roboterInnerPanel.add(montageRoboterPanel);
        roboterInnerPanel.add(lackierRoboterPanel);
        roboterInnerPanel.add(verpackungsRoboterPanel);

        //In mittlere Spalte anordnen
        roboterStatusPanel.add(roboterInnerPanel, BorderLayout.CENTER);

        // Fenster updaten
        bestellungenPanel.revalidate();
        bestellungenPanel.repaint();        
    }

    /**
     * Konfigurierung des Status-Updates-Panel.
     * Erstellt das Panel mit einem Label und einer Möglichekeit zum scrollen.
     */
    private void konfiguriereColumnStatusupdates(){
        // Design
        statusUpdatesPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK),
                BorderFactory.createEmptyBorder(10, 10, 10, 10))); // Fügt den leeren Border hinzu

        JLabel statusUpdatesLabel = new JLabel("Status-Updates");
        statusUpdatesPanel.add(statusUpdatesLabel, BorderLayout.NORTH);

        // Konsolen-Statements anzeigen
        ConsoleTextArea logTextArea = new ConsoleTextArea();
        logTextArea.setEditable(false);

        JScrollPane logScrollPane = new JScrollPane(logTextArea);
        statusUpdatesPanel.add(logScrollPane, BorderLayout.CENTER);

        // Redirect System.out to the custom PrintStream
        PrintStream consolePrintStream = logTextArea.getPrintStream();
        System.setOut(consolePrintStream);
        System.setErr(consolePrintStream);

    }

    /**
     * Konfigurierung einer Leiste ganz links mit vier Knoepfen (Buttons).
     * Ein "Bestellung aufgeben" Knopf, der die Methode handleBestellungAufgeben() aufruft, wenn darauf geklickt wird.
     * Ein "Zeitraffer" Knopf, der die Methode handleZeitraffer() aufruft, wenn darauf geklickt wird.
     * Ein "Bestellungen Ausgeben" Knopf, der die Methode handleBestellungenAusgeben() aufruft, wenn darauf geklickt wird.
     * Ein "Übersicht Lieferant" Knopf, der eine Methode displayInformationPanel() aufruft, wenn darauf geklickt wird.
     */
    private void konfiguriereLinkeLeisteKnoepfe(){
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        //Bestellung Aufgeben Button
        JButton button1 = new JButton("Bestellung Aufgeben");
        button1.setMaximumSize(new Dimension(200, 30));
        button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleBestellungAufgeben();
                }
            });
        leftPanel.add(button1);

        // Zeitraffer Button
        JButton buttonZ = new JButton("Zeitraffer");
        buttonZ.setMaximumSize(new Dimension(200, 30));
        buttonZ.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleZeitraffer();
                }
            });
        leftPanel.add(buttonZ);

        //Bestellung Ausgeben Button
        JButton button2 = new JButton("Bestellungen Ausgeben");
        button2.setMaximumSize(new Dimension(200, 30));
        button2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleBestellungenAusgeben();
                }
            });
        leftPanel.add(button2);

        //Übersicht Lieferant Button
        JButton button3 = new JButton("Übersicht Lieferant");
        button3.setMaximumSize(new Dimension(200, 30));
        button3.addActionListener(e -> {
                    // Handle Button 3 action
                    displayInformationPanel();
            });
        leftPanel.add(button3);

        //fügt Konfiguration dem Main panel hinzu
        mainPanel.add(leftPanel, BorderLayout.WEST);
    }

    /**
     * Konfigurierung der Menüleiste für das GUI-Fenster zu oberst. 
     * Erstellt und konfiguriert das Menü "Datei".
     * Erstellt und konfiguriert das Menü "Produkte" mit Untermenüpunkten "Stuhl" und "Sofa".
     * Erstellt und konfiguriert das Menü "Über Uns" mit dem Untermenüpunkt "Team".
     * Erstellt und konfiguriert den Menüpunkt "Aktualisieren" im "Datei"-Menü mit einem ActionListener für die Aktualisierungsfunktion.
     */
    private void konfiguriereMenueleiste(){

        fenster.setJMenuBar(menueZeile);
        
        // Datei
        JMenu fileMenu = new JMenu("Datei");
        menueZeile.add(fileMenu);
        
        // Produkte
        JMenu produktMenu = new JMenu("Produkte");
        menueZeile.add(produktMenu);
        JMenuItem stuhlEintrag = new JMenuItem("Stuhl");
        stuhlEintrag.addActionListener(new StuhlActionListener());
        produktMenu.add(stuhlEintrag);
        JMenuItem sofaEintrag = new JMenuItem("Sofa");
        sofaEintrag.addActionListener(new SofaActionListener());
        produktMenu.add(sofaEintrag);
        
        // Ueber Uns
        JMenu unsMenu = new JMenu("Über Uns");
        menueZeile.add(unsMenu);
        JMenuItem teamEintrag = new JMenuItem("Team");
        teamEintrag.addActionListener(new TeamActionListener());
        unsMenu.add(teamEintrag);

        // Refresh
        JMenuItem refresh = new JMenuItem("Aktualisieren");
        refresh.addActionListener(e -> {
                    // Refresh action
                    aktualisiereFenster();
                    JOptionPane.showMessageDialog(fenster, "Fenster aktualisiert. Sie sind auf dem aktuellen Stand.");
            });
        fileMenu.add(refresh);
    }

    /**
     * Methode die den Ablauf nach dem Drücken des "Bestellung Aufgeben"-Buttons behandelt.
     * Zeigt Dialogfenster für die Anzahl der zu bestellenden Sofas und Stuehle an.
     * Verarbeitet die eingegebenen Werte und gibt entsprechende Meldungen aus.
     * Ruft die Methode `fabrik.bestellungAufgeben()` auf, um die Bestellung in der Fabrik zu erfassen.
     * Zeigt Ergebnismeldungen oder Fehlermeldungen anhand der Rückgabe von `fabrik.bestellungAufgeben()` an.
     */
    private void handleBestellungAufgeben() {

        String sofasInput = JOptionPane.showInputDialog(GUI.this, "Bitte geben Sie die Anzahl Sofas an, welche Sie bestellen moechten.\nEs soll eine ganze maximal zweistellige Zahl oder '0' sein:");

        // Wenn "Abbrechen" gewählt wird, verhält es sich als ob "faktor = null". In solchen Fällen, wird das Else ausgeführt
        if (sofasInput != null) {
            String stuehleInput = JOptionPane.showInputDialog(GUI.this, "Bitte geben Sie die Anzahl Stuehle an, welche Sie bestellen moechten.\nEs soll eine ganze maximal zweistellige Zahl oder '0' sein:");

            // Wenn hier "Abbrechen" gewält wird, verhält es sich als ob "faktor = null". In solchen Fällen, wird das Else ausgeführt
            if (stuehleInput != null) {
                try {

                // Stellt sicher, dass ein Wert eingegeben wird und dieser nicht mehr als 2 Ziffern hat. Bei zu vielen, gibt es einen Parsing Fehler.
                if (!sofasInput.isEmpty() && sofasInput.length() <= 2 && !stuehleInput.isEmpty() && stuehleInput.length() <= 2) {

                    
                    int stuehle = Integer.parseInt(stuehleInput); // Konversion zu int
                    int sofas = Integer.parseInt(sofasInput); 

                    if (!(stuehle == 0 && sofas == 0)){ // Verhindert Bestellungen mit doppelter Eingabe 0
                        try {
                        
                        String result = fabrik.bestellungAufgeben(sofas, stuehle);
                        System.out.println("Eine Bestellung mit " + sofas + (sofas == 1 ? " Sofa und " : " Sofas und ") + stuehle + (stuehle == 1 ? " Stuhl" : " Stuehlen") +" wird in der Fabrik erfasst.");
                        JOptionPane.showMessageDialog(GUI.this, result);
                        
                        } catch (IllegalArgumentException e) {
                            JOptionPane.showMessageDialog(GUI.this, "Basierend auf den Eigenschaften des Lagers, ist dies eine zu grosse Bestellmenge. Bitte probieren Sie mit einer kleineren!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(GUI.this, "'0' wurde zweimal eingegeben. Dies führt zu keiner Bestellung!");
                    }
                    
                } else {
                        throw new NumberFormatException();
                    }
            
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(GUI.this, "Ungueltiger Input. Es soll eine ganze maximal zweistellige Zahl oder '0' sein.");
                } 

                } else {
                    System.out.println("Operation wurde abgebrochen");
                }

        } else {
            System.out.println("Operation wurde abgebrochen");
        }
        
    }

    /**
     * Methode die den Ablauf nach dem Drücken des "Zeitraffer"-Buttons behandelt.
     * Zeigt ein Dialogfenster für die Eingabe des Zeitfaktors an.
     * Verarbeitet die eingegebene Zeitfaktor-Wert und beeinflusst die Zeit in der Fabrik entsprechend.
     * Validiert die Eingabe, um sicherzustellen, dass ein gültiger Zeitfaktor eingegeben wird (ganze Zahl zwischen 1 und 60).
     * Zeigt Fehlermeldungen an, wenn die Eingabe ungültig ist, oder führt die Methode `fabrik.beeinflusseZeit()` aus.
     */
    private void handleZeitraffer() {

        String faktor = JOptionPane.showInputDialog(GUI.this, "Bitte geben Sie die den Faktor an um welchen Sie die Zeit beeinflussen moechten.\nEs soll eine ganze Zahl zwischen 1 und 60 sein:");

        // Wenn "Abbrechen" gewält wird, verhält es sich als ob "faktor = null". In solchen Fällen, wird das Else ausgeführt
        if (faktor != null) {
            try {

                // Stellt sicher, dass ein Wert eingegeben wird und dieser nicht mehr als 2 Ziffern hat. Bei zu vielen, gibt es einen Parsing Fehler.
                if (!faktor.isEmpty() && faktor.length() <= 2) {
                 
                    int faktorInt = Integer.parseInt(faktor); // Konversion zu int

                    if (1 <= faktorInt && faktorInt <= 60){ // Kontrolle, dass der Wert nicht größer als 60 ist
                        fabrik.beeinflusseZeit(faktorInt);
                        System.out.println("Neuer Zeit-Faktor gewaehlt: " + faktor);
                        this.zeitFaktor = faktor; // Wert wird als Attribut gespeichert
                    } else {
                        throw new NumberFormatException();
                    }
                } else {
                        throw new NumberFormatException();
                    }
            
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(GUI.this, "Ungueltiger Input. Es soll eine ganze Zahl zwischen 1 und 60 sein.");
                } 
            } else {
                ;
            }

        
    }

    /**
     * Methode die die Methode fabrik.bestellungenAusgeben aufruft, um die aktuellen Bestellungen abzurufen.
     */
    private void handleBestellungenAusgeben() {
        // Fabrik-Methode aufrufen und abspeichern
        String result = fabrik.bestellungenAusgeben();

        // Bestellungen anzeigen
        JOptionPane.showMessageDialog(GUI.this, result);
    }

    /**
     * Diese Methode erstellt ein neues Fenster, das Informationen zum Lieferanten anzeigt, einschliesslich des aktuellen Lieferstatus 
     * und der im Lieferprozess befindlichen Einheiten. Der Nutzer kann das Fenster durch Betätigen des "Schliessen"-Buttons schliessen.
     */
        private void displayInformationPanel() {
        // Create a new JFrame for the information panel zum Lieferanten
        JFrame informationFrame = new JFrame("Lieferant Information");
        informationFrame.setSize(600, 300);
        informationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create a panel for the information content
        JPanel informationPanel = new JPanel();
        informationPanel.setLayout(new BoxLayout(informationPanel, BoxLayout.Y_AXIS));

        // Add components for the information panel 
        String infoText = "<html><br> Auf dieser Seite finden Sie den aktuellen Status des Lieferanten.<br><br>" +
            "Der Lieferant hat momentan genuegend Material an Lager um eine Bestellung aufzunehmen.<br>"+
            "----------------------------------------------------------<br>" +
            "Lieferstatus<br>" +
            "Momentan werden folgende Einheiten geliefert:<br>" +
            "Holzeinheiten: " + lager.gibInLieferungHolzeinheiten() + "<br>" +
            "Schrauben: " + lager.gibInLieferungSchrauben() + "<br>" +
            "Kissen: " + lager.gibInLieferungKissen() + "<br>" +
            "Farbeeinheiten: " + lager.gibInLieferungFarbeeinheiten() + "<br>" +
            "Kartoneinheiten: " + lager.gibInLieferungKartoneinheiten() + "</html>";


        JLabel infoLabel = new JLabel(infoText);
        JButton closeButton = new JButton("Schliessen");
        
        closeButton.addActionListener(e -> informationFrame.dispose());

        informationPanel.add(infoLabel);
        informationPanel.add(Box.createHorizontalStrut(10)); // Platz hinzufügen für eine schönere Formatierung
        informationPanel.add(Box.createVerticalStrut(2)); // 
        
        informationPanel.add(closeButton);
        informationPanel.add(Box.createVerticalStrut(10)); 

        // Add the information panel to the frame
        informationFrame.add(informationPanel);

        // Center the frame on the screen
        informationFrame.setLocationRelativeTo(null);

        // Make the frame visible
        informationFrame.setVisible(true);
    }

    /**
     * Aktualisierung eines der vier Roboter-Status-Panel. Die Methode muss für jeden Roboter-Panel aufgerufen werden.
     * Die Informationen werden in Form von JLabels dargestellt und umfassen den Roboter-Namen, seinen Status und die Größe seiner Warteschlange.
     * 
     * @param roboter Der Roboter, dessen Informationen im erstellten JPanel dargestellt werden sollen.
     * @return panel Ein Panel, das die Roboter-Informationen darstellt.
     */

    private JPanel aktualisiereRoboterPanel(Roboter roboter) {
        JPanel panel = new JPanel(new GridLayout(4, 1));
        JLabel nameLabel = new JLabel("<html><b>" +    roboter.gibName() + "</b></html>");
        JLabel statusLabel = new JLabel("  Status: Aktiv");
        JLabel warteschlangeLabel = new JLabel("  Warteschlange: " + roboter.gibWarteschlange().size());

        panel.add(nameLabel);
        panel.add(statusLabel);
        panel.add(warteschlangeLabel);

        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        return panel;
    }

    /**
     * Aktualisiert das Panel für Bestellungen und gibt ein neues JPanel zurück. 
     * 
     * @return panel Ein Panel, das die aktualisierten Bestellungen darstellt. 
     */ 

    private JPanel aktualisiereBestellungPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Create panels for each order
        this.bestellungenList = fabrik.gibBestellungsList();
        for (Bestellung bestellung : bestellungenList) {
            JPanel orderPanel = new JPanel();
            orderPanel.setLayout(new BoxLayout(orderPanel, BoxLayout.Y_AXIS));

            String status = "";
            if(bestellung.gibAlleProdukteProduziert()){
                status = "<html><font color='green'>Fertig</font>";
            }else{
                status = "<html><font color='red'>In Arbeit</font>";
            }

            JLabel orderLabel = new JLabel( "<html><b>Bestellung Nr. " + bestellung.gibBestellungsNr() + "</b></html>");
            JLabel infoLabel = new JLabel(  "<html>Anzahl Stuehle: " + bestellung.gibAnzahlStuehle() +
                    "<br>Anzahl Sofas: " + bestellung.gibAnzahlSofas() +
                    "<br>Status: " + status + "</html>");

            orderPanel.add(orderLabel);
            orderPanel.add(infoLabel);

            orderPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            panel.add(orderPanel, 0);
        }

        return panel;
    }

    /**
     * Methode, um die drei Panels Lagerbestand, ColumnBestellungen und ColumnRoboterstatus zu aktualisieren.
     */
    public void aktualisiereFenster() {
        aktualisiereLagerbestand();
        aktualisiereZeitraffer();
        aktualisiereColumnBestellungen();
        aktualisiereColumnRoboterstatus();
    }

    
    /// Methoden zu den Werten des aktuellen und maximalen Lagerbestandes
    
    
    /**
     * Methode, um den aktuellen Wert der vorhandenen Holzeinheiten im Lager zu erhalten.
     * @return vorhandeneHolzeinheiten Der aktuelle Wert der vorhandenen Holzeinheiten.
     */
    private int gibHolzWert() {
        return this.lager.gibvorhandeneHolzeinheiten();
    }

    /**
     * Methode, um den aktuellen Wert der vorhandenen Schrauben im Lager zu erhalten.
     * @return vorhandeneSchrauben Der aktuelle Wert der vorhandenen Schrauben.
     */
    private int gibSchraubenWert() {
        return this.lager.gibvorhandeneSchrauben();
    }

    /**
     * Methode, um den aktuellen Wert der vorhandenen Kissen im Lager zu erhalten.
     * @return vorhandeneKissen Der aktuelle Wert der vorhandenen Kissen.
     */
    private int gibKissenWert() {
        return this.lager.gibvorhandeneKissen();
    }

    /**
     * Methode, um den aktuellen Wert der vorhandenen Einheiten Farbe im Lager zu erhalten.
     * @return vorhandeneFarbeeinheiten Der aktuelle Wert der vorhandenen Farbeeinheiten.
     */
    private int gibFarbeWert() {
        return this.lager.gibvorhandeneFarbeeinheiten();
    }

    /**
     * Methode, um den aktuellen Wert der vorhandenen Einheiten Karton im Lager zu erhalten.
     * @return vorhandeneKartoneinheiten Der aktuelle Wert der vorhandenen Kartoneinheiten.
     */
    private int gibKartonWert() {
        return this.lager.gibvorhandeneKartoneinheiten();
    }

    /**
     * Methode, um den maximalen Wert der Einheiten Holz im Lager zu erhalten.
     * @return MaxHolzeinheiten Der maximale Wert der Holzeinheiten.
     */
    private int gibMaximalerHolzWert() {
        return this.lager.gibMaxHolzeinheiten();
    }

    /**
     * Methode, um den maximalen Wert der Schrauben im Lager zu erhalten.
     * @return MaxSchrauben Der maximale Wert der Schrauben.
     */
    private int gibMaximalerSchraubenWert() {
        return this.lager.gibMaxSchrauben();
    }

    /**
     * Methode, um den maximalen Wert der Kissen im Lager zu erhalten.
     * @return MaxKissen Der maximale Wert der Kissen.
     */
    private int gibMaximalerKissenWert() {
        return this.lager.gibMaxKissen();
    }

    /**
     * Methode, um den maximalen Wert der Einheiten Farbe im Lager zu erhalten.
     * @return MaxFarbeeinheiten Der maximale Wert der Farbeinheiten.
     */
    private int gibMaximalerFarbeWert() {
        return this.lager.gibMaxFarbeeinheiten();
    }

    /**
     * Methode, um den maximalen Wert der Einheiten Karton im Lager erhalten.
     * @return MaxKartoneinheiten Der maximale Wert der Kartoneinheiten.
     */
    private int gibMaximalerKartonWert() {
        return this.lager.gibMaxKartoneinheiten();
    }

    /**
     * Die Klasse "TeamActionListener" erstellt ein neues Fenster sobald über
     * das JMenu "Über Uns" ausgewählt wird. 
     */
    class TeamActionListener implements ActionListener
    {
         /**
         * Methode die aufgerufen wird, wenn das JMenu "Über Uns" ausgewählt wird.
         * Erstellt ein neues JFrame mit dem Titel "Unser Team" und setzt den Inhalt auf ein Bild.
         */
        public void actionPerformed(ActionEvent event)
        {
            fenster = new JFrame("Unser Team");
            teamFenster();
        }

        /**
         * Methode die ein neues Fenster mit einem Hintergrundbild erstellt, welches das Team der Gruppe abbildet.
         */
        protected void teamFenster() 
        {
            fenster.setContentPane(new BackGroundPane("UnserTeam.png"));
            guiSettings(fenster, 720, 405);
        }
    }

    /**
     * Die Klasse "SofaActionListener" erstellt ein neues Fenster sobald über
     * das JMenu "Produkte" angewählt wird. 
     */
    class SofaActionListener implements ActionListener
    {
        /**
        * Methode wird aufgerufen, wenn das JMenuItem "Sofa" ausgewählt wird.
        * Erstellt ein neues JFrame mit dem Titel "Sofa" und setzt den Inhalt auf ein Bild.
        */
        public void actionPerformed(ActionEvent event)
        {
            fenster = new JFrame("Sofa");
            sofaFenster();
        }

        /**
        * Methdoe, die ein neues Fenster erstellt mit einem Hintergrundbild, welches das Sofa abbildet.
        */
        protected void sofaFenster() 
        {
            fenster.setContentPane(new BackGroundPane("Sofa.png"));
            guiSettings(fenster, 600, 505);
        }
    }

    /**
     * Die Klasse "StuhlActionListener" erstellt ein neues Fenster sobald über
     * das JMenu "Produkte" ausgewählt wird. 
     */
    class StuhlActionListener implements ActionListener
    {
        /**
        * Methode wird aufgerufen, wenn das JMenuItem "Stuhl" ausgewählt wird.
        * Erstellt ein neues JFrame mit dem Titel "Stuhl" und setzt den Inhalt auf ein Bild.
        */
        public void actionPerformed(ActionEvent event)
        {
            fenster = new JFrame("Stuhl");
            stuhlFenster();
        }

        /**
        * Methode, die ein neues Fenster erstellt mit einem Hintergrundbild, welches den Stuhl abbildet.
        */
        protected void stuhlFenster() 
        {
            fenster.setContentPane(new BackGroundPane("Stuhl.png"));
            guiSettings(fenster, 550, 505);
        }
    }

    /**
     * Die Klasse "BackGroundPane" setzt Hintergrundbilder ein. 
     */
    class BackGroundPane extends JPanel 
    {
        Image img = null;

        /**
         * Konstruktor für die BackGroundPane-Klasse.
         * @param imagefile Der Dateipfad des Hintergrundbilds.
         */
        BackGroundPane(String imagefile) 
        {
            if (imagefile != null) {
                MediaTracker mt = new MediaTracker(this);
                img = Toolkit.getDefaultToolkit().getImage(imagefile);
                mt.addImage(img, 0);
                try {
                    mt.waitForAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        /**
         * Die paintComponent-Methode wird überschrieben, um das Hintergrundbild zu zeichnen.
         * @param g Der Graphics-Kontext zum Zeichnen.
         */
        protected void paintComponent(Graphics g) 
        {
            super.paintComponent(g);
            g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
        }
    }

    /**
     * Die private Methode guiSettings stellt die grundlegenden Einstellungen für das JFrame-Fenster ein.
     * 
     * @param fenster Das JFrame-Fenster, für das die Einstellungen vorgenommen werden.
     * @param laenge Die Laenge des Fensters.
     * @param breite Die Breite des Fensters.
     */
    private void guiSettings(JFrame fenster, int laenge, int breite){
        fenster.setLayout(null);
        fenster.setSize(laenge, breite);
        fenster.setResizable(false);
        fenster.setVisible(true);
    }

}