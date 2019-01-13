import java.util.ArrayList;
import java.util.Random;

public class Season {

    public static void main(String args[]){
        int numTeams = 10000;
        ArrayList<Integer> teams = teamNumberGenerator(numTeams);

        ArrayList<Robot> robots = new ArrayList<>();
        for (int i = 0; i < numTeams; i++) {
            robots.add(new Robot(getNum(teams),12));
        }

        ArrayList<Event> events = new ArrayList<>();
        for (int i = 0; i < 250; i++) {
            events.add(new Event(getAttending(robots,40),10));
        }

        System.out.println();
    }//end of main

    private static ArrayList<Integer> teamNumberGenerator(int max){
        ArrayList<Integer> num = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            num.add(i);
        }
        return num;
    }

    private static int getNum(ArrayList<Integer> nums){
        Random rand = new Random();

        return nums.remove(rand.nextInt(nums.size()));
    }

    private static ArrayList<Robot> getAttending(ArrayList<Robot> robots,int eventSize){
        Random rand = new Random();
        ArrayList<Robot> attending = new ArrayList<>();
        for (int i = 0; i < eventSize; i++) {
            attending.add(robots.remove(rand.nextInt(robots.size())));
        }
        return attending;
    }
}
