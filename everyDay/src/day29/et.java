package src.day29;

import java.util.Arrays;

public class et {

    /*
    @param needReverseValue 需要反序的字符串
    @param delimiter 分割符号
*/
    public static void main(String[] args) {
        String s = "prod,gay,ou";
        String sp = ",";
        System.out.println(reverseDelimitedString(s, sp));
    }

    public static String reverseDelimitedString(String needReverseValue, String delimiter) {
        StringBuilder ans = new StringBuilder();
        String[] split = needReverseValue.split(delimiter);
        for (int i = split.length - 1; i >= 0; i--) {
            ans.append(split[i]);
            if (i != 0) {
                ans.append(delimiter);
            }
        }
        return ans.toString();
    }

}
