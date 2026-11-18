package templates.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

/**
 * TEMPLATE: 2022-style GUI question.
 * Combo boxes -> save to a sequential file -> load file into a JList.
 * Also: a fixed-size array with a maximum of 5 entries + error message,
 * and "start and end cannot be the same" validation.
 */
public class TravelForm extends JFrame {

    private static final String FILE_NAME = "travel.txt";
    private static final int MAX_TRIPS = 5;
    private static final String[] LOCATIONS = {"Cape Town", "Durban", "Port Elizabeth"};

    private final JComboBox<String> cboStart = new JComboBox<>(LOCATIONS);
    private final JComboBox<String> cboEnd = new JComboBox<>(LOCATIONS);
    private final JComboBox<String> cboTravelBy = new JComboBox<>(new String[] {"Airplane", "Train"});
    private final DefaultListModel<String> listModel = new DefaultListModel<>();
    private final JList<String> lstTrips = new JList<>(listModel);

    // Array storage with a counter (exam: "save to an array type of your choice")
    private final String[] trips = new String[MAX_TRIPS];
    private int tripCount = 0;

    public TravelForm() {
        super("Travel Planner");

        JButton btnSubmit = new JButton("Submit");
        JButton btnLoad = new JButton("Load");
        btnSubmit.addActionListener(e -> submitTrip());
        btnLoad.addActionListener(e -> loadTrips());

        // Menu: File > Exit ; Tools > Submit, Load, Clear
        JMenuBar bar = new JMenuBar();
        JMenu mnuFile = new JMenu("File");
        JMenuItem mniExit = new JMenuItem("Exit");
        mniExit.addActionListener(e -> System.exit(0));
        mnuFile.add(mniExit);
        JMenu mnuTools = new JMenu("Tools");
        JMenuItem mniSubmit = new JMenuItem("Submit");
        JMenuItem mniLoad = new JMenuItem("Load");
        JMenuItem mniClear = new JMenuItem("Clear");
        mniSubmit.addActionListener(e -> submitTrip());      // same logic as the button
        mniLoad.addActionListener(e -> loadTrips());
        mniClear.addActionListener(e -> clearForm());
        mnuTools.add(mniSubmit);
        mnuTools.add(mniLoad);
        mnuTools.add(mniClear);
        bar.add(mnuFile);
        bar.add(mnuTools);
        setJMenuBar(bar);

        JPanel pnlInput = new JPanel(new GridLayout(4, 2, 5, 5));
        pnlInput.add(new JLabel("Start location:"));
        pnlInput.add(cboStart);
        pnlInput.add(new JLabel("End location:"));
        pnlInput.add(cboEnd);
        pnlInput.add(new JLabel("Travel by:"));
        pnlInput.add(cboTravelBy);
        pnlInput.add(btnSubmit);
        pnlInput.add(btnLoad);

        add(pnlInput, BorderLayout.NORTH);
        add(new JScrollPane(lstTrips), BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 320);
        setLocationRelativeTo(null);
    }

    // Validate, store in the array, append to the file
    void submitTrip() {
        String start = (String) cboStart.getSelectedItem();
        String end = (String) cboEnd.getSelectedItem();
        String travelBy = (String) cboTravelBy.getSelectedItem();

        if (start.equals(end)) {
            JOptionPane.showMessageDialog(this, "Start and end location cannot be the same.",
                    "Invalid trip", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (tripCount >= MAX_TRIPS) {
            JOptionPane.showMessageDialog(this, "You cannot capture more than " + MAX_TRIPS + " trips.");
            return;
        }

        String record = start + "," + end + "," + travelBy;
        trips[tripCount] = record;
        tripCount++;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(record);
            writer.newLine();
            JOptionPane.showMessageDialog(this, "Trip saved (" + tripCount + " of " + MAX_TRIPS + ")");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Could not save: " + e.getMessage());
        }
    }

    // Read the file and populate the list box
    void loadTrips() {
        listModel.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] f = line.split(",");
                if (f.length == 3) {
                    listModel.addElement(f[0] + " to " + f[1] + " by " + f[2]);
                }
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "No trips saved yet.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Could not read: " + e.getMessage());
        }
    }

    void clearForm() {
        cboStart.setSelectedIndex(0);
        cboEnd.setSelectedIndex(0);
        cboTravelBy.setSelectedIndex(0);
        listModel.clear();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TravelForm().setVisible(true));
    }
}
