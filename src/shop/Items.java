package shop;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
public class Items {
    String item_list[] = {"1> Electronics", "2> Groceries", "3> Medicine", "4> TVs and Mobiles", "5> Home & Kitchen", "6> Decor", "7> Beauty"};
    private static Map<String, Integer> groceries_item;
    private static Map<String, Integer> electronics_item;
    private static Map<String, Integer> TVsMobilesItems;
    private static Map<String, Integer> home_kitchens_item;
    private static Map<String, Integer> decorItems;
    private static Map<String, Integer> beautyItems;
    private static Map<String, Integer> medicines_item;
    public Items() {
        groceries_item = new HashMap<>();
        electronics_item = new HashMap<>();
        TVsMobilesItems = new HashMap<>();
        decorItems = new HashMap<>();
        home_kitchens_item = new HashMap<>();
        beautyItems= new HashMap<>();
        medicines_item= new HashMap<>();
        initializeElectronicsItems();
        initializeGroceriesItems();
        initializeMedicineItems();
        initializeTVsMobilesItems();
        initializeDecorItems();
        initializeBeautyItems();
        initializeHomeKitchensItems();
    }

//***********************************
    private void initializeTVsMobilesItems() {
        String[] TVsMobiles = {"realme", "mi9", "samsung-a20"};
        int[] TVsMobilesPrices = {30000, 40000, 15000};
        TVsMobilesItems = new HashMap<>();
        for (int i = 0; i < TVsMobiles.length; i++) {
            TVsMobilesItems.put(TVsMobiles[i].toLowerCase(), TVsMobilesPrices[i]);
        }
    }

    public void TVsMobilesItems_dict() {
        System.out.println("TVs and Mobiles Items:");
        for (Map.Entry<String, Integer> entry : TVsMobilesItems.entrySet()) {
            System.out.println("Item: " + entry.getKey() + ", Price: " + entry.getValue());
        }
    }

    public boolean isTVsMobilesItem(String itemName) {
        return TVsMobilesItems.containsKey(itemName.toLowerCase());
    }
//********************************
    private void initializeBeautyItems() {
        String[] beauty = {"foundation", "eye shadow", "lip gloss"};
        int[] beautyPrices = {200, 60, 90};
        beautyItems = new HashMap<>();
        for (int i = 0; i < beauty.length; i++) {
            beautyItems.put(beauty[i].toLowerCase(), beautyPrices[i]);
        }
    }

    public void BeautyItem_dict() {
        System.out.println("Beauty Items:");
        for (Map.Entry<String, Integer> entry : beautyItems.entrySet()) {
            System.out.println("Item: " + entry.getKey() + ", Price: " + entry.getValue());
        }
    }

    public boolean isBeautyItem(String itemName) {
        return beautyItems.containsKey(itemName.toLowerCase());
    }
//    ********************************
    private void initializeDecorItems() {
        String[] decor = {"lamp light", "vase", "stylish wooden"};
        int[] decorPrices = {800, 150, 300};
        decorItems = new HashMap<>();
        for (int i = 0; i < decor.length; i++) {
            decorItems.put(decor[i].toLowerCase(), decorPrices[i]);
        }
    }

    public void DecorItems_dict() {
        System.out.println("Decor Items:");
        for (Map.Entry<String, Integer> entry : decorItems.entrySet()) {
            System.out.println("Item: " + entry.getKey() + ", Price: " + entry.getValue());
        }
    }

    public boolean isDecorItem(String itemName) {
        return decorItems.containsKey(itemName.toLowerCase());
    }
//*********************************
    private void initializeHomeKitchensItems() {
        String Home_kitchens[] = {"Dinning", "Bedsheets", "Kitchenware"};
        int Home_kitchens_price[] = {2000, 800, 600};
        home_kitchens_item = new HashMap<>();
        for (int i = 0; i < Home_kitchens.length; i++) {
            home_kitchens_item.put(Home_kitchens[i].toLowerCase(), Home_kitchens_price[i]);
        }
    }

