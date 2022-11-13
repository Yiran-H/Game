import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hero {
    private String name;
    private int level;
    private int experience;
    private double hp; //level * 100
    private double mp;
    private double strength;
    private double dexterity;
    private double agility;
    private int gold;
    private boolean isFaint;
    private List<Product> inventory;
    private Random rand = new Random();
    //is the hero equipped the weapon
    private boolean hasWeapon;
    //us the hero equipped the armor
    private boolean hasArmor;
    //keep updating the defence value of hero
    private double defence;

    public Hero(String name, double mp, double strength, double agility, double dexterity, int gold, int experience) {
        this.name = name;
        this.level = 2;
        this.hp = this.level * 100;
        this.experience = experience;
        this.mp = mp;
        this.strength = strength;
        this.dexterity = dexterity;
        this.agility = agility;
        this.gold = gold;
        this.isFaint = false;
        this.inventory = new ArrayList<>();
        this.hasArmor = false;
        this.hasWeapon = false;
        this.defence = 0;
    }

    public Hero(String[] line) {
        this.name = line[1];
        this.level = 2;
        this.hp = this.level * 100;
        this.experience = Integer.parseInt(line[7]);
        this.mp = Double.parseDouble(line[2]);
        this.strength = Double.parseDouble(line[3]);
        this.dexterity = Double.parseDouble(line[5]);
        this.agility = Double.parseDouble(line[4]);
        this.gold = Integer.parseInt(line[6]);
        this.isFaint = false;
        this.inventory = new ArrayList<>();
        this.hasArmor = false;
        this.hasWeapon = false;
        this.defence = 0;
    }
    //use weapon to attack the monster
    public double attack() {
        if (inventory.size() != 0) {
            for (Product p : inventory) {
                if (p.isWeapons() && p.isEquiped()) {
                    return (this.strength + p.getDamage()) * 0.05;
                }
            }
            System.out.println(C.RED + "You have no weapon or haven't equip it yet" + C.RESET);
        }
        return this.strength * 0.05;
    }
    // cast a spell and return which spell the hero has cast
    // the return spell is used for monster to decrease their certain attributes
    public Product castSpell() {
        if (inventory.size() == 0) {
            System.out.println("Nothing to cast");
            return null;
        }
        String name = Checker.getAnyKey();
        if (name.equals("q")) {
            return null;
        }
        Product p = isInInventory(name);
        while (p == null || !p.isSpell())  {
            System.out.println("Please choose the Spell in your inventory! or enter q to exit");
            name = Checker.getAnyKey();
            if (name.equals("q")) {
                return null;
            }
            p = isInInventory(name);
        }
        if (this.mp < p.getMpCost()) {
            System.out.println("Hero has not enough mp to cast the spell!");
            return null;
        } else {
            this.mp -= p.getMpCost();
            System.out.println(this.name + " has casted " + p.getName());
            inventory.remove(p);
            return p;
        }
    }
    //when there are some items that hero has been equipped, we will update
    // hero's defence value.
    // if there are no such item or hero has been equipped, the defence value should remain the same
    public void addDefence() {
        for (Product p : inventory) {
            if (p.isArmor() && p.isEquiped()) {
                this.defence += p.getDamage();
            }
        }
        this.defence += 0;
    }

    public double getDefence() {
        return defence;
    }

    //hero has been attacked by certain monster
    //if hero dodge return false, which means that there is no damage that hero get
    public boolean beAttacked(Monster m) {
        double defence = this.defence;
        if (rand.nextDouble() > this.agility * 0.001) {
            if (this.hp - m.getBaseDamage() + defence <= 0) {
                this.isFaint = true;
                this.hp = 0;
                System.out.println("\n" + this.name + " failed!\n");
            } else {
                this.hp = defence >= m.getBaseDamage() ? this.hp : this.hp - m.getBaseDamage() + defence;
            }
            return true;
        } else {
            System.out.println("\n" + this.name + " dodged monster's attack!\n");
            return false;
        }
    }
    //hero unequip a certain item
    public void unequip() {
        if (inventory.size() == 0) {
            System.out.println("Nothing to unequip");
            return;
        }
        String name = Checker.getAnyKey();
        if (name.equals("q")) {
            return;
        }
        Product p = isInInventory(name);
        while (p == null || !p.isArmor() && !p.isWeapons())  {
            System.out.println("Please choose the Weapon/Armor in your inventory! or enter q to exit");
            name = Checker.getAnyKey();
            if (name.equals("q")) {
                return;
            }
            p = isInInventory(name);
        }
        if (p.isEquiped()) {
            p.unEquiped();
            if (p.isWeapons()) {
                this.hasWeapon = false;
            } else {
                this.hasArmor = false;
                this.defence -= p.getDamage();
            }
            System.out.println(this.name + " has unequipped " + p.getName());
        } else {
            System.out.println("This item hasn't been equipped, choose another one: ");
        }
    }
    public void equip() {
        if (inventory.size() == 0) {
            System.out.println("Nothing to equip");
            return;
        }
        String name = Checker.getAnyKey();
        if (name.equals("q")) {
            return;
        }
        Product p = isInInventory(name);
        while (p == null || !p.isArmor() && !p.isWeapons())  {
            System.out.println("Please choose the Weapon/Armor in your inventory! or enter q to exit");
            name = Checker.getAnyKey();
            if (name.equals("q")) {
                return;
            }
            p = isInInventory(name);
        }
        p.Equiped();
        if (p.isWeapons()) {
            this.hasWeapon = true;
        } else {
            this.hasArmor = true;
            addDefence();
        }
        System.out.println(this.name + " has equipped " + p.getName());
    }
    public void usePotion() {
        if (inventory.size() == 0) {
            System.out.println("Nothing to use");
            return;
        }
        String name = Checker.getAnyKey();
        if (name.equals("q")) {
            return;
        }
        Product p = isInInventory(name);
        while (p == null || !p.isPotion())  {
            System.out.println("Please choose the Potion in your inventory! or enter q to exit");
            name = Checker.getAnyKey();
            if (name.equals("q")) {
                return;
            }
            p = isInInventory(name);
        }
        System.out.println(this.name + " has used Potion: " + p.getName());
        increaseAttribute(p);
        inventory.remove(p);
    }
    //after using potion
    private void increaseAttribute(Product p) {
        for (String s : p.getAttribute()) {
            switch (s) {
                case "Health":
                    this.hp += p.getDamage();
                    System.out.println(this.name + "'s Health has increased" + p.getDamage());
                    break;
                case "Mana":
                    this.mp += p.getDamage();
                    System.out.println(this.name + "'s Mana has increased" + p.getDamage());
                    break;
                case "Strength":
                    this.strength += p.getDamage();
                    System.out.println(this.name + "'s strength has increased" + p.getDamage());
                    break;
                case "Dexterity":
                    this.dexterity += p.getDamage();
                    System.out.println(this.name + "'s dexterity has increased" + p.getDamage());
                    break;
                case "Defense":
                    this.defence += p.getDamage();
                    System.out.println(this.name + "'s defence has increased" + p.getDamage());
                    break;
                case "Agility":
                    this.agility += p.getDamage();
                    System.out.println(this.name + "'s agility has increased" + p.getDamage());
                    break;
            }
        }
    }
    public void buyItem(Factory factory) {
        //check item name through input
        Product p = factory.produceItem();
        if (p == null) {
            return;
        }
        while (p.getPrice() > this.gold || p.getLevel() > this.level) {
            System.out.println("You don't have enough money or your level is to low to buy it. Please choose another one: or enter q to exit");
            p = factory.produceItem();
            if (p == null) {
                return;
            }
        }
        inventory.add(p);
        this.gold -= p.getPrice();
    }
    public void buySpell(Factory factory) {
        //check item name through input
        Product p = factory.produceSpell();
        if (p == null) {
            return;
        }
        while (p.getPrice() > this.gold || p.getLevel() > this.level) {
            System.out.println("You don't have enough money or your level is to low to buy it. Please choose another one: or enter q to exit");
            p = factory.produceSpell();
            if (p == null) {
                return;
            }
        }
        inventory.add(p);
        this.gold -= p.getPrice();
    }
    public void sell() {
        if (inventory.size() == 0) {
            System.out.println("Nothing to sell");
            return;
        }
        String name = Checker.getAnyKey();
        if (name.equals("q")) {
            return;
        }
        Product p = isInInventory(name);
        while (p == null) {
            System.out.println("Please choose the item in your inventory! or enter q to exit");
            name = Checker.getAnyKey();
            if (name.equals("q")) {
                return;
            }
            p = isInInventory(name);
        }
        inventory.remove(p);
        this.gold += p.getPrice() / 2;
    }
    private Product isInInventory(String name) {
        for (Product p : inventory) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }
    public void printInfo() {
        System.out.format(C.format7, this.name, this.mp, this.hp, this.strength, this.agility, this.dexterity, this.experience);
    }

    public void printGold() {
        System.out.println(this.name + "    " + this.gold + " $");
    }
    public void printItem() {
        System.out.println(C.PINK + this.name + C.RESET + C.YELLOW + " Items bought" + C.RESET);
        System.out.format(C.format5, "Type of Item", "Name", "Cost", "Unlock Level", "IsEquipped");
        System.out.println(C.Line);
        for (Product p : inventory) {
            p.printItem();
        }
    }

    //end of each round, after monster move
    public void regain() {
        if (!isFaint()) {
            this.mp = this.mp * 1.1;
            this.hp = this.hp * 1.1;
        }
    }
    public boolean isFaint() {
        if (this.hp == 0) {
//            System.out.println(C.RED + "hero " + this.name + " is defeated!" + C.RESET);
            this.isFaint = true;
            return true;
        } else {
            return false;
        }
    }
    public void afterRound(MonsterGroup mp) {
        //if hero win! gain gold and experience
        if(isFaint) {
            this.hp = this.level * 50; // still not sure
            this.mp = this.mp * 0.5;
        } else {
            this.gold += mp.getLevel() * 100;
            this.experience += mp.getNum() * 2;
            if (canLevelUp()) {
                levelUp();
            }
        }
    }
    public void levelUp() {
        if (canLevelUp()) {
            this.level += 1;
            this.hp = this.level * 100;
            this.mp = this.mp * 1.1;
            this.strength = this.strength * 1.05;
            this.dexterity = this.dexterity * 1.05;
            this.agility = this.agility * 1.05;
            System.out.println("\n" + this.name + " has been leveled up! Current level is: " + this.level + "\n");
        }
    }
    public boolean canLevelUp() {
        return this.experience >= this.level * 10;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public double getDexterity() {
        return dexterity;
    }

    public void setDexterity(double dexterity) {
        this.dexterity = dexterity;
    }

    public double getAgility() {
        return agility;
    }

    public void setAgility(double agility) {
        this.agility = agility;
    }

    public String getName() {
        return name;
    }

    public void setFaint(boolean faint) {
        isFaint = faint;
    }

    public boolean isHasWeapon() {
        return hasWeapon;
    }

    public boolean isHasArmor() {
        return hasArmor;
    }
}

