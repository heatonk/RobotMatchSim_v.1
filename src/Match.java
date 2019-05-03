public class Match {
    private Alliance red;
    private Alliance blue;
    private boolean redWin;
    private int redScore;
    private int blueScore;


    public Match(Alliance red, Alliance blue){
        this.red=red;
        this.blue=blue;
        int r = red.calcScore(red);
        this.redScore=r;
        int b = blue.calcScore(blue);
        this.blueScore=b;
        this.redWin=r>b;
    }

    public boolean isRedWin() {
        return redWin;
    }

    public int getRedScore() {
        return redScore;
    }

    public int getBlueScore() {
        return blueScore;
    }
}
