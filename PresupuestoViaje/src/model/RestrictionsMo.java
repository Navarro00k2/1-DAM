package model;

import java.util.ArrayList;

public class RestrictionsMo {
	
	private ArrayList<String> textsList;	// Textos de errores
	private int lowerPeopleLimit;			// Limite inferior de personas
	private int upperPeopleLimit;			// Limite superior de personas
	private boolean allFieldsValid;			// Boleano de todos los campos rellenos
	private boolean allOptionsValid;		// Boleano de todos los paneles de opciones con alguna opcion seleccionada
	
	public RestrictionsMo() {
		this.textsList = new ArrayList<String>();
		this.lowerPeopleLimit = 1;
		this.upperPeopleLimit = 200;
		this.allFieldsValid = false;
		this.allOptionsValid = false;
		
		textsListsSetup();
	}

	private void textsListsSetup() {
		textsList.add("Error");															// 0
		textsList.add("Solo se permiten numeros");										// 1
		textsList.add("El limite inferior es de " + lowerPeopleLimit + " personas.");	// 2
		textsList.add("El limite superior es de " + upperPeopleLimit + " personas.");	// 3
		
	}

	public ArrayList<String> getTextsList() {
		return textsList;
	}

	public void setTextsList(ArrayList<String> textsList) {
		this.textsList = textsList;
	}

	public int getLowerPeopleLimit() {
		return lowerPeopleLimit;
	}

	public void setLowerPeopleLimit(int lowerPeopleLimit) {
		this.lowerPeopleLimit = lowerPeopleLimit;
	}

	public int getUpperPeopleLimit() {
		return upperPeopleLimit;
	}

	public void setUpperPeopleLimit(int upperPeopleLimit) {
		this.upperPeopleLimit = upperPeopleLimit;
	}

	public boolean isAllFieldsValid() {
		return allFieldsValid;
	}

	public void setAllFieldsValid(boolean allFieldsValid) {
		this.allFieldsValid = allFieldsValid;
	}

	public boolean isAllOptionsValid() {
		return allOptionsValid;
	}

	public void setAllOptionsValid(boolean allOptionsValid) {
		this.allOptionsValid = allOptionsValid;
	}
	
	
	
}
