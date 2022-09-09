public abstract class Card {

    private boolean available = true;

    protected int faceValue;
    protected Suit suit;

    public Card(int faceValue, Suit suit) {
        this.faceValue = faceValue;
        this.suit = suit;
    }

    public abstract int value();


    public Suit getSuit() {
        return suit;
    }

    public boolean isAvailable() {
        return available;
    }

    public void makeAvailable(){
        available = true;
    }

    public void makeUnavailable(){
        available = false;
    }
}
