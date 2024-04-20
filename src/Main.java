import java.util.*;

public class Main {
    public static void main(String[] args) {

        //THE BLACKJACK IS GOING TO BE 1V1 FOR NOW




        ArrayList<Integer> deck = new ArrayList<>();
        addToDeck(deck,1);
        addToDeck(deck,2);
        addToDeck(deck,3);
        addToDeck(deck,4);
        addToDeck(deck,5);
        addToDeck(deck,6);
        addToDeck(deck,7);
        addToDeck(deck,8);
        addToDeck(deck,9);
        addToDeck(deck,10);

        addToDeck(deck,1);
        addToDeck(deck,2);
        addToDeck(deck,3);
        addToDeck(deck,4);
        addToDeck(deck,5);
        addToDeck(deck,6);
        addToDeck(deck,7);
        addToDeck(deck,8);
        addToDeck(deck,9);
        addToDeck(deck,10);

        addToDeck(deck,1);
        addToDeck(deck,2);
        addToDeck(deck,3);
        addToDeck(deck,4);
        addToDeck(deck,5);
        addToDeck(deck,6);
        addToDeck(deck,7);
        addToDeck(deck,8);
        addToDeck(deck,9);
        addToDeck(deck,10);

        addToDeck(deck,1);
        addToDeck(deck,2);
        addToDeck(deck,3);
        addToDeck(deck,4);
        addToDeck(deck,5);
        addToDeck(deck,6);
        addToDeck(deck,7);
        addToDeck(deck,8);
        addToDeck(deck,9);
        addToDeck(deck,10);

        addToDeck(deck,10);
        addToDeck(deck,10);
        addToDeck(deck,10);
        addToDeck(deck,10);
        addToDeck(deck,10);
        addToDeck(deck,10);
        addToDeck(deck,10);
        addToDeck(deck,10);
        addToDeck(deck,10);
        addToDeck(deck,10); 
        addToDeck(deck,10);
        addToDeck(deck,10);

        Game game=new Game("Nikolas",deck);
        game.partida();


    }
    private static void addToDeck(ArrayList<Integer> deck, int number) {
        deck.add(number);
    }
}