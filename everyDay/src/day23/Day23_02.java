package day23;

public class Day23_02 {

    public static void main(String[] args) {
        int res = minSubArrayLen(11, new int[] {1,1,1,1});
        System.out.println("最短子数组长度: " + res);
    }

    /**
     * 给定一个含有n个正整数的数组和一个正整数 target 。
     *
     * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0
     *
     * 输入：target = 7, nums = [2,3,1,2,4,3]
     * 输出：2
     * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     *
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        // 滑动数组 O(n)
        while (end < n) {
            sum += nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
