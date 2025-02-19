/*
 * Panel del presupuesto final. Etiqueta y campo de texto (no editable)
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


public class FinalBudgetPanelVi extends JPanel {
	
	private BudgetWindowMo myBudgetWindowMo;	// Modelo de la ventana principal
	private JLabel budgetLabel;					// Etiqueta "Precio"
	private JTextField budgetField;				// Campo que muestre el presupuesto final
	
	public FinalBudgetPanelVi(BudgetWindowMo myBudgetWindowMo) {
		this.budgetLabel = new JLabel(myBudgetWindowMo.getTexts().get(2));	// Poner su texto a la etiqueta del precio final
		this.budgetField = new JTextField();
		
		setLayout(new FlowLayout()); // Layout de este panel		
		fieldProperties(); // Propiedades del campo
		add(budgetLabel); // Anadir etiqueta a este panel
		add(budgetField); // Anadir campo a este panel
	}

	private void fieldProperties() {
		budgetField.setPreferredSize(new Dimension(100, 25));
		budgetField.setEditable(false);
		
	}

	public BudgetWindowMo getMyBudgetWindowMo() {
		return myBudgetWindowMo;
	}

	public void setMyBudgetWindowMo(BudgetWindowMo myBudgetWindowMo) {
		this.myBudgetWindowMo = myBudgetWindowMo;
	}

	public JLabel getBudgetLabel() {
		return budgetLabel;
	}

	public void setBudgetLabel(JLabel budgetLabel) {
		this.budgetLabel = budgetLabel;
	}

	public JTextField getBudgetField() {
		return budgetField;
	}

	public void setBudgetField(JTextField budgetField) {
		this.budgetField = budgetField;
	}


	
}
