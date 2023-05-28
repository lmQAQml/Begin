package src.day24;

public class Day24 {

    public static void main(String[] args) {
        int res = numSubarrayProductLessThanK(new int[] {10,5,2,6}, 100);
        System.out.println(res);
    }

    /**
     * 给定一个正整数数组 nums和整数 k ，请找出该数组内乘积小于 k 的连续的子数组的个数。
     * @param nums
     * @param k
     * @return
     */
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int ret = 0;
        int total = 1;
        for (int right = 0; right < nums.length; right++) {
            total *= nums[right];
            while (left <= right && total >= k) {
                total /= nums[left++];
            }
            if (left <= right) {

                // 窗口每次移动后，ret都可以增加 right - left + 1个子数组
                ret += (right - left + 1);
            }
        }
        return ret;
    }

}
