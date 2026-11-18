package templates.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

/**
 * TEMPLATE: every Swing topic in LU6 in one JFrame.
 * - extending JFrame, implementing ActionListener with getSource()
 * - JLabel (font/colour), JTextField, JTextArea, JButton + tooltips
 * - JComboBox, JCheckBox, JRadioButton + ButtonGroup, JList + DefaultListModel
 * - layout managers (BorderLayout, FlowLayout, GridLayout), JPanels, colours, JScrollPane
 * - menus: JMenuBar, JMenu, JMenuItem, submenu, separator, JCheckBoxMenuItem,
 *   mnemonics (Alt+key) and accelerators (Ctrl+key)
 * - mouse events with MouseAdapter
 * - JOptionPane message, confirm and input dialogs
 */
public class SwingComponentsTemplate extends JFrame implements ActionListener {

    // ---------- Components ----------
    private final JLabel lblTitle = new JLabel("Student Registration", JLabel.CENTER);
    private final JTextField txtName = new JTextField(15);
    private final JComboBox<String> cboCourse =
            new JComboBox<>(new String[] {"BCAD", "BCIS", "DIS"});
    private final JRadioButton radFullTime = new JRadioButton("Full-time", true);
    private final JRadioButton radDistance = new JRadioButton("Distance");
    private final ButtonGroup grpMode = new ButtonGroup();     // only one radio can be selected
    private final JCheckBox chkBursary = new JCheckBox("Bursary holder");
    private final JButton btnAdd = new JButton("Add");
    private final JButton btnRemove = new JButton("Remove selected");
    private final DefaultListModel<String> listModel = new DefaultListModel<>();
    private final JList<String> lstStudents = new JList<>(listModel);
    private final JTextArea txaLog = new JTextArea(5, 30);
    private final JLabel lblStatus = new JLabel("Students: 0");

    // Menu items that the ActionListener needs to recognise
    private final JMenuItem mniExit = new JMenuItem("Exit");
    private final JMenuItem mniAdd = new JMenuItem("Add student");
    private final JMenuItem mniClear = new JMenuItem("Clear all");
    private final JMenuItem mniAbout = new JMenuItem("About");
    private final JMenuItem mniRename = new JMenuItem("Rename title...");
    private final JCheckBoxMenuItem mniBoldLog = new JCheckBoxMenuItem("Bold log text");

    public SwingComponentsTemplate() {
        super("Swing Components Template");          // title bar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        styleComponents();
        setJMenuBar(buildMenuBar());
        buildLayout();
        registerListeners();

        pack();
        setLocationRelativeTo(null);                 // centre on screen
    }

    // Fonts, colours, tooltips, read-only controls
    private void styleComponents() {
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitle.setForeground(Color.WHITE);
        btnAdd.setToolTipText("Add the student to the list");
        btnRemove.setToolTipText("Remove the highlighted student");
        txaLog.setEditable(false);
        grpMode.add(radFullTime);
        grpMode.add(radDistance);
    }

