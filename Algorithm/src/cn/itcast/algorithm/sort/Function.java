package cn.itcast.algorithm.sort;

import java.util.List;
import java.util.function.BiPredicate;

public class Function {

    public static void insertFun (List<Student> students, int i, int j){
        students.add(i, students.get(j));
        students.remove(j+1);
    }

    public static void swap(List<Student> s1, int i, int j) {
        if (i != j) {
            Student Swap_stu = s1.get(i);
            s1.set(i, s1.get(j));
            s1.set(j, Swap_stu);
        }else ;
    }

    public static boolean positive(List<Student> students, int i, int j){
        return students.get(i).getAge() > students.get(j).getAge();
    }
    public static boolean positive(Student stu_1, Student stu_2){
        return stu_1.getAge() > stu_2.getAge();
    }

    public static class Pos_Sort implements BiPredicate<Student, Student> {
        @Override
        public boolean test(Student student_1, Student student_2) {
            return positive(student_1, student_2);
        }
    }

    public static class Rev_Sort implements BiPredicate<Student, Student> {
        @Override
        public boolean test(Student student_1, Student student_2) {
            return positive(student_2, student_1);
        }
    }
}
