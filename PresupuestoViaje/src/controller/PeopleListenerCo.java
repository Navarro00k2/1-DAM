/*
 * Controlador oyente de los formularios de introducir numero de personas.
 * 
 * @Navarro
 * 18-02-25
 */
package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.RestrictionsMo;
import view.BudgetWindowVi;
import view.SectionPanelsVi;


public class PeopleListenerCo implements KeyListener{

	private RestrictionsMo myRestrictionsMo; // Modelo de las restricciones
	private BudgetWindowVi myBudgetWindowVi; // Vista principal
	
	public PeopleListenerCo(BudgetWindowVi myBudgetWindowVi, RestrictionsMo myRestrictionsMo) {
		this.myRestrictionsMo = myRestrictionsMo;
		this.myBudgetWindowVi = myBudgetWindowVi;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		JTextField field = (JTextField) e.getSource(); // Campo sobre el que se ha introducido un numero
		
        boolean isValid = validateInput(e, field); // Validar el valor introducido y resultante
        if (!isValid) {
        	field.setText(null); // Borrar contenido del campo
        	myBudgetWindowVi.getMyFinalBudgetPanelVi().getBudgetField().setText(null); // Vaciar campo del presupuesto 
        	myRestrictionsMo.setAllFieldsValid(false);
        } else {
        	boolean allValid = true; // Validar que todos los campos tengan datos
        	// Iterar por las secciones (paneles que incluyen los campos)
        	for (SectionPanelsVi section : myBudgetWindowVi.getSectionPanels()) {
        		// Si el campo de la seccion por la que se itera es nulo
        		if (section.getMyFormPanelsVi().getInputField().getText().equals("")) {
        			allValid = false; // Hay algun campo nulo
        			myRestrictionsMo.setAllFieldsValid(false);
        		}
        	}
        	// Si todos los campos estan rellenados
        	if (allValid) {
    			myRestrictionsMo.setAllFieldsValid(true); // Validar que todos los campos estan rellenos
    		}
        	MainController.calculateBudget(myBudgetWindowVi, myRestrictionsMo); // Calcular presupuesto
        }
	}

	
	
	private boolean validateInput(KeyEvent e, JTextField field) {
		// Si la tecla pulsada no es la de borrar
		if (e.getKeyCode() != KeyEvent.VK_BACK_SPACE) {
	        char input = e.getKeyChar(); // Guardar el caracter introducido
			// Si el caracter introducido no es numero
			if (!Character.isDigit(input)) {
				JOptionPane.showMessageDialog(null, myRestrictionsMo.getTextsList().get(1), myRestrictionsMo.getTextsList().get(0), JOptionPane.WARNING_MESSAGE); // Panel de error correspondiente
				return false;
			} else {
				int number = Integer.parseInt(field.getText()); // Convertir a entero el valor que haya el el campo
				// Si el valor en el campo es menor que el limite inferior permitido
				if (number < myRestrictionsMo.getLowerPeopleLimit()) {
					JOptionPane.showMessageDialog(null, myRestrictionsMo.getTextsList().get(2), myRestrictionsMo.getTextsList().get(0), JOptionPane.WARNING_MESSAGE); // Panel de error correspondiente
					return false;
				} else {
					// Si el valor en el campo es menor que el limite inferior permitido
					if (number > myRestrictionsMo.getUpperPeopleLimit()) {
						JOptionPane.showMessageDialog(null, myRestrictionsMo.getTextsList().get(3), myRestrictionsMo.getTextsList().get(0), JOptionPane.WARNING_MESSAGE); // Panel de error correspondiente
						return false;
					} else {
						return true;
					}
				}
			}
		 }
		return false;
	}
	

	
	
	
}
