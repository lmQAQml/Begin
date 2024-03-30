package day19;

import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.ThreadPoolExecutor;

public class Day19 {
    static int time = 1;
    public static void main(String[] args) {

        HashMap<Object, Integer> map = new HashMap<>();
        map.put("key", time);
        new Thread(() -> visit(map)).start();
        new Thread(() -> visit(map)).start();
    }

    private static void visit(HashMap map) {
        synchronized (map) {
            Object key = map.get("key");
            if (Objects.nonNull(key)) {
                map.put("key", time);
                key = map.get("key");
            }
            System.out.println(key);
            map.put("key", ++time);
        }
    }
}
