/*weapon can be equipped and be unequipped
*/
public class Weapons extends Product{
    private final double damage;
    private final int hands;
    private boolean isEquiped;
    public Weapons(String name, double price, int level, double damage, int hands) {
        super(name, price, level);
        this.damage = damage;
        this.hands = hands;
        this.isEquiped = false;
    }
    public Weapons(String[] line) {
        super(line);
        this.damage = Double.parseDouble(line[4]);
        this.hands = Integer.parseInt(line[5]);
        this.isEquiped = false;
    }
    @Override
    public void printItem() {
        System.out.format(C.format5, "Weapon", this.getName(), this.getPrice(), this.getLevel(), this.isEquiped);
    }
    public boolean canEquip() {
        return true;
    }
    @Override
    public double getDamage() {
        return damage;
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
    public boolean isWeapons() {
        return true;
    }
}
