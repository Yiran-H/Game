public class IceSpell extends Spells{
    public IceSpell(String name, double price, int level, double damage, double mpCost) {
        super(name, price, level, damage, mpCost);
    }
    public IceSpell(String[] line) {
        super(line);
    }
    @Override
    public boolean isIce() {
        return true;
    }
}
