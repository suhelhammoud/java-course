---
title: Object Oriented Programming in Java
sub_title: Abstract, Default, and Static Methods in Interfaces
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


# Java Interfaces: Methods Overview

In Java, an **interface** is a contract that defines method signatures which classes agree to implement. Since Java 8, interfaces can also include **default** and **static** methods.

<!-- end_slide -->

## 1. Abstract Methods

These are the original type of methods in interfaces.
<!-- incremental_lists: true -->
- **No body**; must be implemented by the class.
- Declared without `abstract` keyword (implicitly abstract).

```java
interface Drawable {
    void draw(); // abstract method
}
```

<!-- end_slide -->

## 2. Default Methods
<!-- pause -->
Introduced in **Java 8** to allow adding method implementations without breaking existing code.
<!-- incremental_lists: true -->

- Marked with `default`
- Can be inherited or overridden by implementing classes

```java
interface Drawable {
    default void print() {
        System.out.println("Drawing...");
    }
}
```

<!-- end_slide -->


## 3. Static Methods
<!-- pause -->
Also introduced in Java 8.
<!-- incremental_lists: true -->

- Belong to the interface itself (not to instances)
- Not inherited by implementing classes

```java
interface Drawable {
    static void info() {
        System.out.println("Interface for drawable objects.");
    }
}
```

**Usage:**  
```java
Drawable.info(); // Access via interface name
```

<!-- end_slide -->

## Summary Table

| Method Type     | Keyword   | Can Have Body | Can Be Overridden | Inherited |
|----------------|-----------|---------------|-------------------|-----------|
| Abstract        | *none*    | ❌            | ✅ (must be)       | ✅         |
| Default         | `default` | ✅            | ✅ (optional)      | ✅         |
| Static          | `static`  | ✅            | ❌                | ❌         |

