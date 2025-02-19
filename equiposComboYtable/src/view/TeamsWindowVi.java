/*
 * Vista de la ventana de los equipos (de los combos).
 * 
 * @Navarro
 * 17-02-25
 * 
 */
package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.PlayersMo;
import model.TeamsWindowMo;

public class TeamsWindowVi extends JFrame{
	
	private TeamsWindowMo myTeamsWindowMo;					// Modelo de esta ventana
	private ArrayList<ComboPanelsVi> comboPanelsList;		// Conjunto de nombre del equipo + combo
	private JPanel mainPanel; 								// Panel principal de la ventana
	
	public TeamsWindowVi(TeamsWindowMo myTeamsWindowMo) {
		this.myTeamsWindowMo = myTeamsWindowMo;
		this.comboPanelsList = new ArrayList<ComboPanelsVi>();
		this.mainPanel= new JPanel(); 
		
		windowProperties();		// Propiedades de la ventana
		createCombos();			// Crear los combos
		mainPanelSetup();		// Propiedades del panel principal
		
	}

	private void mainPanelSetup() {
		mainPanel.setLayout(new GridLayout(0,myTeamsWindowMo.getTeams().size(),100,10)); // Layout ajustando columnas al numero de equipos
		add(mainPanel); // Anadir panel a la ventana
	}

	private void createCombos() {
		
		// Iterar por los equipos
		for (int i = 0; i < myTeamsWindowMo.getTeams().size(); i++) {
			ArrayList<String> names = new ArrayList<String>(); // Iniciar lista de nombres para guardar los nombres de los jugadores del equipo que corresponde
			names.add(myTeamsWindowMo.getComboHeader());
			// Iterar por los jugadores del equipo
        	for (PlayersMo player : myTeamsWindowMo.getTeams().get(i).getPlayers()) {
        		names.add(player.getName()); // Anadir el nombre del jugador a la lista de nombres
			}
	
			JComboBox<String> combo = new JComboBox(names.toArray()); // Crear el combo con los nombres
			JLabel label = new JLabel(myTeamsWindowMo.getTeams().get(i).getTeamName()); // Crear etiqueta con el nombre del equipo
			
			ComboPanelsVi comboPanel = new ComboPanelsVi(label, combo);	// Crear panel con la etiqueta y el combo	
			comboPanelsList.add(comboPanel); // Anadir el panel de combo a la lista de paneles de combo
			
			mainPanel.add(comboPanelsList.get(i)); // Anadir panel de combo a la lista de paneles
		}
	}

	
	private void windowProperties() {
		setTitle(myTeamsWindowMo.getTitle());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new FlowLayout());
        
        // Centrar la ventana a la izquierda
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // Obtener la dimensión de la pantalla (monitor)
        int x = 0; // Poner la ventana pegada a la izquierda
        int y = (screenSize.height - getHeight()) / 2; // Centrar verticalmente en la pantalla
        setLocation(x, y); // Colocar en la posicion calculada
		
	}

	
	
	public TeamsWindowMo getMyTeamsWindowMo() {
		return myTeamsWindowMo;
	}

	public void setMyTeamsWindowMo(TeamsWindowMo myTeamsWindowMo) {
		this.myTeamsWindowMo = myTeamsWindowMo;
	}

	public ArrayList<ComboPanelsVi> getComboPanelsList() {
		return comboPanelsList;
	}

	public void setComboPanelsList(ArrayList<ComboPanelsVi> comboPanelsList) {
		this.comboPanelsList = comboPanelsList;
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	

	
}
