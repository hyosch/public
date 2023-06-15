package alston.homework2;

import java.io.File;

public class TestIdValidate {

    public static void main(String[] args) {
        String path = "./idList2.txt";
        File file = new File(IdVerifyHelper.class.getResource(path).getFile());
        new IdVerifyHelper(file.getAbsolutePath());
    }

}
