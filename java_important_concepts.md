# Java — Important but Not-So-Common Concepts

A curated set of Java concepts that are **frequently asked in interviews / cause real bugs**,
but don't get enough attention in basic tutorials. Every concept has a short explanation +
a runnable code example with comments.

---

## 1. Integer Caching (Autoboxing Trap)

Java caches `Integer` objects in the range **-128 to 127**. Outside this range, `==` comparison
on boxed values fails even though the numeric value is the same.

```java
public class IntegerCacheDemo {
    public static void main(String[] args) {
        Integer a = 100;
        Integer b = 100;
        System.out.println(a == b); // true -> both from cache (-128 to 127)

        Integer c = 200;
        Integer d = 200;
        System.out.println(c == d); // false -> new objects, outside cache range

        // Always use equals() for value comparison of wrapper objects
        System.out.println(c.equals(d)); // true
    }
}
```

---

## 2. String Pool & `intern()`

String literals are stored in the **String Constant Pool**. `new String()` always creates
a new object on the heap, breaking pool reuse unless you call `intern()`.

```java
public class StringPoolDemo {
    public static void main(String[] args) {
        String s1 = "hello";              // goes into string pool
        String s2 = "hello";               // reuses same pool reference
        String s3 = new String("hello");   // new object on heap, NOT in pool

        System.out.println(s1 == s2);          // true
        System.out.println(s1 == s3);          // false
        System.out.println(s1 == s3.intern()); // true -> intern() forces pool lookup
    }
}
```

---

## 3. `equals()` and `hashCode()` Contract

If you override `equals()` but not `hashCode()`, your objects will behave incorrectly
in `HashMap`, `HashSet`, etc. **Rule: equal objects MUST have equal hash codes.**

```java
import java.util.Objects;

class Point {
    int x, y;
    Point(int x, int y) { this.x = x; this.y = y; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point p = (Point) o;
        return x == p.x && y == p.y;
    }

    @Override
    public int hashCode() {
        // MUST be consistent with equals(), else HashSet/HashMap breaks
        return Objects.hash(x, y);
    }
}

public class EqualsHashCodeDemo {
    public static void main(String[] args) {
        java.util.Set<Point> set = new java.util.HashSet<>();
        set.add(new Point(1, 2));
        set.add(new Point(1, 2)); // duplicate logically
        System.out.println(set.size()); // 1, because equals+hashCode are correct
    }
}
```

---

## 4. `finally` Block Overrides `return`

A `return` inside `finally` **silently overrides** any return value from `try`/`catch`.
This is a common source of subtle bugs.

```java
public class FinallyReturnDemo {
    static int test() {
        try {
            return 1;
        } finally {
            return 2; // this wins! method returns 2, not 1
        }
    }

    public static void main(String[] args) {
        System.out.println(test()); // prints 2 — avoid return in finally!
    }
}
```

---

## 5. Try-With-Resources (Auto-Closeable)

Avoids manual `finally { close(); }` boilerplate and closes resources in **reverse order**
of declaration, even if an exception occurs.

```java
class MyResource implements AutoCloseable {
    String name;
    MyResource(String name) { this.name = name; }

    @Override
    public void close() {
        System.out.println("Closing " + name);
    }
}

public class TryWithResourcesDemo {
    public static void main(String[] args) {
        // Resources are closed automatically, in reverse order: B then A
        try (MyResource a = new MyResource("A");
             MyResource b = new MyResource("B")) {
            System.out.println("Using resources");
        }
    }
}
```

---

## 6. `static` vs `default` Methods in Interfaces (Java 8+)

Interfaces can now have method bodies. `default` gives all implementers a fallback;
`static` belongs to the interface itself and is not inherited.

```java
interface Vehicle {
    void drive(); // abstract - must be implemented

    default void honk() {
        // default implementation - can be overridden
        System.out.println("Beep beep!");
    }

    static Vehicle create() {
        // static method - called as Vehicle.create(), not inherited by implementers
        return () -> System.out.println("Driving a generic vehicle");
    }
}

public class InterfaceDemo {
    public static void main(String[] args) {
        Vehicle v = Vehicle.create();
        v.drive();
        v.honk(); // uses default implementation
    }
}
```

---

## 7. Generics Wildcards: `? extends` vs `? super` (PECS Rule)

**PECS = Producer Extends, Consumer Super**
- Use `? extends T` when you only **read** (produce) from the collection.
- Use `? super T` when you only **write** (consume) into the collection.

```java
import java.util.List;
import java.util.ArrayList;

public class WildcardDemo {

    // Producer: reading only -> use "extends"
    static double sumOfList(List<? extends Number> list) {
        double sum = 0;
        for (Number n : list) sum += n.doubleValue();
        return sum;
    }

    // Consumer: writing only -> use "super"
    static void addIntegers(List<? super Integer> list) {
        list.add(1);
        list.add(2);
    }

    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>(List.of(1, 2, 3));
        System.out.println(sumOfList(ints)); // works: Integer extends Number

        List<Number> numbers = new ArrayList<>();
        addIntegers(numbers); // works: Number is super of Integer
        System.out.println(numbers);
    }
}
```

