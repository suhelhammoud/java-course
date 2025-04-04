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

Enum Classes
===



## What are Enums?

- Enums are classes where all instances are known to the compiler.
- Used for creating types with a fixed set of possible values.
- Created using the `enum` keyword instead of `class`.
- Enum constants are listed in the body, separated by commas.
- No instances can be created outside of enum constants.

```java
public enum DayOfWeek {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
```

- All enums implicitly extend `java.lang.Enum` and cannot have subclasses.

<!-- end_slide -->


Accessing, Evaluating, and Comparing Enums
===

- Enum values can be used as constants.
- Use `==` to compare enum instances.

```java
DayOfWeek weekStart = DayOfWeek.MONDAY;

if (weekStart == DayOfWeek.MONDAY) {
    System.out.println("The week starts on Monday.");
}
```

- Use `switch` for actions based on enum values.

```java
DayOfWeek someDay = DayOfWeek.FRIDAY;

switch (someDay) {
    case MONDAY -> System.out.println("The week just started.");
    case TUESDAY, WEDNESDAY, THURSDAY -> System.out.println("We are in the middle of the week.");
    case FRIDAY -> System.out.println("The weekend is near.");
    case SATURDAY, SUNDAY -> System.out.println("Weekend");
    default -> throw new AssertionError("Should not happen");
}
```

- Switch expressions ensure **exhaustiveness** (all enum values are handled).


<!-- end_slide -->


Enum Members
===

## Adding memebers to enum
- Enums can have constructors, methods, and fields.
- Add a `;` after the enum constants list to define members.

```java
public enum DayOfWeek {
    MONDAY("MON"), TUESDAY("TUE"), WEDNESDAY("WED"), 
    THURSDAY("THU"), FRIDAY("FRI"), SATURDAY("SAT"), SUNDAY("SUN");
    
    private final String abbreviation;
    
    DayOfWeek(String abbreviation) {
        this.abbreviation = abbreviation;
    }
    
    public String getAbbreviation() {
        return abbreviation;
    }
}
```

## Using Enums as Singletons: define a single enum constant


```java
public enum SomeSingleton {
    INSTANCE;
    // Fields, methods, etc.
}
```
<!-- end_slide -->

Enum Methods
===
## Special Methods in Enums

- **Instance Methods**:
  - `name()`: Returns the name of the enum constant.
  - `ordinal()`: Returns the position of the enum constant in the declaration.

```java
System.out.println(DayOfWeek.MONDAY.name());    // "MONDAY"
System.out.println(DayOfWeek.MONDAY.ordinal()); // "0"
```

- **Static Methods**:
  - `values()`: Returns an array of all enum instances.
  - `valueOf(String)`: Returns an enum instance by name.

```java
DayOfWeek[] days = DayOfWeek.values(); // All days
DayOfWeek monday = DayOfWeek.valueOf("MONDAY");
```

- Enums implement `Comparable` and are ordered by their ordinal number.


<!-- end_slide -->

Enums (cont.)
===



## Abstract Methods in Enums

- Enums can have abstract methods, but each enum constant must provide an implementation.

```java
enum MyEnum {
    A() {
        @Override
        void doSomething() {
            System.out.println("a");
        }
    },
    B() {
        @Override
        void doSomething() {
            System.out.println("b");
        }
    };
    
    abstract void doSomething();
}
```

<!-- end_slide -->

Enum: Precautions and Summary
===

## Precautions with Enums

- **Changes to Enum Constants**:
  - Adding, removing, or renaming enum constants can break code.
  - Review all code using the enum when making changes.
- **Large Number of Instances**:
  - For many instances, consider using a configuration file instead of listing all in code.


## Conclusion

- Enums provide a simple and safe way to represent a fixed set of constants.
- They are elegant, readable, and work well with modern Java features like switch expressions.
- Enums are a special type of class, similar to **Records** (introduced in Java 14).
- For more details, visit the [Enum javadoc](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Enum.html).