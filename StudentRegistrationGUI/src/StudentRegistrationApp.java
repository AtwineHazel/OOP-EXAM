import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentRegistrationApp extends JFrame implements ActionListener {

    private JLabel regIdLabel, nameLabel, facultyLabel, projectTitleLabel, contactLabel, emailLabel;
    private JTextField regIdField, nameField, facultyField, projectTitleField, contactField, emailField;
    private JButton registerButton, clearButton, exitButton;

    public StudentRegistrationApp() {
        setTitle("Victoria University Innovation Exhibition Registration");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        add(mainPanel);

        JPanel inputPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        mainPanel.add(inputPanel, BorderLayout.CENTER);

        regIdLabel = new JLabel("Registration ID:");
        regIdField = new JTextField(20);

        nameLabel = new JLabel("Student Name:");
        nameField = new JTextField(20);

        facultyLabel = new JLabel("Faculty:");
        facultyField = new JTextField(20);

        projectTitleLabel = new JLabel("Project Title:");
        projectTitleField = new JTextField(20);

        contactLabel = new JLabel("Contact Number:");
        contactField = new JTextField(20);

        emailLabel = new JLabel("Email Address:");
        emailField = new JTextField(20);

        inputPanel.add(regIdLabel);
        inputPanel.add(regIdField);
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(facultyLabel);
        inputPanel.add(facultyField);
        inputPanel.add(projectTitleLabel);
        inputPanel.add(projectTitleField);
        inputPanel.add(contactLabel);
        inputPanel.add(contactField);
        inputPanel.add(emailLabel);
        inputPanel.add(emailField);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        registerButton = new JButton("Register");
        clearButton = new JButton("Clear");
        exitButton = new JButton("Exit");

        registerButton.addActionListener(this);
        clearButton.addActionListener(this);
        exitButton.addActionListener(this);

        buttonPanel.add(registerButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(exitButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            String regId = regIdField.getText();
            String name = nameField.getText();
            String faculty = facultyField.getText();
            String projectTitle = projectTitleField.getText();
            String contact = contactField.getText();
            String email = emailField.getText();

            if (regId.isEmpty() || name.isEmpty() || faculty.isEmpty() || projectTitle.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all required fields (Reg ID, Name, Faculty, Project Title).", "Missing Information", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Connection conn = null;
            PreparedStatement pstmt = null;

            try {
                conn = DatabaseConnector.connectToAccessDatabase();
                if (conn != null) {
                    String sql = "INSERT INTO Participants (RegistrationID, StudentName, Faculty, ProjectTitle, ContactNumber, EmailAddress) VALUES (?, ?, ?, ?, ?, ?)";
                    pstmt = conn.prepareStatement(sql);

                    pstmt.setString(1, regId);
                    pstmt.setString(2, name);
                    pstmt.setString(3, faculty);
                    pstmt.setString(4, projectTitle);
                    pstmt.setString(5, contact);
                    pstmt.setString(6, email);

                    int rowsAffected = pstmt.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(this, "Student Registered Successfully!", "Registration Success", JOptionPane.INFORMATION_MESSAGE);
                        clearFields();
                    } else {
                        JOptionPane.showMessageDialog(this, "Registration Failed: No rows affected.", "Registration Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            } finally {
                try {
                    if (pstmt != null) pstmt.close();
                    if (conn != null) conn.close();
                } catch (SQLException ex) {
                    System.err.println("Error closing database resources: " + ex.getMessage());
                    ex.printStackTrace();
                }
            }

        } else if (e.getSource() == clearButton) {
            clearFields();
            JOptionPane.showMessageDialog(this, "Form Cleared!", "Clear", JOptionPane.INFORMATION_MESSAGE);

        } else if (e.getSource() == exitButton) {
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit Application", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }

    private void clearFields() {
        regIdField.setText("");
        nameField.setText("");
        facultyField.setText("");
        projectTitleField.setText("");
        contactField.setText("");
        emailField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StudentRegistrationApp().setVisible(true);
            }
        });
    }
}
