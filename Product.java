import java.util.HashSet;
import java.util.Set;
/*
product has 4 subclasses that share the same attributes.
it represents all the items in the market.
 */
public class Product {
    private String name;
    private double price;
    private int level;

    public Product(String name, double price, int level) {
        this.name = name;
        this.price = price;
        this.level = level;
    }
    //construct by List of String
    public Product(String[] line) {
        this.name = line[1];
        this.price = Double.parseDouble(line[2]);
        this.level = Integer.parseInt(line[3]);
    }

    public void printItem() {
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    public boolean isWeapons() {
        return false;
    }
    public boolean isArmor() {
        return false;
    }
    public boolean isPotion() {
        return false;
    }
    public boolean isSpell() {
        return false;
    }
    public boolean isEquiped() {
        return false;
    }
    public void Equiped() {
    }
    public void unEquiped() {
    }
    public double getDamage() {
        return 0;
    }
    public Set<String> getAttribute() {
        return new HashSet<>();
    }
    public double getMpCost() {
        return 0;
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
}
