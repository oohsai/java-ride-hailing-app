# java-ride-hailing-app

### 🏗️ Project Structure
```text
ride-hailing-mvp
├── src/main/java
│   └── com.rideapp
│       └── model
│           ├── User.java
│           └── Ride.java
├── src/main/resources
│   └── META-INF
│       └── persistence.xml
├── src/main/webapp
│   ├── index.jsp
│   └── WEB-INF
└── pom.xml
```

### 🗄️ Database Setup

This project uses *Hibernate (JPA)* to connect to a MySQL database.

To configure the database connection, you must update the `persistence.xml` file with your local database credentials.

1.  **Locate the Configuration File:**
    Navigate to `src/main/resources/META-INF/persistence.xml`.

2.  **Update Credentials:**
    Find the following property line and replace `db-password` with your actual MySQL root password:
    ```xml
    <property name="javax.persistence.jdbc.password" value="YOUR_ACTUAL_PASSWORD"/>
    ```
    *(Note: Ensure your database user is `root` or update the `javax.persistence.jdbc.user` property accordingly.)*

3.  **Database Creation:**
    Ensure you have created a schema named `ride_hailing_db` in your MySQL server before running the application:
    ```sql
    CREATE DATABASE ride_hailing_db;
    ```

4.  **Auto-Generation:**
    The project is configured with `hibernate.hbm2ddl.auto` set to `update`. This means Hibernate will automatically create or update the necessary tables in your database when you run the application.

### 🚀 Domain Layer (Entities)
Mapped Java classes to database tables:
- **User.java**: Handles user information and roles (`rider`/`driver`).
- **Ride.java**: Manages ride details, locations, and status.