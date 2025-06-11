package art.lapov.app;

import art.lapov.data.FakeDatabase;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        FakeDatabase db = new FakeDatabase();
        System.out.println(db.getBooks());
    }
}
