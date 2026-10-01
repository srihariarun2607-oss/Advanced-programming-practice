import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class VehicleServiceCostEstimator {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ServiceController().show());
    }
}

class ServiceModel {
    int calculateCost(boolean general, boolean oil, boolean brake, boolean battery) {
        return (general ? 1000 : 0)
            + (oil ? 800 : 0)
            + (brake ? 1200 : 0)
            + (battery ? 500 : 0);
    }
}

class ServiceView {
    final JFrame frame = new JFrame("Vehicle Service Cost Estimator");
    final JTextField registrationField = new JTextField();
    final JComboBox<String> vehicleType = new JComboBox<>(new String[] {"Two Wheeler", "Car"});
    final JCheckBox general = new JCheckBox("General Service - Rs. 1,000");
    final JCheckBox oil = new JCheckBox("Oil Change - Rs. 800");
    final JCheckBox brake = new JCheckBox("Brake Service - Rs. 1,200");
    final JCheckBox battery = new JCheckBox("Battery Check - Rs. 500");
    final JButton calculateButton = new JButton("Calculate Cost");

    ServiceView() {
        JPanel panel = new JPanel(new GridLayout(0, 1, 6, 6));
        panel.add(new JLabel("Vehicle Registration Number:"));
        panel.add(registrationField);
        panel.add(new JLabel("Vehicle Type:"));
        panel.add(vehicleType);
        panel.add(general);
        panel.add(oil);
        panel.add(brake);
        panel.add(battery);
        panel.add(calculateButton);
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }
}

class ServiceController {
    private final ServiceModel model = new ServiceModel();
    private final ServiceView view = new ServiceView();

    ServiceController() {
        view.calculateButton.addActionListener(event -> calculate());
    }

    void show() {
        view.frame.setVisible(true);
    }

    private void calculate() {
        String registration = view.registrationField.getText().trim();
        if (registration.isEmpty()) {
            JOptionPane.showMessageDialog(view.frame, "Enter the vehicle registration number.",
                "Missing Information", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int total = model.calculateCost(view.general.isSelected(), view.oil.isSelected(),
            view.brake.isSelected(), view.battery.isSelected());
        JOptionPane.showMessageDialog(view.frame,
            "Registration: " + registration
                + "\nVehicle Type: " + view.vehicleType.getSelectedItem()
                + "\nTotal Service Cost: Rs. " + total,
            "Service Estimate", JOptionPane.INFORMATION_MESSAGE);
    }
}