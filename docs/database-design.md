Database Design

1. Introduction

The Inventory Management System uses a relational database to store and manage products, suppliers, customers, orders, order items, stock information, and application data.

MySQL is planned as the database management system.

The database design focuses on:

- Data consistency
- Data integrity
- Reduced data duplication
- Easy data retrieval
- Relationship management
- Scalability

---

2. Database Technology

Component| Technology
Database| MySQL
Database Type| Relational Database
Query Language| SQL
Application Language| Java
Database Connectivity| JDBC

---

3. Main Database Tables

The planned database contains the following major tables:

1. Product
2. Supplier
3. Customer
4. Orders
5. OrderItem
6. Stock
7. User

---

4. Product Table

The Product table stores information about products available in the inventory.

Attributes

Column| Data Type| Constraint| Description
product_id| INT| PRIMARY KEY| Unique product identifier
product_name| VARCHAR(100)| NOT NULL| Name of the product
category| VARCHAR(50)| NOT NULL| Product category
price| DECIMAL(10,2)| NOT NULL| Product price
supplier_id| INT| FOREIGN KEY| Supplier of the product
created_at| TIMESTAMP| DEFAULT CURRENT_TIMESTAMP| Product creation time

---

5. Supplier Table

The Supplier table stores supplier information.

Attributes

Column| Data Type| Constraint| Description
supplier_id| INT| PRIMARY KEY| Unique supplier identifier
supplier_name| VARCHAR(100)| NOT NULL| Name of supplier
phone| VARCHAR(15)| NOT NULL| Supplier contact number
email| VARCHAR(100)| UNIQUE| Supplier email
address| VARCHAR(255)| -| Supplier address

---

6. Customer Table

The Customer table stores information about customers.

Attributes

Column| Data Type| Constraint| Description
customer_id| INT| PRIMARY KEY| Unique customer identifier
customer_name| VARCHAR(100)| NOT NULL| Customer name
phone| VARCHAR(15)| -| Customer phone number
email| VARCHAR(100)| UNIQUE| Customer email
address| VARCHAR(255)| -| Customer address

---

7. Orders Table

The Orders table stores information about customer orders.

Attributes

Column| Data Type| Constraint| Description
order_id| INT| PRIMARY KEY| Unique order identifier
customer_id| INT| FOREIGN KEY| Customer who placed the order
order_date| TIMESTAMP| DEFAULT CURRENT_TIMESTAMP| Date and time of order
total_amount| DECIMAL(10,2)| NOT NULL| Total order amount
status| VARCHAR(30)| NOT NULL| Current order status

Possible Order Status

- Pending
- Confirmed
- Completed
- Cancelled

---

8. OrderItem Table

The OrderItem table stores individual products included in an order.

Attributes

Column| Data Type| Constraint| Description
order_item_id| INT| PRIMARY KEY| Unique order item identifier
order_id| INT| FOREIGN KEY| Related order
product_id| INT| FOREIGN KEY| Ordered product
quantity| INT| NOT NULL| Quantity ordered
unit_price| DECIMAL(10,2)| NOT NULL| Price of one unit

The OrderItem table resolves the many-to-many relationship between Orders and Products.

---

9. Stock Table

The Stock table stores the current inventory quantity of each product.

Attributes

Column| Data Type| Constraint| Description
stock_id| INT| PRIMARY KEY| Unique stock identifier
product_id| INT| FOREIGN KEY| Related product
quantity| INT| NOT NULL| Available stock quantity
reorder_level| INT| NOT NULL| Minimum stock level
last_updated| TIMESTAMP| DEFAULT CURRENT_TIMESTAMP| Last stock update time

---

10. User Table

The User table stores application login information.

Attributes

Column| Data Type| Constraint| Description
user_id| INT| PRIMARY KEY| Unique user identifier
username| VARCHAR(50)| UNIQUE| Login username
password| VARCHAR(255)| NOT NULL| Stored password/hash
role| VARCHAR(30)| NOT NULL| User role

Possible Roles

- ADMIN
- STAFF
- MANAGER

Passwords should be securely hashed in the actual application rather than storing plain-text passwords.

---

11. Entity Relationships

The major relationships between the tables are:

Supplier → Product

One supplier can provide multiple products.

Supplier
    │
    │ 1
    │
    │
    │ N
    ↓
Product

Customer → Orders

One customer can place multiple orders.

Customer
    │
    │ 1
    │
    │ N
    ↓
Orders

Orders → OrderItem

One order can contain multiple order items.

Orders
    │
    │ 1
    │
    │ N
    ↓
OrderItem

Product → OrderItem

One product can appear in multiple order items.

Product
    │
    │ 1
    │
    │ N
    ↓
OrderItem

Product → Stock

Each product has corresponding stock information.

Product
    │
    │ 1
    │
    │ 1
    ↓
Stock

---

