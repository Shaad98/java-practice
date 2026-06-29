# Java Control Statements, Loops, Arrays & Strings

This example demonstrates Java conditional statements, loops, arrays, jagged arrays, enhanced for loop, and commonly used String methods.

---

# Topics Covered

- if
- if-else
- if-else ladder
- switch
- Enhanced switch
- for loop
- while loop
- do-while loop
- Arrays
- Jagged Arrays
- Enhanced for loop
- String methods

---

# Conditional Statements

## if-else

```java
if(condition){
    // code
}
else{
    // code
}
```

---

## if-else ladder

```java
if(){

}
else if(){

}
else{

}
```

Used when multiple conditions need to be checked.

---

# Switch Statement

Traditional switch statement requires `break`.

```java
switch(value){

    case 1:
        break;

    default:
        break;
}
```

---

# Enhanced Switch

Available in Java 14+.

```java
switch(value){

    case 1 -> System.out.println("One");

    case 2 -> System.out.println("Two");

    default -> System.out.println("Other");
}
```

No need to write `break`.

---

# Loops

## For Loop

```java
for(int i=0;i<10;i++){

}
```

---

## While Loop

```java
while(condition){

}
```

---

## Do While Loop

```java
do{

}while(condition);
```

Executes at least once.

---

# Arrays

Declaration

```java
int[] arr = {1,2,3,4,5};
```

Another way

```java
int[] arr = new int[5];
```

---

# Enhanced For Loop

```java
for(int value : arr){
    System.out.println(value);
}
```

---

# Jagged Array

A jagged array is a two-dimensional array where each row can have a different number of columns.

```java
int[][] jaggedArray = {
    {1,2,3},
    {4,5},
    {6,7,8,9},
    {10}
};
```

Output

```
1 2 3
4 5
6 7 8 9
10
```

---

# String Methods

```java
toUpperCase()
toLowerCase()
toCharArray()
charAt()
indexOf()
lastIndexOf()
startsWith()
endsWith()
```

Examples

```java
name.toUpperCase();

name.toLowerCase();

name.charAt(3);

name.indexOf("a");

name.lastIndexOf("a");

name.indexOf("a",5);

name.indexOf("a",5,7);

name.lastIndexOf("a",5);

name.startsWith("S");

name.endsWith(".");
```

---

# Important Notes

- Traditional switch requires `break`.
- Enhanced switch does not require `break`.
- `do-while` executes at least once.
- Enhanced for loop is mainly used for traversing arrays and collections.
- Jagged arrays allow different numbers of columns in each row.
- `indexOf()` returns `-1` when the value is not found.
- `indexOf(String str, int beginIndex, int endIndex)` searches within the specified range.
- `startsWith()` and `endsWith()` return a boolean value.