package src.day22;


import java.util.Objects;

public class Day22 {

    public static void main(String[] args) {
        int[] ans = twoSum(new int[] {1,2,4,6,10}, 1);
        if (ans.length == 0) {
            System.out.println("无法找到两数满足条件");
            return;
        }
        System.out.println("两个数的下标值");
        for (int an : ans) {
            System.out.println(an);
        }
    }

    /**
     * 给定一个已按照 升序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
     * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return new int[0];
        }
        // 定义两个游标
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] < target) {
                // 此时，两数相加小于目标值，左游标需右移
                left += 1;
                continue;
            }
            if (numbers[left] + numbers[right] > target) {
                // 此时，两数相加大于目标值，右游标需左移
                right -= 1;
                continue;
            }
            return new int[] {left, right};
        }
        return new int[0];
    }

}


