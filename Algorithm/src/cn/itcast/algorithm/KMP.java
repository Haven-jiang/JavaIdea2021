package cn.itcast.algorithm;

public class KMP {
    private char[] string;
    private int[] next;

    public KMP(String string) {
        this.string = string.toCharArray();
        next = new int[string.length()];
    }

    private int getNext_data(int k) {
        int x = 0, y, next_data = 0;
        if (k == 0) return -1;
        for (y = 1; y < k; y++, x++) {
            if (string[x] == string[y]) next_data++;
            else {
                next_data = 0;
                x = -1;
            }
        }
        return next_data;
    }

    public int[] getNext() {
        for (int i = 0; i < string.length; i++) next[i] = getNext_data(i);
        return next;
    }

    public boolean isSubstring(String str) {
        char[] string_1 = str.toCharArray();
        if (string_1.length < string.length) return false;
        getNext();
        int i = 0;
        boolean isSub = true;
        for (int j = 0; j < string.length; j++, i++) {
            if (j > string_1.length - 1) {
                isSub = false;
                break;
            }
            if (string_1[i] == string[j]) continue;
            else {
                if (next[j] == -1) j--;
                else {
                    j = next[j] - 1;
                    i--;
                }
            }
        }
        return isSub;
    }
}
