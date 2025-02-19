/*
 * Controlador principal que crea las instancias de las ventanas y sus modelos, 
 * asi como anadir los oyentes
 * 
 * @Navarro
 * 17-02-25
 * 
 */

package controller;

import model.SeleccionWindowMo;
import model.TeamsWindowMo;
import view.SeleccionWindowVi;
import view.TeamsWindowVi;

public class MainController {

	public  MainController() {
		
		TeamsWindowMo myTeamsWindowMo = new TeamsWindowMo();					// Crea el modelo de la ventana de equipos (ventana de los combos)
		TeamsWindowVi myTeamsWindowVi = new TeamsWindowVi(myTeamsWindowMo);		// Crea la vista de la ventana de equipos (ventana de los combos)
		
		SeleccionWindowMo mySeleccionMo = new SeleccionWindowMo();							// Crea el modelo de la ventana de seleccion (ventana de la tabla)
		SeleccionWindowVi mySeleccionVi = new SeleccionWindowVi(mySeleccionMo);				// Crea la vista de la ventana de seleccion (ventana de la tabla)
		
		addCombosListener(myTeamsWindowVi, myTeamsWindowMo, mySeleccionVi);		// Anade los oyentes a los combos
		addTablelistener(mySeleccionVi, myTeamsWindowVi, myTeamsWindowMo);		// Anade el oyente a la tabla 
		
		// Hacer las ventanas visibles
		myTeamsWindowVi.setVisible(true);
		mySeleccionVi.setVisible(true);
	}

	private void addTablelistener(SeleccionWindowVi mySeleccionVi, TeamsWindowVi myTeamsWindowVi, TeamsWindowMo myTeamsWindowMo) {
		mySeleccionVi.getTable().addMouseListener(new tableListenerController(mySeleccionVi, myTeamsWindowVi, myTeamsWindowMo));
		
	}

	private void addCombosListener(TeamsWindowVi myTeamsVi, TeamsWindowMo myTeamsWindowMo, SeleccionWindowVi mySeleccionVi) {
		// Iterar por la lista de paneles de combo (ComboPanels)
		for (int i = 0; i < myTeamsVi.getComboPanelsList().size(); i++) {
			myTeamsVi.getComboPanelsList().get(i).getCombo().addItemListener(new ComboListenerController(myTeamsWindowMo, mySeleccionVi));
		}
	}	


}
