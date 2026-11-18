package templates.inheritance;

/**
 * TEMPLATE: using the classes - instantiate, override in action,
 * dynamic method binding, array of subclass objects, instanceof + cast.
 */
public class InheritanceDemo {

    public static void main(String[] args) {
        Employee clerk = new Employee("Thabo", 18000);
        Manager boss = new Manager("Lerato", 25000, 5000);

        System.out.println(clerk);                 // toString() is called automatically
        System.out.println(boss);                  // uses Manager's calculatePay()
        System.out.println("With extra: " + boss.calculatePay(1000));   // overloaded version
        System.out.println(boss.companyName() + " / " + Employee.category());

        // Dynamic method binding: variable type Employee, object type Manager
        Employee someone = new Manager("Sipho", 20000, 2000);
        System.out.println("Dynamic binding pay: " + someone.calculatePay());

        // Array of superclass type holding different subclass objects
        Employee[] staff = {clerk, boss, someone};
        double payroll = 0;
        for (Employee e : staff) {
            payroll += e.calculatePay();
            if (e instanceof Manager) {            // check before casting
                Manager m = (Manager) e;
                System.out.println(m.getName() + " bonus: " + m.getBonus());
            }
        }
        System.out.printf("Total payroll: R %.2f%n", payroll);

        // Abstract class + polymorphism
        Shape[] shapes = {new Circle(1), new Rectangle(2, 3)};
        for (Shape s : shapes) {
            System.out.println(s.describe());
        }

        // equals() override
        System.out.println("Same employee? " + clerk.equals(new Employee("Thabo", 1)));
    }
}
