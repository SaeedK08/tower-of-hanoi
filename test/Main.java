package tower_of_hanoi.test;

import java.util.Arrays;

import tower_of_hanoi.DiskColor;
import tower_of_hanoi.RodPos;
import tower_of_hanoi.Tower;
import tower_of_hanoi.Disk;

public class Main {
    public static void main(String[] args) {
        Tower game_tower = new Tower(4);
        System.out.println(game_tower.toString());
        System.out.println();
        
        game_tower.makeMove(RodPos.LEFT, RodPos.MIDDLE);
        game_tower.makeMove(RodPos.LEFT, RodPos.RIGHT);

        game_tower.makeMove(RodPos.MIDDLE, RodPos.RIGHT);
        game_tower.makeMove(RodPos.LEFT, RodPos.MIDDLE);

        game_tower.makeMove(RodPos.RIGHT, RodPos.LEFT);
        game_tower.makeMove(RodPos.RIGHT, RodPos.MIDDLE);

        game_tower.makeMove(RodPos.LEFT, RodPos.MIDDLE);
        game_tower.makeMove(RodPos.LEFT, RodPos.RIGHT);

        game_tower.makeMove(RodPos.MIDDLE, RodPos.RIGHT);
        game_tower.makeMove(RodPos.MIDDLE, RodPos.LEFT);
        
        game_tower.makeMove(RodPos.RIGHT, RodPos.LEFT);
        game_tower.makeMove(RodPos.MIDDLE, RodPos.RIGHT);
        
        game_tower.makeMove(RodPos.LEFT, RodPos.MIDDLE);
        game_tower.makeMove(RodPos.LEFT, RodPos.RIGHT);

        game_tower.makeMove(RodPos.MIDDLE, RodPos.RIGHT);
        game_tower.makeMove(RodPos.LEFT, RodPos.MIDDLE);
        
        game_tower.makeMove(RodPos.LEFT, RodPos.MIDDLE);
        game_tower.makeMove(RodPos.LEFT, RodPos.MIDDLE);
        
        System.out.println(game_tower.toString());
        System.out.println(game_tower.isSolved());

        Disk[] rod3Disks = game_tower.getDisks(RodPos.RIGHT);
        System.out.println(Arrays.toString(rod3Disks));
    }
}