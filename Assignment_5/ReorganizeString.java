package INFO6205.Assignment_5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReorganizeString {
    public static String reorganizeString(String str) {
        Map<Character, Integer> hMap = new HashMap<Character, Integer>();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (hMap.containsKey(str.charAt(i))) {
                count = hMap.get(str.charAt(i));
                hMap.put(str.charAt(i), count + 1);
            } else {
                count = 1;
                hMap.put(str.charAt(i), count);
            }
        }
        System.out.println(hMap);
        int strCount = 0;
        char[] chArray = new char[str.length()];
        for (int i = 0; i < str.length() && strCount != str.length(); ) {
            count = 0;
            char ch = getMaximumValueCharacter(hMap);
            System.out.println("ch:" + ch);
            if (hMap.get(ch) > (str.length() + 1) / 2) {
                return "";
            }
            while (i < str.length() && count != hMap.get(ch)) {
                chArray[i] = ch;
                strCount++;
                i = i + 2;
                count++;
                if (i >= str.length()) {
                    i = 1;
                }
            }
            hMap.remove(ch);
            if (i >= str.length()) {
                i = 1;
            }
            System.out.println(Arrays.toString(chArray));
        }
        String output = new String(chArray);
        return output;
    }

    private static char getMaximumValueCharacter(Map<Character, Integer> hMap) {
        int maxValue = 0;
        char ch = ' ';
        for (Map.Entry<Character, Integer> e : hMap.entrySet()) {
            if (e.getValue() > maxValue) {
                maxValue = e.getValue();
                ch = e.getKey();
            }
        }
        return ch;
    }

    public static void main(String[] args) {
        String s = "ogccckcwmbmxtsbmozli";
        System.out.println(reorganizeString(s));
    }
}
