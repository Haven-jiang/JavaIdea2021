package cn.itcast.algorithm.table;

import java.util.Arrays;

public class SequenceList<T> {
    private int capacity;
    private int N;
    private T[] eles;


    public SequenceList(int capacity){
        this.capacity = capacity;
        this.N = 0;
        eles = (T[]) new Object[capacity];
    }

    public void clear () {
        for (int i = 0; i <= N; i++) {
            eles[i] = null;
        }
    }

    public boolean isEmpty () {
        return eles[0] == null;
    }

    public int length () {
        return N;
    }

    public T get (int i) {
        return eles[i];
    }

    public void insert (T t) {
        if (N+1 <= capacity) eles[N++] = t;
    }

    public void insert (int i, T t) {
        if (N < capacity) {
            for (int j = N; j > i; j--){
                eles[j] = eles[j-1];
            }eles[i] = t;
            N++;
        }
    }

    public T remove (int i) {
        T current = eles[i];
        if (i < N) {
            for (; i < N; i++) {
                eles[i] = eles[i + 1];
            }eles[--N] = null;
            return current;
        }else return null;
    }

    public int indexOf (T t) {
        int index = -1;
        for (int i = 0; i < N; i++) {
            if (eles[i].equals(t)) {
                index = i;
            }
        }return index;
    }

    @Override
    public String toString() {
        return "SequenceList{" +
                "data=" + Arrays.toString(eles) +
                '}';
    }
}
