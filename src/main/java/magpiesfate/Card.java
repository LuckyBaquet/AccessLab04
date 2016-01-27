package magpiesfate;

/**
 * Created by lucky on 1/26/16.
 */
public class Card {

    private Suit suit;
    private Rank rank;


    public Card(){

    }

    public Card(Suit suit, Rank rank){

        this.suit = suit;
        this.rank = rank;

    }


    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    @Override
    public boolean equals(Object card){
        return this.getRank() == ((Card)card).getRank() && this.getSuit() == ((Card)card).getSuit();
    }

    @Override
    public String toString(){
        return " Rank: " + rank + "      Suit: " + suit;
    }
}
