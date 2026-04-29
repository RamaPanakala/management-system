import java.sql.*;
import java.util.*;

/**
 * Data Access Object for Employee
 * Handles all database operations for employees
 */
public class EmployeeDAO {

    /**
     * Add a new employee to the database
     * @param e Employee object to add
     * @throws Exception if database error occurs
     */
    public void addEmployee(Employee e) throws Exception {
        if (e.getName() == null || e.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Employee name cannot be empty");
        }
        if (e.getSalary() < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }

        String query = "INSERT INTO employes(name, salary, department) VALUES (?, ?, ?)";
        
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, e.getName());
            ps.setDouble(2, e.getSalary());
            ps.setString(3, e.getDepartment());
            int result = ps.executeUpdate();
            
            if (result > 0) {
                System.out.println("✓ Employee Added Successfully!");
            }
        } catch (SQLException ex) {
            System.err.println("✗ Error adding employee: " + ex.getMessage());
            throw ex;
        }
    }

    /**
     * Display all employees from the database
     * @throws Exception if database error occurs
     */
    public void viewEmployees() throws Exception {
        String query = "SELECT * FROM employes ORDER BY id";
        
        try (Connection con = DbConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            if (!rs.isBeforeFirst()) {
                System.out.println("\n✗ No employees found in database.\n");
                return;
            }

            System.out.println("\n" + "=".repeat(80));
            System.out.printf("%-6s | %-20s | %-12s | %-15s%n", "ID", "Name", "Salary", "Department");
            System.out.println("=".repeat(80));
            
            while (rs.next()) {
                System.out.printf("%-6d | %-20s | %-12.2f | %-15s%n",
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDouble("salary"),
                    rs.getString("department"));
            }
            System.out.println("=".repeat(80) + "\n");
        } catch (SQLException ex) {
            System.err.println("✗ Error retrieving employees: " + ex.getMessage());
            throw ex;
        }
    }

    /**
     * Update employee salary
     * @param id Employee ID
     * @param salary New salary
     * @throws Exception if database error occurs
     */
    public void updateEmployee(int id, double salary) throws Exception {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid employee ID");
        }
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }

        String query = "UPDATE employes SET salary=? WHERE id=?";
        
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setDouble(1, salary);
            ps.setInt(2, id);
            int result = ps.executeUpdate();
            
            if (result > 0) {
                System.out.println("✓ Employee Salary Updated Successfully!");
            } else {
                System.out.println("✗ Employee ID not found.");
            }
        } catch (SQLException ex) {
            System.err.println("✗ Error updating employee: " + ex.getMessage());
            throw ex;
        }
    }

    /**
     * Delete an employee from the database
     * @param id Employee ID to delete
     * @throws Exception if database error occurs
     */
    public void deleteEmployee(int id) throws Exception {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid employee ID");
        }

        String query = "DELETE FROM employes WHERE id=?";
        
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            int result = ps.executeUpdate();
            
            if (result > 0) {
                System.out.println("✓ Employee Deleted Successfully!");
            } else {
                System.out.println("✗ Employee ID not found.");
            }
        } catch (SQLException ex) {
            System.err.println("✗ Error deleting employee: " + ex.getMessage());
            throw ex;
        }
    }

    /**
     * Search for employee by ID
     * @param id Employee ID
     * @return Employee object or null if not found
     */
    public Employee getEmployeeById(int id) throws Exception {
        String query = "SELECT * FROM employes WHERE id=?";
        
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("salary"),
                        rs.getString("department")
                    );
                }
            }
        } catch (SQLException ex) {
            System.err.println("✗ Error searching employee: " + ex.getMessage());
            throw ex;
        }
        return null;
    }
}