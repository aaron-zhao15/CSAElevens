package blackjack;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 
import java.util.ArrayList;
import blackjack.Card;

public abstract class AbstractPlayer implements Playerable {

    private ArrayList<Card> hand;
    private int winCount;

    public AbstractPlayer(){
        hand = new ArrayList<Card>();
        winCount = 0;
    }
    
    public void addCardToHand(Card temp) {
        hand.add(temp);
    }

    public void resetHand() {
        hand.clear();
    }

    public void setWinCount(int numwins) {
        winCount = numwins;
    }

    public int getWinCount() {
        return winCount;
    }

    public int getHandSize() {
        return hand.size();
    }

    public int getHandValue() {
        int total = 0;
        for(Card c : hand){
            total += c.getPointValue();
        }
        return total;
    }

    public String toString() {
        return "hand = " + hand.toString() + " \n-  # wins " + winCount;
    }
}
