package modelo;

import java.awt.Color;

public class MoColores {
    private Color colorActual;

    public MoColores() {
        this.colorActual = Color.WHITE;
    }

    public Color getColorActual() {
        return colorActual;
    }

    public void setColorActual(Color color) {
        this.colorActual = color;
    }
}
