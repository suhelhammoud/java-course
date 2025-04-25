---
title: Object Oriented Programming in Java
sub_title: Lambda Expressions
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


# Writing Your First Lambda Expression

Java SE 8 introduced lambda expressions as a cleaner alternative to anonymous classes for specific use cases.

If you're unfamiliar with anonymous classes, don't worry — you can learn lambdas without them.

Writing a lambda involves three steps:

1. Identify the lambda type  
2. Find the method to implement  
3. Implement that method

Let’s explore each step.

<!-- end_slide -->

## Identifying the Lambda Type

A lambda must implement a **functional interface** — an interface with **exactly one abstract method**.

Since Java 8, interfaces can have default and static methods, but only abstract methods count.

**Note:** `@FunctionalInterface` is optional but helps catch mistakes.

<!-- end_slide -->

## Examples of Functional Interfaces

<!-- column_layout: [1, 1] -->
<!-- column: 0 -->
<!-- pause -->
```java
@FunctionalInterface
public interface Runnable {
    void run();
}
```
<!-- column: 1 -->
<!-- pause -->

```java
@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
    default Consumer<T> andThen(...) { }
}
```
<!-- reset_layout -->
<!-- pause -->

```java
@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
    default Predicate<T> and(...) { }
    static <T> Predicate<T> isEqual(...) { }
}
```
<!-- pause -->

Each has a single abstract method, making them valid functional interfaces.

<!-- end_slide -->

## Finding the Method to Implement

Once you know the functional interface, find its abstract method:

- `Runnable`: `void run()`
- `Predicate<T>`: `boolean test(T t)`
- `Consumer<T>`: `void accept(T t)`

Your lambda is just an inline implementation of this method.

<!-- end_slide -->

## Writing Your First Lambda
<!-- pause -->

To create a `Predicate<String>` that checks for 3-character strings:

```java
Predicate<String> predicate =
    (String s) -> {
        return s.length() == 3;
    };
```

<!-- pause -->

## Simplifying the Syntax

Java allows simplification:

```java
Predicate<String> predicate = s -> s.length() == 3;
```
<!-- incremental_lists: true -->
- No need to declare types or use braces for single-line bodies  
- Keep lambdas short and readable

<!-- end_slide -->

## Other Examples

**Consumer** that prints a string:

```java
Consumer<String> print = s -> System.out.println(s);
```

**Runnable** that prints a message:

```java
Runnable runnable = () -> System.out.println("I am running");
```

<!-- end_slide -->

## Using Lambdas in Methods

Example using a lambda in a method:

```java
List<String> retainStringsOfLength3(List<String> strings) {
    Predicate<String> predicate = s -> s.length() == 3;
    return strings.stream()
                  .filter(predicate)
                  .collect(Collectors.toList());
}
```

Lambdas implement an interface, so you can call its methods like `test()`.

<!-- end_slide -->

## Variable Capture in Lambdas

Lambdas can read **final or effectively final** variables but can't modify them.

<!-- pause -->
Example:

```java
int totalPrice = 0;
Consumer<Product> consumer = p -> totalPrice += p.getPrice(); // Error
```
<!-- pause -->

Use an external mutable structure (e.g., `AtomicInteger`) for updates. 

<!-- end_slide -->

## Lambda Serialization

Lambdas can be serialized, enabling their use in serializable objects.

This supports backward compatibility in classes that store functional fields.

