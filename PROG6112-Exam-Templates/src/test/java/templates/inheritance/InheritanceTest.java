package templates.inheritance;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
// JUnit 4 project instead: import org.junit.Test; import static org.junit.Assert.*;

/**
 * TEMPLATE: testing inheritance - overridden methods, dynamic binding,
 * abstract classes, equals/toString, and exceptions with assertThrows.
 */
public class InheritanceTest {

    @Test
    public void Manager_CalculatePay_AddsBonus() {
        Manager m = new Manager("Lerato", 25000, 5000);
        assertEquals(30000.0, m.calculatePay(), 0.01);
    }

    @Test
    public void DynamicBinding_UsesSubclassMethod() {
        Employee e = new Manager("Sipho", 20000, 2000);   // superclass variable
        assertEquals(22000.0, e.calculatePay(), 0.01);
    }

    @Test
    public void Manager_IsAnEmployee() {
        Employee e = new Manager("Sipho", 20000, 2000);
        assertTrue(e instanceof Manager);
        assertEquals("Sipho", e.getName());                // inherited method
    }

    @Test
    public void Rectangle_Area_IsWidthTimesHeight() {
        Shape s = new Rectangle(2, 3);
        assertEquals(6.0, s.area(), 0.001);
    }

    @Test
    public void Employee_Equals_ComparesByName() {
        assertEquals(new Employee("Thabo", 100), new Employee("Thabo", 999));
        assertNotEquals(new Employee("Thabo", 100), new Employee("Lerato", 100));
    }

    @Test
    public void Employee_ToString_FormatsPay() {
        assertEquals("Thabo earns R 18000.00", new Employee("Thabo", 18000).toString());
    }

    @Test
    public void SetSalary_Negative_ThrowsException() {
        Employee e = new Employee("Thabo", 18000);
        assertThrows(IllegalArgumentException.class, () -> e.setSalary(-1));
    }
}
