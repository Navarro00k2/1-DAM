package controller;

import model.Modelo;
import view.Vista;

public class Controlador {
		
	private Modelo modelo;
	private Vista vista;
	
	public Controlador() {
		this.modelo = new Modelo();
		this.vista = new Vista(modelo);
		

		vista.hacerVisible();
		activarEventoEtiquetas();
		
	}

	private void activarEventoEtiquetas() {
		for (int i = 0; i < vista.getListaPanelesForm().size(); i++) {
			this.vista.getListaPanelesForm().get(i).getTextField().addKeyListener(new CoOyente(modelo,vista));
		}
	}
}
