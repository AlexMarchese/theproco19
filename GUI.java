import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList; 
import java.io.PrintStream;

import java.util.List; // 

/**
 * TO DO:
 * Die Klasse GUI ...
 */
public class GUI extends JFrame {
    //private final GUI_Controller controller;
    private JFrame fenster;
    private JPanel mainPanel;
    private JPanel lagerbestandPanel;// = new JPanel();    
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

    private Main main;

    /**
     * Konstruktor für Objekte der Klasse GUI
     */
    public GUI() {

        //bestellungenList = new ArrayList<>();
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
        
        initFenster(); // Initialisierung des Hauptfensters
    }
    //public GUI(GUI_Controller controller) {
    //   this.controller = controller;
    //   initFenster();
    // }

    /**
     * Methode zur Initialisierung aller Fenster
     * @param fabrik
     * @param lager
     */
    private void initFenster() {

        // Gesamtfenster
        fenster = new JFrame("AEKI Übersicht");
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenster.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fenster.setUndecorated(false);

        // Obiges Subfenster mit vor allem Lagerbestand
        mainPanel = new JPanel(new BorderLayout());        
        lagerbestandPanel = new JPanel(); // Erstellung des Fensters mit dem Lagerbestand
        mainPanel.add(lagerbestandPanel, BorderLayout.NORTH); // Wird dem obigen Subfenster hinzugefügt
        aktualisiereLagerbestand();

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
     * Konfigurierung des Lagerbestandes, Anzeige oben
     */
    private void aktualisiereLagerbestand(){
        
        //Panel säubern, bevor es aufgefaufgesetzt wird
        lagerbestandPanel.removeAll();
        
        // Konfiguriere lagerbestandPanel
        lagerbestandPanel.setBackground(new Color(221, 221, 221));
        lagerbestandPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JLabel lagerbestandLabel = new JLabel("Lagerbestand:");
        lagerbestandPanel.add(lagerbestandLabel);

        JLabel holzLabel = new JLabel("Holz: " + getHolzValue() + " / 1000 Einheiten"); // Insert function call here
        lagerbestandPanel.add(holzLabel);

        JLabel schraubenLabel = new JLabel("Schrauben: " + getSchraubenValue() + " / 5000 Einheiten"); // Insert function call here
        lagerbestandPanel.add(schraubenLabel);

        JLabel kissenLabel = new JLabel("Kissen: " + getKissenValue() + " / 100 Einheiten"); // Insert function call here
        lagerbestandPanel.add(kissenLabel);

        JLabel farbeLabel = new JLabel("Farbe: " + getFarbeValue() + " / 1000 Einheiten"); // Insert function call here
        lagerbestandPanel.add(farbeLabel);

        JLabel kartonLabel = new JLabel("Karton: " + getKartonValue() + " / 1000 Einheiten"); // Insert function call here
        lagerbestandPanel.add(kartonLabel);
        
        // Panel updaten
        lagerbestandPanel.revalidate();
        lagerbestandPanel.repaint();
        
    }

    /**
     * Konfigurierung der Subfenster im Zentrum mit 3 Spalten
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
        
        //Fenster für Roboter-Status zu columnsPanel hinzufügen
        columnsPanel.add(roboterStatusPanel);
        
        
        // Fenster für Status-Updates erstellen
        statusUpdatesPanel = new JPanel(new BorderLayout());
        
        // Fenster für Status-Updates konfigurieren
        konfiguriereColumnStatusupdates();
        
        // Fenster für Status-Updates zu columnsPanel hinzufügen
        columnsPanel.add(statusUpdatesPanel);
        
        
        
        //fügt Konfiguration dem Main panel hinzu
        mainPanel.add(columnsPanel, BorderLayout.CENTER);
        
        
        // Add test messages - OLD
        //for (int i = 1; i <= 5; i++) {
        //    logTextArea.append("Test Message " + i + "\n");
        //}

        //    private void updateLagerbestandGUI() {
        //int[] lagerbestand = this.lager.gibLagerbestand();

        //Label aktuellerLagerstatus = new Label("Status: Normal");
        //aktuellerLagerstatus.setTextFill(Color.rgb(0, 128, 0));
        //if(lager.wartetAufLieferant()) {
        //aktuellerLagerstatus.setText("Status: Wird belieftert...");
        // aktuellerLagerstatus.setTextFill(Color.rgb(128, 0, 0));
        //}

        //Hier wird innerhalb der Spalte Status Updates ein ScrollPane angelegt
        //JScrollPane logScrollPane = new JScrollPane(logTextArea);
        //statusUpdatesPanel.add(logScrollPane, BorderLayout.CENTER);
        
        
        // Subfenster updaten
        columnsPanel.revalidate();
        columnsPanel.repaint();
    }

    /**
     * Konfigurierung der Subfenster im Zentrum mit 3 Spalten
     */
    private void aktualisiereColumnBestellungen(){
        //Fenster säubern, bevor es aufgesetzt wird
        bestellungenPanel.removeAll();
        
        // Fenster designen und befüllen
        bestellungenPanel.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(Color.BLACK),
        BorderFactory.createEmptyBorder(10, 10, 10, 10))); // Fügen Sie den leeren Border hinzu
        
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
     * Konfigurierung der Subfenster im Zentrum mit 3 Spalten
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
     * Konfigurierung der Subfenster im Zentrum mit 3 Spalten
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
     * Konfigurierung der Linken Leiste mit den Knöpfen
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
                //button1.addActionListener(e -> {
                // Handle Button 1 action
                //   JOptionPane.showMessageDialog(fenster, "Button 1 pressed");
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
                //buttonZ.addActionListener(e -> {
                // Handle Button 1 action
                //   JOptionPane.showMessageDialog(fenster, "Button 1 pressed");
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
     * Konfigurierung der Menüleiste
     */
    private void konfiguriereMenueleiste(){

        fenster.setJMenuBar(menueZeile);

        JMenu fileMenu = new JMenu("Datei");
        menueZeile.add(fileMenu);
        
        JMenu produktMenu = new JMenu("Produkte");
        menueZeile.add(produktMenu);
        JMenuItem stuhlEintrag = new JMenuItem("Stuhl");
        stuhlEintrag.addActionListener(new StuhlActionListener());
        produktMenu.add(stuhlEintrag);
        JMenuItem sofaEintrag = new JMenuItem("Sofa");
        sofaEintrag.addActionListener(new SofaActionListener());
        produktMenu.add(sofaEintrag);
        
        JMenu unsMenu = new JMenu("Über Uns");
        menueZeile.add(unsMenu);
        JMenuItem teamEintrag = new JMenuItem("Team");
        teamEintrag.addActionListener(new TeamActionListener());
        unsMenu.add(teamEintrag);

        // Option 1 "Refresh" ->
        JMenuItem refresh = new JMenuItem("Refresh");
        refresh.addActionListener(e -> {
                    // Refresh action
                    aktualisiereFenster();
                    JOptionPane.showMessageDialog(fenster, "Fenster aktualisiert. Du bist auf dem aktuellen Stand.");
            });
        fileMenu.add(refresh);

        /* Code für REFRESH Option für Option 1 oben links in der Selektion
        option1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        handleOption1();
        }
        });

        fileMenu.add(option1);
         */

        // Option 2 "" ->
        //JMenuItem option2 = new JMenuItem("Option 2");
        //option2.addActionListener(e -> {
                    // Handle Option 2 action
        //            JOptionPane.showMessageDialog(fenster, "Option 2 selected");
         //   });
        //fileMenu.add(option2);

        // Option 3 "" ->
        //JMenuItem option3 = new JMenuItem("Option 3");
        //option3.addActionListener(e -> {
        //            // Handle Option 3 action
        //            JOptionPane.showMessageDialog(fenster, "Option 3 selected");
        //    });
        //fileMenu.add(option3);
    }

