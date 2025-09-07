package tower_of_hanoi;

import tower_of_hanoi.DiskColor;

public class Disk {
    private final int diameter; 
    private final DiskColor color;

    public Disk(int diameter, DiskColor color) {
        this.diameter = diameter; 
        this.color = color;
    }

    public int getDiskDiameter() {
        return this.diameter;
    }
    public DiskColor getDiskColor() {
        return this.color;
    }

    @Override 
    public String toString() {
        return "Disk diameter: " + diameter + ", color: " + color;
    }
}
