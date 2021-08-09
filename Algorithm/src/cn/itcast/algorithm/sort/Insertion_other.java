package cn.itcast.algorithm.sort;

import java.util.List;
import java.util.function.BiPredicate;

public class Insertion_other {
    public static List<Student> insert_otherSort(List<Student> students, BiPredicate<Student, Student> bp){
        for(int i = 1; i < students.size(); i++){
            for (int j = i; j > 0; j--) {
                if (bp.test(students.get(j-1), students.get(j))) Function.swap(students, j-1, j);
                else break;
            }
        }return students;
    }
}
