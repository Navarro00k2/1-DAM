package controller;

import java.util.Scanner;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.GameModel;
import model.IntroModel;
import model.PlayerModel;
import view.GameView;
import view.IntroView;

/*
 * Oyente que registra los eventos de JTextField que permite
 * introducir el numero de jugadores con el que se desea
 * jugar en la introduccion
 */
public class EnterPlayersKeyListener implements KeyListener
{
	private IntroView view;
	
    /*
     * Constructor
     */
	public EnterPlayersKeyListener(IntroView view)
    {
		this.view = view;
	}

	
	@Override
    public void keyTyped(KeyEvent e)
    {
	}
	
	@Override
	public void keyPressed(KeyEvent e)
    {
		JTextField textfield= (JTextField) e.getSource(); // Textfield source
		String input = textfield.getText();               // Texto del textfield (input de la cantidad de jugadores)
		boolean valid = false;                            // Boolean de validacion del numero de jugadores
		
		// Al pulsar "Enter"
		if (e.getKeyCode() == KeyEvent.VK_ENTER)
        {
            // Si el input es valido, iniciar el juego
			if (validateInput(input))
            {
				int playersQuantity = Integer.parseInt(input);
				initializeGame(playersQuantity);
			}
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e)
    {
	}

    /*
     * Metodo que permite iniciar el juego con el numero
     * de jugadores dado
     */
	private void initializeGame(int playersQuantity)
    {
        new GameController(playersQuantity); // Iniciar juego
		view.dispose();                      // Eliminar pantalla de inicio		
	}

    /*
     * Metodo que devuelve verdadero si el texto introducido
     * es un numero que se encuentra entre MIN_PLAYERS y MAX_PLAYERS
     *
     * Si no se introduce un numero, o este esta fuera del rango,
     * este metodo devuelve falso
     */
	private boolean validateInput(String input)
    {
        int minPlayers = GameModel.MIN_PLAYERS;
        int maxPlayers = GameModel.MAX_PLAYERS;

        Scanner scanner = new Scanner(input);

        if (!scanner.hasNextInt())
        {
        	JOptionPane.showMessageDialog(null, "Introduce un número válido", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        int number = scanner.nextInt();
        if (number < minPlayers)
        {
            JOptionPane.showMessageDialog(null, "El mínimo de jugadores es de " + minPlayers + ".", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (number > maxPlayers)
        {
            JOptionPane.showMessageDialog(null, "El máximo de jugadores es de " + maxPlayers + ".", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
	}
}
