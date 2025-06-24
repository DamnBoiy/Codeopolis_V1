package Uebungen;

public class Product {
    private int productId;
    private String name;
    private String category;
    private double price;
    private int quantity;

    public Product(int productId, String name, String category, double price, int quantity) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public int getProductId() { return productId; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setPrice(double price) { this.price = price; }


    @Override
    public String toString() {
        return String.format("[%d] %s (%s) - %.2f EUR, %d Stück",
                productId, name, category, price, quantity);
    }
}
