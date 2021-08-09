package cn.itcast.algorithm.table;

public class Link {
    class link <T>{
        T data;
        link next;
    }

    private link head;

    public void InitLink (int length) {
        head = new link();
        for (int i = 0; i < length; i++)
        head.next = new link();
    }
}
