package tower_of_hanoi;

import java.util.Arrays;
import tower_of_hanoi.Rod;
import tower_of_hanoi.RodPos;

public class Tower {
    private Rod[] tower;
    private int moves;
    
    public  Tower(int numOfDisks) {
        tower = new Rod[3];
        for(int i = 0; i < tower.length; i++) {
            tower[i] = new Rod(numOfDisks);
        }
        DiskColor[] colors = DiskColor.values();
        for(int i = 0; i < numOfDisks; i++) {
            tower[0].push(new Disk(numOfDisks - i, colors[i]));
        }
        moves = 0;
    }

    public void initNewGame() {

    }
    public boolean isLegalMove(RodPos currentPos, RodPos nextPos) {
        if (currentPos.equals(nextPos)) return false;
        if (tower[currentPos.getValue()].isEmpty()) return false;
        if (!(tower[nextPos.getValue()].canPush(tower[currentPos.getValue()].peek()))) return false; 
        else return true;
    }
    public void makeMove(RodPos currenPos, RodPos nextPos) {
        if (isLegalMove(currenPos, nextPos)) {
            tower[nextPos.getValue()].push(tower[currenPos.getValue()].pop());
            moves++;
        }
        else throw new IllegalStateException("Illegal move from " + currenPos + " to " + nextPos);
    }
    public boolean isSolved() {
        return tower[RodPos.RIGHT.getValue()].isFull();
    }
    public Disk[] getDisks(RodPos pos) {
        Disk[] copy = tower[pos.getValue()].copyDiskArr();
        return copy;
    }

    @Override
    public String toString() {
        return "Tower " + Arrays.toString(tower) + ", moves=" + moves;
    }
    
}