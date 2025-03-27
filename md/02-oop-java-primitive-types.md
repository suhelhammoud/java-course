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

primitive-types
===

<!-- column_layout: [1, 1] -->
<!-- column: 0 -->
<!-- new_line -->
<!-- reset_layout -->
<!-- end_slide -->



### **Primitive Type Variables in Java**  
- Java is **statically-typed**: Variables must be declared before use.  
- Example:  
```java
int gear = 1; // Declares + initializes
```  
- Primitive types are **predefined** (8 types) and store simple values.  

<!-- new_line -->

### **The 8 Primitive Data Types**  
| Type    | Size/Bits | Description                          | Example           |
|---------|-----------|--------------------------------------|-------------------|
| `byte`  | 8         | Small integer (-128 to 127)          | `byte b = 100;`   |
| `short` | 16        | Medium integer (-32K to 32K)         | `short s = 10000;`|
| `int`   | 32        | Default integer (-2³¹ to 2³¹-1)      | `int i = 100000;` |
| `long`  | 64        | Large integer (ends with `L`)        | `long l = 100L;`  |
| `float`  | 32        | Single-precision (ends with `F`)     | `float f = 3.14f;`   |
| `double` | 64        | Double-precision (default)           | `double d = 3.14;`   |
| `boolean`| 1 bit     | `true`/`false`                       | `boolean flag = true;` |
| `char`   | 16        | Unicode character (single quotes)    | `char c = 'A';`      |


**Note:**  `String` is a class (not primitive), but has special support.  
```java
String s = "Hello"; // Double quotes
```  

<!-- end_slide -->

<!-- column_layout: [1, 1] -->
<!-- column: 0 -->


### **Default Values (For Fields)**  
Uninitialized fields get defaults:  

| Type     | Default Value |
|----------|---------------|
| `byte`   | `0`           |
| `int`    | `0`           |
| `long`   | `0L`          |
| `float`  | `0.0f`        |
| `double` | `0.0d`        |
| `char`   | `\u0000`      |
| `boolean`| `false`       |
| Objects  | `null`        |

**Warning:** Local variables **must** be initialized on declaration or must be assigned before you use them.

<!-- column: 1 -->


### **Creating Values with Literals**  
- No `new` keyword needed for primitives.  
- Examples:  
```java
boolean result = true;  
char capitalC = 'C';    
int i = 100_000;        // Underscores allowed
double d = 1.234e2;     // Scientific notation
```  

**Special Cases:**  
- `long` ends with `L` or `l`: `long num = 100L;`  
- `float` ends with `F` or `f`: `float pi = 3.14F;`  

<!-- reset_layout -->
<!-- end_slide -->


<!-- column_layout: [1, 1] -->
<!-- column: 0 -->

### **Number Systems for int Literals**  
| System       | Prefix | Example           |
|--------------|--------|-------------------|
| Decimal      | None   | `26`              |
| Hexadecimal  | `0x`   | `0x1a` (equals 26)|
| Binary       | `0b`   | `0b11010` (26)    |

**Underscores for Readability:**

```java
long creditCard = 1234_5678_9012_3456L; // Valid
int x = 52_;                            // Invalid!
```  

<!-- column: 1 -->

### **Special Literals & Escapes**  
- **String/Char Escapes:**  
```java
String s = "S\u00ED Se\u00F1or"; // "Sí Señor"
char tab = '\t';                  // Tab character
```  
- **Null Literal:**  
```java
String s = null; // No object reference
```  
- **Class Literal:**  
```java
Class<?> cls = String.class; // String's Class object
```  
<!-- reset_layout -->
<!-- end_slide -->


### **Floating-Point Literals in Java**
- Used to represent decimal numbers
- Two types: `float` (32-bit) and `double` (64-bit)
- Default type is `double` when no suffix is specified

<!-- end_slide -->

Floating Point Literals
===

<!-- column_layout: [1, 1] -->
<!-- column: 0 -->

### **Type Specification**
| Type    | Suffix | Example           |
|---------|--------|-------------------|
| `float` | F or f | `123.4f`          |
| `double`| D or d (optional) | `123.4` or `123.4d` |

**Note:**  
- `double` is the default floating-point type in Java
- The `D` or `d` suffix is typically omitted by convention


### **Scientific Notation**
- Can use `E` or `e` for scientific notation
- Examples:
```java
double d1 = 123.4;      // Regular notation
double d2 = 1.234e2;    // Scientific notation (1.234 × 10²)
float f1 = 123.4f;      // Explicit float
float f2 = 1.234e2f;    // Scientific float
```

<!-- column: 1 -->

### **Key Characteristics**
- **Precision:**
   - `float`: ~6-7 decimal digits
   - `double`: ~15 decimal digits

- **Usage Guidelines:**
   - Use `double` for most cases (default)
   - Use `float` only when memory optimization is critical
   - Never use for precise values (e.g., currency)


### **Examples Comparison**
```java
// Equivalent values
double a = 123.4;
double b = 1.234e2;    // 1.234 × 100 (10²)
double c = 123.4d;

// Float examples
float x = 123.4f;
float y = 1.234e2f;    // Scientific float
```

**Note:**  
Scientific notation is particularly useful for very large or very small numbers

<!-- reset_layout -->
<!-- end_slide -->

**Character and String Literals**
===

<!-- column_layout: [1, 1] -->
<!-- column: 0 -->

### **Character and String Literals**
- `char` uses single quotes: `'A'`
- `String` uses double quotes: `"Hello"`
- Supports full Unicode (UTF-16) characters
- Can use direct Unicode chars or escape sequences
```java
char c = '€';       // Direct
char c = '\u20AC';  // Escape sequence
```


### **Special Escape Sequences**
| Sequence | Meaning          | Example                   |
|----------|------------------|---------------------------|
| `\b`     | Backspace        | `"Hello\b"` → "Hell"      |
| `\t`     | Tab              | `"Name\tAge"`             |
| `\n`     | Newline          | `"Line1\nLine2"`          |
| `\"`     | Double quote     | `"She said \"Hi\""`       |
| `\'`     | Single quote     | `'\''`                    |
| `\\`     | Backslash        | `"C:\\path"`              |


<!-- column: 1 -->

### **Null and Class Literals**
* **Null Literal:**
```java
String s = null;  // Indicates no object
```
  - Can't be used with primitive types
  - Used for reference types only

* **Class Literal:**
  - This refers to the object that represents the type itself
```java
Class<?> cls = String.class;
```

<!-- reset_layout -->
<!-- end_slide -->


### **Underscores in Numeric Literals** (Java 7+)
- Improves readability of large numbers
- Can group digits in any pattern:
```java
int million = 1_000_000;
long creditCard = 1234_5678_9012_3456L;
float pi = 3.141_592f;
```

**Rules:**
- Can't start/end with `_`
- Can't be adjacent to decimal points
- Can't be before type suffixes

<!-- end_slide -->


### **Valid vs Invalid Underscores**
✅ Valid:
```java
int x = 1_000_000;
float f = 3.141_592f;
long hex = 0xCAFE_BABE;
```

❌ Invalid:
```java
int x = _1000;      // Starts with _
float f = 3._14159; // Adjacent to .
long l = 1000_L;    // Before suffix
```

<!-- end_slide -->


### **Practical Examples**
1. **String with Escapes:**
```java
String path = "C:\\Users\\Name\\file.txt";
String poem = "Roses are red\nViolets are blue";
```

2. **Readable Numbers:**
```java
long population = 7_900_000_000L;
int mask = 0b1111_0000_1100_1101;
```

<!-- end_slide -->