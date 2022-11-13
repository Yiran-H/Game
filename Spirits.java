
public class Spirits extends Monster{
    //increased dodge ability
    public Spirits(String name, int level, double baseDamage, double defense, double dodgeAbility) {
        super(name, level, baseDamage, defense, dodgeAbility * 1.1);
    }
    public Spirits(String[] line) {
        super(line);
        this.setDodgeAbility(this.getDodgeAbility() * 1.1);
    }
}