    private void handleBestellungAufgeben() {
        System.out.println("Button 'Bestellung Aufgeben' clicked"); // Debug print

        String sofasInput = JOptionPane.showInputDialog(GUI.this, "Bitte geben Sie die Anzahl Sofas an, welche Sie bestellen moechten:");
        String stuehleInput = JOptionPane.showInputDialog(GUI.this, "Bitte geben Sie die Anzahl Stuehle an, welche Sie bestellen moechten:");

        try {
            int stuehle = Integer.parseInt(stuehleInput);
            int sofas = Integer.parseInt(sofasInput);

            System.out.println("Calling fabrik.bestellungAufgeben with sofas: " + sofas + " and stuehle: " + stuehle); // Debug print

            // Call the fabrik.bestellungAufgeben method with the entered values
            // String result = fabrik.bestellungAufgeben(sofas, stühle);
            // String result = main.befehleSchleife("best " + sofas + " " + stühle);
            // String result = main.befehle("best " + sofas + " " + stühle);
            String result = fabrik.bestellungAufgeben(sofas, stuehle);

            // fenster.pack();

            // System.out.println("Result from fabrik.bestellungAufgeben: " + result); // Debug print
            // System.out.println("Result from fabrik.bestellungAufgeben: "); // Debug print
            // Display the result
            JOptionPane.showMessageDialog(GUI.this, result);
            // JOptionPane.showMessageDialog(GUI.this);
            // JOptionPane.showMessageDialog(GUI.this, "It worked!");

            // Update the Bestellungen column
            //updateBestellungenPanel();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(GUI.this, "Invalid input. Please enter valid numbers.");
        }
    }

