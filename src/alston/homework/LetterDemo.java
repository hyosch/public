package alston.homework;

public class LetterDemo {

    public static void main(String[] args) {
        System.out.println(getSumOfLetters("I"));
    }
    public static int getSumOfLetters(String letters) {

        // 驗證是否為英文字母
        if (!letters.matches("[a-zA-Z]+")) {
            return 0;
        }
        int sum = 0;
        int number = 0;

        //  轉大寫，讓相同大小寫對應的數值相等
        //  透過 ASCII，計算出字母對應的位置
        for (char letter : letters.toCharArray()) {
            letter = Character.toUpperCase(letter);
            number = letter - 'A' + 1;
            sum += number;
        }
        return sum;
    }

}