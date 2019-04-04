package blackjack;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 
import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    public static final int NUMFACES = 13;
    public static final int NUMSUITS = 4;
    public static final int NUMCARDS = 52;

    public static final String SUITS[] = {"CLUBS", "SPADES", "DIAMONDS", "HEARTS"};
    public static final String[] ranks = {"ACE", "TWO", "THREE", "FOUR", "FIVE", 
        "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING"};
    public static final int[] vals = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};

    private int topCardIndex = 51;
    private ArrayList<Card> stackOfCards;

    public Deck() {
        //initialize data - stackOfCards - topCardIndex
        stackOfCards = new ArrayList<Card>();
        for(int i = 0; i < ranks.length; i++){
            for (String suit : SUITS) {
                stackOfCards.add(new BlackJackCard(suit, ranks[i], vals[i]));
            }
        }
    }

    //modifiers
    public void shuffle() {
        //shuffle the deck
        Collections.shuffle(stackOfCards);
        //reset variables as needed
        topCardIndex = 51;
    }

    //accessors
    public int size() {
        return stackOfCards.size();
    }

    public int numCardsLeft() {
        return topCardIndex + 1;
    }

    public Card nextCard() {
        return stackOfCards.get(topCardIndex--);
    }

    public String toString() {
        return stackOfCards + "   topCardIndex = " + topCardIndex;
    }
}
