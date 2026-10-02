# Design Patterns

## 1. Introduction

Design patterns are reusable solutions to common software design problems.

For the Inventory Management System, suitable design patterns are selected to improve code organization, maintainability, flexibility, and scalability.

The planned design patterns are:

1. MVC Pattern
2. Singleton Pattern
3. Factory Pattern

---

## 2. MVC Pattern

MVC stands for:

- Model
- View
- Controller

The MVC pattern separates the user interface, application data, and request handling responsibilities.

### Structure

```text
User
  ↓
Controller
  ↓
Model
  ↓
Database

Model
The Model represents application data and business entities.
Examples:
- Product
- Order
- OrderItem
- Supplier
View
The View is responsible for displaying information to the user.
Examples:
- Product screen
- Order screen
- Stock screen
- Report screen
Controller
The Controller receives user requests and communicates with the appropriate service.
Examples:
- ProductController
- OrderController
- ReportController
Why MVC?
MVC provides separation of responsibilities and makes the application easier to maintain and modify.
3. Singleton Pattern
The Singleton pattern ensures that only one instance of a particular class is created during the application lifecycle.
In this project, it can be used for managing a shared database connection manager or application configuration.
Example
public class DatabaseConnection {

    private static DatabaseConnection instance;

    private DatabaseConnection() {
    }

    public static DatabaseConnection getInstance() {

        if (instance == null) {
            instance = new DatabaseConnection();
        }

        return instance;
    }
}

Usage
DatabaseConnection connection =
        DatabaseConnection.getInstance();

Why Singleton?
It provides a centralized way to manage shared resources.
However, actual database connection pooling may be preferred in a production system because creating and managing raw connections through a Singleton can introduce resource-management issues.
4. Factory Pattern
The Factory pattern provides a centralized method for creating objects without requiring the calling code to know the exact implementation class.
In this project, the Factory pattern can be used for creating different types of reports.
Report Types
                ReportFactory
                     │
          ┌──────────┼──────────┐
          ↓          ↓          ↓
     SalesReport  StockReport  OrderReport

Example
interface Report {
    void generate();
}

class SalesReport implements Report {

    @Override
    public void generate() {
        System.out.println("Generating Sales Report");
    }
}

class StockReport implements Report {

    @Override
    public void generate() {
        System.out.println("Generating Stock Report");
    }
}

class ReportFactory {

    public static Report createReport(String type) {

        if (type.equalsIgnoreCase("sales")) {
            return new SalesReport();
        }

        if (type.equalsIgnoreCase("stock")) {
            return new StockReport();
        }

        return null;
    }
}

Usage
Report report = ReportFactory.createReport("sales");
report.generate();

Why Factory?
The Factory pattern makes object creation centralized and makes it easier to add new report types in the future.
5. Pattern Interaction
The selected patterns can work together within the application.
User
 ↓
Controller
 ↓
Service
 ↓
Factory
 ↓
Report Object
 ↓
Repository
 ↓
Database

For example, when the user requests a sales report:
User
 ↓
ReportController
 ↓
ReportService
 ↓
ReportFactory
 ↓
SalesReport
 ↓
Sales Data Repository
 ↓
MySQL

6. Benefits of Using Design Patterns
The selected patterns provide the following benefits:
Maintainability
The code is organized into clearly defined responsibilities.
Reusability
Common design solutions can be reused throughout the application.
Flexibility
New features can be added with fewer changes to existing components.
Scalability
The architecture can support additional modules as the application grows.
Separation of Responsibilities
Different components focus on different tasks.
7. Design Pattern Selection Rationale
MVC
Selected to separate user interaction from application data and request handling.
Singleton
Selected as a possible approach for managing shared application-level resources such as configuration or a connection manager.
Factory
Selected to simplify creation of different report types and support future report extensions.
8. Future Design Improvements
As the application grows, additional patterns may be considered.
Possible future patterns include:
- Repository Pattern
- Strategy Pattern
- Observer Pattern
- Builder Pattern
These patterns will only be introduced when they provide a clear benefit to the application's design.
9. Conclusion
The selected design patterns provide a structured approach for implementing the Inventory Management System.
MVC supports separation of responsibilities, Singleton can help manage shared application resources, and Factory simplifies the creation of different report objects.
Together with the layered architecture, these patterns provide a maintainable foundation for the planned Java application.