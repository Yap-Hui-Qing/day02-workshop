package cards;


public class Main {
    
    public static void main(String[] args) {

        // using array
        Deck deck = new Deck();
        Cards card = deck.get(5);
        System.out.printf("suit: %s, name: %s, value: %d\n",
        card.getSuit(), card.getName(), card.getValue());

        // shuffled deck
        Deck shuffledDeck = deck.Shuffle();
        Cards shuffledCard = shuffledDeck.get(5);


        System.out.println(card);
        System.out.println(shuffledCard);
        System.out.println(deck);

        System.out.println("\n");

        // with list
        Deckv2 deck1 = new Deckv2();
        Cards card1 = deck1.get(5);
        System.out.printf("suit: %s, name: %s, value: %d\n",
        card1.getSuit(), card1.getName(), card1.getValue());

        // shuffled deck
        Deckv2 shuffledDeck1 = deck1.Shuffle();
        Cards shuffledCard1 = shuffledDeck1.get(5);


        System.out.println(card1);
        System.out.println(shuffledCard1);
        System.out.println(deck1);

    }
}
