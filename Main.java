import java.util.*;

public class Main {
    public static void main(String[] args) {
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
