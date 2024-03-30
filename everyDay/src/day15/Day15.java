package day15;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Day15 {

    public static void main(String[] args) {
        BaseClass myClass = new MyClass("YYY");

        InvocationHandler handler = new MyConfig<BaseClass>(myClass);

        BaseClass myClassProxy = (BaseClass) Proxy.newProxyInstance(
                BaseClass.class.getClassLoader(),
                new Class<?>[]{BaseClass.class},
                handler);

        myClassProxy.run();
    }


}
