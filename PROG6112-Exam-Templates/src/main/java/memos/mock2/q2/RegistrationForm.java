package memos.mock2.q2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ButtonGroup;
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
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.JTextComponent;

/**
 * Mock 2 Q2 - Vaal Tech Expo 2027 registration form.
 * Hand-coded so it runs on its own. In the exam, build the same controls with the
 * GUI builder (same variable names) and copy the helper methods into your form.
 */
public class RegistrationForm extends JFrame {

    private static final String FILE_NAME = "registrations.txt";
    private static final int NAME_LIMIT = 30;
    private static final int REASON_LIMIT = 300;

    // ---------- Q2.1 controls ----------
    private final JTextField txtFirstName = new JTextField(15);
    private final JTextField txtSurname = new JTextField(15);
    private final JTextField txtEmail = new JTextField(15);
    private final JComboBox<String> cboTicketType =
            new JComboBox<>(new String[] {"-- Select --", "Student", "Standard", "VIP"});
    private final JRadioButton radOneDay = new JRadioButton("1 day");
    private final JRadioButton radTwoDays = new JRadioButton("2 days");
    private final ButtonGroup grpDays = new ButtonGroup();
    private final JCheckBox chkWorkshop = new JCheckBox("Add workshop (R100)");
    private final JTextArea txaReason = new JTextArea(4, 25);
    private final JLabel lblReasonCount = new JLabel("0 / 300 characters");
    private final JTextArea txaSummary = new JTextArea(10, 40);
    private final JLabel lblRegistrationsLoaded = new JLabel("Registrations loaded: 0");
    private final JButton btnRegister = new JButton("Register");
    private final JButton btnSave = new JButton("Save");

    private final Registration registration = new Registration();
    private String lastRecord = null;          // set by Register, written by Save
    private String lastFirstName = null;

    public RegistrationForm() {
        super("Vaal Tech Expo 2027 Registration");
        txaSummary.setEditable(false);
        txaReason.setLineWrap(true);
        txaReason.setWrapStyleWord(true);
        grpDays.add(radOneDay);                // neither selected at start
        grpDays.add(radTwoDays);

        // Q2.2 character limits + live counter
        limitCharacters(txtFirstName, NAME_LIMIT);
        limitCharacters(txtSurname, NAME_LIMIT);
        limitCharacters(txaReason, REASON_LIMIT);
        addCharacterCounter(txaReason, lblReasonCount, REASON_LIMIT);

        buildMenu();
        buildLayout();

        btnRegister.addActionListener(e -> registerAttendee());
        btnSave.addActionListener(e -> saveRegistration());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    // Q2.3 File > Exit ; Tools > Register, Save Registration, Load Registrations, Clear
    private void buildMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu mnuFile = new JMenu("File");
        JMenuItem mniExit = new JMenuItem("Exit");
        mniExit.addActionListener(e -> System.exit(0));
        mnuFile.add(mniExit);

        JMenu mnuTools = new JMenu("Tools");
        JMenuItem mniRegister = new JMenuItem("Register");
        JMenuItem mniSave = new JMenuItem("Save Registration");
        JMenuItem mniLoad = new JMenuItem("Load Registrations");
        JMenuItem mniClear = new JMenuItem("Clear");
        mniRegister.addActionListener(e -> registerAttendee());     // same logic as the button
        mniSave.addActionListener(e -> saveRegistration());
        mniLoad.addActionListener(e -> loadRegistrations());
        mniClear.addActionListener(e -> clearForm());
        mnuTools.add(mniRegister);
        mnuTools.add(mniSave);
        mnuTools.add(mniLoad);
        mnuTools.addSeparator();
        mnuTools.add(mniClear);

        menuBar.add(mnuFile);
        menuBar.add(mnuTools);
        setJMenuBar(menuBar);
    }

