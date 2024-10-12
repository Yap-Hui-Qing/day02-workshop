package cards;

//public class Cards extends Object {}
public class Cards {

    // members 
    private final String name;
    private final String suit;
    private final int value;

    // constructor
    // You cannot create a blank card
    public Cards(String suit, String name, int value){
        this.name = name;
        this.suit = suit;
        this.value = value;
    }

    // cannot change the value of the card -- no setters
    public String getName(){return name;}
    public String getSuit(){return suit;}
    public int getValue(){return value;}

    @Override
    public String toString(){
        return "Card(suit: %s, name: %s, value: %d)".formatted(suit, name, value);
    }


}
