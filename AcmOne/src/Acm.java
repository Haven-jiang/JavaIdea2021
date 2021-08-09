import java.util.ArrayList;
import java.util.Scanner;

public class Acm {
    public static void main(){
        Scanner input = new Scanner(System.in);

        ArrayList<Integer> listOfNumbers = new ArrayList<Integer>();
        int Int1 = input.nextInt();
        do{
            listOfNumbers.add(Int1 % 2);
            Int1 /= 2;
        }while(Int1 > 0);
        System.out.println(listOfNumbers);
    }
}
