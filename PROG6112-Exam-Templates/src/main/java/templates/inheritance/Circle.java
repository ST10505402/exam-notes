package templates.inheritance;

/**
 * TEMPLATE: concrete subclass of an abstract class.
 */
public class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}
