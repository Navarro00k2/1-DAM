package model;

import java.util.ArrayList;

public class MoDato {
	
	private String datoBase;
	private int tipoDato;
	private int cantidadCaracteres;
	
	public MoDato(String datoBase, int tipoDato, int cantidadCaracteres) {
		this.datoBase = datoBase;
		this.tipoDato = tipoDato;
		this.cantidadCaracteres = cantidadCaracteres;
	}			


	public String getDatoBase() {
		return datoBase;
	}


	public void setDatoBase(String datoBase) {
		this.datoBase = datoBase;
	}


	public int getTipoDato() {
		return tipoDato;
	}


	public void setTipoDato(int tipoDato) {
		this.tipoDato = tipoDato;
	}


	public int getCantidadCaracteres() {
		return cantidadCaracteres;
	}


	public void setCantidadCaracteres(int cantidadCaracteres) {
		this.cantidadCaracteres = cantidadCaracteres;
	}


}
