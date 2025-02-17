package model;

import java.util.ArrayList;

public class StatsModel 
{
	private String title;
	private ArrayList<String> texts;
	
	public StatsModel() 
	{
		texts = new ArrayList<String>();
		title = "Historial de partidas";
		filltexts();
	}

	private void filltexts() {
		texts.add("Partida");		// 0
		texts.add("Ganador");		// 1
	}

	
	public String getTitle() 
	{
		return title;
	}

	public void setTitle(String title) 
	{
		this.title = title;
	}

	public ArrayList<String> getTexts() 
	{
		return texts;
	}

	public void setTexts(ArrayList<String> texts) 
	{
		this.texts = texts;
	}
}