    // JMenuBar > JMenu > JMenuItem, with mnemonics, accelerators, submenu and separator
    private JMenuBar buildMenuBar() {
        JMenuBar bar = new JMenuBar();

        JMenu mnuFile = new JMenu("File");
        mnuFile.setMnemonic(KeyEvent.VK_F);                         // Alt+F opens it
        mniExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK)); // Ctrl+Q
        mnuFile.add(mniExit);

        JMenu mnuTools = new JMenu("Tools");
        mnuTools.setMnemonic(KeyEvent.VK_T);
        mniAdd.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));  // Ctrl+N
        mnuTools.add(mniAdd);
        mnuTools.add(mniClear);
        mnuTools.addSeparator();                                    // dividing line

        JMenu mnuView = new JMenu("View");                          // submenu inside Tools
        mnuView.add(mniBoldLog);
        mnuView.add(mniRename);
        mnuTools.add(mnuView);

        JMenu mnuHelp = new JMenu("Help");
        mnuHelp.add(mniAbout);

        bar.add(mnuFile);
        bar.add(mnuTools);
        bar.add(mnuHelp);
        return bar;
    }

    // BorderLayout frame: title NORTH, form CENTER, list EAST, log SOUTH
    private void buildLayout() {
        JPanel pnlTitle = new JPanel(new FlowLayout());
        pnlTitle.setBackground(new Color(18, 53, 91));              // custom RGB colour
        pnlTitle.add(lblTitle);

        JPanel pnlForm = new JPanel(new GridLayout(5, 2, 6, 6));
        pnlForm.setBorder(BorderFactory.createTitledBorder("Details"));
        pnlForm.add(new JLabel("Name:"));
        pnlForm.add(txtName);
        pnlForm.add(new JLabel("Course:"));
        pnlForm.add(cboCourse);
        pnlForm.add(radFullTime);
        pnlForm.add(radDistance);
        pnlForm.add(chkBursary);
        pnlForm.add(lblStatus);
        pnlForm.add(btnAdd);
        pnlForm.add(btnRemove);

        JScrollPane scrList = new JScrollPane(lstStudents);
        scrList.setBorder(BorderFactory.createTitledBorder("Students"));
        scrList.setPreferredSize(new java.awt.Dimension(220, 160));

        JScrollPane scrLog = new JScrollPane(txaLog);
        scrLog.setBorder(BorderFactory.createTitledBorder("Log"));

        add(pnlTitle, BorderLayout.NORTH);
        add(pnlForm, BorderLayout.CENTER);
        add(scrList, BorderLayout.EAST);
        add(scrLog, BorderLayout.SOUTH);
    }

    // One ActionListener (this) for buttons and menu items; lambdas also work
    private void registerListeners() {
        btnAdd.addActionListener(this);
        btnRemove.addActionListener(this);
        txtName.addActionListener(this);               // Enter key in the text field
        mniExit.addActionListener(this);
        mniAdd.addActionListener(this);
        mniClear.addActionListener(this);
        mniAbout.addActionListener(this);
        mniRename.addActionListener(this);
        mniBoldLog.addActionListener(this);
        cboCourse.addActionListener(e -> log("Course changed to " + cboCourse.getSelectedItem()));

        // Mouse events: only override the methods you need
        lstStudents.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && lstStudents.getSelectedValue() != null) {
                    JOptionPane.showMessageDialog(SwingComponentsTemplate.this,
                            "You double-clicked: " + lstStudents.getSelectedValue());
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lblStatus.setForeground(Color.BLUE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblStatus.setForeground(Color.BLACK);
            }
        });
    }

    // Event handler: getSource() tells us which component fired
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == btnAdd || source == mniAdd || source == txtName) {
            addStudent();
        } else if (source == btnRemove) {
            removeSelected();
        } else if (source == mniClear) {
            clearAll();
        } else if (source == mniExit) {
            exitWithConfirm();
        } else if (source == mniAbout) {
            JOptionPane.showMessageDialog(this, "PROG6112 Swing template", "About",
                    JOptionPane.INFORMATION_MESSAGE);
        } else if (source == mniRename) {
            String newTitle = JOptionPane.showInputDialog(this, "New title:", lblTitle.getText());
            if (newTitle != null && !newTitle.trim().isEmpty()) {   // null = Cancel pressed
                lblTitle.setText(newTitle.trim());
            }
        } else if (source == mniBoldLog) {
            int style = mniBoldLog.isSelected() ? Font.BOLD : Font.PLAIN;
            txaLog.setFont(txaLog.getFont().deriveFont(style));
        }
    }

    // Read every control, validate, add to the list
    void addStudent() {
        String name = txtName.getText().trim();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name cannot be empty", "Validation",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        String course = (String) cboCourse.getSelectedItem();
        String mode = radFullTime.isSelected() ? "Full-time" : "Distance";
        String bursary = chkBursary.isSelected() ? " (bursary)" : "";
        String entry = name + " - " + course + " - " + mode + bursary;

        listModel.addElement(entry);
        lblStatus.setText("Students: " + listModel.size());
        log("Added " + entry);

        txtName.setText("");
        txtName.requestFocus();
    }

    void removeSelected() {
        int index = lstStudents.getSelectedIndex();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Select a student first");
            return;
        }
        log("Removed " + listModel.get(index));
        listModel.remove(index);
        lblStatus.setText("Students: " + listModel.size());
    }

    void clearAll() {
        listModel.clear();
        txtName.setText("");
        cboCourse.setSelectedIndex(0);
        radFullTime.setSelected(true);
        chkBursary.setSelected(false);
        txaLog.setText("");
        lblStatus.setText("Students: 0");
    }

    private void exitWithConfirm() {
        int answer = JOptionPane.showConfirmDialog(this, "Exit the application?", "Confirm",
                JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private void log(String message) {
        txaLog.append(message + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SwingComponentsTemplate().setVisible(true));
    }
}
