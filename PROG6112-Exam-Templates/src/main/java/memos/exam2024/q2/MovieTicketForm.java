package memos.exam2024.q2;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
 * 2024 Q2 - Movie Tickets GUI.
 * Hand-coded so it runs on its own. In the exam, build the same controls with the
 * GUI builder (same variable names) and copy the helper methods into your form.
 */
public class MovieTicketForm extends JFrame {

    private static final String FILE_NAME = "report.txt";

    private final JComboBox<String> cboMovie =
            new JComboBox<>(new String[] {"Napoleon", "Oppenheimer", "Damsel"});
    private final JTextField txtNumberOfTickets = new JTextField(10);
    private final JTextField txtTicketPrice = new JTextField(10);
    private final JTextArea txaReport = new JTextArea(6, 30);

    private final MovieTickets movieTickets = new MovieTickets();

    public MovieTicketForm() {
        super("MOVIE TICKETS");
        txaReport.setEditable(false);                       // Q2.1 read-only text area

        // Q2.2 menu: File > Exit ; Tools > Process, Clear
        JMenuBar menuBar = new JMenuBar();
        JMenu mnuFile = new JMenu("File");
        JMenuItem mniExit = new JMenuItem("Exit");
        mniExit.addActionListener(e -> System.exit(0));     // Q2.3
        mnuFile.add(mniExit);
        JMenu mnuTools = new JMenu("Tools");
        JMenuItem mniProcess = new JMenuItem("Process");
        JMenuItem mniClear = new JMenuItem("Clear");
        mniProcess.addActionListener(e -> processReport());
        mniClear.addActionListener(e -> clearForm());
        mnuTools.add(mniProcess);
        mnuTools.add(mniClear);
        menuBar.add(mnuFile);
        menuBar.add(mnuTools);
        setJMenuBar(menuBar);

        JPanel pnlInput = new JPanel(new GridLayout(4, 2, 5, 8));
        pnlInput.add(new JLabel("MOVIE:"));
        pnlInput.add(cboMovie);
        pnlInput.add(new JLabel("NUMBER OF TICKETS:"));
        pnlInput.add(txtNumberOfTickets);
        pnlInput.add(new JLabel("TICKET PRICE:"));
        pnlInput.add(txtTicketPrice);
        pnlInput.add(new JLabel("TICKET REPORT:"));
        add(pnlInput, BorderLayout.NORTH);
        add(new JScrollPane(txaReport), BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    // Q2.4 + Q2.5: capture, validate, display the report, then save it
    void processReport() {
        String movieName = (String) cboMovie.getSelectedItem();
        int numberOfTickets;
        double ticketPrice;
        try {
            numberOfTickets = Integer.parseInt(txtNumberOfTickets.getText().trim());
            ticketPrice = Double.parseDouble(txtTicketPrice.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Number of tickets and ticket price must be numbers.");
            return;
        }

        MovieTicketData data = new MovieTicketData(movieName, numberOfTickets, ticketPrice);
        if (!movieTickets.ValidateData(data)) {
            JOptionPane.showMessageDialog(this,
                    "Invalid data: select a movie; tickets and price must be greater than 0.");
            return;
        }

        double total = movieTickets.CalculateTotalTicketPrice(numberOfTickets, ticketPrice);
        txaReport.setText(buildReport(movieName, numberOfTickets, ticketPrice, total));
        saveReport();
    }

    // Report lines exactly as the sample screenshot ("R 100.0" = default double printing)
    static String buildReport(String movieName, int numberOfTickets, double ticketPrice, double total) {
        return "MOVIE NAME: " + movieName + "\n"
                + "MOVIE TICKET PRICE: R " + ticketPrice + "\n"
                + "NUMBER OF TICKETS: " + numberOfTickets + "\n"
                + "TOTAL TICKET PRICE: R " + total;
    }

    // Q2.5: report.txt = heading + stars + report + stars
    private void saveReport() {
        String stars = "*".repeat(35);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write("MOVIE TICKET REPORT");
            writer.newLine();
            writer.write(stars);
            writer.newLine();
            writer.write(txaReport.getText());
            writer.newLine();
            writer.write(stars);
            writer.newLine();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Could not save report: " + e.getMessage());
        }
    }

    // Q2.6: back to the default state
    void clearForm() {
        cboMovie.setSelectedIndex(0);
        txtNumberOfTickets.setText("");
        txtTicketPrice.setText("");
        txaReport.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MovieTicketForm().setVisible(true));
    }
}
