/*
 * Modelo de los coches.
 * 
 * @Navarro
 * 31-01-25
 * 
 */
package model;

public class MoCoches {
	private String brand;
	private String color;
	
	public MoCoches(String brand, String color) {
		this.brand = brand;
		this.color = color;
	}
	
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
}
