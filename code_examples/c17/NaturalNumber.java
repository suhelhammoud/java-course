package c17;

public class NaturalNumber<T extends Integer> {

    private T n;

    public NaturalNumber(T n) {
        this.n = n;
    }

    public boolean isEven() {
        return n.intValue() % 2 == 0; // can use .intValue of object
    }

    // ...
}

