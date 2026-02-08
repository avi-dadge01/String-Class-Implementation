# Custom String Class in Java

## 📌 Overview
This project is a **custom implementation of the Java `String` class**, built from scratch to deeply understand how immutable objects, character handling, and string operations work internally in Java.

The class replicates the **core behavior of `java.lang.String`**, implementing almost all important methods with similar functionality and performance considerations.

This project was created for **learning internals of Java**, **strengthening core concepts**, and **interview preparation**.

---

## 🎯 Objectives
- Understand how Java's `String` class works internally
- Learn immutability and memory efficiency
- Practice object-oriented programming
- Implement commonly used string methods manually
- Improve problem-solving and logic-building skills

---

## 🧠 Key Concepts Covered
- Immutability
- Character arrays (`char[]`)
- Method overriding
- Encapsulation
- Deep copy vs shallow copy
- Performance considerations
- Object comparison (`==` vs `.equals()`)

---

## 🔧 Implemented Methods
The custom String class supports most commonly used methods, including:

- `length()`
- `charAt(int index)`
- `substring(int beginIndex)`
- `substring(int beginIndex, int endIndex)`
- `equals(Object obj)`
- `equalsIgnoreCase(String str)`
- `compareTo(String str)`
- `toUpperCase()`
- `toLowerCase()`
- `trim()`
- `contains(String str)`
- `startsWith(String prefix)`
- `endsWith(String suffix)`
- `indexOf(char ch)`
- `lastIndexOf(char ch)`
- `replace(char oldChar, char newChar)`
- `isEmpty()`
- `toCharArray()`
- `valueOf()` (custom version)

> ⚠️ Note: This implementation focuses on **logical behavior**, not internal JVM optimizations like String Pool or UTF compression.

---

## 🧩 Immutability
Just like Java's `String` class:
- Once created, the object **cannot be modified**
- Any operation returns a **new object**
- Internal character array is **never exposed directly**

---

## 📁 Project Structure
