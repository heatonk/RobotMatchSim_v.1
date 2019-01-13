import helper.helperFuncs;
import helper.*;

public class Robot{
    private int teamNum;
    private int cycles;
    private int panelCycles;
    private int cargoCycles;
    private helper.starting start;
    private helper.ending end;
    private int rp;

    public Robot(int teamNum,int max){
        this.teamNum=teamNum;
        this.cycles = helperFuncs.cycleCount(max,false);
        this.start=helperFuncs.startPicker();
        this.end = helperFuncs.endPicker();
        this.panelCycles = 0;
        this.cargoCycles = 0;
        this.rp = 0;
    }

    public int getTeamNum() {
        return teamNum;
    }

    public void setTeamNum(int teamNum) {
        this.teamNum = teamNum;
    }

    public int getCycles() {
        return cycles;
    }

    public void setCycles(int cycles) {
        this.cycles = cycles;
    }

    public int getCargoCycles() {
        return cargoCycles;
    }

    public void setCargoCycles(int cargoCycles) {
        this.cargoCycles = cargoCycles;
    }

    public int getPanelCycles() {
        return panelCycles;
    }

    public void setPanelCycles(int panelCycles) {
        this.panelCycles = panelCycles;
    }

    public starting getStart() {
        return start;
    }

    public void setStart(starting start) {
        this.start = start;
    }

    public ending getEnd() {
        return end;
    }

    public void setEnd(ending end) {
        this.end = end;
    }

    public int getRp() {
        return rp;
    }

    public void addRp(int rp) {
        this.rp += rp;
    }

}
