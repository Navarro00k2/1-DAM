/*
 * Modelo de cada equipo. Contiene a los jugadores de este.
 * 
 * @Navarro
 * 17-02-25
 * 
 */
package model;

import java.util.ArrayList;

public class TeamsMo {
	
	private String teamName;					// Nombre del equipo
	private ArrayList<PlayersMo> players;		// Lista de jugadores que lo componen
	
	public TeamsMo(String teamName) {
		this.teamName = teamName;
		this.players = new ArrayList<PlayersMo>();
	}

	
	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public ArrayList<PlayersMo> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<PlayersMo> players) {
		this.players = players;
	}

	
}
