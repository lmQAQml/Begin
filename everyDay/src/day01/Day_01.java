package day01;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class Day_01 {
    private final static int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

    public static void main(String[] args) {
        System.out.println("最大值:" + maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int pre = 0, max = nums[0];
        for(int i: nums) {
            pre = Math.max(pre + i, i);
            max = Math.max(pre, max);
        }
        return max;
    }
}
