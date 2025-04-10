import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.Map.Entry;

class Product {
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return name + " - " + category + " ($" + price + ")";
    }
}

public class ProductStreamOperations {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 85000),
            new Product("Phone", "Electronics", 45000),
            new Product("Jeans", "Clothing", 2000),
            new Product("Shirt", "Clothing", 1500),
            new Product("Refrigerator", "Appliances", 30000),
            new Product("Microwave", "Appliances", 10000)
        );

        // 1. Group products by category
        Map<String, List<Product>> groupedByCategory = products.stream()
            .collect(Collectors.groupingBy(Product::getCategory));
        System.out.println("Grouped by category:");
        groupedByCategory.forEach((cat, list) -> {
            System.out.println(cat + ": " + list);
        });

        // 2. Most expensive product in each category
        System.out.println("\nMost expensive product in each category:");
        Map<String, Optional<Product>> mostExpensive = products.stream()
            .collect(Collectors.groupingBy(Product::getCategory,
                    Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))));
        mostExpensive.forEach((cat, prodOpt) -> 
            System.out.println(cat + ": " + prodOpt.get()));

        // 3. Average price of all products
        double averagePrice = products.stream()
            .collect(Collectors.averagingDouble(Product::getPrice));
        System.out.println("\nAverage price of all products: ₹" + averagePrice);
    }
}
