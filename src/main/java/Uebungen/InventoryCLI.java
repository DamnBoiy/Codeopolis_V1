package Uebungen;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.function.Predicate;

public class InventoryCLI {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Inventory inventory = new Inventory();

    static List<Product> dreierProduktListe = List.of(
            new Product(1, "Apfel", "Obst", 0.99, 100),
            new Product(2, "Milch", "Getränke", 1.49, 50),
            new Product(3, "Brot", "Backwaren", 2.49, 30)
    );


    public static void main(String[] args) {

        for(Product p : dreierProduktListe) {
            inventory.addProduct(p);
        }

        boolean running = true;

        while (running) {
            printMenu();
            System.out.print("Wähle eine Option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> removeProduct();
                case 3 -> searchById();
                case 4 -> searchByCategory();
                case 5 -> displayAll();
                case 6 -> inventory.sortProductsByName();
                case 7 -> inventory.sortProductsByPrice();
                case 8 -> showLowStock();
                case 9 -> filterProducts();
                case 10 -> increasePrices();
                case 11 -> {
                    System.out.println("Programm beendet.");
                    running = false;
                }
                default -> System.out.println("Ungültige Option.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("""
        
        === INVENTAR-MANAGER ===
        1. Produkt hinzufügen
        2. Produkt entfernen
        3. Produkt nach ID suchen
        4. Produkte nach Kategorie anzeigen
        5. Alle Produkte anzeigen
        6. Produkte nach Namen sortieren
        7. Produkte nach Preis sortieren
        8. Produkte mit niedrigem Lagerbestand anzeigen
        9. Produkte nach benutzerdefiniertem Filter anzeigen
        10. Preise aller Produkte um Prozentsatz erhöhen
        11. Programm beenden
        """);
    }


    private static void addProduct() {
        System.out.print("Produkt-ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Kategorie: ");
        String category = scanner.nextLine();

        System.out.print("Preis: ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.print("Menge: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        Product product = new Product(id, name, category, price, quantity);
        inventory.addProduct(product);
        System.out.println("Produkt hinzugefügt.");
    }

    private static void removeProduct() {
        System.out.print("Produkt-ID zum Entfernen: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean removed = inventory.removeProduct(id);
        System.out.println(removed ? "Produkt entfernt." : "Produkt nicht gefunden.");
    }

    private static void searchById() {
        System.out.print("Produkt-ID zum Suchen: ");
        int id = Integer.parseInt(scanner.nextLine());
        Product product = inventory.findProductById(id);
        System.out.println(product != null ? product : "Nicht gefunden.");
    }

    private static void searchByCategory() {
        System.out.print("Kategorie eingeben: ");
        String category = scanner.nextLine();
        List<Product> results = inventory.findProductsByCategory(category);
        if (results.isEmpty()) {
            System.out.println("Keine Produkte in der Kategorie \"" + category + "\" gefunden.");
        } else {
            results.forEach(System.out::println);
        }
    }

    private static void displayAll() {
        List<Product> all = inventory.getAllProducts();
        if (all.isEmpty()) {
            System.out.println("Das Inventar ist leer.");
        } else {
            all.forEach(System.out::println);
        }
    }

    private static void showLowStock() {
        System.out.print("Schwellenwert für Lagerbestand: ");
        int threshold = Integer.parseInt(scanner.nextLine());
        List<Product> lowStock = inventory.getLowStockProducts(threshold);
        lowStock.forEach(System.out::println);
    }

    private static void filterProducts() {
        System.out.println("Filteroptionen:");
        System.out.println("1. Preis unter X");
        System.out.println("2. Menge über Y");
        System.out.print("Auswahl: ");
        int filterOption = Integer.parseInt(scanner.nextLine());

        Predicate<Product> predicate;

        switch (filterOption) {
            case 1 -> {
                System.out.print("Maximaler Preis: ");
                double price = Double.parseDouble(scanner.nextLine());
                predicate = p -> p.getPrice() < price;
            }
            case 2 -> {
                System.out.print("Minimale Menge: ");
                int quantity = Integer.parseInt(scanner.nextLine());
                predicate = p -> p.getQuantity() > quantity;
            }
            default -> {
                System.out.println("Ungültige Option.");
                return;
            }
        }

        List<Product> filtered = inventory.filterProducts(predicate);
        filtered.forEach(System.out::println);
    }

    private static void increasePrices() {
        System.out.print("Prozentsatz (z.B. 10 für +10%): ");
        double percent = Double.parseDouble(scanner.nextLine());

        inventory.applyToProducts(p -> {
            double newPrice = p.getPrice() * (1 + percent / 100.0);
            p.setPrice(newPrice);
        });

        System.out.println("Preise wurden um " + percent + "% erhöht.");
    }






    /* private static void increasePrices() {
        System.out.print("Prozentsatz (z. B. 10 für +10%): ");
        double percent = Double.parseDouble(scanner.nextLine());

        inventory.applyToProducts(p -> {
            double newPrice = p.getPrice() * (1 + percent / 100.0);
            // Du musst ggf. setPrice in Product implementieren:
            try {
                java.lang.reflect.Field priceField = Product.class.getDeclaredField("price");
                priceField.setAccessible(true);
                priceField.set(p, newPrice);
            } catch (Exception e) {
                System.out.println("Preis konnte nicht geändert werden.");
            }
        });

        System.out.println("Preise aktualisiert.");
    }*/
}
