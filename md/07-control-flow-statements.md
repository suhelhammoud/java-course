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


If-Then-Else Statement:
===

<!-- column_layout: [1, 1] -->
<!-- column: 0 -->
<!-- pause -->
## The If-Then Statement
- Executes code block if condition is true

<!-- pause -->
```java
void applyBrakes() {
    if (isMoving) {
        currentSpeed--;
    }
}
```
<!-- pause -->
- Braces optional for single statements

```java
// Without braces
void applyBrakes() {
    if (isMoving)
        currentSpeed--;
}
```
<!-- pause -->
**Best Practice**: Always use braces for better maintainability

<!-- column: 1 -->

<!-- pause -->
## The If-Then-Else Statement
<!-- pause -->
### alternative execution path when condition is false

```java
void applyBrakes() {
    if (isMoving) {
        currentSpeed--;
    } else {
        System.err.println("Bicycle already stopped!");
    }
}
```

<!-- pause -->
### Multiple conditions:
```java
if (testscore >= 90) {
    grade = 'A';
} else if (testscore >= 80) {
    grade = 'B';
} // ... and so on
```
<!-- reset_layout -->
<!-- end_slide -->

While Loop
===

<!-- pause -->
## While Loop
<!-- pause -->
- **checks condition first**

```java
// While loop
while (count < 11) {
    System.out.println("Count: " + count);
    count++;
}
```

<!-- pause -->
## Do-while Loop:
- **executes at least once**

```java
// Do-while loop
do {
    System.out.println("Count: " + count);
    count++;
} while (count < 11);
```

<!-- end_slide -->

For Loop
===

<!-- pause -->
- Compact iteration over range of values
- Three parts: initialization, condition, increment

<!-- pause -->
```java
for (int i = 1; i < 11; i++) {
    System.out.println("Count: " + i);
}
```
<!-- pause -->
## Infinit for loop
```java
for (;;) {
    // your code goes here
}
```
<!-- pause -->
## Enhanced for loop

```java
int[] numbers = {1, 2, 3, 4, 5};
for (int num : numbers) {
    System.out.println(num);
}
```

<!-- end_slide -->

**Break and Continue Statemenets**
===
<!-- column_layout: [1, 1] -->
<!-- column: 0 -->
<!-- pause -->
## Break Statement
- Terminates loops or switch statements
- Can be labeled or unlabeled

<!-- pause -->
```java
for (int i = 0; i < array.length; i++) {
    if (array[i] == searchfor) {
        foundIt = true;
        break;
    }
}
```

<!-- pause -->
## Labeled break
```java
search:
for (i = 0; i < array.length; i++) {
    for (j = 0; j < array[i].length; j++) {
        if (array[i][j] == searchfor) {
            break search;
        }
    }
}
```

<!-- column: 1 -->

<!-- pause -->
## Continue Statement
- Skips current iteration
- Can be labeled or unlabeled

<!-- pause -->
```java
// Unlabeled continue
for (int i = 0; i < max; i++) {
    if (str.charAt(i) != 'p') continue;
    numPs++;
}
```
<!-- pause -->
## Labeled continue
<!-- pause -->
```java
test:
for (int i = 0; i <= max; i++) {
    // ...
    if (condition) continue test;
}
```
<!-- reset_layout -->
<!-- end_slide -->

**Return and Yeild Statements**
===

<!-- column_layout: [3, 5] -->
<!-- column: 0 -->
<!-- pause -->
## Return Statement
- Exits current method
- Returns value if method isn't void

<!-- pause -->
```java
// With return value
public int increment(int count) {
    return ++count;
}

// Without return value
public void printMessage() {
    System.out.println("Hello");
    return;
}
```
<!-- column: 1 -->

<!-- pause -->
## Yield Statement
- Exits switch expression
- Returns value for switch expression

<!-- pause -->
```java
class Test {
    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public int calculate(Day d) {
        return switch (d) {
            case SATURDAY, SUNDAY -> 0;
                default -> {
                    int remainingWorkDays = 5 - d.ordinal();
                    yield remainingWorkDays;
                }
            };
    }
}
```
<!-- reset_layout -->
