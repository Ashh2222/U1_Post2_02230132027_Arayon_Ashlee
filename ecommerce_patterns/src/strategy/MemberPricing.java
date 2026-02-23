package strategy;

public class MemberPricing implements PricingStrategy {
	
	public double calculateFinalPrice(double price) {
		return price * 0.9; // Con 10% de descuento
		
	}
	
	public String getDescription() { 
		return "Precio para Miembros con 10% OFF";
		}
	}