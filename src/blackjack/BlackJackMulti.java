package blackjack;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 
import static java.lang.System.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BlackJackMulti {

    private ArrayList<Player> players;
    private Dealer dealer;

    public BlackJackMulti() {
        players = new ArrayList<>();
        players.add(new Player());
    }
    
    public BlackJackMulti(int n) {
        players = new ArrayList<>();
        for(int i = 0; i < n; i++){
            players.add(new Player());
        }
    }

    public void playGame() {
        Scanner keyboard = new Scanner(System.in);
        char choice = 0;
        int dealerTotal;
        
        String answer;
        
        for(Player player : players){
            player.addCardToHand(dealer.deal());
            player.addCardToHand(dealer.deal());
            
            out.println("PLAYER: Total: " + player.getHandValue() + "\n" + player.toString());
            
            out.print("Do you want to hit? [Y/N]: ");
            boolean playerHit = player.hit();

            while (player.getHandValue() <= 21 && playerHit) {
                player.addCardToHand(dealer.deal());
                out.println(player.toString());
                playerHit = player.hit();
            }
        }
        dealer.addCardToHand(dealer.deal());
        dealer.addCardToHand(dealer.deal());

        dealerTotal = dealer.getHandValue();

        out.println("DEALER: Total: " + dealerTotal + "\n" + dealer.toString());


        boolean dealerHit = dealer.hit();

        while (dealerHit) {
            dealer.addCardToHand(dealer.deal());
            dealerTotal = dealer.getHandValue();
            out.println(dealer.toString());
            dealerHit = dealer.hit();
        }

        
        for(Player player : players){
        if (player.getHandValue() > 21 && dealerTotal > 21) {
            out.println("Both players bust!");
        }
        if (player.getHandValue() <= 21){
            if(dealerTotal > 21){
                out.println("\nPlayer wins - Dealer busted!");
            }
            else {
                out.println("\nPlayer wins!");
            }
        }
        if(dealerTotal <= 21){
            if(player.getHandValue() > 21){
                out.println("\nDealer wins - Player busted!");
            }
            else {
                out.println("\nDealer wins!");
            }
        }
        
        out.println("\nPlayer: "+ player.getHandValue() + " and Dealer:" + dealerTotal + "\n");

        }
        out.println("\nDo you want to play again? [Y/N] ");

        answer = keyboard.next();

        if(answer.toUpperCase().equals("Y")){
            for(Player player : players){
                player.resetHand();
            }
            dealer.resetHand();
            playGame();
        }
    }

    public String getPlayerHand(Player p) {
        String str = "";
        if (p.toString().contains("ACE")) {
            str += p.getHandValue() + 10;
        } else {
            str += p.getHandValue();
        }
        return str;
    }

    public static void main(String[] args) {
        BlackJackMulti game = new BlackJackMulti();
        game.playGame();
    }
}
