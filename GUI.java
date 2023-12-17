import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList; 

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
    private JPanel leftPanel;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    

    private Fabrik fabrik;
    private Lager lager;
    private List<Bestellung> bestellungenList;

    private Main main;



    /**
     * Konstruktor für Objekte der Klasse GUI
     */
    public GUI() {

        bestellungenList = new ArrayList<>();
        main = new Main();

        // Aus der Main Methode
        this.fabrik = main.gibFabrik(); 
        this.lager = main.gibLager();
        //fabrik.erstelleMurmeltier();


        initFenster(this.fabrik, this.lager); // Initialisierung des Hauptfensters
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
    private void initFenster(Fabrik fabrik, Lager lager) {

        // Gesamtfenster
        fenster = new JFrame("AEKI Übersicht");
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenster.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fenster.setUndecorated(false);

        // Obiges Subfenster mit vor allem Lagerbestand
        mainPanel = new JPanel(new BorderLayout());        
        lagerbestandPanel = new JPanel(); // Erstellung des Fensters mit dem Lagerbestand
        mainPanel.add(lagerbestandPanel, BorderLayout.NORTH); // Wird dem obigen Subfenster hinzugefügt
        konfiguriereLagerbestand();

        /// 3 Subfenster im Zentrum ("Bestellungen", "Roboter Status", "Status-Updates")
        columnsPanel = new JPanel(new GridLayout(1, 3)); 
        konfiguriereSubfensterZentrum();

        // Linke Leiste mit drei Knöpfen
        leftPanel = new JPanel();
        konfiguriereLinkeLeisteKnoepfe();

        /// Menüleiste
        menuBar = new JMenuBar();
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
     * Konfigurierung des Lagerbestandes
     */
    private void konfiguriereLagerbestand(){
        
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
    }

    /**
     * Konfigurierung der Subfenster im Zentrum
     */
    private void konfiguriereSubfensterZentrum(){
        
        // Three columns below Lagerbestand and right of the buttons
        JPanel bestellungenPanel = new JPanel(new BorderLayout());
        bestellungenPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.BLACK),
            BorderFactory.createEmptyBorder(10, 10, 0, 10))); // Fügen Sie den leeren Border hinzu
        JLabel bestellungenLabel = new JLabel("Bestellungen");
        bestellungenPanel.add(bestellungenLabel, BorderLayout.NORTH);

        // Fenster für Bestellungen
        JPanel bestellungenLogPanel = createBestellungPanel(fabrik.gibBestellungsList());
        JScrollPane bestellungenLogScrollPane = new JScrollPane(bestellungenLogPanel);
        bestellungenPanel.add(bestellungenLogScrollPane, BorderLayout.CENTER);

        columnsPanel.add(bestellungenPanel);
        

        String result = fabrik.bestellungenAusgeben();

        JLabel label = new JLabel(result);
        bestellungenLogPanel.add(label);

        // bestellungenLogPanel.removeAll();
        // for(Produkt produkt: this.laden.gibProdukte()){
        //     JLabel label = new JLabel("Produkt-Name: " + produkt.gibName() + " hat Preis " + produkt.gibPreis());
        //     bestellungenLogPanel.add(label);
        // }
        // fenster.pack(); // Fenster wird geladen

        // Fenster "Roboter Status"
        JPanel roboterStatusPanel = new JPanel(new BorderLayout());
        roboterStatusPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.BLACK),
            BorderFactory.createEmptyBorder(10, 10, 0, 10))); // Fügen Sie den leeren Border hinzu

        JLabel roboterStatusLabel = new JLabel("Roboter Status");
        roboterStatusPanel.add(roboterStatusLabel, BorderLayout.NORTH);

        JPanel roboterInnerPanel = new JPanel(new GridLayout(4, 1));
       
        for (int i = 1; i <= 4; i++) {
            JPanel robotPanel = createRoboterPanel("Roboter " + i, "Active", 2, "Stuhl");
            roboterInnerPanel.add(robotPanel);
        }

        roboterStatusPanel.add(roboterInnerPanel, BorderLayout.CENTER);

        columnsPanel.add(roboterStatusPanel);

        // Fenster "Status-Updates"
        JPanel statusUpdatesPanel = new JPanel(new BorderLayout());
        statusUpdatesPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.BLACK),
            BorderFactory.createEmptyBorder(10, 10, 0, 10))); // Fügen Sie den leeren Border hinzu

        JLabel statusUpdatesLabel = new JLabel("Status-Updates");
        statusUpdatesPanel.add(statusUpdatesLabel, BorderLayout.NORTH);

        JTextArea logTextArea = new JTextArea();
        logTextArea.setEditable(false);

        // Add test messages
        for (int i = 1; i <= 5; i++) {
            logTextArea.append("Test Message " + i + "\n");
        }

        //    private void updateLagerbestandGUI() {
        //int[] lagerbestand = this.lager.gibLagerbestand();
        
        //Label aktuellerLagerstatus = new Label("Status: Normal");
        //aktuellerLagerstatus.setTextFill(Color.rgb(0, 128, 0));
        //if(lager.wartetAufLieferant()) {
            //aktuellerLagerstatus.setText("Status: Wird belieftert...");
           // aktuellerLagerstatus.setTextFill(Color.rgb(128, 0, 0));
        //}
        
        JScrollPane logScrollPane = new JScrollPane(logTextArea);
        statusUpdatesPanel.add(logScrollPane, BorderLayout.CENTER);

        columnsPanel.add(statusUpdatesPanel);

        mainPanel.add(columnsPanel, BorderLayout.CENTER);
    }

    /**
     * Konfigurierung der Linken Leiste mit den Knöpfen
     */
    private void konfiguriereLinkeLeisteKnoepfe(){
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

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

        JButton button2 = new JButton("Bestellungen Ausgeben");
        button2.setMaximumSize(new Dimension(200, 30));
        button2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleBestellungenAusgeben();
                }
            });
        leftPanel.add(button2);

        JButton button3 = new JButton("Übersicht Lieferant");
        button3.setMaximumSize(new Dimension(200, 30));
        button3.addActionListener(e -> {
                    // Handle Button 3 action
                    displayInformationPanel();
            });
        leftPanel.add(button3);

        mainPanel.add(leftPanel, BorderLayout.WEST);
    }

    /**
     * Konfigurierung der Menüleiste
     */
    private void konfiguriereMenueleiste(){

        fenster.setJMenuBar(menuBar);

        fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        // Option 1 "Refresh" ->
        JMenuItem option1 = new JMenuItem("Refresh");
        option1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleOption1();
                }
            });

        fileMenu.add(option1);


        // Option 2 "" ->
        JMenuItem option2 = new JMenuItem("Option 2");
        option2.addActionListener(e -> {
                    // Handle Option 2 action
                    JOptionPane.showMessageDialog(fenster, "Option 2 selected");
            });
        fileMenu.add(option2);

        // Option 3 "" ->
        JMenuItem option3 = new JMenuItem("Option 3");
        option3.addActionListener(e -> {
                    // Handle Option 3 action
                    JOptionPane.showMessageDialog(fenster, "Option 3 selected");
            });
        fileMenu.add(option3);
    }

    private void handleBestellungAufgeben() {
        System.out.println("Button 'Bestellung Aufgeben' clicked"); // Debug print

        String sofasInput = JOptionPane.showInputDialog(GUI.this, "Bitte geben Sie die Anzahl Sofas an, welche Sie bestellen möchten:");
        String stühleInput = JOptionPane.showInputDialog(GUI.this, "Bitte geben Sie die Anzahl Stühle an, welche Sie bestellen möchten:");

        try {
            int stühle = Integer.parseInt(stühleInput);
            int sofas = Integer.parseInt(sofasInput);

            System.out.println("Calling fabrik.bestellungAufgeben with sofas: " + sofas + " and stühle: " + stühle); // Debug print

            // Call the fabrik.bestellungAufgeben method with the entered values
            // String result = fabrik.bestellungAufgeben(sofas, stühle);
            // String result = main.befehleSchleife("best " + sofas + " " + stühle);
            // String result = main.befehle("best " + sofas + " " + stühle);
            String result = fabrik.bestellungAufgeben(sofas, stühle);

            // fenster.pack();


            // System.out.println("Result from fabrik.bestellungAufgeben: " + result); // Debug print
            // System.out.println("Result from fabrik.bestellungAufgeben: "); // Debug print
            // Display the result
            JOptionPane.showMessageDialog(GUI.this, result);
            // JOptionPane.showMessageDialog(GUI.this);
            // JOptionPane.showMessageDialog(GUI.this, "It worked!");

            // Update the Bestellungen column
            updateBestellungenPanel();
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
        updateBestellungenPanel();
        
        // fenster.pack(); // Fenster wird geladen

        // Display the result
        JOptionPane.showMessageDialog(GUI.this, result);
    }

    private void handleOption1() {
        // Implement the logic for Option 1
        // For demonstration purposes, let's assume Option 1 updates some values in the Fabrik
        // and then we want to update the GUI to reflect these changes.
        //fabrik.updateSomeValues(); // You need to implement this method in your Fabrik class.

        // Update the GUI to reflect changes
        updateGUI();
    }

    private void displayInformationPanel() {
        // Create a new JFrame for the information panel
        JFrame informationFrame = new JFrame("Lieferant Information");
        informationFrame.setSize(400, 300);
        informationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create a panel for the information content
        JPanel informationPanel = new JPanel();
        informationPanel.setLayout(new BoxLayout(informationPanel, BoxLayout.Y_AXIS));

        // Add components for the information panel (customize this part)
        String infoText = "<html><br> Auf dieser Seite finden Sie den aktuellen Status des Lieferanten.<br><br>" +
            "Der Lieferant hat momentan genügend Material an Lager um eine Bestellung aufzunehmen.<br>"+
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

    private void updateGUI() {
        // Add logic here to update the GUI components that need to reflect changes in the Fabrik
        // For example, update labels with new values from Fabrik
        // ...
        this.bestellungenList = fabrik.gibBestellungsList();
        // Repaint the GUI
        revalidate();
        repaint();
    }

    private JPanel createRoboterPanel(String name, String status, int warteschlange, String produktion) {
        JPanel panel = new JPanel(new GridLayout(4, 1));
        JLabel nameLabel = new JLabel("  Robotername: " + name);
        JLabel statusLabel = new JLabel("  Status: " + status);
        JLabel warteschlangeLabel = new JLabel("  Warteschlange: " + warteschlange);
        JLabel produktionLabel = new JLabel("  Produktion: " + produktion);

        panel.add(nameLabel);
        panel.add(statusLabel);
        panel.add(warteschlangeLabel);
        panel.add(produktionLabel);

        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        return panel;
    }

    private JPanel createBestellungPanel(List<Bestellung> bestellungenList) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        //JLabel titleLabel = new JLabel("Bestellungen");
        //panel.add(titleLabel);

        // Create panels for each order
        for (Bestellung bestellung : bestellungenList) {
            JPanel orderPanel = new JPanel();
            orderPanel.setLayout(new BoxLayout(orderPanel, BoxLayout.Y_AXIS));

            JLabel orderLabel = new JLabel("Bestellung Nr. " + bestellung.gibBestellungsNr());
            JLabel infoLabel = new JLabel("Number of chairs: " + bestellung.gibAnzahlStuehle() +
                    " | Number of sofas: " + bestellung.gibAnzahlSofas() 
                        // +" | Status: " + bestellung.gibStatus()
                );

            orderPanel.add(orderLabel);
            orderPanel.add(infoLabel);

            orderPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            panel.add(orderPanel);
        }

        return panel;
    }

    
    /// Methoden zu den Werten des Lagerbestandes

    private int getHolzValue() {
        return lager.gibvorhandeneHolzeinheiten();
    }

    private int getSchraubenValue() {
        return lager.gibvorhandeneSchrauben();
    }

    private int getKissenValue() {
        return lager.gibvorhandeneKissen();
    }

    private int getFarbeValue() {
        return lager.gibvorhandeneFarbeeinheiten();
    }

    private int getKartonValue() {
        return lager.gibvorhandeneKartoneinheiten();
    }


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
}