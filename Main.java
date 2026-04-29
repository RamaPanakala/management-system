import java.util.*;

/**
 * Main Application Class for Employee Management System
 * Provides CLI interface for managing employees
 */
public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final EmployeeDAO dao = new EmployeeDAO();

    public static void main(String[] args) {
        displayWelcome();
        
        int choice;
        do {
            displayMenu();
            choice = getValidChoice();

            switch (choice) {
                case 1 -> addEmployeeModule();
                case 2 -> viewEmployeesModule();
                case 3 -> updateEmployeeModule();
                case 4 -> deleteEmployeeModule();
                case 5 -> exitApplication();
                default -> System.out.println("✗ Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private static void displayWelcome() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("          WELCOME TO EMPLOYEE MANAGEMENT SYSTEM");
        System.out.println("=".repeat(80) + "\n");
    }

    private static void displayMenu() {
        System.out.println("\n" + "-".repeat(40));
        System.out.println("         MAIN MENU");
        System.out.println("-".repeat(40));
        System.out.println("  1. Add Employee");
        System.out.println("  2. View All Employees");
        System.out.println("  3. Update Salary");
        System.out.println("  4. Delete Employee");
        System.out.println("  5. Exit");
        System.out.println("-".repeat(40));
        System.out.print("Enter your choice (1-5): ");
    }

    private static int getValidChoice() {
        try {
            int choice = sc.nextInt();
            if (choice < 1 || choice > 5) {
                System.out.println("✗ Please enter a number between 1 and 5.");
                return -1;
            }
            return choice;
        } catch (InputMismatchException e) {
            sc.nextLine();
            System.out.println("✗ Invalid input. Please enter a number.");
            return -1;
        }
    }

    private static void addEmployeeModule() {
        try {
            sc.nextLine();
            
            System.out.print("\nEnter Employee Name: ");
            String name = sc.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("✗ Name cannot be empty.");
                return;
            }

            System.out.print("Enter Salary: ");
            double salary = getValidSalary();
            if (salary < 0) return;

            sc.nextLine();
            System.out.print("Enter Department: ");
            String dept = sc.nextLine().trim();
            if (dept.isEmpty()) {
                System.out.println("✗ Department cannot be empty.");
                return;
            }

            dao.addEmployee(new Employee(0, name, salary, dept));
        } catch (Exception e) {
            System.err.println("✗ Error: " + e.getMessage());
        }
    }

    private static void viewEmployeesModule() {
        try {
            dao.viewEmployees();
        } catch (Exception e) {
            System.err.println("✗ Error: " + e.getMessage());
        }
    }

    private static void updateEmployeeModule() {
        try {
            System.out.print("\nEnter Employee ID to update: ");
            int id = getValidId();
            if (id < 0) return;

            Employee emp = dao.getEmployeeById(id);
            if (emp == null) {
                System.out.println("✗ Employee with ID " + id + " not found.");
                return;
            }

            System.out.println("Current Details: " + emp);
            System.out.print("Enter New Salary: ");
            double salary = getValidSalary();
            if (salary < 0) return;

            dao.updateEmployee(id, salary);
        } catch (Exception e) {
            System.err.println("✗ Error: " + e.getMessage());
        }
    }

    private static void deleteEmployeeModule() {
        try {
            System.out.print("\nEnter Employee ID to delete: ");
            int id = getValidId();
            if (id < 0) return;

            Employee emp = dao.getEmployeeById(id);
            if (emp == null) {
                System.out.println("✗ Employee with ID " + id + " not found.");
                return;
            }

            System.out.println("Employee: " + emp);
            System.out.print("Are you sure you want to delete this employee? (yes/no): ");
            String confirm = sc.nextLine().trim().toLowerCase();
            
            if (confirm.equals("yes") || confirm.equals("y")) {
                dao.deleteEmployee(id);
            } else {
                System.out.println("Deletion cancelled.");
            }
        } catch (Exception e) {
            System.err.println("✗ Error: " + e.getMessage());
        }
    }

    private static int getValidId() {
        try {
            int id = sc.nextInt();
            if (id <= 0) {
                System.out.println("✗ Employee ID must be positive.");
                return -1;
            }
            return id;
        } catch (InputMismatchException e) {
            sc.nextLine();
            System.out.println("✗ Invalid input. Please enter a valid ID.");
            return -1;
        }
    }

    private static double getValidSalary() {
        try {
            double salary = sc.nextDouble();
            if (salary < 0) {
                System.out.println("✗ Salary cannot be negative.");
                return -1;
            }
            return salary;
        } catch (InputMismatchException e) {
            sc.nextLine();
            System.out.println("✗ Invalid input. Please enter a valid salary.");
            return -1;
        }
    }

    private static void exitApplication() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("           Thank you for using Employee Management System!");
        System.out.println("=".repeat(80) + "\n");
        sc.close();
        System.exit(0);
    }
}