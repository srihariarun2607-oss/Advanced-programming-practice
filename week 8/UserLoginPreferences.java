import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class UserLoginPreferences {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(UserLoginPreferences::createAndShowWindow);
    }

    private static void createAndShowWindow() {
        JFrame frame = new JFrame("User Login and Preferences");
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JCheckBox rememberMeBox = new JCheckBox("Remember Me");
        JCheckBox notificationsBox = new JCheckBox("Receive Notifications");
        JButton loginButton = new JButton("Login");

        JPanel form = new JPanel(new GridLayout(0, 2, 8, 8));
        form.add(new JLabel("Username:"));
        form.add(usernameField);
        form.add(new JLabel("Password:"));
        form.add(passwordField);
        form.add(rememberMeBox);
        form.add(notificationsBox);
        form.add(new JLabel());
        form.add(loginButton);

        loginButton.addActionListener(event -> {
            String username = usernameField.getText().trim();
            char[] password = passwordField.getPassword();
            if (username.isEmpty() || password.length == 0) {
                JOptionPane.showMessageDialog(frame, "Enter both username and password.",
                    "Login Failed", JOptionPane.ERROR_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(frame,
                "Login information received for " + username
                    + "\nRemember Me: " + (rememberMeBox.isSelected() ? "Yes" : "No")
                    + "\nReceive Notifications: " + (notificationsBox.isSelected() ? "Yes" : "No"),
                "Login", JOptionPane.INFORMATION_MESSAGE);
        });

        frame.setContentPane(form);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}