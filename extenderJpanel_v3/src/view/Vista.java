package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Modelo;

public class Vista extends JFrame{
	private Modelo modelo;
	private JPanel panelPrincipal;
	private ArrayList<VistaPanelForm> listaPanelesForm;
	
	public Vista(Modelo modelo) {
		this.modelo = modelo;
		listaPanelesForm = new ArrayList<VistaPanelForm>();
		propiedadesVentana();
		crearPanelPrincipal();
		crearPanelesForm();
	}

	
	private void crearPanelesForm() {
		for (int i = 0; i < modelo.getDatosFinales().size(); i++) {
			VistaPanelForm vistaPanelForm = new VistaPanelForm(modelo, i);
			listaPanelesForm.add(vistaPanelForm);
			panelPrincipal.add(listaPanelesForm.get(i));
		}
		
	}

	private void crearPanelPrincipal() {
		panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new GridLayout(10,1,5,10));
		add(panelPrincipal);
	}

	private void propiedadesVentana() {
		setTitle("Ventana");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new FlowLayout());	
	}
	
	public void hacerVisible() {
		setVisible(true);
	}


	public Modelo getModelo() {
		return modelo;
	}


	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}


	public JPanel getPanelPrincipal() {
		return panelPrincipal;
	}


	public void setPanelPrincipal(JPanel panelPrincipal) {
		this.panelPrincipal = panelPrincipal;
	}


	public ArrayList<VistaPanelForm> getListaPanelesForm() {
		return listaPanelesForm;
	}


	public void setListaPanelesForm(ArrayList<VistaPanelForm> listaPanelesForm) {
		this.listaPanelesForm = listaPanelesForm;
	}
	
	
	
	
}
