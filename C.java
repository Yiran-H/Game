public class C {
    public static final String RESET = "\u001B[0m";
    public static final String YELLOW = "\u001B[33m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String WHITE = "\u001B[37m";
    public static final String PINK = "\u001B[35m";
    public static final String Line = new String(new char[120]).replace("\0", "-");
    public static final String Star = new String(new char[30]).replace("\0", "*");
    public static final String S = new String(new char[10]).replace("\0", "<<o>>--");
    public static final String format5 = "|%1$-20s|%2$-15s|%3$-15s|%4$-15s|%5$-20s|\n";
    public static final String format7 = "|%1$-20s|%2$-15s|%3$-15s|%4$-10s|%5$-10s|%6$-12s|%7$-13s|\n";
    public static final String format6 = "|%1$-20s|%2$-10s|%3$-15s|%4$-10s|%5$-20s|%6$-20s|\n";
    public static final String format4 = "|%1$-20s|%2$-15s|%3$-15s|%4$-20s|\n";
    public static final Factory factory = new Factory();
}
