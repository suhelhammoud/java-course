---
theme:
  override:
    code:
        alignment: left
        margin:
            percent: 5
    #   padding:
        # horizontal: 4
---


Expressions
===
<!-- pause -->
## Expressions
- Constructs with variables, operators, method calls
- Evaluate to a single value
- Data type depends on elements used

<!-- pause -->
```java
int result = 1 + 2;  // evaluates to 3
anArray[0] = 100;    // assignment expression
value1 == value2     // boolean expression
```

<!-- pause -->
## Compound Expressions
- Combine smaller expressions
- Type compatibility required
- Evaluation order matters

<!-- pause -->
```java
1 * 2 * 3          // order doesn't matter
x + y / 100        // ambiguous
(x + y) / 100      // unambiguous
```

<!-- pause -->
**Best Practice:** Use parentheses to:
- Make order explicit
- Improves readability and maintainability

<!-- end_slide -->

Expressions
===
<!-- pause -->
## Operator Precedence
- Determines evaluation order when ambiguous
- Higher precedence operators evaluated first
- Example: division before addition

<!-- pause -->
```java
x + y / 100    // same as x + (y / 100)
```

<!-- pause -->
## Floating Point Arithmetic
- Special behavior due to rounding
- May produce unexpected results

<!-- pause -->
Example:
```java
double d1 = 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1;
System.out.println("d1 == 1 ? " + (d1 == 1.0)); //false
```

<!-- pause -->
**Note:**
- Floating-point math has precision limitations
- Requires special handling for comparisons

<!-- end_slide -->

Statements
===

<!-- column_layout: [1, 1] -->
<!-- column: 0 -->
<!-- pause -->
## What is a statement?
<!-- pause -->
- Complete units of execution
<!-- pause -->
- Terminated with semicolon (;) 
<!-- pause -->
- **Types**:
  - Expression statements
  - Declaration statements
  - Control flow statements


<!-- pause -->
## Expression Statements
Examples:
```java
// assignment statement
aValue = 8933.234;

// increment statement
aValue++;

// method invocation statement
System.out.println("Hello World!");

// object creation statement
Bicycle myBike = new Bicycle();
```

<!-- column: 1 -->
<!-- pause -->
## Declaration Statements
- Declare variables
- May include initialization

<!-- pause -->
Examples:
```java
int count;
double aValue = 8933.234;
String name = "Java";
```

<!-- pause -->
## Control Flow Statements
<!-- pause -->
- Used to change program flow
<!-- pause -->
- Examples:
  - If-then statements
  - While loops
  - For loops
  - Switch statements
  - Break and continue statements
  - Return statements

<!-- reset_layout -->
<!-- end_slide -->

Blocks
===

<!-- pause -->
## What is blocks?
- Group of statements in { }
- Can be used anywhere single statement is allowed
- Used in control flow structures

<!-- pause -->
```java
class BlockDemo {
     public static void main(String[] args) {
          boolean condition = true;
          if (condition) { // begin block 1
               System.out.println("Condition is true.");
          } // end block one
          else { // begin block 2
               System.out.println("Condition is false.");
          } // end block 2
     }
}
```

<!-- pause -->

## Lecture Summary
<!-- pause -->
- **Expressions evaluate to values**
<!-- pause -->
- **Statements perform actions**
<!-- pause -->
- **Blocks organize statements**
<!-- pause -->
- **Precedence and parentheses control evaluation order**
<!-- pause -->
- **Floating-point requires special care**

