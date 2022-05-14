package src.day15;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyConfig<T> implements InvocationHandler {

    T myClass;

    public MyConfig(T target) {
        this.myClass = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理方法执行---");
        Object invoke = method.invoke(myClass, args);
        return invoke;
    }
}
