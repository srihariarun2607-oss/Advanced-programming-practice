import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BookManagementJDBC {
    private static final String DEFAULT_URL = "jdbc:mysql://localhost:3306/library";

    public static void main(String[] args) {
        String url = System.getenv().getOrDefault("DB_URL", DEFAULT_URL);
        String user = System.getenv().getOrDefault("DB_USER", "root");
        String password = System.getenv().getOrDefault("DB_PASSWORD", "");

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Scanner scanner = new Scanner(System.in)) {
            createTableIfNeeded(connection);
            boolean running = true;
            while (running) {
                System.out.println("\n1. Insert book\n2. Search by Book ID\n3. List available books\n4. Issue book\n0. Exit");
                int choice = readInt(scanner, "Choice: ");
                switch (choice) {
                    case 1 -> insertBook(connection, scanner);
                    case 2 -> searchBook(connection, scanner);
                    case 3 -> listAvailableBooks(connection);
                    case 4 -> issueBook(connection, scanner);
                    case 0 -> running = false;
                    default -> System.out.println("Choose a listed option.");
                }
            }
        } catch (SQLException exception) {
            System.err.println("Database error: " + exception.getMessage());
        }
    }

    private static void createTableIfNeeded(Connection connection) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS Book (BookID INT PRIMARY KEY, Title VARCHAR(150) NOT NULL, "
            + "Author VARCHAR(120) NOT NULL, Price DECIMAL(10,2) NOT NULL, `Availability` BOOLEAN NOT NULL DEFAULT TRUE)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.executeUpdate();
        }
    }

    private static void insertBook(Connection connection, Scanner scanner) throws SQLException {
        String sql = "INSERT INTO Book (BookID, Title, Author, Price, `Availability`) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, readInt(scanner, "Book ID: "));
            System.out.print("Title: ");
            statement.setString(2, scanner.nextLine().trim());
            System.out.print("Author: ");
            statement.setString(3, scanner.nextLine().trim());
            statement.setDouble(4, readDouble(scanner, "Price: "));
            statement.setBoolean(5, true);
            System.out.println(statement.executeUpdate() == 1 ? "Book inserted." : "Book was not inserted.");
        }
    }

    private static void searchBook(Connection connection, Scanner scanner) throws SQLException {
        String sql = "SELECT BookID, Title, Author, Price, `Availability` FROM Book WHERE BookID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, readInt(scanner, "Book ID: "));
            try (ResultSet result = statement.executeQuery()) {
                if (result.next()) printBook(result);
                else System.out.println("Book not found.");
            }
        }
    }

    private static void listAvailableBooks(Connection connection) throws SQLException {
        String sql = "SELECT BookID, Title, Author, Price, `Availability` FROM Book WHERE `Availability` = TRUE";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet result = statement.executeQuery()) {
            boolean found = false;
            while (result.next()) {
                printBook(result);
                found = true;
            }
            if (!found) System.out.println("No available books.");
        }
    }

    private static void issueBook(Connection connection, Scanner scanner) throws SQLException {
        String sql = "UPDATE Book SET `Availability` = FALSE WHERE BookID = ? AND `Availability` = TRUE";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, readInt(scanner, "Book ID to issue: "));
            System.out.println(statement.executeUpdate() == 1 ? "Book issued." : "Book not found or already issued.");
        }
    }

    private static void printBook(ResultSet result) throws SQLException {
        System.out.printf("ID: %d | Title: %s | Author: %s | Price: %.2f | Available: %s%n",
            result.getInt("BookID"), result.getString("Title"), result.getString("Author"),
            result.getDouble("Price"), result.getBoolean("Availability"));
    }

    private static int readInt(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return Integer.parseInt(scanner.nextLine().trim());
    }

    private static double readDouble(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return Double.parseDouble(scanner.nextLine().trim());
    }
}