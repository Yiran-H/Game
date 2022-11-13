import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Reader {
    private static BufferedReader reader;
    private static Scanner sc = new Scanner(System.in);
    private static Random rand = new Random();
    private static List<String> L1 = getLine("Warriors.txt");
    private static List<String> L2 = getLine("Sorcerers.txt");
    private static List<String> L3 = getLine("Paladins.txt");
    private static List<String> L4 = getLine("Weaponry.txt");
    private static List<String> L5 = getLine("Armory.txt");
    private static List<String> L6 = getLine("Potions.txt");
    private static List<String> L7 = getLine("IceSpells.txt");
    private static List<String> L8 = getLine("FireSpells.txt");
    private static List<String> L9 = getLine("LightningSpells.txt");

    public static String[] helper(String[] l) {
        String[] list = new String[l.length];
        for (int i = 0; i < l.length; i++) {
            if (i == 2) {
                list[2] = "200";
                continue;
            }
            if (i > 2) {
                list[i] = l[i - 1];
            } else {
                list[i] = l[i];;
            }
            if (i == l.length - 1) {
                list[i] = l[l.length - 1];
            }
        }
        return list;
    }
    public static void printAllHero() {
        System.out.println("\n" + C.YELLOW + "Available Warriors\n" + C.RESET + C.Star);
        System.out.format(C.format7, "Name", "Magic Power", "Health Power", "Strength", "Agility", "Dexterity", "Experience");
        System.out.println(C.Line);
        printLineFormat77(L1);

        System.out.println("\n" + C.YELLOW + "Available Sorcerers\n" + C.RESET + C.Star);
        System.out.format(C.format7, "Name", "Magic Power", "Health Power", "Strength", "Agility", "Dexterity", "Experience");
        System.out.println(C.Line);
        printLineFormat77(L2);

        System.out.println("\n" + C.YELLOW + "Available Paladins\n" + C.RESET + C.Star);
        System.out.format(C.format7, "Name", "Magic Power", "Health Power", "Strength", "Agility", "Dexterity", "Experience");
        System.out.println(C.Line);
        printLineFormat77(L3);
    }
    public static void printAllItems() {
        System.out.println("\n" + C.YELLOW + "Available Weapons\n" + C.RESET + C.Star);
        System.out.format(C.format5, "Name", "Cost", "Unlock Level", "Damage", "Required Hands");
        System.out.println(C.Line);
        printLineFormat5(L4);

        System.out.println("\n" + C.YELLOW + "Available Armors\n" + C.RESET + C.Star);
        System.out.format(C.format4, "Name", "Cost", "Unlock Level", "Damage Reduction");
        System.out.println(C.Line);
        printLineFormat4(L5);

        System.out.println("\n" + C.YELLOW + "Available Potions\n" + C.RESET + C.Star);
        System.out.format(C.format5, "Name", "Cost", "Unlock Level", "Increase Rate", "Attribute affected");
        System.out.println(C.Line);
        printLineFormat5(L6);
    }
    public static void printAllSpells() {
        System.out.println("\n" + C.YELLOW + "Available Ice Spells\n" + C.RESET + C.Star);
        System.out.format(C.format5, "Name", "Cost", "Unlock Level", "Damage", "Minimum Magic Power");
        System.out.println(C.Line);
        printLineFormat5(L7);

        System.out.println("\n" + C.YELLOW + "Available Fire Spells\n" + C.RESET + C.Star);
        System.out.format(C.format5, "Name", "Cost", "Unlock Level", "Damage", "Minimum Magic Power");
        System.out.println(C.Line);
        printLineFormat5(L8);

        System.out.println("\n" + C.YELLOW + "Available Lightning Spells\n" + C.RESET + C.Star);
        System.out.format(C.format5, "Name", "Cost", "Unlock Level", "Damage", "Minimum Magic Power");
        System.out.println(C.Line);
        printLineFormat5(L9);
    }
    public static String[] getItemTarget(String name) {
        name = name.replaceAll("\\s", "");
        String[] s;
        String[] s4 = hasTarget(L4, name);
        String[] s5 = hasTarget(L5, name);
        String[] s6 = hasTarget(L6, name);
        if (s4 != null) {
            return addFront(s4, "Weapons");
        } else if (s5 != null) {
            return addFront(s5, "Armor");
        } else if (s6 != null) {
            return addFront(s6, "Potions");
        }
        return null;
    }
    public static String[] getSpellTarget(String name) {
        name = name.replaceAll("\\s", "");
        String[] s;
        String[] s7 = hasTarget(L7, name);
        String[] s8 = hasTarget(L8, name);
        String[] s9 = hasTarget(L9, name);
        if (s7 != null) {
            return addFront(s7, "IceSpell");
        } else if (s8 != null) {
            return addFront(s8, "FireSpell");
        } else if (s9 != null) {
            return addFront(s9, "LightningSpell");
        }
        return null;
    }
    public static String[] getHeroTarget(String name) {
        name = name.replaceAll("\\s", "");
        String[] s;
        String[] s1 = hasTarget(L1, name);
        String[] s2 = hasTarget(L2, name);
        String[] s3 = hasTarget(L3, name);
        if (s1 != null) {
            return addFront(s1, "Warriors");
        } else if (s2 != null) {
            return addFront(s2, "Sorcerers");
        } else if (s3 != null) {
            return addFront(s3, "Paladins");
        }
        return null;
    }
    private static String[] hasTarget(List<String> list, String t) {
        for (String s : list) {
            if (s.split("\\s+", 0)[0].equals(t)) {
                return s.split("\\s+", 0);
            }
        }
        return null;
    }
    private static String[] addFront(String[] s, String t) {
        String[] ss = new String[s.length + 1];
        ss[0] = t;
        System.arraycopy(s, 0, ss, 1, ss.length - 1);
        return ss;
    }
    public static String[] getRandomMonster() {
        List<String> list = new ArrayList<>();
        int n = rand.nextInt(3);
        String s;
        if (n == 0) {
            list = getLine("Dragons.txt");
            s = "Dragons";
        } else if (n == 1) {
            list = getLine("Exoskeletons.txt");
            s = "Exoskeletons";
        } else {
            list = getLine("Spirits.txt");
            s = "Spirits";
        }
        return addFront(list.get(rand.nextInt(list.size())).split("\\s+", 0), s);
    }

    public static List<String> getLine(String path) {
        List<String> list = new ArrayList<>();
        try {
            reader = new BufferedReader(new java.io.FileReader(path));
            String line = reader.readLine();
            line = reader.readLine();
            while (line != null && line.length() != 0) {
                list.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static void printLine(List<String> line) {
        for (String l : line) {
            System.out.println(l);
        }
    }
    public static void printLineFormat77(List<String> line) {
        for (String l : line) {
            String[] s = l.split("\\s+", 0);
            System.out.format(C.format7, helper(s));
        }
    }
    public static void printLineFormat7(List<String> line) {
        for (String l : line) {
            String[] s = l.split("\\s+", 0);
            System.out.format(C.format7, s);
        }
    }
    public static void printLineFormat5(List<String> line) {
        for (String l : line) {
            String[] s = l.split("\\s+", 0);
            System.out.format(C.format5, s);
        }
    }
    public static void printLineFormat4(List<String> line) {
        for (String l : line) {
            String[] s = l.split("\\s+", 0);
            System.out.format(C.format4, s);
        }
    }
    public static void printLineFormat6(List<String> line) {
        for (String l : line) {
            String[] s = l.split("\\s+", 0);
            System.out.format(C.format6, s);
        }
    }
}
