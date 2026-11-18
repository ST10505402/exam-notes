package memos.mock1.q2;

import java.awt.*;
import java.io.*;
import javax.swing.*;

/**
 * Mock 1 Q2 - Kasi Shine Car Wash form, hand-coded so it runs on its own. In the exam, build the same controls with the GUI builder (same variable names) and copy the helper methods into your form.
 */
public class CarWashForm extends JFrame {
    private static final String FILE_NAME = "bookings.txt";
    private final JComboBox<String> cboWashType = new JComboBox<>(new String[] {"Basic", "Full", "Valet"});
    private final JTextField txtCustomerName = new JTextField(15);
    private final JTextField txtVehicles = new JTextField(5);
    private final JCheckBox chkTyreShine = new JCheckBox("Tyre shine (+R25 per vehicle)");
    private final JTextArea txaReport = new JTextArea(10, 40);
    private final JLabel lblBookingsLoaded = new JLabel("Bookings loaded: 0");
    private final JButton btnProcess = new JButton("Process Booking");
    private final JButton btnSave = new JButton("Save Booking");

    private final CarWash carWash = new CarWash();
    private String lastBookingRecord = null;

    public CarWashForm() {
        super("Kasi Shine Car Wash");
        txaReport.setEditable(false);
        JMenuBar bar = new JMenuBar();
        JMenu mnuFile = new JMenu("File");
        JMenu mnuTools = new JMenu("Tools");
        JMenuItem mniExit = new JMenuItem("Exit");
        JMenuItem mniProcess = new JMenuItem("Process Booking");
        JMenuItem mniSave = new JMenuItem("Save Booking");
        JMenuItem mniLoad = new JMenuItem("Load Bookings");
        JMenuItem mniClear = new JMenuItem("Clear");
        mnuFile.add(mniExit);
        mnuTools.add(mniProcess); mnuTools.add(mniSave); mnuTools.add(mniLoad); mnuTools.add(mniClear);
        bar.add(mnuFile); bar.add(mnuTools); setJMenuBar(bar);
        mniExit.addActionListener(e -> System.exit(0));
        mniProcess.addActionListener(e -> processBooking());
        btnProcess.addActionListener(e -> processBooking());
        mniSave.addActionListener(e -> saveBooking());
        btnSave.addActionListener(e -> saveBooking());
        mniLoad.addActionListener(e -> loadBookings());
        mniClear.addActionListener(e -> clearForm());
        JPanel pnl = new JPanel(new GridLayout(5, 2, 5, 5));
        pnl.add(new JLabel("Customer name:")); pnl.add(txtCustomerName);
        pnl.add(new JLabel("Wash type:")); pnl.add(cboWashType);
        pnl.add(new JLabel("Number of vehicles:")); pnl.add(txtVehicles);
        pnl.add(chkTyreShine); pnl.add(lblBookingsLoaded);
        pnl.add(btnProcess); pnl.add(btnSave);
        add(pnl, BorderLayout.NORTH);
        add(new JScrollPane(txaReport), BorderLayout.CENTER);
        setDefaultCloseOperation(EXIT_ON_CLOSE); pack(); setLocationRelativeTo(null);
    }

    void processBooking() {
        String name = txtCustomerName.getText().trim();
        String washType = (String) cboWashType.getSelectedItem();
        boolean tyreShine = chkTyreShine.isSelected();
        int vehicles;
        try {
            vehicles = Integer.parseInt(txtVehicles.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Number of vehicles must be a whole number.");
            return;
        }
        BookingData data = new BookingData(name, washType, vehicles);
        if (!carWash.ValidateData(data)) {
            JOptionPane.showMessageDialog(this,
                "Invalid booking: enter a customer name, choose a wash type and book 1 to 10 vehicles.");
            return;
        }
        double subtotal = carWash.CalculateSubtotal(washType, vehicles, tyreShine);
        double discount = carWash.CalculateDiscount(subtotal, vehicles);
        double total = subtotal - discount;
        txaReport.setText(buildReport(name, washType, vehicles, tyreShine, subtotal, discount, total));
        lastBookingRecord = String.format("%s,%s,%d,%s,%.2f", name, washType, vehicles, tyreShine ? "Yes" : "No", total);
    }

    static String buildReport(String name, String washType, int vehicles, boolean tyreShine,
                              double subtotal, double discount, double total) {
        return "KASI SHINE CAR WASH BOOKING\n"
             + "*****************************\n"
             + "Customer: " + name + "\n"
             + "Wash type: " + washType + "\n"
             + "Vehicles: " + vehicles + "\n"
             + "Tyre shine: " + (tyreShine ? "Yes" : "No") + "\n"
             + String.format("Subtotal: R %.2f%n", subtotal)
             + String.format("Discount (10%%): R %.2f%n", discount)
             + String.format("Total due: R %.2f%n", total)
             + "*****************************";
    }

    void saveBooking() {
        if (lastBookingRecord == null) {
            JOptionPane.showMessageDialog(this, "Process a booking before saving.");
            return;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(lastBookingRecord);
            writer.newLine();
            JOptionPane.showMessageDialog(this, "Booking saved to " + FILE_NAME);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Could not save booking: " + e.getMessage());
        }
    }

    void loadBookings() {
        StringBuilder report = new StringBuilder("SAVED BOOKINGS\n");
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] f = line.split(",");
                if (f.length == 5) {
                    report.append(formatLine(f)).append("\n");
                    count++;
                }
            }
            txaReport.setText(report.toString());
            lblBookingsLoaded.setText("Bookings loaded: " + count);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "No bookings have been saved yet.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Could not read bookings: " + e.getMessage());
        }
    }

    static String formatLine(String[] f) {
        return f[0] + " | " + f[1] + " | " + f[2] + " vehicle(s) | Tyre shine: " + f[3] + " | R " + f[4];
    }

    void clearForm() {
        txtCustomerName.setText("");
        txtVehicles.setText("");
        cboWashType.setSelectedIndex(0);
        chkTyreShine.setSelected(false);
        txaReport.setText("");
        lblBookingsLoaded.setText("Bookings loaded: 0");
        lastBookingRecord = null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CarWashForm().setVisible(true));
    }
}
