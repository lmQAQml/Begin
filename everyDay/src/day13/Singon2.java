package src.day13;

/**
 * 懒汉式
 */
public class Singon2 {

    public static Singon2 singon2;

    public Singon2() {

    }

    public synchronized Singon2 getInstance() {
        if (singon2 == null) {
            return new Singon2();
        }
        return singon2;
    }
}
