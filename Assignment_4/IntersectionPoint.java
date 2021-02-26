package INFO6205.Assignment_4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionPoint {
    public static int[] getIntersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length ==
                0) {
            return new int[0];
        }
        Set<Integer> set1 = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        Set<Integer> set2 = new HashSet<Integer>();
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }
        List<Integer> result = new ArrayList<>();
        for (Integer i : set1) {
            if (set2.contains(i)) {
                result.add(i);
            }
        }
        int[] finalResult = new int[result.size()];
        for (int i = 0; i < finalResult.length; i++) {
            finalResult[i] = result.get(i);
        }
        return finalResult;
    }

    public static void main(String[] args) {
        int[] A = {9, 4, 9, 8, 4};
        int[] B = {4, 9, 5};
        int[] result = getIntersection(A, B);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }

    }
}