    private void buildLayout() {
        JPanel pnlDays = new JPanel(new GridLayout(1, 2));
        pnlDays.add(radOneDay);
        pnlDays.add(radTwoDays);

        JPanel pnlInput = new JPanel(new GridLayout(8, 2, 6, 6));
        pnlInput.add(new JLabel("First name *"));
        pnlInput.add(txtFirstName);
        pnlInput.add(new JLabel("Surname *"));
        pnlInput.add(txtSurname);
        pnlInput.add(new JLabel("Email address *"));
        pnlInput.add(txtEmail);
        pnlInput.add(new JLabel("Ticket type *"));
        pnlInput.add(cboTicketType);
        pnlInput.add(new JLabel("Days *"));
        pnlInput.add(pnlDays);
        pnlInput.add(chkWorkshop);
        pnlInput.add(lblRegistrationsLoaded);
        pnlInput.add(new JLabel("Reason for attending *"));
        pnlInput.add(lblReasonCount);
        pnlInput.add(btnRegister);
        pnlInput.add(btnSave);

        JPanel pnlCentre = new JPanel(new BorderLayout(6, 6));
        pnlCentre.add(new JScrollPane(txaReason), BorderLayout.NORTH);
        pnlCentre.add(new JScrollPane(txaSummary), BorderLayout.CENTER);

        add(pnlInput, BorderLayout.NORTH);
        add(pnlCentre, BorderLayout.CENTER);
    }

    // ---------- Q2.4 + Q2.5 Register ----------
    void registerAttendee() {
        String firstName = txtFirstName.getText().trim();
        String surname = txtSurname.getText().trim();
        String email = txtEmail.getText().trim();
        String ticketType = (String) cboTicketType.getSelectedItem();
        int days = radOneDay.isSelected() ? 1 : (radTwoDays.isSelected() ? 2 : 0);
        boolean workshop = chkWorkshop.isSelected();
        String reason = txaReason.getText().trim();

        // Field-by-field checks so the message and cursor point at the right field
        if (firstName.isEmpty()) {
            showError("First name is required.", txtFirstName);
            return;
        }
        if (surname.isEmpty()) {
            showError("Surname is required.", txtSurname);
            return;
        }
        if (!registration.ValidateEmail(email)) {
            showError("Enter a valid email address, e.g. name@example.com.", txtEmail);
            return;
        }
        if (cboTicketType.getSelectedIndex() == 0) {
            showError("Please select a ticket type.", null);
            cboTicketType.requestFocus();
            return;
        }
        if (days == 0) {
            showError("Please choose 1 day or 2 days.", null);
            return;
        }
        int words = registration.CountWords(reason);
        if (words < Registration.MIN_WORDS || words > Registration.MAX_WORDS) {
            showError("Your reason must be 5 to 50 words (you wrote " + words + ").", txaReason);
            return;
        }

        // Final check through the class (all rules in one place)
        RegistrationData data = new RegistrationData(firstName, surname, email, ticketType,
                days, workshop, reason);
        if (!registration.ValidateData(data)) {
            showError("Invalid registration.", null);
            return;
        }

        double subtotal = registration.CalculateSubtotal(ticketType, days, workshop);
        double discount = registration.CalculateDiscount(ticketType, subtotal);
        double total = subtotal - discount;

        txaSummary.setText(buildSummary(data, subtotal, discount, total));

        // Remember the record for Save
        lastRecord = String.format("%s,%s,%s,%s,%d,%s,%.2f", firstName, surname, email,
                ticketType, days, workshop ? "Yes" : "No", total);
        lastFirstName = firstName;
    }

    static String buildSummary(RegistrationData d, double subtotal, double discount, double total) {
        String stars = "*".repeat(32);
        return "VAAL TECH EXPO 2027 REGISTRATION\n"
                + stars + "\n"
                + "Name: " + d.getFirstName() + " " + d.getSurname() + "\n"
                + "Email: " + d.getEmail() + "\n"
                + "Ticket: " + d.getTicketType() + "\n"
                + "Days: " + d.getDays() + "\n"
                + "Workshop: " + (d.hasWorkshop() ? "Yes" : "No") + "\n"
                + String.format("Subtotal: R %.2f%n", subtotal)
                + String.format("Discount: R %.2f%n", discount)
                + String.format("Total due: R %.2f%n", total)
                + stars;
    }

