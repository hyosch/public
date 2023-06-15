package alston.homework2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IdVerifyHelper {

    public static void main(String[] args) {
        File file = new File("C:\\Alston\\code\\ide\\idea-202203\\workspace\\java_homework\\src\\alston\\homework2\\idList.txt");
        BufferedReader bf;
        List<String> idList;
        String idStr;

        try {
            bf = new BufferedReader(new FileReader(file));
            idList = new ArrayList<>();

            while ((idStr = bf.readLine()) != null) {
                idList.add(idStr);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < idList.size(); i++) {
            boolean flag = verifyId(idList.get(i));

            if (flag) {
                System.out.println("====您輸入的身分證字號 " + idList.get(i) + " ====\n" +
                        "====驗證成功====\n");
            } else {
                System.out.println("====您輸入的身分證字號 " + idList.get(i) + " ====\n" +
                        "====驗證失敗====\n");
            }
        }
    }

    static boolean verifyId(String idStr) {
        String areaStr = "ABCDEFGHJKLMNPQRSTUVXYWZIO";
        if (!idStr.matches("[a-zA-Z][12]\\d{8}")) {

            return false;
        }
        idStr = idStr.toUpperCase();
        idStr = (areaStr.indexOf(idStr.charAt(0)) + 10) + idStr.substring(1);
        int sum = idStr.charAt(0) - '0';

        for (int i = 1; i < idStr.length(); i++) {
            sum = sum + ((idStr.charAt(i) - '0') * (10 - i));
        }
        int lastNum = idStr.charAt(10) - '0';

        if (sum % 10 == 10 - lastNum) {

            return true;
        } else if (sum % 10 == 0 && lastNum == 0) {

            return true;
        }

        return false;
    }

}
