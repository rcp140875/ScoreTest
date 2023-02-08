package ricardotest;

import java.util.*;

public class TeamScores {
    Map<String, Integer> teamScoresMap = new HashMap<String, Integer>();
    List<Team> teams = new ArrayList<Team>();

    public void addScore(String team1, int scoreTeam1, String team2, int scoreTeam2) {
        int pointsToAddTeam1 = 0;
        int pointsToAddTeam2 = 0;

        if (scoreTeam1 > scoreTeam2) {
            pointsToAddTeam1 = 3;
            pointsToAddTeam2 = 0;
        }
        if (scoreTeam1 < scoreTeam2) {
            pointsToAddTeam1 = 0;
            pointsToAddTeam2 = 3;
        }
        if (scoreTeam1 == scoreTeam2) {
            pointsToAddTeam1 = 1;
            pointsToAddTeam2 = 1;
        }

        if (teamScoresMap.get(team1) == null) {
            teamScoresMap.put(team1, new Integer(pointsToAddTeam1));
        } else {
            int previousPointsTeam1 = teamScoresMap.get(team1).intValue();
            teamScoresMap.put(team1, new Integer(previousPointsTeam1 + pointsToAddTeam1));
        }

        if (teamScoresMap.get(team2) == null) {
            teamScoresMap.put(team2, new Integer(pointsToAddTeam2));
        } else {
            int previousPointsTeam2 = teamScoresMap.get(team2).intValue();
            teamScoresMap.put(team2, new Integer(previousPointsTeam2 + pointsToAddTeam2));
        }
    }
    public List<Team> getsTeams() {
        teams.clear();
        for (Map.Entry<String, Integer> teamScore : teamScoresMap.entrySet()) {
            //System.out.println(teamScore.getKey() + ": " + teamScore.getValue());
            teams.add(new Team(teamScore.getKey(), teamScore.getValue().intValue()));
        }
        Collections.sort(teams);
        return teams;
    }
    public void print() {
        for (Team team : getsTeams()) {
            System.out.println(team.getName() + ", " + team.getPoints() + (team.getPoints() > 1 ? " pts" : " pt"));
        }
    }
}
