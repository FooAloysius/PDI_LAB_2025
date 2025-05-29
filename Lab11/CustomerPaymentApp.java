import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class CustomerPaymentApp extends JFrame {

    private JPanel menuPanel;
    private JPanel contentPanel;

    private JButton registerButton;
    private JButton paymentButton;

    private int customerId = 0; // incremental id

    // Components for Register Customer
    private JTextField nameField;
    private JTextField emailField;
    private JTextField petsField;

    // Components for Payment
    private JComboBox<String> treatmentComboBox;
    private DefaultListModel<String> selectedTreatmentsModel;
    private JList<String> selectedTreatmentsList;
    private JRadioButton cashRadioButton;
    private JRadioButton cardRadioButton;
    private ButtonGroup paymentModeGroup;

    private List<String> treatments;

    public CustomerPaymentApp() {
        setTitle("Customer and Payment Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        treatments = loadTreatmentsFromFile("treatments.txt");

        initMenuPanel();
        initContentPanel();

        add(menuPanel, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);

        showRegisterPanel(); // default view

        setVisible(true);
    }

    private void initMenuPanel() {
        menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(2, 1, 0, 10));
        menuPanel.setBorder(new EmptyBorder(20, 20, 20, 10));
        menuPanel.setPreferredSize(new Dimension(180, getHeight()));

        registerButton = new JButton("Register Customer");
        paymentButton = new JButton("Payment");

        registerButton.setFocusPainted(false);
        paymentButton.setFocusPainted(false);

        registerButton.addActionListener(e -> showRegisterPanel());
        paymentButton.addActionListener(e -> showPaymentPanel());

        menuPanel.add(registerButton);
        menuPanel.add(paymentButton);
    }

    private void initContentPanel() {
        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPanel.setLayout(new CardLayout());
    }

    private void showRegisterPanel() {
        contentPanel.removeAll();

        JPanel registerPanel = new JPanel();
        registerPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        customerId++; // increment id

        JLabel idLabel = new JLabel("Customer ID: " + customerId);
        JLabel nameLabel = new JLabel("Name:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel petsLabel = new JLabel("Pet(s) Names (comma separated):");

        nameField = new JTextField(20);
        emailField = new JTextField(20);
        petsField = new JTextField(20);

        JButton submitButton = new JButton("Register");

        gbc.gridx = 0;
        gbc.gridy = 0;
        registerPanel.add(idLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        registerPanel.add(nameLabel, gbc);
        gbc.gridx = 1;
        registerPanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        registerPanel.add(emailLabel, gbc);
        gbc.gridx = 1;
        registerPanel.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        registerPanel.add(petsLabel, gbc);
        gbc.gridx = 1;
        registerPanel.add(petsField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        registerPanel.add(submitButton, gbc);

        submitButton.addActionListener(e -> handleRegisterAction());

        contentPanel.add(registerPanel);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    private void handleRegisterAction() {
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String pets = petsField.getText().trim();

        if (name.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name and Email cannot be empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Confirm Registration?\n\nCustomer ID: " + customerId +
                        "\nName: " + name +
                        "\nEmail: " + email +
                        "\nPet(s): " + pets,
                "Confirm Registration",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this,
                    "Registration Successful!\nThank you, " + name + ".",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
            // Clear fields and increment customerId for next registration
            nameField.setText("");
            emailField.setText("");
            petsField.setText("");
            customerId++; // increment for next one
            showRegisterPanel(); // refresh panel with new ID
        }
    }

    private void showPaymentPanel() {
        contentPanel.removeAll();

        JPanel paymentPanel = new JPanel();
        paymentPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel paymentModeLabel = new JLabel("Mode of Payment:");
        cashRadioButton = new JRadioButton("Cash");
        cardRadioButton = new JRadioButton("Card");

        paymentModeGroup = new ButtonGroup();
        paymentModeGroup.add(cashRadioButton);
        paymentModeGroup.add(cardRadioButton);

        if (cashRadioButton.isSelected() == false && cardRadioButton.isSelected() == false) {
            cashRadioButton.setSelected(true); // default select cash
        }

        JLabel treatmentLabel = new JLabel("Select Treatment:");
        treatmentComboBox = new JComboBox<>();
        for (String t : treatments) {
            treatmentComboBox.addItem(t);
        }

        JButton addTreatmentButton = new JButton("Add Treatment");

        selectedTreatmentsModel = new DefaultListModel<>();
        selectedTreatmentsList = new JList<>(selectedTreatmentsModel);
        selectedTreatmentsList.setVisibleRowCount(6);
        selectedTreatmentsList.setFixedCellWidth(200);
        JScrollPane listScrollPane = new JScrollPane(selectedTreatmentsList);

        JButton payButton = new JButton("Pay");

        // Layout
        gbc.gridx = 0;
        gbc.gridy = 0;
        paymentPanel.add(paymentModeLabel, gbc);
        gbc.gridy = 1;
        paymentPanel.add(cashRadioButton, gbc);
        gbc.gridy = 2;
        paymentPanel.add(cardRadioButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        paymentPanel.add(treatmentLabel, gbc);
        gbc.gridx = 1;
        paymentPanel.add(treatmentComboBox, gbc);

        gbc.gridx = 2;
        paymentPanel.add(addTreatmentButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        paymentPanel.add(listScrollPane, gbc);

        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.CENTER;
        paymentPanel.add(payButton, gbc);

        addTreatmentButton.addActionListener(e -> addSelectedTreatment());

        payButton.addActionListener(e -> handlePayAction());

        contentPanel.add(paymentPanel);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    private void addSelectedTreatment() {
        String selected = (String) treatmentComboBox.getSelectedItem();
        if (selected != null && !selectedTreatmentsModel.contains(selected)) {
            selectedTreatmentsModel.addElement(selected);
        }
    }

    private void handlePayAction() {
        if (selectedTreatmentsModel.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please add at least one treatment before paying.", "No Treatment Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String paymentMode = cashRadioButton.isSelected() ? "Cash" : "Card";

        int confirm = JOptionPane.showConfirmDialog(this,
                "Confirm Payment?\n\nMode: " + paymentMode + 
                "\nTreatments: " + getSelectedTreatmentsString(),
                "Confirm Payment",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this,
                    "Thank you for your payment!",
                    "Payment Successful",
                    JOptionPane.INFORMATION_MESSAGE);
            selectedTreatmentsModel.clear();
        }
    }

    private String getSelectedTreatmentsString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < selectedTreatmentsModel.size(); i++) {
            sb.append(selectedTreatmentsModel.getElementAt(i));
            if (i < selectedTreatmentsModel.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    private List<String> loadTreatmentsFromFile(String fileName) {
        List<String> treatmentList = new ArrayList<>();
        File file = new File(fileName);
        if (!file.exists()) {
            // If file not found, add some default treatments
            treatmentList.add("Vaccination");
            treatmentList.add("Dental Cleaning");
            treatmentList.add("Check-up");
            treatmentList.add("Grooming");
            return treatmentList;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    treatmentList.add(line.trim());
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                    "Error reading treatments file: " + e.getMessage(),
                    "File Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return treatmentList;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CustomerPaymentApp::new);
    }
}

