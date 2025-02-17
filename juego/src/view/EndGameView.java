package view;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;

import model.EndGameModel;

/*
 * Vista del menu de seleccion que aparece al final de cada ronda.
 * Este menu cuenta con 2 botones que permiten realizar las acciones de:
 * - Jugar una nueva ronda
 * - Mostrar la ventana de estadisticas
 */
public class EndGameView extends JFrame
{
	private EndGameModel model;
    private JPanel panel;
    private ArrayList<JButton> buttons; // Lista de etiquetas de la ventana de inicio
	
    public EndGameView(EndGameModel model) {
		super();
		this.model = model;
		this.panel = new JPanel();
		this.buttons = new ArrayList<JButton>();
		
        setup();

		createButtons(); // Crear los botones
		add(panel);      // Anadir panel a la ventana
	}

    /*
     * Metodo que crea los botones de la vista y los anade 
     * tanto al panel como al arrayList
     */
	private void createButtons() {
		// Iterar por la catntidad de botones
		for (int i = 0; i < model.getButtonTexts().size(); i++) {
			JButton button = new JButton(model.getButtonTexts().get(i)); // Crear boton con texto correspondiente
            buttons.add(button);
			panel.add(button); // Anadir boton al panel
		}
	}

    /*
     * Metodo que establece las propiedades de la ventana
     */
    private void setup()
    {
        setTitle(model.getTitle());
        setSize(300, 150);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /*
     * Getters
     */
    public ArrayList<JButton> getButtons()
    {
        return this.buttons;
    }
}
