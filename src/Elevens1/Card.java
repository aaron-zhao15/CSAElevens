package Elevens1;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

public class Card
{
	public static final String FACES[] = {"ZERO","ACE","TWO","THREE","FOUR",
			"FIVE","SIX","SEVEN","EIGHT","NINE","TEN","JACK","QUEEN","KING"};

	//instance variables
	private String suit;
        private int face;

  	//constructors
        public Card(String s, int f){
            this.suit = s;
            this.face = f;
        }
        public Card(String s){
            this.suit = s;
        }
        public Card(int f){
            this.face = f;
        }
        
        

	// modifiers
		//set methods
        public void setSuit(String s){
            this.suit = s;
        }
        public void setFace(int f){
            this.face = f;
        }


  	//accessors
		//get methods
        public String getSuit(){
            return suit;
        }
        public int getFace(){
            return face;
        }

  	//toString
        public String toString(){
            return FACES[face] + " of " + suit;
        }

 }