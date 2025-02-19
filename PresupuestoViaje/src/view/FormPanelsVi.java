/*
 * Panel de formulario para introducir la cantidad de personas en una seccion.
 * 
 * @Navarro
 * 18-02-25
 * 
 */
package view;


import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.BudgetWindowMo;

public class FormPanelsVi extends JPanel{
	
	private BudgetWindowMo myBudgetWindowMo;			// Modelo de la ventana
	private JLabel inputLabel;							// Etiqueta de seccion ("Personas: ")
	private JTextField inputField;						// Campo de seccion
	
	public FormPanelsVi(BudgetWindowMo myBudgetWindowMo) {
		this.myBudgetWindowMo = myBudgetWindowMo;
		this.inputLabel = new JLabel(myBudgetWindowMo.getTexts().get(1)); // Crear etiqueta con su texto ("Personas: ")
		this.inputField = new JTextField();
		
		this.setLayout(new FlowLayout(FlowLayout.LEFT)); // Layout de este panel
		inputField.setPreferredSize(new Dimension(50, 25)); // Tamano del campo
		
		this.add(inputLabel); // Anadir etiqueta a la ventana
		this.add(inputField); // Anadir campo a la ventana
	}

	public BudgetWindowMo getMyBudgetWindowMo() {
		return myBudgetWindowMo;
	}

	public void setMyBudgetWindowMo(BudgetWindowMo myBudgetWindowMo) {
		this.myBudgetWindowMo = myBudgetWindowMo;
	}

	public JLabel getInputLabel() {
		return inputLabel;
	}

	public void setInputLabel(JLabel inputLabel) {
		this.inputLabel = inputLabel;
	}

	public JTextField getInputField() {
		return inputField;
	}

	public void setInputField(JTextField inputField) {
		this.inputField = inputField;
	}
	
	
}
