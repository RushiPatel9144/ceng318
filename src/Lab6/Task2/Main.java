package Lab6.Task2;

public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        // Adding products
        manager.addProduct(new Product(1, "Laptop", 999.99, 10));
        manager.addProduct(new Product(2, "Smartphone", 499.99, 20));
        System.out.println(manager.hashMap);

        //updating product


        //viewing product
        System.out.println(manager.viewProduct(1));

    }
}