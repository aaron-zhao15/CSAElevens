package blackjack;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 
public abstract class Card {

    public static final String FACES[] = {"ZERO", "ACE", "TWO", "THREE", "FOUR",
        "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING"};

    private String suit;
    private String face;
    private int pointValue;

    //constructors
    public Card() {
        suit = "";
        face = FACES[0];
        pointValue = 0;
    }

    public Card(String s, String f, int val) {
        suit = s;
        face = f;
        pointValue = val;
    }
    
    public Card(int val, String s){
        pointValue = val;
        suit = s;
        face = FACES[val];
    }

    // modifiers
    public void setSuit(String s) {
        suit = s;
    }

    public void setFace(String f) {
        face = f;
    }

    public void setPointValue(int val) {
        pointValue = val;
    }

    //accessors
    public String getSuit() {
        return suit;
    }

    public String getFace() {
        return face;
    }

    public int getPointValue() {
        return pointValue;
    }

    public abstract int getValue();

    //equals method
    public boolean equals(Card obj) {
        return obj.getSuit().equals(this.getSuit())
                && obj.getFace()==this.getFace()
                && obj.getPointValue() == this.getPointValue();
    }

    //toString
    public String toString() {
        return face + " of " + getSuit() + " | value = " + getValue();
    }
}
