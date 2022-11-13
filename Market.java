//Singleton pattern - unique market

public class Market {
    private static final Market market = new Market();

    public static Market getMarket() {
        return market;
    }
    public void welcome() {
        Reader.printLine(Reader.getLine("welcome.txt"));
    }
}
