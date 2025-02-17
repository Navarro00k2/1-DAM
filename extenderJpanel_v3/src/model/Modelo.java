package model;

import java.util.ArrayList;

public class Modelo {
	
	private ArrayList <Integer> tiposDato;
	private ArrayList <MoDato> datosFinales; // ArrayList de datos (objetos con texto, tipo y cantidad de caracteres)
	
	public Modelo() {
		this.tiposDato = llenarTipoDatos();
		this.datosFinales = llenarDatosFinales();
		
	}

	// Crear objeto de datos (texto de la etiqueta, tipo de dato y cantidad de caracteres)
	private ArrayList<MoDato> llenarDatosFinales() {
		this.datosFinales = new ArrayList<>();
		datosFinales.add(new MoDato("DNI", 2, 9));
		datosFinales.add(new MoDato("Nombre", 0, 25));
		datosFinales.add(new MoDato("Apellidos", 0, 25));
		datosFinales.add(new MoDato("Ciudad", 0, 10));
		datosFinales.add(new MoDato("Direccion", 2, 10));
		datosFinales.add(new MoDato("Tlf", 1, 9));
		datosFinales.add(new MoDato("dfasfd", 1, 9));
		return datosFinales;
	}

	// Tipos de datos disponibles
	private ArrayList<Integer> llenarTipoDatos() {
		this.tiposDato = new ArrayList<>();
		tiposDato.add(0);				//0 "alfabetico"
		tiposDato.add(1);				//1 "numerico"
		tiposDato.add(2);				//2 "alfanumerico"
		return tiposDato;
	}

	public ArrayList<Integer> getTiposDato() {
		return tiposDato;
	}

	public void setTiposDato(ArrayList<Integer> tiposDato) {
		this.tiposDato = tiposDato;
	}

	public ArrayList<MoDato> getDatosFinales() {
		return datosFinales;
	}

	public void setDatosFinales(ArrayList<MoDato> datosFinales) {
		this.datosFinales = datosFinales;
	}
	
	
	

	
}
