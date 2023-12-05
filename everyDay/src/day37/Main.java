package src.day37;

import java.util.HashMap;

/**
 * HashMap键值是否可以都为null
 */
public class Main {
    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put(null, null);
        System.out.println(map.get(null));
        map.put(null, "");
        System.out.println(map.get(null));

    }
}
