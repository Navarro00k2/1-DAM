/*
 * Opcion JRadioButton para elegir en las secciones. Guarda su "nombre", su precio y el texto visible en las opciones.
 * 
 * @Navarro
 * 18-02-25
 * 
 */
package view;

import javax.swing.JRadioButton;

public class RadioButtonsVi extends JRadioButton{

	private String showedText;	// Texto visible para la opcion en la seccion
	private String itemText;	// "Nombre" de la opcion
	private int price;			// Precio de la opcion
	
	public RadioButtonsVi(String showedText, String itemText, int price) {
		super(showedText);
		this.showedText = showedText;
		this.itemText = itemText;
		this.price = price;
	}



	public String getShowedText() {
		return showedText;
	}

	public void setShowedText(String showedText) {
		this.showedText = showedText;
	}

	public String getItemText() {
		return itemText;
	}

	public void setItemText(String itemText) {
		this.itemText = itemText;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
