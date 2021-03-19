package Assignment_6;

import java.util.Arrays;
import java.util.Stack;

public class Asteroids {
    public static int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length == 0) {
            return null;
        }
        if (asteroids.length == 1) {
            return asteroids;
        }
        Stack<Integer> myStack = new Stack<>();
        int top = 0;
        myStack.push(asteroids[0]);
        for (int i = 1; i < asteroids.length; i++) {
            if (myStack.isEmpty()) {
                myStack.push(asteroids[i]);
                continue;
            }
            while (!myStack.isEmpty()) {
                top = myStack.peek();
                if ((top > 0 && asteroids[i] > 0) || (top < 0 && asteroids[i] < 0) || (top < 0 && asteroids[i] > 0)) {
                    myStack.push(asteroids[i]);
                    break;
                }
                if (top > 0 && asteroids[i] < 0) {
                    if (Math.abs(top) > Math.abs(asteroids[i])) {
                        break;
                    } else if (Math.abs(top) == Math.abs(asteroids[i])) {
                        myStack.pop();
                        break;
                    } else {
                        myStack.pop();
                        if (myStack.isEmpty()) {
                            myStack.push(asteroids[i]);
                            break;
                        }
                    }
                }
            }
        }
        int[] result = new int[myStack.size()];
        for (int i = result.length - 1; i >= 0 && !myStack.isEmpty(); i--) {
            result[i] = myStack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {1, -1, -2, -2};
        int[] res = asteroidCollision(A);
        System.out.println(Arrays.toString(res));
    }
}
