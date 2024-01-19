package shop;

import java.sql.*;
import java.util.Random;
import java.util.Scanner;


public class Admin extends User {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/store";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";


    Items item =new Items();
//    User user = new User();

    public void admin_page() {
        System.out.println("Welcome to the Admin page!");
//        this.user = new User();
        Scanner sc=new Scanner(System.in);
        int ch;
        do {
            System.out.println("*****************************************************\n");
            System.out.println("1 - MANAGE PRODUCTS");
            System.out.println("2 - ADD CUSTOMERS");//complete
            System.out.println("3 - VIEW CUSTOMERS");//complete
            System.out.println("4 - EDIT PROFILE"); //complete
            System.out.println("5 - ADD NEW ADMIN");//complete
            System.out.println("6 - REMOVE CUSTOMERS");
            System.out.println("7 - LOGOUT FROM SYSTEM");
            System.out.println("*****************************************************\n");
            System.out.print("Enter choice : ");
            ch=sc.nextInt();
            if (ch == 1) {
                product_page();
            } else if (ch == 2) {
                add_customer();
            } else if (ch == 3) {
//                user.printAllUsers();
                  printAllUsers();
            } else if (ch == 4) {
                editProfile(UID);
            } else if (ch == 5) {
                add_admin();
            } else if (ch == 6) {
                remove_user();
            } else if (ch == 7)
                System.out.println("Thank you");
            else
                System.out.println("Wrong choice");
        }while (ch!=7);
    }

    private void remove_user() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nWELCOME TO CUSTOMER DELETION PAGE\n");
        System.out.println("*****************************************************\n");
        System.out.println("Enter THE USERNAME U WANT TO DELETE");
        String UserUsername=sc.nextLine();
        System.out.println("Enter THE USER'S NAME U WANT TO DELETE");
        String UserName=sc.nextLine();
//        user.deleteUser(UserUsername,UserName);
        deleteUser(UserUsername,UserName);
    }

    private void add_customer() {
        registerUser();
    }

    private void registerUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nWELCOME TO CUSTOMER REGISTRATION PAGE\n");
        System.out.println("*****************************************************\n");
//        Random random = new Random();
//        char letter = (char) ('A' + random.nextInt(26));
//        int number = 100 + random.nextInt(900);
//        String UID = String.valueOf(letter) + number;

        System.out.print("Enter Name = ");
        String name = sc.nextLine();
        System.out.print("Enter Password = ");
        String password = sc.nextLine();
        System.out.print("Enter Username = ");
        String username = sc.nextLine();
        System.out.print("Enter Contact Number = ");
        String mobno = sc.nextLine();

        try {
//            user.saveUserToDatabase(name, mobno, username, password);
            saveUserToDatabase(name, mobno, username, password);
            System.out.println("REGISTRATION DONE SUCCESSFULLY! FOR " + name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void add_admin() {
        registerAdmin();
    }

    private void registerAdmin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nWELCOME TO ADMIN REGISTRATION PAGE\n");
        System.out.println("*****************************************************\n");

//        Random random = new Random();
//        int UID = 100 + random.nextInt(100);
//        System.out.println("ADMIN ID = " + UID);
        Random random = new Random();
        char letter = (char) ('A' + random.nextInt(26));
        int number = 10 + random.nextInt(90);
        String UID = String.valueOf(letter) + number;

        System.out.println("Generated UID: " + UID);

        System.out.print("Enter Name = ");
        String name = sc.nextLine();
        System.out.print("Enter Password = ");
        String password = sc.nextLine();
        System.out.print("Enter Username = ");
        String username = sc.nextLine();
        System.out.print("Enter Contact Number = ");
        String mobno = sc.nextLine();
        try {
            saveAdminToDatabase(name, mobno, username, password, String.valueOf(UID));
            System.out.println("REGISTRATION DONE SUCCESSFULLY! FOR " + name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void add_products() {

    }

    private void product_page() {
        item.item_show();
        view_groceries();
    }
    private void printAllUsers() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String query = "SELECT * FROM user";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                System.out.println("Existing Users:");

                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String mobno = resultSet.getString("mobno");
                    String username = resultSet.getString("username");

                    System.out.println("Name: " + name + ", Mobile Number: " + mobno +
                            ", Username: " + username);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void remove_product( ) {

    }
    private static String UID;

    private static void setAdminUID(String adminID) {
        UID = adminID;
    }
    private void editProfile(String adminUID) {
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
                    updateProfileField("name", newName, adminUID, connection);
                    System.out.println("Name updated successfully!");
                    break;
                }
                case 2: {
                    System.out.println("Please enter your new mobile number:");
                    String newNumber = sc.nextLine();
                    updateProfileField("mobno", newNumber, adminUID, connection);
                    System.out.println("Mobile number updated successfully!");
                    break;
                }
                case 3: {
                    System.out.println("Please enter your new password:");
                    String newPassword = sc.nextLine();
                    updateProfileField("password", newPassword, adminUID, connection);
                    System.out.println("Password updated successfully!");
                    break;
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateProfileField(String field, String value, String UID, Connection connection) throws SQLException {
        String query = "UPDATE admin SET " + field + " = ? WHERE UID = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, value);
            preparedStatement.setString(2, UID);
            preparedStatement.executeUpdate();
        }
    }
    public static boolean validate_Admin(String username, String password, String UID) throws SQLException {
        Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        String query = "SELECT * FROM admin WHERE username = ? AND password = ? AND UID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, UID);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String adminID = resultSet.getString("UID");
                Admin.setAdminUID(adminID);
                System.out.println("Admin ID: " + UID+" Verification Successful");
                return true;
            } else {
                return false;
            }
        }
    }

    public static void saveAdminToDatabase(String name, String mobno, String username, String password, String UID) throws SQLException {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "INSERT INTO admin (name, mobno, username, password, UID) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, mobno);
                preparedStatement.setString(3, username);
                preparedStatement.setString(4, password);
                preparedStatement.setString(5, UID);
                preparedStatement.executeUpdate();
            }
        }
    }
}
