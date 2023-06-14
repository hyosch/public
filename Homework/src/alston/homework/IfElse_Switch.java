package alston.homework;

public class IfElse_Switch {
    public static void main(String[] args) {
        System.out.println(checkAge(20));
        System.out.println(checkAge2(30));
    }
    public static String checkAge(int age) {
        if (age < 20) {
            return "青少年";
        } else if (age < 30) {
            return "壯年";
        } else if (age < 50) {
            return "中年";
        } else {
            return "老年";
        }
    }
    public static StringBuilder checkAge2(int age) {
        int quotient = age/10;
        StringBuilder result = new StringBuilder();
        switch (quotient) {
            case 0,1:
                result.append( "青少年");
                break;
            case 2:
                result.append( "壯年");
                break;
            case 3,4:
                result.append( "中年");
                break;
            default:
                result.append( "老年");
        }
        return result;
    }
}
