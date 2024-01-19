//package shop;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class Cart{
//    Items item=new Items();
//    void add_cart(){
//        item.item_add();
//    }
//    void view_cart() {
//        System.out.println("Items available in your cart are :");
//        ArrayList<String> cartList = item.getCartList();
//        for (String item : cartList) {
//            System.out.println(item);
//        }
//    }
//    void remove_cart(){
//        Scanner sc=new Scanner(System.in);
//        System.out.println("Enter the product name to remove from cart list:");
//        String cart_name = sc.nextLine();
//        cart_name=cart_name.toLowerCase();
//        ArrayList<String> cartList = item.getCartList();
//        for (int i = 0; i < cartList.size(); i++) {
//            String currentItem = cartList.get(i).toLowerCase();
//            if (cart_name.equals(currentItem)) {
//                System.out.println(cartList.get(i) + " removed from your cart list");
//                cartList.remove(i);
//                return;
//            }
//        }
//    }
//}
