package Elevens;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//make a Deck class
public class Deck{
	public static final int NUMCARDS = 52;
	public static String[] SUITS = "CLUBS HEARTS DIAMONDS SPADES".split(" ");
        public static final String FACES[] = {"ZERO","ACE","TWO","THREE","FOUR",
			"FIVE","SIX","SEVEN","EIGHT","NINE","TEN","JACK","QUEEN","KING"};
	
	private List<Card> cards;
	private int top;

   //make a Deck constructor
   	//refer cards to new ArrayList
   	//set top to the top of the deck 51
   	
        public Deck(){
            cards = new ArrayList<Card>(52);
            top = 51;
            //loop through all suits
   		//loop through all faces 1 to 13
   			//add a new TwentyOneCard to the deck
            for(String s: SUITS){
                for(int i = 1; i < FACES.length; i++){
                    cards.add(new BlackJackCard(s, i));
                }
            }
        }
   
   //make a dealCard() method that returns the top card
        public String dealCard(){
            String s = cards.get(top).toString();
//            cards.remove(top);
            top = (top-1)%52;
            return s;
        }
        
   //write a shuffle() method
   	//use Colletions.shuffle
   	//reset the top card 
        public void shuffle(){
            Collections.shuffle(cards);
            top = 51;
        }
}