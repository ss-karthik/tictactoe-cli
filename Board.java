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

    boolean isValidIndex(int x, int y) {
        if (x < 0 || y < 0 || x >= size || y >= size) {
            return false;
        }
        return true;
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
        if (!isValidIndex(x, y)) return false;

        List<Character> row = board.get(x);
        if (row.get(y) != '.') return false;

        row.set(y, token);
        return true;
    }

    boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board.get(i).get(j) == '.') {
                    return false;
                }
            }
        }
        return true;
    }

    boolean checkWin(char token) {

        for (int i = 0; i < size; i++) {
            int c = 0;
            for (int j = 0; j < size; j++) {
                if (board.get(i).get(j) != token) break;
                c++;
            }
            if (c == size) return true;
        }

        for (int i = 0; i < size; i++) {
            int c = 0;
            for (int j = 0; j < size; j++) {
                if (board.get(j).get(i) != token) break;
                c++;
            }
            if (c == size) return true;
        }

        int i = 0;
        int j = 0;
        int c = 0;
        while (i < size && j < size) {
            if (board.get(i).get(j) != token) break;
            i++;
            j++;
            c++;
        }
        if (c == size) return true;

        i = 0;
        j = size - 1;
        c = 0;
        while (i < size && j >= 0) {
            if (board.get(i).get(j) != token) break;
            i++;
            j--;
            c++;
        }
        if (c == size) return true;

        return false;
    }
}
