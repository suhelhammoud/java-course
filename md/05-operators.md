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


Operators
===

<!-- column_layout: [1, 1] -->
<!-- column: 0 -->
<!-- pause -->
## Operators Overview
- Special symbols that perform operations on operands
- Return a result
- Have different precedence levels
- Can be unary, binary, or ternary


<!-- pause -->
## Simple Assignment Operator
```java
int cadence = 0;
int speed = 0;
int gear = 1;
```
- Most common operator: `=`
- Assigns right value to left operand
- Also works with object references

<!-- column: 1 -->
<!-- pause -->
## Operator Precedence Table
| Operators | Precedence |
|-----------|------------|
| postfix | expr++ expr-- |
| unary | ++expr --expr +expr -expr ~ ! |
| multiplicative | * / % |
| additive | + - |
| shift | << >> >>> |
| relational | < > <= >= instanceof |
| equality | == != |
| bitwise AND | & |
| bitwise OR | ^ \| |
| logical AND | && |
| logical OR | \|\| |
| ternary | ? : |
| assignment | = += -= *= /= %= &= ^= \|= <<= >>= >>>= |

<!-- reset_layout -->
<!-- end_slide -->

Operators
===
<!-- column_layout: [1, 1] -->
<!-- column: 0 -->
<!-- pause -->
## Arithmetic Operators
| Operator | Description |
|----------|-------------|
| + | Addition (also string concatenation) |
| - | Subtraction |
| * | Multiplication |
| / | Division |
| % | Remainder |

Example:
```java
int result = 1 + 2;  // 3
result = result * 2; // 6
result = result % 5; // 1
```

<!-- column: 1 -->
<!-- pause -->
## Compound Assignment Operators
Combine arithmetic with assignment:
```java
x += 1;  // Same as x = x + 1
y *= 2;  // Same as y = y * 2
```

String concatenation:
```java
String s1 = "Hello";
String s2 = "World";
String s3 = s1 + " " + s2;  // "Hello World"
```

<!-- reset_layout -->
<!-- end_slide -->

Operators
===
<!-- column_layout: [1, 1] -->
<!-- column: 0 -->
<!-- pause -->
## Unary Operators
| Operator | Description |
|----------|-------------|
| + | Unary plus |
| - | Unary minus |
| ++ | Increment |
| -- | Decrement |
| ! | Logical complement |

<!-- pause -->
Example:
```java
int x = +1;  // 1
x++;         // 2
x = -x;      // -2
boolean b = !true;  // false
```
<!-- column: 1 -->
<!-- pause -->
## Prefix vs Postfix
```java
int i = 3;
i++;    // returns 3, i becomes 4
++i;    // returns 5, i becomes 5
System.out.println(i++);  // prints 5, i becomes 6
System.out.println(++i);  // prints 7, i becomes 7
```
<!-- pause -->
<!-- end_slide -->

Operators
===

<!-- column_layout: [1, 1] -->
<!-- column: 0 --> 
 <!-- pause -->
 ## Equality and Relational Operators
| Operator | Description |
|----------|-------------|
| == | Equal to |
| != | Not equal |
| > | Greater than |
| >= | Greater or equal |
| < | Less than |
| <= | Less or equal |

Example:
```java
if (a == b) {...}
if (x >= y) {...}
```
<!-- column: 1 --> 
<!-- pause -->
## Conditional Operators
| Operator | Description |
|----------|-------------|
| && | Conditional AND (short-circuit) |
| \|\| | Conditional OR (short-circuit) |
| ?: | Ternary operator |

Examples:
```java
if (a && b) {...}
int max = (x > y) ? x : y;
```
<!-- reset_layout -->
<!-- end_slide -->

Operators
===

<!-- column_layout: [1, 1] -->
<!-- column: 0 -->
<!-- pause -->
## instanceof Operator
Tests object type:
```java
Parent p = new Child();
System.out.println(p instanceof Parent);   // true
System.out.println(p instanceof Child);    // true
System.out.println(p instanceof MyInterface); // true if implemented
```
- `null` is not an instance of anything

<!-- column: 1 -->
<!-- pause -->
## Bitwise Operators
| Operator | Description |
|----------|-------------|
| ~ | Bitwise complement |
| << | Left shift |
| >> | Signed right shift |
| >>> | Unsigned right shift |
| & | Bitwise AND |
| ^ | Bitwise XOR |
| \| | Bitwise OR |

<!-- pause -->
Example:
```java
int mask = 0x000F;
int val = 0x2222;
System.out.println(val & mask);  // prints 2
```
<!-- reset_layout -->

