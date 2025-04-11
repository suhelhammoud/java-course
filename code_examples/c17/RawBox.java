package c17;

public class RawBox {
    private Object object;

    public void set(Object object) {
        this.object = object;
    }

    public Object get() {
        return object;
    }

    public static void main(String[] args) {
        RawBox box = new RawBox();

        box.set(1);
        Integer i = (Integer) box.get();

        box.set("Name");
        String s = (String) box.get();
    }
}