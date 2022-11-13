public class FireSpell extends Spells{
    public FireSpell(String name, double price, int level, double damage, double mpCost) {
        super(name, price, level, damage, mpCost);
    }
    public FireSpell(String[] line) {
        super(line);
    }
    @Override
    public boolean isFire() {
        return true;
    }
}
