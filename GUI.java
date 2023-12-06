import java.awt.*;
import javax.swing.*;

public class GUI extends JFrame {
    private final GUI_Controller controller;
    private JFrame fenster;
    private JPanel lagerbestandPanel = new JPanel();
    private JPanel columnsPanel = new JPanel(new GridLayout(1, 3)); // Use GridLayout with 1 row and 3 columns
    

    public GUI(GUI_Controller controller) {
        this.controller = controller;
        initFenster();
    }

    private void initFenster() {
        fenster = new JFrame("AEKI Übersicht");
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenster.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fenster.setUndecorated(false);

        // Create a main panel to hold the components
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Lagerbestand panel always on top
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

        mainPanel.add(lagerbestandPanel, BorderLayout.NORTH);

        // Left panel with three buttons
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        JButton button1 = new JButton("Bestellung Aufgeben");
        button1.addActionListener(e -> {
            // Handle Button 1 action
            JOptionPane.showMessageDialog(fenster, "Button 1 pressed");
        });
        leftPanel.add(button1);

        JButton button2 = new JButton("Button 2");
        button2.addActionListener(e -> {
            // Handle Button 2 action
            JOptionPane.showMessageDialog(fenster, "Button 2 pressed");
        });
        leftPanel.add(button2);

        JButton button3 = new JButton("Button 3");
        button3.addActionListener(e -> {
            // Handle Button 3 action
            JOptionPane.showMessageDialog(fenster, "Button 3 pressed");
        });
        leftPanel.add(button3);

        mainPanel.add(leftPanel, BorderLayout.WEST);

        // Set up the menu bar
        JMenuBar menuBar = new JMenuBar();
        fenster.setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JMenuItem option1 = new JMenuItem("Option 1");
        option1.addActionListener(e -> {
            // Handle Option 1 action
            JOptionPane.showMessageDialog(fenster, "Option 1 selected");
        });
        fileMenu.add(option1);

        JMenuItem option2 = new JMenuItem("Option 2");
        option2.addActionListener(e -> {
            // Handle Option 2 action
            JOptionPane.showMessageDialog(fenster, "Option 2 selected");
        });
        fileMenu.add(option2);

        JMenuItem option3 = new JMenuItem("Option 3");
        option3.addActionListener(e -> {
            // Handle Option 3 action
            JOptionPane.showMessageDialog(fenster, "Option 3 selected");
        });
        fileMenu.add(option3);

        // Three columns below Lagerbestand and right of the buttons
        JPanel bestellungenPanel = new JPanel(new BorderLayout());
        bestellungenPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JLabel bestellungenLabel = new JLabel("Bestellungen");
        bestellungenPanel.add(bestellungenLabel, BorderLayout.NORTH);

        // Log panel for Bestellungen
        JPanel bestellungenLogPanel = new JPanel();
        bestellungenLogPanel.setLayout(new BoxLayout(bestellungenLogPanel, BoxLayout.Y_AXIS));

        for (int i = 1; i <= 5; i++) {
            JPanel orderPanel = createBestellungPanel(i, getChairsValue(i), getSofasValue(i), getStatusValue(i)); // Insert function calls here
            bestellungenLogPanel.add(orderPanel);
        }

        JScrollPane bestellungenLogScrollPane = new JScrollPane(bestellungenLogPanel);
        bestellungenPanel.add(bestellungenLogScrollPane, BorderLayout.CENTER);

        columnsPanel.add(bestellungenPanel);

        // Four permanent panels in the "Roboter Status" column
        JPanel roboterStatusPanel = new JPanel(new BorderLayout());
        roboterStatusPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel roboterStatusLabel = new JLabel("Roboter Status");
        roboterStatusPanel.add(roboterStatusLabel, BorderLayout.NORTH);

        JPanel roboterInnerPanel = new JPanel(new GridLayout(4, 1));

        for (int i = 1; i <= 4; i++) {
            JPanel robotPanel = createRoboterPanel("Roboter " + i, "Active", 2, "Stuhl");
            roboterInnerPanel.add(robotPanel);
        }

        roboterStatusPanel.add(roboterInnerPanel, BorderLayout.CENTER);

        columnsPanel.add(roboterStatusPanel);

        // Status-Updates panel with log messages
        JPanel statusUpdatesPanel = new JPanel(new BorderLayout());
        statusUpdatesPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel statusUpdatesLabel = new JLabel("Status-Updates");
        statusUpdatesPanel.add(statusUpdatesLabel, BorderLayout.NORTH);

        JTextArea logTextArea = new JTextArea();
        logTextArea.setEditable(false);

        // Add test messages
        for (int i = 1; i <= 5; i++) {
            logTextArea.append("Test Message " + i + "\n");
        }

        JScrollPane logScrollPane = new JScrollPane(logTextArea);
        statusUpdatesPanel.add(logScrollPane, BorderLayout.CENTER);

        columnsPanel.add(statusUpdatesPanel);

        mainPanel.add(columnsPanel, BorderLayout.CENTER);

        // Set up the frame
        fenster.add(mainPanel);
        fenster.setSize(800, 400);
        fenster.setLocationRelativeTo(null);
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenster.setVisible(true);
    }

    private JPanel createRoboterPanel(String name, String status, int warteschlange, String produktion) {
        JPanel panel = new JPanel(new GridLayout(4, 1));
        JLabel nameLabel = new JLabel("Robotername: " + name);
        JLabel statusLabel = new JLabel("Status: " + status);
        JLabel warteschlangeLabel = new JLabel("Warteschlange: " + warteschlange);
        JLabel produktionLabel = new JLabel("Produktion: " + produktion);

        panel.add(nameLabel);
        panel.add(statusLabel);
        panel.add(warteschlangeLabel);
        panel.add(produktionLabel);

        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        return panel;
    }

    private JPanel createBestellungPanel(int bestellungNr, int chairs, int sofas, String status) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Bestellungsnr. " + bestellungNr);
        JLabel infoLabel = new JLabel("Number of chairs: " + chairs + " | Number of sofas: " + sofas + " | Status: " + status);

        panel.add(titleLabel);
        panel.add(infoLabel);

        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        return panel;
    }

    // Insert functions for Lagerbestand values here
    private String getHolzValue() {
        //Lager.gibvorhandeneHolzeinheiten();
        return "100";
    }

    private String getSchraubenValue() {
        // Implement logic to get Schrauben value
        return "500";
    }

    private String getKissenValue() {
        // Implement logic to get Kissen value
        return "50";
    }

    private String getFarbeValue() {
        // Implement logic to get Farbe value
        return "800";
    }

    private String getKartonValue() {
        // Implement logic to get Karton value
        return "900";
    }

    // Insert functions for Bestellungen values here
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GUI(null);
        });
    }
}
