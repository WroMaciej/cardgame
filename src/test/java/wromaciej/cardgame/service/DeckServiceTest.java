package wromaciej.cardgame.service;

import org.junit.Test;
import wromaciej.cardgame.model.Card;
import wromaciej.cardgame.model.CardColour;
import wromaciej.cardgame.model.CardRank;
import wromaciej.cardgame.model.Deck;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class DeckServiceTest {

    @Test
    public void shouldReturn52cardsForNewStandardDeck() {
        //GIVEN
        Deck deck = new Deck(1);
        //WHEN
        int numberOfCards = deck.getNumberOfCards();
        //THEN
        assertThat(numberOfCards, equalTo(52));
    }

    @Test
    public void shouldReturn5200cardsFor100Decks() {
        //GIVEN
        Deck deck = new Deck(100);
        //WHEN
        int numberOfCards = deck.getNumberOfCards();
        //THEN
        assertThat(numberOfCards, equalTo(5200));
    }

    @Test
    public void shouldReturnAceOfSpadesWhenDrawAcardFromNewDeck() {
        //GIVEN
        Deck deck = new Deck(3);
        Card aceOfSpades = new Card(CardColour.SPADES, CardRank.ACE);
        //WHEN
        Card drawnCard;
        drawnCard = deck.draw();
        //THEN
        assertThat(drawnCard.compareTo(aceOfSpades), equalTo(0));
    }

    @Test
    public void shouldReturn42CardsAfter10Draws() {
        //GIVEN
        Deck deck = new Deck(1);
        //WHEN
        for (int drawNumber = 1; drawNumber <= 10; drawNumber++) {
            deck.draw();
        }
        //THEN
        assertThat(deck.getNumberOfCards(), equalTo(42));
    }

    @Test
    public void shouldReturnNullWhenDrawingFromEmptyDeck() {
        //GIVEN
        Deck deck = new Deck(1);
        Card noCardLeft;
        int cardsInNewDeck = deck.getNumberOfCards();
        //make sure the deck is empty
        for (int drawNumber = 1; drawNumber <= cardsInNewDeck; drawNumber++) {
            deck.draw();
        }
        //WHEN
        noCardLeft = deck.draw();
        //THEN
        assertThat(noCardLeft, equalTo(null));
    }

    @Test
    public void shouldReturnDifferentStringDeckRepresentationAfterMix() {
        //GIVEN
        Deck deck = new Deck(3);
        String deckStringRepresentationBeforeShuffle = deck.show();
        //WHEN
        deck.mix();
        String deckStringRepresentationAfterShuffle = deck.show();
        //THEN
        assertThat(deckStringRepresentationBeforeShuffle, not(equalTo(deckStringRepresentationAfterShuffle)));
    }

    @Test
    public void shouldReturnDifferentDeckAfterMix() {
        //GIVEN
        Deck freshDeck = new Deck(3);
        Deck mixedDeck = new Deck(3);
        //WHEN
        mixedDeck.mix();
        //THEN
        assertThat(freshDeck, not(equalTo(mixedDeck)));
    }

    @Test
    public void shouldReturnSameDeckWhenManualAndAutomaticSort() {
        //GIVEN
        Deck automaticSortedDeck = new Deck(1);
        Deck manualSortedDeck = new Deck(1);
        automaticSortedDeck.getCards().clear();
        manualSortedDeck.getCards().clear();

        Card[] unsortedCards = {
                new Card(CardColour.SPADES, CardRank.ACE),
                new Card(CardColour.SPADES, CardRank.KING),
                new Card(CardColour.HEARTS, CardRank.TWO),
                new Card(CardColour.HEARTS, CardRank.TEN),
                new Card(CardColour.CLUBS, CardRank.ACE),
                new Card(CardColour.DIAMONDS, CardRank.FIVE),
                new Card(CardColour.SPADES, CardRank.ACE)
        };
        Card[] sortedCards = {
                new Card(CardColour.HEARTS, CardRank.TWO),
                new Card(CardColour.HEARTS, CardRank.TEN),
                new Card(CardColour.DIAMONDS, CardRank.FIVE),
                new Card(CardColour.CLUBS, CardRank.ACE),
                new Card(CardColour.SPADES, CardRank.KING),
                new Card(CardColour.SPADES, CardRank.ACE),
                new Card(CardColour.SPADES, CardRank.ACE)
        };

        automaticSortedDeck.getCards().addAll(Arrays.asList(unsortedCards));
        manualSortedDeck.getCards().addAll(Arrays.asList(sortedCards));

        //WHEN
        automaticSortedDeck.sort();
        //THEN
        assertThat(automaticSortedDeck, equalTo(manualSortedDeck));
    }

    @Test
    public void shouldReturnSameDeckAfterMixAndSort() {
        //GIVEN
        Deck sortedDeck = new Deck(5);
        Deck mixedAndSortedDeck = new Deck(5);
        //WHEN
        sortedDeck.sort();
        mixedAndSortedDeck.mix();
        mixedAndSortedDeck.sort();
        //THEN
        assertThat(sortedDeck, equalTo(mixedAndSortedDeck));
    }

}
