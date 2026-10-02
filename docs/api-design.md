API Design

1. Introduction

The Inventory Management System provides APIs for communication between the client application and the backend application.

The APIs are designed to handle:

- Product management
- Supplier management
- Customer management
- Order management
- Stock management
- User authentication
- Report generation

The API layer follows a RESTful architecture.

---

2. API Architecture

The API follows the following request flow:

Client
  ↓
REST API
  ↓
Controller
  ↓
Service
  ↓
Repository / DAO
  ↓
MySQL Database

The Controller receives HTTP requests and sends appropriate responses to the client.

The Service layer contains business logic.

The Repository / DAO layer communicates with the MySQL database.

---

3. API Base URL

The planned base URL is:

/api

Examples:

/api/products
/api/suppliers
/api/customers
/api/orders
/api/stock
/api/users
/api/reports

The final URL structure may change depending on the deployment environment.

---

4. HTTP Methods

The API uses standard HTTP methods.

Method| Purpose
GET| Retrieve data
POST| Create new data
PUT| Update existing data
DELETE| Delete data

---

5. Product APIs

5.1 Get All Products

Endpoint

GET /api/products

Description

Retrieves all products available in the inventory.

Response

{
  "success": true,
  "data": [
    {
      "productId": 1,
      "productName": "Laptop",
      "category": "Electronics",
      "price": 55000.00,
      "supplierId": 101
    }
  ]
}

---

5.2 Get Product by ID

Endpoint

GET /api/products/{id}

Example

GET /api/products/1

Response

{
  "success": true,
  "data": {
    "productId": 1,
    "productName": "Laptop",
    "category": "Electronics",
    "price": 55000.00,
    "supplierId": 101
  }
}

---

5.3 Create Product

Endpoint

POST /api/products

Request Body

{
  "productName": "Laptop",
  "category": "Electronics",
  "price": 55000.00,
  "supplierId": 101
}

Response

{
  "success": true,
  "message": "Product created successfully"
}

---

5.4 Update Product

Endpoint

PUT /api/products/{id}

Example

PUT /api/products/1

Request Body

{
  "productName": "Gaming Laptop",
  "category": "Electronics",
  "price": 65000.00,
  "supplierId": 101
}

Response

{
  "success": true,
  "message": "Product updated successfully"
}

---

5.5 Delete Product

Endpoint

DELETE /api/products/{id}

Example

DELETE /api/products/1

Response

{
  "success": true,
  "message": "Product deleted successfully"
}

---

6. Supplier APIs

6.1 Get All Suppliers

GET /api/suppliers

Description

Retrieves all registered suppliers.

---

6.2 Get Supplier by ID

GET /api/suppliers/{id}

---

6.3 Create Supplier

POST /api/suppliers

Request Body

{
  "supplierName": "ABC Suppliers",
  "phone": "9876543210",
  "email": "abc@example.com",
  "address": "Tiruppur"
}

---

6.4 Update Supplier

PUT /api/suppliers/{id}

---

6.5 Delete Supplier

DELETE /api/suppliers/{id}

---

7. Customer APIs

7.1 Get All Customers

GET /api/customers

---

7.2 Get Customer by ID

GET /api/customers/{id}

---

7.3 Create Customer

POST /api/customers

Request Body

{
  "customerName": "Dhanuska",
  "phone": "9876543210",
  "email": "customer@example.com",
  "address": "Tiruppur"
}

---

7.4 Update Customer

PUT /api/customers/{id}

---

7.5 Delete Customer

DELETE /api/customers/{id}

---

8. Order APIs

8.1 Get All Orders

GET /api/orders

Description

Retrieves all customer orders.

---

8.2 Get Order by ID

GET /api/orders/{id}

---

8.3 Create Order

POST /api/orders

Request Body

{
  "customerId": 1,
  "items": [
    {
      "productId": 10,
      "quantity": 2
    },
    {
      "productId": 15,
      "quantity": 1
    }
  ]
}

Response

{
  "success": true,
  "message": "Order created successfully",
  "orderId": 1001
}

---

8.4 Update Order Status

Endpoint

PUT /api/orders/{id}/status

Request Body

{
  "status": "Confirmed"
}

Possible Status Values

Pending
Confirmed
Completed
Cancelled

---

8.5 Delete Order

DELETE /api/orders/{id}

---

9. Stock APIs

9.1 Get Stock

GET /api/stock

Description

Retrieves the current stock information for all products.

---

9.2 Get Stock by Product

GET /api/stock/product/{productId}

---

9.3 Update Stock

PUT /api/stock/product/{productId}

Request Body

{
  "quantity": 100
}

---

9.4 Low Stock Products

GET /api/stock/low-stock

