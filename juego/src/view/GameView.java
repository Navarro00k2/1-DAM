package view;

import javax.swing.JFrame;
import javax.swing.BoxLayout;

import java.util.ArrayList;

import model.GameModel;
import model.PlayerModel;

/*
 * Vista pricipal de juego, esta vista contiene
 * un ArrayList con todas las vistas de los jugadores
 * así como sus botones de 'Coger carta'
 */
public class GameView extends JFrame
{
    private GameModel model;

    private ArrayList<PlayerView> players;

    /*
     * Constructor
     */
    public GameView(GameModel model)
    {
        super();
        this.model = model;

        setup();
        addPlayers();

        addElements();
        setVisible(true);
    }

    /*
     * Metodo que establece las propiedades de la ventana
     */
    private void setup()
    {
        setTitle(model.getTitle());
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /* 
     * Metodo que, a partir de los jugadores almacenados en el
     * modelo, crea sus vistas y los anade un ArrayList para que
     * permanezcan accesibles
     */
    private void addPlayers()
    {
        players = new ArrayList<PlayerView>();
        for (PlayerModel playerModel : model.getPlayers())
        {
            PlayerView playerView = new PlayerView(playerModel);
            players.add(playerView);
        }
    }

    /*
     * Metodo que anade la vista de los jugadores al panel
     */
    private void addElements()
    {
        for (PlayerView player : players)
            add(player);
    }

    // Getters
    public ArrayList<PlayerView> getPlayers()
    {
        return players;
    }
}
