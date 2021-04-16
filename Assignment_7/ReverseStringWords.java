package INFO6205.Assignment_7;

public class ReverseStringWords {
    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        StringBuilder output = new StringBuilder("");
        StringBuilder words = new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                words.append(s.charAt(i));
            } else {
                if (words.length() != 0) {
                    if (output.length() == 0) {
                        output = words;
                    } else {
                        output.insert(0, words + " ");
                    }
                }
                words = new StringBuilder();
            }
        }
        if (words.length() != 0) {
            if (output.length() == 0) {
                output = words;
            } else {
                output.insert(0, words + " ");
            }
        }
        return output.toString();
    }

    public static void main(String[] args) {
        String s = "  Bob    Loves  Alice   ";
        System.out.println(reverseWords(s));

    }
}
