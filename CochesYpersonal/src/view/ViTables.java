/*
 * Vista de las ventanas de las tablas.
 * 
 * @Navarro
 * 31-01-25
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.MoCoches;
import model.MoPersonal;
import model.Model;

public class ViTables extends JFrame {
	
	private Model myModel;
	private JPanel tablePanel;
	private int tableIndex;
	private int rows;		//Cantidad de filas
	private int columns;	// Cantidad de columnas
	
	public ViTables(Model myModel, int tableIndex) {
		this.myModel = myModel;
		this.tableIndex = tableIndex;

		
		setRowsAndColumns();		// Anadir la cantidad de filas y columnas
		addTablePanel();			// Anadir un panel principal a la ventana
		windowProperties();			// Configuración de cada ventana de tablas
		addDefaultData();			// Anadir los datos default de la tabla
	}
	

	
	private void addDefaultData() {		
		// Anadir los Campos Principales
		for(int mainFieldIndex = 0; mainFieldIndex < columns; mainFieldIndex++) {
			JLabel label = new JLabel(myModel.getMainFields().get(tableIndex).get(mainFieldIndex));
			tablePanel.add(label);
		}
		// Anadir los datos
		for (int row = 0; row < rows; row++) {
			ifIsMoCoches(row);		// Si es de clase MoCoches
			ifIsMoPersonal(row);	// Si es de clase MoPersonal
		}
	}

	
	private void ifIsMoPersonal(int row) {
		// Si en esta tabla (tableIndex), el elemento de la tabla por el que se itera (row), es de la clase MoPersonal
		if (myModel.getTablesList().get(tableIndex).get(row) instanceof MoPersonal) {
			
			// Obtener datos correspondientes al tipo en etiquetas y anadirlos a la ventana
			JLabel name = new JLabel(myModel.getPersonalList().get(row).getName());
			JLabel position = new JLabel(myModel.getPersonalList().get(row).getPosition());
			JLabel salary = new JLabel(String.valueOf(myModel.getPersonalList().get(row).getSalary())); //int to String
			tablePanel.add(name);
			tablePanel.add(position);
			tablePanel.add(salary);
		}
		
	}

	private void ifIsMoCoches(int row) {
		// Si en esta tabla (tableIndex), el elemento de la tabla por el que se itera (row), es de la clase MoCoches
		if (myModel.getTablesList().get(tableIndex).get(row) instanceof MoCoches) {
			
			// Obtener datos correspondientes al tipo en etiquetas y anadirlos a la ventana
			JLabel brand = new JLabel(myModel.getCochesList().get(row).getBrand());
			JLabel color = new JLabel(myModel.getCochesList().get(row).getColor());
			tablePanel.add(brand);
			tablePanel.add(color);
		}
		
	}

	
	private void setRowsAndColumns() {
		this.rows = myModel.getTablesList().get(tableIndex).size();	// Cantidad de datos (filas) de la tabla que corresponde segun el indice
		this.columns = myModel.getMainFields().get(tableIndex).size(); 	// Cantidad de campos de la tabla
		
	}
	
	
	private void addTablePanel() {
		tablePanel = new JPanel(new GridLayout(0,columns, 40, 10));
		add(tablePanel);
	}


	private void windowProperties() {	
	    setTitle(myModel.getTableNames().get(tableIndex));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new FlowLayout());	
	}



	public Model getMyModel() {
		return myModel;
	}



	public void setMyModel(Model myModel) {
		this.myModel = myModel;
	}



	public JPanel getTablePanel() {
		return tablePanel;
	}



	public void setTablePanel(JPanel tablePanel) {
		this.tablePanel = tablePanel;
	}



	public int getTableIndex() {
		return tableIndex;
	}



	public void setTableIndex(int tableIndex) {
		this.tableIndex = tableIndex;
	}



	public int getRows() {
		return rows;
	}



	public void setRows(int rows) {
		this.rows = rows;
	}



	public int getColumns() {
		return columns;
	}



	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	
	
	
}
