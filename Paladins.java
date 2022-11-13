import java.util.List;

public class Paladins extends Hero{
    //strength and dexterity
    public Paladins(String name, double mp, double strength, double agility, double dexterity, int gold, int experience) {
        super(name, mp, strength, agility, dexterity, gold, experience);
    }
    public Paladins(String[] line) {
        super(line);
    }
    @Override
    public void levelUp() {
        super.levelUp();
        if (canLevelUp()) {
            this.setDexterity(this.getDexterity() * 1.05);
            this.setStrength(this.getStrength() * 1.05);
            System.out.println(C.GREEN + "hero " + this.getName() + " has been leveled up!" + C.RESET);
        }
    }
}
