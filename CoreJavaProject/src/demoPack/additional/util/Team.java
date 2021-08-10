package demoPack.additional.util;

import java.util.*;

public class Team 
{
    private String name;
    private Set<Player> players;

    public Team(){}

    public Team(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Set<Player> getPlayers() {
        return players;
    }
    public void setPlayers(Set<Player> players) {
        this.players = players;
    }    

    @Override
    public String toString()
    {
        return "[Name = " + name + ", Players = " + playersAsString(players) + "]";
    }

    private String playersAsString(Collection<? extends Object> collection)
    {
        if(collection == null || collection.isEmpty())
        {
            return "";
        }

        StringBuilder result = new StringBuilder();

        Iterator<? extends Object> iterator = collection.iterator();        
        
        result.append("[");

        while (iterator.hasNext())
        {
            String name = ((Player)iterator.next()).getName();            
            result.append("{" + name + "}");
        }        
        
        result.append("]");
        
        return result.toString();
    }    
}