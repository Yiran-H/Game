import java.util.Scanner;

public class Checker {
    //check whether a string is an integer
    private static Scanner sc = new Scanner(System.in);
    public static boolean isInt(String s) {
        try{
            int num = Integer.parseInt(s);
        }catch (NumberFormatException ex){
            return false;
        }
        return true;
    }
    //check whether a number is in the given range and return final correct number
    public static int isInRange(int i, int j) {
        String a = sc.nextLine();
        while (!isInt(a)) {
            System.out.print("Please enter the numbers!");
            a = sc.nextLine();
        }
        while (Integer.parseInt(a) < i && Integer.parseInt(a) > j) {
            System.out.println("Please enter number between " + i + " and " + j);
            a = sc.nextLine();
        }
        return Integer.parseInt(a);
    }
    //return yes or no
    public static boolean yesOrNo() {
        String s = sc.nextLine();
        while (!s.equals("YES") && !s.equals("yes") && !s.equals("NO") && !s.equals("no")) {
            System.out.println("Press YES/yes or NO/no");
            s = sc.nextLine();
        }
        return s.equals("YES") || s.equals("yes");
    }
    //according to wasd return certain int[] direction
    public static int[] getDirection() {
        String s = sc.nextLine();
        while(!s.equals("w") && !s.equals("a") && !s.equals("s") && !s.equals("d")) {
            System.out.println("Please enter [W] [A] [S] [D]!");
            s = sc.nextLine();
        }
        switch (s) {
            case "w":
                return new int[]{-1, 0};
            case "a":
                return new int[]{0, -1};
            case "s":
                return new int[]{1, 0};
        }
        return new int[]{0, 1};
    }
    //get any string
    public static String getAnyKey() {
        String s = sc.nextLine();
        while (s.length() == 0) {
            s = sc.nextLine();
        }
        return s;
    }
    public static int getMarketOption() {
        String s = sc.nextLine();
        while (!s.equals("BUY") && !s.equals("buy") && !s.equals("SELL") && !s.equals("sell") && !s.equals("EXIT") && !s.equals("exit")) {
            System.out.println("Please press BUY/buy, SELL/sell or EXIT/exit");
            s = sc.nextLine();
        }
        if (s.equals("BUY") || s.equals("buy")) {
            return 1;
        } else if (s.equals("SELL") || s.equals("sell")) {
            return 2;
        }
        return 3;
    }
    public static int getBattleOption() {
        String s = sc.nextLine();
        while (!s.equals("EQUIP") && !s.equals("equip") && !s.equals("ATTACK") && !s.equals("attack") && !s.equals("CAST") && !s.equals("cast") && !s.equals("USE") && !s.equals("use")) {
            System.out.println("Please press EQUIP/equip, ATTACK/attack, CAST/cast, USE/use");
            s = sc.nextLine();
        }
        switch (s) {
            case "EQUIP":
            case "equip":
                return 1;
            case "ATTACK":
            case "attack":
                return 2;
            case "CAST":
            case "cast":
                return 3;
        }
        return 4;
    }
}
