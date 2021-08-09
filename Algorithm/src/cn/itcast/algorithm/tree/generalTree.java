package cn.itcast.algorithm.tree;

import java.util.ArrayList;

public class generalTree<ElemType> {

    public class Node<ElemType> {
        ElemType data;
        int parents;
        ArrayList<Node<ElemType>> children = new ArrayList<>();

        @Override
        public String toString() {
            return '{' +
                    "data=" + data +
                    ", parents=" + parents +
                    ", child=" + children +
                    '}';
        }
    }

    private ArrayList<Node<ElemType>> nodes;
    private int temp = 0;
    private final int root = 0;

    public generalTree() {
        nodes = new ArrayList<>();
    }

    public Node<ElemType> insert(ElemType data) {
        nodes.add(new Node<>());
        if (temp == 0) nodes.get(temp).parents = -1;
        nodes.get(temp++).data = data;
        Node<ElemType> elemTypeNode = nodes.get(temp - 1);
        return elemTypeNode;
    }

    public Node<ElemType> insert(ElemType data, int parent) {
        if (temp == 0) parent = -1;
        nodes.add(new Node<>());
        nodes.get(temp).data = data;
        nodes.get(temp++).parents = parent;
        Node<ElemType> elemTypeNode = nodes.get(temp - 1);
        return elemTypeNode;
    }

    public Node<ElemType> insert(ElemType data, int parent, int child) {
        if (temp == 0) parent = -1;
        nodes.add(new Node<>());
        nodes.get(temp).data = data;
        nodes.get(temp).children.add(nodes.get(child));
        nodes.get(temp++).parents = parent;
        Node<ElemType> elemTypeNode = nodes.get(temp - 1);
        return elemTypeNode;
    }

    public void setChildren(int point, int child) {
        nodes.get(point).children.add(nodes.get(child));
    }

    public void setChildren(int point, Node<ElemType> child) {
        nodes.get(point).children.add(child);
    }

    public ArrayList<Node<ElemType>> getChildren(int point) {
        return nodes.get(point).children;
    }

    public void setParent(int point, int parent) {
        nodes.get(point).parents = parent;
    }

    public int getParent(int point) {
        return nodes.get(point).parents;
    }

    @Override
    public String toString() {
        String str = "tree: {\n";
        int i = 0;
        for (Node<ElemType> node : nodes) {
            str = str + "\tnode: " + i++ + ' ';
            str += node.toString();
            str += '\n';
        }
        str += "}";
        return str;
    }
}
