package cn.itcast.algorithm.sort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

public class Merge {
    private static ArrayList<Student> asslist;

    public static List<Student> mergeSort (List<Student> students, BiPredicate<Student, Student> bp){
        asslist = new ArrayList<>();
        int lo = 0;int hi = students.size() - 1;
        List<Student> students1 = mergeSort(students, lo, hi, bp);
        return students;
    }

    private static List<Student> mergeSort (List<Student> students, int lo, int hi, BiPredicate<Student, Student> bp){
        if (hi <= lo) return students;

        //分组
        int mid = lo + (hi - lo) / 2;
        //排序
        List<Student> students1 = mergeSort(students, lo, mid, bp);
        List<Student> students2 = mergeSort(students, mid+1, hi, bp);
        //归并
        merge(students, lo, mid, hi, bp);
        return students;
    }

    private static void merge (List<Student> students, int lo, int mid, int hi, BiPredicate<Student, Student> bp){
        int re_i = lo, re_j = hi, def_mid = mid+1;
        for (int i = re_i; i <= re_j; i++){
            if (lo < def_mid && mid+1 < hi+1){
                if (bp.test(students.get(lo), students.get(mid+1))) asslist.add(students.get(++mid));
                else asslist.add(students.get(lo++));
            }else if (lo == def_mid) asslist.add(students.get(++mid));
            else asslist.add(students.get(lo++));
        }re_stu(students, re_i, re_j);
        students.addAll(re_i, asslist);
        asslist.clear();
    }

    private static void re_stu (List<Student> students, int i, int j){
        for (int a = i; a <= j; a++) {
            students.remove(i);
        }
    }
}
