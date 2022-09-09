import java.util.ArrayList;
import java.util.Collections;

public class Deck <T extends Card>{

    ArrayList<Card> cards;
    private int dealIndex = 0;


    public void shuffle(){
        Collections.shuffle(cards);
    }


}
