package helper;

import java.util.Random;

public class helperFuncs {

    private static int diceRoll(int upperLim){
        return (int)Math.ceil((Math.random()*upperLim)+1);
    }

    public static int cycleCount(int upperLim,boolean adv){
        return adv ? Math.max(diceRoll(upperLim),diceRoll(upperLim)) : Math.min(diceRoll(upperLim),diceRoll(upperLim));
    }

    public static int cycleDivision(int cycles){
        int random = new Random().nextInt(cycles);
        return Math.max(cycles-random,random);
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
