/*
 * Panel de seccion.Cada seccion es un conjunto de opciones, una cabecera y campo para introducir numero de personas.
 * 
 * @Navarro
 * 18-02-25
 * 
 */
package view;


import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.BudgetWindowMo;
import model.OptionsMo;

public class SectionPanelsVi extends JPanel {
	
	private BudgetWindowMo myBudgetWindowMo;			// Modelo de la ventana
	private JLabel sectionHeader;						// Cabecera de la seccion
	private ArrayList<RadioButtonsVi> radioButtonsList;	// Lista de opciones	
	private FormPanelsVi myFormPanelsVi;				// Panel formulario (etiqueta y campo de introducir personas)
	
	public SectionPanelsVi(BudgetWindowMo myBudgetWindowMo, int index) {
		this.myBudgetWindowMo = myBudgetWindowMo;
		this.sectionHeader = new JLabel(myBudgetWindowMo.getSectionHeaders().get(index)); // Crear cabecera
		this.radioButtonsList = new ArrayList<RadioButtonsVi>();
		this.myFormPanelsVi = new FormPanelsVi(myBudgetWindowMo);
		
		this.setLayout(new GridLayout(0, 1));
		
		this.add(sectionHeader); // Anadir cabecera a la ventana
		radioButtonsSetup(index); // Crear las opciones correspondientes
		this.add(myFormPanelsVi); // Anadir subpanel del formulario a este panel
	}
		

	private void radioButtonsSetup(int index) {
		ButtonGroup optionsGroup = new ButtonGroup(); // Crear grupo de botones (solo se podra seleccionar una de las opciones incluidas en este)
        // Iterar por cada opcion de la lista de opciones correspondiente a este panel
		for (OptionsMo item :  myBudgetWindowMo.getSections().get(index)) {
			RadioButtonsVi myRadioButtonVi = new RadioButtonsVi(item.toString(),item.getOptionText(),item.getOptionPrice()); // Crear opcion con los valores de la opcion por la que se itera
			radioButtonsList.add(myRadioButtonVi);
			optionsGroup.add(myRadioButtonVi); // Anadir opcion creada al grupo
			this.add(myRadioButtonVi);	// Anadir opcion a la ventana
		}

	}


	public BudgetWindowMo getMyBudgetWindowMo() {
		return myBudgetWindowMo;
	}


	public void setMyBudgetWindowMo(BudgetWindowMo myBudgetWindowMo) {
		this.myBudgetWindowMo = myBudgetWindowMo;
	}


	public JLabel getSectionHeader() {
		return sectionHeader;
	}


	public void setSectionHeader(JLabel sectionHeader) {
		this.sectionHeader = sectionHeader;
	}
	

	public ArrayList<RadioButtonsVi> getRadioButtonsList() {
		return radioButtonsList;
	}


	public void setRadioButtonsList(ArrayList<RadioButtonsVi> radioButtonsList) {
		this.radioButtonsList = radioButtonsList;
	}


	public FormPanelsVi getMyFormPanelsVi() {
		return myFormPanelsVi;
	}


	public void setMyFormPanelsVi(FormPanelsVi myFormPanelsVi) {
		this.myFormPanelsVi = myFormPanelsVi;
	}




	
}
