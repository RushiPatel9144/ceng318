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

        product.setPrice(price);
        product.setQuantity(quantity);

    }

    //Viewing product
    public Product viewProduct(int productId){
        Product product = hashMap.get(productId);
        return product;
    }

    //Searching Product
    public Product searchProductByName(String name) {
        for (Product product : hashMap.values()) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }
}
