/*
 * Ventana principal del programa.
 * 
 * @Navarro
 * 18-02-25
 * 
 */
package view;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.BudgetWindowMo;


public class BudgetWindowVi extends JFrame{

	private BudgetWindowMo myBudgetWindowMo;				// Modelo de la ventana
	private FinalBudgetPanelVi myFinalBudgetPanelVi;		// Panel del precio final (etiqueta y campo mostrando el presupuesto final)
	private JPanel mainSectionsPanel;						// Panel que agrupa los paneles de secciones
	private ArrayList<SectionPanelsVi> sectionPanels;		// Lista de paneles de seccion. Cada seccion es un conjunto de opciones, una cabecera y campo para introducir numero de personas.
	
	public BudgetWindowVi(BudgetWindowMo myBudgetWindowMo) {
		this.myBudgetWindowMo = myBudgetWindowMo;
		this.myFinalBudgetPanelVi = new FinalBudgetPanelVi(myBudgetWindowMo);
		mainSectionsPanel = new JPanel();
		this.sectionPanels = new ArrayList<SectionPanelsVi>();
		
		windowProperties(); 				// Propiedades de la ventana
		mainSectionsPanelSetup();			// Propiedades del panel de secciones
		sectionPanelsSetup(); 				// Establecer los paneles de seccion
		this.add(myFinalBudgetPanelVi); 	// Anadir a la ventana el panel de presupuesto final
	}


	private void sectionPanelsSetup() {
		// Iterar por las secciones
		for (int i = 0; i  < myBudgetWindowMo.getSections().size(); i ++) {
			SectionPanelsVi sectionPanel = new SectionPanelsVi(myBudgetWindowMo, i); // Crear nuevo panel de seccion mandando el numero de panel
			sectionPanels.add(sectionPanel); // Anadir el panel creado a la lista de paneles de seccion
			mainSectionsPanel.add(sectionPanels.get(i)); // Anadir el panel introducido a la lista al panel contendor de paneles de seccion (me vuelvo loco)
		}
	}


	private void windowProperties() {
		setTitle(myBudgetWindowMo.getTexts().get(0));
        setSize(800, 500);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(0,1,0,50));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void mainSectionsPanelSetup() {
		mainSectionsPanel.setLayout(new GridLayout(1,0,10,10));
		this.add(mainSectionsPanel); // Anadir a la ventana el panel contenedor de secciones
		
	}

	public BudgetWindowMo getMyBudgetWindowMo() {
		return myBudgetWindowMo;
	}


	public void setMyBudgetWindowMo(BudgetWindowMo myBudgetWindowMo) {
		this.myBudgetWindowMo = myBudgetWindowMo;
	}


	public FinalBudgetPanelVi getMyFinalBudgetPanelVi() {
		return myFinalBudgetPanelVi;
	}


	public void setMyFinalBudgetPanelVi(FinalBudgetPanelVi myFinalBudgetPanelVi) {
		this.myFinalBudgetPanelVi = myFinalBudgetPanelVi;
	}


	public JPanel getMainSectionsPanel() {
		return mainSectionsPanel;
	}


	public void setMainSectionsPanel(JPanel mainSectionsPanel) {
		this.mainSectionsPanel = mainSectionsPanel;
	}


	public ArrayList<SectionPanelsVi> getSectionPanels() {
		return sectionPanels;
	}


	public void setSectionPanels(ArrayList<SectionPanelsVi> sectionPanels) {
		this.sectionPanels = sectionPanels;
	}
	

	
	
}
