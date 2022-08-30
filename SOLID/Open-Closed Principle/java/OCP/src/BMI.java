public class BMI {

    public int calculatedMaleBMI(Human m){
        return m.getHeight()/m.getWeight();
    }

    // assume that for a female you calculate the BMI
    // in a different way
    public int calculatedFemaleBMI(Human f){
        return f.getHeight()-5/f.getWeight();
    }
}
