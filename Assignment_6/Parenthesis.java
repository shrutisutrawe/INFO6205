package Assignment_6;

import java.util.ArrayList;
import java.util.List;

public class Parenthesis {
    public static List<String> finalResult = new ArrayList<>();

    public static List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        int current = 0;
        String strings = new String();
        int count1 = 0, count2 = 0;
        generateParenthesis(strings, n, count1, count2);
        System.out.println("final:" + finalResult);
        return finalResult;
    }

    private static void generateParenthesis(String strings, int n, int count1, int count2) {
        if (strings.length() == 2 * n) {
            System.out.println("one:" + strings);
            finalResult.add(strings);
            return;
        }
        for (int i = 0; i < 2; i++) {
            if (i == 0 && count1 < n) {
                generateParenthesis(strings + "(", n, count1 + 1, count2);
            } else if (i == 1 && count2 < count1) {
                generateParenthesis(strings + ")", n, count1, count2 + 1);
            }
        }
        return;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(1));
    }
}
