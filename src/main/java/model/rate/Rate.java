package model.rate;

public class Rate {

    private  float lastRate;
    private float sum;
    private float totalNbRate;

    public void addRating(int rate){
        sum+=rate;
        totalNbRate++;
        lastRate = rate;
    }

    public Rate() {
        this.lastRate = 0;
        this.sum = 0;
        this.totalNbRate = 0;
    }

    public float getRatings(){
        return sum/totalNbRate;
    }
}
