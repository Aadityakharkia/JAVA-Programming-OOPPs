import java.io.*;
import java.util.*;

class Product implements Serializable {
    private String name;
    private int quantity;

    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void reduceQuantity(int amount) {
        this.quantity -= amount;
    }
}

class Customer implements Serializable {
    private String name;
    private String email;
    private String productBought;
    private int quantityBought;

    public Customer(String name, String email, String productBought, int quantityBought) {
        this.name = name;
        this.email = email;
        this.productBought = productBought;
        this.quantityBought = quantityBought;
    }
}

public class Code_5 {
    private static List<Product> products = new ArrayList<>();
    private static List<Customer> customers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Product");
            System.out.println("2. Buy Product");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                if (choice == 1) {
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();
                    products.add(new Product(name, quantity));
                } else if (choice == 2) {
                    System.out.print("Enter your name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter your email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter product name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();

                    boolean productFound = false;
                    for (Product product : products) {
                        if (product.getName().equals(productName)) {
                            productFound = true;
                            if (product.getQuantity() >= quantity) {
                                product.reduceQuantity(quantity);
                                customers.add(new Customer(customerName, email, productName, quantity));
                                System.out.println("Purchase successful.");
                            } else {
                                System.out.println("Not enough stock.");
                            }
                            break;
                        }
                    }
                    if (!productFound) {
                        System.out.println("Product not found.");
                    }
                } else if (choice == 3) {
                    saveData();
                    break;
                } else {
                    System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }

    private static void saveData() {
        try (ObjectOutputStream productOut = new ObjectOutputStream(new FileOutputStream("products.dat"));
             ObjectOutputStream customerOut = new ObjectOutputStream(new FileOutputStream("customers.dat"))) {
            productOut.writeObject(products);
            customerOut.writeObject(customers);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }
}