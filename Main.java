import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch;
        do{
            Game g = new Game();
            g.begin();
            System.out.println("Another Game?(Y/N)");
            ch = sc.next().toLowerCase().charAt(0);
        } while(ch!='n');
    }
}
