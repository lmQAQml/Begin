package src.day23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day23 {

    public static void main(String[] args) {
        List<List<Integer>> res = threeSum(new int[] {-1,0,1,2,-1,-4});
        System.out.println(res);
    }

    /**
     * 给定一个包含 n 个整数的数组nums，判断nums中是否存在三个元素a ，b ，c ，使得a + b + c = 0 ？请找出所有和为 0 且不重复的三元组。
     *
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {

        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // O(nlog n)
        int length = nums.length;
        // o(n^2)
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = length - 1;
            int sum = -nums[i];
            while (left < right) {

                if (nums[left] + nums[right] < sum) {
                    // 小于当前数，左指针右移
                    left++;
                } else
                if (nums[left] + nums[right] > sum) {
                    // 大于当前数，右指针左移
                    right--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重: 相邻元素相同直接跳过，避免产出相同结果
                    while (left < right && nums[left] == nums[++left]);
                    while (left < right && nums[right] == nums[--right]);
                }

            }
        }
        return res;
    }
}
