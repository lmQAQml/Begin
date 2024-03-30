package day12;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;

public class Day12 {
    public static void main(String[] args) throws Exception {
        Integer result = ((Callable<Integer>) () -> 2+1).call();
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();
    }
}
