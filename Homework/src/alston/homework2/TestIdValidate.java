package alston.homework2;

public class TestIdValidate {

    public static void main(String[] args) {
        String fileName = "C:\\Alston\\code\\ide\\idea-202203\\workspace\\java_homework\\src\\alston\\homework2\\idList2.txt";
        IdVerifyHelper idVerifyHelper = new IdVerifyHelper(fileName);
        idVerifyHelper.showResult();
    }

}
