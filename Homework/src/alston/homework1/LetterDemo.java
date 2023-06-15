package alston.homework1;

import java.util.HashMap;

public class LetterDemo {

    public static int getSumOfLetters(String letters) {
        /* 驗證是否為英文字母 */
        if (!letters.matches("[a-zA-Z]6+")) {
            return 0;
        }

        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= 25; i++) {
            map.put(str.substring(i, i + 1), (i + 1));
        }
        map.replace("A", 10);

        int sum = 0;
        for (char letter : letters.toCharArray()) {
            letter = Character.toUpperCase(letter);
            sum = sum + map.get(String.valueOf(letter));
        }

        return sum;
    }

}