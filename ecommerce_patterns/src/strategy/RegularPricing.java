package strategy;

public class RegularPricing implements PricingStrategy {
	
	public double calculateFinalPrice(double price) {
		return price; // Sin descuento
		
	}
	
	public String getDescription() { 
		return "Precio regular";
		}
	}