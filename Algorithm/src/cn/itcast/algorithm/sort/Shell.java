package cn.itcast.algorithm.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

import static cn.itcast.algorithm.sort.Function.swap;


public class Shell {
    public static List<Student> shellSort (List<Student> students, BiPredicate<Student, Student> bp){
        int shell_h = 1;
        do {
            shell_h = shell_h*2 + 1;
        }while (shell_h < students.size()/2);
//        ArrayList<Student> stus_1 = new ArrayList<>();
//        for (int i = 0; i < students.size() - shell_h-1; i++) {
//            while (i+shell_h <= students.size()-1) {
//                stus_1.add(students.get(i));
//                stus_1.add(students.get(i + shell_h));
//            }
//            Insert.insertSort(stus_1);
//        }
        int i, index = 0;
        while (shell_h >= 1) {
            for (i = shell_h+index; i < students.size(); i += shell_h){
                for (int j = i; j >= shell_h; j -= shell_h){
                    if (bp.test(students.get(j-shell_h), students.get(j)))
                        swap(students, j-shell_h, j);
                    else break;
                }
            }if (i - shell_h < students.size()-1) index++;
            else {
                shell_h /= 2;
                index = 0;
            }
        }
        return students;
    }
}
