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

Branching with Switch Statement
===

<!-- column_layout: [1, 1] -->
<!-- column: 0 -->
<!-- pause -->
## Switch Statement Basics:
- Controls program flow based on selector variable
<!-- pause -->
- Supported types:
  - `byte`, `short`, `char`, `int`
  - `Character`, `Byte`, `Short`, `Integer`
  - `enum` types
  - `String` (Java SE 7+)

<!-- pause -->
```java
int quarter = 2;
String quarterLabel;
switch (quarter) {
    case 0: quarterLabel = "Q1 - Winter"; break;
    case 1: quarterLabel = "Q2 - Spring"; break;
    case 2: quarterLabel = "Q3 - Summer"; break;
    case 3: quarterLabel = "Q4 - Fall"; break;
    default: quarterLabel = "Unknown quarter";
}
```
<!-- column: 1 -->
<!-- pause -->
## Break and Fall-Through
- `break` terminates switch block
- Without `break`, execution falls through to next case

<!-- pause -->
```java
int month = 8;
List<String> futureMonths = new ArrayList<>();
switch (month) {
    case 1: futureMonths.add("January");
    case 2: futureMonths.add("February");
    // ... cases 3-7 ...
    case 8: futureMonths.add("August");
    // ... cases 9-11 ...
    case 12: futureMonths.add("December");
             break;
    default: break;
}
// futureMonths contains Aug-Dec
```
<!-- reset_layout -->
<!-- end_slide -->

Branching with Switch Statement
===

<!-- column_layout: [1, 1] -->
<!-- column: 0 -->
<!-- pause -->
## Multiple Case Labels
- Single block can handle multiple cases

<!-- pause -->
```java
switch (month) {
    case 1: case 3: case 5: case 7: 
    case 8: case 10: case 12:
        numDays = 31;
        break;
    case 4: case 6: case 9: case 11:
        numDays = 30;
        break;
    case 2:
        // February calculation
        break;
    default:
        System.out.println("Invalid month");
}
```
<!-- column: 1 -->
<!-- pause -->

## switch vs if-then-else 
<!-- pause -->
- **Switch**: single discrete values

<!-- pause -->
```java
// Good for switch
switch (month) {
    case 1: System.out.println("Jan"); break;
    // ...
}
```
<!-- pause -->
- **if-then-else**: ranges or conditions
<!-- pause -->
```java
// Requires if-else
if (temp < 0) {
    System.out.println("Ice");
} else if (temp < 100) {
    System.out.println("Liquid");
} else {
    System.out.println("Vapor");
}
```
<!-- reset_layout -->
<!-- end_slide -->

Branching with Switch Statement
===
<!-- column_layout: [1, 1] -->
<!-- column: 0 -->
<!-- pause -->

## String in Switch
<!-- pause -->
- Available since Java SE 7
- Case-sensitive comparison (use `toLowerCase()`)

<!-- pause -->
```java
String month = "February";
int monthNumber;
switch (month.toLowerCase()) {
    case "january": monthNumber = 1; break;
    case "february": monthNumber = 2; break;
    // ...
    default: monthNumber = 0; break;
}
```
<!-- column: 1 -->
<!-- pause -->
## Handling Null Values
<!-- pause -->
- Switch throws `NullPointerException` with null selector
- Always check for null first
<!-- pause -->
```java
String month = null;
if (month == null) {
    System.out.println("Month is null");
} else {
    switch (month.toLowerCase()) {
        // cases...
    }
}
```
<!-- reset_layout -->
<!-- end_slide -->

Branching with Switch Expressions
===
<!-- pause -->
## Switch Expressions (Java SE 14+)
<!-- pause -->
- More concise syntax
<!-- pause -->
- No fall-through behavior
<!-- pause -->
- Can return values
<!-- pause -->
- Multiple constants per case

<!-- column_layout: [1, 1] -->

<!-- column: 0 -->
<!-- pause -->

### **Traditional switch statement**

```java
Day day = Day.MONDAY;
int len = 0;
switch (day) {
    case MONDAY, FRIDAY, SUNDAY:
        len = 6;
        break;
    // ... other cases ...
}
```
<!-- column: 1 -->
<!-- pause -->
### ***Switch expression***
```java
int len = switch (day) {
    case MONDAY, FRIDAY, SUNDAY -> 6;
    case TUESDAY                -> 7;
    case THURSDAY, SATURDAY     -> 8;
    case WEDNESDAY              -> 9;
};
```

<!-- reset_layout -->
<!-- end_slide -->

Branching with Switch Expressions
===

<!-- column_layout: [1, 1] -->
<!-- column: 0 -->
<!-- pause -->
## Producing Values
- Entire switch can return a value
- Single expression: implicit return
- Block: use `yield` keyword

<!-- pause -->
## Simple expression
```java
String quarterLabel = switch (quarter) {
    case 0 -> "Q1 - Winter";
    case 1 -> "Q2 - Spring";
    default -> "Unknown quarter";
};
```
<!-- pause -->
## Block with yield
```java
String label = switch (quarter) {
    case 0 -> {
        System.out.println("Q1 - Winter");
        yield "Q1 - Winter";
    }
    default -> "Unknown quarter";
};
```
<!-- column: 1 -->
<!-- pause -->
## Exhaustiveness
- Switch expressions must cover all cases
- Default clause often needed
- Exception for complete enum coverage

<!-- new_line -->
```java
enum Season { SPRING, SUMMER, FALL, WINTER }

String weather = switch (season) {
    case SPRING -> "Rainy";
    case SUMMER -> "Sunny";
    case FALL   -> "Windy";
    case WINTER -> "Snowy";
    // No default needed - all cases covered
};
```
<!-- reset_layout -->
<!-- end_slide -->

Branching with Switch Expressions
===

<!-- column_layout: [1, 1] -->
<!-- column: 0 -->
<!-- pause -->
## Colon Syntax
- Traditional `case L:` syntax supported
- Requires explicit `yield`
- Fall-through still applies

<!-- pause -->
```java
String quarterLabel = switch (quarter) {
    case 0:  
        System.out.println("Winter");
        yield "Q1 - Winter";
    case 1:  
        yield "Q2 - Spring";
    default: 
        yield "Unknown quarter";
};
```

<!-- column: 1 -->
<!-- pause -->
## Null Handling
- Traditional switch throws NPE on null
- Java 17+ preview: null case support

<!-- pause -->
```java
String month = null;
String season = switch (month) {
    case "Jan", "Feb", "Dec" -> "Winter";
    case null -> "No month provided";  // Java 17+ preview
    default -> "Unknown season";
};
```
<!-- reset_layout -->
<!-- pause -->
### Best Practice:  
Always check for null before switching


