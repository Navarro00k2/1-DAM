package controller;

import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Modelo;
import view.Vista;
import view.VistaPanelForm;


public class CoOyente implements KeyListener {
	
	private Modelo modelo;
	private Vista vista;

	public CoOyente(Modelo modelo, Vista vista) {
	      this.modelo = modelo;
	      this.vista = vista;
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		JTextField textfield= (JTextField) e.getSource(); //textfield source
		VistaPanelForm panel= (VistaPanelForm) textfield.getParent(); //panel padre del source, tipo vistapanelform.
		int numPanel = panel.getIndice();

			
		// Detectar si la tecla presionada es "Enter"
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			int tipoDatoPulsado = modelo.getDatosFinales().get(numPanel).getTipoDato(); //obtener el tipo de dato
			System.out.println(tipoDatoPulsado);
			boolean datoCorrecto = true;
			datoCorrecto = restringirSegunTipo(textfield.getText(), tipoDatoPulsado, datoCorrecto);
			datoCorrecto = restringirSegunCantidad(textfield.getText(), tipoDatoPulsado, datoCorrecto, numPanel);

			
			// Seguir si datoCorrecto es verdadero, es decir, si ha pasado el restringirSegunTipo en verdadero.
			if (datoCorrecto) {
				// Bucle iterando por los tipos de datos
				for (int valor = 0; valor < modelo.getTiposDato().size(); valor++) {
					// Bucle iterando por los datos
					for (int i = 0; i < modelo.getDatosFinales().size(); i++) {
						// Si el tipo de dato pulsado es igual al tipo del dato por el cual se está iterando
						if (tipoDatoPulsado == modelo.getDatosFinales().get(i).getTipoDato()) {
							vista.getListaPanelesForm().get(i).getTextField().setText(textfield.getText()); // Poner texto del pulsado
						}
					}	
				}
			}
			
		}
		
	}

	private boolean restringirSegunCantidad(String texto, int tipoDatoPulsado, boolean datoCorrecto, int numPanel) {
		int cantidad = modelo.getDatosFinales().get(numPanel).getCantidadCaracteres();
		// Alfabetico
				String mensaje = "";
		for (int i = 0; i < modelo.getTiposDato().size(); i++) {
			if (tipoDatoPulsado == i) {
				if (texto.length() <= modelo.getDatosFinales().get(numPanel).getCantidadCaracteres()) {
					mensaje = "Error: el limite de caracteres en este campo es de " + cantidad;
					JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
					datoCorrecto = false;
				}
			}
		}
			return datoCorrecto;
	}


	private boolean restringirSegunTipo(String texto, int tipoDatoPulsado, boolean datoCorrecto) {
		// Alfabetico
		String mensaje = "";
		if (tipoDatoPulsado == 0) {
			if (!texto.matches("[\\p{L}]+")) {
				mensaje = "Error: Solo se permiten letras.";
				JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
				datoCorrecto = false;
			}
		}
		// Numerico
		if (tipoDatoPulsado == 1) {
			if (!texto.matches("\\d+")) {
				mensaje = "Error: Solo se permiten números.";
				JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
				datoCorrecto = false;
			}
		}
		// Alfanumerico
		if (tipoDatoPulsado == 2) {
			if (!texto.matches("[a-zA-Z0-9]+")) {
				mensaje = "Error: Solo se permiten letras y números.";
				JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
				datoCorrecto = false;
			}
		}

		return datoCorrecto;
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
