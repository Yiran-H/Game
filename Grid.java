import java.util.Random;

/*
20%inaccessible spaces, 30% market spaces, and 50% common spaces.
 */
//has 3 subclass
public class Grid {
    private int size;
    private Cell[][] grid;
    public Grid(int size) {
        this.size = size;
        this.grid = getRandomGrid();
    }
    public Cell[][] getGrid() {
        return grid;
    }

    public int getSize() {
        return size;
    }

    //generate map randomly
    private Cell[][] getRandomGrid() {
        Random rand = new Random();
        Cell[][] cell = new Cell[size][size];
        cell[0][0] = new MarketCell(); cell[0][1] = new CommonCell();
        for (int i = 2; i < size * size; i++) {
            double temp = rand.nextDouble();
            if(temp <= 0.2) {
                cell[i / size][i % size] = new InaccessibleCell();
            } else if (temp <= 0.5) {
                cell[i / size][i % size] = new MarketCell();
            } else {
                cell[i / size][i % size] = new CommonCell();
            }
        }
        return cell;
    }
    public void printGrid() {
        System.out.println(C.Line);
        for (int i = 0; i < size; i++) {
            System.out.print("|");
            for (int j = 0; j < size; j++) {
                grid[i][j].print();
                if (j < size - 1) {
                    System.out.print("||");
                }
            }
            System.out.println("|");
            System.out.println(C.Line);
        }
        System.out.println(Shape.Common.getShape() + " : Location   " + Shape.Market.getShape() + " : Market    " + Shape.NonAccess.getShape() + " : NonAccessible");
    }
}
