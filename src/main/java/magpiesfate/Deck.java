package magpiesfate;

import java.util.ArrayList;

/**
 * Created by lucky on 1/26/16.
 */
public class Deck {

    private ArrayList<Card> deck;
    private final int num_Cards = 52;




    public Deck(){
        deck = new ArrayList<Card>();
        fillDeck();
    }

    public void shuffle(){
        ArrayList<Card> deck2 = new ArrayList<Card>();
        int i = 0;

        while(!(deck.isEmpty())){
            deck2.add(deck.remove((int)(Math.random() * deck.size())));
        }

        deck = deck2;

    }

    public Card dealOneCardOffTop(){
        if(deck.isEmpty())return null;

        return deck.remove(0);
    }

    private void fillDeck(){
        for(int i = 0 ; i < num_Cards ; i++){
            deck.add(i,new Card());
            switch (i%4){
                case 3:
                    deck.get(i).setSuit(Suit.CLUBS);
                    break;
                case 2:
                    deck.get(i).setSuit(Suit.DIAMONDS);
                    break;
                case 1:
                    deck.get(i).setSuit((Suit.HEARTS));
                    break;
                case 0:
                    deck.get(i).setSuit(Suit.SPADES);
            }

            switch(i%13){
                case 0:
                    deck.get(i).setRank(Rank.ACE);
                    break;
                case 1:
                    deck.get(i).setRank(Rank.TWO);
                    break;
                case 2:
                    deck.get(i).setRank(Rank.THREE);
                    break;
                case 3:
                    deck.get(i).setRank(Rank.FOUR);
                    break;
                case 4:
                    deck.get(i).setRank(Rank.FIVE);
                    break;
                case 5:
                    deck.get(i).setRank(Rank.SIX);
                    break;
                case 6:
                    deck.get(i).setRank(Rank.SEVEN);
                    break;
                case 7:
                    deck.get(i).setRank(Rank.EIGHT);
                    break;
                case 8:
                    deck.get(i).setRank(Rank.NINE);
                    break;
                case 9:
                    deck.get(i).setRank(Rank.TEN);
                    break;
                case 10:
                    deck.get(i).setRank(Rank.JACK);
                    break;
                case 11:
                    deck.get(i).setRank(Rank.QUEEN);
                    break;
                case 12:
                    deck.get(i).setRank(Rank.KING);
                    break;
            }


        }
    }

    public ArrayList<Card> getDeck(){
        return deck;
    }

    @Override
    public String toString(){
        return deck.toString();
    }

    @Override
    public boolean equals(Object deck){
        return this.deck.equals(((Deck)deck).getDeck());
    }
}
