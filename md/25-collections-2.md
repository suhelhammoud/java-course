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

# Extending Collection with List

## Exploring the List Interface

The `List` interface adds:

- **Order preservation**: Elements are kept in insertion order.
- **Indexing**: Access, insert, and remove by position.

```java
List<String> list = List.of("a", "b", "c");
System.out.println(list.get(0)); // "a"
````

<!-- end_slide -->

## Choosing a List Implementation

Two main implementations:

* **ArrayList**: Backed by a dynamic array
* **LinkedList**: Doubly-linked nodes

**Best choice**: `ArrayList` for general use (faster access & iteration)
Use `LinkedList` for LIFO/FIFO operations (stack/queue-like behavior)

<!-- end_slide -->

## Accessing Elements by Index

Key methods:

* `add(index, element)`
* `get(index)`
* `set(index, element)`
* `remove(index)`
* `indexOf(element)` / `lastIndexOf(element)`

⚠️ Throws `IndexOutOfBoundsException` for invalid indices

<!-- end_slide -->

## Sublist Views and Modifications

Use `subList(start, end)` to get a view (not a copy):

```java
List<String> list = new ArrayList<>(List.of("0", "1", "2", "3", "4", "5"));
list.subList(2, 5).clear();
System.out.println(list); // [0, 1, 5]
```

Changes in sublist affect the main list.

<!-- end_slide -->

## Inserting Collections at an Index

You can insert a whole collection at a specific index:

```java
list.addAll(index, otherCollection);
```

This shifts existing elements accordingly.

<!-- end_slide -->

## Sorting a List

Since Java 8:

```java
list.sort(Comparator.naturalOrder());
```

* Requires elements to be `Comparable` or provide a `Comparator`
* Avoid passing `null` directly

Prior to Java 8: use `Collections.sort(list, comparator)`

<!-- end_slide -->

## Iterating with ListIterator

Provides more control than `Iterator`:

* `hasPrevious()` / `previous()`
* `nextIndex()` / `previousIndex()`
* `set(element)` to update the last returned element

```java
var list = new ArrayList<>(List.of("one", "two", "three"));
ListIterator<String> it = list.listIterator();
while (it.hasNext()) {
    if (it.next().equals("two")) {
        it.set("2");
    }
}
```

Output:

```
[one, 2, three]
```

<!-- end_slide -->

Section Two
===
# Extending Collection with Set, SortedSet, and NavigableSet


<!-- end_slide -->


## Exploring the Set Interface

- `Set` forbids **duplicates** but doesn't guarantee order.
- Main implementation: `HashSet` (internally uses `HashMap`).
- Order of iteration is **unpredictable**:

```java
Set<String> set = new HashSet<>(List.of("one", "two", "three"));
set.forEach(System.out::println); // Unordered output
````

Avoid relying on insertion order with plain `Set`.

<!-- end_slide -->

## Extending Set with SortedSet

* `SortedSet` keeps elements **sorted** by natural order or custom `Comparator`.
* Implementation: `TreeSet`.

Useful methods:

* `first()`, `last()`
* `headSet(toElement)`, `tailSet(fromElement)`
* `subSet(from, to)` — inclusive/exclusive rules apply

```java
SortedSet<String> set = new TreeSet<>(Set.of("a", "b", "c", "d", "e", "f"));
System.out.println(set.subSet("aa", "d")); // [b, c]
```

Subsets are **views**, not copies — changes are reflected both ways.

<!-- end_slide -->

## Subset Constraints in SortedSet

* Subsets (`headSet`, `tailSet`, `subSet`) remember their boundaries.
* Illegal to add elements **outside** these bounds → `IllegalArgumentException`.

```java
SortedSet<String> subset = set.subSet("b", "e");
subset.add("a"); // ❌ Illegal
```

<!-- end_slide -->

## Extending SortedSet with NavigableSet

* `NavigableSet` (Java 6) extends `SortedSet` with more powerful methods.
* `TreeSet` implements both interfaces.

New methods:

* `ceiling(e)`, `floor(e)`
* `higher(e)`, `lower(e)`
* `pollFirst()`, `pollLast()`
* `descendingIterator()`, `descendingSet()`

```java
NavigableSet<String> set = new TreeSet<>(Set.of("a", "b", "c", "d"));
System.out.println(set.descendingSet()); // [d, c, b, a]
```

<!-- end_slide -->

## Recap

* `Set` ensures uniqueness, no order.
* `SortedSet` ensures sorted order, supports subset views.
* `NavigableSet` adds fine-grained control (inclusive/exclusive bounds, reverse iteration).

Prefer:

* `HashSet` for uniqueness without order.
* `TreeSet` for sorted, searchable sets with range queries.

<!-- end_slide -->

Section Three
===
# Creating and Processing Data with Collections Factory Methods

<!-- end_slide -->



## Creating Immutable Collections (Java 9+)

Use factory methods for immutable collections:

