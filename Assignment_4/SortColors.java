package INFO6205.Assignment_4;

import java.util.Arrays;

public class SortColors {
    public static void sortColors(int[] nums) {
        int[] range = new int[3];
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            range[nums[i]] += 1;
        }
        for (int i = 0; i < range.length; i++) {
            int count = range[i];
            while (count != 0) {
                nums[k++] = i;
                count--;
            }
        }
    }
    public static void main(String[] args){
        int[] input = {2,0,2,1,1,0};
        sortColors(input);
        System.out.println(Arrays.toString(input));
    }
}
