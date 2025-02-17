/*
 * Vista de los paneles de formulario que se crean
 * al pulsar un boton
 * 
 * @Navarro
 * 31-01-25
 * 
 */
package view;


import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Model;

public class ViFormPanels extends JPanel{
	
	
	private Model myModel;
	private int tableIndex; // Tabla para la que se crean estos formPanels
	private int mainFieldIndex; // Indice del campo de tabla para el cual crear este formPanel
	private JLabel label;
	private JTextField textField;
	
	
	public ViFormPanels(Model myModel, int tableIndex, int mainFieldIndex) {
		this.myModel = myModel;
		this.tableIndex = tableIndex;
		this.mainFieldIndex = mainFieldIndex;
		label = new JLabel();
		textField = new JTextField();
		
		createLabel();		// Crear la etiqueta correspondiente al Index de la tabla y al del campo de esa tabla
		createTextField(); 	// Crear el textField correspondiente al Index de la tabla y al del campo de esa tabla
	}

	private void createLabel() {
		JLabel label = new JLabel(myModel.getMainFields().get(tableIndex).get(mainFieldIndex));
		label.setPreferredSize(new Dimension(100,20));
		
		this.add(label);
	}
	
	private void createTextField() {
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(100,20));
		this.add(textField);
		
	}

	public Model getMyModel() {
		return myModel;
	}

	public void setMyModel(Model myModel) {
		this.myModel = myModel;
	}

	public int getTableIndex() {
		return tableIndex;
	}

	public void setTableIndex(int tableIndex) {
		this.tableIndex = tableIndex;
	}

	public int getMainFieldIndex() {
		return mainFieldIndex;
	}

	public void setMainFieldIndex(int mainFieldIndex) {
		this.mainFieldIndex = mainFieldIndex;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}


	
}
