package controller;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import model.MoBuscaminas;
import view.ViBuscaminas;

public class CoBuscaminas {
	private MoBuscaminas modelo;
	private ViBuscaminas vista;
	
	public CoBuscaminas() {
		this.modelo = new MoBuscaminas();
		introducirCantBotones();
		this.vista = new ViBuscaminas(modelo);
		modelo.setCantBombas((modelo.getCantBotones()/5));
		crearBotones();
		crearEtiquetas();
		crearIndicesBomba();
		activarEventoBoton();
		
		vista.hacerVisible(true);
	}
	

	private void crearIndicesBomba() {	
		ArrayList<Integer> listaTemp = modelo.getIndicesBomba();
		int n;
		for (int i = 0; i < modelo.getCantBombas(); i++) {
			do {
				Random random = new Random();
				n = random.nextInt(modelo.getCantBotones());
			} while (modelo.getIndicesBomba().contains(n));
			listaTemp.add(n);
			System.out.println(n);
		}
		modelo.setIndicesBomba(listaTemp);
	}
	
	
	private void introducirCantBotones() {
		String cantBotones = JOptionPane.showInputDialog("Introduce el numero de casillas");
		modelo.setCantBotones(Integer.parseInt(cantBotones));
	}
	
    private void crearBotones() {
    	for(int i = 0;i<modelo.getCantBotones();i++) {
            vista.crearBoton(modelo.getListaBotones().get(i));
        }
    }
    
    private void crearEtiquetas() {
        for(int i = 0; i<modelo.getDatos().size();i++) {
            vista.crearEtiquetas(modelo.getDatos().get(i));
        }
    }
    
    
    private void activarEventoBoton() {
        for (int i = 0; i < vista.getBotones().size(); i++) {
            this.vista.getBotones().get(i).addActionListener(new CoOyente(modelo,vista));
        }
    }
}
