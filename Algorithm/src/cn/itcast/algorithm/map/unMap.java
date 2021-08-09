package cn.itcast.algorithm.map;

import java.util.Arrays;

public class unMap {
    private char[] vertex;
    private int[][] side;

    /**
     * Define the vertices in the graph
     * @param new_vertex the array of vertex
     */
    public unMap(char[] new_vertex) {
        int index = 0;
        this.vertex = new char[new_vertex.length];
        this.side = new int[new_vertex.length][new_vertex.length];
        vertex = new_vertex;
        for (char ver : new_vertex) Arrays.fill(side[index++], 0);
    }

    /**
     * Pass in the int array to define the edge directly
     * @param side int array
     */
    public void setSide(int[][] side) {
        this.side = side;
    }

    /**
     * Incoming even-numbered vertex are connected in pairs
     * @param line even-numbered vertex
     */
    public void setSide(char[] line) {
        if (line.length % 2 != 0) return;
        int index_x = 0, index_y = 0;
        for (int x = 0; x < line.length; x++) {
            for (index_y = 0; index_y < vertex.length; index_y++) {
                if (x % 2 == 0) if (line[x] == vertex[index_y]) {
                    index_x = index_y;
                    break;
                }if (x % 2 == 1) if (line[x] == vertex[index_y]) {
                    side[index_x][index_y] = side[index_y][index_x] =  1;
                    break;
                }else if (index_y == vertex.length - 1) return;
            }
        }
    }

    public StringBuilder getDegree() {
        StringBuilder degree_str = new StringBuilder();
        for (int index = 0; index < vertex.length; index++) degree_str.append(vertex[index]).append(": ").append(getDegree(index)).append(' ');
        return degree_str;
    }

    public int getDegree(char vertex) {
        int index = 0;
        for (char ver :
                this.vertex) {
            if (ver == vertex) break;
            else index++;
        }

        return getDegree(index);
    }

    public int getDegree(int index) {
        int degree = 0;
        for (int num : this.side[index]) if (num == 1) degree++;
        return degree;
    }

    @Override
    public String toString() {
        StringBuilder side_str = new StringBuilder().append(' ');
        int index = 0;
        for (char str : vertex) side_str.append("  ").append(str);
        side_str.append('\n');
        for (int[] side_pro : side) side_str.append(vertex[index++]).append(' ').append(Arrays.toString(side_pro)).append('\n');
        return "unMap{" + '\n' + side_str +
                "degree: \n\t" + getDegree() + "\n}";
    }

    public static void main(String[] args) {
        unMap un = new unMap(new char[]{'a', 'b', 'c', 'd', 'v', 'o'});
        un.setSide(new char[]{'a', 'd', 'c', 'b', 'b', 'd', 'a', 'o'});
        System.out.println(un);
        //test

    }
}
