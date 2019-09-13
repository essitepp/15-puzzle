package fifteenpuzzle.puzzle;

import java.util.ArrayList;
import java.util.Random;

public class Puzzle {

    private Grid grid;

    public Puzzle() {
        this.grid = new Grid();
    }

    public void reset() {
        this.grid.reset();
    }
    
    public void shuffle() {
        //need to prevent making previous move again
        for (int i = 0; i < 15; i++) {
            moveRandom();
        }
    }

    private void moveRandom() {
            Random random = new Random();
            ArrayList<Tile> moves = possibleMoves();
            Tile tile = moves.get(random.nextInt(moves.size()));
            this.grid.move(tile.getY(), tile.getX());
//            System.out.println("moving " + tile.getY() + ", " + tile.getX());
//            System.out.println(this.toString());
        
    }

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

    private ArrayList<Tile> possibleMoves() {
        ArrayList<Tile> list = new ArrayList<>();
        int size = grid.getTiles().length;
        int xEmpty = grid.getEmpty().getX();
        int yEmpty = grid.getEmpty().getY();
        for (int i = yEmpty - 1; i <= yEmpty + 1; i++) {
            if (i >= 0 && i < size) {
                for (int j = xEmpty - 1; j <= xEmpty + 1; j++) {
                    if (j >= 0 && j < size) {
                        if ((i != yEmpty || j != xEmpty) && (i == yEmpty || j == xEmpty)) {
                            list.add(new Tile(i, j));
                        }
                    }
                }
            }
        }
        return list;
    }
}
