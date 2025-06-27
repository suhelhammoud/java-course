---
title: Object Oriented Programming in Java
sub_title: Maps
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


# Using Maps to Store Key-Value Pairs

## Introducing the Map Hierarchy

- A **Map** stores **unique keys** mapped to **values**
- Keys are usually simple (e.g., strings, numbers); values can be complex
- Core interfaces:
  - `Map<K, V>`
  - `SortedMap<K, V>` → sorted by keys
  - `NavigableMap<K, V>` → enhanced navigation features

### Common implementations:
- `HashMap`: Unordered, efficient
- `LinkedHashMap`: Maintains insertion order
- `IdentityHashMap`: Uses reference equality (`==`) — use with caution

<!-- end_slide -->

## Map Basics

- Each key maps to **one value**
- A value may be associated with **multiple keys**

Data structure relationships:
- Keys → `Set`
- Key-Value pairs → `Set<Map.Entry<K, V>>`
- Values → `Collection<V>`

<!-- end_slide -->

## Creating Immutable Maps (Java 9+)

### Up to 10 entries:
```java
Map.of(1, "one", 2, "two", 3, "three");
````

### More than 10 entries:

```java
Map.ofEntries(
  Map.entry(1, "one"),
  Map.entry(2, "two"),
  Map.entry(3, "three")
);
```

⚠️ Restrictions:

* Immutable
* No `null` keys or values
* No duplicate keys

<!-- end_slide -->

## Basic Map Operations

* `put(k, v)` – add/update a key-value pair
* `get(k)` – retrieve a value
* `remove(k)` – remove a key-value pair
* `containsKey(k)`, `containsValue(v)`
* `isEmpty()`, `size()`
* `putAll(map)`, `clear()`

```java
Map<String, Integer> map = new HashMap<>();
map.put("a", 1);
map.get("a"); // 1
```

<!-- end_slide -->

## Exploring `Map.Entry`

`Map.Entry<K, V>` represents a key-value pair:

* `getKey()`, `getValue()`, `setValue(newVal)`
* Modifying `Map.Entry` updates the map

⚠️ Keys cannot be mutated once added — changing key state may break map integrity

<!-- end_slide -->

## Choosing Map Key Types

* ❌ Avoid mutable objects as keys
* Changing a key after insertion may cause lookup failure

### Good keys:

* Strings, integers, enums
### Bad keys:
* Objects with changing fields in `hashCode()` or `equals()`

<!-- end_slide -->

## Summary

- `Map` holds unique keys mapped to values
- Use `HashMap` or `LinkedHashMap` for general use
- Prefer factory methods (`Map.of`, `Map.ofEntries`) for immutability
- Avoid mutable keys for consistency and correctness

<!-- end_slide -->
Section Two
===

<!-- end_slide -->


# Managing the Content of a Map

## Adding Key-Value Pairs

- Use `put(k, v)` to insert or replace a value.
  - Returns previous value or `null` if new key.

- Use `putIfAbsent(k, v)` to only insert if key is absent or value is `null`.

```java
map.put("two", null);
map.putIfAbsent("two", -1); // replaces null
````

✅ Handy for cleaning up `null` values to avoid `NullPointerException`.

<!-- end_slide -->

## Getting Values

* `get(k)` returns value or `null`
* `getOrDefault(k, default)` returns value or default if key is absent

```java
map.getOrDefault(4, "UNDEFINED");
```

```java
List<String> values = IntStream.range(0, 5)
  .mapToObj(k -> map.getOrDefault(k, "UNDEFINED"))
  .collect(Collectors.toList());
```

<!-- end_slide -->

## Removing Key-Value Pairs

* `remove(k)` removes entry, returns value (may be `null`)
* `remove(k, v)` removes only if both key and value match

```java
map.remove("key", "value"); // safer
```

<!-- end_slide -->

## Checking Map State

* `containsKey(k)`, `containsValue(v)` → `boolean`
* `isEmpty()` → true if empty
* `size()` → number of entries
* `clear()` → removes all entries
* `putAll(map)` → merges maps (overwrites existing keys)

<!-- end_slide -->

## Getting Map Views

```java
Set<K> keys = map.keySet();
Collection<V> values = map.values();
Set<Map.Entry<K, V>> entries = map.entrySet();
```

* Views are **live**: changes to the map affect the views and vice versa

```java
keys.remove(3); // removes key 3 from map
```

<!-- end_slide -->

## Removing from Values View

* `values().remove(v)` removes **first** matching key-value pair

```java
map.values().remove("three");
```

- ⚠️ With `HashMap`, you can't predict which key will be removed
- ⚠️ Cannot `add()` to these views (throws `UnsupportedOperationException`)

<!-- end_slide -->

## Efficient Map Iteration

* Avoid `for (K key : map.keySet())`
* Prefer entry iteration:

```java
for (Map.Entry<K, V> entry : map.entrySet()) {
  System.out.println(entry.getKey() + "=" + entry.getValue());
}
```

✅ Faster and cleaner

<!-- end_slide -->

## Summary

* Use `putIfAbsent()` to handle nulls safely
* `getOrDefault()` simplifies lookups
* Use views (`keySet`, `values`, `entrySet`) to access content
* Prefer `entrySet()` iteration
* Views reflect map changes; some modifications (like `add()`) are restricted

<!-- end_slide -->

Section Three
===

<!-- end_slide -->


# Handling Map Values with Lambda Expressions

## Consuming Map Content with forEach

Use `forEach()` with a `BiConsumer`:

