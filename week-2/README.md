# Week 2 - Library Management System

## Overview

This project is developed as part of the Week 2 Java Application Development task.

The application is a basic command-line Library Management System that allows users to manage a collection of books using CRUD operations.

The application stores book data in memory using Java's `ArrayList` collection.

---

## Objectives

The main objectives of this application are:

- Implement core Java programming concepts.
- Create a Book entity using a Java class.
- Use Java Collections for in-memory data storage.
- Implement CRUD operations.
- Create a menu-driven command-line interface.
- Implement input validation.
- Handle invalid user input and exceptions.
- Follow clean and readable Java coding practices.
- Provide proper comments and documentation.

---

## Features

The application provides the following features:

### 1. Add Book

Users can add a new book by entering:

- Book title
- Author name
- ISBN
- Publication year

The application also checks whether the ISBN already exists before adding the book.

### 2. List All Books

Users can view all books currently stored in the library.

If there are no books available, the application displays an appropriate message.

### 3. Update Book

Users can update an existing book by providing its ISBN.

The following information can be updated:

- Book title
- Author
- Publication year

### 4. Delete Book

Users can delete an existing book using its ISBN.

The application asks for confirmation before deleting the book.

### 5. Exit

Users can safely exit the application using the Exit option.

---

## CRUD Operations

| Operation | Function | Description |
|-----------|----------|-------------|
| Create | Add Book | Adds a new book |
| Read | List Books | Displays all books |
| Update | Update Book | Updates existing book details |
| Delete | Delete Book | Removes a book |

---

## Technology Used

- Java
- Java Collections
- ArrayList
- Scanner
- Exception Handling
- Command-Line Interface (CLI)

---

## Project Structure

```text
week-2/
│
├── src/
│   ├── Book.java
│   └── LibraryApp.java
│
└── README.md

Book.java
Contains the Book entity and its properties:
- Title
- Author
- ISBN
- Publication Year
LibraryApp.java
Contains the main application logic, menu system, CRUD operations, input validation, and exception handling.
Data Storage
The application uses Java's ArrayList to store books in memory.
ArrayList<Book> books = new ArrayList<>();

No external database is used in this version.
Therefore, the book data will be available only while the application is running.
Input Validation
The application validates user input to prevent invalid data.
Examples include:
- Empty book title is not allowed.
- Empty author name is not allowed.
- Empty ISBN is not allowed.
- Publication year must be a positive number.
- Invalid menu selections are handled.
- Duplicate ISBNs are prevented.
- Non-existing books are handled properly.
Exception Handling
The application handles invalid numeric input using exception handling.
For example, if the user enters text instead of a number, the application displays an error message instead of terminating unexpectedly.
Example:
Invalid input. Please enter a number.

Requirements
To run this application, you need:
- Java Development Kit (JDK) 8 or later
- Command Prompt / Terminal
- VS Code or any Java-compatible IDE
You can verify Java installation using:
java -version

and:
javac -version

How to Compile
Open the terminal inside the week-2/src directory.
Run:
javac Book.java LibraryApp.java

If there are no compilation errors, the application has been successfully compiled.
How to Run
After compilation, run:
java LibraryApp

Application Menu
The application displays the following menu:
======================================
      LIBRARY MANAGEMENT SYSTEM
======================================

--------------------------------------
              MAIN MENU
--------------------------------------
1. Add Book
2. List All Books
3. Update Book
4. Delete Book
5. Exit
--------------------------------------

Sample Usage
Add Book
Enter your choice: 1

========== ADD BOOK ==========

Enter book title: Java Programming
Enter author name: James Gosling
Enter ISBN: 123456
Enter publication year: 2024

Book added successfully!

List Books
Enter your choice: 2

========== BOOK LIST ==========

Book #1
------------------------------
Title: Java Programming
Author: James Gosling
ISBN: 123456
Publication Year: 2024

Total books: 1

Update Book
Enter your choice: 3

Enter ISBN of the book to update: 123456

Book updated successfully!

Delete Book
Enter your choice: 4

Enter ISBN of the book to delete: 123456

Are you sure you want to delete this book? (Y/N): Y

Book deleted successfully!

Learning Outcomes
Through this project, the following Java concepts were practiced:
- Classes and Objects
- Encapsulation
- Constructors
- Getters and Setters
- ArrayList
- Loops
- Conditional Statements
- Switch Statements
- Methods
- Exception Handling
- Input Validation
- CRUD Operations
- Command-Line Application Development
Future Improvements
The application can be extended in future versions with:
- Database integration
- REST API
- User authentication
- Book search functionality
- Book categories
- Book borrowing and return management
- Persistent data storage
- Graphical User Interface (GUI)

Author
Developed as part of the Java Application Development practical task.
Week 2 - Core Functionality Implementation
Then structure:
week-2/
├── src/
│   ├── Book.java
│   └── LibraryApp.java
│
└── README.md