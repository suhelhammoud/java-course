---
title: Object Oriented Programming in Java
sub_title: Introduction to Multithreading and Concurrency  
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



## What is Concurrency?
- Concurrency is the ability to run several programs or parts of a program in parallel.
- In Java, concurrency is achieved through:
  - Threads
  - Runnable interface
  - Executors
  - Concurrency utilities in `java.util.concurrent`

<!-- end_slide -->

## Thread Basics
### Creating a Thread
```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running");
    }
}

MyThread t = new MyThread();
t.start();
```

Or using `Runnable`:
```java
Runnable r = () -> System.out.println("Runnable running");
new Thread(r).start();
```

<!-- end_slide -->

## Thread Lifecycle
1. New
2. Runnable
3. Running
4. Blocked/Waiting
5. Terminated

Use `start()`, `sleep()`, `join()`, `wait()`, and `notify()` to manage thread behavior.

<!-- end_slide -->

## Thread Synchronization
### Why Synchronize?
To avoid race conditions when multiple threads access shared data.

```java
synchronized void increment() {
    count++;
}
```

Use `synchronized` blocks or methods.

<!-- end_slide -->

## Volatile Keyword
- Ensures visibility of changes to variables across threads.
```java
volatile boolean flag = true;
```
- Does **not** ensure atomicity.

<!-- end_slide -->

## Locks and ReentrantLock
- Alternative to `synchronized`
```java
ReentrantLock lock = new ReentrantLock();
lock.lock();
try {
    // critical section
} finally {
    lock.unlock();
}
```

<!-- end_slide -->

## Executor Framework
- Better thread management
```java
ExecutorService executor = Executors.newFixedThreadPool(3);
executor.submit(() -> {
    System.out.println("Task executed");
});
executor.shutdown();
```

<!-- end_slide -->

## Callable and Future
- Callable returns a value
```java
Callable<Integer> task = () -> 123;
Future<Integer> future = executor.submit(task);
Integer result = future.get(); // blocks until done
```

<!-- end_slide -->

## Thread-safe Collections
- Use `ConcurrentHashMap`, `CopyOnWriteArrayList`, etc.

```java
Map<String, Integer> map = new ConcurrentHashMap<>();
```

These are designed for high-concurrency scenarios.

<!-- end_slide -->

## Atomic Variables
- Operations like increment are atomic
```java
AtomicInteger count = new AtomicInteger(0);
count.incrementAndGet();
```

Part of `java.util.concurrent.atomic`

<!-- end_slide -->

## CountDownLatch & CyclicBarrier
### CountDownLatch
```java
CountDownLatch latch = new CountDownLatch(3);
latch.countDown();
latch.await();
```

### CyclicBarrier
```java
CyclicBarrier barrier = new CyclicBarrier(3, () -> System.out.println("All threads reached barrier"));
```

<!-- end_slide -->

## Fork/Join Framework
- Recursive task division
```java
ForkJoinPool pool = new ForkJoinPool();
pool.invoke(new MyRecursiveTask());
```

Use `RecursiveTask<T>` or `RecursiveAction`.

<!-- end_slide -->

## Best Practices
- Avoid shared mutable state
- Prefer higher-level abstractions (Executors, Futures)
- Use thread-safe collections and atomics
- Monitor performance and deadlocks

<!-- end_slide -->

## Resources
- [Official Oracle Java Docs](https://docs.oracle.com/javase/tutorial/essential/concurrency/)

