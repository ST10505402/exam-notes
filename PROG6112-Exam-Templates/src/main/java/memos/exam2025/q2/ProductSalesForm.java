package memos.exam2025.q2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 * 2025 Q2 - Product Sales Application.
 * Hand-coded so it runs on its own. In the exam, build the same controls with the
 * GUI builder (same variable names) and copy loadData / saveData / clearForm into your form.
 */
public class ProductSalesForm extends JFrame {

    private static final String FILE_NAME = "data.txt";

    private final JButton btnLoad = new JButton("Load Product Data");
    private final JButton btnSave = new JButton("Save Product Data");
    private final JTextArea txaReport = new JTextArea(5, 25);
    private final JLabel lblYearsProcessed = new JLabel("Years Processed:");

    private final ProductSales productSales = new ProductSales();

    public ProductSalesForm() {
        super("Product Sales Application");
        txaReport.setEditable(false);

        // Q2.3 menu
        JMenuBar menuBar = new JMenuBar();
        JMenu mnuFile = new JMenu("File");
        JMenuItem mniExit = new JMenuItem("Exit");
        mnuFile.add(mniExit);
        JMenu mnuTools = new JMenu("Tools");
        JMenuItem mniLoad = new JMenuItem("Load Product Data");
        JMenuItem mniSave = new JMenuItem("Save Product Data");
        JMenuItem mniClear = new JMenuItem("Clear");
        mnuTools.add(mniLoad);
        mnuTools.add(mniSave);
        mnuTools.add(mniClear);
        menuBar.add(mnuFile);
        menuBar.add(mnuTools);
        setJMenuBar(menuBar);

        // Buttons and menu items share the same methods (code efficiency)
        btnLoad.addActionListener(e -> loadData());
        mniLoad.addActionListener(e -> loadData());
        btnSave.addActionListener(e -> saveData());
        mniSave.addActionListener(e -> saveData());
        mniClear.addActionListener(e -> clearForm());
        mniExit.addActionListener(e -> System.exit(0));

        JPanel pnlButtons = new JPanel(new GridLayout(2, 1, 5, 5));
        pnlButtons.add(btnLoad);
        pnlButtons.add(btnSave);
        add(pnlButtons, BorderLayout.NORTH);
        add(new JScrollPane(txaReport), BorderLayout.CENTER);
        add(lblYearsProcessed, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    // Q2.2 Load: calculate from the class and display (as per the sample screenshot)
    void loadData() {
        txaReport.setText("Total Sales: " + productSales.GetTotalSales() + "\n"
                + "Average Sales: " + Math.round(productSales.GetAverageSales()) + "\n"
                + "Sales over limit: " + productSales.GetSalesOverLimit() + "\n"
                + "Sales under limit: " + productSales.GetSalesUnderLimit());
        lblYearsProcessed.setText("Years Processed: " + productSales.GetProductsProcessed());
    }

    // Q2.2 Save: data.txt = DATA LOG heading + stars + text area + stars
    void saveData() {
        if (txaReport.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Load the product data before saving.");
            return;
        }
        String stars = "*".repeat(32);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write("DATA LOG");
            writer.newLine();
            writer.write(stars);
            writer.newLine();
            writer.write(txaReport.getText());
            writer.newLine();
            writer.write(stars);
            writer.newLine();
            JOptionPane.showMessageDialog(this, "Saved to " + FILE_NAME);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Could not save: " + e.getMessage());
        }
    }

    // Q2.3 Clear: empty the text area and the Years Processed label
    void clearForm() {
        txaReport.setText("");
        lblYearsProcessed.setText("Years Processed:");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProductSalesForm().setVisible(true));
    }
}
