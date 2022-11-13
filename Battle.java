import java.time.chrono.ChronoLocalDate;
import java.util.List;
import java.util.Random;

public class Battle {
    private HeroGroup heroGroup;
    private MonsterGroup monsterGroup;
    public Battle(HeroGroup h) {
        heroGroup = h;
    }
    public void equip(Hero h) {
        if (h != null) {
            do {
                if (h.isHasArmor() || h.isHasWeapon()) {
                    do{
                        if (!h.isHasArmor() && !h.isHasWeapon()) {
                            System.out.println("Nothing to uneqiup");
                            break;
                        }
                        System.out.println("\nHero has already equipped armor or weapon, do you want them unequipped? ");
                        if (Checker.yesOrNo()) {
                            System.out.println("\nEnter the name of the Weapon/Armor you want to unequip: or enter q to exit");
                            h.unequip();
                        } else {
                            break;
                        }
                        System.out.println("Do you want to unequip another Weapon/Armor?");
                    } while(Checker.yesOrNo());
                }
                System.out.println("\nEnter the name of the Weapon/Armor you want to equip: or enter q to exit");
                h.equip();
                System.out.println("Do you want to equip another Weapon/Armor?");
            } while(Checker.yesOrNo());
        }
    }
    public void attack(Hero h, Monster m) {
        if (h != null && m != null) {
            System.out.println(C.GREEN + h.getName() + C.RESET + " is attacking " + m.getName() + "\n");
            System.out.println("The " + C.GREEN + m.getName() + C.RESET + " is fighting back!\n");
            /*hero turn*/
            double damage = h.attack();
            helper(m, h, damage);
            if (!h.isFaint()) {
                h.regain();
            }
        }
    }
    public void cast(Hero h, Monster m) {
        if (h != null && m != null) {
            //deduct mp
            //calculate magic attack to monster
            System.out.println("\nEnter the name of the spell you want to cast: or enter q to exit");
            Product s = h.castSpell();
            double spellDamage = 0;
            //deduct monster's attribute
            if (s != null) {
                m.redAttribute(s);
                spellDamage = s.getDamage() + (h.getDexterity() / 10000) * s.getDamage();
            }
            helper(m, h, spellDamage);
            if (!h.isFaint()) {
                h.regain();
            }
        }
    }
    private void helper(Monster m, Hero h, double damage) {
        if (m.beAttacked(damage)) {
            System.out.println("\nHero " + h.getName() + " attacked the " + m.getName() + " for " + damage + " damage!");
            System.out.println("Monster " + m.getName() + " defence for " + m.getDefense() + "\n");
        }
        //monster fight back
        if (!m.isFaint()) {
            if (h.beAttacked(m)) {
                System.out.println("\nMonster " + m.getName() + " attacked the " + h.getName() + " for " + m.getBaseDamage() + " damage!");
                System.out.println("Hero " + h.getName() + " defence for " + h.getDefence() + "\n");
            }
        }
    }
    public void use(Hero h) {
        if (h != null) {
            do {
                System.out.println("\nEnter the name of the Potions you want to use: or enter q to exit");
                h.usePotion();
                System.out.println("Do you want to use another Potion?");
            } while (Checker.yesOrNo());
        }
    }
    public void round(int round) {
        monsterGroup.printTroops();
        System.out.println(C.YELLOW + "\n              And here is your Team's status" + C.RESET);
        heroGroup.printTroops();
        /*print each hero's items*/
        heroGroup.printInventory();
        do {
            printRound(round++);
            /*hero turn*/
            Hero h = heroGroup.getAvailableHero();
            Monster m = monsterGroup.getAvailableMonster();
            System.out.println("\n              CHOOSE MOVE FOR " + C.RED + "MONSTERS!" + C.RESET + "(EQUIP/equip, ATTACK/attack, CAST/cast, USE/use): ");
            int option = Checker.getBattleOption();
            switch (option) {
                case 1:
                    equip(h);
                    break;
                case 2:
                    attack(h, m);
                    break;
                case 3:
                    cast(h, m);
                    break;
                case 4:
                    use(h);
                    break;
            }
            monsterGroup.printTroops();
            heroGroup.printTroops();
            heroGroup.printInventory();
        } while (!heroGroup.hasAllFaint() && !monsterGroup.hasAllFaint());
    }
    public void end() {
        /*Faint hero revive and gain certain hp and mp, others gain gold and experience*/
        for (Hero h : heroGroup.getHeroGroup()) {
            h.afterRound(monsterGroup);
        }
    }
    public void begin() {
        Random rand = new Random();
        if (rand.nextInt(6) >= 3) {
            /*create monster*/
            /*pass number according to the heroes*/
            monsterGroup = new MonsterGroup(heroGroup.getSize());
            System.out.println(C.YELLOW + "\n              ** OH NO! The enemy has appeared. Get ready to fight for your lives! **\n");
            System.out.println("        The Monsters are closing the distance rapidly! Check their status and decide your move wisely!\n" + C.RESET);
            round(1);
            /*gain experience and gold when hero not all failed*/
            if (!heroGroup.hasAllFaint()) {
                end();
            }
        } else {
            System.out.println("        Looks like this area is safe. Get some rest and proceed with caution.");
            heroGroup.printTroops();
        }
    }
    public void printRound(int r) {
        System.out.println(C.PINK + "\n\n                 G E T  R E A D Y  F O R  R O U N D  " + r + C.RESET + "\n");
    }
}