---

## 8. Enums Are Full-Fledged Classes

Enums can have constructors, fields, and even abstract methods per-constant —
not just a list of names.

```java
enum Operation {
    ADD("+") {
        public int apply(int a, int b) { return a + b; }
    },
    SUBTRACT("-") {
        public int apply(int a, int b) { return a - b; }
    };

    private final String symbol; // each enum constant shares this field

    Operation(String symbol) { // enum constructors are always private/implicit
        this.symbol = symbol;
    }

    public abstract int apply(int a, int b); // each constant implements this

    public String getSymbol() { return symbol; }
}

public class EnumDemo {
    public static void main(String[] args) {
        for (Operation op : Operation.values()) {
            System.out.println("5 " + op.getSymbol() + " 3 = " + op.apply(5, 3));
        }
    }
}
```

---

## 9. `transient` and `volatile` Keywords

- `transient`: excludes a field from **serialization**.
- `volatile`: ensures a variable's value is always read from **main memory**, not a
  thread's cached copy — critical for multithreading visibility.

```java
import java.io.*;

class User implements Serializable {
    String username;
    transient String password; // will NOT be serialized -> security!

    User(String u, String p) { username = u; password = p; }
}

class SharedFlag {
    // without volatile, other threads might never see the updated value
    volatile boolean running = true;
}

public class KeywordsDemo {
    public static void main(String[] args) throws Exception {
        User u = new User("alice", "secret123");

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        new ObjectOutputStream(baos).writeObject(u);

        User restored = (User) new ObjectInputStream(
                new ByteArrayInputStream(baos.toByteArray())).readObject();

        System.out.println(restored.username); // alice
        System.out.println(restored.password);  // null - transient field lost
    }
}
```

---

## 10. Shallow Copy vs Deep Copy (`clone()`)

Default `Object.clone()` does a **shallow copy** — nested objects are shared references,
not duplicated. This bites people using `Cloneable` without understanding it.

```java
class Address {
    String city;
    Address(String city) { this.city = city; }
}

class Person implements Cloneable {
    String name;
    Address address; // reference type

    Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    // Shallow clone (default)
    @Override
    public Person clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }

    // Deep clone (manual)
    public Person deepClone() {
        return new Person(this.name, new Address(this.address.city));
    }
}

public class CloneDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person original = new Person("Bob", new Address("Pune"));
        Person shallow = original.clone();
        Person deep = original.deepClone();

        original.address.city = "Mumbai";

        System.out.println(shallow.address.city); // Mumbai - shared reference!
        System.out.println(deep.address.city);     // Pune - independent copy
    }
}
```

---

## 11. `Comparable` vs `Comparator`

- `Comparable`: defines the **natural/default** ordering, implemented inside the class.
- `Comparator`: defines **custom/external** ordering, can have multiple strategies.

```java
import java.util.*;

class Employee implements Comparable<Employee> {
    String name;
    int salary;

    Employee(String name, int salary) { this.name = name; this.salary = salary; }

    @Override
    public int compareTo(Employee other) {
        // natural order: by name
        return this.name.compareTo(other.name);
    }

    public String toString() { return name + ":" + salary; }
}

public class ComparableComparatorDemo {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>(List.of(
                new Employee("Charlie", 5000),
                new Employee("Alice", 7000),
                new Employee("Bob", 6000)
        ));

        Collections.sort(list); // uses compareTo() -> natural order by name
        System.out.println(list);

        // Custom order by salary, descending, using a Comparator (external logic)
        list.sort(Comparator.comparingInt((Employee e) -> e.salary).reversed());
        System.out.println(list);
    }
}
```

---

## 12. Checked vs Unchecked Exceptions & Custom Exceptions

Checked exceptions **must** be declared/handled at compile time; unchecked ones (RuntimeException)
are not enforced by the compiler. Understanding this helps design better APIs.

```java
// Checked exception - caller MUST handle it (compiler enforced)
class InsufficientFundsException extends Exception {
    InsufficientFundsException(String msg) { super(msg); }
}

class Account {
    double balance;
    Account(double balance) { this.balance = balance; }

    void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Not enough balance!");
        }
        balance -= amount;
    }
}

public class ExceptionDemo {
    public static void main(String[] args) {
        Account acc = new Account(1000);
        try {
            acc.withdraw(2000); // forces try-catch because it's a checked exception
        } catch (InsufficientFundsException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}
```

---

## 13. Functional Interfaces & Method References

A **functional interface** has exactly one abstract method and can be implemented using
lambdas or method references — the backbone of Java's Stream API.

```java
import java.util.function.*;
import java.util.*;
import java.util.stream.*;

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        // Predicate<T>: takes T, returns boolean
        Predicate<String> isLong = s -> s.length() > 3;

        // Function<T, R>: takes T, returns R
        Function<String, Integer> toLength = String::length; // method reference

        // Consumer<T>: takes T, returns nothing
        Consumer<String> printer = System.out::println;

        List<String> words = List.of("cat", "elephant", "dog", "giraffe");

        words.stream()
             .filter(isLong)          // keep words longer than 3 chars
             .map(toLength)           // convert to their lengths
             .forEach(System.out::println);
    }
}
```

