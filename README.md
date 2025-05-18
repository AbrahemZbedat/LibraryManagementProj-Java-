# 📚 Library Management System

This project is a Java-based Library Management System that allows efficient management of different types of books using collections. The system enables users to perform actions such as adding, deleting, and updating books, as well as sorting and displaying book data in tables, with many other useful features.

---

## 🚀 Main Features

- Add, delete, and update books based on user input
- Manage various book types: regular books, children's books, and electronic books
- Sort books by title, author, number of pages, etc.
- Display book data in a table format
- Read from and write to text files
- Separate class for managing book prices
- Uses core OOP principles such as inheritance, polymorphism, interfaces, and abstract classes

---

## 🧱 Class Structure

| Class Name         | Description |
|--------------------|-------------|
| `Books`            | The base class that defines a book, including title, code, author name, and number of pages |
| `ChildrenBook`     | Inherits from `Books`, adds a new property: target age |
| `ElectronicBook`   | Inherits from `Books`, adds properties such as tax and genre |
| `BookPrice`        | A helper class for managing and organizing book prices |
| `BookDataFile`     | Responsible for reading and writing book data to/from files |
| `Library`          | Manages the book and price collections using a `List`; includes methods for searching, adding, deleting, updating books, and file operations |
| `PreBooks`         | An abstract class defining empty methods that must be implemented by its subclasses |

---

## 💡 Interfaces

| Interface Name     | Description |
|--------------------|-------------|
| `BookContract`     | Defines methods such as search by name/code, add book, delete book; implemented by `Books` class |
| `Comparable`       | Used to compare and sort books based on user choice (e.g., title, author, page count); implemented by `Books`, `ChildrenBook`, and `ElectronicBook` |

---

## 🔄 Comparator

| Comparator Name     | Description |
|---------------------|-------------|
| `SortingLibrary`    | A structured comparator system with sub-classes for various sorting options chosen by the user (e.g., by title, pages, author) |

---

## 🧬 Inheritance

- `Books` is the base (parent) class for both `ChildrenBook` and `ElectronicBook`.
- These subclasses inherit common properties and methods, and extend them with their own custom attributes.

---

## 🔁 Polymorphism Example

- The `Books` class defines a method called `update()`.
- Both `ChildrenBook` and `ElectronicBook` override the `update()` method with their own implementations.
- This allows handling different book types uniformly using polymorphism.

---

## 🧩 Abstract Classes

- The `PreBooks` class is an abstract base class that includes method definitions without implementations.
- All subclasses inheriting from `PreBooks` must implement its methods.

---

## 📂 File Handling

The system supports reading from and writing to text files via the `BookDataFile` class, enabling persistent storage and retrieval of the library collection.

---

## 📌 Technologies Used

- Java
- Object-Oriented Programming (OOP)
- Collections (`List`)
- File I/O
- Interfaces and Abstract Classes
- Comparators

---

## 📝 Author

This project was developed as part of a library management solution using Java OOP principles, designed for flexibility, maintainability, and scalability.

---


