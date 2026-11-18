package templates.arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * TEMPLATE: ArrayList - a list that grows. Use when the number of items is not fixed.
 * Also shows a list of OBJECTS (most useful form).
 */
public class ArrayListTemplate {

    // Small class for the "list of objects" example
    static class Product {
        private final String name;
        private final double price;

        Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        String getName() { return name; }
        double getPrice() { return price; }
    }

    public static void main(String[] args) {
        // ---------- Basic list of Strings ----------
        ArrayList<String> movies = new ArrayList<>();
        movies.add("Napoleon");                 // add to the end
        movies.add("Oppenheimer");
        movies.add(1, "Damsel");                // insert at index 1
        movies.set(0, "Dune");                  // replace index 0
        movies.remove("Damsel");                // remove by value (or remove(index))
        System.out.println(movies + " size=" + movies.size());

        // Loop with an index (when you need the position)
        for (int i = 0; i < movies.size(); i++) {
            System.out.println((i + 1) + ". " + movies.get(i));
        }

        // Search
        if (movies.contains("Oppenheimer")) {
            System.out.println("Found at index " + movies.indexOf("Oppenheimer"));
        }

        Collections.sort(movies);               // A-Z
        System.out.println("Sorted: " + movies);

        // ---------- Numbers: use wrapper types (Integer, Double) ----------
        ArrayList<Integer> sales = new ArrayList<>();
        sales.add(300);
        sales.add(150);
        sales.add(700);
        int total = 0;
        for (int sale : sales) {                // auto-unboxing Integer -> int
            total += sale;
        }
        System.out.println("Total " + total + ", max " + Collections.max(sales)
                + ", min " + Collections.min(sales));
        sales.remove(Integer.valueOf(150));     // remove the VALUE 150 (remove(1) removes INDEX 1)
        System.out.println("After remove: " + sales);

        // ---------- List of objects ----------
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Microphone", 300.0));
        products.add(new Product("Speakers", 150.0));

        double sum = 0;
        for (Product p : products) {
            System.out.printf("%-12s R %.2f%n", p.getName(), p.getPrice());
            sum += p.getPrice();
        }
        System.out.printf("Total: R %.2f%n", sum);

        // Convert to an array if a method needs one
        String[] asArray = movies.toArray(new String[0]);
        System.out.println("Array length: " + asArray.length);
    }
}
