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

import model.MoBuscaminas;

public class ViBuscaminas extends JFrame{
	private MoBuscaminas modelo;
    private ArrayList<JPanel> paneles;
    private ArrayList<JButton> botones;
    private ArrayList<JLabel> etiquetas;
	
	public ViBuscaminas(MoBuscaminas modelo) {
        paneles = new ArrayList<>();
        botones = new ArrayList<>();
        etiquetas = new ArrayList<>();
        this.modelo = modelo;

        
     // Configuración de la ventana principal
        setTitle("Menu Ascensor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new FlowLayout());
        
        propiedadesPaneles();
        propiedadesVentana();
	}
	
	public void propiedadesPaneles(){
		JPanel panelIzquierda = new JPanel(new GridLayout(modelo.getRaiz(),modelo.getRaiz(),modelo.getMargenBotones(),modelo.getMargenBotones()));
        paneles.add(panelIzquierda);
        
        JPanel panelDerecha = new JPanel(new GridLayout(2,2));
        panelDerecha.setBackground(Color.lightGray);
        paneles.add(panelDerecha);

        add(panelIzquierda);
        add(panelDerecha);
        }

	private void propiedadesVentana(){
        this.setLayout(new FlowLayout(FlowLayout.LEFT,modelo.getMargenVentana(),modelo.getMargenVentana()));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
   
	public void crearBoton(String listaBotonesPosicion) {
		JButton boton = new JButton(listaBotonesPosicion);
		boton.setPreferredSize(new Dimension(75,75));
		
		botones.add(boton);
		paneles.get(0).add(boton);
		this.pack();
	}
	
    public void crearEtiquetas(String datos){
        JLabel etiqueta = new JLabel(datos);
        etiquetas.add(etiqueta);
        paneles.get(1).add(etiquetas.get(etiquetas.size()-1));
        this.pack();
    }
    
	public void actualizarEtiqueta(int i,String texto) {
		this.etiquetas.get(i).setText(texto);
	}
    
    public void hacerVisible(boolean b){
        this.setVisible(b);
    }
    
	public ArrayList<JButton> getBotones() {
		return botones;
	}

	public void setBotones(ArrayList<JButton> botones) {
		this.botones = botones;
	}

	public ArrayList<JLabel> getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(ArrayList<JLabel> etiquetas) {
		this.etiquetas = etiquetas;
	}
    
    
    
}
