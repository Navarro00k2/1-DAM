package controller;

import model.IntroModel;
import view.IntroView;

/*
 * Controlador que crea y controla la vista de la
 * ventana de introduccion (la ventana que contiene las instrucciones)
 */
public class IntroController
{
    private IntroModel model;
    private IntroView view;

    public IntroController()
    {
        this.model = new IntroModel();
        this.view = new IntroView(model);
        view.getIntroNumberTextField().addKeyListener(new EnterPlayersKeyListener(view));

    }
}