    private void showError(String message, JTextComponent field) {
        JOptionPane.showMessageDialog(this, message, "Invalid input", JOptionPane.WARNING_MESSAGE);
        if (field != null) {
            field.requestFocus();
        }
    }

    // ---------- Q2.6 Save ----------
    void saveRegistration() {
        if (lastRecord == null) {
            JOptionPane.showMessageDialog(this, "Register an attendee before saving.",
                    "Nothing to save", JOptionPane.ERROR_MESSAGE);
            return;
        }
        File file = new File(FILE_NAME);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {   // append
            writer.write(lastRecord);
            writer.newLine();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Could not save: " + e.getMessage());
            return;
        }
        JOptionPane.showMessageDialog(this,
                "Thank you, " + lastFirstName + "! Your registration has been saved.\n\n"
                + "The file can be found at:\n" + file.getAbsolutePath(),
                "Registration saved", JOptionPane.INFORMATION_MESSAGE);
        lastRecord = null;                     // prevents saving the same registration twice
    }

    // ---------- Q2.7 Load + Clear ----------
    void loadRegistrations() {
        StringBuilder report = new StringBuilder("SAVED REGISTRATIONS\n");
        int count = 0;
        double revenue = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] f = line.split(",");
                if (f.length != 7) {
                    continue;                  // skip blank or damaged lines
                }
                double total = Double.parseDouble(f[6]);
                report.append(formatLine(f)).append("\n");
                revenue += total;
                count++;
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "No registrations have been saved yet.");
            return;
        } catch (IOException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Could not read registrations: " + e.getMessage());
            return;
        }
        report.append(String.format("Total revenue: R %.2f", revenue));
        txaSummary.setText(report.toString());
        lblRegistrationsLoaded.setText("Registrations loaded: " + count);
    }

    // "Lerato Mokoena | Student | 2 day(s) | Workshop: Yes | R 160.00"
    static String formatLine(String[] f) {
        return f[0] + " " + f[1] + " | " + f[3] + " | " + f[4] + " day(s) | Workshop: " + f[5]
                + " | R " + f[6];
    }

    void clearForm() {
        txtFirstName.setText("");
        txtSurname.setText("");
        txtEmail.setText("");
        cboTicketType.setSelectedIndex(0);
        grpDays.clearSelection();              // back to neither selected
        chkWorkshop.setSelected(false);
        txaReason.setText("");
        txaSummary.setText("");
        lblRegistrationsLoaded.setText("Registrations loaded: 0");
        lastRecord = null;
        txtFirstName.requestFocus();
    }

    // ---------- Q2.2 helpers ----------
    // Stops typing or pasting past max characters
    private static void limitCharacters(JTextComponent field, int max) {
        ((AbstractDocument) field.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr)
                    throws BadLocationException {
                replace(fb, offset, 0, text, attr);
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                if (text == null) {
                    super.replace(fb, offset, length, text, attrs);
                    return;
                }
                int allowed = max - (fb.getDocument().getLength() - length);
                if (text.length() <= allowed) {
                    super.replace(fb, offset, length, text, attrs);
                } else if (allowed > 0) {
                    super.replace(fb, offset, length, text.substring(0, allowed), attrs);
                }
            }
        });
    }

    // Live "x / max characters" label
    private static void addCharacterCounter(JTextComponent field, JLabel label, int max) {
        field.getDocument().addDocumentListener(new DocumentListener() {
            private void update() {
                label.setText(field.getText().length() + " / " + max + " characters");
            }
            @Override public void insertUpdate(DocumentEvent e) { update(); }
            @Override public void removeUpdate(DocumentEvent e) { update(); }
            @Override public void changedUpdate(DocumentEvent e) { update(); }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RegistrationForm().setVisible(true));
    }
}
