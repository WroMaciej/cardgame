package wromaciej.cardgame.service;

import wromaciej.cardgame.model.Card;
import wromaciej.cardgame.model.CardColour;
import wromaciej.cardgame.model.CardRank;
import wromaciej.cardgame.model.Deck;

import java.util.Collections;

public abstract class DeckService {

    /**
     * Creating a final deck consists of 1 or more standard 52cards` decks
     *
     * @param numberOfStandardDecks Number of standard 52 cards decks to make that big deck
     */

    public static void createDeck(Deck deck, int numberOfStandardDecks) {
        //make sure the deck is empty
        deck.getCards().clear();
        //for every deck
        for (int deckNumber = 1; deckNumber <= numberOfStandardDecks; deckNumber++) {
            //for each colour
            for (CardColour colour : CardColour.values()) {
                //for each rank
                for (CardRank rank : CardRank.values()) {
                    deck.getCards().add(new Card(colour, rank));
                }
            }
        }
    }

    /**
     * Gets number of cards left in deck
     */
    public static int numberOfCardsInDeck(Deck deck) {
        if (deck == null) return 0;
        return deck.getCards().size();
    }


    /**
     * Sorting a deck with proper order (Colours and ranks)
     */

    public static void sort(Deck deck) {
        if ((deck != null) && (deck.getNumberOfCards() > 0)) {
            Collections.sort(deck.getCards());
        }
    }

    /**
     * Shuffling a deck with random order
     */

    public static void mix(Deck deck) {
        if ((deck != null) && (deck.getNumberOfCards() > 0)) {
            Collections.shuffle(deck.getCards());
        }
    }

    /**
     * Draw a card from the top (last index) of the deck by getting and removing from deck
     *
     * @return drawn card
     */

    public static Card draw(Deck deck) {
        Card drawnCard;
        if (deck.getNumberOfCards() > 0) {
            drawnCard = deck.getCards().get(deck.getNumberOfCards() - 1);
            deck.getCards().remove(deck.getNumberOfCards() - 1);
            return drawnCard;
        } else return null;
    }

    /**
     * Show whole deck
     */

    public static String show(Deck deck) {
        if ((deck == null) || (deck.getNumberOfCards() == 0)) return "The deck is empty";
        String viewString = new String();
        for (Card card : deck.getCards()) {
            viewString = viewString + "\n" + card.getBothNames();
        }
        return viewString;
    }

}
