package cn.itcast.algorithm.tree;
import java.util.ArrayList;
import java.util.Scanner;

public class BiTree<ElemType> {

    public class Tree<ElemType> {
        ElemType data;
        int parent;
        Tree<ElemType> l_child;
        Tree<ElemType> r_child;

        public Tree() {}

        public Tree(ElemType data) {
            this.data = data;
        }

        public Tree(ElemType data, int parent) {
            this.data = data;
            this.parent = parent;
        }

        @Override
        public String toString() {
            return "Tree{" +
                    "data=" + data +
//                    ", l_child=" + l_child +
//                    ", r_child=" + r_child +
                    '}';
        }
    }

    private ArrayList<Tree<ElemType>> bi_tree;
    int rear = 0;
    int temp = -1;

    public BiTree() {
        bi_tree = new ArrayList<>();
    }

    public void insert(ElemType data) {
        bi_tree.add(new Tree<>(data, -1));
        if (rear != 0) {
            if (rear % 2 == 0) {
                bi_tree.get(rear).parent = (rear - 1) / 2;
                bi_tree.get((rear - 1) / 2).r_child = bi_tree.get(rear);
            }
            else {
                bi_tree.get(rear).parent = rear / 2;
                bi_tree.get(rear / 2).l_child = bi_tree.get(rear);
            }
        }rear++;
    }

    public void insert(ElemType[] data_s) {
        for (ElemType data : data_s) insert(data);
    }

//    public Tree<ElemType> preOrderInsert(ElemType[] data, int index) {
//        Tree<ElemType> root = null;
//        if (index < data.length) {
//            if (index == 0) root = new Tree<>(data[index], -1);
//            else root = new Tree<>(data[index], index % 2 == 0 ? (index - 1) / 2 : index / 2);
//            root.l_child = preOrderInsert(data, 2 * index + 1);
//            root.r_child = preOrderInsert(data, 2 * index + 2);
//            bi_tree.add(root);
//        }
//        return root;
//    }

    public void preOrderTraverse() {
        System.out.println("-----------prologue_foreach-----------");
        preOrderTraverse(bi_tree.get(0));
        System.out.println("------------------end------------------\n");
    }

    private void preOrderTraverse(Tree<ElemType> root) {
        if (root == null) return;
        System.out.println(root);
        preOrderTraverse(root.l_child);
        preOrderTraverse(root.r_child);
    }

    public void inOrderTraverse() {
        System.out.println("-----------middle_foreach-----------");
        inOrderTraverse(bi_tree.get(0));
        System.out.println("-----------------end-----------------\n");
    }

    private void inOrderTraverse(Tree<ElemType> root) {
        if (root == null) return;
        inOrderTraverse(root.l_child);
        System.out.println(root);
        inOrderTraverse(root.r_child);
    }

    public void postOrderTraverse() {
        System.out.println("-------------post_foreach-------------");
        postOrderTraverse(bi_tree.get(0));
        System.out.println("-----------------end-----------------\n");
    }

    private void postOrderTraverse(Tree<ElemType> root) {
        if (root == null) return;
        postOrderTraverse(root.l_child);
        postOrderTraverse(root.r_child);
        System.out.println(root);
    }

    public void for_each() {
        System.out.println("-------------foreach-------------");
        for (Tree<ElemType> tree :
                bi_tree) {
            System.out.println(tree);
        }
        System.out.println("----------------end----------------");
    }
}
