import java.util.ArrayList;
import java.util.Random;
import java.sql.*;

public class Event {
    int numMatches;
    ArrayList<Robot> teams;
    ArrayList<Match> matches;

    public Event(ArrayList<Robot> teams,int numMatches){
        this.numMatches = numMatches;
        this.teams = teams;
        this.matches=runMatchMaker(teams,numMatches);
    }

    public static ArrayList<Match> runMatchMaker(ArrayList<Robot> teams, int numMatches){
        ArrayList<Match> matches = new ArrayList<>();
        for (int i = 0; i < numMatches; i++) {
            matches.add(new Match(new Alliance(pickThree(teams)),new Alliance(pickThree(teams))));
        }
        return matches;
    }

    public static ArrayList<Robot> pickThree(ArrayList<Robot> teams){
        Random random = new Random();
        ArrayList<Robot> ret = new ArrayList<>();
        ret.add(teams.get(random.nextInt(teams.size())));
        ret.add(teams.get(random.nextInt(teams.size())));
        ret.add(teams.get(random.nextInt(teams.size())));
        return ret;
    }

    public int[] generateReport(Statement statement){
        if(statement==null){
            return null;
        }
        int[] ret = new int[3];
        int total=0;
        int maxScore=-1;
        int minScore=1000;
        ArrayList<Integer> scores = new ArrayList<>();
        for(Match match : this.matches){
            int blue = match.getBlueScore();
            int red = match.getRedScore();
            total=blue+total;
            if(blue>maxScore){
                maxScore=blue;
            }
            if(blue<minScore){
                minScore=blue;
            }
            scores.add(blue);
            total=red+total;
            if(red>maxScore){
                maxScore=red;
            }
            if(red<minScore){
                minScore=red;
            }
            scores.add(red);
            try{
                statement.executeUpdate("insert into scores values ("+red+","+blue+")");
            }catch(Exception e){e.printStackTrace();}

        }

        System.out.println("Max: "+maxScore);
        ret[0]=maxScore;
        System.out.println("Min: "+minScore);
        ret[1]=minScore;
        ret[2]=total/(this.matches.size()*2);
        return ret;
    }
}
