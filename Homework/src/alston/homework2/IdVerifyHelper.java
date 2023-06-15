package alston.homework2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IdVerifyHelper {

    public IdVerifyHelper() {}

    public IdVerifyHelper(String fileName) {
        List<VerifyResult> list = validate(fileName);
        for (VerifyResult v : list) {
            System.out.println(v);
        }
    }

    public List<VerifyResult> validate(String fileName) {
        List<String> idList = readFile(fileName);
        List<VerifyResult> resultList = new ArrayList<>();
        VerifyResult verifyResult;

        for (int i = 0; i < idList.size(); i++) {
            verifyResult = new VerifyResult();

            if (verifyId(idList.get(i))) {
                verifyResult.setVerifySuccess(true);
                verifyResult.setId(idList.get(i));
                verifyResult.setMessage("驗證成功");
            } else {
                verifyResult.setVerifySuccess(false);
                verifyResult.setId(idList.get(i));
                verifyResult.setMessage("驗證失敗");
            }
            resultList.add(verifyResult);
        }

        return resultList;
    }

    private List readFile(String fileName) {
        BufferedReader bf;
        List<String> idList;
        String idStr;

        try {
            bf = getBufferReader(fileName);
            idList = new ArrayList<>();

            while ((idStr = bf.readLine()) != null) {
                idList.add(idStr);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return idList;
    }

    private BufferedReader getBufferReader(String fileName) throws FileNotFoundException {
        return new BufferedReader(new FileReader(fileName));
    }

    private static boolean verifyId(String idStr) {
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
