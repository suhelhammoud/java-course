---
title: Object Oriented Programming in Java
sub_title: Unchecked Exception Controversy
author: Suhel Hammoud

theme:
  override:
    code:
        alignment: left
---

# Unchecked Exception Controversy

Java distinguishes between:
- Checked exceptions  
- Unchecked exceptions  

<!-- pause -->

But this design has been **controversial** among developers.

<!-- end_slide -->

## What Is the Controversy?

The debate centers on:

<!-- incremental_lists: true -->
- Should exceptions be enforced at compile time?  
- Or handled only at runtime?  

<!-- pause -->

Different developers prefer different approaches.

<!-- end_slide -->

## Checked Exceptions (Reminder)

<!-- incremental_lists: true -->
- Must be declared using `throws`  
- Must be handled or propagated  
- Checked at compile time  

<!-- pause -->

Example:

```java
void read() throws IOException { }
````

<!-- end_slide -->

## Unchecked Exceptions (Reminder)

<!-- incremental_lists: true -->

* Extend `RuntimeException`
* Not required to be declared
* Occur at runtime

<!-- pause -->

Example:

```java
int x = 5 / 0; // ArithmeticException
```

<!-- end_slide -->

## Advantages of Checked Exceptions

<!-- incremental_lists: true -->

* Forces developers to handle errors
* Makes APIs explicit about failures
* Improves reliability

<!-- pause -->

Encourages careful programming

<!-- end_slide -->

## Disadvantages of Checked Exceptions

<!-- incremental_lists: true -->

* Leads to verbose code
* Can clutter method signatures
* Often handled poorly (empty catch blocks)

<!-- pause -->

Developers may ignore or misuse them

<!-- end_slide -->

## Advantages of Unchecked Exceptions

<!-- incremental_lists: true -->

* Cleaner, less verbose code
* No need to declare in methods
* Better for programming errors

<!-- pause -->

More flexible design

<!-- end_slide -->

## Disadvantages of Unchecked Exceptions

<!-- incremental_lists: true -->

* Errors may go unnoticed
* No compile-time enforcement
* Can lead to runtime failures

<!-- pause -->

Requires discipline from developers

<!-- end_slide -->

## Design Philosophy

Two main philosophies:

<!-- column_layout: [1, 1] -->

<!-- column: 0 -->

### Checked Approach

<!-- pause -->

* Safer
* Explicit
* Compiler-enforced

<!-- column: 1 -->

### Unchecked Approach

<!-- pause -->

* Simpler
* Flexible
* Developer responsibility

<!-- reset_layout -->

<!-- end_slide -->

## When to Use Checked Exceptions

<!-- incremental_lists: true -->

* Recoverable conditions
* External system failures (I/O, network)
* Situations caller can handle

<!-- end_slide -->

## When to Use Unchecked Exceptions

<!-- incremental_lists: true -->

* Programming errors
* Invalid arguments
* Bugs (null references, logic errors)

<!-- end_slide -->

## Real-World Practice

<!-- incremental_lists: true -->

* Many modern APIs favor unchecked exceptions
* Checked exceptions still used in core Java APIs
* Teams define their own conventions

<!-- pause -->

No universal agreement

<!-- end_slide -->

## Key Insight

<!-- pause -->

Exceptions are not just technical —
they reflect **design decisions**.

<!-- pause -->

Choosing between checked and unchecked:

* Impacts usability
* Affects code clarity
* Influences error handling strategy

<!-- end_slide -->

## Best Practices

<!-- incremental_lists: true -->

* Use checked exceptions for recoverable cases
* Use unchecked for programming errors
* Avoid overusing either type
* Provide clear error messages
* Be consistent in your design

<!-- end_slide -->

## Summary

<!-- incremental_lists: true -->

* Java supports two exception types
* Each has pros and cons
* The choice is a design decision
* No single “correct” approach
* Balance safety and simplicity
