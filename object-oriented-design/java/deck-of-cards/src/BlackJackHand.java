import java.util.ArrayList;
import java.util.Collections;

public class BlackJackHand extends Hand<BlackJackCard>{


    @Override
    public int score() {
        ArrayList<Integer> possibleScores = possibleScores();
        int maxUnder = Integer.MIN_VALUE;
        int minOver = Integer.MAX_VALUE;

        for (Integer score: possibleScores){
            if(score > 21 && score < minOver)
                minOver = score;
            else if (score <= 21 && score > maxUnder)
                maxUnder = score;
        }
        return maxUnder == Integer.MIN_VALUE ? minOver : maxUnder;
    }

    public boolean busted (){
        return score() > 21;
    }
    public boolean is21() {
        return  score() == 21;
    }

    public boolean isBlackJack(){
        // logic
        return false;
    }

    private ArrayList<Integer> possibleScores() {
        // calculate the possible scores
        return new ArrayList<>();
    }
}