```java
List<String> list = List.of("one", "two", "three");
Set<String> set = Set.of("one", "two", "three");
````

✅ Immutable
❌ No `null` values
❌ No duplicates (for `Set`)
⚠️ Internal implementation is not `ArrayList`/`HashSet`

<!-- end_slide -->

## Getting an Immutable Copy (Java 10)

Use `copyOf()` to create immutable snapshots:

```java
List<String> list = List.copyOf(strings);
Set<String> set = Set.copyOf(strings);
```

* Source must be non-null and contain no `null` elements
* `Set.copyOf()` removes duplicates
* Returned structure is immutable

<!-- end_slide -->

## Wrapping an Array in a List

```java
List<String> list = Arrays.asList("a", "b", "c");
```

* Fixed size: supports `set()` but **not** `add()` or `remove()`
* Backed by the original array
* Not a true immutable list

<!-- end_slide -->

## Extracting Min/Max from a Collection

```java
String min = Collections.min(list);
String max = Collections.max(list, comparator);
```

⚠️ Collection must not be empty
⚠️ Elements must be `Comparable` or a `Comparator` must be provided

<!-- end_slide -->

## Searching for a Sublist

```java
int index = Collections.indexOfSublist(source, target);
int last = Collections.lastIndexOfSublist(source, target);
```

Returns index of first/last occurrence of `target` in `source`.

<!-- end_slide -->

## Reordering a List (using Collections class)

* `sort(comparator)` → in-place sort
* `shuffle()` → randomize order
* `rotate(list, distance)` → cyclic shift
* `reverse()` → reverse order
* `swap(list, i, j)` → swap elements



<!-- end_slide -->

## Creating Immutable Wrappers

```java
List<String> immutableList = Collections.unmodifiableList(list);
```

* ❌ Modifications through wrapper
* ✅ Changes to underlying list are reflected

✅ Use defensive copy for true immutability

<!-- end_slide -->

## Creating Synchronized Wrappers

```java
List<String> syncList = Collections.synchronizedList(list);
```

🔒 Synchronize manually when iterating:

```java
synchronized (syncList) {
    for (String s : syncList) { ... }
}
```

⚠️ Prefer `java.util.concurrent` for thread-safe collections

<!-- end_slide -->

## Section Summary

✅ `List.of()`, `Set.of()` for immutable creation
✅ `copyOf()` for immutable snapshot
✅ `Collections` class for:

* min/max
* sublist search
* reordering
* wrappers (immutable/synchronized)

Use factory methods for safety, clarity, and reduced boilerplate.

<!-- end_slide -->

Section Four
===
# Storing Elements in Stacks and Queues

the following image shows it
![Stacks and Queues](../assets/images/25-queue-hierarchy.png)
<!-- end_slide -->


## Queue and Deque in the Collections Framework

- Java SE 5: `Queue` interface added  
- Java SE 6: `Deque` (double-ended queue) added  
- Both extend `Collection` and support push/pop/poll/peek operations  
- Deque = Stack + Queue

```java
Queue<String> q = new LinkedList<>();
Deque<String> d = new ArrayDeque<>();
````

<!-- end_slide -->

## Stack vs Queue Behavior

* **Stack (LIFO)**: Last In, First Out
* **Queue (FIFO)**: First In, First Out

### Common Operations:

* `push(e)` – Add element
* `pop()` / `poll()` – Remove element
* `peek()` – View next element (no removal)

<!-- end_slide -->

## Queue Interface: Behavior on Capacity Limits

| Operation | Method      | On failure       |
| --------- | ----------- | ---------------- |
| Push      | `add(e)`    | Throws exception |
| Push      | `offer(e)`  | Returns `false`  |
| Pop       | `remove()`  | Throws exception |
| Pop       | `poll()`    | Returns `null`   |
| Peek      | `element()` | Throws exception |
| Peek      | `peek()`    | Returns `null`   |

<!-- end_slide -->

## Deque Interface: FIFO and LIFO Support

### FIFO-style (Queue behavior)

| Operation | Method                          |
| --------- | ------------------------------- |
| Push      | `addLast(e)` / `offerLast(e)`   |
| Pop       | `removeFirst()` / `pollFirst()` |
| Peek      | `getFirst()` / `peekFirst()`    |

### LIFO-style (Stack behavior)

| Operation | Method                          |
| --------- | ------------------------------- |
| Push      | `addFirst(e)` / `offerFirst(e)` |
| Pop       | `removeFirst()` / `pollFirst()` |
| Peek      | `getFirst()` / `peekFirst()`    |

<!-- end_slide -->

## Additional Deque Methods

* `push(e)` → alias for `addFirst()`
* `pop()` → alias for `removeFirst()`
* `poll()` → alias for `pollLast()`
* `peek()` → alias for `peekLast()`

If no elements are available: **returns `null`**

<!-- end_slide -->

## Implementations of Queue and Deque

* **ArrayDeque**:

  * Implements both `Queue` and `Deque`
  * Backed by array, dynamically resizes
  * Fast for stack/queue operations

* **LinkedList**:

  * Implements both
  * Fast first/last access due to linked structure

* **PriorityQueue**:

  * Implements only `Queue`
  * Maintains sorted order via `Comparator` or `Comparable`

<!-- end_slide -->

## Avoiding `Stack` Class

* `Stack` extends `Vector` (synchronized, legacy)
* Avoid using `Stack` — use `Deque` or `ArrayDeque` instead
* For thread-safe needs, prefer `BlockingQueue` implementations

```java
Deque<String> stack = new ArrayDeque<>();
stack.push("data");
```

<!-- end_slide -->

## Summary

* Use `Queue` for FIFO, `Deque` for both FIFO/LIFO
* Prefer `ArrayDeque` or `LinkedList` over `Stack`
* Avoid legacy `Stack`/`Vector`
* Understand method behavior on full/empty collections
* Use `PriorityQueue` for sorted queue operations

<!-- end_slide -->
