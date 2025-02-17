package model;

import java.util.ArrayList;

public class MoBuscaminas {
	private int margenBotones;
    private int margenVentana;
	private int cantBotones;
	private int cantBombas;
	private int aciertos;
	private int fallos;
	private ArrayList<Integer> indicesBomba;
	private ArrayList<String> listaBotones;
	private ArrayList<String> datos;
	
	public MoBuscaminas() {

        margenBotones = 5;
        margenVentana = 30;
        aciertos = 0;
        fallos = 0;
		listaBotones = new ArrayList<>();
		indicesBomba = new ArrayList<>();
		datos = new ArrayList<>();

		llenarDatos();
	}
	
	
    private void llenarDatos() {
        datos.add("ACIERTOS -> "); // 0
        datos.add("0"); // 1
        datos.add("FALLOS -> "); // 2
        datos.add("0"); // 3
    }

	public int getRaiz() {
		return (int) Math.sqrt(cantBotones);
	}
	
    public int getCantBotones() {
        return cantBotones;
    }

    public void setCantBotones(int cantBotones) {
        this.cantBotones = cantBotones;
        for (int i = 0; i < cantBotones; i++) {
            listaBotones.add(""+i);
        }
    }
 

	public ArrayList<Integer> getIndicesBomba() {
		return indicesBomba;
	}


	public void setIndicesBomba(ArrayList<Integer> indicesBomba) {
		this.indicesBomba = indicesBomba;
	}


	public int getCantBombas() {
		return cantBombas;
	}


	public void setCantBombas(int cantBombas) {
		this.cantBombas = cantBombas;
	}


	public int getMargenBotones() {
		return margenBotones;
	}

	public void setMargenBotones(int margenBotones) {
		this.margenBotones = margenBotones;
	}

	public int getMargenVentana() {
		return margenVentana;
	}

	public void setMargenVentana(int margenVentana) {
		this.margenVentana = margenVentana;
	}
	
	
	
	public int getAciertos() {
		return aciertos;
	}


	public void setAciertos(int aciertos) {
		this.aciertos = aciertos;
	}


	public int getFallos() {
		return fallos;
	}


	public void setFallos(int fallos) {
		this.fallos = fallos;
	}


	public ArrayList<String> getDatos() {
		return datos;
	}


	public void setDatos(ArrayList<String> datos) {
		this.datos = datos;
	}


	public ArrayList<String> getListaBotones() {
		return listaBotones;
	}

	public void setListaBotones(ArrayList<String> listaBotones) {
		this.listaBotones = listaBotones;
	}
	
    
}
