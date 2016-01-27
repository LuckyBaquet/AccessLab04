package magpiesfate;

/**
 * Created by lucky on 1/26/16.
 */
public class Player {

    private int score;
    private int playerNumber;

    public Player(){

    }

    public Player(int number){
        playerNumber = number;
    }

    public void addToScore(int score){
        this.score += score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    @Override
    public String toString(){
        return "Player Number: " + playerNumber + "        Score: " + score;
    }
}
