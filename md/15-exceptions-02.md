---
title: Object Oriented Programming in Java
sub_title: Catching and Handling Exceptions
author: Suhel Hammoud

theme:
  override:
    code:
        alignment: left
---

# Catching and Handling Exceptions

Java provides a mechanism to **handle exceptions** so that programs can continue running.

<!-- pause -->

This is done using:
- `try`
- `catch`
- `finally`

<!-- end_slide -->

## The try Block

The `try` block contains code that might throw an exception.

```java
try {
    // code that may throw exception
}
````

<!-- pause -->

* Must be followed by at least one `catch` or a `finally`

<!-- end_slide -->

## The catch Block

A `catch` block handles the exception.

```java
try {
    // risky code
} catch (ExceptionType name) {
    // handler code
}
```

<!-- pause -->

* Runs only if matching exception occurs
* `name` gives access to the exception object

<!-- end_slide -->

## Example: Basic try-catch

```java
try {
    int[] arr = {1, 2, 3};
    System.out.println(arr[5]);
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Invalid index!");
}
```

<!-- pause -->

* Prevents program crash
* Handles the error gracefully

<!-- end_slide -->

## Multiple catch Blocks

You can handle different exceptions separately:

```java
try {
    // code
} catch (IOException e) {
    // handle IO
} catch (SQLException e) {
    // handle DB
}
```

<!-- pause -->

* Only one `catch` block executes
* Order matters (specific → general)

<!-- end_slide -->

## Catch Order Matters

```java
catch (Exception e) { }   // general
catch (IOException e) { } // ❌ unreachable
```

<!-- pause -->

Correct order:

```java
catch (IOException e) { }
catch (Exception e) { }
```

<!-- end_slide -->

## Multi-Catch (Java 7+)

Handle multiple exceptions in one block:

```java
try {
    // code
} catch (IOException | SQLException e) {
    System.out.println("Exception occurred");
}
```

<!-- pause -->

* Reduces duplication
* Exception variable is implicitly final

<!-- end_slide -->

## The finally Block

The `finally` block always executes:

```java
try {
    // code
} catch (Exception e) {
    // handler
} finally {
    // always runs
}
```

<!-- pause -->

* Executes whether exception occurs or not
* Commonly used for cleanup

<!-- end_slide -->

## Example: finally Usage

```java
FileReader file = null;

try {
    file = new FileReader("file.txt");
} catch (IOException e) {
    e.printStackTrace();
} finally {
    if (file != null) {
        file.close();
    }
}
```

<!-- pause -->

Ensures resource is closed

<!-- end_slide -->

## try-with-resources (Java 7+)

Automatically closes resources:

```java
try (FileReader file = new FileReader("file.txt")) {
    // use file
}
```

<!-- pause -->

* No need for `finally`
* Resource must implement `AutoCloseable`

<!-- end_slide -->

## try-with-resources Example

```java
try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
    System.out.println(br.readLine());
} catch (IOException e) {
    e.printStackTrace();
}
```

<!-- pause -->

Cleaner and safer resource management

<!-- end_slide -->

## Accessing Exception Information

Exception object provides useful methods:

```java
catch (Exception e) {
    System.out.println(e.getMessage());
    e.printStackTrace();
}
```

<!-- pause -->

Common methods:

* `getMessage()`
* `printStackTrace()`

<!-- end_slide -->

## Stack Trace

Stack trace shows:

* Method call history
* Where the exception occurred

<!-- pause -->

Example:

```java
java.lang.NullPointerException
    at Main.main(Main.java:5)
```

<!-- end_slide -->

## Best Practices

<!-- incremental_lists: true -->

* Catch only what you can handle
* Avoid catching `Exception` unless necessary
* Always clean up resources
* Use try-with-resources when possible
* Log exceptions properly

<!-- end_slide -->

## Summary

<!-- incremental_lists: true -->

* Use `try` to wrap risky code
* Use `catch` to handle exceptions
* Use `finally` for cleanup
* Use try-with-resources for automatic closing
* Proper handling improves program reliability
