import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class StudentRegistrationSystem {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentRegistrationSystem::createAndShowWindow);
    }

    private static void createAndShowWindow() {
        JFrame frame = new JFrame("Student Registration");
        JTextField nameField = new JTextField();
        JTextField registerNumberField = new JTextField();
        JRadioButton maleButton = new JRadioButton("Male");
        JRadioButton femaleButton = new JRadioButton("Female");
        JRadioButton otherButton = new JRadioButton("Other");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        genderGroup.add(otherButton);
        JPanel genderPanel = new JPanel();
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        genderPanel.add(otherButton);
        JComboBox<String> departmentBox = new JComboBox<>(new String[] {
            "Computer Science", "Information Technology", "Electronics", "Mechanical"
        });
        JButton submitButton = new JButton("Submit Registration");

        JPanel form = new JPanel(new GridLayout(0, 2, 8, 8));
        form.add(new JLabel("Student Name:"));
        form.add(nameField);
        form.add(new JLabel("Register Number:"));
        form.add(registerNumberField);
        form.add(new JLabel("Gender:"));
        form.add(genderPanel);
        form.add(new JLabel("Department:"));
        form.add(departmentBox);
        form.add(new JLabel());
        form.add(submitButton);

        submitButton.addActionListener(event -> {
            String name = nameField.getText().trim();
            String registerNumber = registerNumberField.getText().trim();
            if (name.isEmpty() || registerNumber.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Enter the student name and register number.",
                    "Missing Information", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String gender = maleButton.isSelected() ? "Male"
                : femaleButton.isSelected() ? "Female"
                : otherButton.isSelected() ? "Other" : "Not selected";
            JOptionPane.showMessageDialog(frame,
                "Student Name: " + name
                    + "\nRegister Number: " + registerNumber
                    + "\nGender: " + gender
                    + "\nDepartment: " + departmentBox.getSelectedItem(),
                "Registration Details", JOptionPane.INFORMATION_MESSAGE);
        });

        frame.setContentPane(form);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}