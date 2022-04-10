public class App {
    public static void main(String[] args) {
        Child child = new Child("bagaskoro");

        child.sayHello();

        System.out.println(child.name); //error
    }
}