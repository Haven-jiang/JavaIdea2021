package cn.itcast.algorithm.sort;

import java.util.List;
import java.util.function.BiPredicate;

import static cn.itcast.algorithm.sort.Function.swap;

public class Bubble {

    public static List<Student> bubbleSort (List<Student> l1, BiPredicate<Student, Student> bp){
        for (int i = 0; i < l1.size() - 1; i++){
            for (int j = i + 1; j < l1.size(); j++){
                if (bp.test(l1.get(i), l1.get(j))) swap(l1, i, j);
            }
        }return l1;
    }
}