---

## 14. Records (Java 14+) — Immutable Data Carriers

`record` auto-generates constructor, `equals()`, `hashCode()`, and `toString()` —
removing boilerplate for simple immutable data classes.

```java
// Instead of writing a 40-line POJO with getters, equals, hashCode, toString...
record Point(int x, int y) {
    // You can still add custom methods or validation
    Point {
        if (x < 0 || y < 0) throw new IllegalArgumentException("Coordinates must be positive");
    }

    double distanceFromOrigin() {
        return Math.sqrt(x * x + y * y);
    }
}

public class RecordDemo {
    public static void main(String[] args) {
        Point p1 = new Point(3, 4);
        Point p2 = new Point(3, 4);

        System.out.println(p1);              // Point[x=3, y=4] - auto toString
        System.out.println(p1.equals(p2));    // true - auto equals
        System.out.println(p1.distanceFromOrigin()); // 5.0
    }
}
```

---

## 15. Pattern Matching for `switch` (Java 17/21+)

Modern `switch` can act as an expression, match types, and destructure sealed hierarchies —
much more powerful than the old fall-through `switch`.

```java
sealed interface Shape permits Circle, Square {}
record Circle(double radius) implements Shape {}
record Square(double side) implements Shape {}

public class SwitchPatternDemo {
    static double area(Shape shape) {
        // switch as an EXPRESSION with pattern matching, no break needed
        return switch (shape) {
            case Circle c -> Math.PI * c.radius() * c.radius();
            case Square s -> s.side() * s.side();
            // no default needed: compiler knows all Shape subtypes (sealed)
        };
    }

    public static void main(String[] args) {
        System.out.println(area(new Circle(2)));
        System.out.println(area(new Square(3)));
    }
}
```

---

## 16. `StringBuilder` vs `String` Concatenation (Performance)

`String` is immutable — every `+` in a loop creates a **new object**, which is O(n²)
for n concatenations. `StringBuilder` mutates an internal buffer — O(n).

```java
public class StringBuilderDemo {
    public static void main(String[] args) {
        // BAD: creates a new String object on every iteration
        String result = "";
        for (int i = 0; i < 5; i++) {
            result += i; // internally: result = new StringBuilder(result).append(i).toString()
        }

        // GOOD: mutable buffer, no repeated object creation
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append(i);
        }
        System.out.println(sb.toString());
    }
}
```

---

## 17. `Optional` — Avoiding `NullPointerException`

`Optional<T>` forces the caller to explicitly handle the "value might be absent" case,
instead of silently risking a `NullPointerException`.

```java
import java.util.Optional;

public class OptionalDemo {
    static Optional<String> findUserById(int id) {
        // Simulate a DB lookup that might not find anything
        return id == 1 ? Optional.of("Alice") : Optional.empty();
    }

    public static void main(String[] args) {
        // Instead of: String user = findUserById(2); if (user == null) {...}
        String name = findUserById(2)
                .map(String::toUpperCase)
                .orElse("UNKNOWN USER"); // fallback if empty, no NPE risk

        System.out.println(name);
    }
}
```

---

## 18. `synchronized` and Thread Safety Basics

`synchronized` ensures only one thread executes a block/method on a given object at a time,
preventing race conditions on shared mutable state.

```java
class Counter {
    private int count = 0;

    // synchronized method: only one thread can execute this at a time per instance
    public synchronized void increment() {
        count++;
    }

    public int getCount() { return count; }
}

public class ThreadSafetyDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) counter.increment();
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start(); t2.start();
        t1.join(); t2.join();

        // Without "synchronized", this would often print less than 2000 due to race conditions
        System.out.println(counter.getCount()); // reliably 2000
    }
}
```

---

## Quick Reference Table

| Concept | Why It Matters |
|---|---|
| Integer caching | `==` fails for boxed values outside -128..127 |
| String pool / intern() | Controls memory & reference equality of Strings |
| equals()/hashCode() contract | Breaks HashMap/HashSet if violated |
| return in finally | Silently overrides try/catch return value |
| try-with-resources | Auto-closes resources safely, in reverse order |
| default/static interface methods | Enables API evolution without breaking implementers |
| PECS (wildcards) | Correct generic API design for read/write collections |
| Enum with abstract methods | Enums can encapsulate per-constant behavior |
| transient / volatile | Control serialization & thread memory visibility |
| Shallow vs deep clone | Prevents shared-reference bugs after "copying" objects |
| Comparable vs Comparator | Natural vs custom sort strategies |
| Checked vs unchecked exceptions | Compile-time enforced vs runtime-only error handling |
| Functional interfaces | Foundation of lambdas & Stream API |
| Records | Boilerplate-free immutable data classes |
| Pattern matching switch | Expression-based, type-safe, exhaustive switch |
| StringBuilder | Avoids O(n²) cost of String concatenation in loops |
| Optional | Explicit, safer handling of "value may be absent" |
| synchronized | Prevents race conditions on shared mutable state |