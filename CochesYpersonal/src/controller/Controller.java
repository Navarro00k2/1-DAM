/*
 * Controlador pricipal.
 * 
 * @Navarro
 * 31-01-25
 * 
 */
package controller;

import java.util.ArrayList;

import javax.swing.JFrame;

import model.Model;
import view.ViMain;
import view.ViTables;

public class Controller {
	
	private Model myModel;
	private ViMain myViMain;
	private ViTables myViTables;
	private ArrayList<ViTables> viTablesList;	
	
	public Controller() {
		myModel = new Model();
		myViMain = new ViMain(myModel);
		viTablesList = new ArrayList<>();
		
		createTableWindows();	// Crear ventanas para cada tabla, pasando el index para diferenciarlas 
		activateButtonEvents(); // Anadir eventos a los botones
		
		myViMain.setVisible(true);	//Hacer visible la ventana principal
		
	}

	private void activateButtonEvents() {
		for (int i = 0; i < myViMain.getButtons().size(); i++) {
			myViMain.getButtons().get(i).addActionListener(new CoButtonsListener(myModel, myViMain, viTablesList));
		}
		
	}
	

	private void createTableWindows() {
		// Crear la misma cantidad de ventanas de tabla que el tamano del arraylist tablesList
		for (int tableIndex = 0; tableIndex < myModel.getTablesList().size(); tableIndex++) {
			myViTables = new ViTables(myModel, tableIndex);
			this.viTablesList.add(myViTables);	// Anadir al arraylist de ventanas de tabla
			this.viTablesList.get(tableIndex).setVisible(true); // Hacer ventana de tabla visible
		}
	}
	
	
	
}
