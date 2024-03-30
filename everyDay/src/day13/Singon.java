package day13;

/**
 * 饿汉式
 */
public class Singon {

    public static Singon singon = new Singon();

    public Singon() {

    }

    public Singon getInstance() {
        return singon;
    }
}
