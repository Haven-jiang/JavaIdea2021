package cn.itcast.algorithm.sort;

import java.util.List;
import java.util.function.BiPredicate;

public class Quick {
    public static List<Student> quickSort(List<Student> students, BiPredicate<Student, Student> bp){
        int low = 0, high = students.size() - 1;
        quickSort(students, low, high, bp);
        return students;
    }

    public static List<Student> quickSort(List<Student> students, int low, int high, BiPredicate<Student, Student> bp){
        if (low >= high) return students;
        int mid = partition(students, low, high, bp);
        quickSort(students, low, mid-1, bp);
        quickSort(students, mid+1, high, bp);
        return students;
    }
    
    private static int partition (List<Student> students, int low, int high, BiPredicate<Student, Student> bp) {
        int left = low, right = high + 1;
        Student s1 = students.get(low);
        while (true){
            while (bp.test(students.get(--right), s1)) if (left >= right) break;
            while (bp.test(s1, students.get(++left))) if (left >= right) break;
            if (left >= right) break;
            else Function.swap(students, left, right);
        }
        Function.swap(students, low, right);
        return right;
    }
}
