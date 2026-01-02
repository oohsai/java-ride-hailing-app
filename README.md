# java-ride-hailing-app

### 🏗️ Project Structure

ride-hailing-mvp
├── src/main/java
│   └── com.rideapp
│       ├── model
│       │   ├── User.java
│       │   └── Ride.java
│       │
│       └── dao
│           ├── UserDAO.java
│           ├── RideDAO.java
│           └── JPAUtil.java
│
├── src/main/resources
│   └── META-INF
│       └── persistence.xml
│
├── src/main/webapp
│   ├── index.jsp
│   └── WEB-INF
│
└── pom.xml

---

### 🗄️ Database Setup

Uses Hibernate (JPA) with MySQL for persistence.

Create database:
CREATE DATABASE ride_hailing_db;

Configure credentials in:
src/main/resources/META-INF/persistence.xml

Set:
- jdbc.user → MySQL username
- jdbc.password → MySQL password
- hibernate.hbm2ddl.auto → update

---

### 🚀 Domain Layer (Entities)

User.java  
- Represents application users with rider/driver roles  

Ride.java  
- Represents ride details including locations and status  

---

### 🗂️ DAO Layer (Data Access)

UserDAO.java  
- Handles user-related database operations  

RideDAO.java  
- Handles ride-related database operations  

JPAUtil.java  
- Manages EntityManagerFactory and EntityManager lifecycle  

---

### 🧠 Architecture

JSP / Servlets  
↓  
DAO Layer  
↓  
Hibernate (JPA)  
↓  
MySQL  

---

### ✅ Current Features

- User persistence
- Ride persistence
- DAO-based data access
- Automatic schema updates via Hibernate