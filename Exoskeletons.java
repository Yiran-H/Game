
public class Exoskeletons extends Monster{
    //increased defense
    public Exoskeletons(String name, int level, double baseDamage, double defense, double dodgeAbility) {
        super(name, level, baseDamage, defense * 1.1, dodgeAbility);
    }
    public Exoskeletons(String[] line) {
        super(line);
        this.setDefense(this.getDefense() * 1.1);
    }
}
