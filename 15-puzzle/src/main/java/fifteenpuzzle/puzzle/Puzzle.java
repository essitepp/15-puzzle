package fifteenpuzzle.puzzle;

import java.util.ArrayList;
import java.util.Random;

public class Puzzle {

    private Grid grid;

    public Puzzle() {
        this.grid = new Grid();
    }

    /**
     * Resets the puzzle
     */
    public void reset() {
        this.grid.reset();
    }
    
    /**
     * Shuffles the puzzle by making random moves
     * 
     * @param n     Number of random moves to make
     */
    public void shuffle(int n) {
        int previous = 0;
        for (int i = 0; i < n; i++) {          
            previous = moveRandom(previous);
        }
    }

    private int moveRandom(int forbidden) {
            Random random = new Random();
            ArrayList<Position> moves = possibleMoves();
            Position tile = moves.get(random.nextInt(moves.size()));
            while (this.grid.getTiles()[tile.getY()][tile.getX()] == forbidden) {
                System.out.println("invalid move: " + tile.getY() + ", " + tile.getX());
                tile = moves.get(random.nextInt(moves.size()));
            }
            int moved = this.grid.move(tile.getY(), tile.getX());
            
            System.out.println("moving " + tile.getY() + ", " + tile.getX());
            System.out.println(this.toString());
            
            return moved;        
    }

    /**
     * Returns a string representing the puzzle grid
     * 
     * @return  a string representing the puzzle
     */
    @Override
    public String toString() {
        String s = "";
        int[][] tiles = this.grid.getTiles();
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                s += tiles[i][j];
                s += "\t";
            }
            s += "\n";
        }
        return s;
    }

    private ArrayList<Position> possibleMoves() {
        ArrayList<Position> list = new ArrayList<>();
        int size = grid.getTiles().length;
        int xEmpty = grid.getEmpty().getX();
        int yEmpty = grid.getEmpty().getY();
        for (int i = yEmpty - 1; i <= yEmpty + 1; i++) {
            if (i >= 0 && i < size) {
                for (int j = xEmpty - 1; j <= xEmpty + 1; j++) {
                    if (j >= 0 && j < size) {
                        if ((i != yEmpty || j != xEmpty) && (i == yEmpty || j == xEmpty)) {
                            list.add(new Position(i, j));
                        }
                    }
                }
            }
        }
        return list;
    }
}
