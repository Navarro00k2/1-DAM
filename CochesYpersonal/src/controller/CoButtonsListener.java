/*
 * Controlador oyente de los botones de la ventana pricipal.
 * 
 * @Navarro
 * 31-01-25
 * 
 */

package controller;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import model.Model;
import view.ViFormPanels;
import view.ViMain;
import view.ViTables;

public class CoButtonsListener implements ActionListener {

	private Model myModel;
	private ViMain myViMain;
	private ArrayList<ViTables> viTablesList;

	public CoButtonsListener(Model myModel, ViMain myViMain, ArrayList<ViTables> viTablesList) {
		this.myModel = myModel;
		this.myViMain = myViMain;
		this.viTablesList = viTablesList;
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton pressedButton = (JButton) e.getSource(); 	// Obtener boton pulsado
		String pressedButtonText = pressedButton.getText();	// Obtener texto del boton pulsado
		
		myViMain.getFormPanels().clear(); // Limpiar la lista de paneles de formulario
		
		// Iterar por los textos de los botones para compararlo con el del pulsado y asi saber su posicion
		for (int i = 0; i < myModel.getButtonTexts().size(); i++) {
			if (myModel.getButtonTexts().get(i).equals(pressedButtonText)) {
				addFormPanels(i); // Anadir forms 
				activateLabelEvents(i); // Activar evento de la etiqueta
			}
		}
	}

	

	private void activateLabelEvents(int tableIndex) {
		// Iterar por la cantidad de campos principales (mainFields) de la tabla correspondiente (tableIndex)
		for (int formPanelIndex = 0; formPanelIndex < myModel.getMainFields().get(tableIndex).size(); formPanelIndex++) {
			myViMain.getFormPanels().get(formPanelIndex).getTextField().addKeyListener(new CoFormsListener(myModel, myViMain, viTablesList, tableIndex, formPanelIndex));
		}
	}

	private void addFormPanels(int tableIndex) {
		myViMain.getMainFormPanel().removeAll(); // Eliminar interior del contenedor de paneles de formulario
	
		// Iterar por los tipos de campo principales (mainFields) segun la tabla (tableIndex) para crear sus formPanels (etiqueta + textField)
		for (int mainFieldIndex = 0; mainFieldIndex < myModel.getMainFields().get(tableIndex).size(); mainFieldIndex++) {
			ViFormPanels formPanel = new ViFormPanels(myModel, tableIndex, mainFieldIndex); // Crear formPanel correspondieste
			myViMain.getFormPanels().add(formPanel); // Anadir a la lista de formPanels
			myViMain.getMainFormPanel().add(myViMain.getFormPanels().get(mainFieldIndex)); // Anadir la lista de formPanels al contenedor de formPanels
		}
		
		// Actualizar interior del contenedor de paneles de formulario
		myViMain.getMainFormPanel().validate(); 
		myViMain.getMainFormPanel().repaint(); 
	}
	

}