12. Entity Relationship Diagram

                    ┌─────────────────┐
                    │    Supplier     │
                    ├─────────────────┤
                    │ supplier_id PK  │
                    │ supplier_name   │
                    │ phone           │
                    │ email           │
                    │ address         │
                    └────────┬────────┘
                             │
                             │ 1 : N
                             ↓
                    ┌─────────────────┐
                    │     Product     │
                    ├─────────────────┤
                    │ product_id PK   │
                    │ product_name    │
                    │ category        │
                    │ price           │
                    │ supplier_id FK  │
                    └───────┬─────────┘
                            │
                 ┌──────────┴──────────┐
                 │                     │
                1:1                   1:N
                 │                     │
                 ↓                     ↓
        ┌─────────────────┐   ┌─────────────────┐
        │      Stock      │   │   OrderItem     │
        ├─────────────────┤   ├─────────────────┤
        │ stock_id PK     │   │ order_item_id PK│
        │ product_id FK   │   │ order_id FK     │
        │ quantity        │   │ product_id FK   │
        │ reorder_level   │   │ quantity        │
        └─────────────────┘   │ unit_price      │
                              └────────┬────────┘
                                       │
                                      N:1
                                       │
                                       ↓
                              ┌─────────────────┐
                              │     Orders      │
                              ├─────────────────┤
                              │ order_id PK     │
                              │ customer_id FK  │
                              │ order_date      │
                              │ total_amount    │
                              │ status          │
                              └────────┬────────┘
                                       │
                                      N:1
                                       │
                                       ↓
                              ┌─────────────────┐
                              │    Customer     │
                              ├─────────────────┤
                              │ customer_id PK  │
                              │ customer_name   │
                              │ phone           │
                              │ email           │
                              │ address         │
                              └─────────────────┘

---

13. Primary Keys

Primary keys uniquely identify each record in a table.

The primary keys are:

Table| Primary Key
Product| product_id
Supplier| supplier_id
Customer| customer_id
Orders| order_id
OrderItem| order_item_id
Stock| stock_id
User| user_id

---

14. Foreign Keys

Foreign keys establish relationships between tables.

Table| Foreign Key| References
Product| supplier_id| Supplier(supplier_id)
Orders| customer_id| Customer(customer_id)
OrderItem| order_id| Orders(order_id)
OrderItem| product_id| Product(product_id)
Stock| product_id| Product(product_id)

---

15. Database Normalization

The database design follows normalization principles to reduce data duplication and improve data consistency.

First Normal Form (1NF)

Each table contains atomic values and each column stores a single type of information.

Second Normal Form (2NF)

The tables are designed so that non-key attributes depend on the complete primary key.

Third Normal Form (3NF)

Non-key attributes depend only on the primary key and not on other non-key attributes.

Normalization helps prevent:

- Duplicate data
- Update anomalies
- Insert anomalies
- Delete anomalies

---

16. Sample SQL Table Creation

Supplier Table

CREATE TABLE Supplier (
    supplier_id INT PRIMARY KEY AUTO_INCREMENT,
    supplier_name VARCHAR(100) NOT NULL,
    phone VARCHAR(15) NOT NULL,
    email VARCHAR(100) UNIQUE,
    address VARCHAR(255)
);

Product Table

CREATE TABLE Product (
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(100) NOT NULL,
    category VARCHAR(50) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    supplier_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (supplier_id)
        REFERENCES Supplier(supplier_id)
);

Customer Table

CREATE TABLE Customer (
    customer_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_name VARCHAR(100) NOT NULL,
    phone VARCHAR(15),
    email VARCHAR(100) UNIQUE,
    address VARCHAR(255)
);

Orders Table

CREATE TABLE Orders (
    order_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total_amount DECIMAL(10,2) NOT NULL,
    status VARCHAR(30) NOT NULL,

    FOREIGN KEY (customer_id)
        REFERENCES Customer(customer_id)
);

OrderItem Table

CREATE TABLE OrderItem (
    order_item_id INT PRIMARY KEY AUTO_INCREMENT,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    unit_price DECIMAL(10,2) NOT NULL,

    FOREIGN KEY (order_id)
        REFERENCES Orders(order_id),

    FOREIGN KEY (product_id)
        REFERENCES Product(product_id)
);

Stock Table

CREATE TABLE Stock (
    stock_id INT PRIMARY KEY AUTO_INCREMENT,
    product_id INT UNIQUE NOT NULL,
    quantity INT NOT NULL,
    reorder_level INT NOT NULL,
    last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,

    FOREIGN KEY (product_id)
        REFERENCES Product(product_id)
);

User Table

CREATE TABLE User (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(30) NOT NULL
);

---

17. Important Database Constraints

The database uses different constraints to maintain data integrity.

PRIMARY KEY

Uniquely identifies each record.

FOREIGN KEY

Maintains relationships between tables.

NOT NULL

Prevents required fields from containing empty values.

UNIQUE

Prevents duplicate values in selected columns.

DEFAULT

Automatically assigns a value when no value is provided.

---

18. Database Flow

The application interacts with the database through the Java application layer.

User
 ↓
Controller
 ↓
Service
 ↓
Repository / DAO
 ↓
JDBC
 ↓
MySQL Database

The Repository or DAO layer is responsible for executing SQL queries and communicating with MySQL.

---

19. Data Flow Example

When a new product is added:

User
 ↓
ProductController
 ↓
ProductService
 ↓
ProductRepository
 ↓
JDBC
 ↓
Product Table
 ↓
MySQL

When a customer places an order:

Customer
 ↓
OrderController
 ↓
OrderService
 ↓
OrderRepository
 ↓
Orders + OrderItem
 ↓
Stock Update
 ↓
MySQL

---

20. Future Database Improvements

As the application grows, the database may be extended with additional tables such as:

- Payment
- Purchase
- PurchaseItem
- StockTransaction
- Category
- AuditLog
- Role
- Permission

Indexes may also be added to frequently searched columns to improve query performance.

Database backup, recovery, transaction management, and access control can also be implemented for production environments.

---

21. Conclusion

The database design provides a structured relational model for the Inventory Management System.

The main entities are Product, Supplier, Customer, Orders, OrderItem, Stock, and User.

Primary keys uniquely identify records, while foreign keys establish relationships between related entities.

The planned MySQL database works together with the Java application through JDBC and the Repository/DAO layer.

This database structure provides a strong foundation for implementing the inventory management features in the next development phase.