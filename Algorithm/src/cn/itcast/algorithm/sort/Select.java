package cn.itcast.algorithm.sort;

import java.util.List;
import java.util.function.BiPredicate;

import static cn.itcast.algorithm.sort.Function.swap;

public class Select {
    public static List<Student> selectSort(List<Student> students, BiPredicate<Student, Student> bp){
        for (int j = 0; j < students.size() - 1; j++) {
            int max_index = 0;
            for (int i = 0; i < students.size() - j; i++) {
                if (bp.test(students.get(i), students.get(max_index)))
                    max_index = i;
            }
            swap(students, max_index, students.size() - j - 1);
        }
        return students;
    }
}
