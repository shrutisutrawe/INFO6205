package INFO6205.Assignment_4;

public class SmallestElement {
    static boolean flag = false;
    static int temp1 = 0;

    public static int findKthSmallest(int[] nums, int k) {
        if (nums.length == 0 || k > nums.length) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        quickSort(nums, 0, nums.length - 1, k);
        return temp1;
    }

    private static int quickSort(int[] input, int low, int high, int k) {
        if (flag) {
            return 0;
        }
        if (low == high && low >= 0) {
            if (low == k - 1) {
                flag = true;
                temp1 = input[low];

            }
            return input[low];
        }
        int pivot = 0;
        if (low < high) {
            pivot = partition(input, low, high);
            if (pivot == k - 1) {
                flag = true;
                temp1 = input[pivot];
                return pivot;
            }
            quickSort(input, low, pivot - 1, k);
            if (flag) {
                return pivot;
            }
            quickSort(input, pivot + 1, high, k);
        }
        return pivot;
    }

    private static int partition(int[] input, int low, int high) {
        int wall = low - 1;
        int pivot = input[high];
        for (int i = low; i < high; i++) {
            if (input[i] < pivot) {
                wall++;
                int temp = input[i];
                input[i] = input[wall];
                input[wall] = temp;
            }
        }
        wall++;
        int temp = input[high];
        input[high] = input[wall];
        input[wall] = temp;
        return wall;
    }

    public static void main(String[] args) {
        int[] input = {8, 7};
        System.out.println(findKthSmallest(input, 2));
    }
}
