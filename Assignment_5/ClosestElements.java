package INFO6205.Assignment_5;

import java.util.*;

public class ClosestElements {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr == null || arr.length == 0 || k > arr.length) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        Stack<Integer> smallerStack = new Stack<>();
        Queue<Integer> largerStack = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= x) {
                smallerStack.push(arr[i]);
            } else if (arr[i] > x) {
                largerStack.add(arr[i]);
            }
        }

        while (k > 0) {
            if ((!smallerStack.isEmpty() && !largerStack.isEmpty())) {
                if ((Math.abs(smallerStack.peek() - x)) <= (Math.abs(largerStack.peek() - x))) {
                    result.add(smallerStack.pop());
                } else if ((Math.abs(smallerStack.peek() - x)) > (Math.abs(largerStack.peek() - x))) {
                    result.add(largerStack.remove());
                }
            } else if (!smallerStack.isEmpty()) {
                result.add(smallerStack.pop());
            } else if (!largerStack.isEmpty()) {
                result.add(largerStack.remove());
            }
            k--;
        }

        Collections.sort(result);
        System.out.println(Arrays.toString(result.toArray()));
        return result;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(A));
        List<Integer> result = findClosestElements(A, 4, 3);
        System.out.println(Arrays.toString(result.toArray()));
    }
}

