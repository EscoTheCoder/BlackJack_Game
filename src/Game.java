import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Game {

    String player;
    Random random = new Random();
    ArrayList<Integer> deck;

    public Game(String player, ArrayList<Integer> deck) {
        this.player = player;
        this.deck = deck;
    }

    public String play() {

        ArrayList<Integer> playerHand = new ArrayList<>();
        ArrayList<Integer> dealerHand = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Welcome " + player + "! Are you ready to start? (YES/NO): ");
        String answer = scanner.nextLine().toUpperCase();
        if (!answer.equals("YES")) {
            System.out.println("Thank you! Come back when you're ready!");
            return "NOT READY";
        }

        System.out.println("Let's start the game!");
        boolean playing = true;
        while (playing) {
            playerHand = drawCard(playerHand);
            dealerHand = drawCard(dealerHand);
            playerHand = drawCard(playerHand);
            dealerHand = drawCard(dealerHand);

            System.out.println("Your hand: " + playerHand);
            System.out.println("Dealer's hand: " + dealerHand.get(0));

            while (true) {
                try {
                    System.out.print("STAY or HIT: ");
                    String choice = scanner.nextLine().toUpperCase();
                    if (!choice.equals("STAY") && !choice.equals("HIT")) {
                        throw new EscoException("Invalid choice! Please enter 'STAY' or 'HIT'.");
                    }
                    if (choice.equals("STAY")) {
                        break;
                    } else {
                        playerHand = drawCard(playerHand);
                        System.out.println("Your hand: " + playerHand);
                    }
                }
                catch (EscoException e) {
                    System.out.println(e.getMessage());
                }
            }


            // Seira tou Dealer
            while (sumHand(dealerHand) < 17) {
                dealerHand = drawCard(dealerHand);
            }
            System.out.println("Dealer's hand: " + dealerHand);

            String result = determineWinner(playerHand, dealerHand);
            System.out.println(result);

            System.out.print("Do you want to play again? (YES/NO): ");
            answer = scanner.nextLine().toUpperCase();
            if (!answer.equals("YES")) {
                playing = false;
            }
        }
        System.out.println("Thank you for playing!");
        return "GAME OVER";
    }

    private ArrayList<Integer> drawCard(ArrayList<Integer> hand) {
        Collections.shuffle(deck);
        hand.add(deck.remove(0));
        return hand;
    }

    private int sumHand(ArrayList<Integer> hand) {
        int sum = 0;
        for (int card : hand) {
            sum += card;
        }
        return sum;
    }

    private String determineWinner(ArrayList<Integer> playerHand, ArrayList<Integer> dealerHand) {
        int playerSum = sumHand(playerHand);
        int dealerSum = sumHand(dealerHand);

        if (playerSum > 21) {
            return "Busted! You lose!";
        } else if (dealerSum > 21 || playerSum > dealerSum) {
            return "Congratulations! You win!";
        } else if (playerSum < dealerSum) {
            return "Dealer wins!";
        } else {
            return "It's a tie!";
        }
    }
}