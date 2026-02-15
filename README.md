# Textile Management System – Backend

A Spring Boot REST API for managing textile production processes such as batch creation, dyeing status, finishing, and dispatch tracking.

This project is designed based on real textile industry workflow and follows clean layered architecture.

---

## 🚀 Tech Stack
- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven

---

## 🏗 Architecture
The application follows **layered architecture**:

Controller  
→ Service  
→ Repository  
→ Database  

This ensures separation of concerns, maintainability, and scalability.

---

## ✨ Features
- Create textile batch
- Store batch details (color, customer, weight, date)
- Auto-generated batch number
- Fetch batch details by ID
- RESTful APIs
- ORM using Hibernate (no manual SQL)

---

## 📦 Entity Example
Textile batch contains:
- Batch Number (Primary Key)
- Color
- Customer
- Weight
- Date & Time

---

## 🔗 API Endpoints

### Create a batch
**POST**
