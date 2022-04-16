package src.day09;

import java.util.Scanner;

/**
 * 接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）
 */
public class Day09_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toLowerCase();
        String target = sc.nextLine().toLowerCase();
        System.out.print(str.length() - str.replaceAll(target, "").length());
    }
}
