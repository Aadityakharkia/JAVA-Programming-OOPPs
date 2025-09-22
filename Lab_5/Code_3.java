import java.util.Scanner;

class DivisionByZeroException extends Exception {
    public DivisionByZeroException(String message) {
        super(message);
    }
}

class NegativeNumberException extends Exception {
    public NegativeNumberException(String message) {
        super(message);
    }
}

public class Code_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Division");
            System.out.println("2. Square Root");
            System.out.println("3. Factorial");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            try {
                if (choice == 1) {
                    System.out.print("Enter numerator: ");
                    double numerator = scanner.nextDouble();
                    System.out.print("Enter denominator: ");
                    double denominator = scanner.nextDouble();
                    if (denominator == 0) {
                        throw new DivisionByZeroException("Division by zero is not allowed");
                    }
                    System.out.println("Result: " + (numerator / denominator));
                } else if (choice == 2) {
                    System.out.print("Enter a number: ");
                    double number = scanner.nextDouble();
                    if (number < 0) {
                        throw new NegativeNumberException("Square root of negative number is not allowed");
                    }
                    System.out.println("Result: " + Math.sqrt(number));
                } else if (choice == 3) {
                    System.out.print("Enter a number: ");
                    int number = scanner.nextInt();
                    if (number < 0) {
                        throw new NegativeNumberException("Factorial of negative number is not allowed");
                    }
                    System.out.println("Result: " + factorial(number));
                } else if (choice == 4) {
                    break;
                } else {
                    System.out.println("Invalid choice");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }

    public static long factorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}