    private void handleZeitraffer() {
        System.out.println("Button 'Zeitraffer' clicked"); // Debug print

        // String sofasInput = JOptionPane.showInputDialog(GUI.this, "Bitte geben Sie die Anzahl Sofas an, welche Sie bestellen moechten:");
        // String stuehleInput = JOptionPane.showInputDialog(GUI.this, "Bitte geben Sie die Anzahl Stuehle an, welche Sie bestellen moechten:");
        String zeitFaktor = JOptionPane.showInputDialog(GUI.this, "Bitte geben Sie die den Faktor an um welchen Sie die Zeit beeinflussen moechten:");

        try {
            int faktor = Integer.parseInt(zeitFaktor);
            // int sofas = Integer.parseInt(sofasInput);

            System.out.println("Calling fabrik.beeinflusseZeit with Faktor: " + faktor); // Debug print

            // Call the fabrik.bestellungAufgeben method with the entered values
            // String result = fabrik.bestellungAufgeben(sofas, stühle);
            // String result = main.befehleSchleife("best " + sofas + " " + stühle);
            // String result = main.befehle("best " + sofas + " " + stühle);
            // String result = fabrik.bestellungAufgeben(sofas, stuehle);
            fabrik.beeinflusseZeit(faktor);

            // fenster.pack();

            // System.out.println("Result from fabrik.bestellungAufgeben: " + result); // Debug print
            // System.out.println("Result from fabrik.bestellungAufgeben: "); // Debug print
            // Display the result
            // JOptionPane.showMessageDialog(GUI.this, result);
            // JOptionPane.showMessageDialog(GUI.this);
            // JOptionPane.showMessageDialog(GUI.this, "It worked!");

            // Update the Bestellungen column
            //updateBestellungenPanel();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(GUI.this, "Invalid input. Please enter valid numbers.");
        }
    }

    /// Methoden der Fenster
    private void handleBestellungenAusgeben() {
        // Call the fabrik.bestellungenAusgeben method
        // String result = fabrik.bestellungenAusgeben();
        String result = fabrik.bestellungenAusgeben();

        // Fenster "Bestellungen" wird aktualisiert
        //updateBestellungenPanel();

        // fenster.pack(); // Fenster wird geladen

        // Display the result
        JOptionPane.showMessageDialog(GUI.this, result);
    }

    private void handleOption1() {
        // Hier könnte Option 1 refresh implementiert werden
        //fabrik.updateSomeValues(); // You need to implement this method in your Fabrik class.

        // Update the GUI to reflect changes
        //updateGUI();
    }

    private void displayInformationPanel() {
        // Create a new JFrame for the information panel zum Lieferanten
        JFrame informationFrame = new JFrame("Lieferant Information");
        informationFrame.setSize(400, 300);
        informationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create a panel for the information content
        JPanel informationPanel = new JPanel();
        informationPanel.setLayout(new BoxLayout(informationPanel, BoxLayout.Y_AXIS));

        // Add components for the information panel (customize this part)
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
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> informationFrame.dispose());

