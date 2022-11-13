import java.util.List;

public class Dragons extends Monster{
    //increased base damage
    public Dragons(String name, int level, double baseDamage, double defense, double dodgeAbility) {
        super(name, level, baseDamage * 1.1, defense, dodgeAbility);
    }
    public Dragons(String[] line) {
        super(line);
        this.setBaseDamage(this.getBaseDamage() * 1.1);
    }
}
