import java.util.ArrayList;

import static games.deepSpace.*;

public class Alliance {
    private ArrayList<Robot> team;
    private int cycles;
    private int[] levelStart;
    private int cargo;
    private int panels;
    private int[] levelEnd;

    public Alliance(ArrayList<Robot> team){
        this.team = team;
        this.cycles=getCycles(team);
        this.cargo = getCargo(team);
        this.panels = getPanels(team);
        this.levelStart = getStart(team);
        this.levelEnd = getEnd(team);
    }

    public int calcScore(Alliance team){
        int score=0;
        score+= sandstormScore(team.getLevelStart());
        score+= endScore(team.getLevelEnd());
        score+= panelScore(team.getPanels());
        score+= cargoScore(team.getCargo());

        return score;
    }

    public static int getCycles(ArrayList<Robot> team){
        int ret=0;
        for(Robot r : team){
            ret+=r.getCycles();
        }
        return ret;
    }

    public static int getCargo(ArrayList<Robot> team){
        int ret=0;
        for(Robot r : team){
            ret+=r.getCargoCycles();
        }
        return ret;
    }

    public static int getPanels(ArrayList<Robot> team){
        int ret=0;
        for(Robot r : team){
            ret+=r.getPanelCycles();
        }
        return ret;
    }

    public static int[] getStart(ArrayList<Robot> team){
        int[] ret = {0,0,0};
        for(Robot r : team){
            switch (r.getStart()){
                case LEVEL0:{ret[0]++;break;}
                case LEVEL1:{ret[1]++;break;}
                case LEVEL2:{ret[2]++;break;}
            }
        }
        return ret;
    }

    public static int[] getEnd(ArrayList<Robot> team){
        int[] ret = {0,0,0,0};
        for(Robot r : team){
            switch (r.getEnd()){
                case LEVEL0:{ret[0]++;break;}
                case LEVEL1:{ret[1]++;break;}
                case LEVEL2:{ret[2]++;break;}
                case LEVEL3:{ret[3]++;break;}
            }
        }
        return ret;
    }

    public ArrayList<Robot> getTeam() {
        return team;
    }

    public void setTeam(ArrayList<Robot> team) {
        this.team = team;
    }

    public int getCycles() {
        return cycles;
    }

    public void setCycles(int cycles) {
        this.cycles = cycles;
    }

    public int[] getLevelStart() {
        return levelStart;
    }

    public void setLevelStart(int[] levelStart) {
        this.levelStart = levelStart;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    public int getPanels() {
        return panels;
    }

    public void setPanels(int panels) {
        this.panels = panels;
    }

    public int[] getLevelEnd() {
        return levelEnd;
    }

    public void setLevelEnd(int[] levelEnd) {
        this.levelEnd = levelEnd;
    }
}
