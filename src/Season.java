import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Season {

    public static void main(String args[]){

        Connection conn;
        Statement statement=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/frc_sim_data?autoReconnect=true&useSSL=false","root","uYamw4pYW3JpRg8");
            statement = conn.createStatement();


        }catch (Exception e){
            e.printStackTrace();
        }
        int numTeams = 10000;
        ArrayList<Integer> teams = teamNumberGenerator(numTeams);

        ArrayList<Robot> robots = new ArrayList<>();
        for (int i = 0; i < numTeams; i++) {
            robots.add(new Robot(getNum(teams),12));
        }

        ArrayList<Event> events = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            events.add(new Event(getAttending(robots,400),10000));
        }

        ArrayList<Integer> maxs = new ArrayList<>();
        ArrayList<Integer> mins = new ArrayList<>();
        ArrayList<Integer> avgs = new ArrayList<>();
        for (int i = 0; i < events.size(); i++) {
            int[] temp = events.get(i).generateReport(statement);
            maxs.add(temp[0]);
            mins.add(temp[1]);
            avgs.add(temp[2]);
            maxs.sort((o1, o2) -> o1>o2 ? -1 : 1);
            mins.sort((o1, o2) -> o1>o2 ? 1 : -1);
//            avgs.sort((o1, o2) -> o1>o2 ? -1 : 1);
            System.out.println("Overall max: "+maxs.get(0));
            System.out.println("Overall min: "+mins.get(0));
//            System.out.println("Overall avg: "+avgs.get(0));
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
