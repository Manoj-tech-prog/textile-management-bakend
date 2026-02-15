# Textile Management Project (Spring Boot)

This is a backend project built using Spring Boot to understand how real-world textile processes can be handled in a software system.

I created this project while learning Spring Boot, JPA, and PostgreSQL.  
The idea is based on how textile batches move through different departments like dyeing, finishing, QC, and dispatch.

---

## Technologies Used
- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven

---

## Project Structure
The project follows a simple layered structure:

Controller – handles API requests  
Service – contains business logic  
Repository – handles database operations  
Entity – maps Java objects to database tables  

---

## What This Project Does
- Create a textile batch
- Store batch details like color, customer, weight, and date
- Auto-generate batch number
- Fetch batch details using batch ID
- Connect Spring Boot with PostgreSQL using JPA

---

## Sample API

### Create Batch
**POST**  
`/api/textile/batch`

Request body:
```json
{
  "color": "White",
  "customer": "Levis",
  "weight": 220
}
