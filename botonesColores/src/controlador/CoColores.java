package controlador;

import modelo.MoColores;
import vista.ViColores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CoColores {
    private MoColores modelo;
    private ViColores vista;

    public CoColores(MoColores modelo, ViColores vista) {
        this.modelo = modelo;
        this.vista = vista;

        // Agregar listeners a los botones
        vista.getGreenButton().addActionListener(new CambiarColorListener(modelo, vista, "GREEN"));
        vista.getYellowButton().addActionListener(new CambiarColorListener(modelo, vista, "YELLOW"));
        vista.getRedButton().addActionListener(new CambiarColorListener(modelo, vista, "RED"));
    }

    // Listener interno para manejar los cambios de color
    private static class CambiarColorListener implements ActionListener {
        private MoColores modelo;
        private ViColores vista;
        private String color;

        public CambiarColorListener(MoColores modelo, ViColores vista, String color) {
            this.modelo = modelo;
            this.vista = vista;
            this.color = color;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (color) {
                case "GREEN" -> modelo.setColorActual(java.awt.Color.GREEN);
                case "YELLOW" -> modelo.setColorActual(java.awt.Color.YELLOW);
                case "RED" -> modelo.setColorActual(java.awt.Color.RED);
            }
            vista.getLabel().setBackground(modelo.getColorActual());
        }
    }
}
