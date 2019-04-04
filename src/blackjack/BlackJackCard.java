package blackjack;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 
public class BlackJackCard extends Card {
    
    //constructors
    public BlackJackCard(){
        super();
    }
    
    /**
     *
     * @param s
     * @param f
     * @param val
     */
    public BlackJackCard(String s, String f, int val){
        super(s, f, val);
    }
    
    public BlackJackCard(int val, String s){
        super(val, s);
    }

    public int getValue() {
        int val;
        
        if(super.getPointValue() == 1){
            val = 11;
        }
        else if (super.getPointValue() < 10) {
            val = super.getPointValue();
        }
        else {
            val = 10;
        }
        return val;
    }

}
