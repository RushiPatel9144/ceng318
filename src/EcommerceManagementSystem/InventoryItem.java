package EcommerceManagementSystem;

public class InventoryItem {

    private ItemID id;
    private ItemName name;
    private ItemPrice price;
    private ItemCategory category;

    public InventoryItem(ItemID id, ItemName name, ItemPrice price, ItemCategory category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public ItemID getId() {
        return id;
    }

    public ItemName getName() {
        return name;
    }

    public ItemPrice getPrice() {
        return price;
    }

    public ItemCategory getCategory() {
        return category;
    }


    @Override
    public String toString() {
        return "InventoryItem{" +
                "id=" + id.getId() +
                ", name=" + name.getName() +
                ", price=" + price.getPrice() +
                ", category=" + category.getCategory() +
                '}';
    }
}
