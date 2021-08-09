import java.util.ArrayList;
import java.util.Scanner;

public class Acm {
    public int iCount;
    ArrayList<Integer> listOfNumbers = new ArrayList<>(8);

    public static void main(String[] args) {
        Acm a1 = new Acm();
        a1.getBinary();
        a1.getList();
    }

    public void getList() {
        if (listOfNumbers.size() < 8) {
            int max = listOfNumbers.size();
            for (int i = 0; i < 8 - max; i++) listOfNumbers.add(0);
        }
        for (iCount = 3; iCount <= 6; iCount++) System.out.print(listOfNumbers.get(iCount) + " ");
    }

    public void getBinary(){
        Scanner input = new Scanner(System.in);
        int Int1 = input.nextInt();
        do {
            listOfNumbers.add(Int1 % 2);
            Int1 /= 2;
        } while (Int1 > 0);
    }
}
