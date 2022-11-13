public class CommonCell extends Cell{
    private Shape shape;
    public CommonCell() {
        this.shape = Shape.Common;
    }
    @Override
    public void print() {
        System.out.print("      " + this.shape.getShape() + "      ");
    }
    @Override
    public boolean isBattle() {
        return true;
    }
}
