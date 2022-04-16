package src.day08;

import java.util.ArrayList;
import java.util.Scanner;

/**
某商店规定：三个空汽水瓶可以换一瓶汽水，允许向老板借空汽水瓶（但是必须要归还）。
        小张手上有n个空汽水瓶，她想知道自己最多可以喝到多少瓶汽水。
        数据范围：输入的正整数满足
 */
public class Day08 {

    public static void main(String[] args) {
        ArrayList<Integer> num = new ArrayList();
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int i = in.nextInt();
            if (i == 0) {
                break;
            }
            num.add(i);
        }
        for (int i : num) {
            if (i == 0) {
                // 为0代表结束
                break;
            }
            System.out.println(work(i));
        }
    }

    public static int work(int num) {
        int total = 0;
        // 第一次兑换的汽水数量
        total = num / 3;
        int out = num % 3;
        if (total == 0) {
            return (out + 1) / 3;
        }
        return total + work(total + out);
    }


}
/**
 * 这道题也可用数学归纳法解决
 */