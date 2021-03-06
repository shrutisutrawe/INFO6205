package INFO6205.Assignment_5;

import java.util.Arrays;

public class CountOnes {
    public static int countOnesInBinaryArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int count = 0;
        if (arr[0] == 1 && arr[arr.length - 1] == 1) {
            return arr.length;
        }
        count = countOnesInBinaryArray(arr, 0, arr.length - 1);
        return count;
    }

    private static int countOnesInBinaryArray(int[] arr, int low, int high) {
        if (low > high) {
            return 0;
        }
        int mid = (low + high) / 2;
        if (arr[low] == 1) {
            if (arr[mid] < 1) {
                return countOnesInBinaryArray(arr, low, mid - 1);
            } else if (arr[mid] > 1) {
                return countOnesInBinaryArray(arr, mid + 1, high);
            } else {
                return 1 + countOnesInBinaryArray(arr, low, mid - 1) + countOnesInBinaryArray(arr, mid + 1, high);
            }
        } else {
            if (arr[mid] < 1) {
                return countOnesInBinaryArray(arr, mid + 1, high);
            } else if (arr[mid] > 1) {
                return countOnesInBinaryArray(arr, low, mid - 1);
            } else {
                return 1 + countOnesInBinaryArray(arr, low, mid - 1) + countOnesInBinaryArray(arr, mid + 1, high);
            }
        }
    }

    public static void main(String[] args) {
        int[] A = {0, 0, 0, 0, 0, 1, 1};
        System.out.println(Arrays.toString(A));
        System.out.println(countOnesInBinaryArray(A));
    }
}
