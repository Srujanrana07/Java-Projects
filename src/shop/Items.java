package shop;
import java.util.Scanner;

public class Items {
    Scanner sc = new Scanner(System.in);
    String item_list[] = {"1> Electronics", "2> Groceries", "3> Medicine", "4> TVs and Mobiles", "5> Home & Kitchen", "6> Decor", "7> Beauty"};
    String electronics[] = {"calculators", "scanners", "computers", "printers", "fax machines", "front projectors", "refrigerators", "washing machine", "vacuum cleaner", "microwave oven","exit"};
    int electronics_price[] = {1000, 2000, 4000, 4329, 1033, 1345, 8432, 10000, 1023, 999};
    String groceries[] = {"Rice", "roti", "abc", "cyc", "fax sa", "frasdont","exit"};
    int groceries_price[] = {100, 102, 432, 423, 213, 99};
    String medicines[] = {"Acetaminophen (Tylenol)", "Ibuprofen (Advil)", "Cetirizine (Zyrtec)", "Decongestants", "Cough syrup", "Bandages", "Pain-relieving cream", "Condoms","exit"};
    int medicines_price[] = {5, 8, 6, 10, 7, 3, 12, 15};
    String TVsAndMobiles[] = {"Smart TV", "4K Ultra HD TV", "OLED TV", "Curved TV", "QLED TV", "LED TV", "Android Smartphone", "iPhone", "Samsung Galaxy series", "Google Pixel", "OnePlus", "Motorola", "Xiaomi", "Huawei", "LG smartphones", "Sony Xperia", "Foldable smartphones", "Budget smartphones", "Flagship smartphones", "Wireless earbuds", "Bluetooth headphones", "Phone accessories","exit"};
    int TVsAndMobiles_price[] = {500, 800, 1200, 1000, 1500, 700, 600, 1000, 800, 700, 600, 400, 300, 500, 900, 1000, 1500, 500, 1200, 800, 150, 50, 20};

    String HomeAndKitchen[] = {"Cookware set", "Non-stick frying pan", "Stainless steel pots and pans", "Cutlery set", "Dinnerware", "Microwave oven", "Toaster", "Blender", "Coffee maker", "Food processor", "Slow cooker", "Instant Pot", "Refrigerator", "Dishwasher", "Vacuum cleaner", "Air purifier", "Bed sheets and pillowcases", "Comforter set", "Towels", "Curtains", "Furniture", "Home decor items", "Smart home devices", "Laundry detergent", "Trash bags", "Cleaning supplies","exit"};
    int HomeAndKitchen_price[] = {100, 20, 50, 30, 40, 200, 30, 50, 80, 150, 120, 200, 800, 500, 150, 300, 40, 80, 20, 30, 100, 50, 150, 10, 5, 15};

    String HomeDecor[] = {"Wall art", "Picture frames", "Mirrors", "Wall clocks", "Decorative cushions", "Wall shelves", "Accent furniture", "Decorative figurines", "Cushion covers", "Framed posters", "Sculptures", "Wall decals", "Clocks", "Wreaths", "Decorative trays", "String lights", "Holiday decorations","exit"};
    int HomeDecor_price[] = {30, 15, 25, 20, 10, 20, 150, 40, 8, 25, 60, 15, 30, 40, 20, 15, 50};

    String BeautyItems[] = {"Shampoo and conditioner", "Body wash", "Face cleanser", "Moisturizer", "Sunscreen", "Makeup remover", "Facial toner", "Serum", "Face masks", "Exfoliating scrub", "Lip balm", "Deodorant", "Shaving cream or gel", "Razors", "Hair styling products", "Hairbrush or comb", "Toothpaste", "Toothbrush", "Mouthwash", "Perfume or cologne", "Nail polish", "Makeup", "Makeup brushes", "Hair dryer", "Flat iron or curling iron", "Bath salts or bath bombs", "Hand cream", "Face and body wipes","exit"};
    int BeautyItems_price[] = {8, 5, 6, 12, 10, 7, 15, 20, 10, 8, 4, 5, 3, 5, 10, 5, 3, 2, 4, 5, 30, 3, 15, 8, 25, 30, 15, 10, 7};


    void item_show() {
        for (String item : item_list) {
            System.out.println(item);
        }
    }

    private void printItemsWithPrices(String[] items, int[] prices) {
        System.out.printf("%-20s%s%n", "Item", "Price");
        System.out.println("--------------------");
        for (int i = 0; i < items.length; i++) {
            System.out.printf("%-20s$%d%n", items[i], prices[i]);
        }
    }

    private void view_groceries() {
        item_show();
        System.out.println("Enter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Showing Electronics items with prices: ");
                printItemsWithPrices(electronics, electronics_price);
                break;
            case 2:
                System.out.println("Showing Groceries items with prices: ");
                printItemsWithPrices(groceries, groceries_price);
                break;
            case 3:
                System.out.println("Showing Medicines items with prices: ");
                printItemsWithPrices(medicines, medicines_price);
                break;

            case 4:
                System.out.println("Showing TVs and Mobiles items with prices: ");
                printItemsWithPrices(TVsAndMobiles, TVsAndMobiles_price);
                break;
            case 5:
                System.out.println("Showing Home and Kitchen items with prices: ");
                printItemsWithPrices(HomeAndKitchen, HomeAndKitchen_price);
                break;
            case 6:
                System.out.println("Showing Home Decor items with prices: ");
                printItemsWithPrices(HomeDecor, HomeDecor_price);
                break;
            case 7:
                System.out.println("Showing Beauty items with prices: ");
                printItemsWithPrices(BeautyItems, BeautyItems_price);
                break;

            default:
                System.out.println("Invalid choice");
                break;

        }
    }
}