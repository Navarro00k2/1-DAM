package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.MoProyecto;

public class ViProyecto extends JFrame{
	  private ArrayList<JPanel> paneles;
	  private ArrayList<JButton> botones;
	  private ArrayList<JLabel> etiquetas;
	  private ArrayList<JFrame> ventanas;
	  private MoProyecto modelo;
	  
	public ViProyecto(MoProyecto modelo) {
		paneles = new ArrayList<>();
	    botones = new ArrayList<>();
	    etiquetas = new ArrayList<>();
	    ventanas = new ArrayList<>();
	    this.modelo = modelo;
 
	 // Configuración de la ventana principal
	    setTitle("Ventana");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new FlowLayout());
        setVisible(true);
        
        crearPaneles();
        crearVentana();
	    crearElementosPrincipales();
    }
	
	public ViProyecto (char a) {
		
	}
	
  
	
	public void crearPaneles() {
		JPanel panel = new JPanel(new FlowLayout());
	    paneles.add(panel);
	    add(panel);
	}

	private void crearVentana() {
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 2, 2));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

	// Crear textfield y boton para enviar
	public void crearElementosPrincipales() {
		crearBoton();
		crearTextField();	
	}


	private void crearTextField() {
		JTextField textfield = new JTextField();
		textfield.setPreferredSize(new Dimension(75,75));
		paneles.get(0).add(textfield);
		this.pack();
		
	}

	private void crearBoton() {
		JButton boton = new JButton("Enviar");
        boton.setPreferredSize(new Dimension(75,75));
        botones.add(boton);
        paneles.get(0).add(boton);
		this.pack();
		
	}
	
    public void hacerVisible(boolean b){
        this.setVisible(b);
    }
	
}
