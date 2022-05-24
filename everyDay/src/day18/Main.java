package src.day18;

public class Main {

    public static void main(String[] args) {
        System.out.println(make(5));
    }

    /**
     * 0,1,1,2,5,29...
     * 求前n项和
     * @param n
     * @return
     */
    public static int make(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        // 定义一个一维数组，长度为4
        int[] nums = new int[] {0,1,1,1};
        for (int i = 0; i < n - 2; i++) {
            nums[2] = nums[0]*nums[0] + nums[1]*nums[1];
            nums[0] = nums[1];
            nums[1] = nums[2];
            nums[3] += nums[1];
        }
        return nums[3];
    }
}
