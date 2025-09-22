class LegalAgeException extends Exception {
    public LegalAgeException(String message) {
        super(message);
    }

    public String toString() {
        return "LegalAgeException: " + getMessage();
    }
}

class WordANumberException extends Exception {
    public WordANumberException(String message) {
        super(message);
    }

    public String toString() {
        return "WordANumberException: " + getMessage();
    }
}

class BrandNotSameException extends Exception {
    public BrandNotSameException(String message) {
        super(message);
    }

    public String toString() {
        return "BrandNotSameException: " + getMessage();
    }
}

public class Code_4 {
    public static void main(String[] args) {
        try {
            int age = 18;
            if (age < 21) {
                throw new LegalAgeException("Age is less than 21");
            }
        } catch (LegalAgeException e) {
            System.out.println(e);
        }

        try {
            String word = "123";
            if (word.matches("\\d+")) {
                throw new WordANumberException("Word is a number");
            }
        } catch (WordANumberException e) {
            System.out.println(e);
        }

        try {
            String brand1 = "Nike";
            String brand2 = "Adidas";
            if (!brand1.equals(brand2)) {
                throw new BrandNotSameException("Brands are not the same");
            }
        } catch (BrandNotSameException e) {
            System.out.println(e);
        }
    }
}