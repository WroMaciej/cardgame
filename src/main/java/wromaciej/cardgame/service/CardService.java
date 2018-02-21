package wromaciej.cardgame.service;

import wromaciej.cardgame.model.Card;

public abstract class CardService {

    public static String getFullName(Card card) {
        return card.getRank().getFullName() + " of " + card.getColour().getFullName();
    }

    public static String getShortName(Card card) {
        return "(" + card.getRank().getShortName() + " " + card.getColour().getShortName() + ")";
    }

    public static String getBothNames(Card card){
        return getFullName(card)+" "+getShortName(card);
    }

    public static String toString(Card card) {
        return getFullName(card);
    }


    /**
     * Get value of colour and rank to allow sorting
     */
    public static int getSortingValue(Card card) {
        return card.getColour().getColourValue() + card.getRank().getRankValue();
    }
}
