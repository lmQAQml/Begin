package src.day20;

import javax.swing.text.html.parser.Entity;
import java.math.BigDecimal;

public class Day20 {

    public static void main(String[] args) {
        // 泛型方法的调用
        run("s");

        // 泛型类的调用
        Factory<Car> factory = new Factory<>(new Car("Audi", new BigDecimal(100000)));

    }

    /**
     * 泛型方法
     * @param t
     * @param <T>
     */
    public static  <T> void run(T t) {
        System.out.println(t.getClass());
        System.out.println(t);
    }
}
