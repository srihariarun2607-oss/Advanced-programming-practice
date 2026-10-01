import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class StudentCourseManagement {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentCourseManagement::createAndShowWindow);
    }

    private static void createAndShowWindow() {
        JFrame frame = new JFrame("Student Course Management");
        JTextField studentNameField = new JTextField();
        DefaultListModel<String> courseModel = new DefaultListModel<>();
        courseModel.addElement("Java Programming");
        courseModel.addElement("Database Systems");
        courseModel.addElement("Computer Networks");
        JList<String> courseList = new JList<>(courseModel);
        courseList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        courseList.setSelectedIndex(0);

        DefaultTableModel tableModel = new DefaultTableModel(
            new String[] {"Student Name", "Course", "Enrollment Status"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable enrollmentTable = new JTable(tableModel);
        enrollmentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JButton addButton = new JButton("Add Course Registration");
        JButton removeButton = new JButton("Remove Selected Registration");

        JPanel controls = new JPanel(new GridLayout(0, 1, 6, 6));
        controls.add(new JLabel("Student Name:"));
        controls.add(studentNameField);
        controls.add(new JLabel("Available Courses:"));
        controls.add(new JScrollPane(courseList));
        controls.add(addButton);
        controls.add(removeButton);

        addButton.addActionListener(event -> {
            String studentName = studentNameField.getText().trim();
            String course = courseList.getSelectedValue();
            if (studentName.isEmpty() || course == null) {
                JOptionPane.showMessageDialog(frame, "Enter a student name and select a course.",
                    "Missing Information", JOptionPane.ERROR_MESSAGE);
                return;
            }
            tableModel.addRow(new Object[] {studentName, course, "Enrolled"});
            studentNameField.setText("");
        });

        removeButton.addActionListener(event -> {
            int selectedRow = enrollmentTable.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(frame, "Select a registration to remove.",
                    "No Selection", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            tableModel.removeRow(selectedRow);
        });

        frame.add(controls, BorderLayout.WEST);
        frame.add(new JScrollPane(enrollmentTable), BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 350);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}