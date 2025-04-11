package c17;

interface IPair<K, V> {
    K getKey();

    V getValue();
}

public class Pair<K, V> implements IPair<K, V> {

    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public static void main(String[] args) {
        Pair<String, Integer> p1 = new Pair<String, Integer>("Even", 8);
        Pair<String, String> p2 = new Pair<String, String>("hello", "world");

        // Use the diamond only <>
        Pair<String, Box<Integer>> p = new Pair<>("primes", new Box<>());

    }
}