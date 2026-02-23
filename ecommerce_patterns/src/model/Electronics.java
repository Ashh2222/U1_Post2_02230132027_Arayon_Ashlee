package model;


public class Electronics extends Product {
	
	private int warrantyMonths;
	
	public Electronics(String name, double basePrice, int warrantyMonths) {
		super(name, basePrice, "Electronics");
		this.warrantyMonths = warrantyMonths;
	}
	
	public double calculateShipping() { 
		return basePrice * 0.05;
		}
	
	public String getDescription() {
		
		return name + " [Electrónica] - Garantía: " + warrantyMonths + " meses";
	 
}
}
