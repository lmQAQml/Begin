package src.day10;

import java.util.Scanner;

/**
 * 输入一个字符串，请按长度为8拆分每个输入字符串并进行输出；
 *
 * 长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 */
public class Day10 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        if(str == null) {
            return;
        }
        int to = 8 - str.length()%8;
        if(to%8 != 0) {
            for(int i =0; i< to; i++) {
                str += 0;
            }
        }
        int length = str.length();
        int start = 0;
        while(start < length) {
            System.out.println(str.substring(start, start+8));
            start +=8;
        }
    }
}
