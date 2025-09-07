package tower_of_hanoi.src;

public enum RodPos {
    LEFT(0), 
    MIDDLE(1), 
    RIGHT(2);

    private int value;

    private RodPos (int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}