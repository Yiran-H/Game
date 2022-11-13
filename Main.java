
public class Main {
    public static void main(String args[]) {
        System.out.println(C.PINK + "\n        L E G E B D S  O F  M O N S T E R S  A N D  H E R O S\n" + C.RESET);
        System.out.println(C.PINK + "--" + C.S + C.RESET + "\n");
        Controller c = new Controller();
        c.simulate();
        /*All hero died, start a new game*/
        System.out.println("Do you want to play again? Press YES/yes or NO/no");
        while (Checker.yesOrNo()) {
            c.simulate();
        }
    }
}