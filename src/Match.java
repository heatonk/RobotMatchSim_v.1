import java.util.ArrayList;

public class Match extends games.deepSpace {
    private Alliance red;
    private Alliance blue;
    private boolean redWin;
    private int redScore;
    private int blueScore;


    public Match(Alliance red, Alliance blue){
        this.red=red;
        this.blue=blue;
        int r = calcScore(red);
        this.redScore=r;
        int b = calcScore(blue);
        this.blueScore=b;
        this.redWin=r>b;
    }

    public int calcScore(Alliance team){
        int score=0;
        score+=sandstormScore(team.getLevelStart());
        score+=endScore(team.getLevelEnd());
        score+=panelScore(team.getPanels());
        score+=cargoScore(team.getCargo());

        return score;
    }
}
