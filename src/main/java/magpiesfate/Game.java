package magpiesfate;

import java.util.Scanner;

/**
 * Created by lucky on 1/26/16.
 */
public class Game {

    private Deck deck;
    Player[] players;
    Scanner scan;

    public Game(){
        System.out.println("Welcome Welcome Welcome to Magpie's Revenge!");
        scan = new Scanner(System.in);
        initializePlayers();
        deck = new Deck();
        deck.shuffle();


        System.out.println("And the Winner Is!!!! " + playGame()+"\n");
        for (Player player:players) {
            System.out.println(player);
         }

    }

    private void initializePlayers(){
        System.out.println("How Many People are Playing today?");
        players = new Player[scan.nextInt()];

        for(int i = 0 ; i < players.length ; i++){
            players[i] = new Player(i+1);
        }
    }

    private int calculateScore(Card card){

        if(card.equals(new Card(Suit.SPADES,Rank.JACK)) || card.equals(new Card(Suit.CLUBS,Rank.JACK)))
            return 10;
        else if (card.equals(new Card(Suit.DIAMONDS,Rank.JACK)) || card.equals(new Card(Suit.HEARTS,Rank.JACK)))
            return 15;
        else if (card.equals(new Card(Suit.CLUBS,Rank.QUEEN)) || card.equals(new Card(Suit.SPADES,Rank.QUEEN)))
            return 14;
        else if (card.equals(new Card(Suit.DIAMONDS,Rank.QUEEN)) || card.equals(new Card(Suit.HEARTS,Rank.QUEEN)))
            return 18;
        else if (card.equals(new Card(Suit.CLUBS,Rank.KING)) || card.equals(new Card(Suit.SPADES,Rank.KING)))
            return 20;
        else if (card.equals(new Card(Suit.DIAMONDS,Rank.KING)) || card.equals(new Card(Suit.HEARTS,Rank.KING)))
            return 22;
        else if (card.getRank().equals(Rank.ACE) || card.getRank().equals(Rank.TWO) || card.getRank().equals(Rank.FOUR) ||
                card.getRank().equals(Rank.SIX) || card.getRank().equals(Rank.EIGHT) || card.getRank().equals(Rank.TEN))
            return 0;

        switch (card.getRank()){
            case THREE:
                return 3;
            case FIVE:
                return 5;
            case SEVEN:
                return 7;
            case NINE:
                return 9;
        }



        return -1000;
    }

    private Player determineWinner(Player[] players){
       Player winner = players[0];
        for(int i = 0; i < players.length-1; i++)
            if(winner.getScore() < players[i+1].getScore())
                winner = players[i+1];
        return winner;
    }

    private Player playGame(){
        boolean isAce = false;
        int playerCount = 0;

        while(playerCount < players.length) {
            Card tempCard = deck.dealOneCardOffTop();
            System.out.println("Player: " + (playerCount + 1) + " You were dealt: " + tempCard + " which is worth " + calculateScore(tempCard) + " points!");
            players[playerCount].addToScore(calculateScore(tempCard));

            if (tempCard.getRank().equals(Rank.ACE)) {
                System.out.println(players[playerCount]);
                playerCount++;
            }

        }
        return determineWinner(players);
    }

    public static void main(String[] args) {
        Game game = new Game();
    }

}
