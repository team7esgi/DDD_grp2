package model.rate;

public class Rate {

    private float sum;

    private float totalNbRate;

    public void addRating(int rate){
        sum+=rate;
        totalNbRate++;
    }
    public float getRatings(){
        return sum/totalNbRate;
    }
}
