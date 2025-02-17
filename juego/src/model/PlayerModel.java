package model;

import java.util.ArrayList;

public class PlayerModel
{
    private String name;
    private int wins;
    private ArrayList<CardModel> cards;


    public PlayerModel(String name)
    {
        this.name = name;
        this.wins = 0;
        this.cards = new ArrayList<CardModel>();
    }

    public String getName()
    {
        return this.name;
    }

    public int getWins()
    {
        return this.wins;
    }

    public void setWins(int wins)
    {
        this.wins = wins;
    }

    public ArrayList<CardModel> getCards()
    {
        return this.cards;
    }

    public double getPoints()
    {
        double sum = 0;
        for (CardModel card : cards)
        {
            int number = card.getNumber();
            if (number < 7)
                sum += number;
            else
                sum += 0.5;
        }

        return Math.floor(sum * 10) / 10;
    }

    public void addCard(CardModel newCard)
    {
        cards.add(newCard);
    }

    public void setCards(ArrayList<CardModel> cards)
    {
        this.cards = cards;
    }
}
