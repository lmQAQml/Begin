package day02;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class Day_02 {

    public static void main(String[] args) {
        System.out.println("方法总数:" + work(5));
    }

    /**
     * f(n) = f(n-1) + f(n-2)
     * 使用滑动数组
     * @param n
     * @return
     */
    public static Integer work(int n) {
        int pre = 0,next = 0,result = 1;
        for(int i = 1; i<=n; ++i) {
            pre = next;
            next = result;
            result = pre + next;
        }
        return result;
    }
}
