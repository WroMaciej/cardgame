package wromaciej.cardgame.model;


import wromaciej.cardgame.service.CardService;

import java.util.Objects;

public class Card implements Comparable<Card> {

    private CardColour colour;
    private CardRank rank;

    public Card(CardColour colour, CardRank rank) {
        this.colour = colour;
        this.rank = rank;
    }

    /**
     * Gets full name of card like ACE OF SPADES
     */
    public String getFullName() {
        return CardService.getFullName(this);
    }

    /**
     * Gets full name of card like A Sp   (means Ace of Spades)
     */
    public String getShortName() {
        return CardService.getShortName(this);
    }

    public String getBothNames() {
        return CardService.getBothNames(this);
    }

    @Override
    public String toString() {
        return CardService.toString(this);
    }

    public CardColour getColour() {
        return colour;
    }

    public CardRank getRank() {
        return rank;
    }

    /**
     * Get value of colour and rank to allow sorting
     */
    public int getSortingValue() {
        return CardService.getSortingValue(this);
    }

    /**
     * Compare sorting values
     */
    @Override
    public int compareTo(Card o) {
        return getSortingValue() - o.getSortingValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return colour == card.colour &&
                rank == card.rank;
    }

    @Override
    public int hashCode() {

        return Objects.hash(colour, rank);
    }
}
