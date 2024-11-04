package lab07.task3;

public class Product {
    private int productID;
    private String name;
    private double price;
    private int quantity;

    public Product(int productID, String name, double price, int quantity) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Product ID: " + productID + ", Name: " + name + ", Price: $" + price + ", Quantity: " + quantity;
    }
}
