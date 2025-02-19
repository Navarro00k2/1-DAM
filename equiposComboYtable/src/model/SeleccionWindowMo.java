/*
 * Modelo de la ventana de la seleccion (Jtable)
 * 
 * @Navarro
 * 17-02-25
 * 
 */
package model;

import java.util.ArrayList;

public class SeleccionWindowMo {
	
	private String title;						// Titulo de la ventana
	private ArrayList<String> columnTexts;		// Textos de las columnas
	
	public SeleccionWindowMo() {
		this.title = "Seleccion";
		this.columnTexts = new ArrayList<String>();
		
		createColumnTexts();
	}

	private void createColumnTexts() {
		columnTexts.add("Jugador");		// 0
		columnTexts.add("Club");		// 1
		columnTexts.add("Posicion"); 	// 2
		columnTexts.add("Edad");		// 3
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ArrayList<String> getColumnTexts() {
		return columnTexts;
	}

	public void setColumnTexts(ArrayList<String> columnTexts) {
		this.columnTexts = columnTexts;
	}
	
	
}
