package model;

import java.util.ArrayList;

public class IntroModel
{
    private ArrayList<String> infoTexts;  // Textos del panel de informacion    
    private ArrayList<String> otherTexts; // Textos del panel de introducir
    
    public IntroModel()
    {
        otherTexts = new ArrayList<>();
        infoTexts = new ArrayList<>();
        
        createOtherTexts();
        createInfoTexts();
    }
    
    private void createOtherTexts() {
        otherTexts.add("Titulo de ventana awa");                       //2
        otherTexts.add("Introduce la cantidad de jugadores (Enter):"); //1
    }

    private void createInfoTexts() {
        infoTexts.add("REGLAS DEL JUEGO");                                                                     //0
        infoTexts.add("Cada jugador saca una carta por turno.");                                             //1
        infoTexts.add("Las cartas dan la misma cantidad de puntos que su número.");                            //2
        infoTexts.add("A partir del nº7, las cartas valen 0'5 puntos.");                                     //3
        infoTexts.add("La puntuación se suma al jugador correspondiente.");                                 //4
        infoTexts.add("Gana el jugador que no sobrepase el 7'5 de puntuación al finalizar la ronda.");         //5
    }

    public ArrayList<String> getInfoTexts() {
        return infoTexts;
    }

    public void setInfoTexts(ArrayList<String> infoTexts) {
        this.infoTexts = infoTexts;
    }

    public ArrayList<String> getOtherTexts() {
        return otherTexts;
    }

    public void setOtherTexts(ArrayList<String> otherTexts) {
        this.otherTexts = otherTexts;
    }
}

