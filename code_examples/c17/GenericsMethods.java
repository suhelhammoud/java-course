package c17;

//interface Comparable<T> {
//    public int compareTo(T o);
//}

public class GenericsMethods {

   /* not correct code
    public static <T> int countGreaterThan(T[] anArray, T elem) {
        int count = 0;
        for (T e : anArray)
            if (e > elem)  // compiler error
                ++count;
        return count;
    }
    */

    public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
        int count = 0;
        for (T e : anArray)
            if (e.compareTo(elem) > 0) // instead of >
                ++count;
        return count;
    }

    public static void someMethod(Number n) { /* ... */ }

    public static void boxTest(Box<Number> n) { /* ... */ }

    public static void main(String[] args) {
        Object someObject = new Object();
        Integer someInteger = 10;
        someObject = someInteger;   // OK

        someMethod(10);   // OK
        someMethod(10.1);   // OK

//        boxTest(new Box<Integer>()); // Error
    }
}
