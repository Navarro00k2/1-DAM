/*
 * Modelo de las opciones. Cada una sera un radioButton.
 * 
 * @Navarro
 * 18-02-25
 * 
 */
package model;


public class OptionsMo {
	
	private String optionText;		// Texto de la opcion
	private int optionPrice;		// Precio de la opcion
	
	public OptionsMo(String optionText, int optionPrice) {
		super();
		this.optionText = optionText;
		this.optionPrice = optionPrice;
		
	}
	
	// Metodo sobreescrito del toString para obtener el texto completo con los datos de la opcion
	@Override
	public String toString() {
		return this.getOptionText() + " - " + this.getOptionPrice() + " €";
	}

	public String getOptionText() {
		return optionText;
	}

	public void setOptionText(String optionText) {
		this.optionText = optionText;
	}

	public int getOptionPrice() {
		return optionPrice;
	}

	public void setOptionPrice(int optionPrice) {
		this.optionPrice = optionPrice;
	}
	
	
	
}
