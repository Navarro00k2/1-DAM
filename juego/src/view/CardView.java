package view;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Image;

import model.CardModel;

/*
 * Clase que representa la vista de cada carta,
 * cada carta se corresponde con un JLabel que 
 * contiene un ImageIcon
 */
public class CardView extends JLabel
{
    private CardModel model;

    /*
     * Constructor
     */
    public CardView(CardModel model)
    {
        super();
        this.model = model;

        /*
         * Se selecciona la imagen correspodiente a la carta que 
         * indica el modelo y se aplica a la vista.
         */
        ImageIcon icon = new ImageIcon("img/type1/" + model.getNumber() + ".png");
        Image img = icon.getImage();

        // La imagen se escala para que no sea demasiado grande
        Image scaled = img.getScaledInstance((int) (img.getWidth(null) / 3), (int) (img.getHeight(null) / 3), java.awt.Image.SCALE_SMOOTH);
        icon.setImage(scaled);

        // Aplicar la imagen al JLabel
        this.setIcon(icon);
    }
}
