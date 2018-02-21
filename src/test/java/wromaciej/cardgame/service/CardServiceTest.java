package wromaciej.cardgame.service;

import org.junit.Test;
import wromaciej.cardgame.model.Card;
import wromaciej.cardgame.model.CardColour;
import wromaciej.cardgame.model.CardRank;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class CardServiceTest {

    @Test
    public void shouldReturnAceOfSpades() {
        //GIVEN
        Card card = new Card(CardColour.SPADES, CardRank.ACE);
        //WHEN
        String fullName = CardService.getFullName(card);
        //THEN
        assertThat(fullName, equalTo("Ace of Spades"));
    }

    @Test
    public void shouldReturn310SortingValueForTenClubs() {
        //GIVEN
        Card card = new Card(CardColour.CLUBS, CardRank.TEN);
        //WHEN
        int sortingValue = CardService.getSortingValue(card);
        //THEN
        assertThat(sortingValue, equalTo(310));
    }

}
