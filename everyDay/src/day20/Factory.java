package day20;

/**
 * 泛型类
 * @param <T>
 */
public class Factory<T> {

    T t;

    public <C extends Creator<T>> Factory(C target) {
        target.create();
    }

    public Factory() {

    }
}
