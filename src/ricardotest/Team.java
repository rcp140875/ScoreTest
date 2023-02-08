package ricardotest;

class Team implements Comparable {
    String name;
    int points;

    public Team(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public int compareTo(Object o) {
        Team team = (Team) o;

        if (this.points > team.getPoints()) {
            return -1;
        }

        if (this.points < team.getPoints()) {
            return 1;
        }

        if (this.points == team.getPoints()) {
            if (this.name.compareTo(team.getName()) < -1) {
                return -1;
            }

            if (this.name.compareTo(team.getName()) > 1) {
                return 1;
            }
        }
        return 0;
    }
}
