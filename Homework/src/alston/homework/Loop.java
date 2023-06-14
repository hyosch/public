package alston.homework;

public class Loop {

    public static void main(String[] args) {
        // for迴圈
        int sum1 = 0;
        for (int i = 1; i <= 100; i++) {
            sum1 = sum1 + i;
        }

        // while迴圈
        int k = 1;
        int sum2 = 0;
        while (k <= 100) {
            sum2 = sum2 + k;
            k++;
        }

        // do-while迴圈
        int i = 1;
        int sum3 = 0;
        do {
            sum3 = sum3 + i;
            i++;
        } while (i <= 100);
    }

}
