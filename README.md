"# Employee Management System

Simple, fast, and reliable employee management tool. Store, update, and manage employee records with a clean CLI interface connected to MySQL.

## Quick Start (2 Minutes)

### 1️⃣ Database Setup
First, create the database and table in MySQL:

```sql
CREATE DATABASE employee_db;
USE employee_db;

CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    salary DOUBLE NOT NULL,
    department VARCHAR(50) NOT NULL
);
```

### 2️⃣ Compile & Run
```bash
# Navigate to project folder
cd "Employee Management-System"

# Compile all Java files
javac *.java

# Run the application
java Main
```

That's it! The app will start immediately.

---

## 🎮 What You Can Do

| Operation | Command | Time |
|-----------|---------|------|
| Add Employee | Press `1` | 30 seconds |
| View All Employees | Press `2` | Instant |
| Update Salary | Press `3` | 20 seconds |
| Delete Employee | Press `4` | 20 seconds |
| Exit | Press `5` | Immediate |


---

## 📺 Application Interface

When you run `java Main`, you'll see this:

```
================================================================================
          WELCOME TO EMPLOYEE MANAGEMENT SYSTEM
================================================================================

----------------------------------------
         MAIN MENU
----------------------------------------
  1. Add Employee
  2. View All Employees
  3. Update Salary
  4. Delete Employee
  5. Exit
----------------------------------------
Enter your choice (1-5): 
```

### When You View Employees:
```
================================================================================
ID     | Name                 | Salary       | Department     
================================================================================
1      | John Smith           | 50000.00     | IT              
2      | Sarah Johnson        | 45000.00     | HR              
3      | Mike Williams        | 55000.00     | Sales           
================================================================================
```

---

## 🔧 Step-by-Step Setup

### Prerequisites
- ✅ Java 8 or higher installed
- ✅ MySQL Server running
- ✅ MySQL JDBC driver (mysql-connector-java)

### Installation

**Step 1: Create Database**
```sql
CREATE DATABASE employee_db;
USE employee_db;

CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    salary DOUBLE NOT NULL,
    department VARCHAR(50) NOT NULL
);
```

**Step 2: Check Java Installation**
```bash
java -version
javac -version
```

**Step 3: Compile Project**
```bash
javac DbConnection.java Employee.java EmployeeDAO.java Main.java
```

**Step 4: Run Application**
```bash
java Main
```

---

## 💡 How to Use

### Adding an Employee
```
Enter your choice (1-5): 1

Enter Employee Name: John Smith
Enter Salary: 50000
Enter Department: IT

✓ Employee Added Successfully!
```

### Viewing Employees
```
Enter your choice (1-5): 2

(formatted table appears with all employees)
```

### Updating Salary
```
Enter your choice (1-5): 3

Enter Employee ID to update: 1
Current Details: ID: 1 | Name: John Smith | Salary: 50000.00 | Department: IT
Enter New Salary: 55000

✓ Employee Salary Updated Successfully!
```

### Deleting an Employee
```
Enter your choice (1-5): 4

Enter Employee ID to delete: 1
Employee: ID: 1 | Name: John Smith | Salary: 50000.00 | Department: IT
Are you sure you want to delete this employee? (yes/no): yes

✓ Employee Deleted Successfully!
```

```
├── DbConnection.java    → Connects to MySQL database
├── Employee.java        → Employee data model (stores id, name, salary, dept)
├── EmployeeDAO.java     → Database operations (add, view, update, delete)
├── Main.java            → Application interface & menu
└── README.md            → This file
```

---

## ❌ Common Issues & Fixes

**Error: "Connection refused"**
- Make sure MySQL is running
- Check your username/password in DbConnection.java
- Verify database exists: `SHOW DATABASES;`

**Error: "Class not found: com.mysql.cj.jdbc.Driver"**
- Add MySQL JDBC to classpath or project lib folder
- Download: mysql-connector-java-8.0.x.jar

**Error: "Table 'employee_db.employees' doesn't exist"**
- Run the SQL setup commands from Step 1
- Make sure you're connected to correct database

**Input keeps getting rejected**
- Empty names/departments aren't allowed
- Salary must be a positive number (no negative)
- ID must be a valid integer

---

## 🔒 Security

✓ Uses PreparedStatements (prevents SQL injection)  
✓ Validates all inputs before storing  
✓ Closes database connections properly  
✓ Shows errors without crashing  

---

## 🏗️ Architecture

**DAO Pattern**: Separates database logic from business logic
- `EmployeeDAO` = All database operations
- `Employee` = Data storage
- `Main` = User interface
- `DbConnection` = Connection management

---

## 📝 Database Details

| Column | Type | Notes |
|--------|------|-------|
| id | INT | Auto-increments, primary key |
| name | VARCHAR(100) | Employee name |
| salary | DOUBLE | Salary amount |
| department | VARCHAR(50) | Department name |

---

## 🚀 What Happens When You Add an Employee

```
1. User enters name, salary, department
2. App validates inputs (no empty, salary > 0)
3. EmployeeDAO creates SQL INSERT query
4. PreparedStatement adds data to database
5. Database auto-assigns ID
6. Success message appears
```

---

## 📊 Example Data

After adding some employees, View will show:

```
================================================================================
ID     | Name                 | Salary       | Department     
================================================================================
1      | Alice Cooper         | 60000.00     | Engineering     
2      | Bob Johnson          | 50000.00     | Marketing       
3      | Carol Davis          | 55000.00     | Finance         
================================================================================
```

---

## 💻 System Needs

- Java 8+
- MySQL 5.7+
- MySQL JDBC driver
- ~2MB disk space

---

## 🎯 Next Steps

1. ✅ Set up database
2. ✅ Compile & run
3. ✅ Add test employees
4. ✅ Practice all operations
5. ✅ Use in production

---

## 📞 Need Help?

- Check database is running: `mysql -u root -p`
- Check Java: `java -version`
- Check files compiled: Look for `.class` files
- Read error messages carefully

---

**Version**: 2.0 Professional Edition | Built with Java + MySQL | Last Updated: April 2026" 
