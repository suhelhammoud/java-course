---
title: Object Oriented Programming in Java
sub_title: Collections
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


# Storing Data Using the Collections Framework

## Introducing the Collections Framework

The Collections Framework is the most widely used API of the JDK. Whatever the application is, odds are you'll need to store and process data in memory.

It implements classic data structure concepts efficiently, evolving since Java SE 2 (1998):

- Java SE 5: Introduced generics  
- Java SE 8: Introduced lambda expressions and default methods

You'll learn the most useful structures and manipulation patterns.

<!-- end_slide -->

## Collections Framework: Core Concept

From a technical standpoint:

- A set of interfaces modeling various data storage containers
- Each interface has one or more concrete implementations

Choosing the right interface and implementation depends on how you need to:

- Store and access data
- Retrieve elements
- Prevent duplicates
- Sort elements
- Support concurrency

<!-- end_slide -->

## Finding Your Way in the Collections Framework

Many interfaces and classes can seem overwhelming:

- Familiar ones: `List`, `ArrayList`, `Map`
- Specialized ones: `ConcurrentHashMap`, `ConcurrentSkipListMap`

This tutorial focuses on commonly used ones essential for daily development.

<!-- end_slide -->

## Understanding Interfaces vs Implementations

When choosing an interface, ask:

- Do you need indexed access?
- Key-value mapping?
- Duplicate prevention?
- Null element support?
- Concurrency?

When choosing an implementation, ask:

- Will data change frequently?
- Is high performance needed for access or search?
- Will there be concurrent access?

<!-- end_slide -->

## Key Interface Categories

Two main categories:

1. **Collection** – For storing and iterating over elements  
   - Root interface: `Collection`  
   - Extends: `Iterable` (not part of the framework)

2. **Map** – For storing key/value pairs  
   - Root interface: `Map`  
   - No relation to `Collection` hierarchy

Subcategories:
- **Queue/Stack** (modeled under `Collection`)
- **Iterator** (side hierarchy for traversing)

<!-- end_slide -->

## Avoiding Legacy APIs

Avoid using pre-Java 2 interfaces/classes:

- `Vector`, `Stack` → Replace with `ArrayList`, `ArrayDeque` (non-concurrent)
- `Hashtable` → Replace with `HashMap` (non-concurrent) or `ConcurrentHashMap`
- `Enumeration` → Replaced by `Iterator`

These exist for backward compatibility only.

<!-- end_slide -->

## Why Choose a Collection Over an Array?

Arrays are basic but limited. Collections offer:

- Dynamic size
- Element count tracking
- Control over element types (e.g., disallow `null`)
- Element presence queries
- Set operations (e.g., merge, intersection)
- Extensibility via object-oriented design

Arrays are not objects in Java, hence not extensible.

<!-- end_slide -->


# Getting to Know the Collection Hierarchy

## Avoiding Getting Lost in the Collection Hierarchy

<!-- column_layout: [1,1] -->

<!-- column: 0 -->
- Framework is divided into several hierarchies of interfaces and classes.  
- The most fundamental is the **Collection interface hierarchy**.

- Some interfaces are omitted here and will be covered later.
<!-- column: 1 -->
![Collection Hierarchy](../assets/images/24-collection-hierarchy.png)

<!-- reset_layout -->

<!-- end_slide -->


## The Iterable Interface

- The root of the Collection hierarchy, though **not part of the Collections Framework**.
- Introduced in Java SE 5 (2004), with the **for-each loop** syntax.
  
```java
for (String element : collection) {
    // do something with element
}
```

* Any object implementing `Iterable` can be used with this syntax.
* To implement it, just return an `Iterator` instance.

<!-- end_slide -->

## The Collection Interface

<!-- column_layout: [1,1] -->

<!-- column: 0 -->

The `Collection` interface represents containers of elements and supports:

* Adding/removing elements
* Checking for presence of elements
* Querying size or emptiness
* Clearing the collection

<!-- column: 1 -->

Also supports **set operations**:

