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


Control Flow Statements
===

## The If-Then Statement
- Executes code block if condition is true

```java
void applyBrakes() {
    if (isMoving) {
        currentSpeed--;
    }
}
```
- Braces optional for single statements

```java
// Without braces
void applyBrakes() {
    if (isMoving)
        currentSpeed--;
}
```

Best Practice: Always use braces for better maintainability

<!-- end_slide -->

Control Flow Statements
===

## The If-Then-Else Statement
### Provides alternative execution path when condition is false

```java
void applyBrakes() {
    if (isMoving) {
        currentSpeed--;
    } else {
        System.err.println("Bicycle already stopped!");
    }
}
```

### Multiple conditions:
```java
if (testscore >= 90) {
    grade = 'A';
} else if (testscore >= 80) {
    grade = 'B';
} // ... and so on
```

<!-- end_slide -->

## While Loop
- **checks condition first**

```java
// While loop
while (count < 11) {
    System.out.println("Count: " + count);
    count++;
}
```

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

- Compact iteration over range of values
- Three parts: initialization, condition, increment

```java
for (int i = 1; i < 11; i++) {
    System.out.println("Count: " + i);
}
```
### Infinit for loop
```java
for (;;) {
    // your code goes here
}
```
### Enhanced for loop

```java
int[] numbers = {1, 2, 3, 4, 5};
for (int num : numbers) {
    System.out.println(num);
}
```

<!-- end_slide -->

## Break Statement
- Terminates loops or switch statements
- Can be labeled or unlabeled

```java
for (int i = 0; i < array.length; i++) {
    if (array[i] == searchfor) {
        foundIt = true;
        break;
    }
}
```

### Labeled break
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

<!-- end_slide -->

## Continue Statement
- Skips current iteration
- Can be labeled or unlabeled

```java
// Unlabeled continue
for (int i = 0; i < max; i++) {
    if (str.charAt(i) != 'p') continue;
    numPs++;
}
```
### Labeled continue
```java
test:
for (int i = 0; i <= max; i++) {
    // ...
    if (condition) continue test;
}
```

<!-- end_slide -->

## Return Statement
- Exits current method
- Returns value if method isn't void

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

<!-- end_slide -->

## Yield Statement
- Exits switch expression
- Returns value for switch expression

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

