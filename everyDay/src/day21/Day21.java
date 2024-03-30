package day21;

import java.util.HashMap;

/**
 * 给定一个字符串数组 words，请计算当两个字符串 words[i] 和 words[j] 不包含相同字符时，
 * 它们长度的乘积的最大值。假设字符串中只包含英语的小写字母。如果没有不包含相同字符的一对字符串，返回 0。
 *
 */
public class Day21 {

    public static void main(String[] args) {
        String[] arr = new String[] {"abc", "ab", "e" , "ef"};
        int max = maxProduct(arr);
        System.out.println("长度的乘积的最大值：" + max);
    }

    public static int maxProduct(String[] words) {
        int ans = 0;
        if(words.length <= 1) {
            return ans;
        }
        // 预计算
        HashMap<Integer, Integer> map = new HashMap<>();

        for(String word : words) {
            // 当前字母的掩码，26位二进制数
            int num = 0;
            for(char c : word.toCharArray()) {
                // 使用位运算，把字母转换的结果和0进行异运算，就会得到字符串的掩码
                num |= 1 << (c - 'a');
            }

            map.put(num, Math.max(word.length(), map.getOrDefault(num, 0)));
        }
        // 比较

        for (int x : map.keySet()) {
            for (int y : map.keySet()) {
                if ((x & y) == 0) {
                    // 无重复
                    ans = Math.max(ans, map.get(x) * map.get(y));
                }
            }
        }
        return ans;

    }
}
