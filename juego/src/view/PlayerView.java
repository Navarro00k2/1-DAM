package view;

import java.util.ArrayList;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;

import model.PlayerModel;
import model.CardModel;
import model.GameModel;

/*
 * Clase que representa la vista de cada jugador.
 * Cada jugador consta de 3 componentes:
 * - Un ArrayList de JLabels que muestran informacion 
 *   relevante de cada jugador (nombre, puntuacion y vistorias)
 * - Un ArrayList de cartas
 * - Un boton que permite tomar una carta
 */
public class PlayerView extends JPanel
{
    private PlayerModel model;

    private ArrayList<JPanel> panels;
    private ArrayList<JLabel> labels;
    private JButton button;

    // Colors
    private static final Color WON_COLOR =  new Color(144, 238, 144);
    private static final Color LOST_COLOR = Color.RED;

    public PlayerView(PlayerModel model)
    {
        this.model = model;

        // Crear elementos
        createPanels();
        createLabels();
        createButton();

        // Anadir elementos a la vista
        addLabels();
        addCards();
        addPanels();
        addButton();

        update();
        setLayout(new GridLayout(1, 3));
        setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
    }

    /*
     * Metodo que crea los diferentes paneles de la vista del jugador
     */
    private void createPanels()
    {
        panels = new ArrayList<JPanel>();

        for (int i = 0; i < 2; i++)
        {
            JPanel panel = new JPanel(new FlowLayout());
            panel.setOpaque(false);
            panels.add(panel);
        }
    }

    /*
     * Metodo que crea los JLabel
     */
    private void createLabels()
    {
        labels = new ArrayList<JLabel>();

        for (int i = 0; i < 3; i++)
        {
            JLabel label = new JLabel();                         // Crear label
            label.setPreferredSize(new Dimension(150, 30));      // Establecer tamano
            label.setHorizontalAlignment(SwingConstants.CENTER); // Centrar texto
            labels.add(label);                                   // Add to ArrayList
        }
    }

    /*
     * Metodo que crea el boton de cada jugador
     */
    private void createButton()
    {
        button = new JButton("Nueva carta"); // TODO: Move to model
        // button.setEnabled(false);
    }

    /*
     * Metodo que anade las JLabel a la vista
     */
    private void addLabels()
    {
        for (JLabel label : labels)
            panels.get(0).add(label);
    }

    /*
     * Metodo que elimina todas las cartas existentes
     * y las vuelve a anadir para actualizarlas
     */
    private void addCards()
    {
        panels.get(1).removeAll();
        for (CardModel card : model.getCards())
            panels.get(1).add(new CardView(card));
    }

    /*
     * Metodo que anade el boton a la vista
     */
    private void addButton()
    {
        add(button);
    }

    /*
     * Metodo que anade los paneles a la vista
     */
    private void addPanels()
    {
        for (JPanel panel : panels)
            add(panel);
    }

    /*
     * A partir de la informacion contenida
     * en el modelo del mismo jugador se actualiza la informacion 
     * representada en la vista
     */
    public void update()
    {
        labels.get(0).setText("Nombre: " + model.getName());
        labels.get(1).setText("Victorias: " + model.getWins());
        labels.get(2).setText("Puntuacion: " + model.getPoints());

        addCards();

        // Set background color
        if (model.getPoints() <= GameModel.MAX_POINTS)
            setBackground(WON_COLOR);
        else
            setBackground(LOST_COLOR);
    }

    /*
     * Getters
     */
    public PlayerModel getModel()
    {
        return this.model;
    }

	public JButton getButton() {
		return button;
	}

    /*
     * Setters
     */
	public void setButton(JButton button) {
		this.button = button;
	}
    
    public void setColor(Color color)
    {
        setBackground(color);
    }
}
