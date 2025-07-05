package efrisescapulationdemo;

class TaxCategory {
    public double calculateVAT(double amount) {
        return amount * 0.18;
    }
}


class Retailer extends TaxCategory {
    @Override
    public double calculateVAT(double amount) {
        return amount * 0.18;
    }
}


class Wholesaler extends TaxCategory {
    @Override
    public double calculateVAT(double amount) {
        return amount * 0.15;
    }
}


class Importer extends TaxCategory {
    @Override
    public double calculateVAT(double amount) {
        return amount * 0.10;
    }
}


public class VATDemo {
    public static void main(String[] args) {
       
        TaxCategory[] taxpayers = {
            new Retailer(),
            new Wholesaler(),
            new Importer()
        };

        
        double[] amounts = {100000, 200000, 150000};

        
        for (int i = 0; i < taxpayers.length; i++) {
            System.out.println("Transaction Amount: " + amounts[i]);
            System.out.println("VAT: " + taxpayers[i].calculateVAT(amounts[i]));
            System.out.println("---------------------------");
        }
    }
}
