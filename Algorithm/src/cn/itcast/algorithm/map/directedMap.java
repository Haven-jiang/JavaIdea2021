package cn.itcast.algorithm.map;

public class directedMap {
    private class vertex {
        vertex direct;
        String ver_str;

        vertex(String str) {
            this.ver_str = str;
        }

        vertex() {}
    }
    private vertex[] ver_node;
    private int temp = 0;
    private int length = 0;

    directedMap(int length) {
        ver_node = new vertex[length];
        this.length = length;
    }

    directedMap(String[] strings) {
        ver_node = new vertex[strings.length];
        this.length = strings.length;
        for (String str : strings) insert(str);
    }

    public void insert(String str) {
        if (temp > length - 1) return;
        ver_node[temp++].ver_str = str;
    }

    public void setLine(String[] strings) {
        if (strings.length % 2 != 0) return;
        int index_x = -1, index_y;
        for (int i = 0; i < strings.length; i++) {
            for (index_y = 0; index_y < ver_node.length; index_y++) {
                if (i % 2 == 0) if (strings[i] == ver_node[index_y].ver_str) {
                    index_x = index_y;
                    break;
                }if (i % 2 == 1) if (strings[i] == ver_node[index_y].ver_str) {
                    ver_node[index_x].direct = ver_node[index_y];
                    break;
                }
            }
            if (index_y == ver_node.length) return;
        }
    }
}
