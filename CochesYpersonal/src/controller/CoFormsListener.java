/*
 * Controlador oyente de los formularios que aparecen 
 * en la ventana pricipal al pulsar un boton
 * 
 * @Navarro
 * 31-01-25
 * 
 */
package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.MoCoches;
import model.MoPersonal;
import model.Model;
import view.ViFormPanels;
import view.ViMain;
import view.ViTables;

public class CoFormsListener implements KeyListener {

	private Model myModel;
	private ViMain myViMain;
	private int tableIndex;
	private int mainFieldIndex;
	private ArrayList<ViTables> viTablesList;
	
	public CoFormsListener(Model myModel, ViMain myViMain, ArrayList<ViTables> viTablesList, int tableIndex, int mainFieldIndex) {
		this.myModel = myModel;
		this.myViMain = myViMain;
		this.tableIndex = tableIndex;
		this.mainFieldIndex = mainFieldIndex;
		this.viTablesList = viTablesList;
		
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		JTextField textfield= (JTextField) e.getSource(); 	// Textfield source
		ViFormPanels panel= (ViFormPanels) textfield.getParent(); 	// Panel padre del source, tipo viFormPanels.
		this.tableIndex = panel.getTableIndex();		// Indice de la tabla
		this.mainFieldIndex = panel.getMainFieldIndex(); 	// Indice del campo
		boolean isValid = false;	// Variable para verificar la validez de los datos posteriormente
		
		//Al pulsar "Enter"
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			isValid = validateInputs(tableIndex,mainFieldIndex); // Validar inputs (por ahora solo que no haya campos nulos) y anadirlos a la tabla
			if (isValid) {
				addDataToTable(tableIndex);
				JOptionPane.showMessageDialog(null, "Datos nuevos anadidos", "Exito", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	
	private boolean validateInputs(int tableIndex, int mainFieldIndex) {
		// Iterar por los campos de texto de la tabla a ingresar, ya que siempre sera igual al numero de textFields
		for (int field = 0; field < myModel.getMainFields().get(tableIndex).size(); field++) {
			String text = myViMain.getFormPanels().get(field).getTextField().getText(); // Obtener texto del panel correspondiente
			// Si el texto no tiene datos, devolver false.
			if (text.equals("")) {
				JOptionPane.showMessageDialog(null, "Introduce todos los datos", "Error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}	
		return true; // Devolver true si ha pasado las validaciones
	}


	private void addDataToTable(int tableIndex) {
		ArrayList<String> dataList = new ArrayList<>(); // Anadir datos itroducidos a un arraylist
		
		// Iterar por los campos de texto de la tabla a ingresar, ya que siempre sera igual al numero de textFields
		for (int field = 0; field < myModel.getMainFields().get(tableIndex).size(); field++) {
			dataList.add(myViMain.getFormPanels().get(field).getTextField().getText()); // Anadir a la lista el texto del panel correspondiente
		}	
		// Si en esta tabla (tableIndex) el primer dato es de la clase MoCoches
		if (myModel.getTablesList().get(tableIndex).get(0) instanceof MoCoches) {
			String brand = dataList.get(0);
			String color = dataList.get(1);
			MoCoches myMoCoches = new MoCoches(brand,color);
			myModel.getCochesList().add(myMoCoches);
			
		}
		
		// Si en esta tabla (tableIndex) el primer dato es de la clase MoPersonal
		if (myModel.getTablesList().get(tableIndex).get(0) instanceof MoPersonal) {
			String name = dataList.get(0);
			String position = dataList.get(1);
			String salaryString = dataList.get(2);
			int salary = Integer.valueOf(salaryString);
			MoPersonal myMoPersonal = new MoPersonal(name, position, salary);
			myModel.getPersonalList().add(myMoPersonal);
		}
		updateTables(tableIndex, dataList);
	}


	private void updateTables(int tableIndex, ArrayList<String> dataList) {	
		// Actualizar interior del contenedor de paneles de formulario
		
		for (String i : dataList) {
			JLabel label = new JLabel(i);
			viTablesList.get(tableIndex).getTablePanel().add(label);
		}
		
		// Se anade al arraylist pero no me va (quiero llorar)


		viTablesList.get(tableIndex).getTablePanel().revalidate(); 
		viTablesList.get(tableIndex).getTablePanel().repaint();
		
	}
	
	
}