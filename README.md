# Library Management System (Java)

A console-based Library Management System built in Java as a Programming 1 course project. It lets users manage a library's books: adding, searching, issuing, returning, deleting, and editing book records using parallel arrays for storage.

## Overview

The program stores book titles, descriptions, and availability statuses in arrays. On startup, the user specifies how many books the library can hold, then interacts with a numbered menu to perform operations. Each book is identified by an auto-assigned ID based on its position in the library.

## Features

1. **Add a Book**: Add a new book with a title and description (if space is available).
2. **Search for a Book**: Search by title or ID and view title, description, and availability.
3. **Issue a Book**: Mark a book as issued (unavailable) by its ID.
4. **Return a Book**: Mark an issued book as available again by its ID.
5. **Delete a Book**: Remove a book by ID and shift remaining books to fill the gap.
6. **Edit Book Details**: Update a book's title and/or description by ID.
7. **View All Books**: List every book with its details and availability status.
8. **Exit**: Close the program.

## Tech Stack

- **Language:** Java
- **Concepts:** Arrays, loops, conditionals, `switch` statements, `Scanner` for input, basic input validation

## Getting Started

### Prerequisites
- Java JDK 8 or higher installed (`java -version` to check)

### Compile & Run

Since this is a single-file program, you can compile and run it directly from your terminal:

```bash
# 1. Compile the Java file
javac LibraryManagementSystem.java

# 2. Run the compiled program
java LibraryManagementSystem
