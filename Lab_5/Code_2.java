import java.util.Scanner;

class InsufficientDepositAmountException extends Exception {
    public InsufficientDepositAmountException(String message) {
        super(message);
    }
}

class InsufficientTenureException extends Exception {
    public InsufficientTenureException(String message) {
        super(message);
    }
}

public class Code_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter deposit amount: ");
            double depositAmount = scanner.nextDouble();

            System.out.print("Enter tenure (in months): ");
            int tenure = scanner.nextInt();

            try {
                if (depositAmount < 50000) {
                    throw new InsufficientDepositAmountException("Deposit amount must be at least 50000.");
                }

                if (tenure < 12) {
                    throw new InsufficientTenureException("Tenure must be at least 12 months.");
                }

                double maturityAmount = depositAmount*(1 + ((7.5*(tenure/12))/100));
                System.out.println("Maturity amount after " + tenure + " months: " + maturityAmount);

            } catch (InsufficientDepositAmountException e) {
                System.out.println("Condition violated: " + e.getMessage());
            } catch (InsufficientTenureException e) {
                System.out.println("Condition violated: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Invalid input. Please enter numeric values.");
        } finally {
            scanner.close();
        }
    }
}
