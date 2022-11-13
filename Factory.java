import java.util.Scanner;
/*factory can produce instance according to its unique name
to new any hero, monster, item or spell that player wants*/
public class Factory {
    private Scanner sc = new Scanner(System.in);
    public Product produceItem() {
        String name = sc.nextLine();
        if (name.equals("q")) {
            return null;
        }
        String[] line = Reader.getItemTarget(name);
        while (line == null) {
            System.out.println("Please enter the correct item's name!");
            line = Reader.getItemTarget(sc.nextLine());
        }
        if (line[0].equals("Weapons")) {
            return new Weapons(line);
        } else if (line[0].equals("Armor")) {
            return new Armor(line);
        }
        return new Potions(line);
    }
    public Product produceSpell() {
        String name = sc.nextLine();
        String[] line = Reader.getSpellTarget(name);
        while (line == null) {
            System.out.println("Please enter the correct spell's name!");
            line = Reader.getSpellTarget(sc.nextLine());
        }
        if (line[0].equals("IceSpell")) {
            return new IceSpell(line);
        } else if (line[0].equals("FireSpell")) {
            return new FireSpell(line);
        }
        return new LightningSpell(line);
    }
    public Hero produceHero() {
        String name = sc.nextLine();
        String[] line = Reader.getHeroTarget(name);
        while (line == null) {
            System.out.println("Please enter the correct hero's name!");
            line = Reader.getHeroTarget(sc.nextLine());
        }
        if (line[0].equals("Warriors")) {
            return new Warriors(line);
        } else if (line[0].equals("Sorcerers")) {
            return new Sorcerers(line);
        }
        return new Paladins(line);
    }
    public Monster produceMonster() {
        String[] line = Reader.getRandomMonster();
        if (line[0].equals("Exoskeletons")) {
            return new Exoskeletons(line);
        } else if (line[0].equals("Spirits")) {
            return new Spirits(line);
        }
        return new Dragons(line);
    }
}
