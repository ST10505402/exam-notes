package templates.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * TEMPLATE: complete GUI question (exam Question 2), hand-coded.
 *
 * Using the NetBeans GUI builder instead? Drag on the same controls, rename them to
 * the names below, create an actionPerformed handler for each button / menu item,
 * and make each handler call ONE of the helper methods (processReport, saveReport,
 * loadReport, clearForm). Copy the helper methods into the form's Source view.
 */
public class MovieTicketForm extends JFrame {

    private static final String FILE_NAME = "report.txt";

    // ---------- Controls (use these names in the GUI builder too) ----------
    private final JComboBox<String> cboMovie =
            new JComboBox<>(new String[] {"Napoleon", "Oppenheimer", "Damsel"});
    private final JTextField txtTickets = new JTextField(10);
    private final JTextField txtPrice = new JTextField(10);
    private final JCheckBox chkSnack = new JCheckBox("Add snack combo");
    private final JTextArea txaReport = new JTextArea(10, 35);
    private final JLabel lblStatus = new JLabel("Records loaded: 0");
    private final JButton btnProcess = new JButton("Process");
    private final JButton btnSave = new JButton("Save");

    private final MovieTickets logic = new MovieTickets();

    public MovieTicketForm() {
        super("Movie Tickets");
        txaReport.setEditable(false);                 // read-only text area
        buildMenu();
        buildLayout();

        // Buttons and menu items call the SAME helper methods (code efficiency marks)
        btnProcess.addActionListener(e -> processReport());
        btnSave.addActionListener(e -> saveReport());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);                  // centre on screen
    }

    // File > Exit ; Tools > Process, Save, Load, Clear
    private void buildMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu mnuFile = new JMenu("File");
        JMenuItem mniExit = new JMenuItem("Exit");
        mniExit.addActionListener(e -> System.exit(0));
        mnuFile.add(mniExit);

        JMenu mnuTools = new JMenu("Tools");
        JMenuItem mniProcess = new JMenuItem("Process");
        JMenuItem mniSave = new JMenuItem("Save");
        JMenuItem mniLoad = new JMenuItem("Load");
        JMenuItem mniClear = new JMenuItem("Clear");
        mniProcess.addActionListener(e -> processReport());
        mniSave.addActionListener(e -> saveReport());
        mniLoad.addActionListener(e -> loadReport());
        mniClear.addActionListener(e -> clearForm());
        mnuTools.add(mniProcess);
        mnuTools.add(mniSave);
        mnuTools.add(mniLoad);
        mnuTools.addSeparator();
        mnuTools.add(mniClear);

        menuBar.add(mnuFile);
        menuBar.add(mnuTools);
        setJMenuBar(menuBar);                          // setJMenuBar, not add()
    }

    // Labels + inputs in a grid at the top, report in the centre
    private void buildLayout() {
        JPanel pnlInput = new JPanel(new GridLayout(5, 2, 5, 5));
        pnlInput.add(new JLabel("Movie:"));
        pnlInput.add(cboMovie);
        pnlInput.add(new JLabel("Number of tickets:"));
        pnlInput.add(txtTickets);
        pnlInput.add(new JLabel("Ticket price:"));
        pnlInput.add(txtPrice);
        pnlInput.add(chkSnack);
        pnlInput.add(lblStatus);
        pnlInput.add(btnProcess);
        pnlInput.add(btnSave);

        add(pnlInput, BorderLayout.NORTH);
        add(new JScrollPane(txaReport), BorderLayout.CENTER);
    }

    // ---------- Helper methods (copy these into a GUI-builder form) ----------

    // Read inputs, validate, calculate, display
    private void processReport() {
        String movie = (String) cboMovie.getSelectedItem();
        int tickets;
        double price;
        try {
            tickets = Integer.parseInt(txtTickets.getText().trim());
            price = Double.parseDouble(txtPrice.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Tickets and price must be numbers.");
            return;
        }

        TicketData data = new TicketData(movie, tickets, price);
        if (!logic.ValidateData(data)) {
            JOptionPane.showMessageDialog(this,
                    "Select a movie; tickets and price must be greater than 0.");
            return;
        }

        double total = logic.CalculateTotalTicketPrice(tickets, price);
        boolean snack = chkSnack.isSelected();

        txaReport.setText("MOVIE TICKET REPORT\n"
                + "*************************\n"
                + "Movie: " + movie + "\n"
                + "Tickets: " + tickets + "\n"
                + String.format("Ticket price: R %.2f%n", price)
                + "Snack combo: " + (snack ? "Yes" : "No") + "\n"
                + String.format("Total (incl. VAT): R %.2f%n", total)
                + "*************************");
    }

    // Save the text area to a file (use new FileWriter(FILE_NAME, true) to append instead)
    private void saveReport() {
        if (txaReport.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nothing to save - process a report first.");
            return;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write(txaReport.getText());
            JOptionPane.showMessageDialog(this, "Saved to " + FILE_NAME);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Could not save: " + e.getMessage());
        }
    }

    // Load the file into the text area and count the lines
    private void loadReport() {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
                count++;
            }
            txaReport.setText(sb.toString());
            lblStatus.setText("Records loaded: " + count);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, FILE_NAME + " does not exist yet.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Could not read: " + e.getMessage());
        }
    }

    // Reset every control
    private void clearForm() {
        cboMovie.setSelectedIndex(0);
        txtTickets.setText("");
        txtPrice.setText("");
        chkSnack.setSelected(false);
        txaReport.setText("");
        lblStatus.setText("Records loaded: 0");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MovieTicketForm().setVisible(true));
    }
}
