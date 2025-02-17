package model;

import java.util.ArrayList;

public class GameModel
{
    private ArrayList<PlayerModel> players;

    private PlayerModel currentPlayer;
    private int numberPlayers;
    private int roundNumber;
    private String title;

    public static final int MIN_PLAYERS = 2;
    public static final int MAX_PLAYERS = 10;
    public static final double MAX_POINTS = 7.6; 

    public GameModel(int numberPlayers)
    {
        this.numberPlayers = numberPlayers;
        this.roundNumber = 1;
        this.title = "Juego de las 7 y media";

        createPlayers();
        currentPlayer = players.get(0);
    }

    private void createPlayers()
    {
        players = new ArrayList<PlayerModel>();
        for (int i = 0; i < numberPlayers; i++)
            players.add(new PlayerModel("Jugador " + (i + 1)));
    }

    public ArrayList<PlayerModel> getPlayers()
    {
        return this.players;
    }

    public PlayerModel getCurrentPlayer()
    {
        return currentPlayer;
    }

    public void setCurrentPlayer(PlayerModel currentPlayer)
    {
        this.currentPlayer = currentPlayer;
    }

    public int getRoundNumber()
    {
        return this.roundNumber;
    }

    public void setRoundNumber(int roundNumber)
    {
        this.roundNumber = roundNumber;
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
    
}
