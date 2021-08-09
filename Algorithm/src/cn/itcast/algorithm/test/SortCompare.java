package cn.itcast.algorithm.test;

import cn.itcast.algorithm.sort.Function;
import cn.itcast.algorithm.sort.Student;

import static cn.itcast.algorithm.sort.Bubble.bubbleSort;
import static cn.itcast.algorithm.sort.Insert.insertSort;
import static cn.itcast.algorithm.sort.Insertion_other.insert_otherSort;
import static cn.itcast.algorithm.sort.Merge.mergeSort;
import static cn.itcast.algorithm.sort.Quick.quickSort;
import static cn.itcast.algorithm.sort.Shell.shellSort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortCompare {
    public static void testShell(List<Student> students){
        long start = System.currentTimeMillis();
        for (int i = 0; i < 3; i++) {
            shellSort(students, new Function.Pos_Sort());
            shellSort(students, new Function.Rev_Sort());
        }long end = System.currentTimeMillis();
        System.out.println("shellSort :" + (end - start) + "ms");
    }

    public static void testInsert(List<Student> students){
        long start = System.currentTimeMillis();
        for (int i = 0; i < 3; i++) {
            insertSort(students, new Function.Pos_Sort());
            insertSort(students, new Function.Rev_Sort());
        }long end = System.currentTimeMillis();
        System.out.println("mineSort :" + (end - start) + "ms");
    }

    public static void testMerge(List<Student> students){
        long start = System.currentTimeMillis();
        for (int i = 0; i < 3; i++) {
            mergeSort(students, new Function.Pos_Sort());
            mergeSort(students, new Function.Rev_Sort());
        }long end = System.currentTimeMillis();
        System.out.println("mergeSort :" + (end - start) + "ms");
    }

    public static void testBubble(List<Student> students){
        long start = System.currentTimeMillis();
        for (int i = 0; i < 3; i++) {
            bubbleSort(students, new Function.Pos_Sort());
            bubbleSort(students, new Function.Rev_Sort());
        }long end = System.currentTimeMillis();
        System.out.println("bubbleSort :" + (end - start) + "ms");
    }

    public static void testInsert_other(List<Student> students){
        long start = System.currentTimeMillis();
        for (int i = 0; i < 3; i++) {
            insert_otherSort(students, new Function.Pos_Sort());
            insert_otherSort(students, new Function.Rev_Sort());
        }long end = System.currentTimeMillis();
        System.out.println("insertSort :" + (end - start) + "ms");
    }

    public static void testQuick(List<Student> students){
        long start = System.currentTimeMillis();
        for (int i = 0; i < 3; i++) {
            quickSort(students, new Function.Pos_Sort());
            quickSort(students, new Function.Rev_Sort());
        }long end = System.currentTimeMillis();
        System.out.println("quickSort :" + (end - start) + "ms");
    }

    public static void testSystemSort(List<Student> students){
        long start = System.currentTimeMillis();
        for (int i = 0; i < 3; i++) {
            Collections.sort(students, Comparator.naturalOrder());
            Collections.sort(students, Comparator.reverseOrder());
        }long end = System.currentTimeMillis();
        System.out.println("systemSort :" + (end - start) + "ms");
    }
}
