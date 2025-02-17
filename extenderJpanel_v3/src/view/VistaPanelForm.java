/*
 * Panel con label y textfield. 
 * 
 */

package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.CoOyente;
import controller.Controlador;
import model.Modelo;


public class VistaPanelForm extends JPanel {
	
	private Modelo modelo;
	private int indice;
	private JTextField textField;

	public VistaPanelForm(Modelo modelo, int indice) {
		this.modelo = modelo;
		this.indice = indice;


		setLayout(new GridLayout(1,1,1,1)); //layout del panel contenedor
		crearEtiqueta();
		crearTextField();
	}
	
	public VistaPanelForm(Modelo modelo) {
		indice = -1;
	}
	

	private void crearTextField() {
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(100,20));
		this.add(textField);
		
	}

	private void crearEtiqueta() {
		JLabel label = new JLabel(modelo.getDatosFinales().get(indice).getDatoBase());
		label.setPreferredSize(new Dimension(100,20));
		
		this.add(label);
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}


	
	
}
