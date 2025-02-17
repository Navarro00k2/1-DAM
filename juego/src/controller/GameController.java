package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JButton;

import view.GameView;
import view.StatsView;
import model.PlayerModel;
import model.StatsModel;
import model.GameModel;
import model.EndGameModel;
import view.EndGameView;

/*
 * Controlador principal que gestiona 
 * el proceso de las diferentes partidas
 */
public class GameController
{
    private GameModel model;
    private GameView view;
    private StatsModel statsModel;
    private StatsView statsView;

    /*
     * Constructor
     */
    public GameController(int numberPlayers)
    {
        this.model = new GameModel(numberPlayers);
        this.view = new GameView(model);
        this.statsModel = new StatsModel();
        this.statsView = new StatsView(model, statsModel);

        buttonsListenersAndDisable();
    }
    
    /*
     * Metodo que anade los diferentes actionListeners a los jugadores
     */
	private void buttonsListenersAndDisable()
    {
        for (int i = 0; i < view.getPlayers().size(); i++)
        {
        	view.getPlayers().get(i).getButton().addActionListener(new AddCardActionListener(view.getPlayers().get(i), this));
        	
        	if (model.getPlayers().get(i) != model.getCurrentPlayer())
        	{
            	view.getPlayers().get(i).getButton().setEnabled(false);
        	}
        }
    }

    /*
     * Metodo que itera por todos lo jugadores y selecciona el nuevo jugador 
     */
    public void nextPlayer()
    {
        ArrayList<PlayerModel> players = model.getPlayers();

        int currentIndex = players.indexOf(model.getCurrentPlayer());
        // int newIndex = (currentIndex + 1) % players.size();
        int newIndex = currentIndex;
        
        do
        {
            newIndex++;
            newIndex %= players.size();

            // Si todos los jugadores han perdido, salir del bucle
            if (newIndex == currentIndex)
                break;
        }
        while (players.get(newIndex).getPoints() > GameModel.MAX_POINTS);

        model.setCurrentPlayer(players.get(newIndex));
        updateButtons(currentIndex, newIndex);
    }

    /*
     * Metodo que actualiza el estado (enabled/disabled) de los botones
     */
    private void updateButtons(int currentIndex, int newIndex) 
    {
        view.getPlayers().get(currentIndex).getButton().setEnabled(false);
        view.getPlayers().get(newIndex).getButton().setEnabled(true);	
	}

    /*
     * Cuando termina un ronda, el boton el ultimo jugador permanece activado,
     * este metodo lo desactiva
     */
    private void disableRemainingButton() {
    	ArrayList<PlayerModel> players = model.getPlayers();
    	int currentIndex = players.indexOf(model.getCurrentPlayer());
    	
    	view.getPlayers().get(currentIndex).getButton().setEnabled(false);
	}

    /*
     * Metodo que comprueba si hay ganador y, si lo hay,
     * lanza la ventana de victoria junto con las opciones de:
     * - Jugar una nueva ronda
     * - Mostrar estadisticas
     */
	public void checkWinner()
    {
        PlayerModel winner = getWinner();

        if (winner != null)
        {
        	disableRemainingButton();
        	
            winner.setWins(winner.getWins() + 1);
        	JOptionPane.showMessageDialog(null, "¡Enhorabuena!\n Ha ganado el " + winner.getName(), "Victoria", JOptionPane.ERROR_MESSAGE);
            statsView.addRow(model.getRoundNumber(), winner, model.getPlayers());

            EndGameModel endGameModel = new EndGameModel();
            EndGameView endGameView = new EndGameView(endGameModel);

            for (JButton button : endGameView.getButtons())
            {
                button.addActionListener(new EndButtonsListener(statsView, endGameView, view, model));
            }
            endGameView.setVisible(true);
        }
    }
	
    /*
     * Metodo que busca en el ArrayList de jugadores y devuelve 
     * el ganador de la ronda.
     *
     * Si no hay ganador, devuelve nulo
     */
	public PlayerModel getWinner()
    {
        // Contar el numero de jugadores que no han perdido
        int count = 0;
        for (PlayerModel player : model.getPlayers())
        {
            if (player.getPoints() < GameModel.MAX_POINTS)
                count++;
        }

        // Si solo queda un jugador por perder, ese es el ganador
        if (count == 1)
        {
            // Encontrar y devolver dicho jugador
            for (PlayerModel player : model.getPlayers())
                if (player.getPoints() < GameModel.MAX_POINTS)
                    return player;
        }
        
        // Devolver nulo si no hay ganador
        return null;
    }

    /*
     * Getters
     */
    public GameModel getModel()
    {
        return this.model;
    }

    public GameView getView()
    {
        return this.view;
    }
}
