import java.util.Scanner;

public class SuperString {
    public static void main(String[] arg){
        String[] WordListOne = { "24/7" , "multi-Tier" , "30,000 foot" , "B-to-B" , "win-win" ,
                "front-end" , "web-based" , "pervasive" , "smart" , "six-sigma" , "critical-path" , "dynamic"};
        String[] WordListTwo = { "empowered" , "sticky" , "value-added" , "oriented" , "centric"};
        String[] WordListThree = { "process" , "tipping-point" , "solution" };

        int oneLength = WordListOne.length;
        int twoLength = WordListTwo.length;
        int threeLength = WordListThree.length;

        int rand1 = (int) (Math.random() * oneLength);
        int rand2 = (int) (Math.random() * twoLength);
        int rand3 = (int) (Math.random() * threeLength);

        String phrase = WordListOne[rand1] + WordListTwo[rand2] + WordListThree[rand3];
        System.out.println("What we need is a " + phrase);
    }
}