public class LightningSpell extends Spells{
    public LightningSpell(String name, double price, int level, double damage, double mpCost) {
        super(name, price, level, damage, mpCost);
    }
    public LightningSpell(String[] line) {
        super(line);
    }
    @Override
    public boolean isLight() {
        return true;
    }
}
