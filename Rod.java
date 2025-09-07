package tower_of_hanoi;

import java.util.ArrayList;
import java.util.Arrays;
import tower_of_hanoi.Disk;
import tower_of_hanoi.DiskColor;

public class Rod {
    private Disk[] rod;
    private int n;
    private final int capacity;

    public Rod(int capacity) {
        this.capacity = capacity;
        rod = new Disk[capacity];
        this.n = 0;
        // for (int i = 0; i < capacity; i++) {
        //     DiskColor[] colors  = DiskColor.values();
        //     rod[i] = new Disk(0, colors[i]);
        // }
    }

    public boolean canPush(Disk disk) {
        if (isEmpty() || (disk.getDiskDiameter() < rod[n-1].getDiskDiameter() && n < capacity))
            return true; 
        else return false;
    }
    public boolean isEmpty() {
        return n <= 0;
    }
    public boolean isFull() {
        return this.n >= this.capacity;
    }
    public void push(Disk disk) {
        if (canPush(disk)) {
            rod[n++] = disk;
        }
        else {
            throw new IllegalStateException(isFull() ? "Rod is full" : "Disk is bigger than the one at the top");
        }
    }
    public Disk pop () {
        if (isEmpty()) throw new IllegalStateException("The rod is empty");
        Disk poped = rod[n-1];                          
        // for(int i = n-1; i < n; i++) {
        //     rod[i] = rod[i-1];
        // }
        rod[--n] = null;
        return poped;
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

    // @Override
    // public String toString() {
    //     return "Rod [rod=" + Arrays.toString(rod) + ", n=" + n + ", capacity=" + capacity + "]";
    // }

    @Override
    public String toString() {
        return "Rod " + Arrays.toString(rod) + ", Number of Disks: " + n + ", Capacity: " + capacity + "\n";
    }
}