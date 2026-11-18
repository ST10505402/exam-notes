package templates.inheritance;

/**
 * TEMPLATE: superclass (parent).
 * private fields + getters/setters = information hiding.
 */
public class Employee {
    private String name;          // only Employee can access directly
    protected double salary;      // subclasses can access directly

    // Constructor
    public Employee(String name, double salary) {
        this.name = name;
        setSalary(salary);        // reuse validation
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    // Setter with validation (information hiding protects the data)
    public void setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
        this.salary = salary;
    }

    // Will be overridden by subclasses
    public double calculatePay() {
        return salary;
    }

    // final: subclasses can NOT override this
    public final String companyName() {
        return "Acme (Pty) Ltd";
    }

    // static: belongs to the class; can be hidden but not overridden
    public static String category() {
        return "Staff";
    }

    // Overrides Object.toString(): used by println(employee)
    @Override
    public String toString() {
        return String.format("%s earns R %.2f", name, calculatePay());
    }

    // Overrides Object.equals(): compare by content
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Employee e = (Employee) other;
        return name.equals(e.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
