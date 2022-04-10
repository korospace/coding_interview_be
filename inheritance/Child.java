public class Child extends Parent {
    public Child(String name) {
        super(name);
    }

    public String sayHello() {
        System.out.println("hello my name is "+name);
    }
}