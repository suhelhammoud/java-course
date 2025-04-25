---
title: Object Oriented Programming in Java
sub_title: Using Lambdas Expressions in Your Application
author: Suhel Hammoud

theme:
  override:
    code:
        alignment: left
        # margin:
        #     percent: 2q
    #   padding:
        # horizontal: 4
---


# Using Lambdas Expressions in Your Application
<!-- incremental_lists: true -->
- Java SE 8 introduced lambda expressions.
- Major rewrite of JDK API: more updates than with generics in Java SE 5.
- Many existing interfaces became functional automatically.
- Your old interfaces may be implemented with lambdas without any modifications.

<!-- end_slide -->

# Discovering the java.util.function Package
<!-- incremental_lists: true -->

- New package: `java.util.function`, part of `java.base` module.
- Functional interfaces heavily used in Collections and Stream API.
- Organized around four main types of interfaces.
- Understanding the core ones helps you understand the rest.

<!-- end_slide -->

# Creating or Providing Objects with Supplier`<T>`
<!-- pause -->
## Implementing the Supplier`<T>` Interface
<!-- incremental_lists: true -->

- A Supplier`<T>` does not take arguments and returns an object.
- Interface has only one method: `T get();`.
- Example:
```java
Supplier<String> supplier = () -> "Hello Duke!";
```
- Captures variables from surrounding scope (effectively final).

<!-- end_slide -->

# Using a Supplier`<T>`
<!-- incremental_lists: true -->
- Example: Generating random numbers:
```java
Random random = new Random(314L);
Supplier<Integer> rnd = () -> random.nextInt(10);

for (int index = 0; index < 5; index++) {
    System.out.println(rnd.get() + " ");
}
```
- Captured variable `random` is effectively final.

<!-- end_slide -->

# Specialized Suppliers
<!-- incremental_lists: true -->
- Avoid unnecessary boxing/unboxing for performance.
- Example using `IntSupplier`:
```java
Random random = new Random(314L);
IntSupplier rnd = () -> random.nextInt();
```
- Call `getAsInt()` instead of `get()`.
- Specialized Suppliers: `IntSupplier`, `BooleanSupplier`, `LongSupplier`, `DoubleSupplier`.

<!-- end_slide -->

# Consuming Objects with Consumer`<T>`
## Implementing and Using Consumers
<!-- incremental_lists: true -->
- A Consumer`<T>` takes an argument and returns nothing.
- Interface has one abstract method: `void accept(T t);`.
- Example:
```java
Consumer<String> printer = s -> System.out.println(s);
```

<!-- end_slide -->

# Using Specialized Consumers
<!-- incremental_lists: true -->
- Example:
```java
Consumer<Integer> printer = i -> System.out.println(i);
```
- Auto-boxing may occur — can impact performance.
- Specialized Consumers: `IntConsumer`, `LongConsumer`, `DoubleConsumer`.

<!-- end_slide -->

# Consuming Two Elements with a BiConsumer
<!-- incremental_lists: true -->
- `BiConsumer<T, U>` takes two arguments.
- Example:
```java
BiConsumer<Random, Integer> randomNumberPrinter =
    (random, number) -> {
        for (int i = 0; i < number; i++) {
            System.out.println("next random = " + random.nextInt());
        }
    };
randomNumberPrinter.accept(new Random(314L), 5);
```
- Specialized versions: `ObjIntConsumer<T>`, `ObjLongConsumer<T>`, `ObjDoubleConsumer<T>`.

<!-- end_slide -->

# Passing a Consumer to an Iterable
<!-- incremental_lists: true -->
- `forEach(Consumer)` applies a Consumer to each element.
- Example:
```java
List<String> strings = List.of("A", "B", "C");
Consumer<String> printer = s -> System.out.println(s);
strings.forEach(printer);
```
- Enables internal iteration and improves readability.

<!-- end_slide -->

# Testing Objects with Predicate`<T>`
<!-- pause -->
## Implementing and Using Predicates
<!-- incremental_lists: true -->
- A Predicate`<T>` tests an object, returning a boolean.
- Interface:
```java
@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}
```
- Example:
```java
Predicate<String> length3 = s -> s.length() == 3;
```

<!-- end_slide -->

# Using Specialized Predicates
<!-- incremental_lists: true -->
- Example:
```java
Predicate<Integer> isGreaterThan10 = i -> i > 10;
```
- Specialized Predicates: `IntPredicate`, `LongPredicate`, `DoublePredicate`.
- Reduces boxing/unboxing overhead.

<!-- end_slide -->

# Testing Two Elements with a BiPredicate
<!-- incremental_lists: true -->
- `BiPredicate<T, U>` takes two arguments.
- Example:
```java
BiPredicate<String, Integer> isOfLength = (word, length) -> word.length() == length;
```
- No specialized primitive versions.

<!-- end_slide -->

# Passing a Predicate to a Collection
<!-- incremental_lists: true -->
- `removeIf(Predicate)` method removes elements matching the predicate.
- Example:
```java
List<String> strings = new ArrayList<>(List.of("one", "two", "three", "four", "five"));
Predicate<String> isEvenLength = s -> s.length() % 2 == 0;
strings.removeIf(isEvenLength);
System.out.println(strings);
```
- Note:
  - Mutates the collection.
  - Cannot be used on immutable lists (like `List.of()`).

<!-- end_slide -->

# Mapping Objects to Other Objects with Function<T, R>
<!-- pause -->
## Implementing and Using Functions
<!-- incremental_lists: true -->
- A Function<T, R> transforms a value.
- Interface:
```java
@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);
}
```
- Example:
```java
Function<String, Integer> toLength = s -> s.length();
```

<!-- end_slide -->

# Using Specialized Functions
<!-- incremental_lists: true -->
- Specialized for different argument and return types:
  - Input: T, int, long, double
  - Output: T, int, long, double
- Specialized interfaces: `IntFunction<T>`, `ToIntFunction<T>`, etc.

<!-- end_slide -->

# UnaryOperator`<T>` and Specialized Functions
<!-- incremental_lists: true -->
- `UnaryOperator<T>` = `Function<T, T>`.
- Example: Mathematical operations like sqrt, sin, log.
- Specialized versions: `IntUnaryOperator`, `LongUnaryOperator`, `DoubleUnaryOperator`.

<!-- end_slide -->

# Passing a Unary Operator to a List
<!-- incremental_lists: true -->
- Example:
```java
List<String> strings = Arrays.asList("one", "two", "three");
UnaryOperator<String> toUpperCase = word -> word.toUpperCase();
strings.replaceAll(toUpperCase);
System.out.println(strings);
```
- Modifies list elements in place.

<!-- end_slide -->

# Mapping Two Elements with a BiFunction
<!-- incremental_lists: true -->
- `BiFunction<T, U, R>` takes two arguments, returns a value.
- Example:
```java
BiFunction<String, String, Integer> findWordInSentence =
    (word, sentence) -> sentence.indexOf(word);
```
- Specialized versions: `IntBinaryOperator`, `ToIntBiFunction<T>`, etc.

<!-- end_slide -->

# Wrapping up the Four Categories of Functional Interfaces
<!-- incremental_lists: true -->
- Four Main Categories:
  - Supplier: no argument, returns a value.
  - Consumer: takes an argument, returns nothing.
  - Predicate: takes an argument, returns a boolean.
  - Function: takes an argument, returns a transformed value.
- Variants for two arguments: BiConsumer, BiPredicate, BiFunction.
- Specialized interfaces avoid boxing/unboxing for primitives.
- Extensions: `UnaryOperator<T>`, `BinaryOperator<T>` for same-type transformations.

