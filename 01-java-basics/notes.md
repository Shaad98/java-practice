# Java Basics

This folder contains the fundamental concepts of Java programming with examples.

---

# Topics Covered

## 1. Primitive Data Types

| Type | Size | Example |
|------|------|---------|
| byte | 1 Byte | 100 |
| short | 2 Bytes | 20000 |
| int | 4 Bytes | 500000 |
| long | 8 Bytes | 100000000L |
| float | 4 Bytes | 12.5f |
| double | 8 Bytes | 12.567 |
| char | 2 Bytes | 'A' |
| boolean | JVM Dependent | true |

---

## String

String is a non-primitive data type used to store text.

```java
String name = "Shaad";
```

---

# Taking Input

Java mainly provides two ways to take input.

## 1. Scanner

Used for competitive programming and beginners.

```java
Scanner sc = new Scanner(System.in);
```

### Common Methods

```java
nextInt()
nextFloat()
nextDouble()
nextLong()
nextShort()
nextByte()
next()
nextLine()
```

### Reading Character

```java
char ch = sc.next().charAt(0);
```

### Important

Whenever you call

```java
nextLine()
```

after

```java
nextInt()
```

remember to clear the buffer.

```java
sc.nextLine();
```

---

## 2. BufferedReader

Faster than Scanner.

```java
BufferedReader br =
new BufferedReader(new InputStreamReader(System.in));
```

### Reading Values

```java
String value = br.readLine();

int number = Integer.parseInt(value);
float decimal = Float.parseFloat(value);
double d = Double.parseDouble(value);
long l = Long.parseLong(value);
```

### Reading Character

```java
char ch = (char) br.read();
```

After reading a character

```java
br.read();
```

or

```java
br.readLine();
```

may be required to consume the remaining newline.

---

# Methods

A method is a reusable block of code.

```java
public static int add(int a, int b)
```

---

# Varargs

Allows a method to accept multiple arguments.

```java
public static int sumAll(int... numbers)
```

Example

```java
sumAll(10,20);
sumAll(10,20,30,40);
```

---

# Method Overloading

Multiple methods can have the same name if their parameter list differs.

Valid

```java
greet()

greet(String name)

greet(String name, int age)
```

Invalid

```java
void greet(String name)

String greet(String name)
```

Return type alone **cannot** overload a method.

---

# Interview Notes

- `Scanner` is easier but slower.
- `BufferedReader` is faster.
- `next()` reads one word.
- `nextLine()` reads an entire line.
- Always clear the buffer after `nextInt()` before calling `nextLine()`.
- Varargs internally behave like an array.
- Return type is **not** considered in method overloading.