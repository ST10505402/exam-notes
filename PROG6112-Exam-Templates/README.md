# PROG6112 Exam Templates

Reusable Java templates for the PROG6112 (Programming 1B) open-book exam.
Every class compiles, every template and memo with a `main` method runs, and all 64 unit tests pass.

This is a **Maven** project: in NetBeans choose **File > Open Project** and select this folder (the one with `pom.xml`). NetBeans downloads JUnit 5 automatically the first time, so open it once **before** the exam, while you have internet.

## Code templates (`src/main/java/templates/`)

| File | Use it for |
| --- | --- |
| `arrays/SortingTemplate.java` | Bubble sort (ascending, descending, Strings), sorting parallel arrays together, insertion sort, `Arrays.sort` |
| `arrays/TwoDArrayTemplate.java` | 2D + parallel arrays: declare, populate, print as a table, row / column / grand totals, average, highest / lowest with position, top performer, count over a limit, search, passing to methods |
| `arrays/ArrayListTemplate.java` | ArrayList of Strings, Integers and objects: add / get / set / remove / sort / max / min |
| `arrays/EnumTemplate.java` | `values()`, `ordinal()`, `valueOf()`, `switch`, enum with a field |
| `interfaces/IProductSales.java` | Interface template |
| `interfaces/ProductSales.java` | Class implementing the interface (total, average, max, min, row total, top item, count over limit) |
| `interfaces/ProductSalesReport.java` | Complete Question 1 console report using the interface |
| `inheritance/Employee.java` | Superclass: private / protected fields, getters, setter validation, `final` and `static` methods, `toString`, `equals` |
| `inheritance/Manager.java` | Subclass: `extends`, `super(...)`, `@Override`, `super.method()`, overloading |
| `inheritance/Shape.java`, `Circle.java`, `Rectangle.java` | Abstract class + concrete subclasses |
| `inheritance/InheritanceDemo.java` | Dynamic binding, array of subclass objects, `instanceof` + cast |
| `exceptions/ExceptionTemplate.java` | try / catch / finally, multiple catches, `throws`, `throw`, call stack, `assert` |
| `exceptions/InvalidInputException.java` | Custom exception |
| `files/FileTemplate.java` | Write, append, read line by line, split CSV, read whole file, random access file |

## GUI templates (JFrames and menus) (`src/main/java/templates/gui/`)

| File | Use it for |
| --- | --- |
| `MovieTicketForm.java` | **2023 to 2025 style Question 2**: combo box, text fields, check box, read-only text area, status label, buttons, File/Tools menu, process + validate, save to file, load from file, clear |
| `TicketData.java`, `IMovieTickets.java`, `MovieTickets.java` | Data class + interface + logic class (calculation and `ValidateData`) used by the form |
| `TravelForm.java` | **2022 style**: combo boxes, "start and end can't be the same" error, maximum 5 entries in an array, append to `travel.txt`, load the file into a `JList` |
| `SwingComponentsTemplate.java` | Every LU6 topic in one JFrame: extending JFrame, `ActionListener` + `getSource()`, JLabel font/colour, JTextField, JTextArea, JComboBox, JCheckBox, JRadioButton + ButtonGroup, JList + DefaultListModel, BorderLayout / FlowLayout / GridLayout, JPanels with colours and titled borders, JScrollPane, tooltips, menus with submenu, separator, JCheckBoxMenuItem, mnemonics (Alt+F) and shortcuts (Ctrl+N), mouse events with MouseAdapter, and message, confirm and input dialogs |

**Using the NetBeans GUI builder instead of hand-coding?** Drag on the same controls, rename them to the variable names used in these templates (right-click > Change Variable Name), create an `actionPerformed` handler for each button and menu item, and make each handler call one helper method. Copy the helper methods (`processReport`, `saveReport`, `loadReport`, `clearForm`, ...) into the form's Source view, outside the grey generated code.

## Exam memos (`src/main/java/memos/`, tests in `src/test/java/memos/`)

Full model answers, each matching the paper's sample output exactly. Every class, interface and test name is copied from the paper.

