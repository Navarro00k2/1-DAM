package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.MoBuscaminas;
import view.ViBuscaminas;

public class CoOyente implements ActionListener{

    private MoBuscaminas modelo;
    private ViBuscaminas vista;
    
    public CoOyente(MoBuscaminas modelo, ViBuscaminas vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource(); // Boton que se hace click
        int posicion = Integer.parseInt(boton.getText()); // Sacar posicion del texto del boton
        if (modelo.getIndicesBomba().contains(posicion)) {
        	boton.setBackground(Color.RED);
        	int y = modelo.getFallos();
        	modelo.setFallos(y+1);
        	String fallos = String.valueOf(modelo.getFallos());
        	vista.actualizarEtiqueta(3,fallos);
        } else {
        	boton.setBackground(Color.GREEN);
        	int x = modelo.getAciertos();
        	modelo.setAciertos(x+1);
          	String aciertos = String.valueOf(modelo.getAciertos());
        	vista.actualizarEtiqueta(1,aciertos);
        }
    	
    	boton.setEnabled(false);
	}

}
