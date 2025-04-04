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

Var Type Identifier
===


<!-- column_layout: [1, 1] -->
<!-- column: 0 -->
<!-- pause -->
## The var Keyword

<!-- pause -->
- Introduced in Java SE 10
<!-- pause -->
- `var` declares a local variable with type inferred by compiler
<!-- pause -->
- Type is fixed after declaration

<!-- pause -->
**Before:**
```java
String message = "Hello world!";
Path path = Path.of("debug.log");
InputStream stream = Files.newInputStream(path);
```
<!-- pause -->
**After:**
```java
var message = "Hello world!";
var path = Path.of("debug.log");
var stream = Files.newInputStream(path);
```
<!-- column: 1 -->
<!-- pause -->
## Examples with Var

<!-- pause -->
### List Iteration Example
```java
var list = List.of("one", "two", "three", "four");
for (var element: list) {
    System.out.println(element);
}
```
- `list` inferred as `List<String>`
- `element` inferred as `String`

<!-- pause -->
### Try-with-resources Example
```java
var path = Path.of("debug.log");
try (var stream = Files.newInputStream(path)) {
    // process the file
}
```
- `path` inferred as `Path`
- `stream` inferred as `InputStream`

<!-- end_slide -->

Var Type Identifier
===


<!-- column_layout: [1, 1] -->
<!-- column: 0 -->

<!-- pause -->
## **Restrictions on Using Var**
<!-- pause -->
1. Only for local variables in:
   - Methods
   - Constructors
   - Initializer blocks

<!-- pause -->
<!-- new_line -->
2. Cannot be used for:
   - Fields
   - Method parameters
   - Constructor parameters
<!-- pause -->
<!-- new_line -->

3. Must have initializer (can't be `null`)

<!-- pause -->
## Summary

- `var` simplifies local variable declarations
- Type is inferred at compile-time
- Several usage restrictions apply
- Cannot replace all explicit type declarations

<!-- column: 1 -->
<!-- pause -->
## Invalid Usage Examples

<!-- pause -->
### Field Declaration
```java
public class User {
    private var name = "Sue"; // COMPILER ERROR
    ...
}
```

<!-- pause -->
### Missing Initializer
```java
public String greetings(int message) {
    var greetings; // COMPILER ERROR
    if (message == 0) {
        greetings = "morning";
    } ...
}
```
<!-- reset_layout -->
