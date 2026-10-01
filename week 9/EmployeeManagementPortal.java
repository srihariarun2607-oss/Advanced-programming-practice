import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class EmployeeManagementPortal {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PortalController().showLogin());
    }
}

class PortalModel {
    private final String username = "admin";
    private String password = "admin123";
    private final List<String> employees = new ArrayList<>();

    boolean authenticate(String enteredUsername, char[] enteredPassword) {
        return username.equals(enteredUsername) && password.equals(new String(enteredPassword));
    }

    void addEmployee(String name) {
        employees.add(name);
    }

    List<String> getEmployees() {
        return new ArrayList<>(employees);
    }

    void changePassword(char[] newPassword) {
        password = new String(newPassword);
    }
}

class PortalView {
    final JFrame mainFrame = new JFrame("Employee Management Portal");
    private final JTextField usernameField = new JTextField();
    private final JPasswordField passwordField = new JPasswordField();
    final JMenuItem addEmployeeItem = new JMenuItem("Add Employee");
    final JMenuItem viewEmployeeItem = new JMenuItem("View Employee");
    final JMenuItem changePasswordItem = new JMenuItem("Change Password");
    final JMenuItem logoutItem = new JMenuItem("Logout");
    final JMenuItem exitItem = new JMenuItem("Exit Application");

    PortalView() {
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(420, 180);
        mainFrame.setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu employeeMenu = new JMenu("Employee");
        employeeMenu.add(addEmployeeItem);
        employeeMenu.add(viewEmployeeItem);
        JMenu toolsMenu = new JMenu("Tools");
        toolsMenu.add(changePasswordItem);
        JMenu exitMenu = new JMenu("Exit");
        exitMenu.add(logoutItem);
        exitMenu.add(exitItem);
        menuBar.add(employeeMenu);
        menuBar.add(toolsMenu);
        menuBar.add(exitMenu);
        mainFrame.setJMenuBar(menuBar);
        mainFrame.add(new JLabel("Employee Management Portal", JLabel.CENTER), BorderLayout.CENTER);
    }

    int showLoginDialog() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 8, 8));
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        return JOptionPane.showConfirmDialog(null, panel, "Employee Portal Login",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    }

    String getUsername() {
        return usernameField.getText().trim();
    }

    char[] getPassword() {
        return passwordField.getPassword();
    }
}

class PortalController {
    private final PortalModel model = new PortalModel();
    private final PortalView view = new PortalView();

    void showLogin() {
        showLoginDialog();
    }

    private void showLoginDialog() {
        int choice = view.showLoginDialog();
        if (choice != JOptionPane.OK_OPTION) return;

        if (!model.authenticate(view.getUsername(), view.getPassword())) {
            JOptionPane.showMessageDialog(null, "Invalid username or password.",
                "Login Failed", JOptionPane.ERROR_MESSAGE);
            showLoginDialog();
            return;
        }
        showMainWindow();
    }

    private void showMainWindow() {
        view.addEmployeeItem.addActionListener(event -> addEmployee(view));
        view.viewEmployeeItem.addActionListener(event -> viewEmployees(view));
        view.changePasswordItem.addActionListener(event -> changePassword(view));
        view.logoutItem.addActionListener(event -> {
            view.mainFrame.dispose();
            showLoginDialog();
        });
        view.exitItem.addActionListener(event -> System.exit(0));
        view.mainFrame.setVisible(true);
    }

    private void addEmployee(PortalView view) {
        String name = JOptionPane.showInputDialog(view.mainFrame, "Employee name:");
        if (name != null && !name.trim().isEmpty()) {
            model.addEmployee(name.trim());
            JOptionPane.showMessageDialog(view.mainFrame, "Employee added.");
        }
    }

    private void viewEmployees(PortalView view) {
        List<String> employees = model.getEmployees();
        String message = employees.isEmpty() ? "No employees have been added."
            : String.join("\n", employees);
        JOptionPane.showMessageDialog(view.mainFrame, message, "Employees",
            JOptionPane.INFORMATION_MESSAGE);
    }

    private void changePassword(PortalView view) {
        JPasswordField passwordField = new JPasswordField();
        int choice = JOptionPane.showConfirmDialog(view.mainFrame, passwordField,
            "Enter New Password", JOptionPane.OK_CANCEL_OPTION);
        if (choice == JOptionPane.OK_OPTION && passwordField.getPassword().length > 0) {
            model.changePassword(passwordField.getPassword());
            JOptionPane.showMessageDialog(view.mainFrame, "Password changed.");
        }
    }
}