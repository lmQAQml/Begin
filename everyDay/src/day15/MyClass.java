package src.day15;

public class MyClass implements BaseClass{

    private String name;

    public MyClass(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println("wo!" + this.name);
    }

}
