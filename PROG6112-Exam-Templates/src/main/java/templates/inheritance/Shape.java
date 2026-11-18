package templates.inheritance;

/**
 * TEMPLATE: abstract class - cannot be instantiated; subclasses must implement abstract methods.
 */
public abstract class Shape {
    private final String label;

    public Shape(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    // No body: every concrete subclass must provide one
    public abstract double area();

    // Normal method that uses the abstract one (dynamic binding picks the right area())
    public String describe() {
        return String.format("%s with area %.2f", label, area());
    }
}
