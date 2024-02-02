package shop;

import java.util.ArrayList;
import java.util.Scanner;

public class Cart {
    Items item=new Items();
    Scanner sc=new Scanner(System.in);
    ArrayList<String> cart_list = new ArrayList<String>();
    private int choice;
    public void add_cart(){
        Scanner sc = new Scanner(System.in);
        choice=item.getChoice();
        System.out.println("Please Enter item name to your cart: ");
        String itemName = sc.nextLine().toLowerCase();
        switch (choice){
            case 1:
                if (item.isElectronicItem(itemName)) {
                    System.out.println(itemName + " is added to the cart.");
                    cart_list.add(itemName);
                } else {
                    System.out.println(itemName + " is not available.");
                }
                break;
            case 2:
                if (item.isGroceriesItem(itemName)) {
                    System.out.println(itemName + " is added to the cart.");
                    cart_list.add(itemName);
                } else {
                    System.out.println(itemName + " is not available.");
                }
                break;
            default:
                System.out.println("Wrong Choice");
        }
    }
    public void view_cart(){
        System.out.println("Your Cart Items are:");
        int serialNumber = 1;
        for (String cart : cart_list) {
            System.out.println(serialNumber + ". " + cart);
            serialNumber++;
        }
    }
    public void remove_cart(){
        view_cart();
        System.out.println("Enter number u want to remove : ");
        int n;
        Scanner sc =new Scanner(System.in);
        n=sc.nextInt();
        cart_list.remove((n-1));
    }
}

