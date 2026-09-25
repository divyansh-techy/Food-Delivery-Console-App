# Food Delivery Console App

A console-based food delivery application developed using **Java, JDBC, and MySQL**. The application allows users to view food items, place orders, manage order information, and maintain order history through a menu-driven console interface.

## 📌 About the Project

The Food Delivery Console App is a Java-based mini project created to practice backend development concepts using a real-world food ordering scenario.

The application connects Java with a MySQL database using **JDBC** to store and retrieve food menu and order-related information.

Users can view available food items, select items, place orders, and access their order history through the console application.

## 🚀 Features

- Display Food Menu
- View Available Food Items
- Check Food Item Availability
- Select Food Items
- Place Orders
- Store Order Information
- View Order History
- MySQL Database Integration
- JDBC Database Connectivity
- Input Validation
- Menu-Driven Console Interface

## 🛠️ Technologies Used

- Java
- JDBC
- MySQL
- Object-Oriented Programming
- ArrayList
- Eclipse IDE
- Git & GitHub

## 🏗️ Application Structure

The application is organized into different components for handling menu items, orders, database operations, and console interaction.

### Model

Contains classes representing application data such as menu items and orders.

### Service

Handles application logic such as displaying menu items and processing orders.

### Database

MySQL is used to store menu and order-related information.

### Console View

Provides the menu-driven interface through which users interact with the application.

## 🗄️ Database

The application uses **MySQL** as its relational database and connects to it through JDBC.

The database contains information required for:

- Food menu items
- Item availability
- Orders
- Order history

The SQL script for creating the required database and tables is available in:

```text id="8vv5hl"
database/
└── food_delivery.sql
```

## 📂 Project Structure

```text id="m3a3pi"
Food-Delivery-Console-App/
│
├── src/
│   └── Java source files
│
├── database/
│   └── food_delivery.sql
│
├── README.md
└── .gitignore
```

## ▶️ How to Run

### 1. Clone the Repository

Clone or download this repository to your local system.

### 2. Open the Project

Open the project in **Eclipse IDE**.

### 3. Configure MySQL

Install and start MySQL.

Create the required database and tables by executing the SQL script:

```text id="k1z4hr"
database/food_delivery.sql
```

### 4. Configure JDBC Connection

Update the JDBC connection details in the Java project with your own MySQL username, password, and database configuration.

Do not commit personal database credentials to GitHub.

### 5. Add MySQL JDBC Driver

Make sure the **MySQL Connector/J** driver is added to the project's classpath.

### 6. Run the Application

Run the main Java class and follow the options displayed in the console.

## 📚 Concepts Practiced

- Java OOP
- Classes and Objects
- Constructors
- Encapsulation
- Inheritance
- Polymorphism
- ArrayList
- JDBC
- MySQL
- SQL Queries
- PreparedStatement
- ResultSet
- CRUD Operations
- Database Connectivity
- Input Validation
- Exception Handling
- Service-based Application Structure

## 🎯 Learning Outcome

This project provided practical experience in developing a Java console application connected to a relational database.

Through this project, I practiced **JDBC database connectivity, SQL operations, object-oriented programming, menu management, order processing, and retrieving data from MySQL**.

## 👨‍💻 Author

**Divyansh Upadhyay**

GitHub: https://github.com/divyansh-techy
