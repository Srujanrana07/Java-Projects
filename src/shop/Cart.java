package shop;

import java.util.ArrayList;
import java.util.Scanner;

public class Cart {
    Items item = new Items();
    Scanner sc = new Scanner(System.in);
    ArrayList<String> cart_list = new ArrayList<String>();
    private int choice;
    private double totalAmount = 0.0;
    public void add_cart() {
        choice = item.getChoice();
        System.out.println("Please Enter item name to your cart: ");
        String itemName = sc.nextLine().toLowerCase();
        double itemPrice = item.getItemPrice(itemName, choice);

        switch (choice) {
            case 1:
                if (item.isElectronicItem(itemName)) {
                    System.out.println(itemName + " is added to the cart.");
                    cart_list.add(itemName);
                    totalAmount += itemPrice;
                } else {
                    System.out.println(itemName + " is not available.");
                }
                break;
            case 2:
                if (item.isGroceriesItem(itemName)) {
                    System.out.println(itemName + " is added to the cart.");
                    cart_list.add(itemName);
                    totalAmount += itemPrice;
                } else {
                    System.out.println(itemName + " is not available.");
                }
                break;
            case 3:
                if (item.isMedicinesItem(itemName)) {
                    System.out.println(itemName + " is added to the cart.");
                    cart_list.add(itemName);
                    totalAmount += itemPrice;
                } else {
                    System.out.println(itemName + " is not available.");
                }
                break;
            case 4:
                if (item.isTVsMobilesItem(itemName)) {
                    System.out.println(itemName + " is added to the cart.");
                    cart_list.add(itemName);
                    totalAmount += itemPrice;
                } else {
                    System.out.println(itemName + " is not available.");
                }
                break;
            case 5:
                if (item.isHomeKitchensItem(itemName)) {
                    System.out.println(itemName + " is added to the cart.");
                    cart_list.add(itemName);
                    totalAmount += itemPrice;
                } else {
                    System.out.println(itemName + " is not available.");
                }
                break;
            case 6:
                if (item.isDecorItem(itemName)) {
                    System.out.println(itemName + " is added to the cart.");
                    cart_list.add(itemName);
                    totalAmount += itemPrice;
                } else {
                    System.out.println(itemName + " is not available.");
                }
                break;
            case 7:
                if (item.isBeautyItem(itemName)) {
                    System.out.println(itemName + " is added to the cart.");
                    cart_list.add(itemName);
                    totalAmount += itemPrice;
                } else {
                    System.out.println(itemName + " is not available.");
                }
                break;
            default:
                System.out.println("Wrong Choice");
        }
    }
    static double total_Amount = 0.0;

    public void view_cart(){
        System.out.println("Your Cart Items are:");
        int serialNumber = 1;
        for (String cart : cart_list) {
            System.out.println(serialNumber + ". " + cart);
            serialNumber++;
        }
    }


    public void remove_cart() {
        view_cart();
        System.out.println("Enter number u want to remove : ");
        int n;
        n = sc.nextInt();
        totalAmount -= item.getItemPrice(cart_list.get(n - 1), choice);
        cart_list.remove(n - 1);
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public ArrayList<String> getCartList() {
        return cart_list;
    }


}
