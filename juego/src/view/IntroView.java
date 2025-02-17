package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.IntroModel;

/*
 * Vista de la ventana de introduccion.
 * Esta ventana muestras las instrucciones
 * del juego
 */
public class IntroView extends JFrame
{
    private IntroModel model;                 // Modelo de la ventana de inicio
    private ArrayList<JPanel> panelsList;     // Lista de paneles de la ventana de inicio
    private ArrayList<JLabel> infoLabelsList; // Lista de etiquetas de la ventana de inicio
    private JTextField introNumberTextField;  // Textfield de introducir nº de jugadores
    
    /*
     * Constructor
     */
    public IntroView(IntroModel model) {
        this.model = model;

        panelsList = new ArrayList<>();
        infoLabelsList = new ArrayList<>();
        this.introNumberTextField = new JTextField();
        
        windowPropierties(); // Propiedades de la ventana
        createInfoPanel();   // Crear panel de info
        createIntroPanel();  // Crear panel de inroducir nº de jugadores
        setVisible(true);
    }

    /*
     * Metodo que crea los diferentes paneles de infomacion de la vista
     */
    private void createInfoPanel()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0,1,1,1));
        
        // Bucle iterando por los infoTexts
        for (int i = 0; i < model.getInfoTexts().size(); i++)
        {
            JLabel label = new JLabel(model.getInfoTexts().get(i)); // Crear label con texto correspondiente a su posicion
            label.setHorizontalAlignment(SwingConstants.CENTER);    // Centrar etiqueta al panel
            infoLabelsList.add(label);                              // Anadir label su lista
            panel.add(infoLabelsList.get(i));                       // Anadir a la lista de paneles 0 (infoPanel) la etiqueta creada desde su lista
        }
        
        panelsList.add(panel); // Anadir el panel a la lista de paneles
        this.add(panel);       // Anadir el panel a la ventana
    }

    /*
     * Metodo que crea los diferentes paneles de introduccion de datos
     */
    private void createIntroPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        
        JLabel label = new JLabel(model.getOtherTexts().get(1)); // Crear label con texto correspondiente
        label.setHorizontalAlignment(SwingConstants.CENTER);     // Centrar etiqueta al panel
        panel.add(label);
        
        introNumberTextField.setPreferredSize(new Dimension(50,20));
        panel.add(introNumberTextField);
        
        panelsList.add(panel); // Anadir el panel a la lista de paneles
        this.add(panel);       // Anadir el panel a la ventana
    }

    /*
     * Metodo que establece las propiedades de la ventana
     */
    private void windowPropierties()
    {
        setTitle(model.getOtherTexts().get(0));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);
        setLayout(new GridLayout(0,1,1,50));    
        
        // Centrar la ventana a la pantalla
        this.setLocationRelativeTo(null);
    }

    /*
     * Getters
     */
    public ArrayList<JPanel> getPanelsList() {
        return panelsList;
    }

    public ArrayList<JLabel> getInfoLabelsList() {
        return infoLabelsList;
    }

    public JTextField getIntroNumberTextField() {
        return introNumberTextField;
    }

    /*
     * Setters
     */
    public void setPanelsList(ArrayList<JPanel> panelsList) {
        this.panelsList = panelsList;
    }

    public void setInfoLabelsList(ArrayList<JLabel> infoLabelsList) {
        this.infoLabelsList = infoLabelsList;
    }

    public void setIntroNumberTextField(JTextField introNumberTextField) {
        this.introNumberTextField = introNumberTextField;
    }
}