| Package | Paper | Run this | Output / files |
| --- | --- | --- | --- |
| `memos.exam2024.q1` | 2024 Q1: movie tickets report | `MovieTicketReport` | Napoleon 6200, Oppenheimer 6300, top movie Oppenheimer |
| `memos.exam2024.q2` | 2024 Q2: movie tickets GUI (14% VAT) | `MovieTicketForm` | 3 x R100 = R 342.0; saves `report.txt` |
| `memos.exam2025.q1` | 2025 Q1: product sales report (`IProduct`) | `ProductSalesReport` | Total 2200, average 367, max 700, min 150 |
| `memos.exam2025.q2` | 2025 Q2: product sales GUI (limit 500) | `ProductSalesForm` | 2200 / 367 / over 2 / under 4 / 2 years; saves `data.txt` |
| `memos.practice2026.q1` | Practice 2026 Q1: Harbourlight Theatre | `TheatreSalesReport` | Total 2640, average 330, high 450, low 180 |
| `memos.practice2026.q2` | Practice 2026 Q2: Southcoast Surf Co. (target 400) | `SurfSalesForm` | 3150 / 350 / over 3 / under 6 / 3 years; saves `sales_log.txt` |
| `memos.mock1.q1` | Mock exam Q1: Willow Court water usage | `WaterUsageReport` | Totals 52 / 74 / 40, highest 20 kl, lowest Unit 3 |
| `memos.mock1.q2` | Mock exam Q2: Kasi Shine Car Wash | `CarWashForm` | Full x3 + tyre shine = R 472.50; appends `bookings.txt`, loads it back |
| `memos.mock2.q2` | Mock Question 2: Vaal Tech Expo registration | `RegistrationForm` | Student 2 days + workshop = R 160.00; character limits, live counter, validation, `registrations.txt` with a thank-you pop-up showing the path |

**How to use them in the exam:** each question is its own NetBeans project there, with one simple package. Copy the interface, the classes and the test file into your project, change the `package` line to your project's package, and rebuild the form with the GUI builder using the same variable names. Then copy the helper methods (`loadData`, `saveData`, `processReport`, `clearForm`, ...) into the form's Source view and call them from your handlers.

**Watch out (2024 Q2):** `3 * 100 * 1.14` is `341.99999999999994` in Java, so the memo rounds with `Math.round(total * 100) / 100.0` to print `R 342.0` like the sample.

## Unit tests (`src/test/java/templates/`)

| File | Shows how to test |
| --- | --- |
| `interfaces/ProductSalesTest.java` | ints, doubles with a tolerance, Strings, `assertNotEquals` |
| `gui/MovieTicketsTest.java` | A calculation, plus validation with `assertTrue` / `assertFalse` |
| `arrays/SortingTemplateTest.java` | Methods that change an array: `assertArrayEquals`; parallel arrays; overloaded methods |
| `inheritance/InheritanceTest.java` | Overridden methods, dynamic binding, abstract classes, `equals` / `toString`, `assertThrows` |
| `exceptions/ExceptionTemplateTest.java` | `assertThrows` for custom and built-in exceptions, checking the message |
| `files/FileTemplateTest.java` | File code with a temporary file |

Run all tests: right-click the project > **Test**, or `mvn test`. Run one class: right-click it > **Test File**.

## Running the templates

Right-click any file with a `main` method > **Run File**. Text files (`travel.txt`, `report.txt`) are created in the project folder.

## Using the code in an Ant project (`src/` + `test/`)

Copy `src/main/java/templates` into `src/`, and `src/test/java/templates` into `test/`. Then right-click a class > **Tools > Create/Update Tests** once so NetBeans adds JUnit. If NetBeans adds **JUnit 4**, change the two import lines at the top of each test file to the JUnit 4 versions shown in its comment.

## Exam reminders

- Copy the paper's interface **exactly**, including its capitalised method names, and name each test exactly as the paper's table.
- Buttons and menu items call the **same** helper method. That earns the code-efficiency marks.
- Comment every class and method, and rename GUI controls (`txtName`, not `jTextField1`).
- `(double) total / count` for averages; `assertEquals(expected, actual, 0.01)` for doubles.
- Use the VAT / commission rate the paper gives (the template uses 15%).
- Retype and adapt the code rather than pasting it unchanged, and follow the paper's instructions on disclosing AI tools.
