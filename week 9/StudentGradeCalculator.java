import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GradeController().show());
    }
}

class GradeModel {
    private String studentName;
    private final double[] marks = new double[3];

    void calculate(String name, double first, double second, double third) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Enter the student's name.");
        }
        if (!validMark(first) || !validMark(second) || !validMark(third)) {
            throw new IllegalArgumentException("Each mark must be between 0 and 100.");
        }
        studentName = name;
        marks[0] = first;
        marks[1] = second;
        marks[2] = third;
    }

    private boolean validMark(double mark) {
        return mark >= 0 && mark <= 100;
    }

    double getTotal() {
        return marks[0] + marks[1] + marks[2];
    }

    double getAverage() {
        return getTotal() / marks.length;
    }

    String getGrade() {
        double average = getAverage();
        if (average >= 90) return "A";
        if (average >= 75) return "B";
        if (average >= 60) return "C";
        if (average >= 50) return "D";
        return "F";
    }

    String getStudentName() {
        return studentName;
    }
}

class GradeView {
    final JFrame frame = new JFrame("Student Grade Calculator");
    final JTextField nameField = new JTextField();
    final JTextField[] markFields = {new JTextField(), new JTextField(), new JTextField()};
    final JButton calculateButton = new JButton("Calculate Result");

    GradeView() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 8, 8));
        panel.add(new JLabel("Student Name:"));
        panel.add(nameField);
        for (int i = 0; i < markFields.length; i++) {
            panel.add(new JLabel("Subject " + (i + 1) + " Mark:"));
            panel.add(markFields[i]);
        }
        panel.add(new JLabel());
        panel.add(calculateButton);
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }
}

class GradeController {
    private final GradeModel model = new GradeModel();
    private final GradeView view = new GradeView();

    GradeController() {
        view.calculateButton.addActionListener(event -> calculate());
    }

    void show() {
        view.frame.setVisible(true);
    }

    private void calculate() {
        try {
            model.calculate(
                view.nameField.getText().trim(),
                Double.parseDouble(view.markFields[0].getText().trim()),
                Double.parseDouble(view.markFields[1].getText().trim()),
                Double.parseDouble(view.markFields[2].getText().trim())
            );
            JOptionPane.showMessageDialog(view.frame,
                "Student: " + model.getStudentName()
                    + "\nTotal: " + model.getTotal()
                    + "\nAverage: " + String.format("%.2f", model.getAverage())
                    + "\nGrade: " + model.getGrade(),
                "Result", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(view.frame, "Enter a valid number for each mark.",
                "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException exception) {
            JOptionPane.showMessageDialog(view.frame, exception.getMessage(),
                "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }
}