* Inclusion test
* Union
* Intersection
* Complement

Supports access methods:

* Iteration via `Iterator`
* Streams (including parallel)

<!-- reset_layout -->
<!-- end_slide -->

## Extending Collection with List

* A **List** remembers the order of element insertion.
* Iteration order is predictable and fixed.
* Elements are **indexed**, unlike general collections or sets.

Operations specific to `List`:

* Access element by index
* Insert or replace by index
* Get a sublist by index range

Implementation decides how indexing is handled.

<!-- end_slide -->

## Extending Collection with Set

* A **Set** forbids duplicates.
* No two elements can be equal.
* Adding an existing element may silently fail.

Key distinctions:

* No indexing
* No guaranteed iteration order (unless using special implementations)

Some Set implementations preserve order, but this is **accidental** — don’t rely on it.

<!-- end_slide -->

## SortedSet and NavigableSet

### SortedSet:

* Elements are **sorted in ascending order**.
* Requires elements to be:

  * Comparable (via `compareTo()`)
  * Or passed with a `Comparator`

Allows:

* `first()`, `last()` elements
* `headSet()`, `tailSet()` subviews
* Ordered iteration from lowest to highest


<!-- end_slide -->


## SortedSet and NavigableSet


### NavigableSet:

* Enhances `SortedSet` with:

  * Descending iteration
  * Ceiling/floor operations
  * Range queries

Useful for advanced ordered-set operations.

<!-- end_slide -->

## Sorting vs Ordering

* **Ordering**: Preserved in `List` — reflects insertion sequence.
* **Sorting**: Enforced in `SortedSet` — reflects natural or custom comparator order.

Traversal:

* List: first-in → first-out
* SortedSet: smallest → largest (by comparison logic)

Use the appropriate structure depending on whether element **order or sort** is needed.

<!-- end_slide -->


# Storing Elements in a Collection

## Exploring the Collection Interface

The `Collection` interface models a plain collection to store and retrieve elements.

To run the examples, we use `ArrayList` to instantiate a collection (detailed later).

```java
Collection<String> strings = new ArrayList<>();
````

<!-- end_slide -->

## Methods That Handle Individual Elements

Two fundamental methods:

* `add(element)` → adds an element, returns `true` if successful
* `remove(element)` → removes an element, returns `true` if successful

```java
Collection<String> strings = new ArrayList<>();
strings.add("one");
strings.add("two");
System.out.println(strings); // [one, two]
strings.remove("one");
System.out.println(strings); // [two]
```

<!-- end_slide -->

## Checking for Element Presence

Use `contains()` to check if an element exists in the collection.

```java
if (strings.contains("one")) {
    System.out.println("one is here");
}
```

You can even check for unrelated types:

```java
User rebecca = new User("Rebecca");
if (!strings.contains(rebecca)) {
    System.out.println("Rebecca is not here");
}
```

<!-- end_slide -->

## Methods That Handle Other Collections

Four set-based operations:

* `containsAll(other)` → inclusion
* `addAll(other)` → union
* `removeAll(other)` → complement
* `retainAll(other)` → intersection


<!-- end_slide -->

## Methods That Handle Other Collections

### Example
```java
Collection<String> strings = new ArrayList<>();
strings.add("one");
strings.add("two");
strings.add("three");

Collection<String> first = new ArrayList<>();
first.add("one");
first.add("two");