    public void home_kitchens_dict() {
        for (Map.Entry<String, Integer> entry : home_kitchens_item.entrySet()) {
            System.out.println("Home and Kitchen Item: " + entry.getKey() + ", Price: " + entry.getValue());
        }
    }

    public boolean isHomeKitchensItem(String itemName) {
        return home_kitchens_item.containsKey(itemName.toLowerCase());
    }

    //*******************************************
    private void initializeMedicineItems() {
        String medicines[] = {"paracetamol", "ibuprofen", "aspirin"};
        int medicines_price[] = {137, 65, 81};
        for (int i = 0; i < medicines.length; i++) {
            medicines_item.put(medicines[i].toLowerCase(), medicines_price[i]);
        }
    }
    public static void medicines_dict() {
        for (Map.Entry<String, Integer> entry : medicines_item.entrySet()) {
            System.out.println( entry.getKey() + ", Price: " + entry.getValue());
        }
    }
    public boolean isMedicinesItem(String itemName) {
        for (String medicines : medicines_item.keySet()) {
            if (medicines.equalsIgnoreCase(itemName)) {
                return true;
            }
        }
        return false;
    }
//***************************************
    private void initializeElectronicsItems() {
        String electronics[] = {"Calculators", "scanners", "computers", "printers", "fax machines", "front projectors", "refrigerators", "washing machine", "vacuum cleaner", "microwave oven"};
        int electronics_price[] = {1000, 2000, 4000, 4329, 1033, 1345, 8432, 10000, 1023, 999};
        for (int i = 0; i < electronics.length; i++) {
            electronics_item.put(electronics[i].toLowerCase(), electronics_price[i]);
        }
    }
    public void electronics_dict() {
        for (Map.Entry<String, Integer> entry : electronics_item.entrySet()) {
            System.out.println("Electronic Item: " + entry.getKey() + ", Price: " + entry.getValue());
        }
    }
    public boolean isElectronicItem(String itemName) {
        for (String electronic : electronics_item.keySet()) {
            if (electronic.equalsIgnoreCase(itemName)) {
                return true;
            }
        }
        return false;
    }
//    ******************************
    private void initializeGroceriesItems() {
        String groceries[] = {"Rice", "Roti", "abc", "cyc", "fax sa", "frasdont"};
        int groceries_price[] = {100, 102, 432, 423, 213, 99};
        for (int i = 0; i < groceries.length; i++) {
            groceries_item.put(groceries[i].toLowerCase(), groceries_price[i]);
        }
    }
    public static void groceries_dict() {
        for (Map.Entry<String, Integer> entry : groceries_item.entrySet()) {
            System.out.println( entry.getKey() + ", Price: " + entry.getValue());
        }
    }
    public boolean isGroceriesItem(String itemName) {
        for (String groceries : groceries_item.keySet()) {
            if (groceries.equalsIgnoreCase(itemName)) {
                return true;
            }
        }
        return false;
    }
//**********************************
    void addNew_item(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("In which category u want to add:");
        for (String item : item_list) {
            System.out.println(item);
        }
        int no= scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the name of the new item:");
        String newItem = scanner.nextLine();
        System.out.println("Enter the price of the new item:");
        int newPrice = scanner.nextInt();
        switch (no){
            case 1:
                electronics_item.put(newItem, newPrice);
                System.out.println("New electronic item added: " + newItem + ", Price: " + newPrice);
                System.out.println("Electronic Items:");
                for (Map.Entry<String, Integer> entry : electronics_item.entrySet()) {
                    System.out.println("Item: " + entry.getKey() + ", Price: " + entry.getValue());
                }
                break;

            case 2:
                groceries_item.put(newItem, newPrice);
                System.out.println("New Groceries item added: " + newItem + ", Price: " + newPrice);
                System.out.println("Groceries Items:");
                for (Map.Entry<String, Integer> entry : groceries_item.entrySet()) {
                    System.out.println("Item: " + entry.getKey() + ", Price: " + entry.getValue());
                }
                break;
            case 3:
                medicines_item.put(newItem, newPrice);
                System.out.println("New Medicines item added: " + newItem + ", Price: " + newPrice);
                System.out.println("Medicines Items:");
                for (Map.Entry<String, Integer> entry : medicines_item.entrySet()) {
                    System.out.println("Item: " + entry.getKey() + ", Price: " + entry.getValue());
                }
                break;
            case 4:
                TVsMobilesItems.put(newItem, newPrice);
                System.out.println("New TVs_mobiles item added: " + newItem + ", Price: " + newPrice);
                System.out.println("TVs_mobiles Items:");
                for (Map.Entry<String, Integer> entry : TVsMobilesItems.entrySet()) {
                    System.out.println("Item: " + entry.getKey() + ", Price: " + entry.getValue());
                }
                break;
            case 5:
                home_kitchens_item.put(newItem, newPrice);
                System.out.println("New Home_kitchens item added: " + newItem + ", Price: " + newPrice);
                System.out.println("Home_kitchens Items:");
                for (Map.Entry<String, Integer> entry : home_kitchens_item.entrySet()) {
                    System.out.println("Item: " + entry.getKey() + ", Price: " + entry.getValue());
                }
                break;
            case 6:
                decorItems.put(newItem, newPrice);
                System.out.println("New Decor item added: " + newItem + ", Price: " + newPrice);
                System.out.println("Decor Items:");
                for (Map.Entry<String, Integer> entry : decorItems.entrySet()) {
                    System.out.println("Item: " + entry.getKey() + ", Price: " + entry.getValue());
                }
                break;
            case 7:
                beautyItems.put(newItem, newPrice);
                System.out.println("New Beauty item added: " + newItem + ", Price: " + newPrice);
                System.out.println("Beauty Items:");
                for (Map.Entry<String, Integer> entry : beautyItems.entrySet()) {
                    System.out.println("Item: " + entry.getKey() + ", Price: " + entry.getValue());
                }
                break;
            default:
                System.out.println("Invalid category choice");
                break;
        }
    }

