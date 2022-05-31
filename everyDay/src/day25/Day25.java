package src.day25;

import java.util.HashMap;

public class Day25 {

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[] {1, 2, 1, 2, 1}, 3));
    }

    /**
     * 给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数
     *
     * 输入:nums = [1,1,1], k = 2
     * 输出: 2
     * 解释: 此题 [1,1] 与 [1,1] 为两种不同的情况
     *
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum(int[] nums, int k) {
        int pre_sum = 0;
        int ret = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i : nums) {
            pre_sum += i;
            ret += map.getOrDefault(pre_sum - k, 0);
            map.put(pre_sum, map.getOrDefault(pre_sum, 0) + 1);
        }
        return ret;
    }
}
