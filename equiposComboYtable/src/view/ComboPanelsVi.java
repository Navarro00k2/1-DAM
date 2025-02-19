/*
 * Paneles de combo. 
 * Contienen una etiqueta con el nombre del equipo y un combo con los nombres de los jugadores del equipo correspondiente.
 * 
 * @Navarro
 * 17-02-25
 * 
 */
package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ComboPanelsVi extends JPanel{
	
	private JLabel label;				// Nombre del equipo
	private JComboBox<String> combo;	// Listado combo de jugadores del equipo
	
	public ComboPanelsVi(JLabel label, JComboBox<String> combo) {
		this.label = label;
		this.combo = combo;
		
		setLayout(new GridLayout(2,1,10,1)); // Layout de este panel
	    add(label);	// Anadir la etiqueta al panel
	    add(combo);	// Anadir el combo al panel
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public JComboBox<String> getCombo() {
		return combo;
	}

	public void setCombo(JComboBox<String> combo) {
		this.combo = combo;
	}
	
	
	
}
