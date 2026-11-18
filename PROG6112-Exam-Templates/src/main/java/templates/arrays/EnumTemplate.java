package templates.arrays;

/**
 * TEMPLATE: enums - a fixed set of named constants, with values(), ordinal(),
 * valueOf(), name(), compareTo(), switch, and an enum with its own field.
 */
public class EnumTemplate {

    enum Month { JAN, FEB, MAR }

    // Enum with a field + constructor + getter
    enum WashType {
        BASIC(80.0), FULL(150.0), VALET(300.0);

        private final double price;

        WashType(double price) {
            this.price = price;
        }

        public double getPrice() {
            return price;
        }
    }

    public static void main(String[] args) {
        for (Month m : Month.values()) {                  // every constant, in order
            System.out.println(m + " ordinal=" + m.ordinal());
        }

        Month chosen = Month.valueOf("FEB");              // String -> enum (exact spelling)
        System.out.println(chosen.name() + " vs MAR: " + chosen.compareTo(Month.MAR));

        switch (chosen) {
            case JAN:
                System.out.println("First month");
                break;
            case FEB:
                System.out.println("Second month");
                break;
            default:
                System.out.println("Other month");
        }

        System.out.println("Valet costs R" + WashType.VALET.getPrice());
    }
}
