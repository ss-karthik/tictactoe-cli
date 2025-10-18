import java.util.*;

class Board {

    int size;
    List<List<Character>> board;

    Board(int size) {
        //initializes the board of required size and fills with spaces
        this.size = size;
        board = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<Character> row = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                row.add(' ');
            }
            board.add(row);
        }
    }

    //checks if index within bounds
    boolean isValidIndex(int x, int y) {
        if (x < 0 || y < 0 || x >= size || y >= size) {
            return false;
        }
        return true;
    }

    //pretty prints the board
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
        //returns false if invalid index - out of bounds, or trying to place over another token
        //returns true if valid index - after updating the board with that token
        if (!isValidIndex(x, y)) return false;

        List<Character> row = board.get(x);
        if (row.get(y) != ' ') return false;

        row.set(y, token);
        return true;
    }

    //loop to check if the board is full or a playable move exists
    boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board.get(i).get(j) == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    //checks for 4 different possible win scenarios when given a token
    boolean checkWin(char token) {
        //check to see if a row is complete
        for (int i = 0; i < size; i++) {
            int c = 0;
            for (int j = 0; j < size; j++) {
                if (board.get(i).get(j) != token) break;
                c++;
            }
            if (c == size) return true;
        }

        //check to see if a column is complete
        for (int i = 0; i < size; i++) {
            int c = 0;
            for (int j = 0; j < size; j++) {
                if (board.get(j).get(i) != token) break;
                c++;
            }
            if (c == size) return true;
        }

        //check to see if one principal diagonal is complete
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

        //check to see if the other principal diagonal is complete
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
