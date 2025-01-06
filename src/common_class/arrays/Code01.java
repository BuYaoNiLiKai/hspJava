package common_class.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class Code01 {
    public static void main(String[] args) {
        Integer[] arr = {1, 4, 3, 2, 5};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(Arrays.toString(arr));
    }
}
