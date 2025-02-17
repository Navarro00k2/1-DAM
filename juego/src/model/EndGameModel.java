package model;

import java.util.ArrayList;

public class EndGameModel {
    private String title;
	private ArrayList<String> buttonTexts;
	
	public EndGameModel() {
		this.buttonTexts = new ArrayList<String>();
        this.title = "Final de la ronda";
		
		addButtonTexts();
	}

	private void addButtonTexts() {
		buttonTexts.add("NUEVA RONDA");
		buttonTexts.add("VER HISTORIAL");
	}

	public ArrayList<String> getButtonTexts() {
		return buttonTexts;
	}

	public void setButtonTexts(ArrayList<String> buttonTexts) {
		this.buttonTexts = buttonTexts;
	}

    public String getTitle()
    {
        return this.title;
    }
}

