---
title: Object Oriented Programming in Java
sub_title: Combining Lambdas Expressions
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


# Combining Lambda Expressions
<!-- incremental_lists: true -->
- `java.util.function` interfaces have default methods.
- These methods enable chaining and combining lambda expressions.
- Purpose: write simpler, more readable, and expressive code.

<!-- end_slide -->

# Chaining Predicates with Default Methods
<!-- pause -->
## Problem Statement
<!-- incremental_lists: true -->
- Need to filter strings that are:
  - non-null
  - non-empty
  - shorter than 5 characters

## Direct Lambda:
```java
Predicate<String> p = s -> (s != null) && !s.isEmpty() && s.length() < 5;
```

<!-- end_slide -->

# Predicate Chaining Example
<!-- incremental_lists: true -->
- Improved version using `and()` default method:
```java
Predicate<String> nonNull = s -> s != null;
Predicate<String> nonEmpty = s -> !s.isEmpty();
Predicate<String> shorterThan5 = s -> s.length() < 5;

Predicate<String> p = nonNull.and(nonEmpty).and(shorterThan5);
```
- Clearer, intent-driven code.

<!-- end_slide -->

# How It Works at the API Level
<!-- incremental_lists: true -->
- `and()` is:
  - an instance method of `Predicate<T>`
  - takes another `Predicate<T>` as argument
  - returns a new `Predicate<T>`
- Must be a `default` method (only one abstract method allowed)

- Other helpful methods:
  - `or()`: combine with logical OR
  - `negate()`: logical NOT

<!-- end_slide -->

# Expressive Predicate Composition
<!-- incremental_lists: true -->
```java
Predicate<String> isNull = Objects::isNull;
Predicate<String> isEmpty = String::isEmpty;
Predicate<String> isNullOrEmpty = isNull.or(isEmpty);
Predicate<String> isNotNullNorEmpty = isNullOrEmpty.negate();
Predicate<String> shorterThan5 = s -> s.length() < 5;

Predicate<String> p = isNotNullNorEmpty.and(shorterThan5);
```
- Combines method references and default methods.
- Improves clarity despite complexity.

<!-- end_slide -->

# Creating Predicates with Factory Methods
<!-- pause -->
## Factory Method 1: `Predicate.isEqual`
```java
Predicate<String> isEqualToDuke = Predicate.isEqual("Duke");
```
- Tests if input equals "Duke".
<!-- pause -->
## Factory Method 2: `Predicate.not`
```java
Predicate<Collection<String>> isEmpty = Collection::isEmpty;
Predicate<Collection<String>> isNotEmpty = Predicate.not(isEmpty);
```

<!-- end_slide -->

# Chaining Consumers with Default Methods
<!-- incremental_lists: true -->
- `Consumer<T>` can be chained using `andThen()`.
```java
Logger logger = Logger.getLogger("MyApplicationLogger");
Consumer<String> log = message -> logger.info(message);
Consumer<String> print = message -> System.out.println(message);

Consumer<String> logAndPrint = log.andThen(print);
```
- Executes `log` first, then `print`.

<!-- end_slide -->

# Chaining and Composing Functions
<!-- pause -->
## Chaining with `andThen`
```java
Function<T, R> f1;
Function<R, V> f2;
Function<T, V> result = f1.andThen(f2);
```
- Applies `f1`, then passes result to `f2`.

<!-- pause -->
## Composing with `compose`
```java
Function<T, R> f1;
Function<R, V> f2;
Function<T, V> result = f2.compose(f1);
```
- Also applies `f1` first, then `f2`.

<!-- end_slide -->

# Chaining vs Composing Functions
<!-- incremental_lists: true -->
- `f1.andThen(f2)` == `f2.compose(f1)`
- Order is the same, syntax is different.
- You can mix function types as long as:
  - output of `f1` is compatible with input of `f2`.

<!-- end_slide -->

# Creating an Identity Function
<!-- incremental_lists: true -->
- Factory method: `Function.identity()`
- Returns a function that returns its input:
```java
Function<String, String> id = Function.identity();
```
- Works for any type `T`:
```java
Function<T, T> id = Function.identity();
```

