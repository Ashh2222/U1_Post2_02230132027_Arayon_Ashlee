package model;

public class Clothing extends Product{
	
	
private String size;
	
	public Clothing(String name, double basePrice, String size) {
		super(name, basePrice, "Clothing");
		this.size = size;
	}
	
	public double calculateShipping() { 
		return basePrice * 0.03;
		}
	
	public String getDescription() {
		
		return name + " [Ropa] -Talla: "+ size.toUpperCase();
}
}