    void remove_item() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("In which category do you want to remove an item:");
        for (String item : item_list) {
            System.out.println(item);
        }
        int no = scanner.nextInt();
        String removeItem;
        scanner.nextLine();
        switch (no) {
            case 1:
                Map<String, Integer> lowerCaseElectronicsItem = new HashMap<>();

                for (Map.Entry<String, Integer> entry : electronics_item.entrySet()) {
                    lowerCaseElectronicsItem.put(entry.getKey().toLowerCase(), entry.getValue());
                }

                for (Map.Entry<String, Integer> entry : lowerCaseElectronicsItem.entrySet()) {
                    System.out.println("Item: " + entry.getKey() + ", Price: " + entry.getValue());
                }

                System.out.println("Enter the name of the item to remove:");
                removeItem = scanner.nextLine().toLowerCase();
                lowerCaseElectronicsItem.remove(removeItem);
                System.out.println("Electronic item removed: " + removeItem);
                System.out.println("Updated Electronic Items:");
                for (Map.Entry<String, Integer> entry : lowerCaseElectronicsItem.entrySet()) {
                    System.out.println("Item: " + entry.getKey() + ", Price: " + entry.getValue());
                }
                break;


            case 2:
                Map<String, Integer> lowerCaseGroceriesItem = new HashMap<>();

                for (Map.Entry<String, Integer> entry : groceries_item.entrySet()) {
                    lowerCaseGroceriesItem.put(entry.getKey().toLowerCase(), entry.getValue());
                }

                for (Map.Entry<String, Integer> entry : lowerCaseGroceriesItem.entrySet()) {
                    System.out.println("Item: " + entry.getKey() + ", Price: " + entry.getValue());
                }

                System.out.println("Enter the name of the item to remove:");
                removeItem = scanner.nextLine().toLowerCase();
                lowerCaseGroceriesItem.remove(removeItem);
                System.out.println("Groceries item removed: " + removeItem);
                System.out.println("Updated Groceries Items:");
                for (Map.Entry<String, Integer> entry : lowerCaseGroceriesItem.entrySet()) {
                    System.out.println("Item: " + entry.getKey() + ", Price: " + entry.getValue());
                }
                break;
            case 3:
                Map<String, Integer> lowerCaseMedicinesItem = new HashMap<>();

                for (Map.Entry<String, Integer> entry : medicines_item.entrySet()) {
                    lowerCaseMedicinesItem.put(entry.getKey().toLowerCase(), entry.getValue());
                }

                for (Map.Entry<String, Integer> entry : lowerCaseMedicinesItem.entrySet()) {
                    System.out.println("Item: " + entry.getKey() + ", Price: " + entry.getValue());
                }

                System.out.println("Enter the name of the item to remove:");
                removeItem = scanner.nextLine().toLowerCase();
                lowerCaseMedicinesItem.remove(removeItem);
                System.out.println("Medicines item removed: " + removeItem);
                System.out.println("Updated Medicines Items:");
                for (Map.Entry<String, Integer> entry : lowerCaseMedicinesItem.entrySet()) {
                    System.out.println("Item: " + entry.getKey() + ", Price: " + entry.getValue());
                }
                break;
            case 4:
                Map<String, Integer> lowerCaseTVs_mobiles_Item = new HashMap<>();

                for (Map.Entry<String, Integer> entry : TVsMobilesItems.entrySet()) {
                    lowerCaseTVs_mobiles_Item.put(entry.getKey().toLowerCase(), entry.getValue());
                }

                for (Map.Entry<String, Integer> entry : lowerCaseTVs_mobiles_Item.entrySet()) {
                    System.out.println("Item: " + entry.getKey() + ", Price: " + entry.getValue());
                }

                System.out.println("Enter the name of the item to remove:");
                removeItem = scanner.nextLine().toLowerCase();
                lowerCaseTVs_mobiles_Item.remove(removeItem);
                System.out.println("TVs_mobiles item removed: " + removeItem);
                System.out.println("Updated TVs_mobiles Items:");
                for (Map.Entry<String, Integer> entry : lowerCaseTVs_mobiles_Item.entrySet()) {
                    System.out.println("Item: " + entry.getKey() + ", Price: " + entry.getValue());
                }
                break;
            case 5:
                Map<String, Integer> lowerCaseHome_kitchens_Item = new HashMap<>();

                for (Map.Entry<String, Integer> entry : home_kitchens_item.entrySet()) {
                    lowerCaseHome_kitchens_Item.put(entry.getKey().toLowerCase(), entry.getValue());
                }

                for (Map.Entry<String, Integer> entry : lowerCaseHome_kitchens_Item.entrySet()) {
                    System.out.println("Item: " + entry.getKey() + ", Price: " + entry.getValue());
                }

                System.out.println("Enter the name of the item to remove:");
                removeItem = scanner.nextLine().toLowerCase();
                lowerCaseHome_kitchens_Item.remove(removeItem);
                System.out.println("Home_kitchens item removed: " + removeItem);
                System.out.println("Updated Home_kitchens Items:");
                for (Map.Entry<String, Integer> entry : lowerCaseHome_kitchens_Item.entrySet()) {
                    System.out.println("Item: " + entry.getKey() + ", Price: " + entry.getValue());
                }
                break;
            case 6:
                Map<String, Integer> lowerCaseDecorsItem = new HashMap<>();

                for (Map.Entry<String, Integer> entry : decorItems.entrySet()) {
                    lowerCaseDecorsItem.put(entry.getKey().toLowerCase(), entry.getValue());
                }

                for (Map.Entry<String, Integer> entry : lowerCaseDecorsItem.entrySet()) {
                    System.out.println("Item: " + entry.getKey() + ", Price: " + entry.getValue());
                }

                System.out.println("Enter the name of the item to remove:");
                removeItem = scanner.nextLine().toLowerCase();
                lowerCaseDecorsItem.remove(removeItem);
                System.out.println("Medicines item removed: " + removeItem);
                System.out.println("Updated Decors Items:");
                for (Map.Entry<String, Integer> entry : lowerCaseDecorsItem.entrySet()) {
                    System.out.println("Item: " + entry.getKey() + ", Price: " + entry.getValue());
                }
                break;
            case 7:
                Map<String, Integer> lowerCaseBeautyItem = new HashMap<>();

                for (Map.Entry<String, Integer> entry : beautyItems.entrySet()) {
                    lowerCaseBeautyItem.put(entry.getKey().toLowerCase(), entry.getValue());
                }

                for (Map.Entry<String, Integer> entry : lowerCaseBeautyItem.entrySet()) {
                    System.out.println("Item: " + entry.getKey() + ", Price: " + entry.getValue());
                }

                System.out.println("Enter the name of the item to remove:");
                removeItem = scanner.nextLine().toLowerCase();
                lowerCaseBeautyItem.remove(removeItem);
                System.out.println("Beauty item removed: " + removeItem);
                System.out.println("Updated Beauty Items:");
                for (Map.Entry<String, Integer> entry : lowerCaseBeautyItem.entrySet()) {
                    System.out.println("Item: " + entry.getKey() + ", Price: " + entry.getValue());
                }
                break;
            default:
                System.out.println("Item not found");
                break;
        }
    }
    public double getItemPrice(String itemName, int category) {
        itemName = itemName.toLowerCase();

        if (category == 1 && isElectronicItem(itemName)&& electronics_item.containsKey(itemName) ) {
            return electronics_item.get(itemName);
        } else if (category == 2 && isGroceriesItem(itemName) && groceries_item.containsKey(itemName)) {
            return groceries_item.get(itemName);
        } else if (category == 3 && isMedicinesItem(itemName) && medicines_item.containsKey(itemName)) {
            return medicines_item.get(itemName);
        }
        else if (category == 4 && isTVsMobilesItem(itemName) && TVsMobilesItems.containsKey(itemName)) {
            return TVsMobilesItems.get(itemName);
        }
        else if (category == 5 && isHomeKitchensItem(itemName) && home_kitchens_item.containsKey(itemName)) {
            return home_kitchens_item.get(itemName);
        }
        else if (category == 6 && isDecorItem(itemName) && decorItems.containsKey(itemName)) {
            return decorItems.get(itemName);
        }
        else if (category == 7 && isBeautyItem(itemName) && beautyItems.containsKey(itemName)) {
            return beautyItems.get(itemName);
        }
        else {
            System.out.println("Item not found");
            return 0;
        }
    }




    void groceries_show() {
        for (String item : item_list) {
            System.out.println(item);
        }
        System.out.println("8> Back");
    }
    private static int choice;
    protected void view_item() {
        System.out.println("Please Enter Ur choice :");
        Scanner sc=new Scanner(System.in);
        choice=sc.nextInt();
        switch (choice){
            case 1:
                System.out.println("Showing Electronics items: ");
                electronics_dict();
                break;
            case 2:
                System.out.println("Showing Groceries items: ");
                groceries_dict();
                break;
            case 3:
                System.out.println("Showing Medicine items: ");
                medicines_dict();
                break;
            case 4:
                System.out.println("Showing Tvs and Mobiles items: ");
                TVsMobilesItems_dict();
                break;
            case 5:
                System.out.println("Showing Home & Kitchen items: ");
                home_kitchens_dict();
                break;
            case 6:
                System.out.println("Showing Decor items: ");
                DecorItems_dict();
                break;
            case 7:
                System.out.println("Showing Beauty items: ");
                BeautyItem_dict();
                break;
            case 8:
                User user=new User();
                user.CustomerPage();
            default:
                System.out.println("Invalid choice.");
        }
    }
    public static int getChoice() {
        return choice;
    }
}
