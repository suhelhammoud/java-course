---
title: Object Oriented Programming in Java
sub_title: Throwing Exceptions
author: Suhel Hammoud

theme:
  override:
    code:
        alignment: left
---

# Throwing Exceptions

In Java, you can explicitly throw exceptions using the `throw` statement.

<!-- pause -->

This allows you to:
- Signal that an error has occurred  
- Enforce rules in your program  

<!-- end_slide -->

## The throw Statement

Syntax:

```java
throw exceptionObject;
````

<!-- pause -->

* Used inside methods or blocks
* Must throw an object of type `Throwable`

<!-- end_slide -->

## Example: Throwing an Exception

```java
if (age < 18) {
    throw new IllegalArgumentException("Age must be at least 18");
}
```

<!-- pause -->

* Creates and throws exception immediately
* Stops normal program flow

<!-- end_slide -->

## What Happens After throw?

<!-- incremental_lists: true -->

* Execution stops at the `throw` statement
* Control is transferred to nearest handler
* If no handler → program terminates

<!-- end_slide -->

## Throwing Checked Exceptions

Checked exceptions must be declared using `throws`.

```java
public void readFile() throws IOException {
    throw new IOException("File error");
}
```

<!-- pause -->

* Compiler enforces handling
* Must be caught or declared

<!-- end_slide -->

## The throws Clause

Used in method declarations:

```java
public void methodName() throws ExceptionType {
    // code
}
```

<!-- pause -->

* Declares possible exceptions
* Passes responsibility to caller

<!-- end_slide -->

## Example: Using throws

```java
public void process() throws IOException {
    FileReader file = new FileReader("file.txt");
}
```

<!-- pause -->

Caller must handle it:

```java
try {
    process();
} catch (IOException e) {
    e.printStackTrace();
}
```

<!-- end_slide -->

## throw vs throws

<!-- column_layout: [1, 1] -->

<!-- column: 0 -->

### throw

<!-- pause -->

* Used inside method
* Throws one exception
* Followed by object

```java
throw new Exception();
```

<!-- column: 1 -->

### throws

<!-- pause -->

* Used in method signature
* Declares exceptions
* Can list multiple

```java
void m() throws IOException
```

<!-- reset_layout -->

<!-- end_slide -->

## Throwing Unchecked Exceptions

Unchecked exceptions do NOT require declaration:

```java
throw new NullPointerException("Null value!");
```

<!-- pause -->

* Not checked at compile time
* Often used for programming errors

<!-- end_slide -->

## When to Throw Exceptions

<!-- incremental_lists: true -->

* Invalid method arguments
* Violation of business rules
* Unexpected program state
* Input validation failures

<!-- end_slide -->

## Creating Custom Exceptions

You can define your own exception classes:

```java
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}
```

<!-- pause -->

Throw it like:

```java
throw new InvalidAgeException("Invalid age");
```

<!-- end_slide -->

## Checked vs Unchecked Custom Exceptions

<!-- column_layout: [1, 1] -->

<!-- column: 0 -->

### Checked

<!-- pause -->

* Extend `Exception`
* Must be declared

<!-- column: 1 -->

### Unchecked

<!-- pause -->

* Extend `RuntimeException`
* No declaration required

<!-- reset_layout -->

<!-- end_slide -->

## Example: Custom Exception Usage

```java
public void register(int age) throws InvalidAgeException {
    if (age < 18) {
        throw new InvalidAgeException("Must be 18+");
    }
}
```

<!-- pause -->

Ensures rule enforcement

<!-- end_slide -->

## Best Practices

<!-- incremental_lists: true -->

* Throw specific exceptions
* Include meaningful messages
* Avoid overusing checked exceptions
* Use custom exceptions when needed
* Do not use exceptions for normal flow

<!-- end_slide -->

## Summary

<!-- incremental_lists: true -->

* Use `throw` to explicitly raise exceptions
* Use `throws` to declare exceptions
* Checked exceptions must be handled
* Unchecked exceptions are optional to handle
* Custom exceptions improve clarity

