package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;
import shop.*;


public class Shopping extends JFrame {
    public final User user;
    private final Admin admin = new Admin();
    private final JPanel mainPanel;
    private final JLabel welcomeLabel;
    private final JButton registerCustomerButton;
    private final JButton loginCustomerButton;
    private final JButton loginAdminButton;
    private final JButton exitButton;

    public Shopping() {
        setTitle("Online gui.Shopping System");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        welcomeLabel = new JLabel("WELCOME TO ONLINE SHOPPING SYSTEM");
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        registerCustomerButton = new JButton("REGISTER AS CUSTOMER");
        loginCustomerButton = new JButton("LOGIN AS CUSTOMER       ");
        loginAdminButton = new JButton(" LOGIN AS ADMIN               ");
        exitButton = new JButton("EXIT                                      ");

        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();
                if (button == registerCustomerButton) {
                    try {
                        registerCustomer();
                    } catch (SQLException ex) {
                        handleException(ex);
                    }
                } else if (button == loginCustomerButton) {
                    try {
                        loginCustomer();
                    } catch (SQLException ex) {
                        handleException(ex);
                    }
                } else if (button == loginAdminButton) {
                    try {
                        loginAdmin();
                    } catch (SQLException ex) {
                        handleException(ex);
                    }
                } else if (button == exitButton) {
                    exit();
                }
            }
        };

        Dimension buttonSize = new Dimension(200, 50);
        registerCustomerButton.setPreferredSize(buttonSize);
        loginCustomerButton.setPreferredSize(buttonSize);
        loginAdminButton.setPreferredSize(buttonSize);
        exitButton.setPreferredSize(buttonSize);

        registerCustomerButton.addActionListener(buttonListener);
        loginCustomerButton.addActionListener(buttonListener);
        loginAdminButton.addActionListener(buttonListener);
        exitButton.addActionListener(buttonListener);

        mainPanel.add(welcomeLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(registerCustomerButton);
        mainPanel.add(loginCustomerButton);
        mainPanel.add(loginAdminButton);
        mainPanel.add(exitButton);

        add(mainPanel);
        setLocationRelativeTo(null);
        setVisible(true);
        user = new User();
    }

    public static void main(String[] args) {
        new Shopping();
    }

    private void loginAdmin() throws SQLException {
        String username_admin, pass, UID;
        UID = JOptionPane.showInputDialog(null, "ENTER UR UID : ");
        username_admin = JOptionPane.showInputDialog(null, "ENTER UR USERNAME : ");
        pass = JOptionPane.showInputDialog(null, "ENTER PASSWORD : ");
        if (Admin.validate_Admin(username_admin, pass, UID)) {
            JOptionPane.showMessageDialog(null, "LOGIN DONE SUCCESSFULLY !");
            admin.admin_page();
        } else {
            JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
        }
    }

    private void loginCustomer() throws SQLException {
        String username, pass, UID;
        UID = JOptionPane.showInputDialog(null, "ENTER UR UID : ");
        username = JOptionPane.showInputDialog(null, "ENTER UR USERNAME : ");
        pass = JOptionPane.showInputDialog(null, "ENTER PASSWORD : ");
        if (User.validate_Customer(username, pass)) {
            JOptionPane.showMessageDialog(null, "LOGIN DONE SUCCESSFULLY !");
            getUser().CustomerPage();
        } else {
            JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
            int choice = JOptionPane.showConfirmDialog(null, "Do you want to register?", "Please Register Your username if not found", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                registerCustomer();
            }
        }
    }

    private void registerCustomer() throws SQLException {
        Random random = new Random();
        char letter = (char) ('A' + random.nextInt(26));
        int number = 100 + random.nextInt(900);
        String UID = String.valueOf(letter) + number;
        String name = JOptionPane.showInputDialog(null, "Enter Name = ");
        String password = JOptionPane.showInputDialog(null, "Enter Password = ");
        String username = JOptionPane.showInputDialog(null, "Enter Username = ");
        String mobno = JOptionPane.showInputDialog(null, "Enter Contact Number = ");
        getUser().saveUserToDatabase(name, mobno, username, password, UID);
        JOptionPane.showMessageDialog(null, "REGISTRATION DONE SUCCESSFULLY! FOR " + name);
        loginCustomer();
    }

    private void exit() {
        dispose();
        System.exit(0);
    }

    private void handleException(Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    public User getUser() {
        return user;
    }
}
