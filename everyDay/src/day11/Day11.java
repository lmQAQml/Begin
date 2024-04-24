package day11;

import java.util.Arrays;

public class Day11 {
    public static void main(String[] args) {
        int[] g = new int[] {1,2,3};
        int[] s = new int[] {3};
        System.out.println(findContentChildren(g, s));
    }

    public static int findContentChildren(int[] g, int[] s) {
        int res = 0;
        Arrays.sort(s);
        Arrays.sort(g);
        // 循环结束条件：孩子都喂饱了或者饼干用完了
        for(int cookie=0,child=0;child<g.length && cookie<s.length;cookie++) {
            // 如果满足，移动饼干和孩子
            // 不满足，移动饼干，去找下一个满足的饼干
            // 为什么可以用贪心？如果当前的饼干满足不了这个孩子，当然也满足不了比这个孩子胃口更大的孩子
            // 所以这块饼干可以跳过了
            if(g[child]<=s[cookie]) {
                res++;
                child++;
            }
        }
        return res;
    }
}
