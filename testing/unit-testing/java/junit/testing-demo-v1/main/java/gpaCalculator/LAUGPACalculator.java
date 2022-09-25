package gpaCalculator;

public class LAUGPACalculator implements IGPACalculator {


    @Override
    public Character calculate(int grade) {
        if(grade < 0)
            throw new IllegalArgumentException("negative value received");
        else if( grade < 60)
            return 'F';
        else if (grade < 70)
            return 'D';
        else if (grade < 80)
            return 'C';
        else if (grade < 90)
            return 'B';
        else if (grade < 100)
            return 'A';
        else
            throw new IllegalArgumentException("Value is invalid");
    }
}
