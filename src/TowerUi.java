package tower_of_hanoi.src;

import tower_of_hanoi.src.Tower;

import java.util.Arrays;
import java.util.Scanner;
import java.lang.Character;

public class TowerUi {
    private final Tower tower;
    private final Scanner scanner;
    private boolean isRunning;

    public TowerUi() {
        tower = new Tower(5);           //Make it a usr input
        scanner = new Scanner(System.in);
        isRunning = true;
    }

    public void run() {
        System.out.println("Welcome to The Towers of Hanoi game!!!");
        
        while(isRunning) {
            System.out.println("New game!");
            System.out.println(rules + commands);
            printBoard();
            while(isRunning && !tower.isSolved()) {
                System.out.print("Enter command: ");
                String str = scanner.nextLine();
                executeCommand(str);
            }
            if(tower.isSolved()) {
                System.out.println(congrats);
                tower.initNewGame();
            }
        }
    }
    public void executeCommand(String str) {
        if(str.isEmpty()) {
            printIllegalCommand(str);
            return;
        }
        String cmdstr = str.trim().toLowerCase();
        if(cmdstr.length() == 1)
        {
            switch(cmdstr) {
                case "h": System.out.println(commands);
                    break;
                case "q": isRunning = false;
                    break;
                default: printIllegalCommand(cmdstr);
                    break;
            }
        }
        else if(cmdstr.length() == 2) {
            RodPos fromPos = getRodPos(cmdstr.charAt(0));
            RodPos toPos = getRodPos(cmdstr.charAt(1));
            if (fromPos != null && toPos != null) {
                if (tower.isLegalMove(fromPos, toPos)) {
                    tower.makeMove(fromPos, toPos);
                    printBoard();
                } else {
                    System.out.println("Illegal move.");
                }
            }
            else {
                printIllegalCommand(cmdstr);
            }
        }
        else 
            printIllegalCommand(cmdstr);
    }
    public void printBoard() {
        int noOfDisks = tower.getNumOfDisks();
        Disk[] left = tower.getDisks(RodPos.LEFT);
        Disk[] middle = tower.getDisks(RodPos.MIDDLE);
        Disk[] right = tower.getDisks(RodPos.RIGHT);

        for (int i = noOfDisks - 1; i >= 0; i--) {
            String row = "";
            row += left.length <= i ? "  " : " " + left[i].getDiskDiameter();
            row += middle.length <= i ? "  " : " " + middle[i].getDiskDiameter();
            row += right.length <= i ? "  " : " " + right[i].getDiskDiameter();
            System.out.println(row);
        }
        System.out.println(" = = = ");
        System.out.println("moves= " + tower.getMoves());
    }
    private RodPos getRodPos(char rodChar) {
        switch (rodChar) {
            case 'l': return RodPos.LEFT;
            case 'm': return RodPos.MIDDLE;
            case 'r': return RodPos.RIGHT;
            default: return null;
        }
    }
    public void printIllegalCommand(String command) {
        System.out.println("Sorry, i do not understand \"" + command + "\"");
    }

    private final String rules = "The objective of the game is to move the disks from the left" + "\n" +
                                 "rod to the right rod. Only the disk at the top of a rod may be moved." + "\n" +
                                 "A disk can only be moved to an empty rod or to a rod where the top disk is" + "\n" +
                                 "larger than the disk to move." + "\n" + "-------\n";

    private final String commands =  "Commands: \n\t" +
                                     "lm/ml/rl/...: To move a disk where l, m and r stands for left, middle and right rode (if allowed)" + "\n"+
                                     "\th: For help" + "\n" +
                                     "\tq: To quit" + "\n" +
                                     "--------\n";

    private final String congrats = "\n|------------------|\n" + "| Congratulations!!|\n" + "|------------------|\n";
 }