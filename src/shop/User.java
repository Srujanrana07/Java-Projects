package shop;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class User{
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/store";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    Scanner sc=new Scanner(System.in);
    Items item=new Items();
    Cart cart =new Cart();
    private static String username;
    private static void setUserUsername(String userUsername) {
        username = userUsername;
    }




    // Other user-related methods can be added here
    public void CustomerPage() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("WELCOME TO CUSTOMER SECTION\n");
        int ch;
        do {
            System.out.println("*****************************************************\n");
            System.out.println("1 - VIEW GROCERIES LIST");  //complete
//            System.out.println("2 - SEARCH A PRODUCT NAME WISE");
//            System.out.println("3 - SEARCH PRODUCTS TYPE WISE");
            System.out.println("4 - ADD PRODUCT TO CART");   //complete
            System.out.println("5 - REMOVE PRODUCT FROM CART"); //complete
            System.out.println("6 - VIEW CART");   //complete
            System.out.println("7 - PROCEED TO PAYMENT");
            System.out.println("8 - EDIT PROFILE");  //complete
            System.out.println("9 - LOGOUT FROM SYSTEM");
            System.out.println("*****************************************************\n");
            System.out.print("Enter choice : ");
            ch = scanner.nextInt();

            if(ch==1){
                item.groceries_show();
                item.view_item();
                cart.add_cart();
            }else if (ch==6)
                cart.view_cart();
            else if(ch==8)
                editProfile(username);
            else if(ch==4)
                cart.add_cart();
            else if(ch==5)
                cart.remove_cart();
        } while (ch != 9);
    }
//

//    protected void printAllUsers() {
//        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
//            String query = "SELECT * FROM user";
//            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//                ResultSet resultSet = preparedStatement.executeQuery();
//                System.out.println("Existing Users:");
//
//                // Print table header
//                System.out.printf("%-20s %-15s %-15s %-15s%n", "Name", "Mobile Number", "Username", "Password");
//                System.out.println("------------------------------------------------------------");
//
//                while (resultSet.next()) {
//                    String name = resultSet.getString("name");
//                    String mobno = resultSet.getString("mobno");
//                    String username = resultSet.getString("username");
//                    String password = resultSet.getString("password");
//
//                    // Print table rows
//                    System.out.printf("%-20s %-15s %-15s %-15s%n", name, mobno, username, password);
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    private void updateProfileField(String field, String value, String username, Connection connection) throws SQLException {
        String query = "UPDATE user SET " + field + " = ? WHERE username = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, value);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();
        }
    }
    public static boolean validate_Customer(String username, String name) throws SQLException {
        Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        String query = "SELECT * FROM user WHERE username = ? AND password = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                // If a matching record is found, set the user's username
                String userUsername = resultSet.getString("username");
                System.out.println("USERNAME "+userUsername+"Verified");
                User.setUserUsername(userUsername);
                return true;
            } else {
                return false;
            }

        }
    }
    public void deleteUser(String username,String password) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String query = "DELETE FROM user WHERE username = ? AND name = ? ";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("User with Name " + username + " deleted successfully.");
                } else {
                    System.out.println("No user found with username " + username + ".");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    private void editProfile(String userUsername) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What do you want to change: 1. Name 2. Mobile Number 3. Password 4. Back");
        int n = sc.nextInt();
        sc.nextLine();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            switch (n) {
                case 1: {
                    System.out.println("Please enter your new name:");
                    String newName = sc.nextLine();
                    updateProfileField("name", newName, username, connection);
                    System.out.println("Name updated successfully!");
                    break;
                }
                case 2: {
                    System.out.println("Please enter your new mobile number:");
                    String newNumber = sc.nextLine();
                    updateProfileField("mobno", newNumber, username, connection);
                    System.out.println("Mobile number updated successfully!");
                    break;
                }
                case 3: {
                    System.out.println("Please enter your new password:");
                    String newPassword = sc.nextLine();
                    updateProfileField("password", newPassword, username, connection);
                    System.out.println("Password updated successfully!");
                    break;
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    public static void saveUserToDatabase(String name, String mobno, String username, String password) throws SQLException {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "INSERT INTO user (name, mobno, username, password) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, mobno);
                preparedStatement.setString(3, username);
                preparedStatement.setString(4, password);
                preparedStatement.executeUpdate();
            }
        }
    }

}
