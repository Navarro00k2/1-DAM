/*
 * Controlador oyente de la tabla. 
 * Al hacer click en un jugador de esta, este se elimina de la tabla y pasa de vuelta a su JCombo en la otra ventana.
 * 
 * @Navarro
 * 17-02-25
 * 
 */
package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.TeamsWindowMo;
import view.ComboPanelsVi;
import view.SeleccionWindowVi;
import view.TeamsWindowVi;

public class tableListenerController implements MouseListener{

	private SeleccionWindowVi mySeleccionVi;				//vista de la ventana de la seleccion (ventana de la tabla) 			
	private TeamsWindowVi myTeamsWindowVi;			//vista de la ventana de equipos (ventana de los combos)
	
	public tableListenerController(SeleccionWindowVi mySeleccionVi, TeamsWindowVi myTeamsWindowVi, TeamsWindowMo myTeamsWindowMo) {
		this.mySeleccionVi = mySeleccionVi;
		this.myTeamsWindowVi = myTeamsWindowVi;
	}

	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public void mousePressed(MouseEvent e) {	
		// TODO Auto-generated method stub
	}

	
	
	// Al hacer click (y soltarlo) en un jugador de la tabla
	@Override
	public void mouseReleased(MouseEvent e) {
		int row = mySeleccionVi.getTable().rowAtPoint(e.getPoint()); // Obtener posicion de la fila clicada
		
		// Si se hace click en una fila de la tabla (fuera devuelve -1)
        if (row >= 0) {
        	String playerName = (String) mySeleccionVi.getTableModel().getValueAt(row, 0);   // Obtener el nombre del jugador de la fila seleccionada, columna 0 (nombre del jugador)
        	String playerTeam = (String) mySeleccionVi.getTableModel().getValueAt(row, 1);   // Obtener el equipo del jugador de la fila seleccionada, columna 0 (nombre del jugador)
        	
        	mySeleccionVi.getTableModel().removeRow(row); // Eliminar la fila seleccionada
        	
        	// Iterar por los paneles de combo de la ventana de equipos
        	for (ComboPanelsVi comboPanel : myTeamsWindowVi.getComboPanelsList()) {
        		
        		// Si el texto de la etiqueta (nombre del equipo) del panel de combo por el que se itera es el mismo que el del equipo del jugador clikado
        		if (comboPanel.getLabel().getText().equals(playerTeam)) {
        			comboPanel.getCombo().addItem(playerName); // Anadir nombre del jugador clikado al combo
        			return;
        		}     		
        	}
        }		
	}

	
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
