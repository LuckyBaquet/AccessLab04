package magpiesfate;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by lucky on 1/26/16.
 */
public class DeckTest {

    @Test
    public void testDeck(){
        Deck deck1 = new Deck();
        Deck deck2 = new Deck();
        assertNotNull(deck1);
        assertNotNull(deck2);
        assertArrayEquals(deck1.getDeck().toArray(),deck2.getDeck().toArray());

        deck1.shuffle();
        assertFalse(deck1.getDeck().equals(deck2.getDeck()));
        System.out.println(deck1.toString());
        System.out.println(deck2.toString());


        Object[] deck1Copypart0 = Arrays.copyOfRange(deck1.getDeck().toArray(),0,20);
        Object[] deck1Copypart1 = Arrays.copyOfRange(deck1.getDeck().toArray(),0,20);
        Object[] deck1Copypart2 = Arrays.copyOfRange(deck1.getDeck().toArray(),20,40);
        Object[] deck1Copypart3 = Arrays.copyOfRange(deck1.getDeck().toArray(),40,52);

        assertArrayEquals(deck1Copypart0,deck1Copypart1);

        deck1.shuffle();

        Object[] deck1Copypart4 = Arrays.copyOfRange(deck1.getDeck().toArray(),0,20);
        Object[] deck1Copypart5 = Arrays.copyOfRange(deck1.getDeck().toArray(),20,40);
        Object[] deck1Copypart6 = Arrays.copyOfRange(deck1.getDeck().toArray(),40,52);

        assertNotEquals(deck1Copypart1,deck1Copypart4);
        assertNotEquals(deck1Copypart2,deck1Copypart5);
        assertNotEquals(deck1Copypart3,deck1Copypart6);

        Card card1 = deck1.getDeck().get(0);
        Card card2 = deck1.dealOneCardOffTop();

        assertEquals(card1,card2);

        assertTrue(deck1.getDeck().size() != deck2.getDeck().size());
    }


}
