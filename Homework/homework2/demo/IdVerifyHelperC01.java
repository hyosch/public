package alston.homework2.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IdVerifyHelperC01 extends IdVerifyHelper {

    public IdVerifyHelperC01(String fileName) {
        super(fileName);
    }

    @Override
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

        return verifyId(idList);
    }

    private List<VerifyResult> verifyId(List<String> idList) {
        String areaStr = "ABCDEFGHJKLMNPQRSTUVXYWZIO";
        List<VerifyResult> resultList = new ArrayList<>();
        String idStr;
        Boolean flag;

        for (int i = 0; i < idList.size(); i++) {
            idStr = idList.get(i);

            if (idStr.length() != 10) {
                resultList.add(new VerifyResult(false, idStr, "證號長度不為10"));
                continue;
            }
            if (!idStr.matches("[A-Z]\\d{9}")) {
                resultList.add(new VerifyResult(false, idStr, "證號格式錯誤"));
                continue;
            }
            idStr = (areaStr.indexOf(idStr.charAt(0)) + 10) + idStr.substring(1);
            int sum = idStr.charAt(0) - '0';

            for (int j = 1; j < idStr.length(); j++) {
                sum = sum + ((idStr.charAt(j) - '0') * (10 - j));
            }
            int lastNum = idStr.charAt(10) - '0';

            if (sum % 10 == 10 - lastNum) {
                flag = true;
            } else if (sum % 10 == 0 && lastNum == 0) {
                flag = true;
            } else {
                flag = false;
            }

            if (flag) {
                resultList.add(new VerifyResult(true, idList.get(i), "驗證成功"));
            } else {
                resultList.add(new VerifyResult(false, idList.get(i), "驗證失敗"));
            }
        }

        return resultList;
    }

}
