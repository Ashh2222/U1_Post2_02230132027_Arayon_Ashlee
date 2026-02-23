package model;

public class Food extends Product{
	
private String foodType;


	
	public Food(String name, double basePrice, String foodType) {
		super(name, basePrice, "Clothing");
		this.foodType = foodType;
	}
	
	public double calculateShipping() { 
		return basePrice * 0.03;
		}
	
	public String getDescription() {
		
		return name + " [Ropa] -Talla: "+ foodType;
}
}






