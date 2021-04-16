package INFO6205.Assignment_7;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String output = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(output) != 0) {
                output = output.substring(0, output.length() - 1);
                if (output.isEmpty()) {
                    return "";
                }
            }
        }
        return output;
    }

    public static void main(String[] args) {
        String[] str = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(str));
    }
}
