package cards;

import java.security.SecureRandom;
import java.util.Random;
import java.util.LinkedList;
import java.util.List;

// use a list to store deck of cards instead

public class Deckv2{

    public static final String[] SUIT = {
        "Diamond", "Spade", "Hearts", "Clubs"
    };

    public static final String[] NAMES = {
        "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "King", "Queen"
    };

    public static final int[] VALUES = {
        1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13
    };

    // convert deck of cards to use List
    protected List<Cards> cardsList = new LinkedList<>();

    public Deckv2(){
        for (int s = 0; s < SUIT.length; s+=1){
            String suit = SUIT[s];
            for (int n = 0; n < NAMES.length; n+=1){
                String name = NAMES[n];
                int value = VALUES[n];
                Cards card = new Cards(suit, name, value);
                cardsList.add(card);
            }
        }
    }

    public Deckv2 Shuffle(){
        Deckv2 deck = new Deckv2();
        Deckv2 shuffledDeck = new Deckv2();

        Random rand = new SecureRandom();

        for (int i = 0; i < cardsList.size(); i += 1){
            int r = i + rand.nextInt(52-i);
            Cards temp = deck.get(r);
            shuffledDeck.set(i, temp);
        }
        return shuffledDeck;
    }

    public Cards get(int pos){
        return this.cardsList.get(pos);
    }

    public void set(int pos, Cards card){
        this.cardsList.set(pos, card);
    }

    @Override
    public String toString(){
        return "Number of cards: %d".formatted(cardsList.size());
    }


}