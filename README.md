# Library-Management-System-in-Java
A Java-based text-driven Library Management System (LMS) designed to simulate the day-to-day operations of a library, built using core Object-Oriented Programming (OOP) principles. This was developed as a portfolio assignment for the "Introduction to Object-Oriented Programming" module (CFS2104) at the University of Huddersfield.

🚀 Features
👨‍💼 For Staff
Add, edit, and delete books and magazines from the library catalog

Register, edit, or delete members

View all library items

View all current loans

Staff authentication (login/logout)

👤 For Members
View available items

Borrow and return items

View current loans and overdue fees

Member authentication (login/logout)

🧱 Object-Oriented Design
This project demonstrates the four pillars of OOP:

Encapsulation: Classes with private fields and public getters/setters (e.g., Book, Member, Loan)

Inheritance: Common attributes in abstract base classes (LibraryItem, User) extended by subclasses

Abstraction: Abstract classes and interfaces to hide implementation details

Polymorphism: Method overriding in classes like Book and Magazine (e.g., getItemType(), toString())

📊 Data Handling
Operates entirely in memory (no file I/O)

Session data persists until the program is closed

🧪 Testing & Validation
✅ Manual Test Cases
Item and user registration/editing

Borrowing and returning functionality

Overdue fine calculation

⚠️ Edge Cases Tested
Borrowing unavailable items

Duplicate user registration

Invalid logins

Returning items past due date

🔐 Input Validation
Non-empty strings

Date format enforced (YYYY-MM-DD)

Non-negative membership IDs

Try-catch blocks with user-friendly messages

🧩 Technologies Used
Language: Java

Interface: Console/Text-based UI

Development Paradigm: Object-Oriented Programming

🎯 Learning Objectives
Practice of real-world system modeling using Java

Implementation of OOP design patterns

Handling user interaction, system validation, and logical separation of concerns

📁 Project Structure (Sample)
css
Copy
Edit
/src
│── Book.java
│── Magazine.java
│── Member.java
│── Staff.java
│── LibraryItem.java
│── User.java
│── Loan.java
│── LibrarySystem.java
│── InputValidator.java
│── Main.java
🧠 Challenges Faced
Initially used file handling, later replaced with in-memory storage for better performance

Refactored the system to separate staff and member functionality for clarity and maintainability

📌 Conclusion
The Library Management System provides a clean, efficient simulation of a library's operations while reinforcing key OOP principles. Its modular and scalable design makes it suitable for future enhancements like GUI integration or persistent storage.
