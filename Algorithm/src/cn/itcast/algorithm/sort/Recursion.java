package cn.itcast.algorithm.sort;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Recursion {

    private int[] fun = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int index;

    public int fib(int n) {
        if (n < 3) return n == 0 ? 0 : 1;
        else return fib(n - 1) + fib(n - 2);
    }
    
    public void reverse() {
        char result = 0;
        try {
            result = (char) System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (result != '#') reverse();
        if (result != '#') System.out.print(result);;
    }

    public void hanoiTower(int n, char x, char y, char z) {
        if (n == 1) System.out.println(x + "->" + z);
        else {
            hanoiTower(n - 1, x, z, y);
            System.out.println(x + "->" + z);
            hanoiTower(n - 1, y, x, z);
        }
    }

    public boolean isTure(int x, int y) {
        for (int y_test = 0; y_test < y; y_test++) if (fun[y_test] == x || Math.abs(x - fun[y_test]) == Math.abs(y - y_test)) return false;
        return true;
    }

    public void eig_Queen(int y) {
        if (y > 7) print_chess(++index);
        for (int x = 0; x < 8; x++) {
            if (isTure(x, y)) {
                fun[y] = x;
                eig_Queen(y + 1);
            }
        }
    }

    private void print_chess(int ind) {
        System.out.println("第" + ind + "种: ");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < fun[i]; j++) System.out.print("* ");
            System.out.print("Q ");
            for (int j = 0; j < 7 - fun[i]; j++) System.out.print("* ");
            System.out.println();
        }
    }

    @Test
    public void test() {
//        for (int i = 0; i < 41; i++) System.out.println(fib(i));
//        reverse();
//        hanoiTower(20, 'x', 'y', 'z');
        eig_Queen(0);
    }
}