```java
map.forEach((key, value) -> System.out.println(key + " :: " + value));
````

* ✅ Cleaner, declarative iteration
* ✅ Similar to `Iterable.forEach()`, but with key-value pairs

<!-- end_slide -->

## Replacing Values

### Methods:

* `replace(k, v)` – replaces value if key exists
* `replace(k, oldV, newV)` – replaces only if current value matches
* `replaceAll((k, v) -> newV)` – replaces all values using a `BiFunction`

```java
map.replaceAll((k, v) -> v.toUpperCase());
```

✅ Useful for batch updates

<!-- end_slide -->

## Computing Values with Lambdas

### Methods:

* `compute(k, BiFunction)`
* `computeIfPresent(k, BiFunction)`
* `computeIfAbsent(k, Function)`

```java
map.computeIfAbsent(length, key -> new ArrayList<>()).add(word);
```

💡 Returns the new value (not the old one like `put()` does)
💡 `null` result → entry is removed

<!-- end_slide -->

## Example: Group Words by Length

```java
List<String> words = List.of("one", "two", "three", "four", "five");
Map<Integer, List<String>> map = new HashMap<>();

for (String word : words) {
    int length = word.length();
    map.computeIfAbsent(length, k -> new ArrayList<>()).add(word);
}
```

* ✅ Only creates list if needed
* ✅ Preferred over `putIfAbsent()` for lazy initialization

<!-- end_slide -->

## Merging Values

Use `merge(k, v, BiFunction)` to aggregate:

```java
map.merge(length, word, (existing, newWord) -> existing + ", " + newWord);
```

* If key absent or `null` → inserts value
* If key exists → applies merge function
* If result is `null` → removes entry

📌 Works with immutable types like `String`

<!-- end_slide -->

## Example Output

```text
3 :: one, two, six
4 :: four, five
5 :: three, seven
```

### Tips:

* Use **non-capturing lambdas** (prefer `(k) -> ...` over using external vars)
* Improve **performance** and **clarity** when computing or merging map entries

<!-- end_slide -->

## Summary

✅ `forEach()` simplifies iteration
✅ `replaceAll()` updates values in-place
✅ `compute*()` methods add/update conditionally
✅ `merge()` is best for aggregating immutable types
✅ Use non-capturing lambdas for efficiency

<!-- end_slide -->
Section Four
===
<!-- end_slide -->


# Keeping Keys Sorted with SortedMap and NavigableMap

## SortedMap and NavigableMap Overview

- Both extend `Map`; implemented by `TreeMap` (red-black tree)
- Keys are **automatically sorted**
- Requires keys to be `Comparable` or a provided `Comparator`

```java
SortedMap<Integer, String> map = new TreeMap<>();
````

✅ Views: `keySet()` → `SortedSet`, `navigableKeySet()` → `NavigableSet`

<!-- end_slide -->

## Methods in SortedMap

| Method             | Description                 |
| ------------------ | --------------------------- |
| `firstKey()`       | Smallest key                |
| `lastKey()`        | Largest key                 |
| `headMap(toKey)`   | Keys `< toKey`              |
| `tailMap(fromKey)` | Keys `≥ fromKey`            |
| `subMap(from, to)` | Keys `≥ fromKey && < toKey` |

* Returned maps are **views**
* ❌ Cannot add entries **outside** the defined range

<!-- end_slide -->

## Example: `SortedMap` Boundaries

```java
SortedMap<Integer, String> headMap = map.headMap(3);
headMap.put(0, "zero");     // ✅ allowed
headMap.put(4, "four");     // ❌ throws IllegalArgumentException
```

✅ Views are **live and updateable**, but must respect boundaries.

<!-- end_slide -->

## NavigableMap Key Navigation

### Extended methods:

* `firstEntry()`, `lastEntry()`
* `ceilingKey(k)`, `higherKey(k)`
* `floorKey(k)`, `lowerKey(k)`

### Comparison:

* **Ceiling/Floor**: ≥ / ≤
* **Higher/Lower**: > / <

```java
map.ceilingKey(3); // returns 3 if exists, else next higher
```

<!-- end_slide -->

## Queue-like Access Methods

```java
map.pollFirstEntry(); // removes and returns first entry
map.pollLastEntry();  // removes and returns last entry
```

✅ Useful for priority queue-like behavior

<!-- end_slide -->

## Reverse Traversal

```java
NavigableSet<Integer> descKeys = map.descendingKeySet();
NavigableMap<Integer, String> descMap = map.descendingMap();
```

* Iterates in **reverse order**
* Views are **backed** by the original map
* ❌ Cannot add new keys via views

```java
map.keySet();        // 1 2 3 4 5
descKeys.forEach();  // 5 4 3 2 1
```

<!-- end_slide -->

## Flexible Submap Views

### Inclusive/Exclusive Boundaries

```java
map.subMap(2, true, 4, false);  // [2, 4)
map.headMap(4, true);          // ≤ 4
map.tailMap(2, false);         // > 2
```

✅ Views support modification
❌ Cannot add keys outside range

<!-- end_slide -->

## Summary

* Use `TreeMap` for sorted maps
* `SortedMap`/`NavigableMap` provide rich key navigation
* Views (`subMap`, `headMap`, `tailMap`) are live and updateable
* Prefer `descendingMap()` for reverse-order logic
* Handle inclusivity with `NavigableMap` submap variants

<!-- end_slide -->

Reference:
===
- https://dev.java/learn/api/collections-framework