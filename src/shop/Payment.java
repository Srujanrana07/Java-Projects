package shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Payment {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/store";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    private Items item = new Items();

    public void makePayment(String username, ArrayList<String> cartList) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {

            double walletBalance = getWalletBalance(username, connection);

            double totalAmount = calculateTotalAmount(cartList);


            if (walletBalance >= totalAmount) {

                System.out.println("Total amount: " + totalAmount);
                System.out.println("Wallet balance: " + walletBalance);
                System.out.println("Payment successful!");
                updateWalletBalance(username, walletBalance - totalAmount, connection);
                updateLastPayment(username, totalAmount, connection);
                System.out.println("Wallet Ballance left"+(walletBalance - totalAmount));
            } else {
                System.out.println("Insufficient funds in the wallet!");
                System.out.println("Total amount needed: " + totalAmount);
                System.out.println("Please add money to your wallet to complete the payment.");
                addMoneyToWallet(username, connection);
                totalAmount= 0.0;
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private double getWalletBalance(String username, Connection connection) throws SQLException {
        String query = "SELECT Wallet FROM user WHERE username = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getDouble("Wallet");
            } else {
                throw new SQLException("User not found");
            }
        }
    }

    private void updateWalletBalance(String username, double newBalance, Connection connection) throws SQLException {
        String query = "UPDATE user SET Wallet = ? WHERE username = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, newBalance);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();
        }
    }
    static double totalAmount = 0.0;
    private double calculateTotalAmount(ArrayList<String> cartList) {
        double totalAmount = 0.0;
        for (String itemName : cartList) {
            int category = getCategoryByItemName(itemName);
            double itemPrice = item.getItemPrice(itemName, category);
            totalAmount += itemPrice;
        }
        return totalAmount;
    }

    private int getCategoryByItemName(String itemName) {
        if (item.isElectronicItem(itemName)) {
            return 1;
        } else if (item.isGroceriesItem(itemName)) {
            return 2;
        }
        else if (item.isMedicinesItem(itemName)) {
            return 3;
        }
        else if (item.isTVsMobilesItem(itemName)) {
            return 4;
        }
        else if (item.isHomeKitchensItem(itemName)) {
            return 5;
        }
        else if (item.isDecorItem(itemName)) {
            return 6;
        }
        else if (item.isBeautyItem(itemName)) {
            return 7;
        }
        return 0;
    }
    private void updateLastPayment(String username, double totalAmount, Connection connection) throws SQLException {
        String query = "UPDATE user SET LastPayment = ? WHERE username = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, totalAmount);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();
        }
    }
    private void addMoneyToWallet(String username, Connection connection) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to add to your wallet: $");
        double amountToAdd = scanner.nextDouble();

        try {
            double currentBalance = getWalletBalance(username, connection);
            updateWalletBalance(username, currentBalance + amountToAdd, connection);
            System.out.println("Amount added to the wallet successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
