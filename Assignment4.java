// Program: Preventing SQL Injection using PreparedStatement

import java.sql.*;
import java.util.Scanner;

public class PreventSQLInjection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            // 1. Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "password");

            // 3. Get user input
            System.out.print("Enter username: ");
            String username = sc.nextLine();

            System.out.print("Enter password: ");
            String password = sc.nextLine();

            // 4. Create SQL query with placeholders
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

            // 5. Create PreparedStatement
            pst = con.prepareStatement(sql);

            // 6. Set parameters safely (Prevents SQL Injection)
            pst.setString(1, username);
            pst.setString(2, password);

            // 7. Execute query
            rs = pst.executeQuery();

            // 8. Check if user exists
            if (rs.next()) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Invalid username or password.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 9. Close resources
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (con != null) con.close();
                sc.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
