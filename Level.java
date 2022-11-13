public class Level {
    private int level;
    private int points;

    public Level(int level, int points) {
        this.level = level;
        this.points = points;
    }

    public HP levelUp() {
        this.level++;
        return new HP(level * 100);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
