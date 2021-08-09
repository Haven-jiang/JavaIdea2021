//package hello;

//import java.util.Scanner;

import java.util.Scanner;

public class Hello {

    public static void main(String[] args){
        System.out.println("Hello!");
        java.util.Scanner in = new Scanner(System.in);
//        System.out.println("echo: " + in.nextLine());
        System.out.print("Please input amount:");
        int amount = in.nextInt();
        System.out.print("Please input price: ");
        int price = in.nextInt();
        System.out.print(amount + "-" + price + '=' + (amount - price));
    }
}
