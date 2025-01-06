package common_class.arrays;

import java.util.Arrays;

interface customComparaotr<Template> {
    int compare(Template a, Template b);
}

public class CustomSort {
    public static void customSort(Integer[] arr, customComparaotr c) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (c.compare(arr[j], arr[j + 1]) > 0) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

    }

    public static void main(String[] args) {
        Integer[] arr = {4, 5, 6, 7, 1, 2, 3, 8, 9};
        customSort(arr, new customComparaotr<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }

        });
        Arrays.binarySearch(arr, 8);
        System.out.println(Arrays.toString(arr));

    }
}

