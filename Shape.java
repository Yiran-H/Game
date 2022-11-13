public enum Shape {
    Market('M'),
    Common(' '),
    NonAccess('X'),
    Default('O');
    private final char shape;
    Shape(char s) {
        this.shape = s;
    }
    public char getShape() {
        return this.shape;
    }
}