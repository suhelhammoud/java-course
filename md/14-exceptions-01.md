---
title: Object Oriented Programming in Java
sub_title: Exceptions in Java
author: Suhel Hammoud

theme:
  override:
    code:
        alignment: left
---

# What Is an Exception?

An **exception** is an event that occurs during program execution that disrupts the normal flow of instructions.

<!-- pause -->

When an error occurs:
- Java creates an **exception object**
- The object contains information about the error
- The program flow is interrupted

<!-- end_slide -->

## Example of an Exception

```java
int[] numbers = {1, 2, 3};
System.out.println(numbers[5]); // Exception!
````

<!-- pause -->

This causes:

* `ArrayIndexOutOfBoundsException`
* Because index 5 does not exist

<!-- end_slide -->

## What Happens When an Exception Occurs?

When an exception happens:

<!-- incremental_lists: true -->

* An exception object is created
* The runtime system searches for a handler
* If found → exception is handled
* If not → program terminates

<!-- pause -->

This process is called **exception handling**

<!-- end_slide -->

## Exception Object

An exception object contains:

<!-- incremental_lists: true -->

* Type of error
* Location where it occurred
* Stack trace (call history)

<!-- pause -->

Example:

```java
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException
```

<!-- end_slide -->

## Exception Hierarchy

All exceptions are part of a class hierarchy.

<!-- pause -->

Top class:

```java
java.lang.Throwable
```

<!-- pause -->

Main subclasses:

* `Error`
* `Exception`

<!-- end_slide -->

## Errors vs Exceptions

<!-- column_layout: [1, 1] -->

<!-- column: 0 -->

### Errors

<!-- pause -->

* Serious problems
* Not meant to be handled
* Example:

```java
OutOfMemoryError
```

<!-- column: 1 -->

### Exceptions

<!-- pause -->

* Conditions applications may handle
* Recoverable
* Example:

```java
IOException
```

<!-- reset_layout -->

<!-- end_slide -->

## Checked vs Unchecked Exceptions

### Checked Exceptions

<!-- pause -->

* Checked at compile time
* Must be handled or declared

```java
IOException
```

<!-- pause -->

### Unchecked Exceptions

* Occur at runtime
* Not required to handle

```java
NullPointerException
```

<!-- end_slide -->

## Checked Exception Example

```java
FileReader file = new FileReader("file.txt");
```

<!-- pause -->

Compiler error unless handled:

```java
try {
    FileReader file = new FileReader("file.txt");
} catch (IOException e) {
    e.printStackTrace();
}
```

<!-- end_slide -->

## Unchecked Exception Example

```java
String str = null;
System.out.println(str.length()); // NullPointerException
```

<!-- pause -->

* No compile-time error
* Fails at runtime

<!-- end_slide -->

## The Role of the Runtime System

The runtime system:

<!-- incremental_lists: true -->

* Detects exceptions
* Creates exception objects
* Searches the call stack for a handler

<!-- pause -->

If no handler is found:

* Program terminates

<!-- end_slide -->

## Call Stack Search

When an exception occurs:

<!-- incremental_lists: true -->

* JVM checks current method
* If no handler → moves up the call stack
* Continues until a handler is found

<!-- pause -->

If none found:

* Default handler prints stack trace

<!-- end_slide -->

## Why Use Exceptions?

<!-- incremental_lists: true -->

* Separate error-handling code from regular code
* Improve readability
* Handle unexpected situations gracefully
* Prevent program crashes

<!-- end_slide -->

## Summary

<!-- incremental_lists: true -->

* Exceptions represent runtime problems
* They are objects in Java
* Managed using the exception handling mechanism
* Divided into:

  * Checked
  * Unchecked
* Help build robust applications
