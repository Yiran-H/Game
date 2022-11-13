/*
Inaccessible spaces, which the heroes cannot enter
Market spaces, where items can be bought or sold
Common spaces, where battles can occur
 */
public class Cell {
    private Shape shape;
    public Cell() {
        this.shape = Shape.Default;
    }
    public void print() {
        System.out.print("      " + this.shape.getShape() + "      ");
    }
    public boolean canEnter() {
        return true;
    }
    public boolean isMarket() {
        return false;
    }
    public boolean isBattle() {
        return false;
    }
}
