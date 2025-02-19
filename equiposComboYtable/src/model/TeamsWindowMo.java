/*
 * Modelo de la ventana de los equipos (Jcombos)
 * 
 * @Navarro
 * 17-02-25
 * 
 */
package model;

import java.util.ArrayList;

public class TeamsWindowMo {
	
	private String title;								// Titulo de la ventana
	private String comboHeader;							// Cabecera del combo no clikable
	private ArrayList<PlayersMo> players;				// Lista de listas de jugadores ordenados por equipo
	private ArrayList<TeamsMo> teams;					// Lista de equipos
	
	public TeamsWindowMo() {
		this.title = "Equipos";
		this.comboHeader = "** Seleccione opcion **";
		this.players= new ArrayList<PlayersMo>();
		this.teams = new ArrayList<TeamsMo>();
		
		createTeams();			// Crear los equipos
		createPlayers();		// Crear a los jugadores
		addPlayersToTeams();	// Anadir jugadores a los equipos
	}
	

	private void addPlayersToTeams() {
		// Iterar por cada equipo
		for (TeamsMo team : teams) {
			// Iterar por cada jugador
			for (PlayersMo player : players) {
				// Si el nombre del club del jugador coincide con el de un equipo
				if (player.getClub().equals(team.getTeamName())) {
					team.getPlayers().add(player);	// Anadir jugador al equipo
				}
			}
		}
		
	}


	private void createPlayers() {	
		// Anadir al Equipo 0, Real Madrid
		players.add(new PlayersMo("Benzemalo","DC",38,teams.get(0).getTeamName()));
		players.add(new PlayersMo("Cristiano Penaldo","ED",36,teams.get(0).getTeamName()));
		players.add(new PlayersMo("Roberto Carlos","LI",51,teams.get(0).getTeamName()));
		players.add(new PlayersMo("Vincius Luther King Jr","EI",24,teams.get(0).getTeamName()));
		players.add(new PlayersMo("Casillas","POR",41,teams.get(0).getTeamName()));	
		
		// Anadir al Equipo 1, FC Barcelona
		players.add(new PlayersMo("Leo Messi","DC",35,teams.get(1).getTeamName()));
		players.add(new PlayersMo("Neymar Jr","ED",32,teams.get(1).getTeamName()));
		players.add(new PlayersMo("Lamine Yamal","ED",17,teams.get(1).getTeamName()));
		players.add(new PlayersMo("Rakitic","MD",34,teams.get(1).getTeamName()));
		players.add(new PlayersMo("Laporta","LADRON",55,teams.get(1).getTeamName()));

	}

	// Anadir a la lista de equipos, los nuevos equipos, enviando al constructor de estos (TeamsMo) el nombre y la lista de jugadores que lo componen
	private void createTeams() {
		// Crear a los equipos anadiendolos a su lista
		teams.add(new TeamsMo("Real Madrid"));	
		teams.add(new TeamsMo("FC Barcelona"));
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public ArrayList<PlayersMo> getPlayers() {
		return players;
	}


	public void setPlayers(ArrayList<PlayersMo> players) {
		this.players = players;
	}


	public ArrayList<TeamsMo> getTeams() {
		return teams;
	}


	public void setTeams(ArrayList<TeamsMo> teams) {
		this.teams = teams;
	}


	public String getComboHeader() {
		return comboHeader;
	}


	public void setComboHeader(String comboHeader) {
		this.comboHeader = comboHeader;
	}
	

	
}
