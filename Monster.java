import java.util.Random;

public class Monster {
    private final String name;
    private final int level;
    private double hp; //level * 100
    private double baseDamage;
    private double defense;
    private double dodgeAbility;
    private boolean isFaint = false;
    private Random rand = new Random();
    public Monster(String name, int level, double baseDamage, double defense, double dodgeAbility) {
        this.name = name;
        this.level = level;
        this.hp = this.level * 100;
        this.baseDamage = baseDamage;
        this.defense = defense;
        this.dodgeAbility = dodgeAbility;
    }
    public Monster(String[] line) {
        this.name = line[1];
        this.level = Integer.parseInt(line[2]);
        this.hp = this.level * 100;
        this.baseDamage = Double.parseDouble(line[3]);
        this.defense = Double.parseDouble(line[4]);
        this.dodgeAbility = Double.parseDouble(line[5]);
    }
    public void printInfo() {
        System.out.format(C.format5, this.name, this.hp, this.baseDamage, this.defense, this.dodgeAbility);
    }
    public boolean isFaint() {
        return this.isFaint;
    }

    public int getLevel() {
        return level;
    }
    //hero is attacked by certain damage produced by hero
    public boolean beAttacked(double damage) {
        if (rand.nextDouble() > this.dodgeAbility * 0.01) {
            if (this.hp - damage + this.defense <= 0) {
                this.isFaint = true;
                this.hp = 0;
                System.out.println("\n" + this.name + " failed!\n");
            } else {
                this.hp = damage <= this.defense ? this.hp : this.hp - damage + this.defense;
            }
            return true;
        } else {
            System.out.println("\n" + this.name + " dodged hero's attack!\n");
            return false;
        }
    }

    //reduce attribute by spell
    public void redAttribute(Product s) {
        if (s.isIce()) {
            this.baseDamage = this.baseDamage * 0.9;
            System.out.println("Monster " + this.name + "'s base damage has been decreased by " + this.baseDamage * 0.1);
        }
        if (s.isFire()) {
            this.defense = this.defense * 0.9 ;
            System.out.println("Monster " + this.name + "'s defense has been decreased by " + this.defense * 0.1);
        }
        if (s.isLight()) {
            this.dodgeAbility = this.dodgeAbility * 0.9 ;
            System.out.println("Monster " + this.name + "'s dodgeAbility has been decreased by " + this.dodgeAbility * 0.1);
        }
    }

    public double getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(double baseDamage) {
        this.baseDamage = baseDamage;
    }

    public double getDefense() {
        return defense;
    }

    public void setDefense(double defense) {
        this.defense = defense;
    }

    public double getDodgeAbility() {
        return dodgeAbility;
    }

    public void setDodgeAbility(double dodgeAbility) {
        this.dodgeAbility = dodgeAbility;
    }

    public String getName() {
        return name;
    }
}