Description

Returns products whose available quantity is at or below the configured reorder level.

Example Response

{
  "success": true,
  "data": [
    {
      "productId": 10,
      "productName": "Keyboard",
      "quantity": 5,
      "reorderLevel": 10
    }
  ]
}

---

10. User Authentication APIs

10.1 User Login

Endpoint

POST /api/auth/login

Request Body

{
  "username": "admin",
  "password": "password"
}

Response

{
  "success": true,
  "message": "Login successful",
  "role": "ADMIN"
}

In the actual application, authentication credentials should be securely handled and passwords should never be stored as plain text.

---

10.2 User Registration

Endpoint

POST /api/auth/register

Request Body

{
  "username": "staff01",
  "password": "password",
  "role": "STAFF"
}

---

11. Report APIs

11.1 Sales Report

GET /api/reports/sales

Description

Generates sales-related information.

---

11.2 Stock Report

GET /api/reports/stock

Description

Generates the current inventory stock report.

---

11.3 Order Report

GET /api/reports/orders

Description

Generates information about customer orders.

---

12. HTTP Status Codes

The API uses standard HTTP status codes.

Status Code| Meaning
200| Request successful
201| Resource created successfully
400| Bad request
401| Unauthorized
403| Forbidden
404| Resource not found
409| Conflict
500| Internal server error

---

13. Standard API Response Format

The API should follow a consistent response structure.

Successful Response

{
  "success": true,
  "message": "Operation completed successfully",
  "data": {}
}

Error Response

{
  "success": false,
  "message": "Requested resource not found",
  "errorCode": "RESOURCE_NOT_FOUND"
}

Consistent responses make the API easier for frontend applications and other clients to consume.

---

14. Error Handling

The API should provide meaningful error messages when an operation fails.

Common errors include:

- Invalid request data
- Missing required fields
- Product not found
- Supplier not found
- Customer not found
- Insufficient stock
- Duplicate username
- Unauthorized access
- Database connection failure

Example:

{
  "success": false,
  "message": "Insufficient stock for the requested product",
  "errorCode": "INSUFFICIENT_STOCK"
}

---

15. Validation

Input validation should be performed before processing requests.

Examples:

Product

- Product name must not be empty.
- Price must be greater than zero.
- Supplier ID must be valid.

Customer

- Customer name must not be empty.
- Email should follow a valid format.
- Phone number should contain a valid number of digits.

Order

- Customer ID must exist.
- Product ID must exist.
- Quantity must be greater than zero.
- Requested quantity must not exceed available stock.

---

16. API Security

The API should implement appropriate security measures.

Important security practices include:

- Authentication
- Authorization
- Password hashing
- Input validation
- SQL injection prevention
- Secure session/token management
- Role-based access control

Database queries should use parameterized statements or prepared statements instead of directly concatenating user input into SQL queries.

---

17. Role-Based API Access

Different application roles may have different permissions.

Operation| ADMIN| MANAGER| STAFF
View Products| Yes| Yes| Yes
Add Product| Yes| Yes| Yes
Update Product| Yes| Yes| Yes
Delete Product| Yes| No| No
View Reports| Yes| Yes| Limited
Manage Users| Yes| No| No
Manage Stock| Yes| Yes| Yes
Manage Orders| Yes| Yes| Yes

The final permissions may be adjusted according to the application's business requirements.

---

18. API Request Flow

For a product creation request:

Client
   ↓
POST /api/products
   ↓
ProductController
   ↓
ProductService
   ↓
ProductRepository
   ↓
JDBC
   ↓
MySQL
   ↓
Response
   ↓
Client

---

19. API Documentation Example

A complete API endpoint can be documented as follows:

Create Product

Method:

POST

Endpoint:

/api/products

Request:

{
  "productName": "Keyboard",
  "category": "Electronics",
  "price": 1200.00,
  "supplierId": 101
}

Success Response:

{
  "success": true,
  "message": "Product created successfully"
}

Status Code:

201 Created

---

20. Future API Improvements

The API can be extended in future versions with:

- Pagination
- Search and filtering
- Sorting
- API versioning
- JWT-based authentication
- OpenAPI / Swagger documentation
- Rate limiting
- Audit logging
- Advanced reporting APIs
- Notification APIs

These features can be introduced based on the application's requirements.

---

21. Conclusion

The API design provides a structured communication layer between the client application and the Inventory Management System backend.

RESTful endpoints are planned for products, suppliers, customers, orders, stock, users, and reports.

The API follows standard HTTP methods, status codes, validation rules, response formats, and security practices.

Together with the MVC architecture, service layer, repository layer, and MySQL database, the API design provides a clear foundation for implementing the application's backend services.