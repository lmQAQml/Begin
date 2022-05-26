package src.day20;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day20 {

    public static void main(String[] args) {
        // 泛型方法的调用
        run("s");

        // 泛型类的调用
        Factory<Car> factory = new Factory<>(new Car("Audi", new BigDecimal(100000)));


        Integer[] nums = new Integer[] {1, 2, 3};
        List<Integer> list = Arrays.asList(nums);
        nums[0] = 0;
        // Arrays.asList()方法只是将数组的引用改变，所以对原数组进行变更，会导致此时转换后的list也发生变更.注意这里的list并不是平时用到的list，而是一个内部类的ArrayList
        System.out.println(list);


        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.remove(1);
        System.out.println(arrayList);
    }

    /**
     * 泛型方法
     *
     * @param t
     * @param <T>
     */
    public static <T> void run(T t) {
        System.out.println(t.getClass());
        System.out.println(t);
    }
}
