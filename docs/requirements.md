# System Requirements

## 1. Introduction

The Inventory Management System is designed to help small retail businesses manage their products, stock, customer orders, and reports through a centralized Java application.

The system aims to reduce manual work and improve the accuracy of inventory-related operations.

---

## 2. Functional Requirements

### 2.1 Product Management

The system shall allow the user to:

- Add a new product
- Update product details
- Delete a product
- Search for a product
- View product details
- Manage product categories
- Store product price and quantity

### 2.2 Stock Control

The system shall:

- Track current stock quantity
- Add new incoming stock
- Reduce stock when products are sold
- Display available stock
- Identify low-stock products
- Prevent orders when sufficient stock is unavailable

### 2.3 Order Processing

The system shall allow the user to:

- Create a new order
- Add products to an order
- Specify product quantities
- Check product availability
- Calculate the total order amount
- Update stock after an order
- Store order information

### 2.4 Reporting

The system shall generate:

- Product reports
- Current stock reports
- Low-stock reports
- Order reports
- Sales reports

---

## 3. Non-Functional Requirements

### 3.1 Performance

The system should respond quickly to common operations such as product search, stock updates, and order creation.

### 3.2 Security

Only authorized users should be allowed to modify product, stock, and order information.

### 3.3 Reliability

The system should maintain accurate inventory information and prevent inconsistent stock updates.

### 3.4 Maintainability

The application should have a modular architecture so that individual modules can be modified without affecting the entire system.

### 3.5 Scalability

The architecture should allow future features such as barcode scanning, online ordering, payment integration, and analytics to be added.

---

## 4. User Roles

### Admin

The administrator can:

- Add and manage products
- Update stock
- View orders
- Generate reports
- Monitor low-stock products

### Staff/User

Staff users can:

- Search products
- Create orders
- Check stock availability
- View order information

---

## 5. Business Rules

1. Each product must have a unique product ID.
2. Product quantity cannot be negative.
3. An order can only be created when sufficient stock is available.
4. Stock must be reduced after a successful order.
5. Product price must be greater than zero.
6. Deleted products should not be available for new orders.
7. Low-stock products should be identified based on a predefined minimum stock level.

---

## 6. Technology Requirements

The planned technologies are:

- Java for application development
- MySQL for data storage
- JDBC for database connectivity
- Object-Oriented Programming principles
- Layered Architecture for system organization

---

## 7. Conclusion

The identified requirements provide the foundation for designing and implementing a practical Inventory Management System for a small retail business. The requirements will guide the architecture, database design, Java classes, and future development phases.