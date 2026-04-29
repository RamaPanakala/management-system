/**
 * Employee Model Class
 * Represents an employee with ID, name, salary, and department
 */
public class Employee {
    private int id;
    private String name;
    private double salary;
    private String department;

    /**
     * Constructor for Employee
     * @param id Employee ID
     * @param name Employee Name
     * @param salary Employee Salary
     * @param department Employee Department
     */
    public Employee(int id, String name, double salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    public String getDepartment() { return department; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSalary(double salary) { this.salary = salary; }
    public void setDepartment(String department) { this.department = department; }

    @Override
    public String toString() {
        return String.format("ID: %-5d | Name: %-20s | Salary: %-10.2f | Department: %-15s", 
                id, name, salary, department);
    }
}