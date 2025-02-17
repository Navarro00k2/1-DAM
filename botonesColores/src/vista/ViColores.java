package vista;

import javax.swing.*;
import java.awt.*;

public class ViColores extends JFrame {
    private JLabel label;
    private JButton greenButton, yellowButton, redButton;

    public ViColores() {
        // Configuración de la ventana
        setTitle("Cambio de Color");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        // Crear el JLabel grande
        label = new JLabel();
        label.setOpaque(true);
        label.setBackground(Color.WHITE);
        label.setPreferredSize(new Dimension(200, 100));
        add(label, BorderLayout.CENTER);

        // Crear el panel de botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        // Crear botones
        greenButton = new JButton("Verde");
        greenButton.setBackground(Color.GREEN);

        yellowButton = new JButton("Amarillo");
        yellowButton.setBackground(Color.YELLOW);

        redButton = new JButton("Rojo");
        redButton.setBackground(Color.RED);

        // Añadir botones al panel
        buttonPanel.add(greenButton);
        buttonPanel.add(yellowButton);
        buttonPanel.add(redButton);

        // Añadir el panel a la ventana
        add(buttonPanel, BorderLayout.NORTH);

        // Hacer visible la ventana
        setVisible(true);
    }

    public JLabel getLabel() {
        return label;
    }

    public JButton getGreenButton() {
        return greenButton;
    }

    public JButton getYellowButton() {
        return yellowButton;
    }

    public JButton getRedButton() {
        return redButton;
    }
}
