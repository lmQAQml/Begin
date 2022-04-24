package src.day12;

import java.util.concurrent.Callable;

public class Day12 {
    public static void main(String[] args) throws Exception {
        Integer result = ((Callable<Integer>) () -> 2+1).call();
    }
}
