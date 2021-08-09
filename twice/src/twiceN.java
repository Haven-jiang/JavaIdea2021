import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.BiFunction;

public class twiceN{
    public static void main(String[] args) {
        //do something

    }

    int[] nums = new int[]{23, 27, 12, 19, 3, 9, 8, 5};
    int target = 14;
    HashMap<Integer, Integer> outCome = new HashMap<>();

    @Test
    public void test1() {
        Comparator<Integer> com1 = Integer::compare;
//        TreeSet<Integer> filterNums = new TreeSet<>(com1);
        List<Integer> filterNums = Arrays.asList(23, 27, 12, 19, 3, 9, 8, 5, 2, 11);
        BiFunction<List<Integer>, Integer, HashMap<Integer, Integer>> findOut = (x, y) -> {
            HashMap<Integer, Integer> out = new HashMap<>();
            for (int i = 0 ; i < x.size() - 1 ; i++) {
                Integer inte_a = x.get(i);
                for (int j = 1 ; j < x.size() ; j++) {
                    Integer inte_b = x.get(j);
                    if (y == inte_a + inte_b){
                        out.put(i+1, j+1);
                    }
                }
            }
            return out;
        };
        outCome = findOut.apply(filterNums, target);
        System.out.println(outCome);
    }
}
