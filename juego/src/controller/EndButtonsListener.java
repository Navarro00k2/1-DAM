package controller;

import java.util.ArrayList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

import view.StatsView;
import view.EndGameView;
import view.GameView;
import model.GameModel;
import model.PlayerModel;
import model.CardModel;
import view.PlayerView;

/*
 * Oyente que registra los eventos de los dos botones
 * que se encuentran en menu de final de ronda
 */
public class EndButtonsListener implements ActionListener
{
    private StatsView statView;
    private EndGameView endGameView;
    private GameView gameView;
    private GameModel gameModel;

    /*
     * Constructor
     */
    public EndButtonsListener(StatsView statView, EndGameView endGameView, GameView gameView, GameModel gameModel)
    {
        this.statView = statView;
        this.endGameView = endGameView;
        this.gameView = gameView;
        this.gameModel = gameModel;
    }

    public void actionPerformed(ActionEvent event)
    {
        JButton source = (JButton) event.getSource();

        int index = endGameView.getButtons().indexOf(source);
        System.out.println("Index: " + index);
        if (index == -1)
            return;

        // Boton de nueva ronda
        if (index == 0)
        {
            System.out.println("Nueva ronda");
            newRound();
            endGameView.dispose();
        }

        // Boton mostrar estadisticas
        if (index == 1)
        {
            System.out.println("Mostar estadisticas");
            statView.setVisible(true);
        }
    }

    /*
     * Metodo que reinicia el estado del juego para que
     * comience una nueva ronda
     */
    private void newRound()
    {
        // Eliminar todas las cartas de todos los jugadores
        for (PlayerModel player : gameModel.getPlayers())
            player.setCards(new ArrayList<CardModel>());

        // Actualizar la vista de todos los jugadores
        for (PlayerView player : gameView.getPlayers())
            player.update();

        enableNextButton();
        
        // Actualizar la vista del juego
        gameView.repaint();

        // Incrementar el numero de ronda
        gameModel.setRoundNumber(gameModel.getRoundNumber() + 1);

        // Volver a comenzar con el primer jugador
        gameModel.setCurrentPlayer(gameModel.getPlayers().get(0));
    }

    /*
     * Método que permite habilitar el boton del jugar contiguo
     * al actual
     */
	private void enableNextButton() 
	{
	    ArrayList<PlayerModel> players = gameModel.getPlayers();
	    gameModel.setCurrentPlayer(players.get(0));
	    int currentIndex = players.indexOf(gameModel.getCurrentPlayer());
	    gameView.getPlayers().get(currentIndex).getButton().setEnabled(true);	
	}
	
}
