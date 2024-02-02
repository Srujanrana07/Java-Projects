package shop;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
public class Items {
    public Items(){
        electronics_dict();
        groceries_dict();
    }
    Scanner sc = new Scanner(System.in);
    String item_list[] = {"1> Electronics", "2> Groceries", "3> Medicine", "4> TVs and Mobiles", "5> Home & Kitchen", "6> Decor", "7> Beauty"};
    private static Map<String, Integer> electronics_item;
    private static Map<String, Integer> groceries_item;
    public static void groceries_dict() {
        String groceries[] = {"Rice", "Roti", "abc", "cyc", "fax sa", "frasdont"};
        int groceries_price[] = {100, 102, 432, 423, 213, 99};

        groceries_item = new HashMap<>();

        for (int i = 0; i < groceries.length; i++) {
            groceries_item.put(groceries[i], groceries_price[i]);
        }

        for (Map.Entry<String, Integer> entry : groceries_item.entrySet()) {
            System.out.println( entry.getKey() + ", Price: " + entry.getValue());
        }
    }
    public static boolean isGroceriesItem(String itemName) {
        return groceries_item.containsKey(itemName);
    }


    public void electronics_dict() {
        String electronics[] = {"calculators", "scanners", "computers", "printers", "fax machines", "front projectors", "refrigerators", "washing machine", "vacuum cleaner", "microwave oven"};
        int electronics_price[] = {1000, 2000, 4000, 4329, 1033, 1345, 8432, 10000, 1023, 999};

        electronics_item = new HashMap<>();

        for (int i = 0; i < electronics.length; i++) {
            electronics_item.put(electronics[i], electronics_price[i]);
        }

        for (Map.Entry<String, Integer> entry : electronics_item.entrySet()) {
            System.out.println("Electronic Item: " + entry.getKey() + ", Price: " + entry.getValue());
        }
    }
    public static boolean isElectronicItem(String itemName) {
        return electronics_item.containsKey(itemName);
    }

    void addNew_item(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the new electronic item:");
        String newItem = scanner.nextLine();
        System.out.println("Enter the price of the new electronic item:");
        int newPrice = scanner.nextInt();
        electronics_item.put(newItem, newPrice);
        System.out.println("New electronic item added: " + newItem + ", Price: " + newPrice);
        System.out.println("Electronic Items:");
        for (Map.Entry<String, Integer> entry : electronics_item.entrySet()) {
            System.out.println("Item: " + entry.getKey() + ", Price: " + entry.getValue());
        }
    }




    void groceries_show() {
        for (String item : item_list) {
            System.out.println(item);
        }
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

                break;
            case 4:
                System.out.println("Showing Tvs and Mobiles items: ");

                break;
            case 5:
                System.out.println("Showing Home & Kitchen items: ");

                break;
            case 6:
                System.out.println("Showing Decor items: ");

                break;
            case 7:
                System.out.println("Showing Beauty items: ");

                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
    public static int getChoice() {
        return choice;
    }
}




//    String electronics[] = {"calculators", "scanners", "computers", "printers", "fax machines", "front projectors", "refrigerators", "washing machine", "vacuum cleaner", "microwave oven"};
//    int electronics_price[] = {1000, 2000, 4000, 4329, 1033, 1345, 8432, 10000, 1023, 999};
//    String groceries[] = {"Rice", "roti", "abc", "cyc", "fax sa", "frasdont"};
//    int groceries_price[] = {100, 102, 432, 423, 213, 99};
//    String medicines[] = {"Acetaminophen (Tylenol)", "Ibuprofen (Advil)", "Cetirizine (Zyrtec)", "Decongestants", "Cough syrup", "Bandages", "Pain-relieving cream", "Condoms"};
//    int medicines_price[] = {5, 8, 6, 10, 7, 3, 12, 15};
//    String TVsAndMobiles[] = {"Smart TV", "4K Ultra HD TV", "OLED TV", "Curved TV", "QLED TV", "LED TV", "Android Smartphone", "iPhone", "Samsung Galaxy series", "Google Pixel", "OnePlus", "Motorola", "Xiaomi", "Huawei", "LG smartphones", "Sony Xperia", "Foldable smartphones", "Budget smartphones", "Flagship smartphones", "Wireless earbuds", "Bluetooth headphones", "Phone accessories"};
//    int TVsAndMobiles_price[] = {500, 800, 1200, 1000, 1500, 700, 600, 1000, 800, 700, 600, 400, 300, 500, 900, 1000, 1500, 500, 1200, 800, 150, 50, 20};
//
//    String HomeAndKitchen[] = {"Cookware set", "Non-stick frying pan", "Stainless steel pots and pans", "Cutlery set", "Dinnerware", "Microwave oven", "Toaster", "Blender", "Coffee maker", "Food processor", "Slow cooker", "Instant Pot", "Refrigerator", "Dishwasher", "Vacuum cleaner", "Air purifier", "Bed sheets and pillowcases", "Comforter set", "Towels", "Curtains", "Furniture", "Home decor items", "Smart home devices", "Laundry detergent", "Trash bags", "Cleaning supplies"};
//    int HomeAndKitchen_price[] = {100, 20, 50, 30, 40, 200, 30, 50, 80, 150, 120, 200, 800, 500, 150, 300, 40, 80, 20, 30, 100, 50, 150, 10, 5, 15};
//
//    String HomeDecor[] = {"Wall art", "Picture frames", "Mirrors", "Wall clocks", "Decorative cushions", "Wall shelves", "Accent furniture", "Decorative figurines", "Cushion covers", "Framed posters", "Sculptures", "Wall decals", "Clocks", "Wreaths", "Decorative trays", "String lights", "Holiday decorations"};
//    int HomeDecor_price[] = {30, 15, 25, 20, 10, 20, 150, 40, 8, 25, 60, 15, 30, 40, 20, 15, 50};
//
//    String BeautyItems[] = {"Shampoo and conditioner", "Body wash", "Face cleanser", "Moisturizer", "Sunscreen", "Makeup remover", "Facial toner", "Serum", "Face masks", "Exfoliating scrub", "Lip balm", "Deodorant", "Shaving cream or gel", "Razors", "Hair styling products", "Hairbrush or comb", "Toothpaste", "Toothbrush", "Mouthwash", "Perfume or cologne", "Nail polish", "Makeup", "Makeup brushes", "Hair dryer", "Flat iron or curling iron", "Bath salts or bath bombs", "Hand cream", "Face and body wipes"};
//    int BeautyItems_price[] = {8, 5, 6, 12, 10, 7, 15, 20, 10, 8, 4, 5, 3, 5, 10, 5, 3, 2, 4, 5, 30, 3, 15, 8, 25, 30, 15, 10, 7};
