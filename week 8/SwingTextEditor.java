import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class SwingTextEditor {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(SwingTextEditor::createAndShowWindow);
    }

    private static void createAndShowWindow() {
        JFrame frame = new JFrame("Simple Text Editor");
        JTextArea textArea = new JTextArea();
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");

        JMenuItem newItem = new JMenuItem("New");
        newItem.addActionListener(event -> {
            if (!textArea.getText().isEmpty()) {
                int choice = JOptionPane.showConfirmDialog(frame, "Clear the current text?",
                    "New Document", JOptionPane.YES_NO_OPTION);
                if (choice != JOptionPane.YES_OPTION) return;
            }
            textArea.setText("");
        });

        JMenuItem clearItem = new JMenuItem("Clear");
        clearItem.addActionListener(event -> textArea.setText(""));

        JMenuItem findItem = new JMenuItem("Find");
        findItem.addActionListener(event -> {
            String searchText = JOptionPane.showInputDialog(frame, "Find text:");
            if (searchText == null || searchText.isEmpty()) return;
            int match = textArea.getText().toLowerCase().indexOf(searchText.toLowerCase());
            if (match < 0) {
                JOptionPane.showMessageDialog(frame, "Text not found.",
                    "Find", JOptionPane.INFORMATION_MESSAGE);
            } else {
                textArea.requestFocusInWindow();
                textArea.select(match, match + searchText.length());
            }
        });

        JMenuItem exitItem = new JMenuItem(new AbstractAction("Exit") {
            @Override
            public void actionPerformed(ActionEvent event) {
                frame.dispose();
            }
        });

        fileMenu.add(newItem);
        fileMenu.add(clearItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        editMenu.add(findItem);
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        frame.setJMenuBar(menuBar);
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 450);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}