package model;

public class CardModel
{
    private int number;

    private static final int MIN_CARD = 1;
    private static final int MAX_CARD = 12;

    public CardModel(int number)
    {
        this.number = number;
    }

    // Method used to generate random cards
    public static CardModel randomCard()
    {
        int number = (int) (Math.random() * (MAX_CARD - MIN_CARD + 1)) + MIN_CARD;

        return new CardModel(number);
    }

    // Getters
    public int getNumber()
    {
        return this.number;
    }
}
