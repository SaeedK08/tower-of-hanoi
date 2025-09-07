package tower_of_hanoi.src;

import java.util.ArrayList;
import java.util.Arrays;
import tower_of_hanoi.src.Disk;
import tower_of_hanoi.src.DiskColor;

public class Rod {
    private Disk[] rod;
    private int n;
    private final int capacity;

    public Rod(int capacity) {
        this.capacity = capacity;
        rod = new Disk[capacity];
        this.n = 0;
    }

    public boolean canPush(Disk disk) {
        if (isEmpty() || (disk.getDiskDiameter() < rod[n-1].getDiskDiameter() && n < capacity))
            return true; 
        else return false;
    }
    public boolean isEmpty() {
        return n == 0;
    }
    public boolean isFull() {
        return this.n == this.capacity;
    }
    public void push(Disk disk) {
        if (canPush(disk)) {
            rod[n++] = disk;
        }
        else {
            throw new IllegalStateException(isFull() ? "Rod is full" : disk + "] is bigger than the one at the top");
        }
    }
    public Disk pop () {
        if (isEmpty()) throw new IllegalStateException("The rod is empty");
        Disk poped = rod[n-1];                          
        rod[--n] = null;
        return poped;
    }
    public void clear() {
        this.n = 0;
        for(int i = 0; i < rod.length; i++) {
            rod[i] = null;
        }
    }
    public Disk[] copyDiskArr() {
        Disk[] copy = Arrays.copyOf(rod, n);
        return copy;
    }
    public Disk peek() {
        if (isEmpty()) return null;
        else return rod[n-1];
    }
    public int getNumberOfDisks() {
        return this.n;
    }
    public int getCapacityofRod() {
        return this.capacity;
    }

    @Override
    public String toString() {
        return "Rod " + Arrays.toString(rod) + ", Number of Disks: " + n + ", Capacity: " + capacity + "\n";
    }
}