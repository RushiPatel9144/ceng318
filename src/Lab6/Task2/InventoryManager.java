package Lab6.Task2;

import java.util.HashMap;

public class InventoryManager {
    HashMap<Integer, Product> hashMap = new HashMap<>();

    //adding product
    public void addProduct(Product product) {
        hashMap.put(product.getProductId(), product);
    }


    //Updating the product
    public void updateProduct(int productId, double price, int quantity) {
        Product product = hashMap.get(productId);
        //if
        product.setPrice(price);
        product.setQuantity(quantity);

    }

    //Viewing product
    public Product viewProduct(int productId){
        Product product = hashMap.get(productId);
        return product;
    }

    //Searching Product
    public void searchProduct(String name){
        hashMap.containsValue(name);
    }


}
