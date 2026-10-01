import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CourseRegistrationSearchJDBC {
    private static final String DEFAULT_URL = "jdbc:mysql://localhost:3306/college";

    public static void main(String[] args) {
        String url = System.getenv().getOrDefault("DB_URL", DEFAULT_URL);
        String user = System.getenv().getOrDefault("DB_USER", "root");
        String password = System.getenv().getOrDefault("DB_PASSWORD", "");

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Scanner scanner = new Scanner(System.in)) {
            System.out.print("Course code: ");
            String courseCode = scanner.nextLine().trim();
            searchRegistrations(connection, courseCode);
        } catch (SQLException exception) {
            System.err.println("Database error: " + exception.getMessage());
        }
    }

    private static void searchRegistrations(Connection connection, String courseCode) throws SQLException {
        String sql = "SELECT StudentID, StudentName, CourseCode, CourseName, Semester "
            + "FROM CourseRegistration WHERE CourseCode = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, courseCode);
            try (ResultSet result = statement.executeQuery()) {
                boolean found = false;
                while (result.next()) {
                    System.out.printf("Student ID: %d | Name: %s | Course Code: %s | Course: %s | Semester: %s%n",
                        result.getInt("StudentID"), result.getString("StudentName"),
                        result.getString("CourseCode"), result.getString("CourseName"),
                        result.getString("Semester"));
                    found = true;
                }
                if (!found) {
                    System.out.println("No students are registered for course code " + courseCode + ".");
                }
            }
        }
    }
}