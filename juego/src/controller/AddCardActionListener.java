package controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import view.PlayerView;
import model.CardModel;
import model.PlayerModel;
import model.GameModel;
import view.GameView;

/*
 * Oyente que registra los eventos de los botones de los jugadores
 */
public class AddCardActionListener implements ActionListener
{
    private PlayerView view;
    private PlayerModel model;

    private GameController gameController;
    private GameModel gameModel;
    private GameView gameView;

    /*
     * Constructor
     */
    public AddCardActionListener(PlayerView view, GameController controller)
    {
        this.view = view;
        this.model = view.getModel();

        this.gameController = controller;
        this.gameModel = gameController.getModel();
        this.gameView = gameController.getView();
    }

    public void actionPerformed(ActionEvent event)
    {
        if (model != gameModel.getCurrentPlayer())
            return;

        if (model.getPoints() < GameModel.MAX_POINTS)
            model.addCard(CardModel.randomCard());

        // Ir al siguiente jugador
        gameController.nextPlayer();
        
        // Actualizar la vista
        view.update();

        // Comprobar si hay ganador
        gameController.checkWinner();
    }
}
