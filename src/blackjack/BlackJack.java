package blackjack;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 
import static java.lang.System.*;
import java.util.Scanner;

public class BlackJack {

    private Dealer dealer;
    private Player player;

    public BlackJack() {
        dealer = new Dealer();
        player = new Player();
    }

    public void playGame() {
        Scanner keyboard = new Scanner(System.in);
        char choice = 0;
        int playerTotal;
        int dealerTotal;
        
        String answer;
        
        do {
            dealer.shuffle();
            player.addCardToHand(dealer.deal());
            player.addCardToHand(dealer.deal());
            dealer.addCardToHand(dealer.deal());
            dealer.addCardToHand(dealer.deal());

            playerTotal = player.getHandValue();
            dealerTotal = dealer.getHandValue();

            out.println("PLAYER: Total: " + playerTotal + "\n" + player.toString());
            out.println("DEALER: Total: " + dealerTotal + "\n" + dealer.toString());

            out.print("Do you want to hit? [Y/N]: ");
            boolean playerHit = player.hit();

            while (playerTotal <= 21 && playerHit) {
                player.addCardToHand(dealer.deal());
                playerTotal = player.getHandValue();
                out.println(player.toString());
                playerHit = player.hit();
            }

            boolean dealerHit = dealer.hit();

            while (dealerHit) {
                dealer.addCardToHand(dealer.deal());
                dealerTotal = dealer.getHandValue();
                out.println(dealer.toString());
                dealerHit = dealer.hit();
            }
            
            if (playerTotal > 21 && dealerTotal > 21) {
                out.println("Both players bust!");
            }
            if (playerTotal <= 21){
                if(dealerTotal > 21){
                    out.println("\nPlayer wins - Dealer busted!");
                }
                //if (!(dealer.toString().contains("ACE")) &&
                //        (dealerTotal + 10) >= dealerTotal && dealerTotal <= 11)
                else {
                    out.println("\nPlayer wins!");
                }
            }
            if(dealerTotal <= 21){
                if(playerTotal > 21){
                    out.println("\nDealer wins - Player busted!");
                }
                else {
                    out.println("\nDealer wins!");
                }
            }
            
            out.println("\nPlayer: "+ playerTotal + " and Dealer:" + dealerTotal + "\n");
            
            out.println("\nDo you want to play again? [Y/N] ");
            
            answer = keyboard.next();
            
            player.resetHand();
            dealer.resetHand();
            
        } while (answer.toUpperCase().equals("Y"));

    }

    public String getPlayerHand(Player p) {
        String str = "";
        if (player.toString().contains("ACE")) {
            str += p.getHandValue() + 10;
        } else {
            str += p.getHandValue();
        }
        return str;
    }

    public static void main(String[] args) {
        BlackJack game = new BlackJack();
        game.playGame();
    }
}
