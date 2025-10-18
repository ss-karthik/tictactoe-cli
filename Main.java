import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Game Instructions
        System.out.println("Tic-Tac-Toe");
        System.out.println();
        System.out.println("----------");
        System.out.println("INSTRUCTIONS");
        System.out.println("- Enter the number of players and select a symbol on the keyboard as a token to represent the player on the board");
        System.out.println("- Enter a single number to determine the size of the board. (Example: A board of size 3 would result in a 3x3 grid)");
        System.out.println("- All the players will take turns and place their tokens on the board by specifying the row and column numbers of the grid cell");
        System.out.println("- The first player to reach an unbroken line of tokens(horizontal, vertical, principal diagonal) wins the game");
        System.out.println("- In case the board is full of tokens and none of the players have an unbroken line, it results in a Tie");
        System.out.println("----------");
        
        System.out.println();
        System.out.println("May the force be with you!");
        System.out.println();

        

        Scanner sc = new Scanner(System.in);
        char ch;
        //Entry Point
        //A loop that allows user to choose to restart or quit the game
        do{
            //Game object - Contains the entire game logic
            Game g = new Game();
            g.begin();
            System.out.println("Another Game?(Y/N)");
            ch = sc.next().toLowerCase().charAt(0);
        } while(ch!='n');
    }
}
