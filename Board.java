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
            for (int j = 0; j < size; j++) {
                System.out.print("+-----");
            }
            System.out.print("+");
            System.out.println();

            for (int j = 0; j < size; j++) {
                System.out.print("|  " + row.get(j) + "  ");
            }
            System.out.print("|");
            System.out.println();
        }
        for (int j = 0; j < size; j++) {
            System.out.print("+-----");
        }
        System.out.print("+");
        System.out.println();
    }

    boolean setChar(int x, int y, char token) {
        if (x < 0 || y < 0 || x >= size || y >= size) {
            return false;
        }
        List<Character> row = board.get(x);
        row.set(y, token);
        return true;
    }

    char checkWin() {
        //this is gonna be painfully fun to implement
        return '?';
    }
}
