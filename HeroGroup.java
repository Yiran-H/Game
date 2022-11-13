import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HeroGroup {
    private List<Hero> heroGroup;
    public HeroGroup() {
        heroGroup = new ArrayList<>();
    }
    public void addHero(Hero hero) {
        heroGroup.add(hero);
    }
    public int getSize() {
        return heroGroup.size();
    }

    public List<Hero> getHeroGroup() {
        return heroGroup;
    }
    public Hero getHeroByName() {
        String name = Checker.getAnyKey();
        if (name.equals("q")) {
            return null;
        }
        while (true) {
            for (Hero h : heroGroup) {
                if (h.getName().equals(name)) {
                    return h;
                }
            }
            System.out.println("Please enter the name in the heroGroup!");
            name = Checker.getAnyKey();
        }
    }
    public Hero getAvailableHero() {
        for (Hero h : heroGroup) {
            if (!h.isFaint()) {
                return h;
            }
        }
        return null;
    }
    public void printTroops() {
        System.out.println(C.YELLOW + "\nYour Team's Troops:" + C.RESET);
        System.out.format(C.format7, "Name", "Magic Power", "Health Power", "Strength", "Agility", "Dexterity", "Experience");
        System.out.println(C.Line);
        for (Hero h : heroGroup) {
            h.printInfo();
        }
    }
    public void printGold() {
        System.out.println(C.YELLOW + "Your Team Members:" + C.RESET);
        System.out.println("--------------------------------");
        System.out.println("Name                " + "Money");
        for (Hero h : heroGroup) {
            h.printGold();
        }
    }
    public void printInventory() {
        System.out.println(C.YELLOW + "\nYour Team Members’ Inventory:" + C.RESET);
        System.out.println("--------------------------------");
        for (Hero h : heroGroup) {
            h.printItem();
            System.out.println("--------------------------------");
        }
    }
    public boolean hasAllFaint() {
        for (Hero h : heroGroup) {
            if (!h.isFaint()) {
                return false;
            }
        }
        return true;
    }
}
