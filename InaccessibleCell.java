public class InaccessibleCell extends Cell {
    private Shape shape;
    public InaccessibleCell() {
        this.shape = Shape.NonAccess;
    }
    @Override
    public void print() {
        System.out.print("      " + C.RED + this.shape.getShape() + C.RESET + "      ");
    }
    @Override
    public boolean canEnter() {
        return false;
    }
}
