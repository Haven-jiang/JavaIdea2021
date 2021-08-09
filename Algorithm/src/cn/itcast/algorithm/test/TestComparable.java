package cn.itcast.algorithm.test;
import cn.itcast.algorithm.KMP;
import cn.itcast.algorithm.sort.Student;
import cn.itcast.algorithm.table.SequenceList;
import cn.itcast.algorithm.tree.tread_biTree;
import cn.itcast.algorithm.tree.generalTree;

import static cn.itcast.algorithm.sort.Quick.quickSort;
import static cn.itcast.algorithm.test.SortCompare.*;
import static cn.itcast.algorithm.test.StudentExp.Students;

//2.定义测试类Test,在测试类Test中定义测试方法Comparable getMax(Comparable c1, Comparable c2)完成测试
public class TestComparable {


    public static void main(String[] args) {
//        int insert = 1, i = 1;
//        Student std = new Student("lihua", 15);
//        Students.add(0, Students.get(4));
//        Students.remove(5);

//        System.out.println(selectSort(Students));
//        System.out.println(bubbleSort(Students));
//        System.out.println(insertSort(Students));
//        System.out.println(shellSort(Students, (x, y) -> x.compareTo(y) > 0));
//        System.out.println(mergeSort(Students, new Function.Rev_Sort()));
//        System.out.println(quickSort(Students));
//        System.out.println(Students);
//        System.out.println(insertSort(Students, new Function.Pos_Sort);

        testBubble(Students);//96ms //bad: 215ms
        testMerge(Students);//49ms //bad: 46ms
        testShell(Students);//15ms //bad: 13ms
        testInsert_other(Students);//30ms //bad: 233ms
        testInsert(Students);//21ms //15ms bad: 83ms
        testQuick(Students);//32ms //bad: 10ms
        testSystemSort(Students);//4ms //bad: 5ms

        Student stu = new Student("wanggang", 23);

        SequenceList<Student> se = new SequenceList<>(5);
        se.insert(new Student("liming", 18));
        se.insert(1, new Student("wanggang", 23));
        se.insert(0, stu);
//        se.remove(0);
        int index = se.indexOf(stu);
        System.out.println(index);
        System.out.println(se.get(1));
        System.out.println(se);
        System.out.println(se.length());
        se.clear();
        System.out.println(se.isEmpty());
        System.out.println(se);

//        Recursion fb = new Recursion();
//        fb.reverse();

        String str = "ilove";
        String str_1 = "shabiloveyou";
        KMP kmp = new KMP(str);
        System.out.println(kmp.isSubstring(str_1));

//        Students.forEach(();

        generalTree<Integer> gt = new generalTree<>();
        gt.insert(23);
        generalTree<Integer>.Node<Integer> node = gt.insert(46, 0);
        gt.setChildren(0, node);
        gt.setChildren(0, gt.insert(55, 0));
        gt.setChildren(1, gt.insert(37, 1));
        gt.setChildren(1, gt.insert(38, 1));
        gt.setChildren(2, gt.insert(523, 2));
        System.out.println(gt);
        System.out.println(node);

//        BiTree<Integer> b_tree = new BiTree();
//        b_tree.insert(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
//        b_tree.insert(23);
//        b_tree.insert(null);
//        b_tree.insert(71);
//        b_tree.insert(45);
//        b_tree.insert(221);
//        b_tree.insert(121);
//        b_tree.insert(62);
//        b_tree.for_each();
//        b_tree.preOrderTraverse();
//        b_tree.inOrderTraverse();
//        b_tree.postOrderTraverse();

        tread_biTree<Integer> ct = new tread_biTree<>();
        ct.insert(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        ct.inTread();
        System.out.println(ct);
//        ct.inThreadList();

    }
}
