package demoPack.additional.util;

import java.util.*;

public class Player 
{
    private String name;
    private Team team;
    private Map<Team, Integer> runsScored;

    public Player(){}    

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Team getTeam() {
        return team;
    }
    public void setTeam(Team team) {
        this.team = team;
    }

    public Map<Team, Integer> getRunsScored(){
        return runsScored;
    }
    public void setRunsScored(Map<Team, Integer> runsScored){
        this.runsScored = runsScored;
    }

    @Override
    public String toString(){        
        return "[Name = "+ getName() +" , Team Name = "+ getTeam().getName() +", RunsScored = "+ runsScoredAsString() +"]";
    }

    private String runsScoredAsString()
    {
        if (runsScored == null || runsScored.isEmpty()){
            return "";
        }   
        StringBuilder result = new StringBuilder();
        result.append("[");
    
        Iterator<Map.Entry<Team, Integer>> iterator = runsScored.entrySet().iterator();

        while(iterator.hasNext())
        {
            Map.Entry<Team, Integer> entry = iterator.next();
            result.append("{" + entry.getKey().getName() + "," + entry.getValue() + "}");
        }
        result.append("]");

        return result.toString();
    }
}