package tower_of_hanoi.src;

import java.util.Arrays;
import tower_of_hanoi.src.Rod;
import tower_of_hanoi.src.RodPos;

public class Tower {
    private final Rod[] tower;
    private int moves;
    private final int numOfDisks;

    public  Tower(int numOfDisks) {
        tower = new Rod[3];
        for(int i = 0; i < tower.length; i++) {
            tower[i] = new Rod(numOfDisks);
        }
        for(int i = 0; i < numOfDisks; i++) {
            tower[RodPos.LEFT.getValue()].push(new Disk(numOfDisks - i, i));
        }
        moves = 0;
        this.numOfDisks = numOfDisks;
    }
    public int getMoves() {
        return this.moves;
    }
    public int getNumOfDisks() {
        return this.numOfDisks;
    }
    public void initNewGame() {
        this.moves = 0;
        for(int i = 0; i < tower.length; i++) {
            tower[i].clear();
        }
        for(int i = 0; i < numOfDisks; i++) {
            tower[RodPos.LEFT.getValue()].push(new Disk(numOfDisks - i, i));
        }
    }
    public boolean isLegalMove(RodPos currentPos, RodPos nextPos) {
        if (currentPos.equals(nextPos)) return false;
        else if (tower[currentPos.getValue()].isEmpty()) return false;
        // if (!(tower[nextPos.getValue()].canPush(tower[currentPos.getValue()].peek()))) return false;    // An extra check point
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