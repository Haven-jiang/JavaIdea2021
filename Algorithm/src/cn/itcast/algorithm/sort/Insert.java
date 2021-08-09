package cn.itcast.algorithm.sort;

import java.util.List;
import java.util.function.BiPredicate;

public class Insert {
    public static List<Student> insertSort (List<Student> students, BiPredicate<Student, Student> bp){
        for (int insert = 0; insert < students.size() - 1; insert++) {
            if (bp.test(students.get(insert), students.get(insert+1)) && insert != 0) {
                for (int i = 1; i <= insert; i++) {
                    if (bp.test(students.get(insert), students.get(insert+1)) && (insert - 1) != 0) continue;
                    else {
                         Function.insertFun(students, insert+1-i, insert+1);
                        break;
                    }
                }
            } else if (bp.test(students.get(insert), students.get(insert+1))) Function.swap(students, insert, insert + 1);
            else ;
        }
        return students;
    }
}
