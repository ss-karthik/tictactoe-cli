import java.util.*;

class Game {

    List<Player> players;
    int size;
    int n;

    Game() {
        players = new ArrayList<>();
    }

    void begin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Players: ");
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println("Enter Player Name and Token for Player: " + i);
            String name = sc.next();
            char token = sc.next().charAt(0);
            Player temp = new Player(name, token);
            players.add(temp);
        }

        System.out.println("Enter Size of Board: ");
        size = sc.nextInt();
        Board b = new Board(size);

        /*
        for (Player p : players) {
            System.out.println(p.name + "--" + p.token);
        }
        b.printBoard();
        */

        boolean result = false;
        int turn = 0;
        int preturn = n-1;

        while(!b.isFull() && !(result=b.checkWin(players.get(preturn).token))) {
            b.printBoard();
            System.out.println(players.get(turn).name+"'s Turn {"+players.get(turn).token+"}");
            System.out.println("Enter a Position to place token: ");
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(b.setChar(x,y,players.get(turn).token)){
                preturn = turn;
                turn = (turn+1)%n;
            } else {
                System.out.println("Invalid Position! Try Again!");
            }
        } 
        if(result){
            
            System.out.println(players.get(preturn).name + " is the Winner!");
        } else {
            System.out.println("TIE");
        }
    }
}
