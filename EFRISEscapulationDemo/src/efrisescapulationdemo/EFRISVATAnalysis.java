package efrisescapulationdemo;


abstract class VATProfile {
    protected String taxpayerType;

    public VATProfile(String taxpayerType) {
        this.taxpayerType = taxpayerType;
    }

    public abstract double computeVAT(double transactionAmount);

    public void displayVAT(double transactionAmount) {
        System.out.println("Taxpayer: " + taxpayerType);
        System.out.println("Amount: UGX " + transactionAmount);
        System.out.println("VAT Charged: UGX " + computeVAT(transactionAmount));
        System.out.println("------------------------");
    }
}

class RetailEntity extends VATProfile {
    public RetailEntity() {
        super("Retailer");
    }

    @Override
    public double computeVAT(double transactionAmount) {
        return transactionAmount * 0.18;
    }
}

class WholesaleEntity extends VATProfile {
    public WholesaleEntity() {
        super("Wholesaler");
    }

    @Override
    public double computeVAT(double transactionAmount) {
        return transactionAmount * 0.15;
    }
}


class ImportEntity extends VATProfile {
    public ImportEntity() {
        super("Importer");
    }

    @Override
    public double computeVAT(double transactionAmount) {
        return transactionAmount * 0.10;
    }
}


public class EFRISVATAnalysis {
    public static void main(String[] args) {
        VATProfile[] entities = {
            new RetailEntity(),
            new WholesaleEntity(),
            new ImportEntity()
        };

        double[] transactionAmounts = {120000, 250000, 180000};

        for (int i = 0; i < entities.length; i++) {
            entities[i].displayVAT(transactionAmounts[i]);
        }
    }
}
