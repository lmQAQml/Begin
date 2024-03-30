package day09;

import java.util.Scanner;

/**
 * 返回输入的最后一个字符串长度
 */
public class Day09 {
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextLine()) {
            String last = sc.nextLine();
            sb.append(last);
        }
        String str = sb.reverse().toString();
        String[] s = str.trim().split(" ");
        System.out.print(s[0].length());
    }
}
