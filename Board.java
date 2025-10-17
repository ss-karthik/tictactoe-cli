import java.util.*;

class Board {

    int size;
    List<List<Character>> board;

    Board(int size) {
        this.size = size;
        board = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<Character> row = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                row.add('.');
            }
            board.add(row);
        }
    }

    void printBoard() {
        for (int i = 0; i < size; i++) {
            List<Character> row = board.get(i);
            //System.out.print("|");

            for (int j = 0; j < size; j++) {
                System.out.print(row.get(j) + " ");
            }
            System.out.println();
        }
    }
}
