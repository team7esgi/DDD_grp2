package model.rate;

public class Rate {

    private float sum;

    private float totalNbRate;

    public void addRating(int rate){
        sum+=rate;
        totalNbRate++;
    }

    public Rate() {
        this.sum = 0;
        this.totalNbRate = 0;
    }

    public float getRatings(){
        return sum/totalNbRate;
    }
}
