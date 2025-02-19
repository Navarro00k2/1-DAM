/*
 * Vista de la ventana de la seleccion (de la tabla).
 * 
 * @Navarro
 * 17-02-25
 * 
 */
package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.SeleccionWindowMo;

public class SeleccionWindowVi extends JFrame{

	private SeleccionWindowMo mySeleccionMo;			// Modelo de esta ventana
	private DefaultTableModel tableModel;		// Modelo predeterminado de la tabla
	private JTable table;						// Tabla de los jugadores elegidos para la seleccion
	
	public SeleccionWindowVi(SeleccionWindowMo mySeleccionMo) {
		this.mySeleccionMo = mySeleccionMo;
		this.tableModel = new DefaultTableModel();
		this.table = new JTable();
		
		windowProperties();				// Propiedades de la ventana
		createTable();					// Crear la tabla
		add(new JScrollPane(table)); 	// Anadir panel scrolleable a la ventana
	}
	
	private void windowProperties() {
		setTitle(mySeleccionMo.getTitle());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new FlowLayout());
        
        // Centrar la ventana a la derecha
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 	// Obtener la dimensión de la pantalla (monitor)
        int x = screenSize.width - getWidth(); 									// Poner la ventana pegada a la derecha
        int y = (screenSize.height - getHeight()) / 2; 							// Centrar verticalmente en la pantalla
        setLocation(x, y); 														// Colocar en la posicion calculada
	}

	private void createTable() {
        tableModel = new DefaultTableModel(); // Iniciar nuevo modelo de tabla
        
        // Anadir columnas con su texto, iterando por la lista de textos de columna
        for (String text : mySeleccionMo.getColumnTexts()) {
        	tableModel.addColumn(text);	
        }

        table = new JTable(tableModel); 	// Crear la tabla con el modelo de tabla creado
        table.setEnabled(false); 			// deshabilitar edicion de la tabla
    }
	
	
	
	public SeleccionWindowMo getMySeleccionMo() {
		return mySeleccionMo;
	}
	
	public void setMySeleccionMo(SeleccionWindowMo mySeleccionMo) {
		this.mySeleccionMo = mySeleccionMo;
	}
	
	public DefaultTableModel getTableModel() {
		return tableModel;
	}
	
	public void setTableModel(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}
	
	public JTable getTable() {
		return table;
	}
	
	public void setTable(JTable table) {
		this.table = table;
	}
	   
	   
}
