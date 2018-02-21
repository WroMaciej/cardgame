package wromaciej.cardgame.model;

import wromaciej.cardgame.service.DeckService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Deck with cards
 */
public class Deck {
    private List<Card> cards;

    /**
     * Make a big deck of several standard 52 cards` deck during constructor
     */
    public Deck(int numberOfStandardDecks) {
        cards = new ArrayList<>();
        DeckService.createDeck(this, numberOfStandardDecks);
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getNumberOfCards() {
        return DeckService.numberOfCardsInDeck(this);
    }

    /**
     * Sort a deck in right order
     */
    public void sort() {
        DeckService.sort(this);
    }

    /**
     * Shuffle a deck
     */
    public void mix() {
        DeckService.mix(this);
    }

    /**
     * Draw a card from the top (last index) of the deck by getting and removing from deck
     *
     * @return drawn card
     */
    public Card draw() {
        return DeckService.draw(this);
    }

    /**
     * Show whole deck
     */
    public String show() {
        return DeckService.show(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deck deck = (Deck) o;
        return Objects.equals(cards, deck.cards);
    }

    @Override
    public int hashCode() {

        return Objects.hash(cards);
    }
}
