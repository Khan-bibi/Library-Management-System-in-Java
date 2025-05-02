# Library-Management-System-in-Java
A Java-based text-driven Library Management System (LMS) designed to simulate the day-to-day operations of a library, built using core Object-Oriented Programming (OOP) principles. This was developed as a portfolio assignment for the "Introduction to Object-Oriented Programming" module (CFS2104) at the University of Huddersfield.

## Features

### For Staff
- Add, edit, and delete items (Books and Magazines) in the library catalog
- Register, update, or remove library members
- View the entire catalog and current loans
- Login/logout functionality

### For Members
- View available library items
- Borrow and return items
- View current loans and overdue charges
- Login/logout functionality

## Object-Oriented Design Principles

The system implements the four main pillars of object-oriented programming:

### Encapsulation
- Data is kept secure using private access modifiers with appropriate getter and setter methods.
- Classes such as `Book`, `Magazine`, `Member`, and `Loan` demonstrate encapsulation.

### Inheritance
- Shared attributes and methods are moved to parent classes:
  - `LibraryItem` is a parent class for `Book` and `Magazine`
  - `User` is a parent class for `Member` and `Staff`

### Abstraction
- Complex details are hidden using abstract classes and interfaces.
- For example, `LibraryItem` is declared abstract and not used directly.

### Polymorphism
- Method overriding is used to modify behaviors in subclasses.
- Examples include the `getItemType()` and `toString()` methods in `Book` and `Magazine`.

## Data Handling

- The system runs fully in-memory for simplicity and better runtime performance.
- No data is saved to or loaded from external files.
- All session data is lost once the program ends.

## Input Validation and Error Handling

- A separate module handles input validation.
- Validations include:
  - Non-empty strings
  - Proper date format (yyyy-mm-dd)
  - Non-negative numeric inputs
- Try-catch blocks are used to catch input errors and display user-friendly messages.

## Testing Strategy

### Functional Testing
- All features were manually tested for correctness, including:
  - Adding, editing, and removing catalog items
  - Member registration and login
  - Borrowing and returning items
  - Calculation of overdue fees

### Edge Cases
- Attempting to borrow unavailable items
- Registering duplicate users
- Invalid login credentials
- Returning items before and after due dates
- Editing or deleting non-existent users/items

## Challenges and Solutions

- **File Handling**: Initially used file I/O, which was later removed in favor of in-memory data handling.
- **Menu Design**: Staff and member functionalities were separated into distinct menus for better organization.

## Technologies Used

- Programming Language: Java
- Interface Type: Console/Text-based UI
- Programming Paradigm: Object-Oriented Programming (OOP)

## Conclusion

This project successfully simulates a basic library system while implementing key OOP principles. The design is modular and maintainable, with potential for future expansion such as persistent data storage or GUI integration.




