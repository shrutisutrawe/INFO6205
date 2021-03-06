package INFO6205.Assignment_5;

public class PeakIndex {
    public static int peakIndexInMountainArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int i = 0;
        while (i + 1 < arr.length) {
            if (arr[i] > arr[i + 1]) {
                break;
            }
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] A = {0, 1, 2, 3, 2};
        System.out.println(peakIndexInMountainArray(A));
    }
}
