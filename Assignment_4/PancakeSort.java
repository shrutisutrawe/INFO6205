package INFO6205.Assignment_4;

import java.util.ArrayList;
import java.util.List;

public class PancakeSort {
    public static List<Integer> pancakeSort(int[] arr) {
        if (isSorted(arr)) {
            return new ArrayList<>();
        }
        List<Integer> output = new ArrayList<>();
        while (!isSorted(arr)) {
            for (int i = arr.length; i > 0; i--) {
                int k = findK(arr, i);
                if (k == i - 1)
                    continue;
                if (k != 0) {
                    output.add(k + 1);
                    reverse(arr, k + 1);
                }
                output.add(i);
                reverse(arr, i);
            }
        }
        return output;
    }

    protected static void reverse(int[] arr, int k) {
        int i = 0;
        while (i < k / 2) {
            int temp = arr[i];
            arr[i] = arr[k - i - 1];
            arr[k - i - 1] = temp;
            i++;
        }
    }

    protected static boolean isSorted(int[] arr) {
        for (int i = 0; i + 1 < arr.length; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    protected static int findK(int[] arr, int index) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == index) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] input = {3, 2, 4, 1};
        System.out.println(pancakeSort(input).toString());
    }
}
