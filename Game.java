import java.util.*;

class Game {

    List<Player> players;
    int size;
    int n;

    Game() {
        //initializes an empty list of player objects on start of game
        players = new ArrayList<>();
    }

    void begin() {
        Scanner sc = new Scanner(System.in);

        //Taking Input of Player Names and Tokens
        System.out.println("Enter number of Players: ");
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println("Enter Player Name and Token for Player: " + i);
            String name = sc.next();
            char token = sc.next().charAt(0);
            Player temp = new Player(name, token);
            players.add(temp);
        }

        //Taking size of board input and creating a board object.
        System.out.println("Enter Size of Board: ");
        size = sc.nextInt();
        Board b = new Board(size);

        

        boolean result = false; //for storing if win has occured after each turn
        int turn = 0; //current player whose turn it is to place the token
        int preturn = n-1; //previous turn - useful for printing winner once broken out of loop

        //loop runs until winner found or until board is full(tie)
        while(!(result=b.checkWin(players.get(preturn).token)) && !b.isFull()) {
            b.printBoard();
            System.out.println(players.get(turn).name+"'s Turn {"+players.get(turn).token+"}");
            System.out.println("Enter a Position to place token: ");
            int x = sc.nextInt();
            int y = sc.nextInt();
            //setChar returns true if token successfully set at the location and false otherwise
            //we increment turn only if valid position is available to set token
            if(b.setChar(x,y,players.get(turn).token)){
                preturn = turn;
                turn = (turn+1)%n; //circular increment
            } else {
                System.out.println("Invalid Position! Try Again!");
            }
        } 
        //if we have a winner out of the loop then print, else it is a tie
        b.printBoard();
        if(result){
            System.out.println(players.get(preturn).name + " is the Winner!");
        } else {
            System.out.println("TIE");
        }
    }
}
