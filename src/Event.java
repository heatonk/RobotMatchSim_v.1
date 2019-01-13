import java.util.ArrayList;
import java.util.Random;

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
}
