# Threads

In the `Java` programming language, `threads` can be used in two ways:

1) By `implementing` the `Runnable` interface
2) By `extending` the `Thread` class

The important thing to remember is to make sure that no `dataraces` occur by using appropriate `synchronization` primitives such as the `synchronized` keyword in the shared object that the threads are to access

# Description

The examples in this directory are well documented and fully functioning

- The `MultiTasker.java` example covers a basic example of how to use and implement Threads in Java using both the `Runnable` interface and `Threads` class

- The `SharingIsCaring.java` example covers the manipulation of a shared object (shared among the threads), that isn't part of the Threads class or Runnable interface but rather an externally processed object which must reside within a <b>`synchronized`</b> block of code.

- `Solution-Itinere-2023` contains the solution to the 'Prova in itinere' on Threads from the previous academic year, `2022-2023`

# Usage

1) To run the `MultiTasker.java` example:

```bash
javac MultiTasker.java && java MultiTasker
```

2) To run the `SharingIsCaring.java` example:

```bash
javac SharingIsCaring.java && java SharingIsCaring
```

3) To run the `Solution-Itinere-2023/Main.java` example:

```bash
cd Solution-Itinere-2023
javac Main.java && java Main
```

---

# References

1) [Official Oracle docs](https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html)
2) [W3Schools tutorials](https://www.w3schools.com/java/java_threads.asp)

---