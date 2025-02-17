package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.MoProyecto;
import view.ViProyecto;

public class CoOyente implements ActionListener{

    private MoProyecto modelo;
    private ViProyecto vista;
    
    public CoOyente(MoProyecto modelo, ViProyecto vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();
	}
}