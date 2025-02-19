/*
 * Controlador oyente de las opciones radioButtons.
 * 
 * @Navarro
 * 18-02-25
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.RestrictionsMo;
import view.BudgetWindowVi;
import view.RadioButtonsVi;
import view.SectionPanelsVi;

public class SectionListenerCo implements ActionListener{

	private RestrictionsMo myRestrictionsMo;
	private BudgetWindowVi myBudgetWindowVi;
	
	public SectionListenerCo(BudgetWindowVi myBudgetWindowVi, RestrictionsMo myRestrictionsMo) {
		this.myRestrictionsMo = myRestrictionsMo;
		this.myBudgetWindowVi = myBudgetWindowVi;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// Iterar por los paneles de seccion
		if (!myRestrictionsMo.isAllOptionsValid()) {
			int optionsChoosed = 0; // Cantidad de opciones seleccionadas
			// Iterar por los paneles de secciones
			for (SectionPanelsVi section : myBudgetWindowVi.getSectionPanels()) {
				// Iterar por las opciones del panel
				for (RadioButtonsVi option : section.getRadioButtonsList()) {
					// Si se ha seleccionado la opcion
					if (option.isSelected()) {
						optionsChoosed++; // Sumar a la cantidad de 
					}
				}
			}
			// Si la cantidad de opciones elegidas es igual a la cantidad de paneles con opciones
			if (optionsChoosed == myBudgetWindowVi.getSectionPanels().size()) {
				myRestrictionsMo.setAllOptionsValid(true);
			}
		}
		 MainController.calculateBudget(myBudgetWindowVi, myRestrictionsMo); // Calcular presupuesto final
	}

	
	
}
