
public class Controller {
    private Grid grid;
    private HeroGroup heroGroup;
    private Factory factory;
    private Market market;
    private int[] cur;
    public Controller() {
        System.out.println("Choose the size of map you wanna play (Please enter number between 7 and 9)");
        grid = new Grid(Checker.isInRange(7, 9));
        heroGroup = new HeroGroup();
        factory = new Factory();
        cur = new int[]{0, 0};
        market = Market.getMarket();
    }
    public void simulate() {
        //create hero team
        buildHeroTeam();
        //and then move
        move();
    }
    //as long as heroGroup is not failed and doesn't want to quit, they keep moving
    public void move() {
        while (!heroGroup.hasAllFaint()) {
            grid.printGrid();
            System.out.println("The current location on the map is " + cur[0] + " x " + cur[1]);
            //enter a certain cell and do the certain thing
            doSomething(cur);
            if (heroGroup.hasAllFaint()) {
                return;
            }
            System.out.println("The current location on the map is " + cur[0] + " x " + cur[1]);
            System.out.print("Time for our next destination! Choose your move: (Press [W] [A] [S] [D])");
            //get nect position
            cur = getNextPosition(cur, grid.getSize());
        }
        /*All hero died, start a new game*/
    }
    private int[] getNextPosition(int[] cur, int size) {
        int[] d = Checker.getDirection();
        int x = cur[0] + d[0];
        int y = cur[1] + d[1];
        while (x < 0 || x >= size || y < 0 || y >= size || !grid.getGrid()[x][y].canEnter()) {
            System.out.println("This place cannot access! Please choose another place: ");
            d = Checker.getDirection();
            x = cur[0] + d[0];
            y = cur[1] + d[1];
        }
        return new int[]{cur[0] + d[0], cur[1] + d[1]};
    }
    public void doSomething(int[] position) {
        //either go to the market or fight
        if (grid.getGrid()[cur[0]][cur[1]].isMarket()) {
            System.out.println("This is a market in your area. Do you want to visit? Press YES/yes or NO/no");
            if (Checker.yesOrNo()) {
                /*buy or sale*/
                market.welcome();
                while (true) {
                    System.out.println("\n    Press BUY/buy, SELL/sell or EXIT/exit according to your purposes: ");
                    int option = Checker.getMarketOption();
                    if (option == 1) {
                        /*buy*/
                        buy();
                    } else if (option == 2) {
                        /*sell*/
                        sell();
                    } else {
                        break;
                    }
                }
            }
            System.out.println("enter i to display all heroes inventory:");
            if (Checker.getAnyKey().equals("i")) {
                heroGroup.printInventory();
            }
        } else {
            /* battle */
            Battle battle = new Battle(heroGroup);
            battle.begin();
            if (heroGroup.hasAllFaint()) {
                Reader.printLine(Reader.getLine("heroFailed.txt"));
                System.out.println("All hero failed! It's time to start a new game");
                heroGroup = new HeroGroup();
                return;
            }
        }
        System.out.println("enter any key to display the map or continue");
        Checker.getAnyKey();
        grid.printGrid();
    }
    public void buy() {
        Hero h;
        do {
            System.out.println("Choose Category:\nPress 1. for Item 2. for Spells");
            int o = Checker.isInRange(1, 2);
            heroGroup.printGold();
            if (heroGroup.getSize() > 1) {
                System.out.println("\nEnter the name of Hero who will buy the Item/Spell or enter q to exit");
                h = heroGroup.getHeroByName();
                if (h == null) {
                    return;
                }
            } else {
                h = heroGroup.getHeroGroup().get(0);
            }
            if (o == 1) {
                /*buy item*/
                Reader.printAllItems();
                System.out.println("\nEnter the name of the item you want to buy: or enter q to exit");
                h.buyItem(factory);
            } else {
                /*buy spell*/
                Reader.printAllSpells();
                System.out.println("\nEnter the name of the spell you want to buy: or enter q to exit");
                h.buySpell(factory);
            }
            System.out.println("Do you want to buy anything else? Press YES/yes or NO/no: ");
        } while (Checker.yesOrNo());
    }
    public void sell() {
        do {
            heroGroup.printGold();
            System.out.println("\nEnter the name of Hero who will sell the Item/Spell Spell or enter q to exit");
            Hero h = heroGroup.getHeroByName();
            if (h == null) {
                return;
            }
            h.printItem();
            System.out.println("\nEnter the name of the item/spell you want to sell: or enter q to exit");
            h.sell();
            System.out.println("Do you want to sell anything else? Press YES/yes or NO/no: ");
        } while (Checker.yesOrNo());
    }
    public void buildHeroTeam() {
        Reader.printAllHero();
        for (int i = 1; i < 4; i++) {
            if (i == 1) {
                System.out.print("Enter hero's name:");
                heroGroup.addHero(factory.produceHero());
            } else {
                System.out.println("Do you want to choose another hero? Press YES/yes or NO/no");
                if (Checker.yesOrNo()) {
                    System.out.print("Enter hero's name:");
                    heroGroup.addHero(factory.produceHero());
                } else {
                    break;
                }
            }
            if (i == 3) {
                System.out.println("At most 3 hero! You cannot choose again!");
            }
        }
    }
}
