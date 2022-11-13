public class Armor extends Product{
    private final double damageRed;
    private boolean isEquiped;
    public Armor(String name, double price, int level, double damageRed) {
        super(name, price, level);
        this.damageRed = damageRed;
        this.isEquiped = false;
    }
    public Armor(String[] line) {
        super(line);
        this.damageRed = Double.parseDouble(line[4]);
        this.isEquiped = false;
    }
    @Override
    public void printItem() {
        System.out.format(C.format5, "Armor", this.getName(), this.getPrice(), this.getLevel(), this.isEquiped);
    }
    @Override
    public double getDamage() {
        return damageRed;
    }
    @Override
    public boolean isEquiped() {
        return this.isEquiped;
    }
    @Override
    public void Equiped() {
        this.isEquiped = true;
    }
    @Override
    public void unEquiped() {
        this.isEquiped = false;
    }
    @Override
    public boolean isArmor() {
        return true;
    }
}