Collection<String> second = new ArrayList<>();
second.add("one");
second.add("four");
```
<!-- end_slide -->

## `addAll()` and `removeAll()` in Practice

```java
boolean changed = strings.addAll(first);
System.out.println("Has strings changed? " + changed);// false
```

```java
boolean changed = strings.removeAll(second);
System.out.println("strings = " + strings); // strings = [two, three]
```

Behaviors may differ by implementation (`ArrayList` vs `HashSet`).

<!-- end_slide -->

## `containsAll()` in Practice

```java
System.out.println(strings.containsAll(first)); // true
System.out.println(strings.containsAll(second)); // false
```

## `retainAll()` in Practice

```java
boolean changed = strings.retainAll(second); // true
System.out.println("strings = " + strings); // strings = [one]
```

This retains only those elements also present in the provided collection.

<!-- end_slide -->

## Methods That Handle the Collection Itself

* `size()` → number of elements
* `isEmpty()` → checks if collection is empty
* `clear()` → empties the collection

```java
System.out.println(strings.size()); // 3
strings.clear();
System.out.println(strings.size()); // 0
```

<!-- end_slide -->

## Getting an Array from a Collection

### Three `toArray()` methods:

1. `toArray()` → returns `Object[]`
2. `toArray(T[] array)` → return T[]
3. `toArray(IntFunction<T[]>)` → method reference

```java
String[] result = strings.toArray(new String[] {});
```

```java
String[] result = strings.toArray(String[]::new); // Java 8+
```

<!-- end_slide -->


## Filtering Elements with a Predicate

Java 8 added `removeIf(Predicate)`:

```java
Predicate<String> isNull = Objects::isNull;
Predicate<String> isEmpty = String::isEmpty;
Predicate<String> isNullOrEmpty = isNull.or(isEmpty);

strings.removeIf(isNullOrEmpty);
```

Before:

```
[null, "", "one", "two", "", "three", null]
```

After:

```
["one", "two", "three"]
```

<!-- end_slide -->

## Choosing a Collection Implementation

We used `ArrayList` in examples:

* `ArrayList` implements `List`, which extends `Collection`

No direct implementation of `Collection` is provided by the JDK.

✅ `ArrayList` is the default go-to choice when starting with `Collection`.

There are more advances choices also, refer to the documentation to learn more.

<!-- end_slide -->


# Iterating over the Elements of a Collection

## Using the for-each Pattern


```java
Collection<String> strings = List.of("one", "two", "three");

for (String element: strings) {
    System.out.print(element + ", ");
}
```

Output:

```
one, two, three,
```

Efficient when **only reading** elements. For removing elements during iteration, use `Iterator`.

<!-- end_slide -->

## Using an Iterator on a Collection

Get an `Iterator` from any `Collection`:

```java
Collection<String> strings = List.of("one", "two", "three", "four");

for (Iterator<String> iterator = strings.iterator(); iterator.hasNext();) {
    String element = iterator.next();
    if (element.length() == 3) {
        System.out.print(element + ", ");
    }
} // Output: one, two
```

- Use `hasNext()` to check if there's another element.
- Use `next()` to get the next element.

<!-- end_slide -->

## Iterator: remove()

The `Iterator` interface also has:

* `remove()`: removes the **current element**.

⚠️ Throws `UnsupportedOperationException` if unsupported (e.g. immutable collections).

✅ Supported in: `ArrayList`, `LinkedList`, `HashSet`.

<!-- end_slide -->

## Updating a Collection While Iterating


Example:

```java
Collection<String> strings = new ArrayList<>(List.of("one", "two", "three"));

Iterator<String> iterator = strings.iterator();
while (iterator.hasNext()) {
    String element = iterator.next();
    strings.remove(element);  // ⚠️ throws ConcurrentModificationException
}
```

✅ Use `removeIf(predicate)` instead when removing conditionally.

<!-- end_slide -->

## Implementing the Iterable Interface (Java 16+)

Example using a `record` to define an iterable range:

```java
record Range(int start, int end) implements Iterable<Integer> {
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private int index = start;
            public boolean hasNext() { return index < end; }
            public Integer next() {
                if (index > end) throw new NoSuchElementException();
                return index++;
            }
        };
    }
}
```
<!-- end_slide -->

## Implementing the Iterable Interface (Java 16+)

Usage:

```java
for (int i : new Range(0, 5)) {
    System.out.println("i = " + i);
}
```

Output:

```
i = 0
i = 1
i = 2
i = 3
i = 4
```
- Range can also be implemented using old plain `class` syntax.

<!-- end_slide -->

References:
===
- https://dev.java/learn/api/collections-framework
