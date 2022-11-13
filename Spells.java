/*
spells has 3 subclasses and in this super class, there has some state-checking
function to automatically decide which type of spell it is
 */
public class Spells extends Product{
    private final double damage;
    private final double mpCost;
    public Spells(String name, double price, int level, double damage, double mpCost) {
        super(name, price, level);
        this.damage = damage;
        this.mpCost = mpCost;
    }
    public Spells(String[] line) {
        super(line);
        this.damage = Double.parseDouble(line[4]);
        this.mpCost = Double.parseDouble(line[5]);
    }
    public void output() {
        System.out.format(C.format5, "Name", "Cost", "Unlock Level", "Damage", "Minimum Magic Power");
        System.out.println(C.Line);
        System.out.format(C.format5, this.getName(), (int)this.getMpCost(), this.getLevel(), this.damage, this.mpCost);
    }
    @Override
    public void printItem() {
        System.out.format(C.format5, "Spell", this.getName(), this.getPrice(), this.getLevel(), "NA");
    }

    public boolean isIce() {
        return false;
    }

    public boolean isFire() {
        return false;
    }

    public boolean isLight() {
        return false;
    }
    @Override
    public double getDamage() {
        return damage;
    }

    @Override
    public double getMpCost() {
        return mpCost;
    }
    @Override
    public boolean isSpell() {
        return true;
    }
}
