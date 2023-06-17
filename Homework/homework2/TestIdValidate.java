package alston.homework2;

import alston.homework2.demo.IdVerifyHelper;
import alston.homework2.demo.IdVerifyHelperC01;
import alston.homework2.demo.IdVerifyHelperC02;

public class TestIdValidate {

    public static void main(String[] args) {
        String fileName = "C:\\Alston\\code\\ide\\idea-202203\\workspace\\java_homework\\src\\alston\\homework2\\file\\idList3.txt";
        IdVerifyHelper idVerifyHelper = new IdVerifyHelper(fileName);
        idVerifyHelper.showResult();

        IdVerifyHelper idVerifyHelper1 = new IdVerifyHelperC01(fileName);
        idVerifyHelper1.showResult();

        IdVerifyHelper idVerifyHelper2 = new IdVerifyHelperC02(fileName);
        idVerifyHelper2.showResult();
    }

}
