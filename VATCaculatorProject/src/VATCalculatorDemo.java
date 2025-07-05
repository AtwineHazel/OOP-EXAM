
public class VATCalculatorDemo {
abstract class TaxCategory {
    protected String categoryName;

    public TaxCategory(String name) {
        this.categoryName = name;
    }

    public abstract double calculateVAT(double amount);

    public String getCategoryName() {
        return categoryName;
    }
}

class Retailer extends TaxCategory {
    private static final double VAT_RATE = 0.18;

    public Retailer() {
        super("Retailer");
    }

    @Override
    public double calculateVAT(double amount) {
        return amount * VAT_RATE;
    }
}

class Wholesaler extends TaxCategory {
    private static final double VAT_RATE = 0.15;

    public Wholesaler() {
        super("Wholesaler");
    }

    @Override
    public double calculateVAT(double amount) {
        return amount * VAT_RATE;
    }
}

class Importer extends TaxCategory {
    private static final double VAT_RATE = 0.10;

    public Importer() {
        super("Importer");
    }

    @Override
    public double calculateVAT(double amount) {
        return amount * VAT_RATE;
    }
}

public class VATCalculatorDemo {

    public static void main(String[] args) {
        TaxCategory[] taxpayerCategories = new TaxCategory[3];

        taxpayerCategories[0] = new Retailer();
        taxpayerCategories[1] = new Wholesaler();
        taxpayerCategories[2] = new Importer();

        double transactionAmount = 1000.00;

        System.out.println("Demonstrating VAT calculation using Polymorphism (Dynamic Method Dispatch):\n");

        for (TaxCategory category : taxpayerCategories) {
            double vat = category.calculateVAT(transactionAmount);
            System.out.printf("For %s (Amount: %.2f), Calculated VAT: %.2f%n",
                              category.getCategoryName(), transactionAmount, vat);
        }

        System.out.println("\n--- End of Demonstration ---");
    }
}

    
    
}
