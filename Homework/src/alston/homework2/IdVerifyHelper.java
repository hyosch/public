package alston.homework2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IdVerifyHelper {

    List<VerifyResult> list;

    public IdVerifyHelper() {
    }

    public IdVerifyHelper(String fileName) {
        list = validate(fileName);
    }

    public void showResult() {
        for (VerifyResult v : list) {
            if (v.getVerifySuccess()) {
                System.out.println("====您輸入的身分證字號 " + v.getId() + " ====\n" +
                        "====" + v.getMessage() + "====\n");
            } else {
                System.out.println("====您輸入的身分證字號 " + v.getId() + " ====\n" +
                        "====" + v.getMessage() + "====\n");
            }
        }
    }

    public List<VerifyResult> validate(String fileName) {
        BufferedReader bf;
        List<String> idList;
        String line;

        try {
            bf = new BufferedReader(new FileReader(fileName));
            idList = new ArrayList<>();

            while ((line = bf.readLine()) != null) {
                idList.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<VerifyResult> resultList = new ArrayList<>();
        String areaStr = "ABCDEFGHJKLMNPQRSTUVXYWZIO";
        String idOriginal;
        String idStr;
        Boolean isValidated;

        for (int i = 0; i < idList.size(); i++) {
            idOriginal = idStr = idList.get(i);

            if (!idStr.matches("[a-zA-Z][12]\\d{8}")) {
                resultList.add(new VerifyResult(false, idOriginal, "驗證失敗"));
                continue;
            }
            idStr = idStr.toUpperCase();
            idStr = (areaStr.indexOf(idStr.charAt(0)) + 10) + idStr.substring(1);
            int sum = idStr.charAt(0) - '0';

            for (int j = 1; j < idStr.length(); j++) {
                sum = sum + ((idStr.charAt(j) - '0') * (10 - j));
            }
            int lastNum = idStr.charAt(10) - '0';

            if (sum % 10 == 10 - lastNum) {
                isValidated = true;
            } else if (sum % 10 == 0 && lastNum == 0) {
                isValidated = true;
            } else {
                isValidated = false;
            }

            if (isValidated) {
                resultList.add(new VerifyResult(true, idOriginal, "驗證成功"));
            } else {
                resultList.add(new VerifyResult(false, idOriginal, "驗證失敗"));
            }
        }

        return resultList;
    }

    private boolean verifyId(String idStr) {
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