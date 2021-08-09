import java.util.Scanner;

public class Samp {
    public static void main(String[] arg){
        double foot;
        double inch;
        Scanner io = new Scanner(System.in);
        foot = io.nextDouble();
        inch = io.nextDouble();
        System.out.println((foot + inch / 12) * 0.3048);
    }
}
