import java.util.ArrayList;
import java.util.List;

public class MonsterGroup {
    private List<Monster> monsterList;
//    private int num;
    private int level;

    public boolean hasAllFaint() {
        for (Monster m : monsterList) {
            if (!m.isFaint()) {
                return false;
            }
        }
        return true;
    }
    public MonsterGroup(int number) {
        this.level = 0;
        this.monsterList = new ArrayList<>();
        /* produce monster */
        for (int i = 0; i < number; i++) {
            monsterList.add(C.factory.produceMonster());
        }
        for (Monster m : monsterList) {
            this.level = Math.max(this.level, m.getLevel());
        }
    }
    public void printTroops() {
        System.out.println(C.YELLOW + "Your Enemy's Troops:" + C.RESET);
        System.out.format(C.format5, "Name", "Health Power", "Damage", "Defence", "Attack AP");
        System.out.println(C.Line);
        for (Monster m : monsterList) {
            m.printInfo();
        }
    }
    public int getNum() {
        return monsterList.size();
    }

    public int getLevel() {
        return this.level;
    }
    public List<Monster> getMonsterList() {
        return monsterList;
    }
    public Monster getAvailableMonster() {
        for (Monster m : monsterList) {
            if (!m.isFaint()) {
                return m;
            }
        }
        return null;
    }
}
