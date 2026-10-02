# System Architecture Design

## 1. Overview

The Inventory Management System follows a layered architecture to separate user interaction, business logic, data access, and data storage.

The architecture is designed to make the application easier to understand, maintain, test, and extend.

The main layers are:

1. Presentation Layer
2. Service Layer
3. Repository / DAO Layer
4. Database Layer

---

## 2. High-Level Architecture

```text
                    ┌───────────────────────┐
                    │      Admin / User     │
                    └───────────┬───────────┘
                                │
                                ▼
                    ┌───────────────────────┐
                    │   Presentation Layer  │
                    │                       │
                    │ Product Controller    │
                    │ Order Controller      │
                    │ Report Controller     │
                    └───────────┬───────────┘
                                │
                                ▼
                    ┌───────────────────────┐
                    │     Service Layer     │
                    │                       │
                    │ Product Service       │
                    │ Stock Service         │
                    │ Order Service         │
                    │ Report Service        │
                    └───────────┬───────────┘
                                │
                                ▼
                    ┌───────────────────────┐
                    │ Repository / DAO      │
                    │                       │
                    │ Product Repository    │
                    │ Stock Repository      │
                    │ Order Repository      │
                    └───────────┬───────────┘
                                │
                                ▼
                    ┌───────────────────────┐
                    │       MySQL DB        │
                    │                       │
                    │ Product               │
                    │ Supplier              │
                    │ Order                 │
                    │ OrderItem             │
                    └───────────────────────┘

                    Presentation Layer
3.The Presentation Layer is responsible for interacting with the user.
It receives user requests and sends them to the appropriate service.
Main components include:
- ProductController
- OrderController
- ReportController
For example, when an administrator wants to add a product, the ProductController receives the request and passes it to the ProductService.
The presentation layer should not directly communicate with the database.

4. Service Layer
The Service Layer contains the main business logic of the application.
Main services include:
ProductService
Responsible for:
- Adding products
- Updating products
- Deleting products
- Searching products
- Validating product information
StockService
Responsible for:
- Adding stock
- Reducing stock
- Checking stock availability
- Identifying low-stock products
OrderService
Responsible for:
- Creating orders
- Validating product availability
- Calculating order totals
- Updating stock after successful orders
ReportService
Responsible for:
- Generating stock reports
- Generating sales reports
- Generating order reports
- Generating low-stock reports

5. Repository / DAO Layer
The Repository or DAO layer is responsible for communication between the Java application and the database.
Main repositories include:
- ProductRepository
- StockRepository
- OrderRepository
The repository layer performs operations such as:
- Insert
- Update
- Delete
- Select
- Search
This layer keeps database-related code separate from business logic.

6. Database Layer
MySQL is planned as the database management system.
The main database tables are:
Product
Stores product information.
Fields:
- product_id
- name
- category
- price
- quantity
- supplier_id
Supplier
Stores supplier information.
Fields:
- supplier_id
- name
- phone
- email
Order
Stores order information.
Fields:
- order_id
- order_date
- total_amount
- status
OrderItem
Stores individual products included in an order.
Fields:
- order_item_id
- order_id
- product_id
- quantity
- price

7. Module Interaction
The basic request flow is:
User
  ↓
Controller
  ↓
Service
  ↓
Repository
  ↓
Database

Each layer has a specific responsibility.
This separation prevents one component from handling all application operations.

8. Product Management Flow
When an administrator adds a product:
Admin
  ↓
ProductController
  ↓
ProductService
  ↓
Validate Product
  ↓
ProductRepository
  ↓
MySQL

The ProductService validates the product information before passing it to the repository.

9. Order Processing Flow
When a customer places an order:
Customer
    ↓
OrderController
    ↓
OrderService
    ↓
Check Product Stock
    ↓
Stock Available?
   /        \
 YES         NO
  ↓           ↓
Create       Return
Order        "Out of Stock"
  ↓
Calculate Total
  ↓
Update Stock
  ↓
Save Order
  ↓
Generate Order Summary

This process ensures that stock is checked before an order is confirmed.

10. Architectural Principles
The design follows important software architecture principles.
Separation of Concerns
Each layer performs a specific responsibility.
Single Responsibility
A class should focus on one major responsibility.
Loose Coupling
The modules should depend on abstractions where possible rather than directly depending on implementation details.
High Cohesion
Related functionality should be grouped within the same module.
Maintainability
The modular structure makes future modifications easier.

11. Advantages of the Proposed Architecture
The layered architecture provides several advantages:
- Easy to understand
- Easy to maintain
- Easier testing
- Clear separation of responsibilities
- Database logic is isolated
- Business logic can be modified independently
- New modules can be added easily
- Suitable for a small retail application

12. Future Scalability
The architecture can be extended with additional modules such as:
- Authentication
- Barcode Management
- Supplier Management
- Payment Processing
- Online Ordering
- Notification Service
- Analytics Dashboard
- AI-based Stock Prediction
These features can be added without completely redesigning the existing system.

13. Conclusion
The proposed layered architecture provides a structured foundation for implementing the Inventory Management System in Java.
By separating presentation, business logic, data access, and database responsibilities, the system becomes easier to develop, test, maintain, and extend.
The architecture will serve as the foundation for the next phase of the project, which is Java implementation and MySQL database integration.