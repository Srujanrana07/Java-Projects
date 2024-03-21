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
    Payment payment = new Payment();
    private static String UID;
    private static String username;

    private static void setUserUID(String UserUID) {
        UID = UserUID;
    }
    private static void setUserUsername(String userUsername) {
        username = userUsername;
    }

    public void CustomerPage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("WELCOME TO CUSTOMER SECTION\n");
        int ch;
        do {
            System.out.println("*****************************************************\n");
            System.out.println("1 - VIEW GROCERIES LIST");  //complete
            System.out.println("2 - ADD PRODUCT TO CART");   //complete
            System.out.println("3 - REMOVE PRODUCT FROM CART"); //complete
            System.out.println("4 - VIEW CART");   //complete
            System.out.println("5 - PROCEED TO PAYMENT");
            System.out.println("6 - EDIT PROFILE");  //complete
            System.out.println("7 - LOGOUT FROM SYSTEM");
            System.out.println("*****************************************************\n");
            System.out.print("Enter choice : ");
            ch = scanner.nextInt();

            if(ch==1){
                item.groceries_show();
                item.view_item();
                cart.add_cart();
            }else if (ch==4) {
                cart.view_cart();
            }
            else if(ch==6)
                editProfile(UID);
            else if(ch==2) {
                item.groceries_show();
                item.view_item();
                cart.add_cart();
            }
            else if(ch==3)
                cart.remove_cart();
            else if(ch==5) payment.makePayment(username, cart.getCartList());

        } while (ch != 7);
    }

    private void updateProfileField(String field, String value, String UserUID, Connection connection) throws SQLException {
        String query = "UPDATE user SET " + field + " = ? WHERE UserUID = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, value);
            preparedStatement.setString(2, UserUID);
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
                String UserUID = resultSet.getString("UserUID");
                String userUsername = resultSet.getString("username");
                System.out.println("UID "+UserUID+" Verified successfully");
                User.setUserUID(UserUID);
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



    private void editProfile(String UID) {
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
                    updateProfileField("name", newName, UID, connection);
                    System.out.println("Name updated successfully!");
                    break;
                }
                case 2: {
                    System.out.println("Please enter your new mobile number:");
                    String newNumber = sc.nextLine();
                    updateProfileField("mobno", newNumber, UID, connection);
                    System.out.println("Mobile number updated successfully!");
                    break;
                }
                case 3: {
                    System.out.println("Please enter your new password:");
                    String newPassword = sc.nextLine();
                    updateProfileField("password", newPassword, UID, connection);
                    System.out.println("Password updated successfully!");
                    break;
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    public static void saveUserToDatabase(String name, String mobno, String username, String password,String UserUID) throws SQLException {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "INSERT INTO user (name, mobno, username, password, UserUID, LastPayment, Wallet) VALUES (?, ?, ?, ?, ?, '0', '0')";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, mobno);
                preparedStatement.setString(3, username);
                preparedStatement.setString(4, password);
                preparedStatement.setString(5,UserUID );
                preparedStatement.executeUpdate();
            }
        }
    }

}
