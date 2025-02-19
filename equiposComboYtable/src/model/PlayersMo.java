/*
 * Modelo de cada jugador.
 * Este tiene nombre, posicion y edad. 
 * El equipo no lo tiene asignado ya que es el modelo del equipo (Teams) el que contiene al jugador.
 * 
 * @Navarro
 * 17-02-25
 * 
 */

package model;

public class PlayersMo {
	
	private static int id = 1;
	private int player_id;
	private String name;		// Nombre del jugador
	private String position;	// Posicion del jugador
	private int age;			// Edad del jugador
	private String club;		// Equipo del jugador
	
	
	public PlayersMo(String name, String position, int age, String club) {
		this.name = name;
		this.position = position;
		this.age = age;
		this.club = club;
		this.player_id = id++;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getClub() {
		return club;
	}


	public void setClub(String club) {
		this.club = club;
	}
	
	
	
}
