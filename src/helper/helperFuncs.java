package helper;

import java.util.Random;

public class helperFuncs {

    private static int diceRoll(int max){
        return (int)Math.ceil((Math.random()*max)+1);
    }

    public static int cycleCount(int max,boolean adv){
        return adv ? Math.max(diceRoll(max),diceRoll(max)) : Math.min(diceRoll(max),diceRoll(max));
    }

    private static final starting[] startLIST = starting.values();
    private static final int SIZE = startLIST.length;
    private static final Random RANDOM = new Random();
    public static starting startPicker(){
        return startLIST[RANDOM.nextInt(SIZE)];
    }

    private static final ending[]endLIST = ending.values();
    private static final int endSIZE = endLIST.length;
    public static ending endPicker(){
        return endLIST[RANDOM.nextInt(endSIZE)];
    }
}
