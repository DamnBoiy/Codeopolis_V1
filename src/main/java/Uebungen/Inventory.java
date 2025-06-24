package Uebungen;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Inventory {

    private final Map<Integer, Product> products;


    public Inventory() {
        this.products = new LinkedHashMap<>();
    }


    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    // Entfernt ein Produkt anhand der ID
    public boolean removeProduct(int productId) {
        return products.remove(productId) != null;
    }


    public Product findProductById(int productId) {
        return products.getOrDefault(productId, null);
    }


    public List<Product> findProductsByCategory(String category) {
        return products.values().stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }


    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values()); // automatisch in Einfügereihenfolge durch LinkedHashMap
    }


    public List<Product> sortProductsByName() {
        return products.values().stream()
                .sorted(Comparator.comparing(Product::getName))
                .toList();
    }


    public List<Product> sortProductsByPrice() {
        return products.values().stream()
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .toList();
    }

    // Gibt Produkte mit Lagerbestand unter einem Schwellenwert zurück
    public List<Product> getLowStockProducts(int threshold) {
        return products.values().stream()
                .filter(p -> p.getQuantity() < threshold)
                .collect(Collectors.toList());
    }

    // Filtert Produkte anhand eines Prädikats
    public List<Product> filterProducts(Predicate<Product> predicate) {
        return products.values().stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }


    public void applyToProducts(Consumer<Product> consumer) {
        products.values().forEach(consumer);
    }

//    // methode zur Ausgabe der sortierten Listen
//    private void printProductList(List<Product> list) {
//        list.forEach(System.out::println);
//    }





}
