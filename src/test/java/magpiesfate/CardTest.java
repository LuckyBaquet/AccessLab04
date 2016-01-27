package magpiesfate;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by lucky on 1/26/16.
 */
public class CardTest {

    @Test
    public void testCard(){
        Card card = new Card();
        card.setRank(Rank.ACE);
        card.setSuit(Suit.DIAMONDS);

        assertEquals(card.getRank() , Rank.ACE);
        assertEquals(card.getSuit() , Suit.DIAMONDS);
    }
}
