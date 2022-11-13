public class MarketCell extends Cell{
    private Shape shape;
    public MarketCell() {
        this.shape = Shape.Market;
    }
    @Override
    public void print() {
        System.out.print("      ");
        System.out.print(C.PINK + this.shape.getShape() + C.RESET);
        System.out.print("      ");
    }
    @Override
    public boolean isMarket() {
        return true;
    }
}
