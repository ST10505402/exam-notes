package templates.inheritance;

/**
 * TEMPLATE: subclass (child) - extends, super(...), @Override, super.method().
 */
public class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary, double bonus) {
        super(name, salary);       // MUST be the first line: runs the parent constructor
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    // Override: same name, parameters and return type as the parent
    @Override
    public double calculatePay() {
        return super.calculatePay() + bonus;   // reuse the parent's version
    }

    // Overload (not override): same name, different parameters
    public double calculatePay(double extra) {
        return calculatePay() + extra;
    }
}
