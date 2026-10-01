import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ProductManagementJDBC {
    private static final String DEFAULT_URL = "jdbc:mysql://localhost:3306/product_store";

    public static void main(String[] args) {
        String url = System.getenv().getOrDefault("DB_URL", DEFAULT_URL);
        String user = System.getenv().getOrDefault("DB_USER", "root");
        String password = System.getenv().getOrDefault("DB_PASSWORD", "");

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Scanner scanner = new Scanner(System.in)) {
            createTableIfNeeded(connection);
            boolean running = true;
            while (running) {
                System.out.println("\n1. Insert product\n2. Retrieve by Product ID\n3. Update quantity\n4. List products with quantity below 10\n0. Exit");
                int choice = readInt(scanner, "Choice: ");
                switch (choice) {
                    case 1 -> insertProduct(connection, scanner);
                    case 2 -> retrieveProduct(connection, scanner);
                    case 3 -> updateQuantity(connection, scanner);
                    case 4 -> listLowStock(connection);
                    case 0 -> running = false;
                    default -> System.out.println("Choose a listed option.");
                }
            }
        } catch (SQLException exception) {
            System.err.println("Database error: " + exception.getMessage());
        }
    }

    private static void createTableIfNeeded(Connection connection) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS Product (ProductID INT PRIMARY KEY, ProductName VARCHAR(150) NOT NULL, "
            + "Price DECIMAL(10,2) NOT NULL, Quantity INT NOT NULL)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.executeUpdate();
        }
    }

    private static void insertProduct(Connection connection, Scanner scanner) throws SQLException {
        String sql = "INSERT INTO Product (ProductID, ProductName, Price, Quantity) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, readInt(scanner, "Product ID: "));
            System.out.print("Product name: ");
            statement.setString(2, scanner.nextLine().trim());
            statement.setDouble(3, readDouble(scanner, "Price: "));
            statement.setInt(4, readInt(scanner, "Quantity: "));
            System.out.println(statement.executeUpdate() == 1 ? "Product inserted." : "Product was not inserted.");
        }
    }

    private static void retrieveProduct(Connection connection, Scanner scanner) throws SQLException {
        String sql = "SELECT ProductID, ProductName, Price, Quantity FROM Product WHERE ProductID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, readInt(scanner, "Product ID: "));
            try (ResultSet result = statement.executeQuery()) {
                if (result.next()) printProduct(result);
                else System.out.println("Product not found.");
            }
        }
    }

    private static void updateQuantity(Connection connection, Scanner scanner) throws SQLException {
        String sql = "UPDATE Product SET Quantity = ? WHERE ProductID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, readInt(scanner, "New quantity: "));
            statement.setInt(2, readInt(scanner, "Product ID: "));
            System.out.println(statement.executeUpdate() == 1 ? "Quantity updated." : "Product not found.");
        }
    }

    private static void listLowStock(Connection connection) throws SQLException {
        String sql = "SELECT ProductID, ProductName, Price, Quantity FROM Product WHERE Quantity < 10";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet result = statement.executeQuery()) {
            boolean found = false;
            while (result.next()) {
                printProduct(result);
                found = true;
            }
            if (!found) System.out.println("No products have a quantity below 10.");
        }
    }

    private static void printProduct(ResultSet result) throws SQLException {
        System.out.printf("ID: %d | Name: %s | Price: %.2f | Quantity: %d%n",
            result.getInt("ProductID"), result.getString("ProductName"),
            result.getDouble("Price"), result.getInt("Quantity"));
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