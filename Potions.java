import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Potions extends Product {
    private final double effectInc;
    private final Set<String> attribute;
    public Potions(String name, double price, int level, double effectInc, String s) {
        super(name, price, level);
        this.effectInc = effectInc;
        String[] ss = s.split("/", 0);
        attribute = new HashSet<>();
        attribute.addAll(Arrays.asList(ss));
    }
    public Potions(String[] line) {
        super(line);
        this.effectInc = Double.parseDouble(line[4]);
        String[] ss = line[5].split("/", 0);
        attribute = new HashSet<>();
        attribute.addAll(Arrays.asList(ss));
    }
    @Override
    public void printItem() {
        System.out.format(C.format5, "Potion", this.getName(), this.getPrice(), this.getLevel(), "NA");
    }
    @Override
    public double getDamage() {
        return effectInc;
    }
    @Override
    public Set<String> getAttribute() {
        return attribute;
    }
    @Override
    public boolean isPotion() {
        return true;
    }
}