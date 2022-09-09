import java.util.ArrayList;

public class Hand <T extends Card>{

    private ArrayList<T> handCards = new ArrayList<T>();


    public int score(){
        int score =0;

        for(T card: handCards){
            score += card.value();
        }

        return  score;
    }


    public void addCard(T card){
        handCards.add(card);
    }
}
