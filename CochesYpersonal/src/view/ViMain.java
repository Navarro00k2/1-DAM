/*
 * Vista de la ventana pricipal.
 * 
 * @Navarro
 * 31-01-25
 * 
 */
package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Model;

public class ViMain extends JFrame{
	
	private Model myModel;
	private JPanel buttonsPanel;					// Panel principal de la ventana	
	private ArrayList<JButton> buttons; 			// Lista de botones
	private ArrayList<ViFormPanels> formPanels; 	// Lista de paneles de form > etiqueta + label
	private JPanel mainFormPanel;					// Panel contenedor de los paneles de formulario	
	
	public ViMain(Model myModel) {
		this.myModel = myModel;
		buttons = new ArrayList<>();
		formPanels = new ArrayList<>();
		mainFormPanel = new JPanel();
		
		windowProperties(); 			// Configuración de la ventana principal
		addButtonsPanel();				// Anadir el panel principal a la ventana
		addButtons(); 					// Anadir los botones al array y al panel
		this.add(mainFormPanel);		// Anadir panel contenedor de paneles de forms		
	}



	private void addButtonsPanel() {
		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new FlowLayout());
		this.add(buttonsPanel);		
	}



	private void windowProperties() {
        setTitle("Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridLayout(2,1,2,2));
		
	}
	
	// Anadir la misma cantidad de botones que textos para botones haya en el modelo (y anadir estos textos a cada uno)
	private void addButtons() {
		for (int i = 0; i < myModel.getButtonTexts().size(); i++) {
			JButton button = new JButton(myModel.getButtonTexts().get(i)); // Crear boton con el texto correspondiente sacado del modelo
			buttons.add(button);
			buttonsPanel.add(buttons.get(i));
		}
		
	}


	public Model getMyModel() {
		return myModel;
	}



	public void setMyModel(Model myModel) {
		this.myModel = myModel;
	}



	public JPanel getMainPanel() {
		return buttonsPanel;
	}



	public void setMainPanel(JPanel mainPanel) {
		this.buttonsPanel = mainPanel;
	}



	public ArrayList<JButton> getButtons() {
		return buttons;
	}



	public void setButtons(ArrayList<JButton> buttons) {
		this.buttons = buttons;
	}



	public ArrayList<ViFormPanels> getFormPanels() {
		return formPanels;
	}



	public void setFormPanels(ArrayList<ViFormPanels> formPanels) {
		this.formPanels = formPanels;
	}



	public JPanel getMainFormPanel() {
		return mainFormPanel;
	}



	public void setMainFormPanel(JPanel mainFormPanel) {
		this.mainFormPanel = mainFormPanel;
	}
	

	
	 
}
