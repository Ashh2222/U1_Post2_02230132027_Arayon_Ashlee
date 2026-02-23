package strategy;

public class BulkPricing implements PricingStrategy {

    private int quantity;

    public BulkPricing(int quantity) {
        this.quantity = quantity;
    }

    
    public double calculateFinalPrice(double price) {

        double total = price * quantity;

        if (quantity >= 15) {
            return total * 0.75; // Con 25% descuento
        } else if (quantity >= 10) {
            return total * 0.85; // Con 15% descuento
        } else {
            return total;
        }
    }

   
    public String getDescription() {
        return "Descuento por cantidad (" + quantity + " unidades)";
    }
}