package c17;

/**
 * Generic version of the Box class.
 *
 * @param <T> the type of the value being boxed
 */
public class Box<T> {
    // T stands for "Type"
    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public <U extends Number> void inspect(U u) {
        System.out.println("T: " + t.getClass().getName());
        System.out.println("U: " + u.getClass().getName());
    }

    public static void main(String[] args) {
        Box<Integer> ibox = new Box<>();
        ibox.set(3);
        Integer i = ibox.get();

        //ibox.set("Name"); compile time error

        Box<String> sBox = new Box<>();
        sBox.set("Name");
        String s = sBox.get();

        Box<Integer> integerBox = new Box<Integer>();
        integerBox.set(10);
//        integerBox.inspect("some text"); // error: this is still String!
    }
}