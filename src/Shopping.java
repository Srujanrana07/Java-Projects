import java.sql.*;
import java.util.Random;
import java.util.Scanner;
import shop.Admin;
import shop.User;

public class Shopping {
    static int ch;
    static Admin admin = new Admin();
    static User user = new User();

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO ONLINE SHOPPING SYSTEM\n");
        System.out.println("***************************************************************************************************************\n");
        System.out.println("1 - REGISTER AS CUSTOMER");
        System.out.println("2 - LOGIN AS CUSTOMER");
        System.out.println("3 - LOGIN AS ADMIN");
        System.out.println("4 - EXIT");
        System.out.println("***************************************************************************************************************\n");
        System.out.print("Enter choice : ");
        ch = sc.nextInt();
        if (ch == 1)
            registerCustomer();
        else if (ch == 2)
            loginCustomer();
        else if (ch == 3)
            loginAdmin();
        else if (ch == 4)
            exit();
        else
            System.out.println("Wrong choice");
    }


    static void loginAdmin() {
        Scanner scanner = new Scanner(System.in);
        String username_admin, pass ,UID;
        System.out.println("\nWELCOME TO ADMIN LOGIN PAGE\n");
        System.out.println("**************************************************************************************\n");
        try {
            System.out.println("ENTER UR UID : ");
            UID = scanner.nextLine();
            System.out.print("ENTER UR USERNAME : ");
            username_admin = scanner.nextLine();
            System.out.print("ENTER PASSWORD : ");
            pass = scanner.nextLine();

            if (Admin.validate_Admin(username_admin, pass,UID)) {
                System.out.println("LOGIN DONE SUCCESSFULLY !");
                admin.admin_page();
            } else {
                System.out.println("Invalid username or password. Please try again.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void loginCustomer() {
        Scanner scanner = new Scanner(System.in);
        String username, pass;
        System.out.println("\nWELCOME TO CUSTOMER LOGIN PAGE\n");
        System.out.println("**********************************************************************************\n");
        try {
            System.out.print("ENTER UR USERNAME : ");
            username = scanner.nextLine();
            System.out.print("ENTER PASSWORD : ");
            pass = scanner.nextLine();

            if (User.validate_Customer(username, pass)) {
                System.out.println("LOGIN DONE SUCCESSFULLY !");
                user.CustomerPage();
            } else {
                System.out.println("Invalid username or password. Please try again.");
                System.out.println("Please Register Your username if not found ");
                Scanner sc = new Scanner(System.in);
                System.out.println("1>Register \n2>Re Login");
                int n = sc.nextInt();
                if(n == 1){
                    registerCustomer();
                }else if(n== 2)
                    loginCustomer();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void registerCustomer() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nWELCOME TO CUSTOMER REGISTRATION PAGE\n");
        System.out.println("*****************************************************\n");
//        Random random = new Random();
//        char letter = (char) ('A' + random.nextInt(26));
//        int number = 10 + random.nextInt(90);
//        String UID = String.valueOf(letter) + number;

        System.out.print("Enter Name = ");
        String name = sc.nextLine();
        System.out.print("Enter Password = ");
        String password = sc.nextLine();
        System.out.print("Enter Username = ");
        String username = sc.nextLine();
        System.out.print("Enter Contact Number = ");
        String mobno = sc.nextLine();
        user.saveUserToDatabase(name, mobno, username, password);

        System.out.println("REGISTRATION DONE SUCCESSFULLY! FOR " + name);
        loginCustomer();
    }
    static void exit(){
        System.out.println("Thankyou For Visiting Us");
    }
}
