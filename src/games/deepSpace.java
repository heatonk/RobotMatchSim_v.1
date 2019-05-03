package games;

public class deepSpace {
    int maxPanels = 14;
    int maxCargo = 20;
    int rpWin = 2;
    int rplose = 0;
    int rpTie =1;

    public static int sandstormScore(int[] start){
      return 3*start[1]+6*start[2];
    }

    public static int panelScore(int panels){
        return 2*panels;
    }

    public static int cargoScore(int cargo){
        return 3*cargo;
    }

    public static int endScore(int[] level){
        return 3*level[1]+6*level[2]+12*level[3];
    }
}
