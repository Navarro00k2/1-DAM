package main;

import controlador.CoColores;
import modelo.MoColores;
import vista.ViColores;

public class Main {
    public static void main(String[] args) {
        MoColores modelo = new MoColores();
        ViColores vista = new ViColores();
        new CoColores(modelo, vista);
    }
}
