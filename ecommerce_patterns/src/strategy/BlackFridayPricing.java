package strategy;

public class BlackFridayPricing implements PricingStrategy {
	
	public double calculateFinalPrice(double price) {
		return price * 0.7; // Con 30% de descuento
		
	}
	
	public String getDescription() { 
		return "Precio BlackFriday 30% OFF";
		}
	}