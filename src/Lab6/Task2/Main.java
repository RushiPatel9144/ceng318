package Lab6.Task2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();


        // Generating and adding 100 products
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 1; i <= 10000; i++) {
            double price = Math.round((1 + (100 - 1) * random.nextFloat()) * 100.0) / 100.0;
            int quantity = random.nextInt(50) + 1;
            manager.addProduct(new Product(i, "Product" + i, price, quantity));
        }
        long endTime = System.nanoTime();
        System.out.println("Time for adding " + (endTime - startTime) + " ns");

        // Display all products in the inventory
        System.out.println(manager.hashMap);

        // Updating a product
        long startTime1 = System.nanoTime();
        manager.updateProduct(2, 10.00, 8);
        long endTime1 = System.nanoTime();
        System.out.println("Time for updating " + (endTime1 - startTime1) + " ns");

        // Viewing a product
        long startTime2 = System.nanoTime();
        System.out.println(manager.viewProduct(1));
        long endTime2 = System.nanoTime();
        System.out.println("Time for viewing " + (endTime2 - startTime2) + " ns");

        // Searching for a product
        long startTime3 = System.nanoTime();
        System.out.println(manager.searchProductByName("Product8"));
        long endTime3 = System.nanoTime();
        System.out.println("Time for searching " + (endTime3 - startTime3) + " ns");
    }
}

//        For 100 data sets:
//        Time for adding 8925300 ns
//        Time for updating 16200 ns
//        Time for viewing 98400 ns
//        Time for searching 204400 ns
//
//        For 1000 data sets:
//        Time for adding 13062100 ns
//        Time for updating 23700 ns
//        Time for viewing 215700 ns
//        Time for searching 234500 ns
//
//        For 10000 data sets:
//        Time for adding 24635200 ns
//        Time for updating 23100 ns
//        Time for viewing 92100 ns
//        Time for searching 187200 ns