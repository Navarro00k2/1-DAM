/*
 * Controlador principal
 * 
 * @Navarro
 * 18-02-25
 * 
 */
package controller;

import java.util.ArrayList;

import model.BudgetWindowMo;
import model.RestrictionsMo;
import view.BudgetWindowVi;
import view.RadioButtonsVi;
import view.SectionPanelsVi;

public class MainController {
	
	public MainController() {
		BudgetWindowMo myBudgetWindowMo = new BudgetWindowMo();	// Crear el modelo de la ventana						
		BudgetWindowVi myBudgetWindowVi = new BudgetWindowVi(myBudgetWindowMo); // Crear la vista de la ventana
		RestrictionsMo myRestrictionsMo = new RestrictionsMo();	// Crear modelo de restricciones
		
		peopleListenerSetup(myBudgetWindowVi, myRestrictionsMo); // Anadir oyente a los campos para introducir numero de personas
		sectionListenerSetup(myBudgetWindowVi, myRestrictionsMo); // Anadir oyente a las opciones de cada seccion
		
		myBudgetWindowVi.setVisible(true); // Hacer visible la ventana principal
	}

	private void sectionListenerSetup(BudgetWindowVi myBudgetWindowVi, RestrictionsMo myRestrictionsMo) {
		// Iterar por los paneles de seccion
		for (SectionPanelsVi section : myBudgetWindowVi.getSectionPanels()) {
			// Iterar por las opciones de la seccion
			for (RadioButtonsVi option : section.getRadioButtonsList()) {
				option.addActionListener(new SectionListenerCo(myBudgetWindowVi, myRestrictionsMo)); // Anadir oyente a cada opcion
			}
		}
		
	}

	private void peopleListenerSetup(BudgetWindowVi myBudgetWindowVi, RestrictionsMo myRestrictionsMo) {
		// Iterar por los paneles de seccion
		for (SectionPanelsVi section : myBudgetWindowVi.getSectionPanels()) {
			section.getMyFormPanelsVi().getInputField().addKeyListener(new PeopleListenerCo(myBudgetWindowVi, myRestrictionsMo)); // Anadir oyente a cada campo de introducir personas de cada seccion
		}
		
	}
	
	public static void calculateBudget(BudgetWindowVi myBudgetWindowVi, RestrictionsMo myRestrictionsMo) {
		// Si en las restrcciones (myRestrictionsMo), es verdadero que todos los campos tienen datos validos y todos los paneles con opciones tienen una seleccionada
		if (myRestrictionsMo.isAllOptionsValid() && myRestrictionsMo.isAllFieldsValid()) {
			ArrayList<Integer> calculatedPrices = new ArrayList<Integer>(); // Iniciar array de precios
			int totalBudget = 0; // Valor del campo de presupuesto final
			// Iterar por los paneles de seccion
			for (SectionPanelsVi section : myBudgetWindowVi.getSectionPanels()) {
				// Iterar por las opciones de cada panel
				for (RadioButtonsVi option : section.getRadioButtonsList()) {
					if (option.isSelected()) {
						// Anadir a la lista de precios calculados el precio de la opcion seleccionada multiplicaddo por el numero de personas de su seccion
						calculatedPrices.add(option.getPrice()* Integer.parseInt(section.getMyFormPanelsVi().getInputField().getText()));
					}
				}
				totalBudget = totalBudget + calculatedPrices.getLast(); // Sumar al presupuesto final el ultimo precio calculado anadido
			}
			myBudgetWindowVi.getMyFinalBudgetPanelVi().getBudgetField().setText(String.valueOf(totalBudget)); // Anadir el presupuesto final a su campo
		}
	}
	
}
