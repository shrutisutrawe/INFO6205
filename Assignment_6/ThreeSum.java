package Assignment_6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultTriplet = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return resultTriplet;
        }
        Arrays.sort(nums);
        int j = 0, k = 0;
        int i = 0;
        int temp1 = 0, temp2 = 0, temp3 = 0;
        while (i < nums.length - 1) {

            int x = nums[i];
            j = i + 1;
            k = nums.length - 1;
            while (j < nums.length - 1 && k > j) {
                if (nums[j] + nums[k] + x == 0) {
                    List<Integer> result = new ArrayList<>();
                    result.add(x);
                    result.add(nums[j]);
                    result.add(nums[k]);
                    resultTriplet.add(result);
                    temp2 = nums[j];
                    j++;
                    while (j < nums.length - 1 && nums[j] == temp2) {
                        temp2 = nums[j];
                        j++;
                    }

                } else if (nums[j] + nums[k] + x > 0) {
                    temp3 = nums[k];
                    k--;
                    while (k > j && nums[k] == temp3) {
                        temp3 = nums[k];
                        k--;
                    }

                } else {
                    temp2 = nums[j];
                    j++;
                    while (j < nums.length - 1 && nums[j] == temp2) {
                        temp2 = nums[j];
                        j++;
                    }
                }
            }
            temp1 = nums[i];
            i++;
            while (i < nums.length && nums[i] == temp1) {
                temp1 = nums[i];
                i++;
            }
        }
        return resultTriplet;
    }

    public static void main(String[] args) {
        int[] A = {-2, 0, 1, 1, 2};
        System.out.println(threeSum(A));
    }
}