        informationPanel.add(infoLabel);
        informationPanel.add(Box.createVerticalStrut(10)); // Add spacing
        informationPanel.add(closeButton);

        // Add the information panel to the frame
        informationFrame.add(informationPanel);

        // Center the frame on the screen
        informationFrame.setLocationRelativeTo(null);

        // Make the frame visible
        informationFrame.setVisible(true);
    }

    //Diese Funktion sollte das Panel mit den Bestellungen updaten (nicht mehr in Use - jetzt aktualisiereBestellungPanel())
    /*
    private void updateBestellungenPanel() {
    // Create a new panel for bestellungenLogPanel
    // Create a new panel for bestellungenLogPanel
    // JPanel newBestellungenLogPanel = createBestellungPanel("STa chippa");
    JPanel newBestellungenLogPanel = createBestellungPanel(fabrik.gibBestellungsList());

    //Nur als Testing Alex
    JFrame debugFrame = new JFrame("Debug Window");
    debugFrame.setSize(400, 300);
    debugFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    debugFrame.setContentPane(newBestellungenLogPanel);
    debugFrame.setLocationRelativeTo(null);
    debugFrame.setVisible(true);

    // Update only the Bestellungen column
    Component[] components = columnsPanel.getComponents();
    for (Component component : components) {
    if (component instanceof JScrollPane && ((JScrollPane) component).getViewport().getView() instanceof JPanel) {
    // Remove the old bestellungenLogPanel from the JScrollPane
    ((JScrollPane) component).getViewport().removeAll();

    // Add the new bestellungenLogPanel to the JScrollPane
    ((JScrollPane) component).setViewportView(newBestellungenLogPanel);
    break; // Assuming there's only one JScrollPane for Bestellungen
    }
    }

    // Repaint the GUI
    revalidate();
    repaint();
    }
     */

    /*
    //Dieser Code snippet sollte die gesamte GUI updaten nicht mehr in use
    /*
     * 
     *private void updateGUI() {
    // Add logic here to update the GUI components that need to reflect changes in the Fabrik
    // For example, update labels with new values from Fabrik
    // ...
    this.bestellungenList = fabrik.gibBestellungsList();
    // Repaint the GUI
    revalidate();
    repaint();
    }
    
    */

    /**
     * Aktualisierung eines der vier Roboter-Panel (muss für jeden Roboter-Panel aufgerufen werden).
     */
    //Dieser Code sollte die einzelenen Roboter in Spalte 2 formatieren nicht mer in use
    
    private JPanel aktualisiereRoboterPanel(Roboter roboter) {
    JPanel panel = new JPanel(new GridLayout(4, 1));
    JLabel nameLabel = new JLabel("<html><b>" +    roboter.gibName() + "</b></html>");
    JLabel statusLabel = new JLabel("  Status: Aktiv");
    JLabel warteschlangeLabel = new JLabel("  Warteschlange: " + roboter.gibWarteschlange().size());

    panel.add(nameLabel);
    panel.add(statusLabel);
    panel.add(warteschlangeLabel);

    System.out.println("\n\nAktualisiere Roboter " + roboter.gibName() + "\nWS: " + roboter.gibWarteschlange().size());

    panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    return panel;
    }
    
    
    

    /**
     * Dieser Code soll aus der Bestellungsliste die einzelnen Bestellungen als Panels einblenden
     */ 
    
    private JPanel aktualisiereBestellungPanel() {
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    //JLabel titleLabel = new JLabel("Bestellungen");
    //panel.add(titleLabel);

    // Create panels for each order
    this.bestellungenList = fabrik.gibBestellungsList();
    for (Bestellung bestellung : bestellungenList) {
        JPanel orderPanel = new JPanel();
        orderPanel.setLayout(new BoxLayout(orderPanel, BoxLayout.Y_AXIS));

        String status = "";
        if(bestellung.gibAlleProdukteProduziert()){
            status = "Fertig";
        }else{
            status = "In Arbeit";
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
        aktualisiereColumnBestellungen();
        aktualisiereColumnRoboterstatus();
        // Add other update methods if needed
    }

    



    
    /*
    // Methode um Bestellungen zu Printen neu angelegt während dem Sprint,
    private void BestellungenAusgeben(){
        columnsPanel.removeAll();
        this.bestellungenList = fabrik.gibBestellungsList();
        for (Bestellung bestellung : bestellungenList) {
            JLabel label = new JLabel("Bestellung Nr. " + bestellung.gibBestellungsNr() + "Anzahl Stühle: " + bestellung.gibAnzahlStuehle() +
                    " | Anzahl Sofas: " + bestellung.gibAnzahlSofas());
            columnsPanel.add(label);
        }
        fenster.pack();
    }
    
    */
    
    /// Methoden zu den Werten des Lagerbestandes

    private int getHolzValue() {
        return this.lager.gibvorhandeneHolzeinheiten();
    }

    private int getSchraubenValue() {
        return this.lager.gibvorhandeneSchrauben();
    }

    private int getKissenValue() {
        return this.lager.gibvorhandeneKissen();
    }

    private int getFarbeValue() {
        return this.lager.gibvorhandeneFarbeeinheiten();
    }

    private int getKartonValue() {
        return this.lager.gibvorhandeneKartoneinheiten();
    }

    /* Das da unten ist falsch, LG Flo.

    /// Methoden zu den Werten der Bestellungen
    private int getChairsValue(int bestellungNr) {
        // Implement logic to get number of chairs for the given Bestellung
        return 10 * bestellungNr;
    }

    private int getSofasValue(int bestellungNr) {
        // Implement logic to get number of sofas for the given Bestellung
        return 5 * bestellungNr;
    }

    private String getStatusValue(int bestellungNr) {
        // Implement logic to get status for the given Bestellung
        return "In Progress";
    }


    


    //public static void main(String[] args) {
    // Create and display the GUI
    //    SwingUtilities.invokeLater(() -> new GUI());
    //}
    */


    // /**
    //  * Methode zur Veränderung der Zeit um den im Input angegebenen Faktor.
    //  * 
    //  */
    // public void beeinflusseZeit(int faktor){
    //     fabrik.beeinflusseZeit(faktor);
    // }


    public static void main(String[] args) {
        // GUI erstellen und sichtbar machen
        SwingUtilities.invokeLater(() -> {
            GUI gui = new GUI();
            gui.setVisible(false);

            // Timer, damit die Fenster jede Millisekunde updaten
            Timer timer = new Timer(1, e -> gui.aktualisiereFenster());
            timer.setRepeats(true); // true, damit sich das wiederholt
            timer.start();
        });
    }



    /**
     * Die Klasse "TeamActionListener" erstellt ein neues Fenster sobald über
     * das JMenu Karriere angewählt wird. 
     */
    class TeamActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            fenster = new JFrame("Sofa");
            teamFenster();
        }
        
        protected void teamFenster() 
        {
            fenster.setContentPane(new BackGroundPane("UnserTeam.png"));
            guiSettings(fenster, 720, 405);
        }
    }
   
   /**
     * Die Klasse "SofaActionListener" erstellt ein neues Fenster sobald über
     * das JMenu Karriere angewählt wird. 
     */
    class SofaActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            fenster = new JFrame("Sofa");
            sofaFenster();
        }
        
        protected void sofaFenster() 
        {
            fenster.setContentPane(new BackGroundPane("Sofa.png"));
            guiSettings(fenster, 600, 505);
        }
    }
   
    /**
     * Die Klasse "StuhlActionListener" erstellt ein neues Fenster sobald über
     * das JMenu Karriere angewählt wird. 
     */
    class StuhlActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            fenster = new JFrame("Stuhl");
            stuhlFenster();
        }
        
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
        
        protected void paintComponent(Graphics g) 
        {
            super.paintComponent(g);
            g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
        }
    }
    
    private void guiSettings(JFrame fenster, int laenge, int breite){
        fenster.setLayout(null);
        fenster.setSize(laenge, breite);
        fenster.setResizable(false);
        fenster.setVisible(true);
    }

}