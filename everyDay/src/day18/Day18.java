package src.day18;

public class Day18 {

    /**
     * 负数向上，大于等于0的数向下
     * @param args
     */
    public static void main(String[] args) {
        int num = (int) 3.9;
        System.out.println(num);
        num %= 2;
        System.out.println(num);
        int num2 = (int) -3.9;
        System.out.println(num2);
    }
}
