package controller;

import model.MoProyecto;
import view.ViProyecto;

public class CoProyecto {
	private MoProyecto modelo;
	private ViProyecto vista;
	
	public CoProyecto() {
		this.modelo = new MoProyecto();
		this.vista = new ViProyecto(modelo);
		
		vista.hacerVisible(true);
	}

	
}
