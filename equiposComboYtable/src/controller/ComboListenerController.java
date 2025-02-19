/*
 * Controlador oyente de los combos. 
 * Al hacer click en un jugador, este se elimina del JCombo y pasa a la tabla en la otra ventana.
 * 
 * @Navarro
 * 17-02-25
 * 
 */
package controller;


import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

import model.PlayersMo;
import model.TeamsMo;
import model.TeamsWindowMo;
import view.SeleccionWindowVi;


public class ComboListenerController implements ItemListener{

	private SeleccionWindowVi mySeleccionVi;		// Vista de la ventana de la seleccion (ventana de la tabla)
	private TeamsWindowMo myTeamsWindowMo;			// Vista de la ventana de equipos (ventana de los combos)
	private boolean isUpdating = false; 			// Bandera para evitar eventos innecesarios (GPTazo historico)
	
	public ComboListenerController(TeamsWindowMo myTeamsWindowMo, SeleccionWindowVi mySeleccionVi) {
		this.mySeleccionVi = mySeleccionVi;
		this.myTeamsWindowMo = myTeamsWindowMo;
	}
	
	// Al hacer click en un jugador (en una fila de la tabla)
    @Override
    public void itemStateChanged(ItemEvent e) {
    	if (isUpdating) return; // Evita que se ejecute de nuevo al eliminar un elemento
    	
    	// Cuando se pulse en un jugador del combo
        if (e.getStateChange() == ItemEvent.SELECTED) {
        	
        		// Iterar por los jugadores del equipo 
	        	for (PlayersMo player : myTeamsWindowMo.getPlayers()) {
	        		
	        		// Si el nombre pulsado es igual al nombre falso para seleccionar (la cabecera, primer elemento de cada combo), no hacer nada
	            	if ((String) e.getItem() == player.getClub()) {
	            		return;
	            	}
	        		
	        		// Si el nombre pulsado es igual al nombre del jugador por el que se esta iterando
		        	if ((String) e.getItem() == player.getName()) {
		                Object[] row = new Object[] {(String) e.getItem(), player.getClub(), player.getPosition(), player.getAge()}; // Anadir una fila con nombre del jugador, nombre de su equipo, posicion del jugador y su edad
		                mySeleccionVi.getTableModel().addRow(row);
		                
		                isUpdating = true; // Desactivar eventos temporalmente
		                
	                    JComboBox<String> comboBox = (JComboBox<String>) e.getSource(); // Obtener nombre pulsado
	                    comboBox.removeItem((String) e.getItem()); // Eliminar nombre del combo
	                    comboBox.setSelectedIndex(0); // Volver a la cabecera (valor 0 del combo)
	                    
	                    isUpdating = false; // Reactivar eventos
	                    return; // Salir del metodo para evitar errores
		        	}
	        }
        }    
    }

    
    
    
    
    
}
