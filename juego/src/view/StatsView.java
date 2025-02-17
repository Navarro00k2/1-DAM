/*
 * Ventana de las estadisticas con tabla
 */
package view;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;

import model.GameModel;
import model.PlayerModel;
import model.StatsModel;

public class StatsView extends JFrame
{
    private GameModel model;				// Modelo del juego
    private StatsModel statsModel;			// Modelo de la ventana de estadisticas

    private DefaultTableModel tableModel; 	// Modelo de la tabla
    private JTable tableView; 				// Tabla

    public StatsView(GameModel model, StatsModel statsModel)
    {
        super();
        this.statsModel = statsModel;
        setup(); // Establecer propiedades a la ventana

        this.model = model;

        createTable(); 						// Crear la tabla
        add(new JScrollPane(tableView)); 	// Anadir panel scrolleable a la ventana
    }

    /*
     * Establecer las propiedades de la ventana
     */
    private void setup()
    {
        setTitle(statsModel.getTitle());
        setSize(500, 500);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    /*
     * Este metodo crea un DefaultTableModel se lo anade a
     * una JTable (vista)
     *
     * Las columnas de la JTable son las siguientes
     * - Numero de ronda
     * - Puntuacion jugador 1
     * - Puntuacion jugador 2
     * - Puntuacion jugador 3
     * - ...
     * - Ganador de la randa
     */
    private void createTable()
    {
        tableModel = new DefaultTableModel(); // Iniciar nuevo modelo de tabla

        tableModel.addColumn(statsModel.getTexts().get(0)); // Columna para ver el numero de la partida
        // Iterar por la cantidad de jugadores
        for (PlayerModel player : model.getPlayers())
        tableModel.addColumn(player.getName()); // Anadir nombre del jugador
        tableModel.addColumn(statsModel.getTexts().get(1)); // Anadir el texto "Ganador"

        tableView = new JTable(tableModel); // Crear la tabla con el modelo de tabla creado
        tableView.setEnabled(false); // Deshabilitar edicion de la tabla
    }

    /*
     * Metodo para anadir los registros de cada partida al historial
     */
    public void addRow(int number, PlayerModel winner, ArrayList<PlayerModel> players)
    {
        ArrayList<String> values = new ArrayList<String>();

        values.add(String.valueOf(number));
        for (PlayerModel player : players)
            values.add(String.valueOf(player.getPoints()));
        values.add(winner.getName());

        tableModel.addRow(values.toArray());
    }
}
