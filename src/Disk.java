package tower_of_hanoi.src;

import tower_of_hanoi.src.DiskColor;

public class Disk {
    private final int diameter; 
    private final DiskColor color;

    public Disk(int diameter, int index) {
        this.diameter = diameter; 
        this.color = DiskColor.values()[index];
    }

    public int getDiskDiameter() {
        return this.diameter;
    }
    public DiskColor getDiskColor() {
        return this.color;
    }

    @Override 
    public String toString() {
        return "Disk [diameter= " + diameter + ", color: " + color;
    }
}
