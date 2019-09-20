package fifteenpuzzle.puzzle;

import java.util.Scanner;

public class PuzzleUi {

    public static void main(String[] args) {
        Puzzle puzzle = new Puzzle();
        System.out.println(puzzle.toString());

        while (true) {
            System.out.println("Select action:\n"
                    + "\treset - resets the puzzle\n"
                    + "\tshuffle - shuffles the puzzle by making 20 random moves\n"
                    + "\tsolve - solves the puzzle\n"
                    + "\texit - exits the program");

            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();

            if (command.equals("reset")) {
                puzzle.reset();
                System.out.println("\n" + puzzle.toString());
            } else if (command.equals("shuffle")) {
                puzzle.shuffle(20);
                System.out.println("\n" + puzzle.toString());
            } else if (command.equals("solve")) {
                //puzzle.solve();
            } else if (command.equals("exit")) {
                break;
            } else {
                System.out.println("Unknown command");
                System.out.println("");
            }
        }
    }

}
